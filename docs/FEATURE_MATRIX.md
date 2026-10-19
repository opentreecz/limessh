# Feature and plugin matrix

**Status: requirements and evidence only; no successor feature is implemented or runtime-tested.** “Historical” means advertised in recovered material; “observed” means static evidence in the supplied artifact. Neither establishes present service operation.

Evidence keys: [S — official historical store text](https://github.com/Sonelli/juicessh-translations/blob/master/en_US/STORE-LISTING), [F — archived first-party features](https://web.archive.org/web/20240318221739id_/https://juicessh.com/partials/features), [A — artifact analysis](../research_notes/JuiceSSH%20revival%20feasibility/artifact-analysis.md), [H — historical/plugin research](../research_notes/JuiceSSH%20revival%20feasibility/history-and-plugins.md). Phase numbers refer to [ROADMAP.md](ROADMAP.md). Acceptance criteria are proposed successor behavior, not claims about the old app.

## Requested features and other Pro capabilities

| Capability | Historical/static evidence | Proposed delivery and acceptance | Dependencies / open questions |
|---|---|---|---|
| Connection/group widget | Pro; frequent connections, selected group, forward access (S/F) | Phase 3: original widget opens correct connection/group; handles deleted items and locked state | Android widget/background launch behavior; no credential exposure in widget payload |
| Local forwarding | Pro; app/widget launch and optional browser launch (S/F); gated menu (A) | Phase 3: loopback listener forwards through SSH, cleans up on disconnect; browser opens only after successful setup | Bind-address defaults, port conflicts, explicit non-loopback consent |
| Remote forwarding | Explicitly named (F) | Phase 3: remote listener forwards to selected local target; deny/failure and cancellation paths tested | Server `AllowTcpForwarding`/`GatewayPorts`; remote exposure must be visible |
| Dynamic SOCKS forwarding | Explicitly named (F) | Phase 3: test SOCKS proxy requests and close behavior; define DNS resolution semantics | Protocol/version and supported address types are new spec decisions, not established legacy details |
| Snippets and scripts | Pro library (S); scripts and host-connect auto-execution (F); models (A) | Phase 3: store exact text and associations; execute manually; opt-in autostart with reconnect policy and visible execution | Commands can mutate remote state; define once-per-session behavior, cancellation, output/exit status and secret handling |
| AES-256 multi-device sync | CloudSync advertised (S/F); mixed encrypted records/metadata (A) | Phase 6: new AES-256-GCM envelope; two-device conflict/deletion tests and key-recovery policy | Transport undecided; no restored Sonelli backend; AES key size alone is not a security guarantee |
| Automatic encrypted backup | AES-256 backups advertised (S) | Phase 6 before sync: scheduled export plus verified restore on a clean install | Explicit destination, retention, passphrase/key derivation, loss recovery |
| Inactivity lock | Pro inactivity protection (S) | Phase 3: configurable timeout, background/foreground and reboot behavior; widget/plugin/deep-link entry obeys lock policy | Decide whether existing SSH sessions continue; screen lock is not automatically key erasure |
| Home-screen shortcuts | Static Pro-gated creation and configuration checks (A) | Phase 3: pinned shortcuts launch stable connection IDs and respect lock/deletion | Historical gate not a separate store-text category; use current Android shortcut APIs |
| AWS EC2 / EC2Link | Instance import/sync and grouping by class/security group (S/F); service/models (A) | Phase 6 separately approved: scoped AWS auth, pagination, grouping, removal/reconciliation tests | Current AWS behavior and credential strategy untested; no assumed compatibility with legacy account flow |
| TeamShare | AES-256-encrypted group sharing (S/F); team key/models (A) | Phase 6 separate design: invitations, membership, revocation and rotation tests | Backend, roles, key distribution and metadata privacy unresolved; no claim that old sharing can be recovered |
| Other entitlement branches | Sharing, terminal/identity UI, cloud and EC2 call sites inspected (A) | Specify observable behavior before promising parity | Partial gate map; not enough evidence to invent additional named paid products |

## Baseline UX and transport requirements

| Capability | Evidence/classification | Successor target / caveat |
|---|---|---|
| Full-color terminal, special keys, font sizing, external keyboards, tmux/screen gestures | Historically baseline (S) | Phase 2–3: original controls with Unicode, resize, IME, accessibility and keyboard tests; preserve workflows rather than copied pixels |
| Connections, identities, groups, IPv6, key authentication/generation, “via” connections | Historically baseline (S/H); data models observed (A) | Phase 2–3: host-key trust, credential references, jump-host policy, modern algorithm selection; no unsafe algorithm enabled merely for parity |
| Keyboard-interactive/two-factor and agent forwarding | Older store text (S) | Evaluate in phase 2; user decides agent-forwarding scope and exposure policy |
| Concurrent/background sessions, links, clipboard, transcripts, compression | Baseline store text (S) | Phase 3: lifecycle and redaction controls; scoped transcript export; no claim all details are recovered |
| Themes and selectable fonts | Baseline text and 3.2.2 listing (H) | Original theme assets/copy; ambiguous Free/Pro checkmarks do not prove every theme is paid |
| Local shell, Mosh, Telnet | Historical baseline (S); packaged adapters/native files (A) | Separately prioritize; local shell is app-sandbox execution, Mosh has native/lifecycle costs, Telnet is cleartext and should be explicitly opt-in |
| SFTP/SCP UI | SFTP SDK/services observed, signature restriction (A/H) | Unverified as a shipped plugin/Pro browser; treat as optional new scope, not recovered parity |
| Tasker automation | Separate product, not established as bundled Pro (H) | Phase 5: independently specify session/script/forward actions; output/variables require new requirements, not review-based assumptions |

## Bounded plugin inventory

The [full discovery inventory](../research_notes/JuiceSSH%20revival%20feasibility/history-and-plugins.md#plugin-recovery-table) records packages, licensing evidence, mirrors and release metadata. No plugin APK in this table was installed or authenticated during the web research. “Asset listed” does not mean downloaded; repository license metadata is not a dependency-level audit. No complete official catalog or exhaustive private/deleted/fork inventory was recovered.

| Plugin / extension | Source / inventory link | Evidence and next target |
|---|---|---|
| Performance Monitor | [Official](https://github.com/Sonelli/juicessh-performancemonitor) | Apache-2.0 source; first functional port after Example; historical mirror listing |
| PortKnocker | [Official](https://github.com/Sonelli/juicessh-portknocker) | Apache-2.0; `com.sonelli.portknocker`; test TCP/UDP sequence timing |
| Plugin Audit Log | [Official](https://github.com/Sonelli/juicessh-auditlog) | Apache-2.0; host action logs, not SSH transcripts; design redacted audit schema |
| Tasker Plugin | [Historical listing](https://apkpure.com/juicessh-tasker-plugin/com.sonelli.juicessh.tasker) | Source/license not found; 1.0.2; separate integration specification needed |
| Plugin Example | [Official](https://github.com/Sonelli/juicessh-pluginexample) | Apache-2.0; first API-contract port, not a retail feature |
| FreeNAS Monitor | [Source](https://github.com/bpvelloso/freenasmonitor), [1.0.5 asset](https://github.com/bpvelloso/freenasmonitor/releases/tag/1.0.5) | Apache-2.0; source reuses official monitor package; inspect release manifest/signature |
| NVIDIA GPU Monitor | [Source](https://github.com/sds100/NvidiaGpuMonitor) | GPL-3.0 metadata; no GitHub releases returned; audit dependencies and command assumptions |
| Openpyn / NordVPN controller | [Source](https://github.com/1951FDG/openpyn-nordvpn-juiceSSH), [1.0.6 asset](https://github.com/1951FDG/openpyn-nordvpn-juiceSSH/releases/tag/1.0.6) | GPL-3.0 metadata; external APIs/tools; not proof of a generic OpenWrt plugin |
| Config Exporter | [Source](https://github.com/Jolt151/JuiceSSHConfigExporter) | No detected license; OpenSSH config output lead, not verified private-key recovery |
| Modernized Performance Monitor | [Source](https://github.com/smrinalsingh/juicessh-performancemonitor) | Apache-2.0; Android 15/16 claims untested |
| Improved Performance Monitor | [Candidate](https://github.com/joncv/juiceSSH-performanceMonitor) | Unknown license metadata; implementation/differences not inspected |
| GroupSnippet | [Placeholder](https://github.com/DavidEdwards/JuiceSSH-GroupSnippet) | MIT README/LICENSE only; no recovered implementation |
| OfflineProFix | [Upstream](https://github.com/li-yifei/JuiceSSHOfflineProFix), [local analysis](../research_notes/JuiceSSH%20revival%20feasibility/artifact-analysis.md) | AGPL-3.0-or-later module, Xposed rather than SDK; not part of successor architecture |

Supporting assets: [official SDK 1.0.13](https://github.com/Sonelli/juicessh-pluginlibrary), [Maven artifacts](https://github.com/Sonelli/maven), [SDK fork](https://github.com/1951FDG/juicessh-pluginlibrary), [gojuice](https://github.com/Sonelli/gojuice), [pyjuice](https://github.com/markus-li/pyjuice), [translations](https://github.com/Sonelli/juicessh-translations), and [keyboard diagnostic utility](https://github.com/Sonelli/android-keywatcher). These are not all plugins. Translation reuse lacks an established license; pyjuice is GPL-3.0-or-later and incomplete for bidirectional sync.

Additional monitor copies, SDK forks, unauthenticated client/revival projects and bypass-labelled candidates are recorded under [discovery results and exclusions](../research_notes/JuiceSSH%20revival%20feasibility/history-and-plugins.md#other-discovery-results-and-exclusions). No distinct Docker, generic OpenWrt or SFTP-browser plugin was verified. Compatibility must be recorded per concrete source revision or APK hash, host build and Android version, including whether original JuiceSSH can coexist.
