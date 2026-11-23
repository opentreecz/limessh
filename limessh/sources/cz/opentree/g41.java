package cz.opentree;

import java.io.IOException;
import java.security.PrivateKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.jcajce.interfaces.SPHINCSKey;

/* loaded from: classes.dex */
public class g41 implements PrivateKey, SPHINCSKey {

    /* renamed from: O */
    public transient aq0 f2829O;

    /* renamed from: P */
    public transient g21 f2830P;

    /* renamed from: Q */
    public transient gq0 f2831Q;

    public g41(qs0 qs0Var) throws IOException {
        m4054a(qs0Var);
    }

    /* renamed from: a */
    public final void m4054a(qs0 qs0Var) throws IOException {
        this.f2831Q = qs0Var.m7781k();
        this.f2829O = w01.m9379k(qs0Var.m7782n().m9344n()).m9380m().m9343k();
        this.f2830P = (g21) i21.m4709b(qs0Var);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g41)) {
            return false;
        }
        g41 g41Var = (g41) obj;
        return this.f2829O.m3549o(g41Var.f2829O) && e51.m3432a(this.f2830P.m3968b(), g41Var.f2830P.m3968b());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "SPHINCS-256";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return (this.f2830P.m3660a() != null ? j21.m5036a(this.f2830P, this.f2831Q) : new qs0(new vs0(PQCObjectIdentifiers.f8880e, new w01(new vs0(this.f2829O))), new gr0(this.f2830P.m3968b()), this.f2831Q)).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return this.f2829O.hashCode() + (e51.m3445n(this.f2830P.m3968b()) * 37);
    }
}
