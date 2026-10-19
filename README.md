# LimeSSH

**A modern, open-source Android SSH client inspired by JuiceSSH workflows.**

LimeSSH is an independently implemented successor to the discontinued JuiceSSH Android app. It preserves the excellent user experience and workflow patterns while using modern, properly licensed components and a fresh green retro aesthetic.

> Where JuiceSSH was yellow, LimeSSH is green. A lime with green skin, green core, and a terminal prompt.

## Status

**Early development** -- app foundation created, not yet runtime-tested.

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
- Plugin SDK v2 (compatible with ported JuiceSSH plugins)
- Migration importer for JuiceSSH data

## Project Structure

```
app/src/main/java/cz/opentree/limessh/
  LimeApp.kt                    Application + notification channels
  domain/model/                  Connection, Identity, Snippet, etc.
  data/local/                    Room database, DAOs, entities
  ssh/                           SshEngine (SSHJ adapter), host key verifier
  service/                       Foreground SessionService
  ui/
    screens/                     ConnectionList, Terminal (placeholder)
    navigation/                  Compose NavHost routing
    theme/                       Green retro color scheme + monospace typography
    viewmodel/                   ViewModels
  plugin/                        Future plugin SDK (empty)
```

## Research & Documentation

This project includes extensive reverse-engineering research:

- [Feasibility Report](reports/JuiceSSH%20revival%20feasibility.md) -- full analysis
- [Roadmap](docs/ROADMAP.md) -- staged development plan
- [Feature Matrix](docs/FEATURE_MATRIX.md) -- complete feature inventory
- [Architecture](docs/ARCHITECTURE.md) -- proposed app design
- [Session Memory](docs/SESSION_MEMORY.md) -- resumable project state
- [Plugin Contracts](research_notes/JuiceSSH%20implementation%20groundwork/plugin-contracts.md) -- SDK AIDL analysis
- [Component Evaluation](research_notes/JuiceSSH%20implementation%20groundwork/components-and-android.md) -- SSH library comparison

## Legal

- LimeSSH is **independently implemented** -- it does not contain JuiceSSH source code
- Research involved exposure to decompiled material; no clean-room claim is made
- JuiceSSH plugin SDK and official plugins (Performance Monitor, PortKnocker, Audit Log) are Apache-2.0
- Sonelli Ltd appears active; an unsent permission inquiry is drafted for optional authorized asset reuse
- No license has been assigned to LimeSSH yet; this will be decided before first release

## Building

Requires Android SDK with compileSdk 35:

```bash
./gradlew assembleDebug
```

## Contributing

Early stage -- contact the maintainers before contributing. See [ROADMAP.md](docs/ROADMAP.md) for the development plan.
