package com.sonelli;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1SetParser;

/* loaded from: classes.dex */
public class nr0 implements ASN1SetParser {

    /* renamed from: O */
    public hq0 f5356O;

    public nr0(hq0 hq0Var) {
        this.f5356O = hq0Var;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        try {
            return mo2595g();
        } catch (IOException e) {
            throw new dq0(e.getMessage(), e);
        }
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    /* renamed from: g */
    public eq0 mo2595g() throws IOException {
        return new bs0(this.f5356O.m4641d());
    }
}
