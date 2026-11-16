# JuiceSSH → LimeSSH: research in resumable batches

Prepared 2026-10-20. Scope: prepare the research and implementation process; this
document does not claim that deep research, parity implementation or device testing
has finished. Start at [the compact index](../research_notes/juicessh-parity/INDEX.md).

## 1. What we are researching

The main application is
`com.sonelli.juicessh_3.2.2-200_minAPI26(arm64-v8a,armeabi-v7a,x86,x86_64)(nodpi)_apkmirror.com.apk`.
`JuiceSSHOfflineProFix-v1.0-xposed82-release.apk` is a separate Xposed module. Its five
hooks change local entitlement/session checks; it contains no SSH or terminal
implementation. Give the module a small, complete audit and use the main APK for
feature reconstruction.

| Input | Bytes | SHA-256 | Scope |
|---|---:|---|---|
| Main APK 3.2.2 / 200 | 24,805,394 | `167d3afb1c832698ca512d9bf418c341a6f6e441bc64f57aaa1b264d47a8d64b` | 7,839 DEX classes; application, dependencies, resources and native code |
| Fix APK 1.0 / 1 | 15,200 | `5dea4033623bc6562fe388c4f47e9df6cd2643327138b0f10578ef6f171a267d` | 10 DEX classes; settings, Xposed entry point and hooks |

Hashes and cached DEX identity were rechecked during planning. Existing analysis:
[artifact evidence](../research_notes/JuiceSSH%20revival%20feasibility/artifact-analysis.md)
and [feature map](../research_notes/Limessh%20feature%20gap%20investigation/legacy-apk-map.md).
Main APK method-ID count 55,362 includes references, **not** just defined methods.
Its 4,439 generated Java files are not a substitute for the DEX class inventory.
The 40 `lib/` entries cover four ABIs: 36 ELF files and four bashrc files. Include
native blobs elsewhere in the archive too. Historical JADX analysis had 26 errors;
`DB.c(...)` is a known incomplete import/merge routine. Later fallback caches need
reconciliation before assuming every historical failure remains unresolved.

The objective is **complete accounting of the supplied artifacts and specified,
tested LimeSSH behaviors**. Every item receives a disposition. Application behavior
is independently implemented; library internals normally map to maintained
dependencies. Generated code, duplicate ABI implementations, historical purchase
checks and absent server implementations still receive explicit records. They must
not disappear silently or be presented as implemented features. Preserve existing
scope decisions in the backlog and record any proposed change separately.

## 2. Reuse the knowledge already available

| Source | How to use it |
|---|---|
| `docs/MISSING_FEATURES.md` | Existing feature IDs and milestones M-A…M-F; extend these IDs rather than inventing a competing backlog |
| `docs/IMPLEMENTATION_STATUS.md` and current app files | Baseline of implemented paths; recheck only files affected by a task |
| `docs/SESSION_MEMORY.md` | Dated history; older entries contain superseded plans and test totals |
| `research_notes/JuiceSSH revival feasibility/` | Hashes, manifest, hooks, crypto/data, native inventory, public plugin research and analysis helpers |
| `research_notes/JuiceSSH implementation groundwork/plugin-contracts.md` | Existing public SDK contract research |
| `research_notes/Limessh feature gap investigation/legacy-apk-map.md` | Feature-to-class/resource starting points |
| `.artifact-analysis/` | Ignored local evidence, extracted APKs, manifests, inventories and JADX output; reuse before regenerating |
| Obsidian `projects/juicessh/` | Existing overview, gap map and build notes, plus the new research entry point |

The connected vault currently exposes three existing project overview notes; much
of their detailed evidence is linked to repository files. Keep those links and the
historical folder name. Older roadmap/library/platform proposals are historical,
not current verification. Resolve conflicting claims with dated evidence and the
current source. Platform/dependency recommendations require fresh primary-source
checking when a task depends on them; this plan makes no new version-policy claim.

