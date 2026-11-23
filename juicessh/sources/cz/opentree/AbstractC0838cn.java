package cz.opentree;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.cn */
/* loaded from: classes.dex */
public abstract class AbstractC0838cn {
    public AbstractC0838cn() {
    }

    /* renamed from: a */
    public static long m2882a(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    /* renamed from: b */
    public static AbstractC0838cn m2883b(byte[] bArr, int i, int i2, boolean z) {
        C0947en c0947en = new C0947en(bArr, 0, i2, false);
        try {
            c0947en.mo2885c(i2);
            return c0947en;
        } catch (C0839co e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: d */
    public static int m2884d(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    /* renamed from: c */
    public abstract int mo2885c(int i) throws C0839co;

    /* renamed from: e */
    public abstract int mo2886e();
}
