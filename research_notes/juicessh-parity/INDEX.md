# LimeSSH research: start here

Updated 2026-10-21. **R-011…R-013, R-016…R-021 implemented and verified (64 tests, 0 failures). Android SDK installed at /home/i314866/Android/Sdk.**

1. Read only this index, the assigned row in `WORK_QUEUE.csv`, and its task card.
2. Read that card's exact source slices. Reuse existing findings and cached analysis.
3. Follow `AGENT_PROTOCOL.md`; checkpoint before the session allowance is exhausted.

## Current state

- Main APK = JuiceSSH 3.2.2/200, SHA-256
  `167d3afb1c832698ca512d9bf418c341a6f6e441bc64f57aaa1b264d47a8d64b`.
- Fix APK = OfflineProFix 1.0/1, SHA-256
  `5dea4033623bc6562fe388c4f47e9df6cd2643327138b0f10578ef6f171a267d`.
- Fix has 10 DEX classes/five hooks; main app has 7,839 classes. Main app is the
  feature-research target. Hashes and cached DEX were rechecked during planning.
- `.artifact-analysis/` contains both extractions and JADX output. Reuse it; 26
  historical decompiler errors and native behavior remain coverage concerns.
- Working tree already contains substantial uncommitted app changes. HEAD alone
  does not identify the current implementation. R-000 recorded a 95-file implementation baseline; see `coverage/BASELINE.md`.
- `docs/MISSING_FEATURES.md` holds canonical gap IDs. `IMPLEMENTATION_STATUS.md`
  describes implemented paths. Older roadmap/session entries are historical.
- Latest existing notes report 53 JVM tests and no device validation. This planning
  session did not rerun app tests. Do not convert historical reports into fresh results.
- Biometric unlock is a new feature; PPK was not supported by the original app.
- Budget default: 8k–12k total tokens per research leaf, one worker, fresh context.
  Quota/actual usage unknown until measured. Stop and checkpoint; never auto-retry
  quota errors or open more agents to bypass limits.
- **Android SDK absent on current machine** (`/home/lukas/Android/Sdk`). R-011 and
  R-013 implementations need `JAVA_HOME=/usr/lib/jvm/temurin-21-jdk-amd64 bash build.sh --ci`
  on the machine with SDK to verify.

## Next work

1. **R-000 reviewed:** 61,540 inventory rows; 48,083 main-app defined methods.
2. **R-001 reviewed:** all 61 module records accounted; no module port; gate callers stay in W-23.
3. **R-010 reviewed & implemented (I-R-010):** Terminal device queries (TM-03) implemented and verified.
4. **R-011 spec_ready & implemented:** Scrollback viewer (TM-01) — `getRow()`, `getTranscriptText()` in emulator; scroll gesture + indicator in TerminalScreen. **Build unverified on this machine.**
5. **R-013 spec_ready & implemented:** Extra keys row (TM-04) — Ctrl/Alt toggle, pipe, tilde, PgUp/Dn, Home/End, F1–F4, Ctrl-Z/D/A/E/W/L. **Build unverified on this machine.**
6. **R-012 spec_ready:** Text selection/copy/paste (TM-02) — awaiting I-R-012 (depends on R-011 `getRow` API).
7. **R-012 implemented:** Text selection/copy/paste/share — long-press → transcript `AlertDialog` + `SelectionContainer`; paste button; share via `ACTION_SEND`.
8. **R-016 implemented:** `ssh://` URI handling — `SshQuickConnect` in `MainActivity`, quick-connect dialog in `AppNavigation`, pre-fill for `ConnectionEditScreen`.
9. **R-017 implemented:** Known-hosts management UI — `KnownHostsScreen`, `deleteKnownHost` in repository, "Known hosts" item in Settings.
10. **Next priority:** Compile and test all on machine with SDK. Next research leaves: R-014 (TM-07 parser modes), R-018 (C-04 reconnect/keepalive), R-019 (C-02 jump host), R-020 (K-03/K-05 key export/gen).

Workers edit their assigned card; the coordinator owns the queue. Save canonical
state in the repository before syncing a short Obsidian handoff. Application code
changes belong to subsequent implementation tasks.

## Links

- [Full plan](../../docs/RESEARCH_PLAN.md)
- [Queue](WORK_QUEUE.csv)
- [Agent prompts](AGENT_PROTOCOL.md)
- [Task template](templates/task.md) and [handoff template](templates/handoff.md)
- [Current gaps](../../docs/MISSING_FEATURES.md)
- [Existing legacy map](../Limessh%20feature%20gap%20investigation/legacy-apk-map.md)
- Obsidian: `projects/juicessh/Research/Research programme.md`

The complete method/resource index is in ignored `.artifact-analysis/parity/`.
See [reviewed baseline](coverage/BASELINE.md) and [residual owners](coverage/residuals.csv).
Ownership is provisional; 3,432 main classes remain unknown. No behavioral parity
is claimed. R-001/R-010 cards now include exact entry points.

R-001 result: [reviewed module audit](tasks/R-001.md) and
[61 item dispositions](coverage/R-001-dispositions.csv). Runtime behavior and
exact source-to-binary build provenance remain unverified.
