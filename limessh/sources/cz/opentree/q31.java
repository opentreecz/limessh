package cz.opentree;

import java.io.IOException;
import java.security.PrivateKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;

/* loaded from: classes.dex */
public class q31 implements PrivateKey {

    /* renamed from: O */
    public s11 f5931O;

    public q31(s11 s11Var) {
        this.f5931O = s11Var;
    }

    /* renamed from: a */
    public u41 m7615a() {
        return this.f5931O.m8300b();
    }

    /* renamed from: b */
    public b51 m7616b() {
        return this.f5931O.m8301c();
    }

    /* renamed from: c */
    public t41 m7617c() {
        return this.f5931O.m8302d();
    }

    /* renamed from: d */
    public int m7618d() {
        return this.f5931O.m8303e();
    }

    /* renamed from: e */
    public int m7619e() {
        return this.f5931O.m8304f();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof q31)) {
            return false;
        }
        q31 q31Var = (q31) obj;
        return m7619e() == q31Var.m7619e() && m7618d() == q31Var.m7618d() && m7615a().equals(q31Var.m7615a()) && m7616b().equals(q31Var.m7616b()) && m7620f().equals(q31Var.m7620f()) && m7617c().equals(q31Var.m7617c());
    }

    /* renamed from: f */
    public a51 m7620f() {
        return this.f5931O.m8305g();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece-CCA2";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new qs0(new vs0(PQCObjectIdentifiers.f8879d), new q01(m7619e(), m7618d(), m7615a(), m7616b(), m7620f(), w31.m9406a(this.f5931O.m7849a()))).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return (((((((((this.f5931O.m8303e() * 37) + this.f5931O.m8304f()) * 37) + this.f5931O.m8300b().hashCode()) * 37) + this.f5931O.m8301c().hashCode()) * 37) + this.f5931O.m8305g().hashCode()) * 37) + this.f5931O.m8302d().hashCode();
    }
}
