package cz.opentree;

import java.io.IOException;
import org.bouncycastle.pqc.jcajce.interfaces.NHPrivateKey;

/* loaded from: classes.dex */
public class x31 implements NHPrivateKey {

    /* renamed from: O */
    public transient y11 f7864O;

    /* renamed from: P */
    public transient gq0 f7865P;

    public x31(qs0 qs0Var) throws IOException {
        m9689a(qs0Var);
    }

    /* renamed from: a */
    public final void m9689a(qs0 qs0Var) throws IOException {
        this.f7865P = qs0Var.m7781k();
        this.f7864O = (y11) i21.m4709b(qs0Var);
    }

    public boolean equals(Object obj) {
        if (obj instanceof x31) {
            return e51.m3435d(this.f7864O.m10049a(), ((x31) obj).f7864O.m10049a());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "NH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return j21.m5036a(this.f7864O, this.f7865P).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return e51.m3451t(this.f7864O.m10049a());
    }
}
