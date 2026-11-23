package cz.opentree;

/* loaded from: classes.dex */
public class ct0 extends zp0 {

    /* renamed from: O */
    public final bq0 f2043O;

    /* renamed from: P */
    public gv0 f2044P;

    /* renamed from: Q */
    public iv0 f2045Q;

    public ct0(gv0 gv0Var, byte[] bArr) {
        this.f2044P = gv0Var;
        this.f2043O = new gr0(e51.m3436e(bArr));
    }

    public ct0(iv0 iv0Var, boolean z) {
        this.f2045Q = iv0Var.m4949w();
        this.f2043O = new gr0(iv0Var.m4939j(z));
    }

    @Override // cz.opentree.zp0, org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        return this.f2043O;
    }

    /* renamed from: k */
    public synchronized iv0 m2980k() {
        if (this.f2045Q == null) {
            this.f2045Q = this.f2044P.m4263h(this.f2043O.m2598v()).m4949w();
        }
        return this.f2045Q;
    }
}
