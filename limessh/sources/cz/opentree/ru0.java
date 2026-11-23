package cz.opentree;

/* loaded from: classes.dex */
public class ru0 {
    /* renamed from: a */
    public static vt0 m8241a(su0 su0Var) {
        vt0 vt0Var;
        String m8490d = su0Var.m8490d();
        if ("ssh-rsa".equals(m8490d)) {
            vt0Var = new lu0(false, su0Var.m8488b(), su0Var.m8488b());
        } else if ("ssh-dss".equals(m8490d)) {
            vt0Var = new bu0(su0Var.m8488b(), new zt0(su0Var.m8488b(), su0Var.m8488b(), su0Var.m8488b()));
        } else if (m8490d.startsWith("ecdsa")) {
            String m8490d2 = su0Var.m8490d();
            if (m8490d2.startsWith("nist")) {
                String substring = m8490d2.substring(4);
                m8490d2 = substring.substring(0, 1) + "-" + substring.substring(1);
            }
            at0 m9881b = xs0.m9881b(m8490d2);
            if (m9881b == null) {
                throw new IllegalStateException("unable to find curve for " + m8490d + " using curve name " + m8490d2);
            }
            gv0 m2271k = m9881b.m2271k();
            vt0Var = new hu0(m2271k.m4263h(su0Var.m8489c()), new du0(m2271k, m9881b.m2272m(), m9881b.m2274o(), m9881b.m2273n(), m9881b.m2275p()));
        } else if ("ssh-ed25519".equals(m8490d)) {
            byte[] m8489c = su0Var.m8489c();
            if (m8489c.length != 32) {
                throw new IllegalStateException("public key value of wrong length");
            }
            vt0Var = new ju0(m8489c, 0);
        } else {
            vt0Var = null;
        }
        if (vt0Var == null) {
            throw new IllegalArgumentException("unable to parse key");
        }
        if (su0Var.m8487a()) {
            throw new IllegalArgumentException("decoded key has trailing data");
        }
        return vt0Var;
    }

    /* renamed from: b */
    public static vt0 m8242b(byte[] bArr) {
        return m8241a(new su0(bArr));
    }
}
