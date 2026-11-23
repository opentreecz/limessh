package com.sonelli;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.Digest;

/* loaded from: classes.dex */
public class e11 {

    /* renamed from: a */
    public static Map<String, aq0> f2319a = new HashMap();

    /* renamed from: b */
    public static Map<aq0, String> f2320b = new HashMap();

    static {
        Map<String, aq0> map = f2319a;
        aq0 aq0Var = NISTObjectIdentifiers.f8736c;
        map.put("SHA-256", aq0Var);
        Map<String, aq0> map2 = f2319a;
        aq0 aq0Var2 = NISTObjectIdentifiers.f8738e;
        map2.put("SHA-512", aq0Var2);
        Map<String, aq0> map3 = f2319a;
        aq0 aq0Var3 = NISTObjectIdentifiers.f8742i;
        map3.put("SHAKE128", aq0Var3);
        Map<String, aq0> map4 = f2319a;
        aq0 aq0Var4 = NISTObjectIdentifiers.f8743j;
        map4.put("SHAKE256", aq0Var4);
        f2320b.put(aq0Var, "SHA-256");
        f2320b.put(aq0Var2, "SHA-512");
        f2320b.put(aq0Var3, "SHAKE128");
        f2320b.put(aq0Var4, "SHAKE256");
    }

    /* renamed from: a */
    public static Digest m3380a(aq0 aq0Var) {
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
}
