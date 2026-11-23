package cz.opentree;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class wz0 {
    public wz0(BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2, BigInteger bigInteger, BigInteger bigInteger2, int i) {
        m9649a(bigIntegerArr, "v1");
        m9649a(bigIntegerArr2, "v2");
        BigInteger bigInteger3 = bigIntegerArr[0];
        BigInteger bigInteger4 = bigIntegerArr[1];
        BigInteger bigInteger5 = bigIntegerArr2[0];
        BigInteger bigInteger6 = bigIntegerArr2[1];
    }

    /* renamed from: a */
    public static void m9649a(BigInteger[] bigIntegerArr, String str) {
        if (bigIntegerArr == null || bigIntegerArr.length != 2 || bigIntegerArr[0] == null || bigIntegerArr[1] == null) {
            throw new IllegalArgumentException("'" + str + "' must consist of exactly 2 (non-null) values");
        }
    }
}
