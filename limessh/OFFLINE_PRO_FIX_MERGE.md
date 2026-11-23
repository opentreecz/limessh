# OfflineProFix — applied to the LimeSSH build

The `org.lyf.juicesshofflinepro` Xposed module unlocked JuiceSSH's offline
"Pro" by hooking five methods at runtime. The LimeSSH build bakes those same
five changes into the APK by rewriting the methods in **smali** at build time
(see `patches/patch.py`), so the Xposed framework is not required.

| Xposed hook (runtime name) | Patched method (smali) | New behaviour |
|---|---|---|
| `oi0.d(Object)` | `Lcom/sonelli/oi0;->d(Ljava/lang/Object;)Z` | always returns `true` |
| `User.H()` | `Lcom/sonelli/juicessh/models/User;->H()Z` | always returns `true` (signature valid) |
| `User.w()` | `Lcom/sonelli/juicessh/models/User;->w()J` | returns `0x12cc0300` (315360000s ≈ 10 years; session never expires) |
| `pi0.m(Context)` | `Lcom/sonelli/pi0;->m(Landroid/content/Context;)Z` | always returns `true` (API user gate) |
| `pi0.j(Context, pi0$p)` | `Lcom/sonelli/pi0;->j(Landroid/content/Context;Lcom/sonelli/pi0$p;)V` | resolves the user locally via `User.A(context)` (or `new User()`) and invokes the callback, with no network refresh |

The `limessh/sources/` tree contains the equivalent changes in human-readable
decompiled Java for reference; the actual build applies them in smali against
the original `com.sonelli.juicessh` package so the bundled native libraries
continue to resolve.
