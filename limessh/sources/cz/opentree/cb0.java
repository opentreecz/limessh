package cz.opentree;

import cz.opentree.im0;
import cz.opentree.rm0;
import cz.opentree.tm0;
import cz.opentree.um0;
import cz.opentree.xm0;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class cb0 {

    /* renamed from: f */
    public static final um0 f1906f;

    /* renamed from: a */
    public final bb0 f1907a;

    /* renamed from: b */
    public final String f1908b;

    /* renamed from: c */
    public final Map<String, String> f1909c;

    /* renamed from: e */
    public tm0.C1940a f1911e = null;

    /* renamed from: d */
    public final Map<String, String> f1910d = new HashMap();

    static {
        um0.C2022b m8956v = new um0().m8956v();
        m8956v.m8960b(10000L, TimeUnit.MILLISECONDS);
        f1906f = m8956v.m8959a();
    }

    public cb0(bb0 bb0Var, String str, Map<String, String> map) {
        this.f1907a = bb0Var;
        this.f1908b = str;
        this.f1909c = map;
    }

    /* renamed from: a */
    public final xm0 m2748a() {
        xm0.C2302a c2302a = new xm0.C2302a();
        im0.C1167a c1167a = new im0.C1167a();
        c1167a.m4809c();
        c2302a.m9823b(c1167a.m4807a());
        rm0.C1825a m8173o = rm0.m8154q(this.f1908b).m8173o();
        for (Map.Entry<String, String> entry : this.f1909c.entrySet()) {
            m8173o.m8183a(entry.getKey(), entry.getValue());
        }
        c2302a.m9828g(m8173o.m8184b());
        for (Map.Entry<String, String> entry2 : this.f1910d.entrySet()) {
            c2302a.m9824c(entry2.getKey(), entry2.getValue());
        }
        tm0.C1940a c1940a = this.f1911e;
        c2302a.m9826e(this.f1907a.name(), c1940a == null ? null : c1940a.m8777d());
        return c2302a.m9822a();
    }

    /* renamed from: b */
    public eb0 m2749b() throws IOException {
        return eb0.m3470c(f1906f.m8957w(m2748a()).mo9589h());
    }

    /* renamed from: c */
    public final tm0.C1940a m2750c() {
        if (this.f1911e == null) {
            tm0.C1940a c1940a = new tm0.C1940a();
            c1940a.m8778e(tm0.f6794f);
            this.f1911e = c1940a;
        }
        return this.f1911e;
    }

    /* renamed from: d */
    public cb0 m2751d(String str, String str2) {
        this.f1910d.put(str, str2);
        return this;
    }

    /* renamed from: e */
    public cb0 m2752e(Map.Entry<String, String> entry) {
        m2751d(entry.getKey(), entry.getValue());
        return this;
    }

    /* renamed from: f */
    public String m2753f() {
        return this.f1907a.name();
    }

    /* renamed from: g */
    public cb0 m2754g(String str, String str2) {
        tm0.C1940a m2750c = m2750c();
        m2750c.m8774a(str, str2);
        this.f1911e = m2750c;
        return this;
    }

    /* renamed from: h */
    public cb0 m2755h(String str, String str2, String str3, File file) {
        ym0 m10190c = ym0.m10190c(sm0.m8470d(str3), file);
        tm0.C1940a m2750c = m2750c();
        m2750c.m8775b(str, str2, m10190c);
        this.f1911e = m2750c;
        return this;
    }
}
