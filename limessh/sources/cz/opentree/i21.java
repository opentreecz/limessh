package cz.opentree;

import cz.opentree.f31;
import cz.opentree.k31;
import java.io.IOException;
import org.bouncycastle.asn1.p003bc.BCObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;

/* loaded from: classes.dex */
public class i21 {
    /* renamed from: a */
    public static short[] m4708a(byte[] bArr) {
        int length = bArr.length / 2;
        short[] sArr = new short[length];
        for (int i = 0; i != length; i++) {
            sArr[i] = h51.m4371g(bArr, i * 2);
        }
        return sArr;
    }

    /* renamed from: b */
    public static vt0 m4709b(qs0 qs0Var) throws IOException {
        aq0 m9343k = qs0Var.m7782n().m9343k();
        if (m9343k.m2256F(BCObjectIdentifiers.f8689D)) {
            return new a21(m21.m6342c(qs0Var.m7782n()), bq0.m2592t(qs0Var.m7784q()).m2598v());
        }
        if (m9343k.m3549o(BCObjectIdentifiers.f8702h)) {
            return new g21(bq0.m2592t(qs0Var.m7784q()).m2598v(), m21.m6344e(w01.m9379k(qs0Var.m7782n().m9344n())));
        }
        if (m9343k.m3549o(BCObjectIdentifiers.f8693H)) {
            return new y11(m4708a(bq0.m2592t(qs0Var.m7784q()).m2598v()));
        }
        if (m9343k.m3549o(PKCSObjectIdentifiers.f8758l)) {
            byte[] m2598v = bq0.m2592t(qs0Var.m7784q()).m2598v();
            pp0 m7783o = qs0Var.m7783o();
            if (h51.m4365a(m2598v, 0) != 1) {
                return f11.m3652a(e51.m3441j(m2598v, 4, m2598v.length));
            }
            if (m7783o == null) {
                return k11.m5779e(e51.m3441j(m2598v, 4, m2598v.length));
            }
            byte[] m7438w = m7783o.m7438w();
            return k11.m5780f(e51.m3441j(m2598v, 4, m2598v.length), e51.m3441j(m7438w, 4, m7438w.length));
        }
        if (m9343k.m3549o(BCObjectIdentifiers.f8706l)) {
            x01 m9662m = x01.m9662m(qs0Var.m7782n().m9344n());
            aq0 m9343k2 = m9662m.m9664n().m9343k();
            b11 m2335n = b11.m2335n(qs0Var.m7784q());
            try {
                k31.C1433b c1433b = new k31.C1433b(new j31(m9662m.m9663k(), m21.m6340a(m9343k2)));
                c1433b.m5815l(m2335n.m2337m());
                c1433b.m5820q(m2335n.m2342s());
                c1433b.m5819p(m2335n.m2341r());
                c1433b.m5817n(m2335n.m2339p());
                c1433b.m5818o(m2335n.m2340q());
                if (m2335n.m2343t() != 0) {
                    c1433b.m5816m(m2335n.m2338o());
                }
                if (m2335n.m2336k() != null) {
                    c1433b.m5814k(((n21) m31.m6356f(m2335n.m2336k(), n21.class)).m6635i(m9343k2));
                }
                return c1433b.m5813j();
            } catch (ClassNotFoundException e) {
                throw new IOException("ClassNotFoundException processing BDS state: " + e.getMessage());
            }
        }
        if (!m9343k.m3549o(PQCObjectIdentifiers.f8887l)) {
            throw new RuntimeException("algorithm identifier in private key not recognised");
        }
        y01 m10042m = y01.m10042m(qs0Var.m7782n().m9344n());
        aq0 m9343k3 = m10042m.m10045o().m9343k();
        try {
            z01 m10312n = z01.m10312n(qs0Var.m7784q());
            f31.C0968b c0968b = new f31.C0968b(new e31(m10042m.m10043k(), m10042m.m10044n(), m21.m6340a(m9343k3)));
            c0968b.m3675m(m10312n.m10314m());
            c0968b.m3680r(m10312n.m10319s());
            c0968b.m3679q(m10312n.m10318r());
            c0968b.m3677o(m10312n.m10316p());
            c0968b.m3678p(m10312n.m10317q());
            if (m10312n.m10320t() != 0) {
                c0968b.m3676n(m10312n.m10315o());
            }
            if (m10312n.m10313k() != null) {
                c0968b.m3674l(((o21) m31.m6356f(m10312n.m10313k(), o21.class)).m6841f(m9343k3));
            }
            return c0968b.m3673k();
        } catch (ClassNotFoundException e2) {
            throw new IOException("ClassNotFoundException processing BDS state: " + e2.getMessage());
        }
    }
}
