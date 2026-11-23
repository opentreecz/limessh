package com.sonelli;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.signers.DSAKCalculator;

/* loaded from: classes.dex */
public class pu0 implements DSAKCalculator {

    /* renamed from: c */
    public static final BigInteger f5875c = BigInteger.valueOf(0);

    /* renamed from: a */
    public BigInteger f5876a;

    /* renamed from: b */
    public SecureRandom f5877b;

    @Override // org.bouncycastle.crypto.signers.DSAKCalculator
    /* renamed from: a */
    public BigInteger mo7549a() {
        int bitLength = this.f5876a.bitLength();
        while (true) {
            BigInteger m3684c = f51.m3684c(bitLength, this.f5877b);
            if (!m3684c.equals(f5875c) && m3684c.compareTo(this.f5876a) < 0) {
                return m3684c;
            }
        }
    }

    @Override // org.bouncycastle.crypto.signers.DSAKCalculator
    /* renamed from: b */
    public boolean mo7550b() {
        return false;
    }

    @Override // org.bouncycastle.crypto.signers.DSAKCalculator
    /* renamed from: c */
    public void mo7551c(BigInteger bigInteger, SecureRandom secureRandom) {
        this.f5876a = bigInteger;
        this.f5877b = secureRandom;
    }

    @Override // org.bouncycastle.crypto.signers.DSAKCalculator
    /* renamed from: d */
    public void mo7552d(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        throw new IllegalStateException("Operation not supported");
    }
}
