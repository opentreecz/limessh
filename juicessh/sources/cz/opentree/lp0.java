package cz.opentree;

import java.util.Arrays;

/* compiled from: SegmentedByteString.java */
/* loaded from: classes.dex */
public final class lp0 extends ap0 {

    /* renamed from: T */
    public final transient byte[][] f4900T;

    /* renamed from: U */
    public final transient int[] f4901U;

    public lp0(zo0 zo0Var, int i) {
        super(null);
        np0.m6762b(zo0Var.f8573P, 0L, i);
        jp0 jp0Var = zo0Var.f8572O;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = jp0Var.f3640c;
            int i6 = jp0Var.f3639b;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            jp0Var = jp0Var.f3643f;
        }
        this.f4900T = new byte[i4];
        this.f4901U = new int[i4 * 2];
        jp0 jp0Var2 = zo0Var.f8572O;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.f4900T;
            bArr[i7] = jp0Var2.f3638a;
            int i8 = jp0Var2.f3640c;
            int i9 = jp0Var2.f3639b;
            i2 += i8 - i9;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.f4901U;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            jp0Var2.f3641d = true;
            i7++;
            jp0Var2 = jp0Var2.f3643f;
        }
    }

    @Override // cz.opentree.ap0
    /* renamed from: A */
    public byte[] mo2235A() {
        int[] iArr = this.f4901U;
        byte[][] bArr = this.f4900T;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.f4901U;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.f4900T[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // cz.opentree.ap0
    /* renamed from: B */
    public String mo2236B() {
        return m6277E().mo2236B();
    }

    @Override // cz.opentree.ap0
    /* renamed from: C */
    public void mo2237C(zo0 zo0Var) {
        int length = this.f4900T.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f4901U;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            jp0 jp0Var = new jp0(this.f4900T[i], i3, (i3 + i4) - i2, true, false);
            jp0 jp0Var2 = zo0Var.f8572O;
            if (jp0Var2 == null) {
                jp0Var.f3644g = jp0Var;
                jp0Var.f3643f = jp0Var;
                zo0Var.f8572O = jp0Var;
            } else {
                jp0Var2.f3644g.m5183c(jp0Var);
            }
            i++;
            i2 = i4;
        }
        zo0Var.f8573P += i2;
    }

    /* renamed from: D */
    public final int m6276D(int i) {
        int binarySearch = Arrays.binarySearch(this.f4901U, 0, this.f4900T.length, i + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    /* renamed from: E */
    public final ap0 m6277E() {
        return new ap0(mo2235A());
    }

    @Override // cz.opentree.ap0
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ap0) {
            ap0 ap0Var = (ap0) obj;
            if (ap0Var.mo2247w() == mo2247w() && mo2243s(0, ap0Var, 0, mo2247w())) {
                return true;
            }
        }
        return false;
    }

    @Override // cz.opentree.ap0
    /* renamed from: f */
    public String mo2238f() {
        return m6277E().mo2238f();
    }

    @Override // cz.opentree.ap0
    public int hashCode() {
        int i = this.f1504P;
        if (i != 0) {
            return i;
        }
        int length = this.f4900T.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.f4900T[i2];
            int[] iArr = this.f4901U;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.f1504P = i3;
        return i3;
    }

    @Override // cz.opentree.ap0
    /* renamed from: p */
    public byte mo2241p(int i) {
        np0.m6762b(this.f4901U[this.f4900T.length - 1], i, 1L);
        int m6276D = m6276D(i);
        int i2 = m6276D == 0 ? 0 : this.f4901U[m6276D - 1];
        int[] iArr = this.f4901U;
        byte[][] bArr = this.f4900T;
        return bArr[m6276D][(i - i2) + iArr[bArr.length + m6276D]];
    }

    @Override // cz.opentree.ap0
    /* renamed from: q */
    public String mo2242q() {
        return m6277E().mo2242q();
    }

    @Override // cz.opentree.ap0
    /* renamed from: s */
    public boolean mo2243s(int i, ap0 ap0Var, int i2, int i3) {
        if (i < 0 || i > mo2247w() - i3) {
            return false;
        }
        int m6276D = m6276D(i);
        while (i3 > 0) {
            int i4 = m6276D == 0 ? 0 : this.f4901U[m6276D - 1];
            int min = Math.min(i3, ((this.f4901U[m6276D] - i4) + i4) - i);
            int[] iArr = this.f4901U;
            byte[][] bArr = this.f4900T;
            if (!ap0Var.mo2244t(i2, bArr[m6276D], (i - i4) + iArr[bArr.length + m6276D], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            m6276D++;
        }
        return true;
    }

    @Override // cz.opentree.ap0
    /* renamed from: t */
    public boolean mo2244t(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > mo2247w() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int m6276D = m6276D(i);
        while (i3 > 0) {
            int i4 = m6276D == 0 ? 0 : this.f4901U[m6276D - 1];
            int min = Math.min(i3, ((this.f4901U[m6276D] - i4) + i4) - i);
            int[] iArr = this.f4901U;
            byte[][] bArr2 = this.f4900T;
            if (!np0.m6761a(bArr2[m6276D], (i - i4) + iArr[bArr2.length + m6276D], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            m6276D++;
        }
        return true;
    }

    @Override // cz.opentree.ap0
    public String toString() {
        return m6277E().toString();
    }

    @Override // cz.opentree.ap0
    /* renamed from: u */
    public ap0 mo2245u() {
        return m6277E().mo2245u();
    }

    @Override // cz.opentree.ap0
    /* renamed from: v */
    public ap0 mo2246v() {
        return m6277E().mo2246v();
    }

    @Override // cz.opentree.ap0
    /* renamed from: w */
    public int mo2247w() {
        return this.f4901U[this.f4900T.length - 1];
    }

    @Override // cz.opentree.ap0
    /* renamed from: y */
    public ap0 mo2249y(int i, int i2) {
        return m6277E().mo2249y(i, i2);
    }

    @Override // cz.opentree.ap0
    /* renamed from: z */
    public ap0 mo2250z() {
        return m6277E().mo2250z();
    }
}
