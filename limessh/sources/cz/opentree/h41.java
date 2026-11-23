package cz.opentree;

import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.jcajce.interfaces.SPHINCSKey;

/* loaded from: classes.dex */
public class h41 implements PublicKey, SPHINCSKey {

    /* renamed from: O */
    public transient aq0 f3105O;

    /* renamed from: P */
    public transient h21 f3106P;

    public h41(ws0 ws0Var) throws IOException {
        m4364a(ws0Var);
    }

    /* renamed from: a */
    public final void m4364a(ws0 ws0Var) throws IOException {
        this.f3105O = w01.m9379k(ws0Var.m9636k().m9344n()).m9380m().m9343k();
        this.f3106P = (h21) k21.m5791a(ws0Var);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h41)) {
            return false;
        }
        h41 h41Var = (h41) obj;
        return this.f3105O.m3549o(h41Var.f3105O) && e51.m3432a(this.f3106P.m4343b(), h41Var.f3106P.m4343b());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "SPHINCS-256";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return (this.f3106P.m3660a() != null ? l21.m6045a(this.f3106P) : new ws0(new vs0(PQCObjectIdentifiers.f8880e, new w01(new vs0(this.f3105O))), this.f3106P.m4343b())).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return this.f3105O.hashCode() + (e51.m3445n(this.f3106P.m4343b()) * 37);
    }
}
