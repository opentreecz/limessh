package com.sonelli;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

/* loaded from: classes.dex */
public class wt0 implements CipherParameters {

    /* renamed from: O */
    public BigInteger f7794O;

    /* renamed from: P */
    public BigInteger f7795P;

    /* renamed from: Q */
    public BigInteger f7796Q;

    public wt0(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i, int i2, BigInteger bigInteger4, xt0 xt0Var) {
        if (i2 != 0) {
            if (i2 > bigInteger.bitLength()) {
                throw new IllegalArgumentException("when l value specified, it must satisfy 2^(l-1) <= p");
            }
            if (i2 < i) {
                throw new IllegalArgumentException("when l value specified, it may not be less than m value");
            }
        }
        if (i > bigInteger.bitLength() && !i51.m4721b("org.bouncycastle.dh.allow_unsafe_p_value")) {
            throw new IllegalArgumentException("unsafe p value so small specific l required");
        }
        this.f7794O = bigInteger2;
        this.f7795P = bigInteger;
        this.f7796Q = bigInteger3;
    }

    /* renamed from: a */
    public BigInteger m9639a() {
        return this.f7794O;
    }

    /* renamed from: b */
    public BigInteger m9640b() {
        return this.f7795P;
    }

    /* renamed from: c */
    public BigInteger m9641c() {
        return this.f7796Q;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof wt0)) {
            return false;
        }
        wt0 wt0Var = (wt0) obj;
        if (m9641c() != null) {
            if (!m9641c().equals(wt0Var.m9641c())) {
                return false;
            }
        } else if (wt0Var.m9641c() != null) {
            return false;
        }
        return wt0Var.m9640b().equals(this.f7795P) && wt0Var.m9639a().equals(this.f7794O);
    }

    public int hashCode() {
        return (m9640b().hashCode() ^ m9639a().hashCode()) ^ (m9641c() != null ? m9641c().hashCode() : 0);
    }
}
