package cz.opentree;

import java.math.BigInteger;
import org.bouncycastle.math.field.FiniteField;

/* loaded from: classes.dex */
public class c01 implements FiniteField {

    /* renamed from: a */
    public final BigInteger f1856a;

    public c01(BigInteger bigInteger) {
        this.f1856a = bigInteger;
    }

    @Override // org.bouncycastle.math.field.FiniteField
    /* renamed from: b */
    public int mo2331b() {
        return 1;
    }

    @Override // org.bouncycastle.math.field.FiniteField
    /* renamed from: c */
    public BigInteger mo2332c() {
        return this.f1856a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c01) {
            return this.f1856a.equals(((c01) obj).f1856a);
        }
        return false;
    }

    public int hashCode() {
        return this.f1856a.hashCode();
    }
}
