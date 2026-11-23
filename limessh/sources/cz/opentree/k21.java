package cz.opentree;

import cz.opentree.g31;
import cz.opentree.l31;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.isara.IsaraObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;

/* loaded from: classes.dex */
public class k21 {

    /* renamed from: a */
    public static Map f4448a;

    /* renamed from: cz.opentree.k21$b */
    /* loaded from: classes.dex */
    public static class C1424b extends AbstractC1428f {
        public C1424b() {
            super();
        }

        @Override // cz.opentree.k21.AbstractC1428f
        /* renamed from: a */
        public vt0 mo5793a(ws0 ws0Var, Object obj) throws IOException {
            byte[] m2598v = bq0.m2592t(ws0Var.m9638o()).m2598v();
            return h51.m4365a(m2598v, 0) == 1 ? l11.m6042a(e51.m3441j(m2598v, 4, m2598v.length)) : g11.m3929a(e51.m3441j(m2598v, 4, m2598v.length));
        }
    }

    /* renamed from: cz.opentree.k21$c */
    /* loaded from: classes.dex */
    public static class C1425c extends AbstractC1428f {
        public C1425c() {
            super();
        }

        @Override // cz.opentree.k21.AbstractC1428f
        /* renamed from: a */
        public vt0 mo5793a(ws0 ws0Var, Object obj) throws IOException {
            return new z11(ws0Var.m9637n().m7437v());
        }
    }

    /* renamed from: cz.opentree.k21$d */
    /* loaded from: classes.dex */
    public static class C1426d extends AbstractC1428f {
        public C1426d() {
            super();
        }

        @Override // cz.opentree.k21.AbstractC1428f
        /* renamed from: a */
        public vt0 mo5793a(ws0 ws0Var, Object obj) throws IOException {
            return new b21(m21.m6342c(ws0Var.m9636k()), ws0Var.m9637n().m7438w());
        }
    }

    /* renamed from: cz.opentree.k21$e */
    /* loaded from: classes.dex */
    public static class C1427e extends AbstractC1428f {
        public C1427e() {
            super();
        }

        @Override // cz.opentree.k21.AbstractC1428f
        /* renamed from: a */
        public vt0 mo5793a(ws0 ws0Var, Object obj) throws IOException {
            return new h21(ws0Var.m9637n().m7437v(), m21.m6344e(w01.m9379k(ws0Var.m9636k().m9344n())));
        }
    }

    /* renamed from: cz.opentree.k21$f */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1428f {
        public AbstractC1428f() {
        }

        /* renamed from: a */
        public abstract vt0 mo5793a(ws0 ws0Var, Object obj) throws IOException;
    }

    /* renamed from: cz.opentree.k21$g */
    /* loaded from: classes.dex */
    public static class C1429g extends AbstractC1428f {
        public C1429g() {
            super();
        }

        @Override // cz.opentree.k21.AbstractC1428f
        /* renamed from: a */
        public vt0 mo5793a(ws0 ws0Var, Object obj) throws IOException {
            x01 m9662m = x01.m9662m(ws0Var.m9636k().m9344n());
            if (m9662m == null) {
                byte[] m2598v = bq0.m2592t(ws0Var.m9638o()).m2598v();
                l31.C1488b c1488b = new l31.C1488b(j31.m5039k(h51.m4365a(m2598v, 0)));
                c1488b.m6059f(m2598v);
                return c1488b.m6058e();
            }
            aq0 m9343k = m9662m.m9664n().m9343k();
            c11 m2652k = c11.m2652k(ws0Var.m9638o());
            l31.C1488b c1488b2 = new l31.C1488b(new j31(m9662m.m9663k(), m21.m6340a(m9343k)));
            c1488b2.m6060g(m2652k.m2653m());
            c1488b2.m6061h(m2652k.m2654n());
            return c1488b2.m6058e();
        }
    }

    /* renamed from: cz.opentree.k21$h */
    /* loaded from: classes.dex */
    public static class C1430h extends AbstractC1428f {
        public C1430h() {
            super();
        }

        @Override // cz.opentree.k21.AbstractC1428f
        /* renamed from: a */
        public vt0 mo5793a(ws0 ws0Var, Object obj) throws IOException {
            y01 m10042m = y01.m10042m(ws0Var.m9636k().m9344n());
            if (m10042m == null) {
                byte[] m2598v = bq0.m2592t(ws0Var.m9638o()).m2598v();
                g31.C1025b c1025b = new g31.C1025b(e31.m3408i(h51.m4365a(m2598v, 0)));
                c1025b.m3980f(m2598v);
                return c1025b.m3979e();
            }
            aq0 m9343k = m10042m.m10045o().m9343k();
            c11 m2652k = c11.m2652k(ws0Var.m9638o());
            g31.C1025b c1025b2 = new g31.C1025b(new e31(m10042m.m10043k(), m10042m.m10044n(), m21.m6340a(m9343k)));
            c1025b2.m3981g(m2652k.m2653m());
            c1025b2.m3982h(m2652k.m2654n());
            return c1025b2.m3979e();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f4448a = hashMap;
        hashMap.put(PQCObjectIdentifiers.f8892q, new C1426d());
        f4448a.put(PQCObjectIdentifiers.f8893r, new C1426d());
        f4448a.put(PQCObjectIdentifiers.f8880e, new C1427e());
        f4448a.put(PQCObjectIdentifiers.f8881f, new C1425c());
        f4448a.put(PQCObjectIdentifiers.f8882g, new C1429g());
        f4448a.put(PQCObjectIdentifiers.f8887l, new C1430h());
        f4448a.put(IsaraObjectIdentifiers.f8732a, new C1429g());
        f4448a.put(IsaraObjectIdentifiers.f8733b, new C1430h());
        f4448a.put(PKCSObjectIdentifiers.f8758l, new C1424b());
    }

    /* renamed from: a */
    public static vt0 m5791a(ws0 ws0Var) throws IOException {
        return m5792b(ws0Var, null);
    }

    /* renamed from: b */
    public static vt0 m5792b(ws0 ws0Var, Object obj) throws IOException {
        vs0 m9636k = ws0Var.m9636k();
        AbstractC1428f abstractC1428f = (AbstractC1428f) f4448a.get(m9636k.m9343k());
        if (abstractC1428f != null) {
            return abstractC1428f.mo5793a(ws0Var, obj);
        }
        throw new IOException("algorithm identifier in public key not recognised: " + m9636k.m9343k());
    }
}
