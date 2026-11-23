package com.sonelli;

import com.sonelli.gv0;
import java.math.BigInteger;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class tu0 {

    /* renamed from: a */
    public static Map f6862a = new HashMap();

    static {
        Enumeration m8994j = ut0.m8994j();
        while (m8994j.hasMoreElements()) {
            String str = (String) m8994j.nextElement();
            at0 m9881b = xs0.m9881b(str);
            if (m9881b != null) {
                f6862a.put(m9881b.m2271k(), ut0.m8993i(str).m2271k());
            }
        }
        gv0 m2271k = ut0.m8993i("Curve25519").m2271k();
        f6862a.put(new gv0.C1079f(m2271k.m4270p().mo2332c(), m2271k.m4266l().mo2290t(), m2271k.m4267m().mo2290t(), m2271k.m4271s(), m2271k.m4268n()), m2271k);
    }

    /* renamed from: a */
    public static gv0 m8813a(EllipticCurve ellipticCurve) {
        ECField field = ellipticCurve.getField();
        BigInteger a = ellipticCurve.getA();
        BigInteger b = ellipticCurve.getB();
        if (field instanceof ECFieldFp) {
            gv0.C1079f c1079f = new gv0.C1079f(((ECFieldFp) field).getP(), a, b);
            return f6862a.containsKey(c1079f) ? (gv0) f6862a.get(c1079f) : c1079f;
        }
        ECFieldF2m eCFieldF2m = (ECFieldF2m) field;
        int m = eCFieldF2m.getM();
        int[] m9072a = uu0.m9072a(eCFieldF2m.getMidTermsOfReductionPolynomial());
        return new gv0.C1078e(m, m9072a[0], m9072a[1], m9072a[2], a, b);
    }

    /* renamed from: b */
    public static iv0 m8814b(gv0 gv0Var, ECPoint eCPoint) {
        return gv0Var.mo4262f(eCPoint.getAffineX(), eCPoint.getAffineY());
    }

    /* renamed from: c */
    public static cv0 m8815c(ECParameterSpec eCParameterSpec) {
        gv0 m8813a = m8813a(eCParameterSpec.getCurve());
        iv0 m8814b = m8814b(m8813a, eCParameterSpec.getGenerator());
        BigInteger order = eCParameterSpec.getOrder();
        BigInteger valueOf = BigInteger.valueOf(eCParameterSpec.getCofactor());
        byte[] seed = eCParameterSpec.getCurve().getSeed();
        return eCParameterSpec instanceof bv0 ? new av0(((bv0) eCParameterSpec).m2637a(), m8813a, m8814b, order, valueOf, seed) : new cv0(m8813a, m8814b, order, valueOf, seed);
    }
}
