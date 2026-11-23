package com.sonelli;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.Digest;

/* loaded from: classes.dex */
public class s21 {

    /* renamed from: a */
    public static Map<String, aq0> f6338a = new HashMap();

    /* renamed from: b */
    public static Map<aq0, String> f6339b = new HashMap();

    static {
        Map<String, aq0> map = f6338a;
        aq0 aq0Var = NISTObjectIdentifiers.f8736c;
        map.put("SHA-256", aq0Var);
        Map<String, aq0> map2 = f6338a;
        aq0 aq0Var2 = NISTObjectIdentifiers.f8738e;
        map2.put("SHA-512", aq0Var2);
        Map<String, aq0> map3 = f6338a;
        aq0 aq0Var3 = NISTObjectIdentifiers.f8742i;
        map3.put("SHAKE128", aq0Var3);
        Map<String, aq0> map4 = f6338a;
        aq0 aq0Var4 = NISTObjectIdentifiers.f8743j;
        map4.put("SHAKE256", aq0Var4);
        f6339b.put(aq0Var, "SHA-256");
        f6339b.put(aq0Var2, "SHA-512");
        f6339b.put(aq0Var3, "SHAKE128");
        f6339b.put(aq0Var4, "SHAKE256");
    }

    /* renamed from: a */
    public static Digest m8307a(aq0 aq0Var) {
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
    public static String m8308b(aq0 aq0Var) {
        String str = f6339b.get(aq0Var);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("unrecognized digest oid: " + aq0Var);
    }

    /* renamed from: c */
    public static aq0 m8309c(String str) {
        aq0 aq0Var = f6338a.get(str);
        if (aq0Var != null) {
            return aq0Var;
        }
        throw new IllegalArgumentException("unrecognized digest name: " + str);
    }
}
