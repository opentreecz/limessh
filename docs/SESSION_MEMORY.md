# Session memory — LimeSSH (formerly JuiceSSH revival feasibility)

Last updated: 2026-10-19 (password/private-key authentication fixes and loopback SSH tests).

## R-001 module audit completed — 2026-10-21

[Reviewed R-001](../research_notes/juicessh-parity/tasks/R-001.md) accounts for all
61 fix-module records (10 classes, 31 methods, 13 resources, activity and archive
entries). Hook/settings/error behavior and provenance are recorded; no module code
is selected for porting. Underlying gate call-site research stays with W-23. DEX
confirmed the lookup-only catch region missing from JADX. R-010 is ready next.
No app changes or runtime tests. Obsidian findings/session handoff saved.

## R-000 inventory completed — 2026-10-20

The [reviewed baseline](../research_notes/juicessh-parity/coverage/BASELINE.md)
records 61,540 indexed items, 48,083 main-app defined methods, 31 fix-module
methods, 43 native files and 95 current source/build records. Exact APK/cache,
smali signature and resource-ID checks passed; repeat generation was stable.
3,432 main classes have unknown ownership; behavioral parity remains pending.
DB.c fallback output exists but semantics are unresolved. No app changes or fresh
app test run. R-001 and R-010 are ready with exact entry points; start with
[the compact index](../research_notes/juicessh-parity/INDEX.md). Actual billed
token usage is unknown. Full generated indexes remain ignored locally.

## Research planning update — 2026-10-20

The resumable APK research programme is prepared in [RESEARCH_PLAN.md](RESEARCH_PLAN.md).
New agents start with [the compact index](../research_notes/juicessh-parity/INDEX.md),
then one queue row and task card. The default is one bounded research worker with
an estimated 8k–12k total-token target and durable checkpoints. Existing APK/JADX
evidence is reused. R-000 creates the complete coverage inventory; R-001 audits the
small Xposed module; R-010 pilots a terminal behavior specification. The other
workstreams must be split before dispatch. This update prepares the work and does
not claim deep-research completion, implementation changes or fresh app test results.
Obsidian entry point: `projects/juicessh/Research/Research programme.md`.

## Latest update — gap research, branding and user-reported defects

Tasks from the user: remove legacy product naming from the code, deep-map the legacy
app and fix APK, memorize all missing areas, and fix three reported defects.

- **Agents:** six research/audit sub-agents were launched; all failed with "usage limit
  reached". The branding worker had partly applied its edits first (importer already
  renamed). All research below was done directly by the coordinator.
- **Branding:** `app/src` has zero JuiceSSH references (case-insensitive). Importer is
  `LimesshMetadataImporter`; dead legacy decryption constants removed. Research notes,
  supplied APK names and the nested original fix module intentionally keep their names
  as provenance. No git rebase was performed (no target branch was given).
- **Research:** `research_notes/Limessh feature gap investigation/legacy-apk-map.md`
  (feature areas mapped to manifest components, packages, settings and resources;
  both APK hashes re-verified). Key fact: the original had **no** biometric or
  device-credential unlock (PIN lock only), 9 terminal themes, and filesystem key import.
- **Backlog:** `docs/MISSING_FEATURES.md` holds stable IDs, evidence, priorities and
  milestones M-A..M-F. Not built: graphify structural call graph (agent failed).
- **Fixes:** L-01 unlock (BiometricPrompt, planner, 3 policies, Lock now), T-01 eight
  terminal themes with **Retro green kept as default** (user request), K-01 key import
  (file/paste, format and encryption detection, validation, fingerprint, public key),
  plus identity deletion now removes stored credentials.
- **Verification:** `build.sh --ci --no-daemon --max-workers 2` passes: **53 JVM tests**
  (was 32), lint, instrumentation compile, debug APK, v2 signature verified. **No device
  was available, so unlock/theme/key-import behavior is untested on Android.**

## Latest authentication update — password and private key

After the crypto fix the user reported `Exhausted available authentication
methods`, and confirmed using both password and private-key login. That generic
message alone does not establish whether their credentials, selected identity,
server policy or client handling caused the rejection.

