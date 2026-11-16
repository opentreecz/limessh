# LimeSSH

**A modern, open-source Android SSH client inspired by JuiceSSH workflows.**

LimeSSH is an independently implemented successor to the discontinued JuiceSSH Android app. It preserves the excellent user experience and workflow patterns while using modern, properly licensed components and a fresh green retro aesthetic.

> Where JuiceSSH was yellow, LimeSSH is green. A lime with green skin, green core, and a terminal prompt.

## Status

**Development implementation** — Android UI, SSH/session integration, SFTP,
forwarding, encrypted configuration backup, and researched extension workflows
are implemented. Runtime/device interoperability remains unverified. See
[implementation status](docs/IMPLEMENTATION_STATUS.md) for the feature boundaries
and validation record.

- Package: `cz.opentree.limessh`
- Repository: [github.com/opentreecz/limessh](https://github.com/opentreecz/limessh)
- Origin: Reverse-engineering research of JuiceSSH 3.2.2 + independent implementation

## Stack

| Component | Choice | License |
|-----------|--------|---------|
| Language | Kotlin 2.1.0 | Apache-2.0 |
| UI | Jetpack Compose + Material 3 | Apache-2.0 |
| SSH engine | SSHJ 0.40.0 | Apache-2.0 |
| Crypto | BouncyCastle 1.79 | MIT-like |
| Database | Room 2.6.1 | Apache-2.0 |
| Min SDK | 26 (Android 8.0) | |
| Target SDK | 35 (Android 15) | |

## Theme

LimeSSH uses a **retro green terminal** aesthetic:
- Dark mode: phosphor green (#00FF41) on deep dark green-black (#0A1A0A)
- Light mode: forest green on honeydew
- Monospace typography throughout for that terminal feel
- Logo: lime fruit cross-section with segment lines and a terminal prompt overlay

## Feature Targets

Inspired by JuiceSSH Pro, all features will be free and open source:

- SSH terminal with full xterm emulation
- Connection, identity, and group management
- Host key verification (Room-backed database)
- Local, remote, and SOCKS port forwarding
- Saved commands/scripts with auto-run on connect
- Home screen widget and shortcuts
- Inactivity screen lock
- AES-256-GCM encrypted backup and sync (new design)
- Plugin SDK v2 (limessh-native permission-checked provider and session API)
- Metadata importer for supported JSON connection exports
- Terminal color schemes (Retro green is the default)
- App lock with fingerprint/face and screen-lock fallback
- Import of existing OpenSSH, PEM and PKCS#8 private keys

## Project Structure

```
app/src/main/java/cz/opentree/limessh/
  LimeApp.kt                    Application + notification channels
  domain/model/                  Connection, Identity, Snippet, etc.
  data/local/                    Room database, DAOs, entities
  ssh/                           SshEngine (SSHJ adapter), host key verifier
  service/                       Foreground SessionService
  ui/
    screens/                     Connections, terminal, SFTP, keys, extensions, settings
    navigation/                  Compose NavHost routing
    theme/                       Green retro color scheme + monospace typography
    viewmodel/                   ViewModels
  plugin/                        Permission-checked v2 provider and session gateway
    builtin/                     Monitor, port knocking, audit, remote command adapters
    automation/                  New Tasker/Locale action and scoped grants
```

## Research & Documentation

This project includes extensive reverse-engineering research:

- [Feasibility Report](reports/JuiceSSH%20revival%20feasibility.md) -- full analysis
- [Roadmap](docs/ROADMAP.md) -- staged development plan
- [Feature Matrix](docs/FEATURE_MATRIX.md) -- complete feature inventory
- [Architecture](docs/ARCHITECTURE.md) -- proposed app design
- [Session Memory](docs/SESSION_MEMORY.md) -- resumable project state
- [Implementation Status](docs/IMPLEMENTATION_STATUS.md) -- current functionality, plugin API, and remaining work
- [Missing Features Backlog](docs/MISSING_FEATURES.md) -- every known gap with IDs, evidence and milestones
- [Build & CI Guide](docs/BUILDING.md) -- setup, troubleshooting, artifacts, and release signing
- [Plugin Contracts](research_notes/JuiceSSH%20implementation%20groundwork/plugin-contracts.md) -- SDK AIDL analysis
- [Component Evaluation](research_notes/JuiceSSH%20implementation%20groundwork/components-and-android.md) -- SSH library comparison

## Legal

- LimeSSH is **independently implemented** -- it does not contain JuiceSSH source code
- Research involved exposure to decompiled material; no clean-room claim is made
- JuiceSSH plugin SDK and official plugins (Performance Monitor, PortKnocker, Audit Log) are Apache-2.0
- Sonelli Ltd appears active; an unsent permission inquiry is drafted for optional authorized asset reuse
- No license has been assigned to LimeSSH yet; this will be decided before first release

## Building

### Local build script

Requires Python 3, JDK 17 or 21, and Android SDK Platform 35 with Build Tools
34.0.0 (the default for Android Gradle Plugin 8.7.3). Install the SDK using
Android Studio's SDK Manager, or the Android command-line tools:

```bash
sdkmanager "platforms;android-35" "build-tools;34.0.0" "platform-tools"
sdkmanager --licenses
```

Set `ANDROID_HOME` to your SDK directory, or use Android Studio's
`sdk.dir` entry in the ignored `local.properties` file. The script also detects
the usual Android Studio SDK locations on Linux, macOS, and Windows.

From the repository root:

```bash
./build.sh --check        # Check Java, SDK packages, and wrapper
./build.sh                # Build the debug APK
./build.sh --clean --test # Clean, run JVM unit tests, and build
./build.sh --offline      # Build with cached dependencies
./build.sh --ci --release # Run CI checks and build debug + unsigned release
```

`build.sh` delegates to the cross-platform `build-local.py` helper. You can also
run `python3 build-local.py` directly. On Windows, use `py -3 build-local.py`
with the same options. The script works
from any working directory when invoked by its path. It uses the checked-in
Gradle wrapper, preserves Gradle failure exit codes, and prints the APK path
only after a successful build. The first build needs network access to download
Gradle and dependencies; `--offline` requires the Gradle distribution and all
dependencies to be cached already. `--check` does not download anything.

Use `export JAVA_HOME=...` to select a **full JDK**, including `javac`; a plain
shell assignment may not reach the build process. On north, the verified JDK is
`/usr/lib/jvm/temurin-21-jdk-amd64` and the SDK is `/home/lukas/Android/Sdk`.
That checkout's ignored `local.properties` selects the SDK automatically.

`--ci` runs JVM tests and lint and compiles Android instrumentation tests;
executing instrumentation tests still requires a device/emulator. `--release`
also builds `app/build/outputs/apk/release/app-release-unsigned.apk`, which must
be signed before installation. See the [Build & CI Guide](docs/BUILDING.md) for
all options, GitHub artifact names, tagged releases and signing secrets.

Output: `app/build/outputs/apk/debug/app-debug.apk` (debug-signed).

Install on a USB-debugging-enabled device with Android platform-tools:

```bash
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

You can also invoke Gradle directly:

```bash
./gradlew assembleDebug
```

## Contributing

Early stage -- contact the maintainers before contributing. See [ROADMAP.md](docs/ROADMAP.md) for the development plan.
