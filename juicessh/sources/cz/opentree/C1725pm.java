package cz.opentree;

import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzhi;
import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.pm */
/* loaded from: classes.dex */
public final class C1725pm {
    /* renamed from: a */
    public static int m7392a(int i, byte[] bArr, int i2, int i3, C1876sm c1876sm) throws C0839co {
        if ((i >>> 3) == 0) {
            throw C0839co.m2891c();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return m7402k(bArr, i2, c1876sm);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return m7400i(bArr, i2, c1876sm) + c1876sm.f6511a;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw C0839co.m2891c();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = m7400i(bArr, i2, c1876sm);
            i6 = c1876sm.f6511a;
            if (i6 == i5) {
                break;
            }
            i2 = m7392a(i6, bArr, i2, i3, c1876sm);
        }
        if (i2 > i3 || i6 != i5) {
            throw C0839co.m2893e();
        }
        return i2;
    }

    /* renamed from: b */
    public static int m7393b(int i, byte[] bArr, int i2, int i3, zzfq<?> zzfqVar, C1876sm c1876sm) {
        C0724ao c0724ao = (C0724ao) zzfqVar;
        int m7400i = m7400i(bArr, i2, c1876sm);
        c0724ao.m2168h(c1876sm.f6511a);
        while (m7400i < i3) {
            int m7400i2 = m7400i(bArr, m7400i, c1876sm);
            if (i != c1876sm.f6511a) {
                break;
            }
            m7400i = m7400i(bArr, m7400i2, c1876sm);
            c0724ao.m2168h(c1876sm.f6511a);
        }
        return m7400i;
    }

