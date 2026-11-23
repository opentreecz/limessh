package com.sonelli;

import java.io.IOException;
import java.security.PrivateKey;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;

/* loaded from: classes.dex */
public class s31 implements CipherParameters, PrivateKey {

    /* renamed from: O */
    public w11 f6346O;

    public s31(w11 w11Var) {
        this.f6346O = w11Var;
    }

    /* renamed from: a */
    public u41 m8311a() {
        return this.f6346O.m9382a();
    }

    /* renamed from: b */
    public b51 m8312b() {
        return this.f6346O.m9383b();
    }

    /* renamed from: c */
    public int m8313c() {
        return this.f6346O.m9384c();
    }

    /* renamed from: d */
    public int m8314d() {
        return this.f6346O.m9385d();
    }

    /* renamed from: e */
    public a51 m8315e() {
        return this.f6346O.m9386e();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s31)) {
            return false;
        }
        s31 s31Var = (s31) obj;
        return m8314d() == s31Var.m8314d() && m8313c() == s31Var.m8313c() && m8311a().equals(s31Var.m8311a()) && m8312b().equals(s31Var.m8312b()) && m8317h().equals(s31Var.m8317h()) && m8315e().equals(s31Var.m8315e()) && m8316f().equals(s31Var.m8316f());
    }

    /* renamed from: f */
    public a51 m8316f() {
        return this.f6346O.m9387f();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new qs0(new vs0(PQCObjectIdentifiers.f8878c), new s01(this.f6346O.m9385d(), this.f6346O.m9384c(), this.f6346O.m9382a(), this.f6346O.m9383b(), this.f6346O.m9386e(), this.f6346O.m9387f(), this.f6346O.m9388g())).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    /* renamed from: h */
    public t41 m8317h() {
        return this.f6346O.m9388g();
    }

    public int hashCode() {
        return (((((((((((this.f6346O.m9384c() * 37) + this.f6346O.m9385d()) * 37) + this.f6346O.m9382a().hashCode()) * 37) + this.f6346O.m9383b().hashCode()) * 37) + this.f6346O.m9386e().hashCode()) * 37) + this.f6346O.m9387f().hashCode()) * 37) + this.f6346O.m9388g().hashCode();
    }
}
