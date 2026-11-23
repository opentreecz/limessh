package cz.opentree;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1OctetStringParser;

/* loaded from: classes.dex */
public class oq0 implements ASN1OctetStringParser {

    /* renamed from: O */
    public hq0 f5533O;

    public oq0(hq0 hq0Var) {
        this.f5533O = hq0Var;
    }

    @Override // org.bouncycastle.asn1.ASN1OctetStringParser
    /* renamed from: e */
    public InputStream mo2594e() {
        return new vq0(this.f5533O);
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
        return new nq0(r51.m7880b(mo2594e()));
    }
}
