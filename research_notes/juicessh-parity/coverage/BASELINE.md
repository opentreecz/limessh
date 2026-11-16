# R-000 — Reviewed inventory baseline

Date: 2026-10-20. Status: **inventory reviewed; behavioral research and runtime
verification remain pending**. No app code changed and no APK code executed.
Canonical task: [R-000](../tasks/R-000.md). Machine summary: [summary.json](summary.json).

## Identities and current source

| Input | SHA-256 |
|---|---|
| Main APK 3.2.2/200 | `167d3afb1c832698ca512d9bf418c341a6f6e441bc64f57aaa1b264d47a8d64b` |
| Fix APK 1.0/1 | `5dea4033623bc6562fe388c4f47e9df6cd2643327138b0f10578ef6f171a267d` |
| Main classes.dex | `48729572137f4a654d421f3ae1bfb10195b455b9de9f685220488ea409522bc9` |
| Fix classes.dex | `461b2c2d34d0277feeb03c4bedb0cd0efd5b578ce0bc6a0d24e33edf6b91d1e3` |

All 1,262 extracted archive members matched the corresponding APK member bytes.
Existing APK inventory and DEX header/class/reference counts also reconciled.
Signatures were not reverified; their earlier verification remains historical.

Repository HEAD: `916d46e431164d4f014f3e14f7daa2e4a64e9800`.
Current implementation baseline:
`523cf8aa35b143e97f969a66f5881b5c384abea532b86a543aa17cae00b24421`.
This ID hashes HEAD plus the sorted **95 selected file records**, including
untracked app files and a deleted source. It covers app source/schema, build
configuration/helpers, Gradle wrapper, CI and tests. It does not identify every
repository document, filesystem mode, generated output or local setting.
The full dirty status is recorded separately in ignored evidence.
[current-source-files.csv](current-source-files.csv) preserves individual hashes.

## Reconciled denominators

| Item kind | Main app | Fix module |
|---|---:|---:|
| Archive entries | 1,256 | 6 |
| DEX classes | 7,839 | 10 |
| Defined methods | 48,083 | 31 |
| Methods containing bytecode | 43,656 | 31 |
| Native method declarations | 74 | 0 |
| Abstract method declarations | 4,353 | 0 |
| Referenced method-ID entries | 55,362 | 110 |
| Manifest components | 55 | 1 |
| Resource IDs | 4,203 | 13 |
| Resource configuration variants | 18,443 | 24 |
| Native files, including auxiliary platforms | 43 | 0 |
| Direct invoke sites | 171,385 | 207 |

The index has **61,540 unique rows** across archive/class/defined-method/component/
resource/native-file kinds. These kinds overlap structurally and are not a feature
denominator. Main manifest components remain 29 activities, 17 services, 7 receivers
and 2 providers. Native files comprise 40 `lib/` members (36 ELF + four bashrc files)
plus JNA Windows x86/x86-64 DLLs and a Darwin `.jnilib` outside `lib/`.

Every row has an APK-bound stable ID, parent where applicable, provisional routing
and an explicit unreviewed status. Main class ownership seeds: **394 application,
3,627 dependency, 386 generated, 3,432 unknown**. Fix: six application and four
generated. Package-prefix classification is a starting hypothesis, not proven
attribution or permission to discard a class. Every item remains queued.

The direct-call index is a shallow static reference aid, not a complete call graph.
It records **1,486 reflection/library-load candidate sites** and **74 native
declarations** separately. Dynamic argument targets/JNI implementations remain
unresolved. Workstream assignments are primary seeds; method leaves can refine them.
See [residuals.csv](residuals.csv) for follow-up owners. Counts across residual rows
overlap and must not be summed into a completion percentage.

## Evidence files and regeneration

Generated files under ignored `.artifact-analysis/parity/`:

- `inventory.jsonl`: complete stable identifiers, locators, ownership/routing seeds.
- `direct-invokes.jsonl`: caller ID, instruction offset, target signature.
- `dynamic-boundaries.jsonl`: native and reflection/load candidates.
- `decompiler-markers.jsonl`: marker path, line, source hash and unreconciled status.
- `{fix,juicessh}-jadx-files.json`: source-cache file hashes.
- `current-source-baseline.json`: selected file records, HEAD, baseline ID, dirty status.
- `provenance.json`: generator/Python hashes, installed package versions, historical
  tool archive hashes and fallback file hashes.