- Removed silent `root`/empty-password fallback. A valid, explicitly selected
  identity and nonblank username are now required; usernames are trimmed.
- Password login prompts when a stored password is absent and supports actual
  keyboard-interactive prompts. Only one recognizable password prompt may be
  auto-filled; OTPs, echo-enabled prompts and second factors are not auto-filled.
- Private-key parsing requests a missing passphrase, validates the key before
  authentication and reports key-format/passphrase errors without exposing key
  text or library exception contents. A server-accepted key may continue with a
  required account password/interactive factor. A rejected key does not silently
  fall back to password authentication.
- Authentication errors now include the username, selected method and remaining
  methods reported by the server, with partial-success guidance. Passwords,
  passphrases, private keys and raw library errors are not included in UI errors.
- Connection editing shows the selected username/method and links to identity
  editing. Failed connections show login metadata, Edit login and Retry controls;
  cancelling a challenge produces a retryable error.
- Added five policy/diagnostic unit tests and eleven real SSH authentication
  tests using an isolated loopback Apache MINA server. Tests cover password,
  prompted password, RSA PKCS#8, encrypted PEM/passphrase, OpenSSH Ed25519,
  keyboard-interactive password+OTP, required key+password, rejected credentials,
  and preserving accepted-key diagnostics after a failed second factor.
  MINA and its optional EdDSA provider are test-only dependencies, not app runtime
  dependencies. No external host or real user credentials are used by these tests.
- `JAVA_HOME=/usr/lib/jvm/temurin-21-jdk-amd64 bash build.sh --ci --no-daemon --max-workers 2`
  passes: **32 JVM tests**, Android lint, instrumentation compilation and debug
  APK assembly. Actual Android/target-server login still requires user retest.
  The release APK was not rebuilt in this authentication fix pass.

## Latest connection fix — Android X25519 / BC

The user reported `Connection failed: no such algorithm: X25519 for provider BC`
on an Android connection attempt. Android's reduced built-in provider uses the
same `BC` name as the bundled full BouncyCastle library. SSHJ 0.40.0 can probe a
new provider instance but select the existing reduced provider by name.

Added `ssh/SshCrypto.kt` and invoke it before constructing each `SSHClient`.
It replaces a non-bundled `BC` registration with the full bundled provider and
explicitly configures SSHJ to use it. Other platform providers retain their
relative ordering; AndroidKeyStore is not replaced. Initialization is synchronized
and reuses an already-installed bundled provider. Curve25519 and host-key
verification remain enabled.

Added three JVM regression tests: reproduce the same-name provider collision,
perform matching bidirectional X25519 agreements, and verify repeat initialization
does not replace/reorder providers. Added an Android instrumentation test for
X25519 plus AndroidKeyStore preservation.

Executed `JAVA_HOME=/usr/lib/jvm/temurin-21-jdk-amd64 bash build.sh --ci --no-daemon --max-workers 2`:
**16 JVM tests passed**, lint passed with existing warnings, Android test code
compiled, and the corrected debug APK was rebuilt and its v2 signature verified.
No device was connected to ADB, so the actual Android/server connection still
needs the user's retest after installing the new debug APK. The release variant
was not rebuilt in this fix pass.

## Current implementation result — 2026-10-19

The user confirmed the new project name is **limessh** and requested app code
and the researched plugin/extension workflows. See
[IMPLEMENTATION_STATUS.md](IMPLEMENTATION_STATUS.md) for current behavior,
plugin protocols and explicitly outstanding work.

Implemented/repaired the existing Kotlin/Compose app: connection/editor routes,
session reuse/list/disconnect, real SSHJ API calls, keyboard-interactive prompts,
SHA-256 host fingerprints, terminal UTF-8/alternate-buffer handling, local/remote/
SOCKS5 forwarding, SFTP document transfers, RSA identity generation, saved commands
and group execution, connection-scoped autostart snippets, inactivity lock,
font/scrollback preferences and pinned connection shortcuts. Room schema v2 adds
snippet connection associations with a 1→2 migration and generated schema export.

The Extensions screen exposes monitor/knock/audit/diagnostic/NVIDIA/ZFS/Openpyn
adapters. Added a new permission-checked v2 data provider and UID-bound Messenger
session API, a scoped/revocable Tasker/Locale action, and OpenSSH metadata export.
These are independent workflow implementations, not verified ports of original
plugin APKs. Original signing/package restrictions still apply.

