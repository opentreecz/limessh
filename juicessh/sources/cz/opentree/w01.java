package cz.opentree;

/* loaded from: classes.dex */
public class w01 extends zp0 {

    /* renamed from: O */
    public final xp0 f7584O;

    /* renamed from: P */
    public final vs0 f7585P;

    public w01(fq0 fq0Var) {
        this.f7584O = xp0.m9866t(fq0Var.mo3870u(0));
        this.f7585P = vs0.m9342m(fq0Var.mo3870u(1));
    }

    public w01(vs0 vs0Var) {
        this.f7584O = new xp0(0L);
        this.f7585P = vs0Var;
    }

    /* renamed from: k */
    public static final w01 m9379k(Object obj) {
        if (obj instanceof w01) {
            return (w01) obj;
        }
        if (obj != null) {
            return new w01(fq0.m3869t(obj));
        }
        return null;
    }

    @Override // cz.opentree.zp0, org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        rp0 rp0Var = new rp0();
        rp0Var.m8224a(this.f7584O);
        rp0Var.m8224a(this.f7585P);
        return new kr0(rp0Var);
    }

    /* renamed from: m */
    public vs0 m9380m() {
        return this.f7585P;
    }
}
