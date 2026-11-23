#!/usr/bin/env python3
"""Apply the LimeSSH patches (offline-pro + green lime icon) to an apktool-
decoded JuiceSSH tree. Idempotent: replaces whole method bodies by signature.

Usage: patch.py <decoded-dir>
"""
import glob
import os
import re
import sys

# Offline-pro: replace whole method bodies (matched by exact .method signature).
# Mirrors the five hooks of the org.lyf.juicesshofflinepro Xposed module.
SMALI_PATCHES = {
    "com/sonelli/oi0.smali": {
        ".method public static d(Ljava/lang/Object;)Z": """.method public static d(Ljava/lang/Object;)Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method""",
    },
    "com/sonelli/juicessh/models/User.smali": {
        ".method public H()Z": """.method public H()Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method""",
        ".method public w()J": """.method public w()J
    .locals 2

    const-wide/32 v0, 0x12cc0300

    return-wide v0
.end method""",
    },
    "com/sonelli/pi0.smali": {
        ".method public static m(Landroid/content/Context;)Z": """.method public static m(Landroid/content/Context;)Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method""",
        ".method public static j(Landroid/content/Context;Lcom/sonelli/pi0$p;)V": """.method public static j(Landroid/content/Context;Lcom/sonelli/pi0$p;)V
    .locals 2

    if-nez p1, :cond_0

    return-void

    :cond_0
    :try_start_0
    invoke-static {p0}, Lcom/sonelli/juicessh/models/User;->A(Landroid/content/Context;)Lcom/sonelli/juicessh/models/User;

    move-result-object v0
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v1

    const/4 v0, 0x0

    :goto_0
    if-nez v0, :cond_1

    new-instance v0, Lcom/sonelli/juicessh/models/User;

    invoke-direct {v0}, Lcom/sonelli/juicessh/models/User;-><init>()V

    :cond_1
    invoke-virtual {p1, v0}, Lcom/sonelli/pi0$p;->b(Lcom/sonelli/juicessh/models/User;)V

    return-void
.end method""",
    },
}


def find_class(root, rel):
    hits = glob.glob(os.path.join(root, "smali*", rel))
    if not hits:
        raise SystemExit(f"error: class not found: {rel}")
    return hits[0]


def replace_method(text, start_sig, replacement):
    i = text.find(start_sig)
    if i == -1:
        raise SystemExit(f"error: method not found: {start_sig}")
    end = text.find(".end method", i)
    if end == -1:
        raise SystemExit(f"error: no .end method after {start_sig}")
    end += len(".end method")
    return text[:i] + replacement + text[end:]


def patch_smali(root):
    for rel, methods in SMALI_PATCHES.items():
        path = find_class(root, rel)
        with open(path, encoding="utf-8") as f:
            text = f.read()
        for sig, repl in methods.items():
            text = replace_method(text, sig, repl)
        with open(path, "w", encoding="utf-8") as f:
            f.write(text)
        print(f"patched {len(methods)} method(s) in {os.path.relpath(path, root)}")


def patch_icon(root):
    here = os.path.dirname(os.path.abspath(__file__))
    fg_src = os.path.join(here, "res", "drawable", "ic_launcher_svg.xml")
    fg_dst = os.path.join(root, "res", "drawable", "ic_launcher_svg.xml")
    with open(fg_src, encoding="utf-8") as f:
        data = f.read()
    with open(fg_dst, "w", encoding="utf-8") as f:
        f.write(data)
    print("replaced launcher foreground with green lime")

    colors = os.path.join(root, "res", "values", "colors.xml")
    with open(colors, encoding="utf-8") as f:
        text = f.read()
    new = re.sub(
        r'(<color name="ic_launcher_background">)#[0-9a-fA-F]{6,8}(</color>)',
        r"\g<1>#ff2e7d32\g<2>",
        text,
    )
    if new == text:
        raise SystemExit("error: ic_launcher_background color not found")
    with open(colors, "w", encoding="utf-8") as f:
        f.write(new)
    print("set launcher background to green")


def main():
    if len(sys.argv) != 2:
        raise SystemExit("usage: patch.py <decoded-dir>")
    root = sys.argv[1]
    patch_smali(root)
    patch_icon(root)
    print("patches applied")


if __name__ == "__main__":
    main()
