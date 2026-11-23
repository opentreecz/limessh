package cz.opentree;

import org.bouncycastle.asn1.ASN1Encodable;

/* loaded from: classes.dex */
public class u01 extends zp0 {

    /* renamed from: O */
    public xp0 f6882O;

    /* renamed from: P */
    public aq0 f6883P;

    /* renamed from: Q */
    public byte[][] f6884Q;

    /* renamed from: R */
    public byte[] f6885R;

    /* renamed from: S */
    public byte[][] f6886S;

    /* renamed from: T */
    public byte[] f6887T;

    /* renamed from: U */
    public byte[] f6888U;

    /* renamed from: V */
    public d21[] f6889V;

    public u01(fq0 fq0Var) {
        int i = 0;
        if (fq0Var.mo3870u(0) instanceof xp0) {
            this.f6882O = xp0.m9866t(fq0Var.mo3870u(0));
        } else {
            this.f6883P = aq0.m2251A(fq0Var.mo3870u(0));
        }
        fq0 fq0Var2 = (fq0) fq0Var.mo3870u(1);
        this.f6884Q = new byte[fq0Var2.size()];
        for (int i2 = 0; i2 < fq0Var2.size(); i2++) {
            this.f6884Q[i2] = ((bq0) fq0Var2.mo3870u(i2)).m2598v();
        }
        this.f6885R = ((bq0) ((fq0) fq0Var.mo3870u(2)).mo3870u(0)).m2598v();
        fq0 fq0Var3 = (fq0) fq0Var.mo3870u(3);
        this.f6886S = new byte[fq0Var3.size()];
        for (int i3 = 0; i3 < fq0Var3.size(); i3++) {
            this.f6886S[i3] = ((bq0) fq0Var3.mo3870u(i3)).m2598v();
        }
        this.f6887T = ((bq0) ((fq0) fq0Var.mo3870u(4)).mo3870u(0)).m2598v();
        this.f6888U = ((bq0) ((fq0) fq0Var.mo3870u(5)).mo3870u(0)).m2598v();
        fq0 fq0Var4 = (fq0) fq0Var.mo3870u(6);
        byte[][][][] bArr = new byte[fq0Var4.size()][][];
        byte[][][][] bArr2 = new byte[fq0Var4.size()][][];
        byte[][][] bArr3 = new byte[fq0Var4.size()][];
        byte[][] bArr4 = new byte[fq0Var4.size()];
        int i4 = 0;
        while (i4 < fq0Var4.size()) {
            fq0 fq0Var5 = (fq0) fq0Var4.mo3870u(i4);
            fq0 fq0Var6 = (fq0) fq0Var5.mo3870u(i);
            bArr[i4] = new byte[fq0Var6.size()][];
            for (int i5 = i; i5 < fq0Var6.size(); i5++) {
                fq0 fq0Var7 = (fq0) fq0Var6.mo3870u(i5);
                bArr[i4][i5] = new byte[fq0Var7.size()];
                for (int i6 = 0; i6 < fq0Var7.size(); i6++) {
                    bArr[i4][i5][i6] = ((bq0) fq0Var7.mo3870u(i6)).m2598v();
                }
            }
            fq0 fq0Var8 = (fq0) fq0Var5.mo3870u(1);
            bArr2[i4] = new byte[fq0Var8.size()][];
            for (int i7 = 0; i7 < fq0Var8.size(); i7++) {
                fq0 fq0Var9 = (fq0) fq0Var8.mo3870u(i7);
                bArr2[i4][i7] = new byte[fq0Var9.size()];
                for (int i8 = 0; i8 < fq0Var9.size(); i8++) {
                    bArr2[i4][i7][i8] = ((bq0) fq0Var9.mo3870u(i8)).m2598v();
                }
            }
            fq0 fq0Var10 = (fq0) fq0Var5.mo3870u(2);
            bArr3[i4] = new byte[fq0Var10.size()];
            for (int i9 = 0; i9 < fq0Var10.size(); i9++) {
                bArr3[i4][i9] = ((bq0) fq0Var10.mo3870u(i9)).m2598v();
            }
            bArr4[i4] = ((bq0) fq0Var5.mo3870u(3)).m2598v();
            i4++;
            i = 0;
        }
        int length = this.f6888U.length - 1;
        this.f6889V = new d21[length];
        int i10 = 0;
        while (i10 < length) {
            byte[] bArr5 = this.f6888U;
            int i11 = i10 + 1;
            this.f6889V[i10] = new d21(bArr5[i10], bArr5[i11], e21.m3389f(bArr[i10]), e21.m3389f(bArr2[i10]), e21.m3387d(bArr3[i10]), e21.m3385b(bArr4[i10]));
            i10 = i11;
        }
    }