    /* renamed from: c */
    public static int m7394c(int i, byte[] bArr, int i2, int i3, C2437zp c2437zp, C1876sm c1876sm) throws C0839co {
        if ((i >>> 3) == 0) {
            throw C0839co.m2891c();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int m7402k = m7402k(bArr, i2, c1876sm);
            c2437zp.m10580c(i, Long.valueOf(c1876sm.f6512b));
            return m7402k;
        }
        if (i4 == 1) {
            c2437zp.m10580c(i, Long.valueOf(m7403l(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int m7400i = m7400i(bArr, i2, c1876sm);
            int i5 = c1876sm.f6511a;
            if (i5 < 0) {
                throw C0839co.m2890b();
            }
            if (i5 > bArr.length - m7400i) {
                throw C0839co.m2889a();
            }
            if (i5 == 0) {
                c2437zp.m10580c(i, AbstractC1939tm.f6790P);
            } else {
                c2437zp.m10580c(i, AbstractC1939tm.m8764k(bArr, m7400i, i5));
            }
            return m7400i + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw C0839co.m2891c();
            }
            c2437zp.m10580c(i, Integer.valueOf(m7399h(bArr, i2)));
            return i2 + 4;
        }
        C2437zp m10579g = C2437zp.m10579g();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int m7400i2 = m7400i(bArr, i2, c1876sm);
            int i8 = c1876sm.f6511a;
            i7 = i8;
            if (i8 == i6) {
                i2 = m7400i2;
                break;
            }
            int m7394c = m7394c(i7, bArr, m7400i2, i3, m10579g, c1876sm);
            i7 = i8;
            i2 = m7394c;
        }
        if (i2 > i3 || i7 != i6) {
            throw C0839co.m2893e();
        }
        c2437zp.m10580c(i, m10579g);
        return i2;
    }

    /* renamed from: d */
    public static int m7395d(int i, byte[] bArr, int i2, C1876sm c1876sm) {
        int i3 = i & KeycodeConstants.KEYCODE_MEDIA_PAUSE;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            c1876sm.f6511a = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            c1876sm.f6511a = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            c1876sm.f6511a = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            c1876sm.f6511a = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                c1876sm.f6511a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* renamed from: e */
    public static int m7396e(zzhi<?> zzhiVar, int i, byte[] bArr, int i2, int i3, zzfq<?> zzfqVar, C1876sm c1876sm) throws IOException {
        int m7398g = m7398g(zzhiVar, bArr, i2, i3, c1876sm);
        zzfqVar.add(c1876sm.f6513c);
        while (m7398g < i3) {
            int m7400i = m7400i(bArr, m7398g, c1876sm);
            if (i != c1876sm.f6511a) {
                break;
            }
            m7398g = m7398g(zzhiVar, bArr, m7400i, i3, c1876sm);
            zzfqVar.add(c1876sm.f6513c);
        }
        return m7398g;
    }

    /* renamed from: f */
    public static int m7397f(zzhi zzhiVar, byte[] bArr, int i, int i2, int i3, C1876sm c1876sm) throws IOException {
        C0732ap c0732ap = (C0732ap) zzhiVar;
        Object mo1272a = c0732ap.mo1272a();
        int m2224o = c0732ap.m2224o(mo1272a, bArr, i, i2, i3, c1876sm);
        c0732ap.mo1275d(mo1272a);
        c1876sm.f6513c = mo1272a;
        return m2224o;
    }

    /* renamed from: g */
    public static int m7398g(zzhi zzhiVar, byte[] bArr, int i, int i2, C1876sm c1876sm) throws IOException {
        int i3 = i + 1;
        int i4 = bArr[i];
        if (i4 < 0) {
            i3 = m7395d(i4, bArr, i3, c1876sm);
            i4 = c1876sm.f6511a;
        }
        int i5 = i3;
        if (i4 < 0 || i4 > i2 - i5) {
            throw C0839co.m2889a();
        }
        Object mo1272a = zzhiVar.mo1272a();
        int i6 = i4 + i5;
        zzhiVar.mo1279h(mo1272a, bArr, i5, i6, c1876sm);
        zzhiVar.mo1275d(mo1272a);
        c1876sm.f6513c = mo1272a;
        return i6;
    }

    /* renamed from: h */
    public static int m7399h(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    /* renamed from: i */
    public static int m7400i(byte[] bArr, int i, C1876sm c1876sm) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return m7395d(b, bArr, i2, c1876sm);
        }
        c1876sm.f6511a = b;
        return i2;
    }

    /* renamed from: j */
    public static int m7401j(byte[] bArr, int i, zzfq<?> zzfqVar, C1876sm c1876sm) throws IOException {
        C0724ao c0724ao = (C0724ao) zzfqVar;
        int m7400i = m7400i(bArr, i, c1876sm);
        int i2 = c1876sm.f6511a + m7400i;
        while (m7400i < i2) {
            m7400i = m7400i(bArr, m7400i, c1876sm);
            c0724ao.m2168h(c1876sm.f6511a);
        }
        if (m7400i == i2) {
            return m7400i;
        }
        throw C0839co.m2889a();
    }

    /* renamed from: k */
    public static int m7402k(byte[] bArr, int i, C1876sm c1876sm) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            c1876sm.f6512b = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & Byte.MAX_VALUE) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & Byte.MAX_VALUE) << i4;
            b = bArr[i3];
            i3 = i5;
        }
        c1876sm.f6512b = j2;
        return i3;
    }

    /* renamed from: l */
    public static long m7403l(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    /* renamed from: m */
    public static double m7404m(byte[] bArr, int i) {
        return Double.longBitsToDouble(m7403l(bArr, i));
    }

    /* renamed from: n */
    public static int m7405n(byte[] bArr, int i, C1876sm c1876sm) throws C0839co {
        int m7400i = m7400i(bArr, i, c1876sm);
        int i2 = c1876sm.f6511a;
        if (i2 < 0) {
            throw C0839co.m2890b();
        }
        if (i2 == 0) {
            c1876sm.f6513c = "";
            return m7400i;
        }
        c1876sm.f6513c = new String(bArr, m7400i, i2, C2435zn.f8565a);
        return m7400i + i2;
    }

    /* renamed from: o */
    public static float m7406o(byte[] bArr, int i) {
        return Float.intBitsToFloat(m7399h(bArr, i));
    }

    /* renamed from: p */
    public static int m7407p(byte[] bArr, int i, C1876sm c1876sm) throws C0839co {
        int m7400i = m7400i(bArr, i, c1876sm);
        int i2 = c1876sm.f6511a;
        if (i2 < 0) {
            throw C0839co.m2890b();
        }
        if (i2 == 0) {
            c1876sm.f6513c = "";
            return m7400i;
        }
        c1876sm.f6513c = C1008fq.m3866k(bArr, m7400i, i2);
        return m7400i + i2;
    }

    /* renamed from: q */
    public static int m7408q(byte[] bArr, int i, C1876sm c1876sm) throws C0839co {
        int m7400i = m7400i(bArr, i, c1876sm);
        int i2 = c1876sm.f6511a;
        if (i2 < 0) {
            throw C0839co.m2890b();
        }
        if (i2 > bArr.length - m7400i) {
            throw C0839co.m2889a();
        }
        if (i2 == 0) {
            c1876sm.f6513c = AbstractC1939tm.f6790P;
            return m7400i;
        }
        c1876sm.f6513c = AbstractC1939tm.m8764k(bArr, m7400i, i2);
        return m7400i + i2;
    }
}
