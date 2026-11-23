package com.sonelli;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.PolynomialExtensionField;

/* loaded from: classes.dex */
public class fv0 {
    /* renamed from: a */
    public static iv0 m3880a(iv0 iv0Var) {
        if (iv0Var.m4948u()) {
            return iv0Var;
        }
        throw new IllegalStateException("Invalid result");
    }

    /* renamed from: b */
    public static iv0 m3881b(gv0 gv0Var, iv0 iv0Var) {
        if (gv0Var.m4265j(iv0Var.m4937h())) {
            return gv0Var.mo4272t(iv0Var);
        }
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    /* renamed from: c */
    public static boolean m3882c(gv0 gv0Var) {
        return m3883d(gv0Var.m4270p());
    }

    /* renamed from: d */
    public static boolean m3883d(FiniteField finiteField) {
        return finiteField.mo2331b() > 1 && finiteField.mo2332c().equals(ECConstants.f8874c) && (finiteField instanceof PolynomialExtensionField);
    }

    /* renamed from: e */
    public static boolean m3884e(gv0 gv0Var) {
        return m3885f(gv0Var.m4270p());
    }

    /* renamed from: f */
    public static boolean m3885f(FiniteField finiteField) {
        return finiteField.mo2331b() == 1;
    }

    /* renamed from: g */
    public static void m3886g(hv0[] hv0VarArr, int i, int i2, hv0 hv0Var) {
        hv0[] hv0VarArr2 = new hv0[i2];
        int i3 = 0;
        hv0VarArr2[0] = hv0VarArr[i];
        while (true) {
            i3++;
            if (i3 >= i2) {
                break;
            } else {
                hv0VarArr2[i3] = hv0VarArr2[i3 - 1].mo2284j(hv0VarArr[i + i3]);
            }
        }
        int i4 = i3 - 1;
        if (hv0Var != null) {
            hv0VarArr2[i4] = hv0VarArr2[i4].mo2284j(hv0Var);
        }
        hv0 mo2281g = hv0VarArr2[i4].mo2281g();
        while (i4 > 0) {
            int i5 = i4 - 1;
            int i6 = i4 + i;
            hv0 hv0Var2 = hv0VarArr[i6];
            hv0VarArr[i6] = hv0VarArr2[i5].mo2284j(mo2281g);
            mo2281g = mo2281g.mo2284j(hv0Var2);
            i4 = i5;
        }
        hv0VarArr[i] = mo2281g;
    }

    /* renamed from: h */
    public static iv0 m3887h(iv0 iv0Var, BigInteger bigInteger) {
        BigInteger abs = bigInteger.abs();
        iv0 mo2308r = iv0Var.m4937h().mo2308r();
        int bitLength = abs.bitLength();
        if (bitLength > 0) {
            if (abs.testBit(0)) {
                mo2308r = iv0Var;
            }
            for (int i = 1; i < bitLength; i++) {
                iv0Var = iv0Var.mo2638C();
                if (abs.testBit(i)) {
                    mo2308r = mo2308r.mo2641a(iv0Var);
                }
            }
        }
        return bigInteger.signum() < 0 ? mo2308r.mo2642v() : mo2308r;
    }
}
