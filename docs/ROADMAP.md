# Successor roadmap — approval required

Status: **research workspace prepared, application implementation not approved or started** (2026-10-18). No successor Android app/build or runtime tests exist. Stages below are proposals; completion of documentation does not satisfy later implementation criteria.

## Decisions before application implementation

| Decision for user | Proposed default | What must be recorded |
|---|---|---|
| Revival route | Independently implemented, renamed client; pursue permission in parallel if desired | Independent route versus waiting for authorized source reuse; record known decompilation exposure |
| Product identity | New name, owned application-ID namespace and signing identity | User-selected name/domain, branding review and publisher; no final identity chosen here |
| UX scope | Preserve workflows using original expression | Priority screens/gestures and lawful observation opportunities; exact assets require permission |
| First release | Local SSH, identities/groups, terminal, forwards, snippets, lock, shortcuts/widget | Ordering and whether local shell/Mosh/agent forwarding are required initially |
| Devices/distribution | Modern supported Android baseline, arm64 first for native evaluation | Minimum/target SDK, device matrix, Play/F-Droid/direct distribution, territories and accessibility requirements |
| Components and licensing | Maintained upstream SSH and terminal components | Acceptable copyleft obligations and future project license decision; no license assigned yet |
| Migration | Explicit user-authorized import | Available export/database sample, passphrase context and acceptable unsupported fields; no private database access assumed |
| Plugins | New SDK and licensed source ports before binary compatibility | Priority plugins and whether old APK compatibility/coexistence is essential |
| Sync and teams | Optional later features; no Sonelli endpoint dependency | Self-hosted/managed/file transport, metadata/privacy requirements, recovery and sharing scope |
| Permissions and legal scope | Document acquisition/terms and obtain scoped advice | Developer/publisher jurisdictions; whether user wants to send the unsent permission request |

**Approval gate:** user approves the route, first implementation slice, component-evaluation plan and unresolved scope exclusions explicitly. Architecture choices below remain proposals until then. Approval of this documentation task is not approval to create an Android scaffold.

## Stages and acceptance criteria

| Stage | Deliverable / concrete targets | Acceptance criteria | Current status |
|---|---|---|---|
| 0 — Evidence baseline | Final report, matrix, architecture, session record; preserve two APKs and nested source | Claims trace to sources; artifact hashes and analysis commands recorded; incomplete work labelled; proprietary output stays outside reports | Documentation prepared; analyst static results recorded |
| 1 — Rights and behavioral specification | Acquisition/terms record; permission inquiry if authorized; prioritized workflow specification; exposure/provenance log; inspect public SDK 1.0.13 and exact licenses | Scope of lawful research/reuse recorded; no unknown-license input approved for reuse; user approves implementation brief and identity direction | Pending user decisions |
| 2 — Component evaluation and first SSH slice | After approval only: evaluate SSHJ versus a maintained libssh/JNI approach; evaluate upstream terminal engines; original terminal/connection screen | Reproducible build; one real SSH login; correct first-use and changed-host-key handling; password/key/keyboard-interactive evaluation; terminal resize, Unicode, IME and disconnect tests; dependency decisions documented | Not started |
| 3 — Local feature parity | Connection/identity/group models; concurrent sessions; local/remote/SOCKS forwarding; snippets/autostart; shortcuts/widget; inactivity lock | Matrix's local acceptance criteria pass on agreed devices, including background/lock/network transitions; no cloud/billing prerequisite for local features | Not started |
| 4 — Explicit migration | Acquire redacted user-owned fixture; use public gojuice/SDK evidence first; resolve only necessary missing import semantics | Fixture import report covers counts, associations, host keys, secrets and unsupported fields; wrong-passphrase/malformed input fail safely; rollback and duplicate handling tested | Blocked by fixtures and incomplete legacy import understanding |
| 5 — Plugin ecosystem | Versioned new SDK; port Example then Performance Monitor, Audit Log and PortKnocker; assess Tasker automation separately | Consent/caller isolation tests pass; sample works; exact dependency/license inventory exists; compatibility claims limited to tested plugin version/hash/OS combinations | Not started; no plugin APK tests |
| 6 — Backup and optional services | Encrypted export/restore first; then selected sync transport, conflict/deletion design; separate TeamShare and EC2 proposals | Independent cryptographic review; restore on a second device; conflicts, deletion propagation and lost-key behavior tested; team revocation/rotation tests before team claims | Design only; no backend selected |
| 7 — Release readiness | Accessibility/performance/background review, dependency notices, branding/legal review, reproducible release and signing procedures | Agreed Android/device/page-size matrix passes; threat model and release provenance reviewed; distribution policies checked at release date | Not started |

Stages 4 and 5 can proceed independently after a stable approved core, subject to their own evidence gates. Cloud and team functionality is not a hidden dependency of local feature delivery. No dates or effort estimates imply that unknown compatibility work is already solved.

## Immediate research targets

1. User selects route, first-release priorities and distribution territories; confirms legitimate acquisition and terms privately.
2. Review and, only if authorized, send the [permission draft](../research_notes/JuiceSSH%20revival%20feasibility/licensing-and-permission.md#draft-permission-email--not-sent). Confirm current rightsholder authority and scope; lack of response grants no rights.
3. Obtain one sanitized user-owned export and a documented passphrase fixture. Separate record structure tests from real credentials and receipts.
4. Inspect exact licensed SDK/AIDL sources and official Example before further proprietary analysis; compare hardcoded package/service/authority assumptions and signature restrictions.
5. Pin candidate SSH/terminal revisions and assess maintenance, Android support, algorithms, licensing and JNI/native requirements. Do not import code until the implementation plan is approved.
6. Revisit current Android foreground-service, exported-component, storage and 16 KiB requirements from primary documentation; prior fetches failed, so current policy claims are unresolved.
7. For each desired plugin, collect source revision or release APK provenance and plan explicit authorized runtime tests. Resolve FreeNAS package collision and Tasker source/license absence rather than assuming compatibility.

## Sources and continuation

See [final report](../reports/JuiceSSH%20revival%20feasibility.md), [feature matrix](FEATURE_MATRIX.md), [architecture](ARCHITECTURE.md), [session memory](SESSION_MEMORY.md), and the [artifact](../research_notes/JuiceSSH%20revival%20feasibility/artifact-analysis.md), [history/plugin](../research_notes/JuiceSSH%20revival%20feasibility/history-and-plugins.md) and [legal](../research_notes/JuiceSSH%20revival%20feasibility/licensing-and-permission.md) research notes. This roadmap is an engineering proposal, not permission to reuse the proprietary application.
