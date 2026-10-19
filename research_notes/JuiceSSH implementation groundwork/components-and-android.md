# SSH Library and Android Component Evaluation

Date: 2026-10-18

## SSH Library Candidates

### SSHJ 0.40.0 (Recommended for MVP)

- **License**: Apache-2.0
- **Source**: https://github.com/hierynomus/sshj
- **JVM**: Pure Java, no native code required
- **Dependencies**: BouncyCastle (bcprov + bcpkix), SLF4J
- **Key exchange**: DH groups 1-18, ECDH (nistp256/384/521), curve25519
- **Host keys**: RSA (SHA-2), DSA, ECDSA, Ed25519, FIDO/U2F (sk-ecdsa, sk-ed25519)
- **Ciphers**: chacha20-poly1305, AES-GCM, AES-CTR, AES-CBC, 3DES, others
- **Auth**: publickey, password, keyboard-interactive, SSH agent (unix domain socket, Java 16+)
- **Channels**: shell, exec, subsystem, local/remote port forwarding, SCP, SFTP v0-3
- **Key formats**: PKCS5, PKCS8, openssh-key-v1 (including FIDO keys)
- **CVE note**: Versions <= 0.37.0 vulnerable to Terrapin (CVE-2023-48795); 0.38.0+ patched
- **Android**: Pure JVM, works on Android. No NDK/JNI. BouncyCastle Android provider may need configuration.
- **Maintenance**: Active (CI passing, recent releases)

**Advantages for successor**: No native packaging, wide algorithm support, well-documented API, Apache-2.0 compatible. SSH agent forwarding available on Java 16+ (Android doesn't expose unix domain sockets natively, but can be adapted).

### ConnectBot cbssh (Alternative / Future)

- **License**: Apache-2.0
- **Source**: https://github.com/connectbot/cbssh
- **Language**: Kotlin with coroutines
- **Features**: Post-quantum algorithms (ML-KEM, ML-DSA hybrid, SNTRUP761), SFTP, local/remote/SOCKS5 forwarding, agent forwarding
- **Target**: JVM 17
- **Note**: Relatively new (544 commits), designed specifically for ConnectBot. May become the stronger long-term choice but less battle-tested than SSHJ.

### mwiede/JSch (Not Recommended)

- Fork of unmaintained Jcraft JSch
- Less algorithm coverage than SSHJ
- API less ergonomic
- Skip unless SSHJ proves inadequate

### Native libssh via JNI (Not Recommended for MVP)

- Would require NDK build, JNI wrapper, per-ABI packaging
- 16 KiB page alignment requirement on new Android devices
- Maintenance burden too high for initial release
- Consider only if specific native features (e.g., Mosh integration) require it later

## Terminal Emulator Candidates

### ConnectBot Terminal View

- **Source**: Part of connectbot/connectbot (Apache-2.0)
- **Type**: Android View-based terminal emulator
- **VT100/xterm**: Proven implementation used in production for years
- **Integration**: Would need Compose interop via AndroidView wrapper
- **Recommended**: Evaluate as first choice for terminal rendering

### Termux terminal-emulator

- **Source**: https://github.com/termux/termux-app
- **License**: GPL-3.0 – **license incompatibility risk** if the successor uses Apache/MIT
- **Quality**: Excellent terminal emulation
- **Decision**: Evaluate only if the project adopts GPL-compatible licensing

### Custom Compose Canvas

- Most flexibility for UI integration
- Highest development cost
- Consider only if existing components prove inadequate

## Android Platform Requirements (2026)

### Target SDK

- Google Play requires targetSdk 35 (Android 15) for new apps and updates as of August 2025
- App foundation targets compileSdk 35, targetSdk 35, minSdk 26

### Foreground Service

- `FOREGROUND_SERVICE_CONNECTED_DEVICE` type appropriate for SSH sessions
- Must declare in manifest and request at runtime on Android 14+
- Foreground service timeout: Android 15 may enforce timeouts on some types
  - `connectedDevice` type is expected to be exempt from short timeouts (like media/phone)
  - Needs runtime verification on actual Android 15 device

### 16 KiB Page Size (Android 15+)

- Pure JVM approach (SSHJ) avoids this entirely
- Relevant only if native libraries are added later
- NDK r27+ needed for 16 KiB aligned native builds

### Other Requirements

- POST_NOTIFICATIONS permission (Android 13+) for session notifications
- PendingIntent.FLAG_IMMUTABLE required (Android 12+)
- Exported components must declare `android:exported` (Android 12+)
- Package visibility: may need `<queries>` for plugin discovery

## Selected Stack for MVP

| Component | Choice | License | Rationale |
|-----------|--------|---------|-----------|
| SSH engine | SSHJ 0.40.0 | Apache-2.0 | Pure JVM, mature, wide algorithms |
| Crypto provider | BouncyCastle 1.79 | MIT-like | Required by SSHJ |
| UI framework | Jetpack Compose + Material 3 | Apache-2.0 | Modern Android UI, dynamic theming |
| Database | Room 2.6.1 | Apache-2.0 | Type-safe, migration support |
| Terminal | TBD (ConnectBot view first) | Apache-2.0 | Needs evaluation |
| Build | Gradle 8.11.1, AGP 8.7.3, Kotlin 2.1.0 | - | Current stable |

## Blocked Validations

- [ ] Actual Gradle sync and build (requires Android SDK on build machine)
- [ ] SSHJ connection to real SSH server
- [ ] Terminal emulator integration and escape sequence handling
- [ ] Foreground service timeout behavior on Android 15 device
- [ ] BouncyCastle provider registration on Android (may conflict with platform provider)
