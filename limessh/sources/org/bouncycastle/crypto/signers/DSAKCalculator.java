package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;

/* loaded from: classes.dex */
public interface DSAKCalculator {
    /* renamed from: a */
    BigInteger mo7549a();

    /* renamed from: b */
    boolean mo7550b();

    /* renamed from: c */
    void mo7551c(BigInteger bigInteger, SecureRandom secureRandom);

    /* renamed from: d */
    void mo7552d(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr);
}