- `summary.json` and `validation.json`: totals, output hashes and structural checks.

The original Python environment was absent. Recreated Androguard **4.1.4** in
ignored `.artifact-analysis/parity-env/`; no global installation was changed.
Python parser code reads APKs and existing caches; no new full decompilation ran.

```bash
python3 -m venv .artifact-analysis/parity-env
.artifact-analysis/parity-env/bin/python -m pip install 'androguard==4.1.4'
.artifact-analysis/parity-env/bin/python research_notes/juicessh-parity/build_inventory.py
python3 research_notes/juicessh-parity/verify_inventory.py
```

The generator requires the two original APKs, prior inventory JSON, extracted
members and JADX resources/sources. If those caches are missing, use the existing
reproduction commands in
[artifact-analysis.md](../../JuiceSSH%20revival%20feasibility/artifact-analysis.md).
The verifier additionally uses `/tmp/opencode/revtools/apk_smali/smali` by default;
pass another smali root as its first argument. Missing comparison evidence fails
verification. Tool archive hashes and installed package versions are in provenance;
full Python versions can be reconstructed from its `packages` list.

Regeneration replaces generated **seeds**, not reviewed task cards. Keep human
dispositions in separate coverage/task records keyed by stable IDs. Future source
changes produce a new baseline; preserve this recorded CSV/summary for comparison.
Temporary fallback caches have hashes but unverified source-APK instruction identity.

## Validation performed

- All archive member hashes matched the existing extraction.
- DEX class and method-reference counts matched binary headers and earlier inventory.
- All **7,839 class** and **48,083 defined-method** signatures independently matched
  the existing main-app smali set, with zero differences.
- All **4,203 + 13 resource IDs** matched independently decoded JADX `public.xml`.
- Inventory IDs were unique, parent links had zero orphans, counts reconciled.
- Two generator runs produced identical hashes for every hashed evidence output.
- Current selected source hashes still matched after research; no app changes.
- A bounded second-agent review found no blocking counting/snapshot issue.

These checks establish structural indexing and cache consistency. Smali signature
matching does not prove fallback instruction identity or recovered semantics.
App builds, JVM tests and device tests were not rerun.

## Reconciled prior knowledge

| Earlier statement | Current evidence and disposition |
|---|---|
| 26 JADX errors | Historical run diagnostic count. Current source scan has **1,495 warning/error/placeholder marker lines**, not 1,495 failed methods. Group/reconcile by method in W-23. |
| DB import `DB.c` undecompiled | Canonical Java still has a placeholder. Simple/fallback/CFR attempts exist; CFR warns of possible behavior change and unstructured control flow. Semantics remain unresolved in W-13. |
| Fallback tooling not attempted | Superseded by existing `outA`, `out_simple`, `out_fallback`, `out_cfr` output. `out_vf` is empty. Tools being present does not establish success. |
| 40 native files | Correct for `lib/` only; whole archive has 43 including three auxiliary JNA binaries. |
| 13 / 16 / 32 / 53 JVM tests | Successive historical runs. Latest cached XML: nine suites, 53 tests, zero failures/errors, timestamps 2026-10-19 20:25:26–45, timezone unspecified. No fresh execution or device result. |
| Session-memory date October 19 | Top line describes implementation update; October 20 planning section is newer. Read dated sections rather than treating the top date as complete chronology. |

The DB method bytecode locator is
`Lcom/sonelli/juicessh/db/DB;->c(Lorg/json/JSONArray;Ljava/lang/Class;Lcom/sonelli/xi0;Lcom/sonelli/juicessh/models/User;ZLandroid/content/Context;)V`.
Existing smali starts at `/tmp/opencode/revtools/apk_smali/smali/com/sonelli/juicessh/db/DB.smali:288`.
Canonical Java is `.artifact-analysis/juicessh/jadx/sources/com/sonelli/juicessh/db/DB.java:91`;
CFR warning region is `/tmp/opencode/revtools/out_cfr/com/sonelli/juicessh/db/DB.java:127`.

## Next dispatch

**R-001 and R-010 are ready**, with exact entry points appended to their cards.
Default remains one worker at a time. R-001 covers the complete small module;
R-010 starts directly in `jackpal.androidterm.emulatorview.TerminalEmulator`.
Neither behavior task has been executed by R-000. Actual billed token usage is
unavailable; the 12k target remains an estimate rather than a claimed measured total.
