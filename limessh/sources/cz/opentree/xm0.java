package cz.opentree;

import cz.opentree.qm0;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

/* compiled from: Request.java */
/* loaded from: classes.dex */
public final class xm0 {

    /* renamed from: a */
    public final rm0 f8010a;

    /* renamed from: b */
    public final String f8011b;

    /* renamed from: c */
    public final qm0 f8012c;

    /* renamed from: d */
    @Nullable
    public final ym0 f8013d;

    /* renamed from: e */
    public final Map<Class<?>, Object> f8014e;

    /* renamed from: f */
    @Nullable
    public volatile im0 f8015f;

    /* compiled from: Request.java */
    /* renamed from: cz.opentree.xm0$a */
    /* loaded from: classes.dex */
    public static class C2302a {

        /* renamed from: a */
        @Nullable
        public rm0 f8016a;

        /* renamed from: b */
        public String f8017b;

        /* renamed from: c */
        public qm0.C1776a f8018c;

        /* renamed from: d */
        @Nullable
        public ym0 f8019d;

        /* renamed from: e */
        public Map<Class<?>, Object> f8020e;

        public C2302a() {
            this.f8020e = Collections.emptyMap();
            this.f8017b = "GET";
            this.f8018c = new qm0.C1776a();
        }

        public C2302a(xm0 xm0Var) {
            this.f8020e = Collections.emptyMap();
            this.f8016a = xm0Var.f8010a;
            this.f8017b = xm0Var.f8011b;
            this.f8019d = xm0Var.f8013d;
            this.f8020e = xm0Var.f8014e.isEmpty() ? Collections.emptyMap() : new LinkedHashMap<>(xm0Var.f8014e);
            this.f8018c = xm0Var.f8012c.m7751f();
        }

        /* renamed from: a */
        public xm0 m9822a() {
            if (this.f8016a != null) {
                return new xm0(this);
            }
            throw new IllegalStateException("url == null");
        }

        /* renamed from: b */
        public C2302a m9823b(im0 im0Var) {
            String im0Var2 = im0Var.toString();
            if (im0Var2.isEmpty()) {
                m9827f("Cache-Control");
                return this;
            }
            m9824c("Cache-Control", im0Var2);
            return this;
        }

        /* renamed from: c */
        public C2302a m9824c(String str, String str2) {
            this.f8018c.m7760f(str, str2);
            return this;
        }

        /* renamed from: d */
        public C2302a m9825d(qm0 qm0Var) {
            this.f8018c = qm0Var.m7751f();
            return this;
        }

        /* renamed from: e */
        public C2302a m9826e(String str, @Nullable ym0 ym0Var) {
            Objects.requireNonNull(str, "method == null");
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (ym0Var != null && !un0.m8962b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (ym0Var != null || !un0.m8965e(str)) {
                this.f8017b = str;
                this.f8019d = ym0Var;
                return this;
            }
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        }

        /* renamed from: f */
        public C2302a m9827f(String str) {
            this.f8018c.m7759e(str);
            return this;
        }

        /* renamed from: g */
        public C2302a m9828g(rm0 rm0Var) {
            Objects.requireNonNull(rm0Var, "url == null");
            this.f8016a = rm0Var;
            return this;
        }
    }

    public xm0(C2302a c2302a) {
        this.f8010a = c2302a.f8016a;
        this.f8011b = c2302a.f8017b;
        this.f8012c = c2302a.f8018c.m7758d();
        this.f8013d = c2302a.f8019d;
        this.f8014e = fn0.m3841v(c2302a.f8020e);
    }

    @Nullable
    /* renamed from: a */
    public ym0 m9814a() {
        return this.f8013d;
    }

    /* renamed from: b */
    public im0 m9815b() {
        im0 im0Var = this.f8015f;
        if (im0Var != null) {
            return im0Var;
        }
        im0 m4796k = im0.m4796k(this.f8012c);
        this.f8015f = m4796k;
        return m4796k;
    }

    @Nullable
    /* renamed from: c */
    public String m9816c(String str) {
        return this.f8012c.m7749c(str);
    }

    /* renamed from: d */
    public qm0 m9817d() {
        return this.f8012c;
    }

    /* renamed from: e */
    public boolean m9818e() {
        return this.f8010a.m8172m();
    }

    /* renamed from: f */
    public String m9819f() {
        return this.f8011b;
    }

    /* renamed from: g */
    public C2302a m9820g() {
        return new C2302a(this);
    }

    /* renamed from: h */
    public rm0 m9821h() {
        return this.f8010a;
    }

    public String toString() {
        return "Request{method=" + this.f8011b + ", url=" + this.f8010a + ", tags=" + this.f8014e + '}';
    }
}
