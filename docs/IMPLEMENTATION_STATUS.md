# limessh implementation status

Updated: 2026-10-19. This is the current implementation record; the architecture,
roadmap and feature matrix also retain their earlier research proposals.

## Implementation route

The project is **limessh**, application ID `cz.opentree.limessh`. The original
JuiceSSH APK remains a research input. This implementation uses the documented
workflows/contracts, SSHJ and Android libraries. The new adapters described below
are independent implementations, not verified source ports or repackaged
JuiceSSH plugin binaries. Research exposure is recorded; no clean-room claim is
made. No proprietary source/asset reuse permission has been established.

## Implemented app paths

- Connection editing with saved identity selection, quick password identities,
  groups, deletion and pinned home-screen shortcuts.
- Password, private-key and keyboard-interactive authentication; SHA-256 host-key
  fingerprints with explicit unknown/changed-key prompts.
- Application-owned concurrent sessions with a foreground-service notification,
  session list, explicit disconnect, and reuse when returning to a terminal.
- Original terminal parser/renderer, chunked UTF-8 handling, basic wide/combining
  characters, alternate-screen resize, ANSI/256/truecolor attributes, hardware
  keys, mobile line input and special-key buttons. This is not a full xterm
  conformance claim; IME, accessibility, tmux/screen and Unicode edge cases need
  device testing. Scrollback is retained but has no history browser yet.
- Local forwarding bound to `127.0.0.1`; remote forwarding; loopback SOCKS5
  CONNECT with IPv4, IPv6 and server-resolved domain names. SOCKS BIND and UDP
  ASSOCIATE are unsupported. Configure rules before opening a new session.
- Saved commands and sequential group execution on already-open sessions.
  Explicitly opted-in snippets run once per fresh login to their associated
  connection, not when returning to an existing terminal. Room schema v2 adds
  this association with a v1→v2 migration.
- SFTP directory browsing, downloads through Android's document picker, and
  uploads that refuse to overwrite existing files.
- RSA-3072 identity generation, device-bound private-key storage and public-key
  copying in OpenSSH format.
- Persistent font/scrollback preferences and configurable inactivity lock using
  Android device credentials. Lock preserves existing SSH transports, hides the
  app UI and blocks new plugin/automation requests. It is not key erasure.
- AES-256-GCM configuration export/restore with PBKDF2-HMAC-SHA256, bounded input,
  actual database records and transactional restore. **Passwords, private keys,
  automation grants and application preferences are excluded.** Restore merges
  by ID and can replace matching configuration and host-trust records.
- Explicit JSON metadata migration with UUID validation and skip/warning counts.
  Legacy encrypted exports and SQLite databases are not supported without
  format fixtures. No private-key recovery is claimed.

## Research inventory → implementation

| Researched extension | Current delivery |
|---|---|
| Performance Monitor | Built-in CPU/RAM/load/disk/network/temperature polling; tied to screen lifecycle; Linux commands required |
| Modernized / Improved Performance Monitor | Core monitoring workflow covered by the built-in adapter; fork-specific behavior/source not imported |
| PortKnocker | Strict TCP/UDP/pause sequence parser and sender; manual execution from Extensions |
| Plugin Audit Log | Shared, bounded, process-memory audit events; no command text, tokens or SSH transcripts; not durable across process death |
| Plugin Example | In-app diagnostic command plus new v2 provider/session API |
| FreeNAS Monitor | Read-only `zpool`/`zfs` status command adapter; needs remote tools; original plugin UI/API compatibility unverified |
| NVIDIA GPU Monitor | `nvidia-smi` CSV query adapter; needs remote NVIDIA tooling; no original GPL source copied |
| Openpyn / NordVPN | Status and explicitly confirmed daemon connect/disconnect commands; needs remote Linux/systemd, openpyn and non-interactive sudo; not an Android VPN implementation |
| Config Exporter | Independent OpenSSH metadata exporter; excludes credentials and forwarding rules |
| GroupSnippet | New saved-command/group workflow over active sessions; original repository contained no recovered implementation |
| Tasker | New Locale/Tasker setting activity and action receiver; scoped, revocable saved-command grants; device interoperability untested |
| OfflineProFix | Xposed module for the original app; not part of limessh, which has no Pro entitlement gate |

Open **Tools → Extensions** from the connection list, or the extension icon in
an active terminal. Configure saved commands, forwarding rules and groups from
the same Tools menu. Configuration export and automation revocation are in
Settings.

