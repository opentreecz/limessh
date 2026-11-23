package com.sonelli;

import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.pqc.jcajce.interfaces.XMSSMTKey;

/* loaded from: classes.dex */
public class l41 implements PublicKey, XMSSMTKey {

    /* renamed from: O */
    public transient aq0 f4741O;

    /* renamed from: P */
    public transient g31 f4742P;

    public l41(ws0 ws0Var) throws IOException {
        m6067a(ws0Var);
    }

    /* renamed from: a */
    public final void m6067a(ws0 ws0Var) throws IOException {
        g31 g31Var = (g31) k21.m5791a(ws0Var);
        this.f4742P = g31Var;
        this.f4741O = o41.m6870a(g31Var.m3112a());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l41)) {
            return false;
        }
        l41 l41Var = (l41) obj;
        return this.f4741O.m3549o(l41Var.f4741O) && e51.m3432a(this.f4742P.m3974e(), l41Var.f4742P.m3974e());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "XMSSMT";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return l21.m6045a(this.f4742P).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return this.f4741O.hashCode() + (e51.m3445n(this.f4742P.m3974e()) * 37);
    }
}
