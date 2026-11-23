package cz.opentree;

import org.bouncycastle.asn1.p004x9.X9ObjectIdentifiers;

/* loaded from: classes.dex */
public class zs0 extends zp0 implements X9ObjectIdentifiers {

    /* renamed from: O */
    public gv0 f8587O;

    /* renamed from: P */
    public byte[] f8588P;

    /* renamed from: Q */
    public aq0 f8589Q = null;

    public zs0(gv0 gv0Var, byte[] bArr) {
        this.f8587O = gv0Var;
        this.f8588P = e51.m3436e(bArr);
        m10627k();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0061  */
    @Override // cz.opentree.zp0, org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public cz.opentree.eq0 mo1950f() {
        /*
            r3 = this;
            cz.opentree.rp0 r0 = new cz.opentree.rp0
            r1 = 3
            r0.<init>(r1)
            cz.opentree.aq0 r1 = r3.f8589Q
            cz.opentree.aq0 r2 = org.bouncycastle.asn1.p004x9.X9ObjectIdentifiers.f8848c
            boolean r1 = r1.m3549o(r2)
            if (r1 == 0) goto L35
            cz.opentree.dt0 r1 = new cz.opentree.dt0
            cz.opentree.gv0 r2 = r3.f8587O
            cz.opentree.hv0 r2 = r2.m4266l()
            r1.<init>(r2)
            cz.opentree.eq0 r1 = r1.mo1950f()
            r0.m8224a(r1)
            cz.opentree.dt0 r1 = new cz.opentree.dt0
            cz.opentree.gv0 r2 = r3.f8587O
            cz.opentree.hv0 r2 = r2.m4267m()
            r1.<init>(r2)
        L2d:
            cz.opentree.eq0 r1 = r1.mo1950f()
            r0.m8224a(r1)
            goto L5d
        L35:
            cz.opentree.aq0 r1 = r3.f8589Q
            cz.opentree.aq0 r2 = org.bouncycastle.asn1.p004x9.X9ObjectIdentifiers.f8849d
            boolean r1 = r1.m3549o(r2)
            if (r1 == 0) goto L5d
            cz.opentree.dt0 r1 = new cz.opentree.dt0
            cz.opentree.gv0 r2 = r3.f8587O
            cz.opentree.hv0 r2 = r2.m4266l()
            r1.<init>(r2)
            cz.opentree.eq0 r1 = r1.mo1950f()
            r0.m8224a(r1)
            cz.opentree.dt0 r1 = new cz.opentree.dt0
            cz.opentree.gv0 r2 = r3.f8587O
            cz.opentree.hv0 r2 = r2.m4267m()
            r1.<init>(r2)
            goto L2d
        L5d:
            byte[] r1 = r3.f8588P
            if (r1 == 0) goto L6b
            cz.opentree.xq0 r1 = new cz.opentree.xq0
            byte[] r2 = r3.f8588P
            r1.<init>(r2)
            r0.m8224a(r1)
        L6b:
            cz.opentree.kr0 r1 = new cz.opentree.kr0
            r1.<init>(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.zs0.mo1950f():cz.opentree.eq0");
    }

    /* renamed from: k */
    public final void m10627k() {
        aq0 aq0Var;
        if (fv0.m3884e(this.f8587O)) {
            aq0Var = X9ObjectIdentifiers.f8848c;
        } else {
            if (!fv0.m3882c(this.f8587O)) {
                throw new IllegalArgumentException("This type of ECCurve is not implemented");
            }
            aq0Var = X9ObjectIdentifiers.f8849d;
        }
        this.f8589Q = aq0Var;
    }
}
