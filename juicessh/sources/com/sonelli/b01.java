package com.sonelli;

import java.math.BigInteger;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.Polynomial;
import org.bouncycastle.math.field.PolynomialExtensionField;

/* loaded from: classes.dex */
public class b01 implements PolynomialExtensionField {

    /* renamed from: a */
    public final FiniteField f1562a;

    /* renamed from: b */
    public final Polynomial f1563b;

    public b01(FiniteField finiteField, Polynomial polynomial) {
        this.f1562a = finiteField;
        this.f1563b = polynomial;
    }

    @Override // org.bouncycastle.math.field.PolynomialExtensionField
    /* renamed from: a */
    public Polynomial mo2330a() {
        return this.f1563b;
    }

    @Override // org.bouncycastle.math.field.FiniteField
    /* renamed from: b */
    public int mo2331b() {
        return this.f1562a.mo2331b() * this.f1563b.mo1948b();
    }

    @Override // org.bouncycastle.math.field.FiniteField
    /* renamed from: c */
    public BigInteger mo2332c() {
        return this.f1562a.mo2332c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b01)) {
            return false;
        }
        b01 b01Var = (b01) obj;
        return this.f1562a.equals(b01Var.f1562a) && this.f1563b.equals(b01Var.f1563b);
    }

    public int hashCode() {
        return this.f1562a.hashCode() ^ g51.m4056b(this.f1563b.hashCode(), 16);
    }
}
