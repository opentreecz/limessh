package com.sonelli;

import java.io.IOException;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;

/* loaded from: classes.dex */
public class ws0 extends zp0 {

    /* renamed from: O */
    public vs0 f7792O;

    /* renamed from: P */
    public xq0 f7793P;

    public ws0(fq0 fq0Var) {
        if (fq0Var.size() == 2) {
            Enumeration mo3871v = fq0Var.mo3871v();
            this.f7792O = vs0.m9342m(mo3871v.nextElement());
            this.f7793P = xq0.m9874B(mo3871v.nextElement());
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + fq0Var.size());
        }
    }

    public ws0(vs0 vs0Var, ASN1Encodable aSN1Encodable) throws IOException {
        this.f7793P = new xq0(aSN1Encodable);
        this.f7792O = vs0Var;
    }

    public ws0(vs0 vs0Var, byte[] bArr) {
        this.f7793P = new xq0(bArr);
        this.f7792O = vs0Var;
    }

    /* renamed from: m */
    public static ws0 m9635m(Object obj) {
        if (obj instanceof ws0) {
            return (ws0) obj;
        }
        if (obj != null) {
            return new ws0(fq0.m3869t(obj));
        }
        return null;
    }

    @Override // com.sonelli.zp0, org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        rp0 rp0Var = new rp0(2);
        rp0Var.m8224a(this.f7792O);
        rp0Var.m8224a(this.f7793P);
        return new kr0(rp0Var);
    }

    /* renamed from: k */
    public vs0 m9636k() {
        return this.f7792O;
    }

    /* renamed from: n */
    public xq0 m9637n() {
        return this.f7793P;
    }

    /* renamed from: o */
    public eq0 m9638o() throws IOException {
        return eq0.m3546p(this.f7793P.m7438w());
    }
}
