package cz.opentree;

/* loaded from: classes.dex */
public class y01 extends zp0 {

    /* renamed from: O */
    public final xp0 f8103O;

    /* renamed from: P */
    public final int f8104P;

    /* renamed from: Q */
    public final int f8105Q;

    /* renamed from: R */
    public final vs0 f8106R;

    public y01(int i, int i2, vs0 vs0Var) {
        this.f8103O = new xp0(0L);
        this.f8104P = i;
        this.f8105Q = i2;
        this.f8106R = vs0Var;
    }

    public y01(fq0 fq0Var) {
        this.f8103O = xp0.m9866t(fq0Var.mo3870u(0));
        this.f8104P = xp0.m9866t(fq0Var.mo3870u(1)).m9868B();
        this.f8105Q = xp0.m9866t(fq0Var.mo3870u(2)).m9868B();
        this.f8106R = vs0.m9342m(fq0Var.mo3870u(3));
    }

    /* renamed from: m */
    public static y01 m10042m(Object obj) {
        if (obj instanceof y01) {
            return (y01) obj;
        }
        if (obj != null) {
            return new y01(fq0.m3869t(obj));
        }
        return null;
    }

    @Override // cz.opentree.zp0, org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        rp0 rp0Var = new rp0();
        rp0Var.m8224a(this.f8103O);
        rp0Var.m8224a(new xp0(this.f8104P));
        rp0Var.m8224a(new xp0(this.f8105Q));
        rp0Var.m8224a(this.f8106R);
        return new kr0(rp0Var);
    }

    /* renamed from: k */
    public int m10043k() {
        return this.f8104P;
    }

    /* renamed from: n */
    public int m10044n() {
        return this.f8105Q;
    }

    /* renamed from: o */
    public vs0 m10045o() {
        return this.f8106R;
    }
}
