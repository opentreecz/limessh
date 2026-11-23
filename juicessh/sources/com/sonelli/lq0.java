package com.sonelli;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1ApplicationSpecificParser;

/* loaded from: classes.dex */
public class lq0 implements ASN1ApplicationSpecificParser {

    /* renamed from: O */
    public final int f4902O;

    /* renamed from: P */
    public final hq0 f4903P;

    public lq0(int i, hq0 hq0Var) {
        this.f4902O = i;
        this.f4903P = hq0Var;
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
        return new kq0(this.f4902O, this.f4903P.m4641d());
    }
}
