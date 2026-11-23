package com.sonelli;

import java.io.IOException;
import java.security.PublicKey;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;

/* loaded from: classes.dex */
public class r31 implements CipherParameters, PublicKey {

    /* renamed from: O */
    public t11 f6170O;

    public r31(t11 t11Var) {
        this.f6170O = t11Var;
    }

    /* renamed from: a */
    public t41 m7859a() {
        return this.f6170O.m8574b();
    }

    /* renamed from: b */
    public int m7860b() {
        return this.f6170O.m8575c();
    }

    /* renamed from: c */
    public int m7861c() {
        return this.f6170O.m8576d();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof r31)) {
            return false;
        }
        r31 r31Var = (r31) obj;
        return this.f6170O.m8575c() == r31Var.m7860b() && this.f6170O.m8576d() == r31Var.m7861c() && this.f6170O.m8574b().equals(r31Var.m7859a());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece-CCA2";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new ws0(new vs0(PQCObjectIdentifiers.f8879d), new r01(this.f6170O.m8575c(), this.f6170O.m8576d(), this.f6170O.m8574b(), w31.m9406a(this.f6170O.m7849a()))).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return ((this.f6170O.m8575c() + (this.f6170O.m8576d() * 37)) * 37) + this.f6170O.m8574b().hashCode();
    }

    public String toString() {
        return (("McEliecePublicKey:\n length of the code         : " + this.f6170O.m8575c() + "\n") + " error correction capability: " + this.f6170O.m8576d() + "\n") + " generator matrix           : " + this.f6170O.m8574b().toString();
    }
}
