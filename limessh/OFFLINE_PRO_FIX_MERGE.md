# OfflineProFix merged into LimeSSH

The standalone `juicessh-offlineprofix` Xposed module
(`org.lyf.juicesshofflinepro`) has been merged directly into these decompiled
LimeSSH sources, so the offline-"Pro" behaviour is baked into the app itself
and no longer requires the Xposed framework.

The module replaced five LimeSSH methods at runtime. Each has been patched
in place; search for `[OfflineProFix merged]` to find them. The original body
of each method is preserved next to it with an `_original` suffix (or inside a
block comment) for reference.

| Xposed hook (runtime name) | Patched method (decompiled name) | New behaviour |
|---|---|---|
| `oi0.d(Object)` | `cz/opentree/oi0.java` → `m7047d(Object)` | always returns `true` |
| `User.H()` | `cz/opentree/limessh/models/User.java` → `m5531H()` | always returns `true` (signature valid) |
| `User.w()` | `cz/opentree/limessh/models/User.java` → `m5533w()` | returns `315360000L` (10-year session, never expires) |
| `pi0.m(Context)` | `cz/opentree/pi0.java` → `m7334m(Context)` | always returns `true` (API user gate) |
| `pi0.j(Context, pi0$p)` | `cz/opentree/pi0.java` → `m7331j(Context, AbstractC1720p)` | resolves the user locally via `User.m5518A(context)` (or `new User()`) and invokes the callback, with no network refresh |

The module's configurable options (`hook_pro_check`, `hook_user_signature`,
`hook_session_expiry`, `hook_api_gate`, `session_years`, default 10) are baked
in as all-enabled with a 10-year session.
