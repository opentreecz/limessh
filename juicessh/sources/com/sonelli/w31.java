package com.sonelli;

import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.crypto.Digest;

/* loaded from: classes.dex */
public class w31 {
    /* renamed from: a */
    public static vs0 m9406a(String str) {
        if (str.equals("SHA-1")) {
            return new vs0(OIWObjectIdentifiers.f8746a, er0.f2528O);
        }
        if (str.equals("SHA-224")) {
            return new vs0(NISTObjectIdentifiers.f8739f, er0.f2528O);
        }
        if (str.equals("SHA-256")) {
            return new vs0(NISTObjectIdentifiers.f8736c, er0.f2528O);
        }
        if (str.equals("SHA-384")) {
            return new vs0(NISTObjectIdentifiers.f8737d, er0.f2528O);
        }
        if (str.equals("SHA-512")) {
            return new vs0(NISTObjectIdentifiers.f8738e, er0.f2528O);
        }
        throw new IllegalArgumentException("unrecognised digest algorithm: " + str);
    }

    /* renamed from: b */
    public static Digest m9407b(vs0 vs0Var) {
        if (vs0Var.m9343k().m3549o(OIWObjectIdentifiers.f8746a)) {
            return qu0.m7792a();
        }
        if (vs0Var.m9343k().m3549o(NISTObjectIdentifiers.f8739f)) {
            return qu0.m7793b();
        }
        if (vs0Var.m9343k().m3549o(NISTObjectIdentifiers.f8736c)) {
            return qu0.m7794c();
        }
        if (vs0Var.m9343k().m3549o(NISTObjectIdentifiers.f8737d)) {
            return qu0.m7795d();
        }
        if (vs0Var.m9343k().m3549o(NISTObjectIdentifiers.f8738e)) {
            return qu0.m7796e();
        }
        throw new IllegalArgumentException("unrecognised OID in digest algorithm identifier: " + vs0Var.m9343k());
    }
}
