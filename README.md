# LimeSSH

A rebuild of JuiceSSH 3.2.2 with the offline-Pro unlock baked in and a green
lime launcher icon. The APK is produced by repackaging the base JuiceSSH APK
with [apktool](https://apktool.org) — decode → patch → rebuild → sign — which
keeps the original native libraries and signing-independent resources intact.

## Layout

| Path | Purpose |
|---|---|
| `juicessh-base.apk` | Base JuiceSSH 3.2.2 APK the build repackages (build input) |
| `patches/patch.py` | Applies the patches to a decoded tree (offline-pro + icon) |
| `patches/res/drawable/ic_launcher_svg.xml` | Green lime adaptive-icon foreground |
| `build.sh` | Decode → patch → rebuild → zipalign → sign |
| `limessh/sources/` | Human-readable decompiled Java, for reference only (not built) |
| `.github/workflows/` | CI: build on push, publish APK on `v*.*.*` tag |

## Build locally

Requires a JDK 17+, an Android SDK with build-tools (`ANDROID_HOME`), `python3`
and `curl` (apktool is downloaded automatically):

```bash
bash build.sh
# -> build/limessh-debug.apk  (debug-signed, installable)
```

## What the patches do

Offline-Pro is unlocked by rewriting five methods in smali (the same five the
`org.lyf.juicesshofflinepro` Xposed module hooked at runtime) — see
`limessh/OFFLINE_PRO_FIX_MERGE.md` for the full mapping. The package stays
`com.sonelli.juicessh` so the bundled JNI libraries keep working.

The build produces a **debug-signed** APK. Because it is signed with a
different certificate than the Play Store build, it cannot update an installed
JuiceSSH in place.
