package cz.opentree;

import java.io.IOException;
import java.security.PrivateKey;
import org.bouncycastle.pqc.jcajce.interfaces.LMSPrivateKey;

/* loaded from: classes.dex */
public class n31 implements PrivateKey, LMSPrivateKey {

    /* renamed from: O */
    public transient j11 f5215O;

    /* renamed from: P */
    public transient gq0 f5216P;

    public n31(qs0 qs0Var) throws IOException {
        m6637a(qs0Var);
    }

    /* renamed from: a */
    public final void m6637a(qs0 qs0Var) throws IOException {
        this.f5216P = qs0Var.m7781k();
        this.f5215O = (j11) i21.m4709b(qs0Var);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n31)) {
            return false;
        }
        try {
            return e51.m3432a(this.f5215O.getEncoded(), ((n31) obj).f5215O.getEncoded());
        } catch (IOException unused) {
            throw new IllegalStateException("unable to perform equals");
        }
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "LMS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return j21.m5036a(this.f5215O, this.f5216P).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        try {
            return e51.m3445n(this.f5215O.getEncoded());
        } catch (IOException unused) {
            throw new IllegalStateException("unable to calculate hashCode");
        }
    }
}
