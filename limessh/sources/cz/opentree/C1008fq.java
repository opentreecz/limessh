package cz.opentree;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.fq */
/* loaded from: classes.dex */
public final class C1008fq {

    /* renamed from: a */
    public static final AbstractC1067gq f2759a;

    static {
        f2759a = (!(C0841cq.m2929m() && C0841cq.m2934r()) || C1775qm.m7743b()) ? new C1232jq() : new C1519lq();
    }

    /* renamed from: d */
    public static int m3859d(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                throw new C1172iq(i2, length2);
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        long j = i3 + 4294967296L;
        StringBuilder sb = new StringBuilder(54);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: e */
    public static int m3860e(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return f2759a.mo4240b(charSequence, bArr, i, i2);
    }

    /* renamed from: f */
    public static boolean m3861f(byte[] bArr) {
        return f2759a.m4241c(bArr, 0, bArr.length);
    }

    /* renamed from: g */
    public static boolean m3862g(byte[] bArr, int i, int i2) {
        return f2759a.m4241c(bArr, i, i2);
    }

    /* renamed from: h */
    public static int m3863h(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* renamed from: i */
    public static int m3864i(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    /* renamed from: j */
    public static int m3865j(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    /* renamed from: k */
    public static String m3866k(byte[] bArr, int i, int i2) throws C0839co {
        return f2759a.mo4242d(bArr, i, i2);
    }

    /* renamed from: m */
    public static int m3868m(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 == 0) {
            return m3863h(b);
        }
        if (i3 == 1) {
            return m3864i(b, bArr[i]);
        }
        if (i3 == 2) {
            return m3865j(b, bArr[i], bArr[i + 1]);
        }
        throw new AssertionError();
    }
}