Replaced empty backup arrays and count-only restore with real encrypted,
transactional configuration backup/restore. Credentials and automation grants
are excluded. JSON migration is explicitly metadata-only; removed the false
claim that decrypted private keys had been stored. Fixed identity save navigation
to wait for the operation to complete.

### Executed validation

- `:app:testDebugUnitTest`: **13 tests passed**, covering terminal stream behavior,
  strict knock parsing, VPN argument validation and OpenSSH export.
- `:app:compileDebugAndroidTestKotlin`: passed. Backup round-trip, wrong-passphrase
  and tamper test source compiles; **not executed on Android**.
- `:app:assembleDebug`: passed, APK at
  `app/build/outputs/apk/debug/app-debug.apk`, package `cz.opentree.limessh`,
  version `0.1.0-dev`, min SDK 26.
- `:app:lintDebug`: passed with warnings. Fixed the API-35-only `removeFirst`
  call that would otherwise break older devices. Dependency/version/resource
  and exported-component warnings remain; permission/token enforcement is in
  code and still needs runtime isolation tests.
- `build-local.py --test`: passed with the actual SDK/JDK and existing build
  outputs. The script also rejects a JRE without a JDK compiler.
- `apksigner verify --verbose`: APK verifies using v2 signing (debug certificate).
- `git diff --check`: passed.
- `adb devices`: no devices/emulators connected. No SSH login, Android UI, Tasker,
  forwarding, SFTP or Android backup runtime test was performed.

Initial verification used a downloaded JDK and Android SDK under `/tmp/opencode`.
The subsequent local setup uses the installed Temurin JDK at
`/usr/lib/jvm/temurin-21-jdk-amd64` and a persistent Android SDK at
`/home/lukas/Android/Sdk`. The checkout's ignored `local.properties` selects that
SDK. No shell startup files were changed. Rebuild using `build.sh` with an
exported `JAVA_HOME`; see [BUILDING.md](BUILDING.md).
BouncyCastle's duplicate OSGi metadata required a packaging exclusion;
LICENSE/NOTICE resources are merged instead of discarded.

Existing uncommitted app/UI work was incorporated and preserved. The two original
APKs and nested OfflineProFix repository were not modified. No commit, signing-key
publication or release was performed. Cloud sync/teams/EC2, native transport
extensions and original binary plugin compatibility remain outstanding.

### Build scripts, CI and knowledge-base update — 2026-10-19

- Extended `build-local.py`/`build.sh` with `--ci`, `--lint`, `--release`,
  `--no-daemon`, `--max-workers`, version overrides and SDK package listing.
  Gradle accepts `limessh.versionName`/`limessh.versionCode` overrides.
- Added eight standard-library Python regression tests in `tests/`.
- Added a shared GitHub setup action using Temurin 21, Python 3.12 and the helper's
  SDK package list (Platform 35 / Build Tools 34.0.0).
- Reworked build/release workflows so tests and lint block publication, artifact
  paths are explicit, reports upload on failure, and tag versions reach the APK.
  Optional publisher signing uses scoped secrets, temporary-key cleanup and
  verified, accurately named signed/unsigned assets plus SHA-256 checksums.
- The first R8 release build exposed optional desktop GSS/JAAS references and
  compile-time Error Prone annotations. Added narrow documented `dontwarn`
  rules in `app/proguard-rules.pro`; no blanket missing-class suppression.
- Executed successfully with the persistent toolchain:
  `JAVA_HOME=/usr/lib/jvm/temurin-21-jdk-amd64 bash build.sh --ci --release --no-daemon --max-workers 2`.
  Debug APK and **minified unsigned release APK** now build. Existing 13 JVM
  tests and lint pass; Android instrumentation compiles but is not executed.
- Eight Python tests, ShellCheck, actionlint and `git diff --check` passed;
  debug APK signature verification passed. No GitHub-hosted run or publisher
  signing was executed, and no commit/push/tag/release was created.
- See `docs/BUILDING.md` for local setup, troubleshooting and CI/release recipes.
  The opentree vault project note and Build and CI note are maintained under
  `projects/juicessh/`, preserving the existing research-project location.

