package cz.opentree;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.r0 */
/* loaded from: classes.dex */
public abstract class AbstractC1795r0 {

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* renamed from: cz.opentree.r0$a */
    /* loaded from: classes.dex */
    public enum a {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR
    }

    /* renamed from: a */
    public static AbstractC1795r0 m7836a() {
        return new C1628o0(a.FATAL_ERROR, -1L);
    }

    /* renamed from: d */
    public static AbstractC1795r0 m7837d(long j) {
        return new C1628o0(a.OK, j);
    }

    /* renamed from: e */
    public static AbstractC1795r0 m7838e() {
        return new C1628o0(a.TRANSIENT_ERROR, -1L);
    }

    /* renamed from: b */
    public abstract long mo6823b();

    /* renamed from: c */
    public abstract a mo6824c();
}
