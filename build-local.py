#!/usr/bin/env python3
"""Build and check limessh locally or in CI using the checked-in Gradle wrapper."""

import argparse
import os
from pathlib import Path
import re
import shutil
import subprocess
import sys


ROOT = Path(__file__).resolve().parent
# Android Gradle Plugin 8.7.3's default, unless buildToolsVersion is set.
DEFAULT_BUILD_TOOLS = "34.0.0"


def fail(message):
    raise RuntimeError(message)


def property_value(path, key):
    """Read a standard Android Studio Java-properties entry, including escapes."""
    if not path.is_file():
        return None
    result = None
    for line in path.read_text(encoding="utf-8").splitlines():
        match = re.match(r"^\s*" + re.escape(key) + r"\s*[=:]\s*(.*)$", line)
        if match:
            escapes = {"t": "\t", "n": "\n", "r": "\r", "f": "\f"}
            result = re.sub(
                r"\\(u[0-9a-fA-F]{4}|.)",
                lambda m: chr(int(m[1][1:], 16)) if m[1].startswith("u")
                and len(m[1]) == 5 else escapes.get(m[1], m[1]),
                match[1],
            )
    return result


def check_java(env):
    suffix = ".exe" if os.name == "nt" else ""
    home = env.get("JAVA_HOME")
    java = str(Path(home) / "bin" / ("java" + suffix)) if home else shutil.which("java")
    if not java:
        fail("Java was not found. Install JDK 17 or 21 and set JAVA_HOME to its directory.")
    try:
        version = subprocess.run(
            [java, "-version"], capture_output=True, text=True, check=True,
        )
    except (OSError, subprocess.CalledProcessError) as error:
        fail("Cannot run Java. Check JAVA_HOME and install JDK 17 or 21.\n" + str(error))
    output = version.stderr + version.stdout
    match = re.search(r'version\s+"(\d+)', output)
    if not match or not 17 <= int(match[1]) <= 23:
        fail("This Gradle setup requires Java 17–23; JDK 17 or 21 is recommended.\n" + output)
    java_path = Path(java).resolve()
    javac = (Path(home) if home else java_path.parent.parent) / "bin" / ("javac" + suffix)
    if not javac.is_file():
        fail("Java is available, but its JDK compiler is missing. Install a full JDK 17 or 21 (not only a JRE) and set JAVA_HOME.")
    print("Java: " + output.splitlines()[0], flush=True)


def find_sdk(env):
    configured = property_value(ROOT / "local.properties", "sdk.dir")
    if configured:
        sdk = Path(configured)
        return sdk if sdk.is_absolute() else ROOT / sdk
    for key in ("ANDROID_HOME", "ANDROID_SDK_ROOT"):
        if env.get(key):
            return Path(env[key]).expanduser().resolve()
    candidates = [
        Path.home() / "Android" / "Sdk",
        Path.home() / "Library" / "Android" / "sdk",
    ]
    if env.get("LOCALAPPDATA"):
        candidates.append(Path(env["LOCALAPPDATA"]) / "Android" / "Sdk")
    candidates.extend([Path("/opt/android-sdk"), Path("/usr/lib/android-sdk")])
    return next((path for path in candidates if path.is_dir()), None)


def sdk_requirements():
    config = (ROOT / "app" / "build.gradle.kts").read_text(encoding="utf-8")
    compile_sdk = re.search(r"\bcompileSdk\s*=\s*(\d+)", config)
    if not compile_sdk:
        fail("Cannot determine compileSdk from app/build.gradle.kts.")
    tools = re.search(r'\bbuildToolsVersion\s*=\s*"([^"]+)"', config)
    tools_version = tools[1] if tools else DEFAULT_BUILD_TOOLS
    return compile_sdk[1], tools_version


def sdk_packages():
    compile_sdk, tools_version = sdk_requirements()
    return ["platforms;android-" + compile_sdk, "build-tools;" + tools_version, "platform-tools"]


def check_sdk(env):
    compile_sdk, tools_version = sdk_requirements()
    packages = " ".join('"{}"'.format(package) for package in sdk_packages())
    setup = (
        "Install Android Studio's SDK or the Android command-line tools, then run:\n"
        "  sdkmanager " + packages + "\n"
        "  sdkmanager --licenses\n"
        "Set ANDROID_HOME to the SDK directory, or set sdk.dir in local.properties."
    )
    sdk = find_sdk(env)
    if sdk is None or not sdk.is_dir():
        fail("Android SDK was not found" + (" at " + str(sdk) if sdk else "") + ".\n" + setup)
    missing = []
    if not (sdk / "platforms" / ("android-" + compile_sdk) / "android.jar").is_file():
        missing.append("platforms;android-" + compile_sdk)
    tool_name = "aapt2.exe" if os.name == "nt" else "aapt2"
    if not (sdk / "build-tools" / tools_version / tool_name).is_file():
        missing.append("build-tools;" + tools_version)
    if missing:
        fail("SDK at {} is missing: {}.\n{}".format(sdk, ", ".join(missing), setup))
    # Make automatic discovery visible to Gradle without modifying local.properties.
    env["ANDROID_HOME"] = str(sdk.resolve())
    env["ANDROID_SDK_ROOT"] = env["ANDROID_HOME"]
    print("Android SDK: " + env["ANDROID_HOME"], flush=True)


