package com.sonelli;

import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.pqc.jcajce.interfaces.QTESLAKey;

/* loaded from: classes.dex */
public class b41 implements PublicKey, QTESLAKey {

    /* renamed from: O */
    public transient b21 f1609O;

    public b41(ws0 ws0Var) throws IOException {
        m2372a(ws0Var);
    }

    /* renamed from: a */
    public final void m2372a(ws0 ws0Var) throws IOException {
        this.f1609O = (b21) k21.m5791a(ws0Var);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b41)) {
            return false;
        }
        b41 b41Var = (b41) obj;
        return this.f1609O.m2357b() == b41Var.f1609O.m2357b() && e51.m3432a(this.f1609O.m2356a(), b41Var.f1609O.m2356a());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return c21.m2658a(this.f1609O.m2357b());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return l21.m6045a(this.f1609O).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return this.f1609O.m2357b() + (e51.m3445n(this.f1609O.m2356a()) * 37);
    }
}
