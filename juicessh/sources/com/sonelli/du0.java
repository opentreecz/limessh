package com.sonelli;

import java.math.BigInteger;
import java.util.Objects;
import org.bouncycastle.math.ec.ECConstants;

/* loaded from: classes.dex */
public class du0 implements ECConstants {

    /* renamed from: e */
    public final gv0 f2287e;

    /* renamed from: f */
    public final byte[] f2288f;

    /* renamed from: g */
    public final iv0 f2289g;

    /* renamed from: h */
    public final BigInteger f2290h;

    /* renamed from: i */
    public final BigInteger f2291i;

    public du0(gv0 gv0Var, iv0 iv0Var, BigInteger bigInteger, BigInteger bigInteger2) {
        this(gv0Var, iv0Var, bigInteger, bigInteger2, null);
    }

    public du0(gv0 gv0Var, iv0 iv0Var, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        Objects.requireNonNull(gv0Var, "curve");
        Objects.requireNonNull(bigInteger, "n");
        this.f2287e = gv0Var;
        this.f2289g = m3317g(gv0Var, iv0Var);
        this.f2290h = bigInteger;
        this.f2291i = bigInteger2;
        this.f2288f = e51.m3436e(bArr);
    }

    /* renamed from: g */
    public static iv0 m3317g(gv0 gv0Var, iv0 iv0Var) {
        Objects.requireNonNull(iv0Var, "Point cannot be null");
        iv0 m4949w = fv0.m3881b(gv0Var, iv0Var).m4949w();
        if (m4949w.m4945r()) {
            throw new IllegalArgumentException("Point at infinity");
        }
        if (m4949w.m4947t()) {
            return m4949w;
        }
        throw new IllegalArgumentException("Point not on curve");
    }

    /* renamed from: a */
    public gv0 m3318a() {
        return this.f2287e;
    }

    /* renamed from: b */
    public iv0 m3319b() {
        return this.f2289g;
    }

    /* renamed from: c */
    public BigInteger m3320c() {
        return this.f2291i;
    }

    /* renamed from: d */
    public BigInteger m3321d() {
        return this.f2290h;
    }

    /* renamed from: e */
    public byte[] m3322e() {
        return e51.m3436e(this.f2288f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof du0)) {
            return false;
        }
        du0 du0Var = (du0) obj;
        return this.f2287e.m4265j(du0Var.f2287e) && this.f2289g.m4934d(du0Var.f2289g) && this.f2290h.equals(du0Var.f2290h);
    }

    /* renamed from: f */
    public BigInteger m3323f(BigInteger bigInteger) {
        Objects.requireNonNull(bigInteger, "Scalar cannot be null");
        if (bigInteger.compareTo(ECConstants.f8873b) < 0 || bigInteger.compareTo(m3321d()) >= 0) {
            throw new IllegalArgumentException("Scalar is not in the interval [1, n - 1]");
        }
        return bigInteger;
    }

    /* renamed from: h */
    public iv0 m3324h(iv0 iv0Var) {
        return m3317g(m3318a(), iv0Var);
    }

    public int hashCode() {
        return ((((this.f2287e.hashCode() ^ 1028) * 257) ^ this.f2289g.hashCode()) * 257) ^ this.f2290h.hashCode();
    }
}
