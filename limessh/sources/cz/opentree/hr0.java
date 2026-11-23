package cz.opentree;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1OctetStringParser;

/* loaded from: classes.dex */
public class hr0 implements ASN1OctetStringParser {

    /* renamed from: O */
    public es0 f3221O;

    public hr0(es0 es0Var) {
        this.f3221O = es0Var;
    }

    @Override // org.bouncycastle.asn1.ASN1OctetStringParser
    /* renamed from: e */
    public InputStream mo2594e() {
        return this.f3221O;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        try {
            return mo2595g();
        } catch (IOException e) {
            throw new dq0("IOException converting stream to byte array: " + e.getMessage(), e);
        }
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    /* renamed from: g */
    public eq0 mo2595g() throws IOException {
        return new gr0(this.f3221O.m3553f());
    }
}
