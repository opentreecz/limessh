package cz.opentree;

import java.util.Hashtable;
import org.bouncycastle.asn1.sec.SECObjectIdentifiers;

/* loaded from: classes.dex */
public class ps0 {

    /* renamed from: a */
    public static final Hashtable f5763a = new Hashtable();

    /* renamed from: b */
    public static final Hashtable f5764b = new Hashtable();

    static {
        m7441a("B-571", SECObjectIdentifiers.f8782F);
        m7441a("B-409", SECObjectIdentifiers.f8780D);
        m7441a("B-283", SECObjectIdentifiers.f8799n);
        m7441a("B-233", SECObjectIdentifiers.f8805t);
        m7441a("B-163", SECObjectIdentifiers.f8797l);
        m7441a("K-571", SECObjectIdentifiers.f8781E);
        m7441a("K-409", SECObjectIdentifiers.f8779C);
        m7441a("K-283", SECObjectIdentifiers.f8798m);
        m7441a("K-233", SECObjectIdentifiers.f8804s);
        m7441a("K-163", SECObjectIdentifiers.f8787b);
        m7441a("P-521", SECObjectIdentifiers.f8778B);
        m7441a("P-384", SECObjectIdentifiers.f8777A);
        m7441a("P-256", SECObjectIdentifiers.f8784H);
        m7441a("P-224", SECObjectIdentifiers.f8811z);
        m7441a("P-192", SECObjectIdentifiers.f8783G);
    }

    /* renamed from: a */
    public static void m7441a(String str, aq0 aq0Var) {
        f5763a.put(str, aq0Var);
        f5764b.put(aq0Var, str);
    }

    /* renamed from: b */
    public static at0 m7442b(String str) {
        aq0 aq0Var = (aq0) f5763a.get(j51.m5067f(str));
        if (aq0Var != null) {
            return m7443c(aq0Var);
        }
        return null;
    }

    /* renamed from: c */
    public static at0 m7443c(aq0 aq0Var) {
        return ts0.m8805k(aq0Var);
    }

    /* renamed from: d */
    public static aq0 m7444d(String str) {
        return (aq0) f5763a.get(j51.m5067f(str));
    }
}