The Openpyn flags were checked against the upstream
[argument parser](https://github.com/jotyGill/openpyn-nordvpn/blob/master/openpyn/openpyn.py)
on 2026-10-19. Daemon mode avoids treating a long-running VPN process as a
bounded interactive exec command. This is a source-level check, not a remote
VPN connectivity test.

## New plugin data API

Authority: `content://cz.opentree.limessh.api.v2`.

Resources: `connections`, `snippets`, `portforwards`, `connectiongroups`,
`connectiongroupmemberships`, `pluginlog`. Each resource enforces its own
`cz.opentree.limessh.permission.READ_*` / `WRITE_*` permission; memberships and
audit are read-only. Identities, credentials and known-host keys are not exposed.

Queries accept allowlisted projections, an optional `column = ?` selection,
and allowlisted sort orders. Writes support collection insert and item-URI
update/delete; modified timestamps are host-controlled. IDs are UUIDs. Raw SQL
expressions and unrestricted bulk mutation are unsupported. Provider mutations
invalidate Room observers.

## New plugin session API

Bind explicitly to
`cz.opentree.limessh/cz.opentree.limessh.plugin.PluginSessionService` using
Android `Messenger`. Declare/request `OPEN_SESSIONS`; `EXECUTE_COMMANDS` is also
required for exec and PTY writes. See `PluginContract.SessionApi` for constants.

Requests use `Message.what` for the operation, `arg1` for a request ID and
`replyTo` for a reply Messenger:

1. `ATTACH` (1): data `connectionId`; user must already have opened that session.
   Reply includes `handle` and `apiVersion=2`.
2. `EXECUTE` (2): data `handle`, `command`; returns `stdout`, `stderr`,
   `exitCode`, `truncated`. Each returned output stream is capped at 32,768
   characters for Binder transport; command execution has separate byte/time limits.
3. `WRITE` (3): data `handle`, `command`; writes exact UTF-8 text to the PTY.
4. `RELEASE` (4): data `handle`; releases the plugin handle, preserving the session.

Replies retain the request operation/ID and include `ok` or an `error`.
Handles are random and UID-bound, limited and invalidated on caller death/service
destruction. Request permission and lock checks occur for every operation.
This is a new protocol, not the original JuiceSSH AIDL wire contract. External
SFTP IPC and headless session creation are not implemented.

## Tasker / Locale

In Tasker, add the **limessh: run saved command** plugin action. Select a
connection and saved command in its configuration activity. A random bearer
grant authorizes only that association. Editing the saved command changes its
future action. Revoke all grants in Settings.

The receiver validates the grant and queues WorkManager execution; it does not
start SSH sessions or bypass host-key prompts/lock. The worker rechecks the
grant and lock, then uses an already-open session. Duplicate in-flight triggers
for one grant are coalesced. Ordered broadcast success means **queued**, not
remote command success; consult the audit log. API discovery, Tasker behavior
and background timing require on-device verification.

## Validation and remaining work

Executed on 2026-10-19: `assembleDebug`, all **53** JVM tests,
`compileDebugAndroidTestKotlin`, `lintDebug` (warnings remain), and the local
build script passed. The generated debug APK passed `apksigner verify` using
v2 signatures. No device/emulator was connected, so Android instrumentation,
target-server SSH, SFTP, forwarding and Tasker runtime behavior remain unverified.

Authentication now rejects missing identities instead of assuming `root`, prompts
for missing passwords/key passphrases, handles keyboard-interactive password/OTP
and server-required key-plus-password flows, and reports remaining server methods.
The connection editor exposes the selected login identity and failed connections
offer Edit login and Retry. Five new policy tests and eleven loopback SSH-server
tests pass, covering password, RSA/encrypted PEM, OpenSSH Ed25519, multifactor and
rejection cases. These exercise the real SSH transport against an isolated JVM
server, not the user's Android device or target server.

The latest debug build fixes the reported Android `X25519 for provider BC`
connection failure by registering the full bundled BouncyCastle provider before
SSHJ client creation. Three additional JVM tests cover the provider-name
collision and key agreement; an AndroidKeyStore/X25519 instrumentation test
compiles but has not run on a device. The user's real connection must be retested
with the rebuilt APK. The earlier unsigned release build predates this fix.

The earlier shared `build.sh --ci --release --no-daemon --max-workers 2` run
passed and produced `app/build/outputs/apk/release/app-release-unsigned.apk`;
that unsigned artifact predates the latest connection fixes.
Eight Python build-helper tests, ShellCheck and actionlint pass. GitHub workflows
now use this same helper with blocking tests/lint and optional tagged publisher
signing. Hosted execution and publisher signing remain unverified; see
[BUILDING.md](BUILDING.md) for configuration and artifact details.

JVM regression coverage includes chunked/invalid UTF-8, combining characters,
alternate-buffer resize, OSC termination, immutable snapshots, bounded escape
parameters, strict knocks, VPN argument validation and OpenSSH export behavior.
Android backup round-trip/wrong-passphrase/tamper coverage is also provided.
See the session record for the latest executed build/check results.

Remaining: real-server/device authentication and forwarding tests; SFTP and
backup round trips; Room migration testing; plugin isolation/revocation tests;
Tasker interoperability; modern Android background/notification/IME/accessibility
testing; complete terminal conformance; configured connection/group widgets
(the existing widget opens the app); optional Mosh/local/Telnet/jump hosts/agent
forwarding; automatic backup scheduling; multi-device sync, AWS EC2 and teams.
The `specialUse` foreground-service declaration still needs distribution review.
No original plugin APK compatibility, server shutdown recovery or release-readiness
claim is made.

## Update — unlock, color schemes and key import

- **App lock:** Settings → Unlock method: fingerprint/face with screen-lock fallback
  (default), screen lock only, or biometric only (falls back to the screen lock if
  nothing is enrolled, so the user cannot be locked out). Uses `BiometricPrompt` on
  Android 11+ and a two-step flow on Android 8–10. "Lock now" is in Settings.
- **Color schemes:** eight terminal themes; **Retro green remains the default** and
  the fallback for unknown saved values.
- **Key import:** Identities → Public key → Import key file / Paste / Check key.
  OpenSSH, PEM and PKCS#8 keys, encrypted or not; PuTTY `.ppk` and `.pub` files are
  rejected with guidance. The key is validated before it can be saved.
- All three are covered by JVM tests but have **not been run on a device**.
- The complete list of remaining work is in [MISSING_FEATURES.md](MISSING_FEATURES.md).
