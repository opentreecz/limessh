# Proposed independent Android successor architecture

**Proposal only — no application scaffold, code, build or runtime validation.** The user must approve the [implementation plan](ROADMAP.md) before app work. Technical facts come from the [artifact analysis](../research_notes/JuiceSSH%20revival%20feasibility/artifact-analysis.md); historical requirements from the [feature matrix](FEATURE_MATRIX.md). Choices below are recommendations to evaluate, not recovered original source or settled dependencies.

## Identity and UX

Use a new product name, application ID under a namespace the publisher controls, signing key, provider authority, deep-link scheme and permission namespace. None is selected yet. Do not impersonate `com.sonelli.juicessh`, reuse its signing identity or assume access to its private storage. A distinct identity permits side-by-side installation but prevents automatic legacy data/plugin takeover.

Preserve task flows: choose a connection/group, reuse an identity, verify host trust, open or switch sessions, send special keys, run snippets and control tunnels. Design original layouts, copy, icons and artwork. Reuse specific assets/code only under verified licenses or sufficient permission; authorized source reuse would require a revised architecture decision and provenance inventory. Exposure to decompiled code has occurred during research: document it and do not label the whole effort clean-room. See [permission analysis](../research_notes/JuiceSSH%20revival%20feasibility/licensing-and-permission.md).

## Proposed boundaries

Kotlin with a modern Android UI toolkit is the starting proposal. Compose is a candidate, with an Android View bridge if the selected terminal renderer requires one. Prefer a small number of modules initially; the boundaries below are logical and need not each become a Gradle module.

```text
Original UI / widget / shortcuts
           | application use cases
           v
Connection + identity + host-trust + snippet + forward models
           |                      |
      Local repositories     Session coordinator
           |                      |
   Crypto / import-export    SSH-engine adapter <-> SSH server
                                  |
                          Terminal model / renderer

Explicit plugin gateway -> authorized use cases / scoped session handles
Optional sync worker    -> encrypted envelopes / chosen storage transport
```

| Boundary | Responsibility | Important restriction |
|---|---|---|
| App/UI | Navigation, original terminal controls, accessibility, observable session states | UI does not directly decrypt/export arbitrary identity records |
| Domain/use cases | Connections, groups, identities, known hosts, forwards, scripts and policy | Transport-independent models; no copied legacy ORM/class names in new wire format |
| Session runtime | Session state machine, reconnect, channels, notifications, lifecycle | User-visible long-lived work; reconnect must not silently rerun side-effecting scripts |
| SSH adapter | Authentication, host keys, PTY, exec, local/remote/dynamic forwarding | Reject changed host keys until resolved; explicit algorithm/agent-forwarding policy |
| Terminal | Parser/model, scrollback, selection, resize, rendering and input | Test escape handling, Unicode and IME; no assumption a generic text view is a terminal |
| Storage/crypto | Versioned schema, secret encryption, keys, import/export | Avoid secrets in logs, intents, plugin provider projections or unencrypted backups |
| Plugin gateway | Caller identity, consent, capabilities, scoped session I/O and audit | No blanket identity-store access; define cancellation, timeout and output limits |
| Optional sync | Encrypted records, revisions, deletions, conflict resolution | Transport cannot become a prerequisite for local features |

## SSH and terminal component decision

