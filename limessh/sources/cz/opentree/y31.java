package cz.opentree;

import java.io.IOException;
import org.bouncycastle.pqc.jcajce.interfaces.NHPublicKey;

/* loaded from: classes.dex */
public class y31 implements NHPublicKey {

    /* renamed from: O */
    public transient z11 f8135O;

    public y31(ws0 ws0Var) throws IOException {
        m10081a(ws0Var);
    }

    /* renamed from: a */
    public final void m10081a(ws0 ws0Var) throws IOException {
        this.f8135O = (z11) k21.m5791a(ws0Var);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof y31)) {
            return false;
        }
        return e51.m3432a(this.f8135O.m10322a(), ((y31) obj).f8135O.m10322a());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "NH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return l21.m6045a(this.f8135O).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return e51.m3445n(this.f8135O.m10322a());
    }
}