    public u01(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, d21[] d21VarArr) {
        this.f6882O = new xp0(1L);
        this.f6884Q = e21.m3386c(sArr);
        this.f6885R = e21.m3384a(sArr2);
        this.f6886S = e21.m3386c(sArr3);
        this.f6887T = e21.m3384a(sArr4);
        this.f6888U = e21.m3391h(iArr);
        this.f6889V = d21VarArr;
    }

    /* renamed from: n */
    public static u01 m8824n(Object obj) {
        if (obj instanceof u01) {
            return (u01) obj;
        }
        if (obj != null) {
            return new u01(fq0.m3869t(obj));
        }
        return null;
    }

    @Override // cz.opentree.zp0, org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        rp0 rp0Var = new rp0();
        ASN1Encodable aSN1Encodable = this.f6882O;
        if (aSN1Encodable == null) {
            aSN1Encodable = this.f6883P;
        }
        rp0Var.m8224a(aSN1Encodable);
        rp0 rp0Var2 = new rp0();
        int i = 0;
        while (true) {
            byte[][] bArr = this.f6884Q;
            if (i >= bArr.length) {
                break;
            }
            rp0Var2.m8224a(new gr0(bArr[i]));
            i++;
        }
        rp0Var.m8224a(new kr0(rp0Var2));
        rp0 rp0Var3 = new rp0();
        rp0Var3.m8224a(new gr0(this.f6885R));
        rp0Var.m8224a(new kr0(rp0Var3));
        rp0 rp0Var4 = new rp0();
        int i2 = 0;
        while (true) {
            byte[][] bArr2 = this.f6886S;
            if (i2 >= bArr2.length) {
                break;
            }
            rp0Var4.m8224a(new gr0(bArr2[i2]));
            i2++;
        }
        rp0Var.m8224a(new kr0(rp0Var4));
        rp0 rp0Var5 = new rp0();
        rp0Var5.m8224a(new gr0(this.f6887T));
        rp0Var.m8224a(new kr0(rp0Var5));
        rp0 rp0Var6 = new rp0();
        rp0Var6.m8224a(new gr0(this.f6888U));
        rp0Var.m8224a(new kr0(rp0Var6));
        rp0 rp0Var7 = new rp0();
        for (int i3 = 0; i3 < this.f6889V.length; i3++) {
            rp0 rp0Var8 = new rp0();
            byte[][][] m3388e = e21.m3388e(this.f6889V[i3].m3104a());
            rp0 rp0Var9 = new rp0();
            for (int i4 = 0; i4 < m3388e.length; i4++) {
                rp0 rp0Var10 = new rp0();
                for (int i5 = 0; i5 < m3388e[i4].length; i5++) {
                    rp0Var10.m8224a(new gr0(m3388e[i4][i5]));
                }
                rp0Var9.m8224a(new kr0(rp0Var10));
            }
            rp0Var8.m8224a(new kr0(rp0Var9));
            byte[][][] m3388e2 = e21.m3388e(this.f6889V[i3].m3105b());
            rp0 rp0Var11 = new rp0();
            for (int i6 = 0; i6 < m3388e2.length; i6++) {
                rp0 rp0Var12 = new rp0();
                for (int i7 = 0; i7 < m3388e2[i6].length; i7++) {
                    rp0Var12.m8224a(new gr0(m3388e2[i6][i7]));
                }
                rp0Var11.m8224a(new kr0(rp0Var12));
            }
            rp0Var8.m8224a(new kr0(rp0Var11));
            byte[][] m3386c = e21.m3386c(this.f6889V[i3].m3107d());
            rp0 rp0Var13 = new rp0();
            for (byte[] bArr3 : m3386c) {
                rp0Var13.m8224a(new gr0(bArr3));
            }
            rp0Var8.m8224a(new kr0(rp0Var13));
            rp0Var8.m8224a(new gr0(e21.m3384a(this.f6889V[i3].m3106c())));
            rp0Var7.m8224a(new kr0(rp0Var8));
        }
        rp0Var.m8224a(new kr0(rp0Var7));
        return new kr0(rp0Var);
    }

    /* renamed from: k */
    public short[] m8825k() {
        return e21.m3385b(this.f6885R);
    }

    /* renamed from: m */
    public short[] m8826m() {
        return e21.m3385b(this.f6887T);
    }

    /* renamed from: o */
    public short[][] m8827o() {
        return e21.m3387d(this.f6884Q);
    }

    /* renamed from: p */
    public short[][] m8828p() {
        return e21.m3387d(this.f6886S);
    }

    /* renamed from: q */
    public d21[] m8829q() {
        return this.f6889V;
    }

    /* renamed from: r */
    public int[] m8830r() {
        return e21.m3390g(this.f6888U);
    }
}
