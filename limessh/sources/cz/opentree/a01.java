package cz.opentree;

import org.bouncycastle.math.field.Polynomial;

/* loaded from: classes.dex */
public class a01 implements Polynomial {

    /* renamed from: a */
    public final int[] f1304a;

    public a01(int[] iArr) {
        this.f1304a = e51.m3437f(iArr);
    }

    @Override // org.bouncycastle.math.field.Polynomial
    /* renamed from: a */
    public int[] mo1947a() {
        return e51.m3437f(this.f1304a);
    }

    @Override // org.bouncycastle.math.field.Polynomial
    /* renamed from: b */
    public int mo1948b() {
        return this.f1304a[r0.length - 1];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a01) {
            return e51.m3434c(this.f1304a, ((a01) obj).f1304a);
        }
        return false;
    }

    public int hashCode() {
        return e51.m3448q(this.f1304a);
    }
}
