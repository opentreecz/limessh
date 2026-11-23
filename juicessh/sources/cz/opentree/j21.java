package cz.opentree;

import java.io.IOException;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;

/* loaded from: classes.dex */
public class j21 {
    /* renamed from: a */
    public static qs0 m5036a(vt0 vt0Var, gq0 gq0Var) throws IOException {
        if (vt0Var instanceof a21) {
            a21 a21Var = (a21) vt0Var;
            return new qs0(m21.m6341b(a21Var.m1975b()), new gr0(a21Var.m1974a()), gq0Var);
        }
        if (vt0Var instanceof g21) {
            g21 g21Var = (g21) vt0Var;
            return new qs0(new vs0(PQCObjectIdentifiers.f8880e, new w01(m21.m6343d(g21Var.m3660a()))), new gr0(g21Var.m3968b()));
        }
        if (vt0Var instanceof y11) {
            vs0 vs0Var = new vs0(PQCObjectIdentifiers.f8881f);
            short[] m10049a = ((y11) vt0Var).m10049a();
            byte[] bArr = new byte[m10049a.length * 2];
            for (int i = 0; i != m10049a.length; i++) {
                h51.m4376l(m10049a[i], bArr, i * 2);
            }
            return new qs0(vs0Var, new gr0(bArr));
        }
        if (vt0Var instanceof k11) {
            k11 k11Var = (k11) vt0Var;
            d11 m3091f = d11.m3091f();
            m3091f.m3099i(1);
            m3091f.m3094c(k11Var);
            byte[] m3093b = m3091f.m3093b();
            d11 m3091f2 = d11.m3091f();
            m3091f2.m3099i(1);
            m3091f2.m3094c(k11Var.m5787i());
            return new qs0(new vs0(PKCSObjectIdentifiers.f8758l), new gr0(m3093b), gq0Var, m3091f2.m3093b());
        }
        if (!(vt0Var instanceof f11)) {
            if (vt0Var instanceof k31) {
                k31 k31Var = (k31) vt0Var;
                return new qs0(new vs0(PQCObjectIdentifiers.f8882g, new x01(k31Var.m5802b().m5041b(), m21.m6345f(k31Var.m2662a()))), m5037b(k31Var), gq0Var);
            }
            if (!(vt0Var instanceof f31)) {
                throw new IOException("key parameters not recognized");
            }
            f31 f31Var = (f31) vt0Var;
            return new qs0(new vs0(PQCObjectIdentifiers.f8887l, new y01(f31Var.m3661b().m3410a(), f31Var.m3661b().m3411b(), m21.m6345f(f31Var.m3112a()))), m5038c(f31Var), gq0Var);
        }
        f11 f11Var = (f11) vt0Var;
        d11 m3091f3 = d11.m3091f();
        m3091f3.m3099i(f11Var.m3654b());
        m3091f3.m3094c(f11Var);
        byte[] m3093b2 = m3091f3.m3093b();
        d11 m3091f4 = d11.m3091f();
        m3091f4.m3099i(f11Var.m3654b());
        m3091f4.m3094c(f11Var.m3655c());
        return new qs0(new vs0(PKCSObjectIdentifiers.f8758l), new gr0(m3093b2), gq0Var, m3091f4.m3093b());
    }

    /* renamed from: b */
    public static b11 m5037b(k31 k31Var) throws IOException {
        byte[] encoded = k31Var.getEncoded();
        int m5047h = k31Var.m5802b().m5047h();
        int m5041b = k31Var.m5802b().m5041b();
        int m6351a = (int) m31.m6351a(encoded, 0, 4);
        if (!m31.m6362l(m5041b, m6351a)) {
            throw new IllegalArgumentException("index out of bounds");
        }
        byte[] m6357g = m31.m6357g(encoded, 4, m5047h);
        int i = 4 + m5047h;
        byte[] m6357g2 = m31.m6357g(encoded, i, m5047h);
        int i2 = i + m5047h;
        byte[] m6357g3 = m31.m6357g(encoded, i2, m5047h);
        int i3 = i2 + m5047h;
        byte[] m6357g4 = m31.m6357g(encoded, i3, m5047h);
        int i4 = i3 + m5047h;
        byte[] m6357g5 = m31.m6357g(encoded, i4, encoded.length - i4);
        try {
            n21 n21Var = (n21) m31.m6356f(m6357g5, n21.class);
            return n21Var.m6630c() != (1 << m5041b) - 1 ? new b11(m6351a, m6357g, m6357g2, m6357g3, m6357g4, m6357g5, n21Var.m6630c()) : new b11(m6351a, m6357g, m6357g2, m6357g3, m6357g4, m6357g5);
        } catch (ClassNotFoundException e) {
            throw new IOException("cannot parse BDS: " + e.getMessage());
        }
    }

    /* renamed from: c */
    public static z01 m5038c(f31 f31Var) throws IOException {
        byte[] encoded = f31Var.getEncoded();
        int m3415f = f31Var.m3661b().m3415f();
        int m3410a = f31Var.m3661b().m3410a();
        int i = (m3410a + 7) / 8;
        long m6351a = (int) m31.m6351a(encoded, 0, i);
        if (!m31.m6362l(m3410a, m6351a)) {
            throw new IllegalArgumentException("index out of bounds");
        }
        int i2 = i + 0;
        byte[] m6357g = m31.m6357g(encoded, i2, m3415f);
        int i3 = i2 + m3415f;
        byte[] m6357g2 = m31.m6357g(encoded, i3, m3415f);
        int i4 = i3 + m3415f;
        byte[] m6357g3 = m31.m6357g(encoded, i4, m3415f);
        int i5 = i4 + m3415f;
        byte[] m6357g4 = m31.m6357g(encoded, i5, m3415f);
        int i6 = i5 + m3415f;
        byte[] m6357g5 = m31.m6357g(encoded, i6, encoded.length - i6);
        try {
            o21 o21Var = (o21) m31.m6356f(m6357g5, o21.class);
            return o21Var.m6837b() != (1 << m3410a) - 1 ? new z01(m6351a, m6357g, m6357g2, m6357g3, m6357g4, m6357g5, o21Var.m6837b()) : new z01(m6351a, m6357g, m6357g2, m6357g3, m6357g4, m6357g5);
        } catch (ClassNotFoundException e) {
            throw new IOException("cannot parse BDSStateMap: " + e.getMessage());
        }
    }
}
