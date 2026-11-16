# Legacy app code and feature map (for limessh gap analysis)

Date: 2026-10-19. Method: **static** reading of the previously extracted, git-ignored evidence in `.artifact-analysis/` (JADX 1.5.3 output, decoded manifest and resources) plus targeted greps run this session. The original app was not executed and no service was contacted. Proprietary output stays in the ignored directory; this note records identifiers and counts, not copied code.

Reuse of earlier work: `research_notes/JuiceSSH revival feasibility/artifact-analysis.md` (hashes, manifest, native inventory, fix hooks, data model, plugin API, cloud). This note adds the **feature-surface map** and the limessh gap view. Sub-agent research was attempted but all six agents failed with "usage limit reached", so everything here was produced directly; see "Limits".

## Inputs verified this session

| Input | SHA-256 | Matches recorded baseline |
|---|---|---|
| Original app 3.2.2 (200) | `167d3afb1c832698ca512d9bf418c341a6f6e441bc64f57aaa1b264d47a8d64b` | yes |
| Fix module APK | `5dea4033623bc6562fe388c4f47e9df6cd2643327138b0f10578ef6f171a267d` | yes |

## Size and structure of the original app

- Package `com.sonelli.juicessh`; 7,839 DEX classes; JADX produced about 1,990 files under `com/sonelli` (most obfuscated as `xx0`-style names) with 26 recorded decompile errors.
- Manifest: 29 activities, 17 services, 7 receivers, 2 providers (many are Google/Firebase libraries).
- Readable package directories and file counts: `activities` 27, `models` 22 (+5 EC2), `util` 19, `pluginlibrary` 16 (+15 listeners), `views` 12 (+8 `dbpreferences`), `services` 7, `libssh` binding 42 + 6 adapter, `db` 5, `connections` 2 + 3 transports, `controllers` 3, `widgets` 2, `receivers` 2, `fragments` 2, `adapters` 2, `parsers` 1, `providers` 1.
- Unresolved: `DB.c(...)` database import/merge method (1,532 instructions) not decompiled; obfuscated classes (`oi0`, `pi0`, `ci0`, `di0`, `li0`, `qg0`, etc.) carry most terminal, transport and crypto logic; native libraries not reversed.

## Feature areas and where they live (original app)

