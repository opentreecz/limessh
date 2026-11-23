package com.sonelli;

import com.sonelli.qm0;
import java.io.Closeable;
import javax.annotation.Nullable;

/* compiled from: Response.java */
/* loaded from: classes.dex */
public final class zm0 implements Closeable {

    /* renamed from: O */
    public final xm0 f8540O;

    /* renamed from: P */
    public final vm0 f8541P;

    /* renamed from: Q */
    public final int f8542Q;

    /* renamed from: R */
    public final String f8543R;

    /* renamed from: S */
    @Nullable
    public final pm0 f8544S;

    /* renamed from: T */
    public final qm0 f8545T;

    /* renamed from: U */
    @Nullable
    public final an0 f8546U;

    /* renamed from: V */
    @Nullable
    public final zm0 f8547V;

    /* renamed from: W */
    @Nullable
    public final zm0 f8548W;

    /* renamed from: X */
    @Nullable
    public final zm0 f8549X;

    /* renamed from: Y */
    public final long f8550Y;

    /* renamed from: Z */
    public final long f8551Z;

    /* renamed from: a0 */
    @Nullable
    public volatile im0 f8552a0;

    /* compiled from: Response.java */
    /* renamed from: com.sonelli.zm0$a */
    /* loaded from: classes.dex */
    public static class C2434a {

        /* renamed from: a */
        @Nullable
        public xm0 f8553a;

        /* renamed from: b */
        @Nullable
        public vm0 f8554b;

        /* renamed from: c */
        public int f8555c;

        /* renamed from: d */
        public String f8556d;

        /* renamed from: e */
        @Nullable
        public pm0 f8557e;

        /* renamed from: f */
        public qm0.C1776a f8558f;

        /* renamed from: g */
        @Nullable
        public an0 f8559g;

        /* renamed from: h */
        @Nullable
        public zm0 f8560h;

        /* renamed from: i */
        @Nullable
        public zm0 f8561i;

        /* renamed from: j */
        @Nullable
        public zm0 f8562j;

        /* renamed from: k */
        public long f8563k;

        /* renamed from: l */
        public long f8564l;

        public C2434a() {
            this.f8555c = -1;
            this.f8558f = new qm0.C1776a();
        }

        public C2434a(zm0 zm0Var) {
            this.f8555c = -1;
            this.f8553a = zm0Var.f8540O;
            this.f8554b = zm0Var.f8541P;
            this.f8555c = zm0Var.f8542Q;
            this.f8556d = zm0Var.f8543R;
            this.f8557e = zm0Var.f8544S;
            this.f8558f = zm0Var.f8545T.m7751f();
            this.f8559g = zm0Var.f8546U;
            this.f8560h = zm0Var.f8547V;
            this.f8561i = zm0Var.f8548W;
            this.f8562j = zm0Var.f8549X;
            this.f8563k = zm0Var.f8550Y;
            this.f8564l = zm0Var.f8551Z;
        }

        /* renamed from: a */
        public C2434a m10518a(String str, String str2) {
            this.f8558f.m7755a(str, str2);
            return this;
        }

        /* renamed from: b */
        public C2434a m10519b(@Nullable an0 an0Var) {
            this.f8559g = an0Var;
            return this;
        }

        /* renamed from: c */
        public zm0 m10520c() {
            if (this.f8553a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f8554b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.f8555c >= 0) {
                if (this.f8556d != null) {
                    return new zm0(this);
                }
                throw new IllegalStateException("message == null");
            }
            throw new IllegalStateException("code < 0: " + this.f8555c);
        }

        /* renamed from: d */
        public C2434a m10521d(@Nullable zm0 zm0Var) {
            if (zm0Var != null) {
                m10523f("cacheResponse", zm0Var);
            }
            this.f8561i = zm0Var;
            return this;
        }

