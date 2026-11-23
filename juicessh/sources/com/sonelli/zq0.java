package com.sonelli;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.InMemoryRepresentable;

/* loaded from: classes.dex */
public class zq0 implements ASN1Encodable, InMemoryRepresentable {

    /* renamed from: O */
    public hq0 f8582O;

    public zq0(hq0 hq0Var) {
        this.f8582O = hq0Var;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        try {
            return mo2595g();
        } catch (IOException e) {
            throw new dq0("unable to get DER object", e);
        } catch (IllegalArgumentException e2) {
            throw new dq0("unable to get DER object", e2);
        }
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    /* renamed from: g */
    public eq0 mo2595g() throws IOException {
        try {
            return new wr0(this.f8582O.m4641d());
        } catch (IllegalArgumentException e) {
            throw new tp0(e.getMessage(), e);
        }
    }
}
