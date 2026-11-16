# Local builds and GitHub Actions

## Prerequisites

- Python 3 and a full JDK 17 or 21, including `javac`. CI uses Temurin 21.
- Android SDK Platform 35, Build Tools 34.0.0 and platform-tools.
- The checked-in Gradle 8.11.1 wrapper; a separate Gradle installation is unnecessary.

Install the Android command-line tools using Android Studio's SDK Manager or
the [official command-line tools download](https://developer.android.com/studio#command-tools).
Place `sdkmanager` under `$ANDROID_HOME/cmdline-tools/latest/bin` if installing
manually, then configure your shell and install the packages:

```bash
# JAVA_HOME must point to your installed full JDK, not its bin directory.
# On north, the verified JDK is:
export JAVA_HOME=/usr/lib/jvm/temurin-21-jdk-amd64
export ANDROID_HOME="$HOME/Android/Sdk"
export PATH="$JAVA_HOME/bin:$ANDROID_HOME/cmdline-tools/latest/bin:$ANDROID_HOME/platform-tools:$PATH"

sdkmanager --sdk_root="$ANDROID_HOME" "platforms;android-35" "build-tools;34.0.0" "platform-tools"
sdkmanager --sdk_root="$ANDROID_HOME" --licenses
```

`JAVA_HOME=/some/path` on its own is a shell variable, not necessarily an
exported environment variable. Use `export`, or prefix the build command:

```bash
JAVA_HOME=/usr/lib/jvm/temurin-21-jdk-amd64 bash build.sh --check
```

## SDK discovery

The helper checks these locations in order:

1. `sdk.dir` in the checkout's `local.properties` (same precedence as Android Gradle Plugin).
2. `ANDROID_HOME`, then the legacy `ANDROID_SDK_ROOT` variable.
3. Standard Android Studio locations on Linux, macOS and Windows, then common Linux system locations.

An explicitly selected incomplete SDK is reported, rather than silently replaced.
Point the environment variables to the same installation. `local.properties`
is ignored by Git and must not be copied into CI.

On **north**, the SDK is installed persistently at `/home/lukas/Android/Sdk`.
This checkout has an ignored `local.properties` containing:

```properties
sdk.dir=/home/lukas/Android/Sdk
```

Earlier verification used temporary tools in `/tmp/opencode`; they are no longer
required for local builds. Shell startup files have not been modified: export
`JAVA_HOME` in each new terminal, or add your chosen setup to your shell profile.

## Commands

Run from the repository root:

```bash
bash build.sh --check                # Check Java, compiler, SDK packages and wrapper
bash build.sh                        # Build debug APK
bash build.sh --clean --test          # Clean, run JVM tests and build debug
bash build.sh --lint                  # Run Android debug lint and build debug
bash build.sh --ci                    # JVM tests, lint, compile Android tests, debug APK
bash build.sh --ci --release          # The same checks plus minified unsigned release APK
bash build.sh --offline               # Use an already-cached Gradle distribution/dependencies
bash build.sh --no-daemon --max-workers 2
python3 -m unittest discover -s tests -v  # Build-helper regression tests; no Android SDK required
```

`./build.sh` also works. On Windows use `py -3 build-local.py`; on any platform
the Python helper accepts the same options. Invoke either helper by its full
path to build from another working directory.

`--ci` **compiles**, but does not execute, the Android instrumentation tests.
Run those separately with an emulator or a connected test device:

```bash
./gradlew :app:connectedDebugAndroidTest
```

Optional version overrides are passed into the actual Android build:

```bash
bash build.sh --release --version-name 0.1.0-alpha1 --version-code 1
```

The first build needs network access. Gradle failures propagate as nonzero exit
codes; the helper reports APK paths only after successful assembly. `--check`
and `--print-sdk-packages` do not download anything. Print the SDK packages that
CI installs with:

```bash
python3 build-local.py --print-sdk-packages
```

## Outputs and installation

| Output | Path | Installable? |
|---|---|---|
| Debug APK | `app/build/outputs/apk/debug/app-debug.apk` | Yes, debug-signed |
| Release APK | `app/build/outputs/apk/release/app-release-unsigned.apk` | Only after signing |
| JVM test report | `app/build/reports/tests/testDebugUnitTest/index.html` | Report |
| Lint report | `app/build/reports/lint-results-debug.html` | Report |
| Room schema | `app/schemas/cz.opentree.limessh.data.local.AppDatabase/2.json` | Versioned schema metadata |

Install the debug APK with USB debugging enabled:

```bash
"$HOME/Android/Sdk/platform-tools/adb" install -r app/build/outputs/apk/debug/app-debug.apk
```

Different signing certificates cannot update each other in place. Debug keys
can differ across developer machines and GitHub-hosted runners. Use a stable
publisher key for distributable updates; do not treat a debug-signed APK as a
publisher-signed release.

## GitHub Actions

`.github/actions/setup-build/action.yml` is shared by both workflows. It installs
Temurin 21, Python 3.12, the Android tools, and SDK packages obtained from the
build helper, and configures the Gradle cache. It does not cache the entire
Android SDK or signing keys.

### Build APK

`.github/workflows/build-apk.yml` runs on pushes to `main`/`develop`, pull requests
to `main`, and manual dispatch. It runs the Python helper tests, ShellCheck,
`bash build.sh --ci --release --no-daemon --max-workers 2`, and debug-signature
verification. Test/lint/build failures fail the job. Reports are uploaded even
when a check fails.

Artifacts:

- `limessh-debug-apk`: debug-signed `app-debug.apk`.
- `limessh-release-unsigned-apk`: minified unsigned APK.
- `limessh-check-reports`: JVM test results and Android lint reports.

APKs are retained for 30 days, reports for 14 days. Find them under the
repository's **Actions → Build APK → run → Artifacts** after a successful run.

### Tagged release

`.github/workflows/release.yml` runs on tags such as `v0.1.0` or
`v0.1.0-alpha1`. It validates the tag, embeds its version name, uses the release
workflow run number as the version code, and runs the same blocking checks
before publishing. Tags with a prerelease suffix produce GitHub prereleases.
Choose tags and version codes according to the project's release policy; no tag
or release is created merely by editing these files.

Optional repository secrets for publisher signing:

- `KEYSTORE_BASE64`
- `KEYSTORE_PASSWORD`
- `KEY_ALIAS`
- `KEY_PASSWORD`

When the keystore secret is present, all signing values are required. The
workflow decodes the key in runner temporary storage, signs using `apksigner`
with password environment variables, verifies the result and removes the
temporary key on step exit. Signing failures fail publication.

Without the keystore secret, the release asset is explicitly named
`limessh-VERSION-release-unsigned.apk`. With signing configured, it is
`limessh-VERSION-release-signed.apk`. Both cases also publish
`limessh-VERSION-debug.apk` and `SHA256SUMS`. An unsigned APK cannot be installed
until it is signed. Only the tag-publishing job receives `contents: write`.

Workflow syntax and local-equivalent commands can be validated locally, but a
successful GitHub-hosted run is a separate check after these changes are pushed.

## Troubleshooting

- **Java found, compiler missing:** the system default is a JRE. Export the full
  JDK's `JAVA_HOME`; verify `"$JAVA_HOME/bin/javac" -version`.
- **SDK at `/usr/lib/android-sdk` lacks packages:** that directory may contain
  only platform-tools. Use a complete SDK and update `sdk.dir`/`ANDROID_HOME`.
- **`sdkmanager` not found:** add `cmdline-tools/latest/bin` to `PATH`, or run the
  tool by its full path.
- **License not accepted:** run `sdkmanager --sdk_root="$ANDROID_HOME" --licenses`.
- **Resource limits:** use `--max-workers 2 --no-daemon`.
- **Install certificate mismatch:** use an APK signed by the existing publisher,
  or explicitly handle removal/data backup before switching certificates.
- **Connection fails with `no such algorithm: X25519 for provider BC`:** install
  the rebuilt APK containing `SshCrypto` initialization. Android's reduced `BC`
  provider must be replaced with the bundled full provider before SSHJ creates
  the client. The fix keeps Curve25519 enabled; no server algorithm downgrade
  is needed. JVM collision/key-agreement regression tests pass; real-device
  connection verification is still required.
- **`Exhausted available authentication methods`:** install the current debug
  APK for detailed authentication errors and use **Edit connection / login
  identity**. Confirm the selected identity has the correct SSH username and
  method. For password login use the account password; for private-key login
  supply the private key (not its `.pub` file) and its separate key passphrase
  if encrypted. Missing passwords/passphrases are prompted at login. If the
  server accepts a key but requires another factor, the app prompts for that
  account password/interactive response. A key-only server cannot authenticate
  an account password. Use **Retry** after editing the identity. Errors show the
  server's remaining methods; the generic rejection alone cannot identify
  whether credentials or server account policy are the cause.
