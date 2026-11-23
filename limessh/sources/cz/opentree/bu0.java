package cz.opentree;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class bu0 extends yt0 {

    /* renamed from: O */
    public static final BigInteger f1828O = BigInteger.valueOf(1);

    /* renamed from: P */
    public static final BigInteger f1829P = BigInteger.valueOf(2);

    public bu0(BigInteger bigInteger, zt0 zt0Var) {
        super(false, zt0Var);
        m2636a(bigInteger, zt0Var);
    }

    /* renamed from: a */
    public final BigInteger m2636a(BigInteger bigInteger, zt0 zt0Var) {
        if (zt0Var == null) {
            return bigInteger;
        }
        BigInteger bigInteger2 = f1829P;
        if (bigInteger2.compareTo(bigInteger) > 0 || zt0Var.m10629b().subtract(bigInteger2).compareTo(bigInteger) < 0 || !f1828O.equals(bigInteger.modPow(zt0Var.m10630c(), zt0Var.m10629b()))) {
            throw new IllegalArgumentException("y value does not appear to be in correct group");
        }
        return bigInteger;
    }
}