Evaluate maintained upstream implementations rather than transplanting APK libraries. Candidate investigations include [SSHJ](https://github.com/hierynomus/sshj) for a JVM-oriented adapter and [libssh](https://www.libssh.org/) with a deliberately maintained JNI layer. These are evaluation leads, not a current maintenance, Android compatibility or license audit. Compare host-key algorithms, modern key formats, keyboard-interactive/2FA, IPv6, jump hosts, channel concurrency, cancellation, local/remote/SOCKS forwarding, agent forwarding, licensing and security response. A JVM path reduces native packaging work; a native path adds NDK, JNI ownership, ABI/page-size and release obligations. Neither is selected.

Evaluate terminal components from upstream, for example [ConnectBot](https://github.com/connectbot/connectbot) and [Termux](https://github.com/termux/termux-app) as investigation starting points. Audit exact reusable component boundaries, revisions and licenses before adopting any code; an application's license cannot be generalized to all vendored files. Build an independent terminal behavior corpus covering cursor movement, alternate screen, colors, wide/combining characters, resize, selection, hardware keys, touch, IME and screen-reader requirements.

Mosh, local shell and Telnet are separate transports or tools, not prerequisites for SSH MVP. Local shell runs within the app sandbox unless a separately specified mechanism exists. Native Mosh/subprocess support introduces packaging/lifecycle work; do not reuse the old packaged executable binaries. Telnet requires an explicit cleartext feature decision rather than a global cleartext default.

## Android session lifecycle

Use a session coordinator with explicit disconnected/connecting/authenticating/active/reconnecting/closing/error states. Define what survives activity recreation, screen lock, app process death and network changes. Select foreground-service behavior using current Android requirements and Play policies at implementation time; the analyst could not retrieve contemporary Android guidance. Review exported components, notification permission, foreground-service types, PendingIntent mutability, background starts, package visibility and Storage Access Framework access. Native evaluation must include 16 KiB-page devices and current NDK packaging. No current target SDK or compliance deadline is asserted here.

Decide whether lock hides UI only, prevents new channels, blocks plugins, or also disconnects sessions and clears available keys. Existing authenticated SSH sessions contain transport secrets even if stored credentials are locked. Automatic reconnect, widget actions and snippet autostart must honor that decision.

## Local data and cryptography

Proposed entities: connection, identity reference, known host, group/membership, forwarding rule, snippet/connection binding, execution policy, preferences, plugin grant and redacted audit event. Use stable opaque IDs and schema migrations. A Room/SQLite layer is a candidate; do not claim full-database encryption merely because selected credential fields are encrypted.

For new secret storage, evaluate AES-256-GCM with Android Keystore-protected wrapping keys, unique nonces, authenticated version/context fields and explicit unlock/rotation behavior. Device-bound protection and portable export are different requirements: exported data needs a passphrase-derived or independently recoverable key, with a modern calibrated KDF, salt, format version and integrity check. Choose KDF parameters through device measurements and review rather than reusing the observed legacy PBKDF2 setting. Document whether connection metadata/hostnames are encrypted, what remains visible, how deletion works, and what Android backup captures. No security certification is implied by this design sketch.

The legacy helper is AES-CBC without an observed MAC and uses a weak-by-modern-standards KDF configuration; it must not become the new writer format. Any compatibility decoder should be read-only, size-bounded, isolated from live storage and tested with lawful fixtures. Without authenticated legacy ciphertext, successful parsing alone cannot prove its authenticity.

## Encrypted backup, sync and teams

Start with export/restore, then consider multi-device synchronization. Define a new versioned AES-256-GCM envelope with record IDs, revision/conflict rules, deletion markers and authenticated context. Design key rotation, recovery, multi-device enrollment and metadata visibility before choosing a managed or self-hosted transport. Validate loss/corruption, rollback/replay policy and offline concurrent edits; authenticated encryption alone does not solve these protocol problems.

Team sharing adds identity/membership verification, invitations, per-team keys, role changes, revocation, rotation and audit. Revocation cannot erase data already decrypted by a former member. Do not reuse Sonelli session cookies, endpoints, purchase signatures or assume access to its cloud data. AWS EC2 discovery is a separate connector with least-privilege credentials and its own refresh/reconciliation policy. All are later user-approved scopes.

## Plugin compatibility choices

The public [Apache-2.0 SDK](https://github.com/Sonelli/juicessh-pluginlibrary) is a better first input than decompiled host code. Its license and exact files/dependencies must still be audited. The old API combines Binder services, content-provider URIs and package/permission assumptions; SFTP's signature-level permission creates a specific continuity barrier. The provider offers no identity endpoint, and an EC2 matcher is not proof of equivalent external access.

| Strategy | Benefit | Tradeoff / proposed disposition |
|---|---|---|
| New namespaced, versioned SDK plus source ports | Side-by-side host installation, explicit security model | Existing APKs need updates; preferred first path for Example/Monitor/Audit Log/PortKnocker |
| Optional legacy protocol adapter | Potentially fewer plugin changes | Investigate binding targets, authority collisions, permission names, parcel ordering and callback semantics; no drop-in claim |
| Claim original package/authority | Superficial resemblance to legacy host | Signing conflicts, coexistence limits and identity confusion; not the proposed path |

Provide granular grants for listing connections, opening sessions, executing commands and viewing output, tied to authenticated caller identities. Consider signing-certificate continuity when installed plugins update. Use parameterized data operations and explicit projection allowlists; do not copy the observed substring SQL guard. Support redacted auditing, revocation, bounded I/O and per-session handles. Test legacy compatibility against a concrete plugin APK hash or source revision, host version and Android version—not merely matching interface names.

## Migration tradeoffs

| Route | Useful input | Limitation / acceptance target |
|---|---|---|
| User-authorized structured export | Connections, groups, snippets, optional identities | Need an actual fixture and credential context; preserve associations and report unsupported fields |
| Existing encrypted backup | Public gojuice/pyjuice format evidence | Decrypt only user-provided data; old service retrieval is unverified; test wrong passwords and corruption |
| Plugin-mediated export | Provider-accessible records | No demonstrated identity/private-key access; partial migration must be labelled |
| Private SQLite/preferences snapshot | Potentially more local state | New package cannot ordinarily access old sandbox; no extraction bypass assumed; accept only lawfully supplied data |
| Recreate connections / OpenSSH import | Independent fallback | Loses some app-only metadata and secrets; user decides acceptable scope |

Stage imports into a transaction, display a preview, detect duplicates, preserve host-trust semantics, require explicit secret import and produce a redacted result report. An unresolved 1,532-instruction legacy DB method prevents promising exact merge equivalence. Prefer documented format facts and licensed tools; further reverse engineering needs a defined necessity/scope. Do not modify original data or silently treat an import as trust in a host key.

## Pending architecture decisions

Before coding, record approval of identity direction, baseline Android/device support, UI/terminal approach, SSH candidate evaluation, crypto/lock semantics, plugin priorities and migration fixtures. Later decisions cover sync transport, team security, EC2 auth, project licensing and release distribution. See [roadmap gates](ROADMAP.md) and [session blockers](SESSION_MEMORY.md). Permission to reuse proprietary code could change inputs, but would not eliminate modernization, provenance review or runtime tests.
