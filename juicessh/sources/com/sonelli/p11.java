package com.sonelli;

import org.bouncycastle.crypto.Digest;

/* loaded from: classes.dex */
public class p11 {
    /* renamed from: a */
    public static void m7217a(byte[] bArr, Digest digest) {
        digest.mo6293a(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    public static void m7218b(short s, Digest digest) {
        digest.mo6294c((byte) (s >>> 8));
        digest.mo6294c((byte) s);
    }

    /* renamed from: c */
    public static void m7219c(int i, Digest digest) {
        digest.mo6294c((byte) (i >>> 24));
        digest.mo6294c((byte) (i >>> 16));
        digest.mo6294c((byte) (i >>> 8));
        digest.mo6294c((byte) i);
    }
}
