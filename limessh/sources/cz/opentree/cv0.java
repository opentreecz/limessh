package cz.opentree;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

/* loaded from: classes.dex */
public class cv0 implements AlgorithmParameterSpec {

    /* renamed from: a */
    public gv0 f2059a;

    /* renamed from: b */
    public byte[] f2060b;

    /* renamed from: c */
    public iv0 f2061c;

    /* renamed from: d */
    public BigInteger f2062d;

    /* renamed from: e */
    public BigInteger f2063e;

    public cv0(gv0 gv0Var, iv0 iv0Var, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.f2059a = gv0Var;
        this.f2061c = iv0Var.m4949w();
        this.f2062d = bigInteger;
        this.f2063e = bigInteger2;
        this.f2060b = bArr;
    }

    /* renamed from: a */
    public gv0 m3046a() {
        return this.f2059a;
    }

    /* renamed from: b */
    public iv0 m3047b() {
        return this.f2061c;
    }

    /* renamed from: c */
    public BigInteger m3048c() {
        return this.f2063e;
    }

    /* renamed from: d */
    public BigInteger m3049d() {
        return this.f2062d;
    }

    /* renamed from: e */
    public byte[] m3050e() {
        return this.f2060b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof cv0)) {
            return false;
        }
        cv0 cv0Var = (cv0) obj;
        return m3046a().m4265j(cv0Var.m3046a()) && m3047b().m4934d(cv0Var.m3047b());
    }

    public int hashCode() {
        return m3046a().hashCode() ^ m3047b().hashCode();
    }
}
