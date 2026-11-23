package cz.opentree;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1TaggedObjectParser;

/* loaded from: classes.dex */
public class uq0 implements ASN1TaggedObjectParser {

    /* renamed from: O */
    public boolean f7090O;

    /* renamed from: P */
    public int f7091P;

    /* renamed from: Q */
    public hq0 f7092Q;

    public uq0(boolean z, int i, hq0 hq0Var) {
        this.f7090O = z;
        this.f7091P = i;
        this.f7092Q = hq0Var;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        try {
            return mo2595g();
        } catch (IOException e) {
            throw new dq0(e.getMessage());
        }
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    /* renamed from: g */
    public eq0 mo2595g() throws IOException {
        return this.f7092Q.m4640c(this.f7090O, this.f7091P);
    }
}
