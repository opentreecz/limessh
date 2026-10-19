# Session memory — LimeSSH (formerly JuiceSSH revival feasibility)

Last updated: 2026-10-18 (branding and implementation session).

## Current result

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
