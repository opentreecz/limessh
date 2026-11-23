package com.sonelli;

import org.bouncycastle.crypto.Digest;

/* loaded from: classes.dex */
public class o11 {
    /* renamed from: a */
    public static byte[] m6834a(h11 h11Var, byte[] bArr, int i, byte[] bArr2) {
        Digest m3380a = e11.m3380a(h11Var.m4337b());
        d11 m3091f = d11.m3091f();
        m3091f.m3095d(bArr);
        m3091f.m3099i(i);
        m3091f.m3098h(-32640);
        m3091f.m3097g(0, 22);
        byte[] m3093b = m3091f.m3093b();
        m3380a.mo6293a(m3093b, 0, m3093b.length);
        Digest m3380a2 = e11.m3380a(h11Var.m4337b());
        d11 m3091f2 = d11.m3091f();
        m3091f2.m3095d(bArr);
        m3091f2.m3099i(i);
        m3091f2.m3097g(0, m3380a2.mo6519f() + 23);
        byte[] m3093b2 = m3091f2.m3093b();
        q11 q11Var = new q11(bArr, bArr2, e11.m3380a(h11Var.m4337b()));
        q11Var.m7602d(i);
        q11Var.m7601c(0);
        int m4339d = h11Var.m4339d();
        int m4338c = h11Var.m4338c();
        int m4341g = (1 << h11Var.m4341g()) - 1;
        int i2 = 0;
        while (i2 < m4339d) {
            q11Var.m7599a(m3093b2, i2 < m4339d + (-1), 23);
            h51.m4375k((short) i2, m3093b2, 20);
            for (int i3 = 0; i3 < m4341g; i3++) {
                m3093b2[22] = (byte) i3;
                m3380a2.mo6293a(m3093b2, 0, m3093b2.length);
                m3380a2.mo7096b(m3093b2, 23);
            }
            m3380a.mo6293a(m3093b2, 23, m4338c);
            i2++;
        }
        byte[] bArr3 = new byte[m3380a.mo6519f()];
        m3380a.mo7096b(bArr3, 0);
        return bArr3;
    }
}
