package cz.opentree;

import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;

/* loaded from: classes.dex */
public class o41 {
    /* renamed from: a */
    public static aq0 m6870a(String str) {
        if (str.equals("SHA-256")) {
            return NISTObjectIdentifiers.f8736c;
        }
        if (str.equals("SHA-512")) {
            return NISTObjectIdentifiers.f8738e;
        }
        if (str.equals("SHAKE128")) {
            return NISTObjectIdentifiers.f8742i;
        }
        if (str.equals("SHAKE256")) {
            return NISTObjectIdentifiers.f8743j;
        }
        throw new IllegalArgumentException("unrecognized digest: " + str);
    }
}
