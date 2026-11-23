package cz.opentree;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.qm */
/* loaded from: classes.dex */
public final class C1775qm {

    /* renamed from: a */
    public static final Class<?> f6052a = m7742a("libcore.io.Memory");

    /* renamed from: b */
    public static final boolean f6053b;

    static {
        f6053b = m7742a("org.robolectric.Robolectric") != null;
    }

    /* renamed from: a */
    public static <T> Class<T> m7742a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m7743b() {
        return (f6052a == null || f6053b) ? false : true;
    }

    /* renamed from: c */
    public static Class<?> m7744c() {
        return f6052a;
    }
}