L-01 unlock, T-01 themes and K-01 key import already have implementations recorded.
The original app had PIN lock rather than biometric unlock; its strings explicitly
excluded PuTTY PPK. A standalone legacy SFTP browser is not established. Avoid
researching these as if all were missing original features.

## 3. Budget and scheduling

**Provisional default: 8,000–12,000 total tokens per research leaf, one active
research worker.** This is a planning target until the user supplies a quota and
provider usage is observable. It includes input, output and reasoning where counted;
it is not an API-enforced cap or a guarantee about daily limits. Actual accounting
can include caching/model differences and usage outside this project.

- Give workers fresh context: compact index + one task card + exact evidence slices.
  Do not fork the entire project conversation or read the whole vault.
- Usually inspect 3–8 closely related files, bounded method ranges, or one difficult
  method. Read roughly 3,000–5,000 source tokens at most before reconsidering scope.
  Large files are never a reason to dump their whole contents.
- Target a result of 500–900 words, plus structured ledger rows and evidence links.
  A narrow child can use 4,000–6,000 tokens. These are estimates, not measured usage.
- Reserve about 25% of the target for checkpointing, recording and review. Checkpoint
  after a material finding or three substantial source reads, whichever occurs first.
- If there are more than two unresolved cross-domain dependencies, the question
  expands, or the budget is near exhaustion, save and split. One method may need
  several sessions. Never force an unsupported conclusion to fit a token budget.
- A worker cannot spawn more workers. The coordinator may assign the next worker
  after the previous checkpoint is durable. Parallel workers share the allowance;
  use them only when a known remaining allowance and independent work justify it.
- A quota error stops dispatch and retries. Resume the same checkpoint after the
  allowance returns. A context reset or a new agent does not reset account usage.
- Record provider-reported usage if available; otherwise write `unknown` and retain
  the estimate separately. Do not represent file size or word count as billed tokens.

If a daily usable allowance D is known, reserve at least 20% for coordination and
handoffs. Plan at most `floor(0.8 * D / (worker_target + review_target))` leaves, with
review typically budgeted at 1,000–2,000 tokens. Adjust against observed usage after
three leaves. With unknown allowance, run one leaf, checkpoint, then reassess.

The first pilot consists of R-000, R-001 and R-010, **sequentially**. Budget roughly
24k–36k worker tokens plus review if all three fit their initial sizes; spread them
over as many sessions/days as necessary. R-000 may split. A credible campaign total
requires the inventory and a measured pilot; workstream counts are not leaf counts.

## 4. Phases and concrete deliverables

| Phase | Work | Exit condition |
|---|---|---|
| 0 — Baseline and inventory | R-000: snapshot the dirty working tree, reconcile existing research, index cached evidence, register all artifact items | Every input has identity/provenance; complete denominators and unresolved ownership/failures are visible |
| 1 — Small pilot | R-001 fix-module audit; R-010 terminal device-query contract | Reviewed cards, tested handoff procedure and measured/unknown usage explicitly recorded |
| 2 — Research by behavior | Split workstreams W-01…W-24 into bounded leaf cards; prioritize M-B terminal and M-C reliability | Each selected leaf has evidence, requirements, failure cases, dependencies and acceptance tests |
| 3 — Incremental implementation | After each reviewed specification, implement its narrow LimeSSH change in a separate task | Relevant tests pass; code and requirement links recorded; device status remains separate |
| 4 — Residual sweep | Reconcile unassigned classes/methods/resources, dependency packages, native families, decompiler failures and all feature gates | No unaccounted items; unresolved or deferred items remain explicit rather than counted as parity |
| 5 — Runtime parity | Execute shared behavior scenarios against available original and successor builds, using controlled fixtures | Each selected behavior has results by app version/device/build, or a specific blocker |

Research and implementation can alternate after the pilot. Do not wait for all
7,839 classes to be deeply read before implementing a sufficiently specified
terminal behavior. Conversely, a successful APK build does not establish parity.
Existing M-A device validation can proceed independently when a device is available.

