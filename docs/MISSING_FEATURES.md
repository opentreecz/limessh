# limessh — missing and non-functional features backlog

Updated: 2026-10-19. This is the working inventory of what remains to implement in limessh, built from the legacy app map ([legacy-apk-map.md](../research_notes/Limessh%20feature%20gap%20investigation/legacy-apk-map.md)), the earlier research notes, the current source, and reports from the user.

Status words: **Done (needs device test)** = implemented, JVM-tested, never run on a device. **Missing** = no implementation. **Partial** = some code, incomplete. Evidence cites current source unless marked *legacy*.

## 0. Reported by the user

| ID | Report | Finding | Status |
|---|---|---|---|
| L-01 | Android device credential and biometric unlock non-functional/missing | Cause confirmed: `MainActivity` was a plain `ComponentActivity`, `BiometricPrompt` was never called, and the "Unlock method" setting only displayed a message. *Legacy* had **no** biometric or device-credential unlock (PIN lock only), so this was a new requirement. | **Done (needs device test)** — `ui/lock/UnlockPlanner.kt`, `InactivityLockScreen.kt`, `AppSettings.UnlockMethod`; 3 policies, Android 8–10 two-step fallback, no lockout when biometrics are removed; "Lock now" |
| T-01 | Only one retro-green terminal color scheme | Cause confirmed: palette hard-coded in `TerminalScreen`; "Color scheme" setting only showed a message. *Legacy* had 9 themes. | **Done (needs device test)** — `ui/theme/TerminalThemes.kt`: Retro green (**default, unchanged**), Classic dark/light, Solarized dark/light, Monokai, Amber CRT, High contrast; picker with live preview |
| K-01 | Cannot import existing SSH keys | Cause confirmed: identity editor was paste-only. | **Done (needs device test)** — `ssh/KeyImport.kt` + identity screen: file picker, paste, format/encryption detection, passphrase prompt, validation with the login parser, fingerprint and public key display; PuTTY `.ppk` and `.pub` files rejected with guidance |

Found while fixing: deleting an identity left its saved password/private key in encrypted storage (`CredentialStore.deleteCredentials` was never called). **Fixed** in `IdentityListViewModel`.

Branding: all JuiceSSH names removed from `app/src` (importer renamed `LimesshMetadataImporter`; no matches remain). Research documents, supplied APK filenames and the original fix module keep their names because they are evidence and provenance.

## 1. Keys and identities

| ID | Gap | Evidence | Priority |
|---|---|---|---|
| K-02 | PuTTY `.ppk` import (v2/v3, incl. encrypted) | rejected with conversion advice in `KeyImport` | P2 |
| K-03 | Export public key from a saved identity; export private key (explicit, confirmed) | public key only shown during import check; *legacy* had both | P1 |
| K-04 | "Install public key" snippet for `authorized_keys` | *legacy* string `pro_users_can_public_key_snippet` | P2 |
| K-05 | Generate Ed25519/ECDSA keys; choose size | `KeyGeneratorScreen.kt` RSA-3072 only | P1 |
| K-06 | Change passphrase, clear key | *legacy* `clear_private_key`, `update_passphrase`; none here | P2 |
| K-07 | Keys with OpenSSH certificates; FIDO `sk-` keys | not handled | P3 |
| K-08 | Multiple keys per identity / try-order | one key per identity | P3 |

## 2. Security

| ID | Gap | Evidence | Priority |
|---|---|---|---|
| S-01 | Known-hosts management UI (view, remove, re-trust) | `observeKnownHosts()` exists; no UI references it; *legacy* `clear_known_hosts` | P1 |
| S-02 | Optional PIN/attempt lockout (legacy model) | system credential only | P3 |
| S-03 | Lock timing options (on background, on screen off), screenshot blocking (`FLAG_SECURE`) | fixed timeouts only | P2 |
| S-04 | Credentials in encrypted backup (opt-in) | `BackupManager` refuses credentials | P2 |
| S-05 | Android cloud/device-transfer backup policy (`dataExtractionRules`) | lint warning | P2 |
| S-06 | Biometric-bound credential encryption (keys require unlock to use) | credentials in `EncryptedSharedPreferences`, not unlock-bound | P3 |

## 3. Terminal

| ID | Gap | Evidence | Priority |
|---|---|---|---|
| TM-01 | Scrollback viewer | buffer retained (`maxScrollback`) but no UI scrolls it | P1 |
| TM-02 | Text selection, copy, paste, transcript save/share | none in `TerminalScreen.kt`; *legacy* has all | P1 |
| TM-03 | Answer device-status and attributes queries | `TerminalEmulator.kt:241-242` ignores `n` and `c` requests; full-screen apps and multiplexers may misbehave | P1 |
| TM-04 | Extra keys row: Ctrl/Alt/Fn sticky keys, PgUp/PgDn/Home/End, pipe/tilde | only Esc, Tab, Ctrl-C, arrows, Enter | P1 |
| TM-05 | Gesture shortcuts (tmux/screen window switching), pinch zoom | *legacy* `horizontal_swipe_mode`; none here | P2 |
| TM-06 | Font choice, margins, bell mode, `TERM` type, keep-screen-on, keyboard position | only font size and scrollback | P2 |
| TM-07 | Mouse reporting, bracketed paste, OSC title, alternate-screen details, DECSET modes | partial parser; not conformance-tested | P2 |
| TM-08 | IME/hardware keyboard edge cases, accessibility (TalkBack) | untested; canvas-drawn text | P1 |
| TM-09 | Terminal theme applies to app chrome as well | themes affect terminal screen only by design | P3 |

