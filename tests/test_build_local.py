"""Standard-library regression checks for the shared local/CI build helper."""

import contextlib
import importlib.util
import io
from pathlib import Path
import subprocess
import unittest
from unittest.mock import patch

SPEC = importlib.util.spec_from_file_location("build_local", Path(__file__).resolve().parents[1] / "build-local.py")
build = importlib.util.module_from_spec(SPEC)
SPEC.loader.exec_module(build)


class BuildHelperTests(unittest.TestCase):
    def test_default_build_is_debug_only(self):
        command = build.build_command(build.parse_args([]))
        self.assertEqual([":app:assembleDebug"], [part for part in command if part.startswith(":app:")])

    def test_ci_is_blocking_checks_plus_debug_build(self):
        command = build.build_command(build.parse_args(["--ci", "--release", "--no-daemon", "--max-workers", "2"]))
        self.assertEqual([
            ":app:testDebugUnitTest", ":app:lintDebug", ":app:compileDebugAndroidTestKotlin",
            ":app:assembleDebug", ":app:assembleRelease",
        ], [part for part in command if part.startswith(":app:")])
        self.assertIn("--no-daemon", command)
        self.assertEqual("2", command[command.index("--max-workers") + 1])

    def test_clean_precedes_tasks_and_version_overrides_are_single_arguments(self):
        command = build.build_command(build.parse_args([
            "--clean", "--test", "--offline", "--version-name", "1.2.3-alpha1", "--version-code", "42",
        ]))
        self.assertLess(command.index("clean"), command.index(":app:testDebugUnitTest"))
        self.assertIn("--offline", command)
        self.assertIn("-Plimessh.versionName=1.2.3-alpha1", command)
        self.assertIn("-Plimessh.versionCode=42", command)

    def test_invalid_cli_values_fail_before_gradle(self):
        for args in (["--max-workers", "0"], ["--version-code", "-1"],
                     ["--version-code", "2100000001"], ["--version-name", "bad\nvalue"]):
            with self.subTest(args=args), contextlib.redirect_stderr(io.StringIO()), self.assertRaises(SystemExit):
                build.parse_args(args)

    def test_package_listing_does_not_require_installed_java_or_sdk(self):
        output = io.StringIO()
        with patch.object(build, "check_java") as java, patch.object(build, "check_sdk") as sdk, contextlib.redirect_stdout(output):
            self.assertEqual(0, build.main(["--print-sdk-packages"]))
        java.assert_not_called()
        sdk.assert_not_called()
        self.assertEqual(["platforms;android-35", "build-tools;34.0.0", "platform-tools"], output.getvalue().splitlines())

    def test_check_only_never_invokes_gradle(self):
        with patch.object(build, "check_java"), patch.object(build, "check_sdk"), patch.object(build.subprocess, "run") as run, contextlib.redirect_stdout(io.StringIO()):
            self.assertEqual(0, build.main(["--check"]))
        run.assert_not_called()

    def test_gradle_failure_code_is_preserved_without_success_message(self):
        output = io.StringIO()
        with patch.object(build, "check_java"), patch.object(build, "check_sdk"), patch.object(build.subprocess, "run", return_value=subprocess.CompletedProcess([], 7)), contextlib.redirect_stdout(output), contextlib.redirect_stderr(output):
            self.assertEqual(7, build.main([]))
        self.assertNotIn("Debug APK:", output.getvalue())

    def test_android_studio_escaped_sdk_path(self):
        with patch.object(Path, "is_file", return_value=True), patch.object(Path, "read_text", return_value="sdk.dir=C\\:\\\\Android\\ SDK\n"):
            self.assertEqual("C:\\Android SDK", build.property_value(Path("local.properties"), "sdk.dir"))


if __name__ == "__main__":
    unittest.main()