## 5. Complete coverage without reading the entire APK into context

R-000 creates **machine-generated indexes on disk**, returning only counts and
short filtered slices to agents. Use existing helper scripts and tools; preserve
tool version, binary hash and command. `/tmp/opencode/revtools/` is an expendable
cache, not durable provenance. Rebuild only missing or mismatched evidence.

Inventory all archive entries, DEX class definitions and **defined** method
signatures, manifest components and exported entry points, resource IDs/groups,
assets, native families/ABIs, reflective/JNI targets and decompiler failures. Keep a
full private index under `.artifact-analysis/parity/`; keep compact ledgers/specs
under `research_notes/juicessh-parity/`. A reproducible inventory script belongs in
the repository; generated proprietary code and raw binary dumps remain ignored.

Suggested inventory columns:

```text
item_id,artifact_sha256,kind,locator,parent_id,owner_classification,
classification_evidence,workstream_id,leaf_id,review_status,disposition,
evidence_card,uncertainty
```

Use stable IDs from APK hash + DEX descriptor/method signature, archive path,
resource ID, manifest component or native file hash/symbol. JADX path/line numbers
are secondary locators. Classify ownership as application / dependency / generated /
unknown; obfuscation under `com.sonelli` does not prove application ownership.

- Build a shallow reverse-reference index once. Follow one caller/callee hop as
  needed. Reflection, resources and native calls need separate references; a Java
  call graph is not exhaustive. A whole-repository graph tool is optional.
- Give each item one primary workstream; allow multiple behavior links without
  double-counting coverage. Split a large obfuscated class by signatures, keeping
  each child's membership explicit. Retain an unassigned/unknown bucket.
- For application method clusters, describe inputs, side effects, state transitions,
  errors, persistence and visible results. Follow meaningful branches beyond names
  or resource strings. A gate reveals a candidate feature, not complete behavior.
- For dependencies/generated code, record identification evidence and successor
  replacement/disposition; deeply inspect only behavior at application boundaries
  or a concrete unresolved requirement. Unknown ownership stays queued.
- For native code, start with Java/JNI contracts and one representative ABI per
  family. Register hashes for every ABI and verify differences; binary inequality
  across ABIs is expected and cannot establish behavioral equivalence by itself.
- For failed Java decompilation, inspect existing fallback/smali for just the method.
  Preserve unresolved control flow as an uncertainty and create a separate leaf.
  `DB.c` and native internals are not one-session tasks.
- For server features, capture all client contracts and failure states. Server
  implementation absent from the APK is an explicit unknown. Backend replacement
  decisions follow research; do not assume old endpoints work.

After every workstream, reconcile generated inventories against assigned IDs.
Report four separate measures: **accounted items / total**, **application behavior
clusters reviewed / total identified**, **requirements implemented / selected**,
and **runtime scenarios passed / planned**. Do not blend them into one completion
percentage. Documented deferral counts as accounted, never implemented or verified.
All-component coverage also requires a resource/settings/intent surface sweep and
an all-call-site entitlement-gate sweep; easy named activities alone are insufficient.

## 6. Turn research into LimeSSH implementation

Use the [task template](../research_notes/juicessh-parity/templates/task.md). Every
reviewed card must contain:

1. One question and an explicit read scope, exclusions, budget and stop condition.
2. Evidence locators, input hashes, tool versions and **observed / inferred /
   unknown** labels; searches that found nothing, with their exact search scope.
3. Behavior contract: preconditions, action, state/output, failure paths and relevant
   persistence/IPC/transport boundaries. Distinguish static evidence from runtime.
4. Mapping to existing gap IDs, current LimeSSH symbols/file hashes and status:
   already matches / partial / missing / new enhancement / deliberately different /
   blocked. One legacy method need not map to one Kotlin method.
5. Requirements with stable IDs such as `R-010-REQ-01`, dependency links and concrete
   Given/When/Then scenarios, including error/lifecycle cases where applicable.
