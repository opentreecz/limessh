package cz.opentree;

/* loaded from: classes.dex */
public class s01 extends zp0 {

    /* renamed from: O */
    public int f6315O;

    /* renamed from: P */
    public int f6316P;

    /* renamed from: Q */
    public byte[] f6317Q;

    /* renamed from: R */
    public byte[] f6318R;

    /* renamed from: S */
    public byte[] f6319S;

    /* renamed from: T */
    public byte[] f6320T;

    /* renamed from: U */
    public byte[] f6321U;

    public s01(int i, int i2, u41 u41Var, b51 b51Var, a51 a51Var, a51 a51Var2, t41 t41Var) {
        this.f6315O = i;
        this.f6316P = i2;
        this.f6317Q = u41Var.m8848e();
        this.f6318R = b51Var.m2385h();
        this.f6319S = t41Var.m8594c();
        this.f6320T = a51Var.m1980a();
        this.f6321U = a51Var2.m1980a();
    }

    public s01(fq0 fq0Var) {
        this.f6315O = ((xp0) fq0Var.mo3870u(0)).m9868B();
        this.f6316P = ((xp0) fq0Var.mo3870u(1)).m9868B();
        this.f6317Q = ((bq0) fq0Var.mo3870u(2)).m2598v();
        this.f6318R = ((bq0) fq0Var.mo3870u(3)).m2598v();
        this.f6320T = ((bq0) fq0Var.mo3870u(4)).m2598v();
        this.f6321U = ((bq0) fq0Var.mo3870u(5)).m2598v();
        this.f6319S = ((bq0) fq0Var.mo3870u(6)).m2598v();
    }

    /* renamed from: n */
    public static s01 m8291n(Object obj) {
        if (obj instanceof s01) {
            return (s01) obj;
        }
        if (obj != null) {
            return new s01(fq0.m3869t(obj));
        }
        return null;
    }

    @Override // cz.opentree.zp0, org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        rp0 rp0Var = new rp0();
        rp0Var.m8224a(new xp0(this.f6315O));
        rp0Var.m8224a(new xp0(this.f6316P));
        rp0Var.m8224a(new gr0(this.f6317Q));
        rp0Var.m8224a(new gr0(this.f6318R));
        rp0Var.m8224a(new gr0(this.f6320T));
        rp0Var.m8224a(new gr0(this.f6321U));
        rp0Var.m8224a(new gr0(this.f6319S));
        return new kr0(rp0Var);
    }

    /* renamed from: k */
    public u41 m8292k() {
        return new u41(this.f6317Q);
    }

    /* renamed from: m */
    public b51 m8293m() {
        return new b51(m8292k(), this.f6318R);
    }

    /* renamed from: o */
    public int m8294o() {
        return this.f6316P;
    }

    /* renamed from: p */
    public int m8295p() {
        return this.f6315O;
    }

    /* renamed from: q */
    public a51 m8296q() {
        return new a51(this.f6320T);
    }

    /* renamed from: r */
    public a51 m8297r() {
        return new a51(this.f6321U);
    }

    /* renamed from: s */
    public t41 m8298s() {
        return new t41(this.f6319S);
    }
}
