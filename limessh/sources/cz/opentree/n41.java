package cz.opentree;

import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.pqc.jcajce.interfaces.XMSSKey;

/* loaded from: classes.dex */
public class n41 implements PublicKey, XMSSKey {

    /* renamed from: O */
    public transient l31 f5227O;

    /* renamed from: P */
    public transient aq0 f5228P;

    public n41(ws0 ws0Var) throws IOException {
        m6638a(ws0Var);
    }

    /* renamed from: a */
    public final void m6638a(ws0 ws0Var) throws IOException {
        l31 l31Var = (l31) k21.m5791a(ws0Var);
        this.f5227O = l31Var;
        this.f5228P = o41.m6870a(l31Var.m2662a());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n41) {
            n41 n41Var = (n41) obj;
            try {
                if (this.f5228P.m3549o(n41Var.f5228P)) {
                    if (e51.m3432a(this.f5227O.getEncoded(), n41Var.f5227O.getEncoded())) {
                        return true;
                    }
                }
                return false;
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "XMSS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return l21.m6045a(this.f5227O).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        try {
            return this.f5228P.hashCode() + (e51.m3445n(this.f5227O.getEncoded()) * 37);
        } catch (IOException unused) {
            return this.f5228P.hashCode();
        }
    }
}
