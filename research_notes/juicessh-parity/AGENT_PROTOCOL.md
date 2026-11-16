# Agent protocol and dispatch prompts

Use a fresh agent context. Default concurrency is one research worker; the
coordinator reads its result and updates the queue. Do not send the entire old
conversation, all documentation or decompiled directories to the worker.

## Coordinator

1. Select one `ready` leaf whose dependencies are `reviewed`. A `needs_split`
   workstream cannot be dispatched as a whole. Check allowance before dispatch.
2. Resolve applicable repository instructions. Compare the task's source hashes
   with current files; refresh only affected evidence if the worktree changed.
3. Fill the research prompt with exact paths/ranges, deliverables and a token target.
   Set owner/session in the queue to avoid duplicate work.
4. Require a durable checkpoint after material discoveries. On quota failure,
   inspect the saved card and wait for allowance; do not repeat the failed run.
5. Review the result for evidence, uncertainty, gap mapping and acceptance criteria.
   Update canonical queue/coverage, then Obsidian. Do not count a written note as
   a reviewed specification automatically.
6. Create one implementation task per small reviewed behavior, or a follow-up
   research leaf when evidence is insufficient. Record dependency edges.

## Research worker prompt

```text
Task: <R-ID>, research only, target <8k–12k total tokens; estimate, not enforced cap>.
Working directory: /home/lukas/git/limessh.
Read research_notes/juicessh-parity/INDEX.md and tasks/<R-ID>.md.
Your single question: <observable behavior or specific unresolved method>.
Allowed legacy inputs: <exact files and methods/ranges>.
Allowed current inputs: <exact LimeSSH files and symbols>.
Relevant existing evidence: <one or two note sections>.
Only write: <assigned task card and explicitly assigned evidence/index files>.
Do not change app code, regenerate the entire APK, or spawn other workers.
Follow at most one reference hop; record out-of-scope dependencies for later tasks.
Use short searches and bounded reads; do not print full decompiled files.
Checkpoint after a material finding or three substantial source reads. Reserve
about 25% of the budget for handoff. If usage cannot be measured, say unknown.
If scope grows, save completed evidence and exact next action; request a split
through the card. Do not invent completeness or retry quota failures.
Return 500–900 words: observed/inferred/unknown, stable evidence locators, existing
gap IDs, current implementation mapping, behavior requirements, Given/When/Then
tests, unresolved items, next action, and checkpoint path. End with spec_ready
only if all task exit criteria are satisfied; otherwise checkpointed or blocked.
```

## Review prompt

```text
Review <R-ID> from its saved card, not the previous conversation. Budget 1k–2k
tokens initially. Verify the small cited evidence slices needed for material
claims. Check artifact/file identities, static versus runtime labels, failure
paths, gap mappings and independently implementable acceptance criteria.
Do not reopen the entire subsystem. Record corrections or precise follow-up
questions. Mark reviewed only if the contract is supported. If adequate review
will exceed the target, checkpoint and create a separate review leaf.
```

## Implementation prompt

```text
Implement <I-ID> from reviewed research card <R-ID> and requirements <REQ-IDs>.
Inspect current LimeSSH files <allowlist>; preserve existing unrelated work.
Implement the specified behavior in the project's current architecture. Use
maintained dependencies where already selected. Raw decompiled source is not the
implementation deliverable. Keep the change bounded; split broad refactors.
Record requirement → Kotlin symbol → test links. Run checks meaningful for this
change, and record exact commands/results. Static/JVM/build success and device
verification are separate statuses. Checkpoint if the task cannot fit its own
budget; research and implementation are separate sessions by default.
```

## Resume after a daily limit or context reset

Read INDEX, the selected queue row, the task's latest checkpoint, and any referenced
handoff. Check source hashes before trusting line numbers. Continue at the exact
pending method/action. Negative searches and failed tooling attempts are retained
so a new agent does not repeat them. If previous writes stopped mid-update, recover
from the task card first, then reconcile queue and Obsidian hash/status.

Do not silently erase conflicting old findings. Record which evidence supersedes
which claim, with dates and locators. When MCP is unavailable, write
`obsidian_sync: pending` in the handoff; local progress remains durable.
