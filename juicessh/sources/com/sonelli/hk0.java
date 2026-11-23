package com.sonelli;

/* compiled from: SSHKeyParser.java */
/* loaded from: classes.dex */
public class hk0 {

    /* renamed from: a */
    public static final byte[] f3166a = j51.m5065d("openssh-key-v1\u0000");

    /* renamed from: a */
    public static boolean m4480a(fq0 fq0Var) {
        for (int i = 0; i < fq0Var.size(); i++) {
            if (!(fq0Var.mo3870u(i) instanceof xp0)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static vt0 m4481b(byte[] bArr) {
        vt0 iu0Var;
        if (bArr[0] == 48) {
            fq0 m3869t = fq0.m3869t(bArr);
            if (m3869t.size() == 6) {
                if (m4480a(m3869t) && ((xp0) m3869t.mo3870u(0)).m9870v().equals(f51.f2620a)) {
                    iu0Var = new au0(((xp0) m3869t.mo3870u(5)).m9870v(), new zt0(((xp0) m3869t.mo3870u(1)).m9870v(), ((xp0) m3869t.mo3870u(2)).m9870v(), ((xp0) m3869t.mo3870u(3)).m9870v()));
                }
                iu0Var = null;
            } else if (m3869t.size() == 9) {
                if (m4480a(m3869t) && ((xp0) m3869t.mo3870u(0)).m9870v().equals(f51.f2620a)) {
                    rs0 m8232o = rs0.m8232o(m3869t);
                    iu0Var = new mu0(m8232o.m8236p(), m8232o.m8240t(), m8232o.m8239s(), m8232o.m8237q(), m8232o.m8238r(), m8232o.m8234m(), m8232o.m8235n(), m8232o.m8233k());
                }
                iu0Var = null;
            } else {
                if (m3869t.size() == 4 && (m3869t.mo3870u(3) instanceof iq0) && (m3869t.mo3870u(2) instanceof iq0)) {
                    ss0 m8483k = ss0.m8483k(m3869t);
                    aq0 aq0Var = (aq0) m8483k.m8486o();
                    at0 m9882c = xs0.m9882c(aq0Var);
                    iu0Var = new gu0(m8483k.m8484m(), new fu0(aq0Var, m9882c.m2271k(), m9882c.m2272m(), m9882c.m2274o(), m9882c.m2273n(), m9882c.m2275p()));
                }
                iu0Var = null;
            }
        } else {
            ik0 ik0Var = new ik0(f3166a, bArr);
            if (!"none".equals(ik0Var.m4791e())) {
                throw new IllegalStateException("encrypted keys not supported");
            }
            ik0Var.m4793g();
            ik0Var.m4793g();
            if (ik0Var.m4792f() != 1) {
                throw new IllegalStateException("multiple keys not supported");
            }
            ru0.m8242b(ik0Var.m4788b());
            byte[] m4789c = ik0Var.m4789c();
            if (ik0Var.m4787a()) {
                throw new IllegalArgumentException("decoded key has trailing data");
            }
            ik0 ik0Var2 = new ik0(m4789c);
            if (ik0Var2.m4792f() != ik0Var2.m4792f()) {
                throw new IllegalStateException("private key check values are not the same");
            }
            String m4791e = ik0Var2.m4791e();
            if (!"ssh-ed25519".equals(m4791e)) {
                throw new IllegalStateException("can not parse private key of type " + m4791e);
            }
            ik0Var2.m4793g();
            byte[] m4788b = ik0Var2.m4788b();
            if (m4788b.length != 64) {
                throw new IllegalStateException("private key value of wrong length");
            }
            iu0Var = new iu0(m4788b, 0);
        }
        if (iu0Var != null) {
            return iu0Var;
        }
        throw new IllegalArgumentException("unable to parse key");
    }
}
