package cz.opentree;

import cz.opentree.qm0;
import cz.opentree.xm0;
import cz.opentree.zm0;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: CacheStrategy.java */
/* loaded from: classes.dex */
public final class in0 {

    /* renamed from: a */
    @Nullable
    public final xm0 f3365a;

    /* renamed from: b */
    @Nullable
    public final zm0 f3366b;

    /* compiled from: CacheStrategy.java */
    /* renamed from: cz.opentree.in0$a */
    /* loaded from: classes.dex */
    public static class C1169a {

        /* renamed from: a */
        public final long f3367a;

        /* renamed from: b */
        public final xm0 f3368b;

        /* renamed from: c */
        public final zm0 f3369c;

        /* renamed from: d */
        public Date f3370d;

        /* renamed from: e */
        public String f3371e;

        /* renamed from: f */
        public Date f3372f;

        /* renamed from: g */
        public String f3373g;

        /* renamed from: h */
        public Date f3374h;

        /* renamed from: i */
        public long f3375i;

        /* renamed from: j */
        public long f3376j;

        /* renamed from: k */
        public String f3377k;

        /* renamed from: l */
        public int f3378l;

        public C1169a(long j, xm0 xm0Var, zm0 zm0Var) {
            this.f3378l = -1;
            this.f3367a = j;
            this.f3368b = xm0Var;
            this.f3369c = zm0Var;
            if (zm0Var != null) {
                this.f3375i = zm0Var.m10517z();
                this.f3376j = zm0Var.m10515x();
                qm0 m10512l = zm0Var.m10512l();
                int m7752h = m10512l.m7752h();
                for (int i = 0; i < m7752h; i++) {
                    String m7750e = m10512l.m7750e(i);
                    String m7753i = m10512l.m7753i(i);
                    if ("Date".equalsIgnoreCase(m7750e)) {
                        this.f3370d = sn0.m8476b(m7753i);
                        this.f3371e = m7753i;
                    } else if ("Expires".equalsIgnoreCase(m7750e)) {
                        this.f3374h = sn0.m8476b(m7753i);
                    } else if ("Last-Modified".equalsIgnoreCase(m7750e)) {
                        this.f3372f = sn0.m8476b(m7753i);
                        this.f3373g = m7753i;
                    } else if ("ETag".equalsIgnoreCase(m7750e)) {
                        this.f3377k = m7753i;
                    } else if ("Age".equalsIgnoreCase(m7750e)) {
                        this.f3378l = tn0.m8785d(m7753i, -1);
                    }
                }
            }
        }

        /* renamed from: e */
        public static boolean m4815e(xm0 xm0Var) {
            return (xm0Var.m9816c("If-Modified-Since") == null && xm0Var.m9816c("If-None-Match") == null) ? false : true;
        }

        /* renamed from: a */
        public final long m4816a() {
            Date date = this.f3370d;
            long max = date != null ? Math.max(0L, this.f3376j - date.getTime()) : 0L;
            int i = this.f3378l;
            if (i != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.f3376j;
            return max + (j - this.f3375i) + (this.f3367a - j);
        }

        /* renamed from: b */
        public final long m4817b() {
            if (this.f3369c.m10507b().m4800d() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.m4800d());
            }
            if (this.f3374h != null) {
                Date date = this.f3370d;
                long time = this.f3374h.getTime() - (date != null ? date.getTime() : this.f3376j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f3372f == null || this.f3369c.m10516y().m9821h().m8177y() != null) {
                return 0L;
            }
            Date date2 = this.f3370d;
            long time2 = (date2 != null ? date2.getTime() : this.f3375i) - this.f3372f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        /* renamed from: c */
        public in0 m4818c() {
            in0 m4819d = m4819d();
            return (m4819d.f3365a == null || !this.f3368b.m9815b().m4806j()) ? m4819d : new in0(null, null);
        }

        /* renamed from: d */
        public final in0 m4819d() {
            if (this.f3369c == null) {
                return new in0(this.f3368b, null);
            }
            if ((!this.f3368b.m9818e() || this.f3369c.m10509d() != null) && in0.m4814a(this.f3369c, this.f3368b)) {
                im0 m9815b = this.f3368b.m9815b();
                if (m9815b.m4804h() || m4815e(this.f3368b)) {
                    return new in0(this.f3368b, null);
                }
                im0 m10507b = this.f3369c.m10507b();
                long m4816a = m4816a();
                long m4817b = m4817b();
                if (m9815b.m4800d() != -1) {
                    m4817b = Math.min(m4817b, TimeUnit.SECONDS.toMillis(m9815b.m4800d()));
                }
                long j = 0;
                long millis = m9815b.m4802f() != -1 ? TimeUnit.SECONDS.toMillis(m9815b.m4802f()) : 0L;
                if (!m10507b.m4803g() && m9815b.m4801e() != -1) {
                    j = TimeUnit.SECONDS.toMillis(m9815b.m4801e());
                }
                if (!m10507b.m4804h()) {
                    long j2 = millis + m4816a;
                    if (j2 < j + m4817b) {
                        zm0.C2434a m10513n = this.f3369c.m10513n();
                        if (j2 >= m4817b) {
                            m10513n.m10518a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (m4816a > 86400000 && m4820f()) {
                            m10513n.m10518a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new in0(null, m10513n.m10520c());
                    }
                }
                String str = this.f3377k;
                String str2 = "If-Modified-Since";
                if (str != null) {
                    str2 = "If-None-Match";
                } else if (this.f3372f != null) {
                    str = this.f3373g;
                } else {
                    if (this.f3370d == null) {
                        return new in0(this.f3368b, null);
                    }
                    str = this.f3371e;
                }
                qm0.C1776a m7751f = this.f3368b.m9817d().m7751f();
                dn0.f2249a.mo3266b(m7751f, str2, str);
                xm0.C2302a m9820g = this.f3368b.m9820g();
                m9820g.m9825d(m7751f.m7758d());
                return new in0(m9820g.m9822a(), this.f3369c);
            }
            return new in0(this.f3368b, null);
        }

        /* renamed from: f */
        public final boolean m4820f() {
            return this.f3369c.m10507b().m4800d() == -1 && this.f3374h == null;
        }
    }

    public in0(xm0 xm0Var, zm0 zm0Var) {
        this.f3365a = xm0Var;
        this.f3366b = zm0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.m10507b().m4798b() == false) goto L33;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean m4814a(cz.opentree.zm0 r3, cz.opentree.xm0 r4) {
        /*
            int r0 = r3.m10508c()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.m10510f(r0)
            if (r0 != 0) goto L5a
            cz.opentree.im0 r0 = r3.m10507b()
            int r0 = r0.m4800d()
            r1 = -1
            if (r0 != r1) goto L5a
            cz.opentree.im0 r0 = r3.m10507b()
            boolean r0 = r0.m4799c()
            if (r0 != 0) goto L5a
            cz.opentree.im0 r0 = r3.m10507b()
            boolean r0 = r0.m4798b()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            cz.opentree.im0 r3 = r3.m10507b()
            boolean r3 = r3.m4805i()
            if (r3 != 0) goto L6f
            cz.opentree.im0 r3 = r4.m9815b()
            boolean r3 = r3.m4805i()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.in0.m4814a(cz.opentree.zm0, cz.opentree.xm0):boolean");
    }
}
