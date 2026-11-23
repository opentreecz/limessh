package cz.opentree;

import cz.opentree.gv0;
import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.asn1.anssi.ANSSIObjectIdentifiers;

/* loaded from: classes.dex */
public class ls0 {

    /* renamed from: a */
    public static bt0 f4908a = new C1522a();

    /* renamed from: b */
    public static final Hashtable f4909b = new Hashtable();

    /* renamed from: c */
    public static final Hashtable f4910c = new Hashtable();

    /* renamed from: d */
    public static final Hashtable f4911d = new Hashtable();

    /* renamed from: cz.opentree.ls0$a */
    /* loaded from: classes.dex */
    public static class C1522a extends bt0 {
        @Override // cz.opentree.bt0
        /* renamed from: a */
        public at0 mo2603a() {
            BigInteger m6287g = ls0.m6287g("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C03");
            BigInteger m6287g2 = ls0.m6287g("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C00");
            BigInteger m6287g3 = ls0.m6287g("EE353FCA5428A9300D4ABA754A44C00FDFEC0C9AE4B1A1803075ED967B7BB73F");
            BigInteger m6287g4 = ls0.m6287g("F1FD178C0B3AD58F10126DE8CE42435B53DC67E140D2BF941FFDD459C6D655E1");
            BigInteger valueOf = BigInteger.valueOf(1L);
            gv0.C1079f c1079f = new gv0.C1079f(m6287g, m6287g2, m6287g3, m6287g4, valueOf);
            ls0.m6282b(c1079f);
            return new at0(c1079f, ls0.m6284d(c1079f, "04B6B3D4C356C139EB31183D4749D423958C27D2DCAF98B70164C97A2DD98F5CFF6142E0F7C8B204911F9271F0F3ECEF8C2701C307E8E4C9E183115A1554062CFB"), m6287g4, valueOf, null);
        }
    }

    static {
        m6286f("FRP256v1", ANSSIObjectIdentifiers.f8685a, f4908a);
    }

    /* renamed from: b */
    public static /* synthetic */ gv0 m6282b(gv0 gv0Var) {
        m6285e(gv0Var);
        return gv0Var;
    }

    /* renamed from: d */
    public static ct0 m6284d(gv0 gv0Var, String str) {
        ct0 ct0Var = new ct0(gv0Var, o51.m6872a(str));
        pv0.m7553a(ct0Var.m2980k());
        return ct0Var;
    }

    /* renamed from: e */
    public static gv0 m6285e(gv0 gv0Var) {
        return gv0Var;
    }

    /* renamed from: f */
    public static void m6286f(String str, aq0 aq0Var, bt0 bt0Var) {
        f4909b.put(j51.m5066e(str), aq0Var);
        f4911d.put(aq0Var, str);
        f4910c.put(aq0Var, bt0Var);
    }

    /* renamed from: g */
    public static BigInteger m6287g(String str) {
        return new BigInteger(1, o51.m6872a(str));
    }

    /* renamed from: h */
    public static at0 m6288h(String str) {
        aq0 m6290j = m6290j(str);
        if (m6290j == null) {
            return null;
        }
        return m6289i(m6290j);
    }

    /* renamed from: i */
    public static at0 m6289i(aq0 aq0Var) {
        bt0 bt0Var = (bt0) f4910c.get(aq0Var);
        if (bt0Var == null) {
            return null;
        }
        return bt0Var.m2604b();
    }

    /* renamed from: j */
    public static aq0 m6290j(String str) {
        return (aq0) f4909b.get(j51.m5066e(str));
    }
}
