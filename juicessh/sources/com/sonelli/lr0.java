package com.sonelli;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1SequenceParser;

/* loaded from: classes.dex */
public class lr0 implements ASN1SequenceParser {

    /* renamed from: O */
    public hq0 f4906O;

    public lr0(hq0 hq0Var) {
        this.f4906O = hq0Var;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        try {
            return mo2595g();
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    /* renamed from: g */
    public eq0 mo2595g() throws IOException {
        return new zr0(this.f4906O.m4641d());
    }
}
