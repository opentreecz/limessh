package cz.opentree;

import com.google.android.gms.internal.measurement.zzix;
import cz.opentree.AbstractC2303xn;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.zp */
/* loaded from: classes.dex */
public final class C2437zp {

    /* renamed from: f */
    public static final C2437zp f8574f = new C2437zp(0, new int[0], new Object[0], false);

    /* renamed from: a */
    public int f8575a;

    /* renamed from: b */
    public int[] f8576b;

    /* renamed from: c */
    public Object[] f8577c;

    /* renamed from: d */
    public int f8578d;

    /* renamed from: e */
    public boolean f8579e;

    public C2437zp() {
        this(0, new int[8], new Object[8], true);
    }

    public C2437zp(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f8578d = -1;
        this.f8575a = i;
        this.f8576b = iArr;
        this.f8577c = objArr;
        this.f8579e = z;
    }

    /* renamed from: a */
    public static C2437zp m10576a() {
        return f8574f;
    }

    /* renamed from: b */
    public static C2437zp m10577b(C2437zp c2437zp, C2437zp c2437zp2) {
        int i = c2437zp.f8575a + c2437zp2.f8575a;
        int[] copyOf = Arrays.copyOf(c2437zp.f8576b, i);
        System.arraycopy(c2437zp2.f8576b, 0, copyOf, c2437zp.f8575a, c2437zp2.f8575a);
        Object[] copyOf2 = Arrays.copyOf(c2437zp.f8577c, i);
        System.arraycopy(c2437zp2.f8577c, 0, copyOf2, c2437zp.f8575a, c2437zp2.f8575a);
        return new C2437zp(i, copyOf, copyOf2, true);
    }

    /* renamed from: d */
    public static void m10578d(int i, Object obj, zzix zzixVar) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzixVar.mo1321w(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 1) {
            zzixVar.mo1294K(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 2) {
            zzixVar.mo1286C(i2, (AbstractC1939tm) obj);
            return;
        }
        if (i3 != 3) {
            if (i3 != 5) {
                throw new RuntimeException(C0839co.m2892d());
            }
            zzixVar.mo1293J(i2, ((Integer) obj).intValue());
        } else if (zzixVar.mo1299a() == AbstractC2303xn.e.f8034k) {
            zzixVar.mo1301c(i2);
            ((C2437zp) obj).m10583h(zzixVar);
            zzixVar.mo1302d(i2);
        } else {
            zzixVar.mo1302d(i2);
            ((C2437zp) obj).m10583h(zzixVar);
            zzixVar.mo1301c(i2);
        }
    }

    /* renamed from: g */
    public static C2437zp m10579g() {
        return new C2437zp();
    }

    /* renamed from: c */
    public final void m10580c(int i, Object obj) {
        if (!this.f8579e) {
            throw new UnsupportedOperationException();
        }
        int i2 = this.f8575a;
        int[] iArr = this.f8576b;
        if (i2 == iArr.length) {
            int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
            this.f8576b = Arrays.copyOf(iArr, i3);
            this.f8577c = Arrays.copyOf(this.f8577c, i3);
        }
        int[] iArr2 = this.f8576b;
        int i4 = this.f8575a;
        iArr2[i4] = i;
        this.f8577c[i4] = obj;
        this.f8575a = i4 + 1;
    }

    /* renamed from: e */
    public final void m10581e(zzix zzixVar) throws IOException {
        if (zzixVar.mo1299a() == AbstractC2303xn.e.f8035l) {
            for (int i = this.f8575a - 1; i >= 0; i--) {
                zzixVar.mo1313o(this.f8576b[i] >>> 3, this.f8577c[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.f8575a; i2++) {
            zzixVar.mo1313o(this.f8576b[i2] >>> 3, this.f8577c[i2]);
        }
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C2437zp)) {
            return false;
        }
        C2437zp c2437zp = (C2437zp) obj;
        int i = this.f8575a;
        if (i == c2437zp.f8575a) {
            int[] iArr = this.f8576b;
            int[] iArr2 = c2437zp.f8576b;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                }
                if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (z) {
                Object[] objArr = this.f8577c;
                Object[] objArr2 = c2437zp.f8577c;
                int i3 = this.f8575a;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    }
                    if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    }
                    i4++;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: f */
    public final void m10582f(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.f8575a; i2++) {
            C2363yo.m10207d(sb, i, String.valueOf(this.f8576b[i2] >>> 3), this.f8577c[i2]);
        }
    }

    /* renamed from: h */
    public final void m10583h(zzix zzixVar) throws IOException {
        if (this.f8575a == 0) {
            return;
        }
        if (zzixVar.mo1299a() == AbstractC2303xn.e.f8034k) {
            for (int i = 0; i < this.f8575a; i++) {
                m10578d(this.f8576b[i], this.f8577c[i], zzixVar);
            }
            return;
        }
        for (int i2 = this.f8575a - 1; i2 >= 0; i2--) {
            m10578d(this.f8576b[i2], this.f8577c[i2], zzixVar);
        }
    }

    public final int hashCode() {
        int i = this.f8575a;
        int i2 = (i + 527) * 31;
        int[] iArr = this.f8576b;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.f8577c;
        int i7 = this.f8575a;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* renamed from: i */
    public final void m10584i() {
        this.f8579e = false;
    }

    /* renamed from: j */
    public final int m10585j() {
        int i = this.f8578d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f8575a; i3++) {
            i2 += AbstractC1116hn.m4514d0(this.f8576b[i3] >>> 3, (AbstractC1939tm) this.f8577c[i3]);
        }
        this.f8578d = i2;
        return i2;
    }

    /* renamed from: k */
    public final int m10586k() {
        int m4519i0;
        int i = this.f8578d;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f8575a; i3++) {
            int i4 = this.f8576b[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 == 0) {
                m4519i0 = AbstractC1116hn.m4519i0(i5, ((Long) this.f8577c[i3]).longValue());
            } else if (i6 == 1) {
                m4519i0 = AbstractC1116hn.m4527r0(i5, ((Long) this.f8577c[i3]).longValue());
            } else if (i6 == 2) {
                m4519i0 = AbstractC1116hn.m4507U(i5, (AbstractC1939tm) this.f8577c[i3]);
            } else if (i6 == 3) {
                m4519i0 = (AbstractC1116hn.m4518h0(i5) << 1) + ((C2437zp) this.f8577c[i3]).m10586k();
            } else {
                if (i6 != 5) {
                    throw new IllegalStateException(C0839co.m2892d());
                }
                m4519i0 = AbstractC1116hn.m4534y0(i5, ((Integer) this.f8577c[i3]).intValue());
            }
            i2 += m4519i0;
        }
        this.f8578d = i2;
        return i2;
    }
}