## Earlier foundation result — 2026-10-18

**LimeSSH app foundation created with full branding.** Kotlin/Compose project at `cz.opentree.limessh` with SSHJ 0.40.0, Room database, domain models, SSH engine adapter, foreground service, navigation, retro green theme, lime logo, and placeholder terminal screen. Remote configured at `git@github.com:opentreecz/limessh.git`. Requires Android SDK to build and has not been runtime-tested.

Research complete: feasibility report, artifact analysis, legal research, plugin SDK contract inspection (all AIDL/provider bindings cataloged), SSH library evaluation, and Android platform requirements documented.

Recommended route: independently implemented, local-first client using licensed upstream components (SSHJ, BouncyCastle, Room, Compose) with retro green branding distinct from JuiceSSH's yellow. Research exposure to decompiled material is recorded; **do not call the entire project clean-room**. No permission email has been sent and no rightsholder permission has been obtained.

## Files to read when resuming

| File / directory | Purpose |
|---|---|
| [README.md](../README.md) | Entry point and scope |
| [reports/JuiceSSH revival feasibility.md](../reports/JuiceSSH%20revival%20feasibility.md) | Final cited synthesis and actual analyst reproduction commands |
| [ROADMAP.md](ROADMAP.md) | User decisions, stage gates and acceptance criteria |
| [FEATURE_MATRIX.md](FEATURE_MATRIX.md) | Requested Pro/local features, other historical capabilities and plugin links |
| [ARCHITECTURE.md](ARCHITECTURE.md) | Proposed identity, SSH/terminal, lifecycle, storage/crypto, migration and plugins |
| [artifact-analysis.md](../research_notes/JuiceSSH%20revival%20feasibility/artifact-analysis.md) | Static APK/module evidence, hashes, tooling, hooks and limitations |
| [history-and-plugins.md](../research_notes/JuiceSSH%20revival%20feasibility/history-and-plugins.md) | Timeline, plugin/SDK inventory, public URLs and discovery scope |
| [licensing-and-permission.md](../research_notes/JuiceSSH%20revival%20feasibility/licensing-and-permission.md) | Preliminary legal research and complete unsent permission draft |
| [plugin-contracts.md](../research_notes/JuiceSSH%20implementation%20groundwork/plugin-contracts.md) | AIDL/provider contract analysis from public SDK |
| [components-and-android.md](../research_notes/JuiceSSH%20implementation%20groundwork/components-and-android.md) | SSH library comparison, terminal candidates, Android requirements |
| `app/` | Android app foundation (Kotlin/Compose/SSHJ/Room) |
| `build.gradle.kts`, `settings.gradle.kts`, `gradle/` | Gradle build configuration |
| `research_notes/JuiceSSH revival feasibility/{analyze_artifacts.py,dex_evidence.py,native_inventory.py,VerifyApks.java}` | Existing original static-analysis helpers; not successor application code |
| `.artifact-analysis/` | Ignored private generated evidence; local links need these files or reproduction |
| Two root APKs and `JuiceSSHOfflineProFix/` | User's original inputs; preserve unchanged |

## Established evidence

- Main APK: `com.sonelli.juicessh` 3.2.2/200, min 26/target 29, SHA-256 `167d3afb1c832698ca512d9bf418c341a6f6e441bc64f57aaa1b264d47a8d64b`.
- Fix APK: `org.lyf.juicesshofflinepro` 1.0/1, min 26/target 36, SHA-256 `5dea4033623bc6562fe388c4f47e9df6cd2643327138b0f10578ef6f171a267d`.
- Analyst recorded both APK signatures valid; main JADX output partial with 26 errors, fix JADX successful; native files inventoried, not fully reversed. Static parse/signature checks are not runtime tests.
- Inherited module HEAD recorded as `d4af690e27bbe94355f49cdc56b411b7c2f1ab8a`; its APK embeds a different revision with later manifest content. No byte-for-byte source rebuild established. Module README states AGPL-3.0-or-later; that does not license JuiceSSH.
- Five fix hooks alter local entitlement/signature/lifetime/user acquisition. They do not recover server authentication or cloud services. No ownership-verification check found in the module.
- Legacy data is ORMLite/SQLite schema 55 with selected encrypted fields. Observed crypto helper uses AES-256-CBC, PBKDF2-HMAC-SHA1/1,000 and no MAC in that helper; new crypto must be independently specified.
- Public SDK and three functional official plugin repositories plus Example are Apache-2.0 sources. Tasker source/license is missing; other community plugins have varying evidence/licensing. Inventory is bounded, not exhaustive.
- Latest observed main version dates to 2021; tracker records Play removal in December 2025. Entitlement failures are reports, not independently reproduced. No authoritative all-services shutdown established.
- Sonelli GitHub provides `support@sonelli.com`; Companies House 07878261 was active in the legal research. Neither fact proves present authority to license all IP.

