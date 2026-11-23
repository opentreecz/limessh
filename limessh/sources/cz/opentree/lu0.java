package cz.opentree;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class lu0 extends vt0 {

    /* renamed from: O */
    public static final BigInteger f4917O = new BigInteger("8138e8a0fcf3a4e84a771d40fd305d7f4aa59306d7251de54d98af8fe95729a1f73d893fa424cd2edc8636a6c3285e022b0e3866a565ae8108eed8591cd4fe8d2ce86165a978d719ebf647f362d33fca29cd179fb42401cbaf3df0c614056f9c8f3cfd51e474afb6bc6974f78db8aba8e9e517fded658591ab7502bd41849462f", 16);

    /* renamed from: P */
    public static final BigInteger f4918P = BigInteger.valueOf(1);

    public lu0(boolean z, BigInteger bigInteger, BigInteger bigInteger2) {
        super(z);
        if (!z && (bigInteger2.intValue() & 1) == 0) {
            throw new IllegalArgumentException("RSA publicExponent is even");
        }
        m6300a(bigInteger);
    }

    /* renamed from: a */
    public final BigInteger m6300a(BigInteger bigInteger) {
        if ((bigInteger.intValue() & 1) == 0) {
            throw new IllegalArgumentException("RSA modulus is even");
        }
        if (i51.m4721b("org.bouncycastle.rsa.allow_unsafe_mod") || bigInteger.gcd(f4917O).equals(f4918P)) {
            return bigInteger;
        }
        throw new IllegalArgumentException("RSA modulus has a small prime factor");
    }
}
