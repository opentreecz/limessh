package cz.opentree;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1SetParser;

/* loaded from: classes.dex */
public class sq0 implements ASN1SetParser {

    /* renamed from: O */
    public hq0 f6585O;

    public sq0(hq0 hq0Var) {
        this.f6585O = hq0Var;
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
        return new rq0(this.f6585O.m4641d());
    }
}
