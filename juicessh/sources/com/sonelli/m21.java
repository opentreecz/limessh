package com.sonelli;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;

/* loaded from: classes.dex */
public class m21 {

    /* renamed from: a */
    public static final vs0 f4960a;

    /* renamed from: b */
    public static final vs0 f4961b;

    /* renamed from: c */
    public static final vs0 f4962c;

    /* renamed from: d */
    public static final vs0 f4963d;

    /* renamed from: e */
    public static final vs0 f4964e;

    /* renamed from: f */
    public static final vs0 f4965f;

    /* renamed from: g */
    public static final vs0 f4966g;

    /* renamed from: h */
    public static final vs0 f4967h;

    /* renamed from: i */
    public static final Map f4968i;

    static {
        aq0 aq0Var = PQCObjectIdentifiers.f8892q;
        f4960a = new vs0(aq0Var);
        aq0 aq0Var2 = PQCObjectIdentifiers.f8893r;
        f4961b = new vs0(aq0Var2);
        f4962c = new vs0(NISTObjectIdentifiers.f8741h);
        f4963d = new vs0(NISTObjectIdentifiers.f8740g);
        f4964e = new vs0(NISTObjectIdentifiers.f8736c);
        f4965f = new vs0(NISTObjectIdentifiers.f8738e);
        f4966g = new vs0(NISTObjectIdentifiers.f8742i);
        f4967h = new vs0(NISTObjectIdentifiers.f8743j);
        HashMap hashMap = new HashMap();
        f4968i = hashMap;
        hashMap.put(aq0Var, g51.m4057c(5));
        hashMap.put(aq0Var2, g51.m4057c(6));
    }

    /* renamed from: a */
    public static Digest m6340a(aq0 aq0Var) {
        if (aq0Var.m3549o(NISTObjectIdentifiers.f8736c)) {
            return new qt0();
        }
        if (aq0Var.m3549o(NISTObjectIdentifiers.f8738e)) {
            return new st0();
        }
        if (aq0Var.m3549o(NISTObjectIdentifiers.f8742i)) {
            return new tt0(128);
        }
        if (aq0Var.m3549o(NISTObjectIdentifiers.f8743j)) {
            return new tt0(256);
        }
        throw new IllegalArgumentException("unrecognized digest OID: " + aq0Var);
    }

    /* renamed from: b */
    public static vs0 m6341b(int i) {
        if (i == 5) {
            return f4960a;
        }
        if (i == 6) {
            return f4961b;
        }
        throw new IllegalArgumentException("unknown security category: " + i);
    }

    /* renamed from: c */
    public static int m6342c(vs0 vs0Var) {
        return ((Integer) f4968i.get(vs0Var.m9343k())).intValue();
    }

    /* renamed from: d */
    public static vs0 m6343d(String str) {
        if (str.equals("SHA3-256")) {
            return f4962c;
        }
        if (str.equals("SHA-512/256")) {
            return f4963d;
        }
        throw new IllegalArgumentException("unknown tree digest: " + str);
    }

    /* renamed from: e */
    public static String m6344e(w01 w01Var) {
        vs0 m9380m = w01Var.m9380m();
        if (m9380m.m9343k().m3549o(f4962c.m9343k())) {
            return "SHA3-256";
        }
        if (m9380m.m9343k().m3549o(f4963d.m9343k())) {
            return "SHA-512/256";
        }
        throw new IllegalArgumentException("unknown tree digest: " + m9380m.m9343k());
    }

    /* renamed from: f */
    public static vs0 m6345f(String str) {
        if (str.equals("SHA-256")) {
            return f4964e;
        }
        if (str.equals("SHA-512")) {
            return f4965f;
        }
        if (str.equals("SHAKE128")) {
            return f4966g;
        }
        if (str.equals("SHAKE256")) {
            return f4967h;
        }
        throw new IllegalArgumentException("unknown tree digest: " + str);
    }
}