def positive_integer(value):
    try:
        number = int(value)
    except ValueError:
        raise argparse.ArgumentTypeError("Must be a positive integer") from None
    if number < 1:
        raise argparse.ArgumentTypeError("Must be a positive integer")
    return number


def parse_args(argv=None):
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--check", action="store_true", help="Check prerequisites without building or downloading")
    parser.add_argument("--clean", action="store_true", help="Clean build outputs before building")
    parser.add_argument("--test", action="store_true", help="Run debug JVM unit tests before assembling")
    parser.add_argument("--offline", action="store_true", help="Use only cached Gradle dependencies")
    parser.add_argument("--lint", action="store_true", help="Run Android debug lint")
    parser.add_argument("--ci", action="store_true", help="Run JVM tests, lint, compile Android tests, and build debug")
    parser.add_argument("--release", action="store_true", help="Also build the minified unsigned release APK")
    parser.add_argument("--no-daemon", action="store_true", help="Disable persistent Gradle daemons")
    parser.add_argument("--max-workers", type=positive_integer, help="Limit Gradle worker count")
    parser.add_argument("--version-name", help="Override the APK version name")
    parser.add_argument("--version-code", type=positive_integer, help="Override the Android version code")
    parser.add_argument("--print-sdk-packages", action="store_true", help="Print required sdkmanager packages without checking Java/SDK")
    args = parser.parse_args(argv)
    if args.version_name is not None and not re.fullmatch(r"[0-9A-Za-z][0-9A-Za-z.+-]{0,63}", args.version_name):
        parser.error("--version-name must be 1–64 letters, digits, dots, pluses or hyphens")
    if args.version_code is not None and args.version_code > 2_100_000_000:
        parser.error("--version-code must not exceed 2100000000")
    return args


def build_command(args):
    wrapper = ROOT / ("gradlew.bat" if os.name == "nt" else "gradlew")
    command = [str(wrapper)] if os.name == "nt" else ["sh", str(wrapper)]
    command += ["--console=plain", "--stacktrace"]
    if args.no_daemon:
        command.append("--no-daemon")
    if args.max_workers:
        command += ["--max-workers", str(args.max_workers)]
    if args.version_name is not None:
        command.append("-Plimessh.versionName=" + args.version_name)
    if args.version_code is not None:
        command.append("-Plimessh.versionCode=" + str(args.version_code))
    if args.offline:
        command.append("--offline")
    if args.clean:
        command.append("clean")
    if args.test or args.ci:
        command.append(":app:testDebugUnitTest")
    if args.lint or args.ci:
        command.append(":app:lintDebug")
    if args.ci:
        command.append(":app:compileDebugAndroidTestKotlin")
    command.append(":app:assembleDebug")
    if args.release:
        command.append(":app:assembleRelease")
    return command


def main(argv=None):
    args = parse_args(argv)
    if args.print_sdk_packages:
        print("\n".join(sdk_packages()))
        return 0

    wrapper = ROOT / ("gradlew.bat" if os.name == "nt" else "gradlew")
    if not wrapper.is_file() or not (ROOT / "gradle" / "wrapper" / "gradle-wrapper.jar").is_file():
        fail("Gradle wrapper is incomplete. Restore gradlew and gradle/wrapper from the repository.")
    env = os.environ.copy()
    check_java(env)
    check_sdk(env)
    if args.check:
        print("Local build prerequisites are ready. Run python3 build-local.py to build.")
        return 0

    print("Building limessh…", flush=True)
    result = subprocess.run(build_command(args), cwd=ROOT, env=env)
    if result.returncode:
        print("Build failed; see Gradle's errors above. No APK success is claimed.", file=sys.stderr)
        return result.returncode if result.returncode > 0 else 1
    apk = ROOT / "app" / "build" / "outputs" / "apk" / "debug" / "app-debug.apk"
    if not apk.is_file():
        fail("Gradle finished but the expected debug APK was not found: " + str(apk))
    print("\nDebug APK: " + str(apk), flush=True)
    adb = Path(env["ANDROID_HOME"]) / "platform-tools" / ("adb.exe" if os.name == "nt" else "adb")
    print('Install on a connected device: "{}" install -r "{}"'.format(adb if adb.is_file() else "adb", apk))
    if args.release:
        release = ROOT / "app" / "build" / "outputs" / "apk" / "release" / "app-release-unsigned.apk"
        if not release.is_file():
            fail("Gradle finished but the expected unsigned release APK was not found: " + str(release))
        print("Unsigned release APK (sign before installation): " + str(release))
    return 0


if __name__ == "__main__":
    try:
        sys.exit(main())
    except (RuntimeError, OSError) as error:
        print("Build setup error: " + str(error), file=sys.stderr)
        sys.exit(1)
    except KeyboardInterrupt:
        sys.exit(130)
