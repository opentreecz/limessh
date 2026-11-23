package com.sonelli;

import java.io.IOException;
import java.security.PrivateKey;
import org.bouncycastle.pqc.jcajce.interfaces.XMSSPrivateKey;

/* loaded from: classes.dex */
public class m41 implements PrivateKey, XMSSPrivateKey {

    /* renamed from: O */
    public transient k31 f4982O;

    /* renamed from: P */
    public transient aq0 f4983P;

    /* renamed from: Q */
    public transient gq0 f4984Q;

    public m41(qs0 qs0Var) throws IOException {
        m6368a(qs0Var);
    }

    /* renamed from: a */
    public final void m6368a(qs0 qs0Var) throws IOException {
        this.f4984Q = qs0Var.m7781k();
        this.f4983P = x01.m9662m(qs0Var.m7782n().m9344n()).m9664n().m9343k();
        this.f4982O = (k31) i21.m4709b(qs0Var);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m41)) {
            return false;
        }
        m41 m41Var = (m41) obj;
        return this.f4983P.m3549o(m41Var.f4983P) && e51.m3432a(this.f4982O.m5803c(), m41Var.f4982O.m5803c());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "XMSS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return j21.m5036a(this.f4982O, this.f4984Q).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return this.f4983P.hashCode() + (e51.m3445n(this.f4982O.m5803c()) * 37);
    }
}
