package com.sonelli;

import org.bouncycastle.asn1.ASN1Encodable;

/* loaded from: classes.dex */
public class j41 {
    /* renamed from: a */
    public static byte[] m5053a(vs0 vs0Var, ASN1Encodable aSN1Encodable) {
        try {
            return m5054b(new ws0(vs0Var, aSN1Encodable));
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static byte[] m5054b(ws0 ws0Var) {
        try {
            return ws0Var.m10587j("DER");
        } catch (Exception unused) {
            return null;
        }
    }
}
