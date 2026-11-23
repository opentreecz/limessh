package cz.opentree;

import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;

/* loaded from: classes.dex */
public class t31 implements PublicKey {

    /* renamed from: O */
    public x11 f6706O;

    public t31(x11 x11Var) {
        this.f6706O = x11Var;
    }

    /* renamed from: a */
    public t41 m8590a() {
        return this.f6706O.m9670a();
    }

    /* renamed from: b */
    public int m8591b() {
        return this.f6706O.m9671b();
    }

    /* renamed from: c */
    public int m8592c() {
        return this.f6706O.m9672c();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof t31)) {
            return false;
        }
        t31 t31Var = (t31) obj;
        return this.f6706O.m9671b() == t31Var.m8591b() && this.f6706O.m9672c() == t31Var.m8592c() && this.f6706O.m9670a().equals(t31Var.m8590a());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new ws0(new vs0(PQCObjectIdentifiers.f8878c), new t01(this.f6706O.m9671b(), this.f6706O.m9672c(), this.f6706O.m9670a())).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return ((this.f6706O.m9671b() + (this.f6706O.m9672c() * 37)) * 37) + this.f6706O.m9670a().hashCode();
    }

    public String toString() {
        return (("McEliecePublicKey:\n length of the code         : " + this.f6706O.m9671b() + "\n") + " error correction capability: " + this.f6706O.m9672c() + "\n") + " generator matrix           : " + this.f6706O.m9670a();
    }
}
