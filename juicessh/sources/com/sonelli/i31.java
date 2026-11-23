package com.sonelli;

import com.sonelli.t21;
import com.sonelli.v21;
import java.util.Objects;

/* loaded from: classes.dex */
public class i31 {
    /* renamed from: a */
    public static h31 m4713a(x21 x21Var, a31 a31Var, v21 v21Var) {
        double d;
        Objects.requireNonNull(a31Var, "publicKey == null");
        Objects.requireNonNull(v21Var, "address == null");
        int m10325a = x21Var.m9677d().m10325a();
        byte[][] m1977a = a31Var.m1977a();
        h31[] h31VarArr = new h31[m1977a.length];
        for (int i = 0; i < m1977a.length; i++) {
            h31VarArr[i] = new h31(0, m1977a[i]);
        }
        v21.C2150b m2370h = new v21.C2150b().m2369g(v21Var.m2360b()).m2370h(v21Var.m2361c());
        m2370h.m9155n(v21Var.m9147e());
        m2370h.m9156o(0);
        m2370h.m9157p(v21Var.m9149g());
        v21.C2150b m2368f = m2370h.m2368f(v21Var.m2359a());
        while (true) {
            v21 v21Var2 = (v21) m2368f.m9153l();
            if (m10325a <= 1) {
                return h31VarArr[0];
            }
            int i2 = 0;
            while (true) {
                d = m10325a / 2;
                if (i2 >= ((int) Math.floor(d))) {
                    break;
                }
                v21.C2150b m2370h2 = new v21.C2150b().m2369g(v21Var2.m2360b()).m2370h(v21Var2.m2361c());
                m2370h2.m9155n(v21Var2.m9147e());
                m2370h2.m9156o(v21Var2.m9148f());
                m2370h2.m9157p(i2);
                v21Var2 = (v21) m2370h2.m2368f(v21Var2.m2359a()).m9153l();
                int i3 = i2 * 2;
                h31VarArr[i2] = m4714b(x21Var, h31VarArr[i3], h31VarArr[i3 + 1], v21Var2);
                i2++;
            }
            if (m10325a % 2 == 1) {
                h31VarArr[(int) Math.floor(d)] = h31VarArr[m10325a - 1];
            }
            m10325a = (int) Math.ceil(m10325a / 2.0d);
            v21.C2150b m2370h3 = new v21.C2150b().m2369g(v21Var2.m2360b()).m2370h(v21Var2.m2361c());
            m2370h3.m9155n(v21Var2.m9147e());
            m2370h3.m9156o(v21Var2.m9148f() + 1);
            m2370h3.m9157p(v21Var2.m9149g());
            m2368f = m2370h3.m2368f(v21Var2.m2359a());
        }
    }

    /* renamed from: b */
    public static h31 m4714b(x21 x21Var, h31 h31Var, h31 h31Var2, b31 b31Var) {
        Objects.requireNonNull(h31Var, "left == null");
        Objects.requireNonNull(h31Var2, "right == null");
        if (h31Var.m4347a() != h31Var2.m4347a()) {
            throw new IllegalStateException("height of both nodes must be equal");
        }
        Objects.requireNonNull(b31Var, "address == null");
        byte[] m9679f = x21Var.m9679f();
        if (b31Var instanceof v21) {
            v21 v21Var = (v21) b31Var;
            v21.C2150b m2370h = new v21.C2150b().m2369g(v21Var.m2360b()).m2370h(v21Var.m2361c());
            m2370h.m9155n(v21Var.m9147e());
            m2370h.m9156o(v21Var.m9148f());
            m2370h.m9157p(v21Var.m9149g());
            b31Var = (v21) m2370h.m2368f(0).m9153l();
        } else if (b31Var instanceof t21) {
            t21 t21Var = (t21) b31Var;
            t21.C1897b m2370h2 = new t21.C1897b().m2369g(t21Var.m2360b()).m2370h(t21Var.m2361c());
            m2370h2.m8584m(t21Var.m8578e());
            m2370h2.m8585n(t21Var.m8579f());
            b31Var = (t21) m2370h2.m2368f(0).m8582k();
        }
        byte[] m8836c = x21Var.m9676c().m8836c(m9679f, b31Var.mo2362d());
        if (b31Var instanceof v21) {
            v21 v21Var2 = (v21) b31Var;
            v21.C2150b m2370h3 = new v21.C2150b().m2369g(v21Var2.m2360b()).m2370h(v21Var2.m2361c());
            m2370h3.m9155n(v21Var2.m9147e());
            m2370h3.m9156o(v21Var2.m9148f());
            m2370h3.m9157p(v21Var2.m9149g());
            b31Var = (v21) m2370h3.m2368f(1).m9153l();
        } else if (b31Var instanceof t21) {
            t21 t21Var2 = (t21) b31Var;
            t21.C1897b m2370h4 = new t21.C1897b().m2369g(t21Var2.m2360b()).m2370h(t21Var2.m2361c());
            m2370h4.m8584m(t21Var2.m8578e());
            m2370h4.m8585n(t21Var2.m8579f());
            b31Var = (t21) m2370h4.m2368f(1).m8582k();
        }
        byte[] m8836c2 = x21Var.m9676c().m8836c(m9679f, b31Var.mo2362d());
        if (b31Var instanceof v21) {
            v21 v21Var3 = (v21) b31Var;
            v21.C2150b m2370h5 = new v21.C2150b().m2369g(v21Var3.m2360b()).m2370h(v21Var3.m2361c());
            m2370h5.m9155n(v21Var3.m9147e());
            m2370h5.m9156o(v21Var3.m9148f());
            m2370h5.m9157p(v21Var3.m9149g());
            b31Var = (v21) m2370h5.m2368f(2).m9153l();
        } else if (b31Var instanceof t21) {
            t21 t21Var3 = (t21) b31Var;
            t21.C1897b m2370h6 = new t21.C1897b().m2369g(t21Var3.m2360b()).m2370h(t21Var3.m2361c());
            m2370h6.m8584m(t21Var3.m8578e());
            m2370h6.m8585n(t21Var3.m8579f());
            b31Var = (t21) m2370h6.m2368f(2).m8582k();
        }
        byte[] m8836c3 = x21Var.m9676c().m8836c(m9679f, b31Var.mo2362d());
        int m10327c = x21Var.m9677d().m10327c();
        byte[] bArr = new byte[m10327c * 2];
        for (int i = 0; i < m10327c; i++) {
            bArr[i] = (byte) (h31Var.m4348b()[i] ^ m8836c2[i]);
        }
        for (int i2 = 0; i2 < m10327c; i2++) {
            bArr[i2 + m10327c] = (byte) (h31Var2.m4348b()[i2] ^ m8836c3[i2]);
        }
        return new h31(h31Var.m4347a(), x21Var.m9676c().m8835b(m8836c, bArr));
    }
}
