package com.sonelli;

import java.io.IOException;
import java.security.PrivateKey;
import org.bouncycastle.pqc.jcajce.interfaces.XMSSMTPrivateKey;

/* loaded from: classes.dex */
public class k41 implements PrivateKey, XMSSMTPrivateKey {

    /* renamed from: O */
    public transient aq0 f4478O;

    /* renamed from: P */
    public transient f31 f4479P;

    /* renamed from: Q */
    public transient gq0 f4480Q;

    public k41(qs0 qs0Var) throws IOException {
        m5834a(qs0Var);
    }

    /* renamed from: a */
    public final void m5834a(qs0 qs0Var) throws IOException {
        this.f4480Q = qs0Var.m7781k();
        this.f4478O = y01.m10042m(qs0Var.m7782n().m9344n()).m10045o().m9343k();
        this.f4479P = (f31) i21.m4709b(qs0Var);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k41)) {
            return false;
        }
        k41 k41Var = (k41) obj;
        return this.f4478O.m3549o(k41Var.f4478O) && e51.m3432a(this.f4479P.m3662c(), k41Var.f4479P.m3662c());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "XMSSMT";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return j21.m5036a(this.f4479P, this.f4480Q).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return this.f4478O.hashCode() + (e51.m3445n(this.f4479P.m3662c()) * 37);
    }
}
