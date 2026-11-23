package cz.opentree;

import org.bouncycastle.asn1.ASN1Encodable;

/* loaded from: classes.dex */
public class v01 extends zp0 {

    /* renamed from: O */
    public xp0 f7381O;

    /* renamed from: P */
    public aq0 f7382P;

    /* renamed from: Q */
    public xp0 f7383Q;

    /* renamed from: R */
    public byte[][] f7384R;

    /* renamed from: S */
    public byte[][] f7385S;

    /* renamed from: T */
    public byte[] f7386T;

    public v01(int i, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.f7381O = new xp0(0L);
        this.f7383Q = new xp0(i);
        this.f7384R = e21.m3386c(sArr);
        this.f7385S = e21.m3386c(sArr2);
        this.f7386T = e21.m3384a(sArr3);
    }

    public v01(fq0 fq0Var) {
        if (fq0Var.mo3870u(0) instanceof xp0) {
            this.f7381O = xp0.m9866t(fq0Var.mo3870u(0));
        } else {
            this.f7382P = aq0.m2251A(fq0Var.mo3870u(0));
        }
        this.f7383Q = xp0.m9866t(fq0Var.mo3870u(1));
        fq0 m3869t = fq0.m3869t(fq0Var.mo3870u(2));
        this.f7384R = new byte[m3869t.size()];
        for (int i = 0; i < m3869t.size(); i++) {
            this.f7384R[i] = bq0.m2592t(m3869t.mo3870u(i)).m2598v();
        }
        fq0 fq0Var2 = (fq0) fq0Var.mo3870u(3);
        this.f7385S = new byte[fq0Var2.size()];
        for (int i2 = 0; i2 < fq0Var2.size(); i2++) {
            this.f7385S[i2] = bq0.m2592t(fq0Var2.mo3870u(i2)).m2598v();
        }
        this.f7386T = bq0.m2592t(((fq0) fq0Var.mo3870u(4)).mo3870u(0)).m2598v();
    }

    /* renamed from: p */
    public static v01 m9136p(Object obj) {
        if (obj instanceof v01) {
            return (v01) obj;
        }
        if (obj != null) {
            return new v01(fq0.m3869t(obj));
        }
        return null;
    }

    @Override // cz.opentree.zp0, org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        rp0 rp0Var = new rp0();
        ASN1Encodable aSN1Encodable = this.f7381O;
        if (aSN1Encodable == null) {
            aSN1Encodable = this.f7382P;
        }
        rp0Var.m8224a(aSN1Encodable);
        rp0Var.m8224a(this.f7383Q);
        rp0 rp0Var2 = new rp0();
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[][] bArr = this.f7384R;
            if (i2 >= bArr.length) {
                break;
            }
            rp0Var2.m8224a(new gr0(bArr[i2]));
            i2++;
        }
        rp0Var.m8224a(new kr0(rp0Var2));
        rp0 rp0Var3 = new rp0();
        while (true) {
            byte[][] bArr2 = this.f7385S;
            if (i >= bArr2.length) {
                rp0Var.m8224a(new kr0(rp0Var3));
                rp0 rp0Var4 = new rp0();
                rp0Var4.m8224a(new gr0(this.f7386T));
                rp0Var.m8224a(new kr0(rp0Var4));
                return new kr0(rp0Var);
            }
            rp0Var3.m8224a(new gr0(bArr2[i]));
            i++;
        }
    }

    /* renamed from: k */
    public short[][] m9137k() {
        return e21.m3387d(this.f7384R);
    }

    /* renamed from: m */
    public short[] m9138m() {
        return e21.m3385b(this.f7386T);
    }

    /* renamed from: n */
    public short[][] m9139n() {
        return e21.m3387d(this.f7385S);
    }

    /* renamed from: o */
    public int m9140o() {
        return this.f7383Q.m9868B();
    }
}
