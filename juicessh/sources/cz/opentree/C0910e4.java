package cz.opentree;

import androidx.core.app.NotificationCompat;

/* renamed from: cz.opentree.e4 */
/* loaded from: classes.dex */
public final class C0910e4 {
    /* renamed from: a */
    public static String m3418a(String str, int i) {
        if (i <= 0) {
            C1212jh.m5113d("index out of range for prefix", str);
            return "";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11);
        sb.append(str);
        sb.append(i);
        return sb.toString();
    }

    /* renamed from: b */
    public static String m3419b(int i) {
        return m3418a("cd", i);
    }

    /* renamed from: c */
    public static String m3420c(int i) {
        return m3418a("cm", i);
    }

    /* renamed from: d */
    public static String m3421d(int i) {
        return m3418a("&pr", i);
    }

    /* renamed from: e */
    public static String m3422e(int i) {
        return m3418a("pr", i);
    }

    /* renamed from: f */
    public static String m3423f(int i) {
        return m3418a("&promo", i);
    }

    /* renamed from: g */
    public static String m3424g(int i) {
        return m3418a(NotificationCompat.CATEGORY_PROMO, i);
    }

    /* renamed from: h */
    public static String m3425h(int i) {
        return m3418a("pi", i);
    }

    /* renamed from: i */
    public static String m3426i(int i) {
        return m3418a("&il", i);
    }

    /* renamed from: j */
    public static String m3427j(int i) {
        return m3418a("il", i);
    }
}
