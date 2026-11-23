package cz.opentree;

import android.os.Build;

/* renamed from: cz.opentree.ah */
/* loaded from: classes.dex */
public final class C0711ah {
    /* renamed from: a */
    public static int m2065a() {
        try {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException unused) {
            C1212jh.m5113d("Invalid version number", Build.VERSION.SDK);
            return 0;
        }
    }
}
