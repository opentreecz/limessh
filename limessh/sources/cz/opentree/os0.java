package cz.opentree;

import cz.opentree.gv0;
import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.asn1.gm.GMObjectIdentifiers;

/* loaded from: classes.dex */
public class os0 {

    /* renamed from: a */
    public static bt0 f5541a = new C1671a();

    /* renamed from: b */
    public static bt0 f5542b = new C1672b();

    /* renamed from: c */
    public static final Hashtable f5543c = new Hashtable();

    /* renamed from: d */
    public static final Hashtable f5544d = new Hashtable();

    /* renamed from: e */
    public static final Hashtable f5545e = new Hashtable();

    /* renamed from: cz.opentree.os0$a */
    /* loaded from: classes.dex */
    public static class C1671a extends bt0 {
        @Override // cz.opentree.bt0
        /* renamed from: a */
        public at0 mo2603a() {
            BigInteger m7092g = os0.m7092g("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF");
            BigInteger m7092g2 = os0.m7092g("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC");
            BigInteger m7092g3 = os0.m7092g("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93");
            BigInteger m7092g4 = os0.m7092g("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123");
            BigInteger valueOf = BigInteger.valueOf(1L);
            gv0.C1079f c1079f = new gv0.C1079f(m7092g, m7092g2, m7092g3, m7092g4, valueOf);
            os0.m7087b(c1079f);
            return new at0(c1079f, os0.m7089d(c1079f, "0432C4AE2C1F1981195F9904466A39C9948FE30BBFF2660BE1715A4589334C74C7BC3736A2F4F6779C59BDCEE36B692153D0A9877CC62A474002DF32E52139F0A0"), m7092g4, valueOf, null);
        }
    }

    /* renamed from: cz.opentree.os0$b */
    /* loaded from: classes.dex */
    public static class C1672b extends bt0 {
        @Override // cz.opentree.bt0
        /* renamed from: a */
        public at0 mo2603a() {
            BigInteger m7092g = os0.m7092g("BDB6F4FE3E8B1D9E0DA8C0D46F4C318CEFE4AFE3B6B8551F");
            BigInteger m7092g2 = os0.m7092g("BB8E5E8FBC115E139FE6A814FE48AAA6F0ADA1AA5DF91985");
            BigInteger m7092g3 = os0.m7092g("1854BEBDC31B21B7AEFC80AB0ECD10D5B1B3308E6DBF11C1");
            BigInteger m7092g4 = os0.m7092g("BDB6F4FE3E8B1D9E0DA8C0D40FC962195DFAE76F56564677");
            BigInteger valueOf = BigInteger.valueOf(1L);
            gv0.C1079f c1079f = new gv0.C1079f(m7092g, m7092g2, m7092g3, m7092g4, valueOf);
            os0.m7087b(c1079f);
            return new at0(c1079f, os0.m7089d(c1079f, "044AD5F7048DE709AD51236DE65E4D4B482C836DC6E410664002BB3A02D4AAADACAE24817A4CA3A1B014B5270432DB27D2"), m7092g4, valueOf, null);
        }
    }

    static {
        m7091f("wapip192v1", GMObjectIdentifiers.f8730d, f5542b);
        m7091f("sm2p256v1", GMObjectIdentifiers.f8728b, f5541a);
    }

    /* renamed from: b */
    public static /* synthetic */ gv0 m7087b(gv0 gv0Var) {
        m7090e(gv0Var);
        return gv0Var;
    }

    /* renamed from: d */
    public static ct0 m7089d(gv0 gv0Var, String str) {
        ct0 ct0Var = new ct0(gv0Var, o51.m6872a(str));
        pv0.m7553a(ct0Var.m2980k());
        return ct0Var;
    }

    /* renamed from: e */
    public static gv0 m7090e(gv0 gv0Var) {
        return gv0Var;
    }

    /* renamed from: f */
    public static void m7091f(String str, aq0 aq0Var, bt0 bt0Var) {
        f5543c.put(j51.m5066e(str), aq0Var);
        f5545e.put(aq0Var, str);
        f5544d.put(aq0Var, bt0Var);
    }

    /* renamed from: g */
    public static BigInteger m7092g(String str) {
        return new BigInteger(1, o51.m6872a(str));
    }

    /* renamed from: h */
    public static at0 m7093h(String str) {
        aq0 m7095j = m7095j(str);
        if (m7095j == null) {
            return null;
        }
        return m7094i(m7095j);
    }

    /* renamed from: i */
    public static at0 m7094i(aq0 aq0Var) {
        bt0 bt0Var = (bt0) f5544d.get(aq0Var);
        if (bt0Var == null) {
            return null;
        }
        return bt0Var.m2604b();
    }

    /* renamed from: j */
    public static aq0 m7095j(String str) {
        return (aq0) f5543c.get(j51.m5066e(str));
    }
}