        /* renamed from: e */
        public final void m10522e(zm0 zm0Var) {
            if (zm0Var.f8546U != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        /* renamed from: f */
        public final void m10523f(String str, zm0 zm0Var) {
            if (zm0Var.f8546U != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (zm0Var.f8547V != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (zm0Var.f8548W != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (zm0Var.f8549X == null) {
                return;
            }
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }

        /* renamed from: g */
        public C2434a m10524g(int i) {
            this.f8555c = i;
            return this;
        }

        /* renamed from: h */
        public C2434a m10525h(@Nullable pm0 pm0Var) {
            this.f8557e = pm0Var;
            return this;
        }

        /* renamed from: i */
        public C2434a m10526i(String str, String str2) {
            this.f8558f.m7760f(str, str2);
            return this;
        }

        /* renamed from: j */
        public C2434a m10527j(qm0 qm0Var) {
            this.f8558f = qm0Var.m7751f();
            return this;
        }

        /* renamed from: k */
        public C2434a m10528k(String str) {
            this.f8556d = str;
            return this;
        }

        /* renamed from: l */
        public C2434a m10529l(@Nullable zm0 zm0Var) {
            if (zm0Var != null) {
                m10523f("networkResponse", zm0Var);
            }
            this.f8560h = zm0Var;
            return this;
        }

        /* renamed from: m */
        public C2434a m10530m(@Nullable zm0 zm0Var) {
            if (zm0Var != null) {
                m10522e(zm0Var);
            }
            this.f8562j = zm0Var;
            return this;
        }

        /* renamed from: n */
        public C2434a m10531n(vm0 vm0Var) {
            this.f8554b = vm0Var;
            return this;
        }

        /* renamed from: o */
        public C2434a m10532o(long j) {
            this.f8564l = j;
            return this;
        }

        /* renamed from: p */
        public C2434a m10533p(xm0 xm0Var) {
            this.f8553a = xm0Var;
            return this;
        }

        /* renamed from: q */
        public C2434a m10534q(long j) {
            this.f8563k = j;
            return this;
        }
    }

    public zm0(C2434a c2434a) {
        this.f8540O = c2434a.f8553a;
        this.f8541P = c2434a.f8554b;
        this.f8542Q = c2434a.f8555c;
        this.f8543R = c2434a.f8556d;
        this.f8544S = c2434a.f8557e;
        this.f8545T = c2434a.f8558f.m7758d();
        this.f8546U = c2434a.f8559g;
        this.f8547V = c2434a.f8560h;
        this.f8548W = c2434a.f8561i;
        this.f8549X = c2434a.f8562j;
        this.f8550Y = c2434a.f8563k;
        this.f8551Z = c2434a.f8564l;
    }

    @Nullable
    /* renamed from: a */
    public an0 m10506a() {
        return this.f8546U;
    }

    /* renamed from: b */
    public im0 m10507b() {
        im0 im0Var = this.f8552a0;
        if (im0Var != null) {
            return im0Var;
        }
        im0 m4796k = im0.m4796k(this.f8545T);
        this.f8552a0 = m4796k;
        return m4796k;
    }

    /* renamed from: c */
    public int m10508c() {
        return this.f8542Q;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        an0 an0Var = this.f8546U;
        if (an0Var == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        an0Var.close();
    }

    @Nullable
    /* renamed from: d */
    public pm0 m10509d() {
        return this.f8544S;
    }

    @Nullable
    /* renamed from: f */
    public String m10510f(String str) {
        return m10511h(str, null);
    }

    @Nullable
    /* renamed from: h */
    public String m10511h(String str, @Nullable String str2) {
        String m7749c = this.f8545T.m7749c(str);
        return m7749c != null ? m7749c : str2;
    }

    /* renamed from: l */
    public qm0 m10512l() {
        return this.f8545T;
    }

    /* renamed from: n */
    public C2434a m10513n() {
        return new C2434a(this);
    }

    @Nullable
    /* renamed from: p */
    public zm0 m10514p() {
        return this.f8549X;
    }

    public String toString() {
        return "Response{protocol=" + this.f8541P + ", code=" + this.f8542Q + ", message=" + this.f8543R + ", url=" + this.f8540O.m9821h() + '}';
    }

    /* renamed from: x */
    public long m10515x() {
        return this.f8551Z;
    }

    /* renamed from: y */
    public xm0 m10516y() {
        return this.f8540O;
    }

    /* renamed from: z */
    public long m10517z() {
        return this.f8550Y;
    }
}