6. A narrow implementation proposal with acceptance tests and integration risks;
   a reviewer checks evidence sufficiency before implementation is dispatched.

The implementation agent reads the reviewed behavior card and relevant LimeSSH
source, then implements original Kotlin behavior. Record requirement → code → test
links. Run meaningful checks for the change; do not repeatedly run the entire
build for documentation-only research. Record build variant, test names/results
and device/emulator details. Verify interactions across terminal/session/data/IPC
boundaries before declaring runtime parity. Broad refactors get their own tasks.

Research status: `planned → ready → in_progress → checkpointed/spec_ready → reviewed`.
Use `blocked` with an exact missing input and next action. Workstreams remain
`needs_split` until leaf cards exist. Dependencies must be reviewed before dispatch.
Implementation status is separate: `not_started / in_progress / implemented /
verified / deferred / blocked`. Runtime status is separately `not_run / passed /
failed / blocked`. A feature can be implemented with runtime `not_run`.

## 7. Repository and Obsidian responsibilities

**Repository is authoritative for queue states, coverage ledgers, task cards,
requirements and code/test mappings. Obsidian provides navigation, concise findings,
decisions and resumable session summaries.** Keep one owner per record; copied
notes identify the canonical file and revision. Raw APK/decompiler output stays in
the local evidence cache, with regeneration instructions for a new machine.

```text
research_notes/juicessh-parity/
  INDEX.md                 # compact startup packet
  WORK_QUEUE.csv           # workstreams and schedulable leaf tasks
  AGENT_PROTOCOL.md        # worker/reviewer/implementation prompts
  tasks/R-xxx.md           # canonical contracts, findings and checkpoints
  templates/               # reusable task and handoff templates
  coverage/                # compact ledgers generated in R-000

Obsidian: projects/juicessh/Research/
  Research programme.md    # project entry point and scope
  Agent workflow.md        # budget, dispatch and handoff rules
  Source register.md       # existing knowledge and artifact identities
  Sessions/<session-id>.md # one bounded handoff per session, when work starts
  Findings/<task-id>.md    # concise reviewed findings, when available
```

Use Obsidian `get_note_outline` and `read_note_lines` before reading long notes;
search within `projects/juicessh/`, and read exact linked cards. Avoid vault-wide
search on every resume. Wiki-link to existing index/gap/build notes. Frontmatter on
new findings includes `task_id`, `gap_ids`, `canonical_path`, `canonical_sha256`,
`source_artifact`, `evidence_level`, `updated` and separate statuses.

At checkpoint: save the canonical task first; update the queue; then write the
Obsidian summary with its canonical hash. The coordinator owns the shared queue;
workers own only their assigned task/evidence files. If MCP is unavailable, save
`obsidian_sync: pending` in the repository handoff and continue independent work;
sync that checkpoint when access returns. When copied text conflicts, verify the
canonical hash and source evidence rather than silently merging claims.

Use the [handoff template](../research_notes/juicessh-parity/templates/handoff.md):
completed evidence, exact next locator/action, failed approaches, unresolved
questions, file hashes, remaining scope and usage. New agents start from these
durable files without needing the old conversation. A session ending mid-research
is normal and does not reset coverage.

## 8. First dispatch and completion criteria

Read [INDEX](../research_notes/juicessh-parity/INDEX.md), select
[R-000](../research_notes/juicessh-parity/tasks/R-000.md), and use the bounded research
prompt in [AGENT_PROTOCOL](../research_notes/juicessh-parity/AGENT_PROTOCOL.md).
R-001 and R-010 already have starter cards. The CSV lists workstreams covering the
rest of the app; those broad rows must be decomposed before assignment.

Campaign completion requires inventory reconciliation, reviewed requirements for
every selected application behavior, implementation/test links and explicit
dispositions for every unresolved/deferred item. Device results and unavailable
backend/fixture blockers remain visible. The final product is a traceable parity
report, not a claim that every decompiled line became new app code.
