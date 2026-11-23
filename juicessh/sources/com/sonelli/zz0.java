package com.sonelli;

import java.math.BigInteger;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.PolynomialExtensionField;

/* loaded from: classes.dex */
public abstract class zz0 {

    /* renamed from: a */
    public static final FiniteField f8612a = new c01(BigInteger.valueOf(2));

    /* renamed from: b */
    public static final FiniteField f8613b = new c01(BigInteger.valueOf(3));

    /* renamed from: a */
    public static PolynomialExtensionField m10668a(int[] iArr) {
        if (iArr[0] != 0) {
            throw new IllegalArgumentException("Irreducible polynomials in GF(2) must have constant term");
        }
        for (int i = 1; i < iArr.length; i++) {
            if (iArr[i] <= iArr[i - 1]) {
                throw new IllegalArgumentException("Polynomial exponents must be montonically increasing");
            }
        }
        return new b01(f8612a, new a01(iArr));
    }

    /* renamed from: b */
    public static FiniteField m10669b(BigInteger bigInteger) {
        int bitLength = bigInteger.bitLength();
        if (bigInteger.signum() <= 0 || bitLength < 2) {
            throw new IllegalArgumentException("'characteristic' must be >= 2");
        }
        if (bitLength < 3) {
            int intValue = bigInteger.intValue();
            if (intValue == 2) {
                return f8612a;
            }
            if (intValue == 3) {
                return f8613b;
            }
        }
        return new c01(bigInteger);
    }
}
