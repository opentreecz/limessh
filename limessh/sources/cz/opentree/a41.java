package cz.opentree;

import java.io.IOException;
import java.security.PrivateKey;
import org.bouncycastle.pqc.jcajce.interfaces.QTESLAKey;

/* loaded from: classes.dex */
public class a41 implements PrivateKey, QTESLAKey {

    /* renamed from: O */
    public transient a21 f1330O;

    /* renamed from: P */
    public transient gq0 f1331P;

    public a41(qs0 qs0Var) throws IOException {
        m1979a(qs0Var);
    }

    /* renamed from: a */
    public final void m1979a(qs0 qs0Var) throws IOException {
        this.f1331P = qs0Var.m7781k();
        this.f1330O = (a21) i21.m4709b(qs0Var);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a41)) {
            return false;
        }
        a41 a41Var = (a41) obj;
        return this.f1330O.m1975b() == a41Var.f1330O.m1975b() && e51.m3432a(this.f1330O.m1974a(), a41Var.f1330O.m1974a());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return c21.m2658a(this.f1330O.m1975b());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return j21.m5036a(this.f1330O, this.f1331P).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return this.f1330O.m1975b() + (e51.m3445n(this.f1330O.m1974a()) * 37);
    }
}