## 4. Connections and transports

| ID | Gap | Evidence | Priority |
|---|---|---|---|
| C-01 | `ssh://` links and quick connect (`user@host:port`) | manifest declares `ssh` scheme (`AndroidManifest.xml:58`) but `MainActivity.kt:27` handles only `limessh` | P1 |
| C-02 | Connect-via (jump host / ProxyJump) | *legacy* `form_connect_via`; no model field | P1 |
| C-03 | SSH agent forwarding | *legacy* `ssh:agent`; absent | P2 |
| C-04 | Auto-reconnect, keepalive settings, network-change handling | not implemented | P1 |
| C-05 | Compression, ciphers/KEX policy UI | none | P3 |
| C-06 | Mosh | `SessionManager` rejects non-SSH types | P3 |
| C-07 | Telnet | rejected; cleartext needs explicit opt-in | P3 |
| C-08 | Local shell | rejected | P3 |
| C-09 | Recents / frequently used / counters | *legacy* `ConnectionCounter`; none | P2 |
| C-10 | Connection list search, sort, group views | basic list only | P2 |

## 5. Forwarding, SFTP, widgets

| ID | Gap | Evidence | Priority |
|---|---|---|---|
| F-01 | "Open in browser" after forwarding | `openInBrowser` stored, UI control removed, never used | P2 |
| F-02 | Per-session forward status, start/stop | rules start at login; no status UI | P1 |
| F-03 | Remote forward conflict handling | errors collected in warnings only | P2 |
| SF-01 | SFTP: mkdir, rename, delete, chmod, recursive/multi-file, progress, resume | list/download/upload only (`SftpBrowserScreen.kt`) | P1 |
| W-01 | Configurable connection/group widget | `LimeWidget.kt` only opens the app and shows "Ready" | P2 |
| W-02 | Dynamic shortcuts | pinned shortcut only | P3 |

## 6. Data, plugins, services

| ID | Gap | Evidence | Priority |
|---|---|---|---|
| D-01 | Import of a real exported legacy dataset (needs user-owned fixture) | importer handles simple JSON metadata only | blocked |
| D-02 | Scheduled encrypted backup (WorkManager) | manual only | P2 |
| D-03 | Multi-device sync; AWS EC2 import; team sharing | not started; backend decision needed | P3 |
| P-01 | Compatibility with original plugin binaries | not feasible: package, authority and signature differ | won't do |
| P-02 | Persistent audit log, plugin catalog | audit log is in-memory | P2 |
| P-03 | External SFTP plugin IPC | not implemented | P3 |
| P-04 | Tasker end-to-end validation | untested | P1 |

## 7. Quality gates (cross-cutting)

| ID | Gap | Priority |
|---|---|---|
| Q-01 | No on-device run of **anything**; no emulator in this environment | P0 |
| Q-02 | Instrumentation tests compile but have never executed | P1 |
| Q-03 | GitHub-hosted CI and publisher signing unverified | P1 |
| Q-04 | No end-to-end tests of UI flows (Compose UI tests) | P2 |
| Q-05 | Terminal conformance corpus (vttest-style) | P2 |
| Q-06 | Release (minified) build not retested after recent fixes; R8 can break reflection use | P1 |

## 8. Milestones

| Milestone | Scope | Exit criteria |
|---|---|---|
| **M-A Device validation** | Q-01, Q-02, Q-06; run L-01, T-01, K-01 on real Android 8, 11 and 14+ devices | each reported fix demonstrated on a device; instrumentation tests executed |
| **M-B Terminal essentials** | TM-01, TM-02, TM-03, TM-04, TM-08 | scroll, select/copy/paste, tmux/vim usable, extra keys, TalkBack pass |
| **M-C Connection reliability** | C-01, C-02, C-04, F-02, S-01 | links open, jump host works, reconnect on network change, known hosts manageable |
| **M-D Keys and files** | K-03, K-05, K-06, SF-01 | export/generate/manage keys, full SFTP file operations |
| **M-E Polish** | TM-05..07, TM-06, C-09, C-10, W-01, F-01, S-03..05, D-02, P-02 | settings parity with the legacy app's surface |
| **M-F Extended** | K-02, K-04, C-03, C-05..08, D-03, P-03 | optional transports and services; each needs a separate decision |

## 9. Unavailable or out of scope

- Original source code and server backends are not available; the supplied fix module restores none of them.
- Proprietary assets, layouts and palettes are not copied. Themes here are public schemes or original.
- Anything marked "server-dependent" in the legacy map (CloudSync, EC2Link, TeamShare, purchases, push) would need a new, user-selected service.