All facts above trace to the linked analyst notes; follow their specific source links before expanding claims. The legal analyst did not inspect the module; use the separate artifact note for its actual license/mechanism. The synthesis did not rerun decompilation, download plugins, contact services or repeat web discovery.

## Blockers and unknowns

1. User approval of application implementation and decisions in ROADMAP.md are outstanding.
2. No proprietary host source/asset license or written permission; exact purchase terms, lawful acquisition evidence, jurisdictions and rights-holder authority unresolved.
3. No migration database/export/passphrase fixture; key DB import method is not decompiled. No import round trip demonstrated.
4. No plugin APK authentication/install tests; renamed package/authority/signature restrictions prevent assumed drop-in compatibility. FreeNAS package collision and Tasker source absence need attention.
5. No selected SSH/terminal dependency, Android baseline, publisher identity, project license or sync backend. New candidates are proposals, not audited selections.
6. No runtime, battery/background, accessibility, IME, rendering, native page-size or backend tests. Android documentation fetches failed in analyst work; current policies need primary-source recheck.
7. No full security audit of host-key verification, algorithms, TLS, sensitive logging, provider/SFTP receiver checks or team crypto. Do not turn audit targets into proven vulnerabilities.

## Next actions

1. **Build verification**: Run Gradle sync/build on a machine with Android SDK to validate the foundation compiles.
2. **Terminal emulator**: Integrate ConnectBot's terminal view (Apache-2.0) or evaluate cbssh's terminal components.
3. **First SSH connection**: Wire up SshEngine through the UI to achieve one real SSH login with host-key verification.
4. **Connection CRUD**: Implement add/edit/delete connection dialogs.
5. **Identity management**: Password and public key authentication UI and encrypted storage.
6. **Port forwarding**: Local, remote, and SOCKS forwarding with UI controls.
7. **Snippets and autostart**: Snippet management and auto-execute on connection.
8. **Widget and shortcuts**: Home screen widget for connections and port forwards.
9. **Inactivity lock**: Screen lock timeout with configurable behavior.
10. **Plugin SDK v2**: Design new versioned plugin API inspired by but independent from the Sonelli SDK.
11. **Migration importer**: Parse legacy JuiceSSH database/export with user-supplied fixture.
12. **Product identity**: Choose the project name, application ID, and branding.
13. **Permission inquiry**: Review and optionally send the unsent permission draft to Sonelli.

## Preservation and validation record

At synthesis start, Git showed the supplied APKs, nested repository, `.gitignore` and research notes untracked; README was tracked. Treat those inputs as existing user/research work. The only existing file edited by this synthesis is README; other deliverables are new Markdown files. `.gitignore` already excludes only `/.artifact-analysis/`, **not root APKs**. No blanket staging, license addition or commit is authorized.

Analyst checks recorded: APK signatures/inventory, manifest/DEX/native extraction, helper syntax compilation and ignored evidence path; nested working tree remained clean. Synthesis checks passed: `git diff --check`, whitespace validation across all six Markdown deliverables, and existence checks for 68 local file-link targets (not heading-anchor or external-URL verification). Both original APK hashes matched the recorded values, the nested repository was clean at the recorded HEAD, and `git check-ignore` confirmed the evidence exclusion. These are documentation/preservation checks, not app tests. External URLs are inherited citations and were not freshly revalidated in synthesis. Local ignored evidence is intentionally unavailable in a docs-only checkout until regenerated.