| Area | Evidence (manifest component / package / resource) | What the original offered |
|---|---|---|
| Connection list | `AddressBookActivity`, `ManageConnectionActivity`, `ManageGroupActivity`, `QuickConnectPrompt`, `ConnectionCounter` model | Address book, groups, quick connect, frequently used connections |
| Identities and keys | `ManageIdentityActivity`/`ManageIdentityFragment`, `PrivateKeyPrompt`, `NewIdentityPrompt`, strings `set_private_key`, `export_private_key`, `clear_private_key`, `key_import_export_generation` | Import private key from the filesystem, generate keys, export public/private key, passphrase update, clear key. String `no_private_keys_found` says keys must be OpenSSH format, **not PuTTY PPK** |
| Terminal | `TerminalEmulatorActivity`, `TerminalView`, `TerminalAutoCompleteBox`, `AutoRepeatButton`, `TerminalGestureListener` | Full-color terminal, popup keyboard with special keys, external keyboard support, selection/copy/paste, transcripts (save/share), fullscreen, keep-screen-on |
| Terminal settings | `res/xml/settings.xml` keys `terminal:theme`, `terminal:font`, `terminal:font_size`, `terminal:margin`, `terminal:horizontal_swipe_mode`, `terminal:utf8`, `terminal:type`, `terminal:bell_mode`, `terminal:keyboard_position` | 9 themes, font choice, size, margin, swipe mode (tmux/screen style), UTF-8, emulator type (linux, xterm, xterm-color, xterm-256color, vt100), bell mode, keyboard position |
| Themes | `res/values/arrays.xml` `terminal_theme_names` | Dark, Light, Solarized Dark, Solarized Light, 80's Hacker, Monokai, Tiger Orange, Tiger Black, Bifrost (strings say extra schemes are a Pro feature) |
| Security | `pinlock:enabled` setting (`EncSwitchDBPreference`), `PinManager`, `LockoutActivity`, strings `enter_your_pin_to_unlock`, `too_many_incorrect_security_lock_attempts`, `clear_known_hosts`, `ssh:agent` | **PIN-based** lock with attempt lockout, clear known hosts, SSH agent forwarding switch. A search of all decompiled sources found **no** biometric, fingerprint or device-credential API use |
| Transports | `connections/transports/*`, `libssh` JNA binding, native `libcom_sonelli_mosh-client.so`, `..._telnet.so`, `..._bash.so`; URL schemes `ssh`, `ssh-forward`, `telnet`, `local`, `mosh` | SSH (native libssh 0.9.3), Mosh 1.3.2, Telnet, local shell, connect-via (jump) connections, zlib compression |
| Forwarding | `ManagePortForwardActivity`, `ForwardTransport`, strings `dynamic_socks`, `open_in_browser`, `set_as_browser_proxy`, `select_browser` | Local, remote and dynamic SOCKS forwards, open a browser through the forward, browser proxy |
| Snippets | `ManageSnippetsActivity`, `Snippet` model, strings `generate_snippet`, `pro_users_can_public_key_snippet` | Snippet library and an authorized_keys install snippet generator |
| Widgets/shortcuts | `ConnectionWidgetProvider/Service`, `ConfigureWidgetActivity`, `widget_preferences.xml` | Configurable home-screen widget (Pro), home-screen shortcuts |
| Background | `ConnectionManagerService` (non-exported) | Persistent session management |
| SFTP | `SftpPluginService` (+ `SftpControllerInterface`), strings `sftp_download/upload` | Plugin-oriented SFTP control, not a documented standalone browser |
| Plugins | `PluginService`, `ConnectionPluginService`, `SftpPluginService`, `PluginContentProvider`, `PluginsActivity`, `LogViewerActivity` | AIDL services, content provider (authority `com.sonelli.juicessh.api.v1`), plugin catalog and log viewer |
| Cloud/commerce | `CloudSync`, `Ec2Link`, `ManageTeamActivity`, `TeamShareActivity`, `ManageShareActivity`, `BookclubActivity`, `PurchaseActivity`, `BillingService`, `PushNotification`, models `Book`, `Team`, `TeamMembership`, `TeamEncryption`, `Share`, EC2 models | Sync, EC2 import, team sharing, purchases, push. Server-dependent; not reproducible locally |
| Data layer | `db/DB` (ORMLite schema 55), `BaseModel`, models Connection, Host, Identity, ConnectionIdentity, ConnectionGroup(+Membership), PortForward, Snippet, Config(+Field/Value), PluginLog, DeletedItem, User, Purchase | UUID-keyed records; secrets individually encrypted (AES-256-CBC, PBKDF2-SHA1/1000 — legacy format, not a design to copy) |
| Meta | `ChangelogActivity`, `SoftwareLicensesActivity`, `ViewLicenseActivity`, `ThankYouForPurchasingActivity` | About/licensing/changelog |

## The fix module (OfflineProFix)

Scope confirmed from earlier analysis: five Xposed hooks (`oi0.d`, `User.H`, `User.w`, `pi0.m`, `pi0.j`) that force **local** Pro/session checks to succeed and supply a cached or blank user. It adds **no** SSH, key, terminal, theme, lock or plugin functionality and does not restore any server. Therefore it contributes no code or features for limessh to reuse; its only value is documenting which features were Pro-gated (port forwarding, group sharing, shortcuts/widgets, extra themes, cloud sync, EC2, some identity UI).

## What the original did NOT have (relevant to the reported gaps)

- **Biometric / device-credential unlock: absent.** The original's security lock was a PIN with attempt lockout. limessh's request for Android device credential and biometric unlock is a **new requirement**, not a missing port.
- **Key import: present** (filesystem import of OpenSSH-format keys), but PuTTY PPK was explicitly unsupported.
- **Themes: present** (9 themes); limessh previously had one.

## Limits

- Static reading only; no runtime behavior, server responses or UI layouts were observed.
- Obfuscated classes were grouped by their surviving strings, resources and manifest roles, not fully traced. Function-level parity cannot be claimed from symbols alone.
- Sub-agent workers and the graphify structural code graph did not run (usage limit). No machine-generated call graph exists yet; this table is manual and file-level.
- No legacy palette values were copied; limessh's theme palettes are public schemes or original.
