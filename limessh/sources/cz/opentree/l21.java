package cz.opentree;

import java.io.IOException;
import org.bouncycastle.asn1.isara.IsaraObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;

/* loaded from: classes.dex */
public class l21 {
    /* renamed from: a */
    public static ws0 m6045a(vt0 vt0Var) throws IOException {
        if (vt0Var instanceof b21) {
            b21 b21Var = (b21) vt0Var;
            return new ws0(m21.m6341b(b21Var.m2357b()), b21Var.m2356a());
        }
        if (vt0Var instanceof h21) {
            h21 h21Var = (h21) vt0Var;
            return new ws0(new vs0(PQCObjectIdentifiers.f8880e, new w01(m21.m6343d(h21Var.m3660a()))), h21Var.m4343b());
        }
        if (vt0Var instanceof z11) {
            return new ws0(new vs0(PQCObjectIdentifiers.f8881f), ((z11) vt0Var).m10322a());
        }
        if (vt0Var instanceof l11) {
            d11 m3091f = d11.m3091f();
            m3091f.m3099i(1);
            m3091f.m3094c((l11) vt0Var);
            return new ws0(new vs0(PKCSObjectIdentifiers.f8758l), new gr0(m3091f.m3093b()));
        }
        if (vt0Var instanceof g11) {
            g11 g11Var = (g11) vt0Var;
            d11 m3091f2 = d11.m3091f();
            m3091f2.m3099i(g11Var.m3930b());
            m3091f2.m3094c(g11Var);
            return new ws0(new vs0(PKCSObjectIdentifiers.f8758l), new gr0(m3091f2.m3093b()));
        }
        if (vt0Var instanceof l31) {
            l31 l31Var = (l31) vt0Var;
            byte[] m6051c = l31Var.m6051c();
            byte[] m6052d = l31Var.m6052d();
            byte[] encoded = l31Var.getEncoded();
            return encoded.length > m6051c.length + m6052d.length ? new ws0(new vs0(IsaraObjectIdentifiers.f8732a), new gr0(encoded)) : new ws0(new vs0(PQCObjectIdentifiers.f8882g, new x01(l31Var.m6050b().m5041b(), m21.m6345f(l31Var.m2662a()))), new c11(m6051c, m6052d));
        }
        if (!(vt0Var instanceof g31)) {
            throw new IOException("key parameters not recognized");
        }
        g31 g31Var = (g31) vt0Var;
        byte[] m3972c = g31Var.m3972c();
        byte[] m3973d = g31Var.m3973d();
        byte[] encoded2 = g31Var.getEncoded();
        return encoded2.length > m3972c.length + m3973d.length ? new ws0(new vs0(IsaraObjectIdentifiers.f8733b), new gr0(encoded2)) : new ws0(new vs0(PQCObjectIdentifiers.f8887l, new y01(g31Var.m3971b().m3410a(), g31Var.m3971b().m3411b(), m21.m6345f(g31Var.m3112a()))), new a11(g31Var.m3972c(), g31Var.m3973d()));
    }
}
