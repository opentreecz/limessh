package cz.opentree;

/* loaded from: classes.dex */
public class q01 extends zp0 {

    /* renamed from: O */
    public int f5900O;

    /* renamed from: P */
    public int f5901P;

    /* renamed from: Q */
    public byte[] f5902Q;

    /* renamed from: R */
    public byte[] f5903R;

    /* renamed from: S */
    public byte[] f5904S;

    /* renamed from: T */
    public vs0 f5905T;

    public q01(int i, int i2, u41 u41Var, b51 b51Var, a51 a51Var, vs0 vs0Var) {
        this.f5900O = i;
        this.f5901P = i2;
        this.f5902Q = u41Var.m8848e();
        this.f5903R = b51Var.m2385h();
        this.f5904S = a51Var.m1980a();
        this.f5905T = vs0Var;
    }

    public q01(fq0 fq0Var) {
        this.f5900O = ((xp0) fq0Var.mo3870u(0)).m9868B();
        this.f5901P = ((xp0) fq0Var.mo3870u(1)).m9868B();
        this.f5902Q = ((bq0) fq0Var.mo3870u(2)).m2598v();
        this.f5903R = ((bq0) fq0Var.mo3870u(3)).m2598v();
        this.f5904S = ((bq0) fq0Var.mo3870u(4)).m2598v();
        this.f5905T = vs0.m9342m(fq0Var.mo3870u(5));
    }

    /* renamed from: o */
    public static q01 m7591o(Object obj) {
        if (obj instanceof q01) {
            return (q01) obj;
        }
        if (obj != null) {
            return new q01(fq0.m3869t(obj));
        }
        return null;
    }

    @Override // cz.opentree.zp0, org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        rp0 rp0Var = new rp0();
        rp0Var.m8224a(new xp0(this.f5900O));
        rp0Var.m8224a(new xp0(this.f5901P));
        rp0Var.m8224a(new gr0(this.f5902Q));
        rp0Var.m8224a(new gr0(this.f5903R));
        rp0Var.m8224a(new gr0(this.f5904S));
        rp0Var.m8224a(this.f5905T);
        return new kr0(rp0Var);
    }

    /* renamed from: k */
    public vs0 m7592k() {
        return this.f5905T;
    }

    /* renamed from: m */
    public u41 m7593m() {
        return new u41(this.f5902Q);
    }

    /* renamed from: n */
    public b51 m7594n() {
        return new b51(m7593m(), this.f5903R);
    }

    /* renamed from: p */
    public int m7595p() {
        return this.f5901P;
    }

    /* renamed from: q */
    public int m7596q() {
        return this.f5900O;
    }

    /* renamed from: r */
    public a51 m7597r() {
        return new a51(this.f5904S);
    }
}
