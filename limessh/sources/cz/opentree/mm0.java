package cz.opentree;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

/* compiled from: ConnectionSpec.java */
/* loaded from: classes.dex */
public final class mm0 {

    /* renamed from: e */
    public static final km0[] f5095e;

    /* renamed from: f */
    public static final km0[] f5096f;

    /* renamed from: g */
    public static final mm0 f5097g;

    /* renamed from: h */
    public static final mm0 f5098h;

    /* renamed from: a */
    public final boolean f5099a;

    /* renamed from: b */
    public final boolean f5100b;

    /* renamed from: c */
    @Nullable
    public final String[] f5101c;

    /* renamed from: d */
    @Nullable
    public final String[] f5102d;

    /* compiled from: ConnectionSpec.java */
    /* renamed from: cz.opentree.mm0$a */
    /* loaded from: classes.dex */
    public static final class C1561a {

        /* renamed from: a */
        public boolean f5103a;

        /* renamed from: b */
        @Nullable
        public String[] f5104b;

        /* renamed from: c */
        @Nullable
        public String[] f5105c;

        /* renamed from: d */
        public boolean f5106d;

        public C1561a(mm0 mm0Var) {
            this.f5103a = mm0Var.f5099a;
            this.f5104b = mm0Var.f5101c;
            this.f5105c = mm0Var.f5102d;
            this.f5106d = mm0Var.f5100b;
        }

        public C1561a(boolean z) {
            this.f5103a = z;
        }

        /* renamed from: a */
        public mm0 m6470a() {
            return new mm0(this);
        }

        /* renamed from: b */
        public C1561a m6471b(String... strArr) {
            if (!this.f5103a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.f5104b = (String[]) strArr.clone();
            return this;
        }

        /* renamed from: c */
        public C1561a m6472c(km0... km0VarArr) {
            if (!this.f5103a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] strArr = new String[km0VarArr.length];
            for (int i = 0; i < km0VarArr.length; i++) {
                strArr[i] = km0VarArr[i].f4617a;
            }
            m6471b(strArr);
            return this;
        }

        /* renamed from: d */
        public C1561a m6473d(boolean z) {
            if (!this.f5103a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.f5106d = z;
            return this;
        }

        /* renamed from: e */
        public C1561a m6474e(String... strArr) {
            if (!this.f5103a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (strArr.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.f5105c = (String[]) strArr.clone();
            return this;
        }

        /* renamed from: f */
        public C1561a m6475f(cn0... cn0VarArr) {
            if (!this.f5103a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] strArr = new String[cn0VarArr.length];
            for (int i = 0; i < cn0VarArr.length; i++) {
                strArr[i] = cn0VarArr[i].f2008O;
            }
            m6474e(strArr);
            return this;
        }
    }

    static {
        km0 km0Var = km0.f4612q;
        km0 km0Var2 = km0.f4613r;
        km0 km0Var3 = km0.f4614s;
        km0 km0Var4 = km0.f4615t;
        km0 km0Var5 = km0.f4616u;
        km0 km0Var6 = km0.f4606k;
        km0 km0Var7 = km0.f4608m;
        km0 km0Var8 = km0.f4607l;
        km0 km0Var9 = km0.f4609n;
        km0 km0Var10 = km0.f4611p;
        km0 km0Var11 = km0.f4610o;
        km0[] km0VarArr = {km0Var, km0Var2, km0Var3, km0Var4, km0Var5, km0Var6, km0Var7, km0Var8, km0Var9, km0Var10, km0Var11};
        f5095e = km0VarArr;
        km0[] km0VarArr2 = {km0Var, km0Var2, km0Var3, km0Var4, km0Var5, km0Var6, km0Var7, km0Var8, km0Var9, km0Var10, km0Var11, km0.f4604i, km0.f4605j, km0.f4602g, km0.f4603h, km0.f4600e, km0.f4601f, km0.f4599d};
        f5096f = km0VarArr2;
        C1561a c1561a = new C1561a(true);
        c1561a.m6472c(km0VarArr);
        cn0 cn0Var = cn0.TLS_1_3;
        cn0 cn0Var2 = cn0.TLS_1_2;
        c1561a.m6475f(cn0Var, cn0Var2);
        c1561a.m6473d(true);
        c1561a.m6470a();
        C1561a c1561a2 = new C1561a(true);
        c1561a2.m6472c(km0VarArr2);
        cn0 cn0Var3 = cn0.TLS_1_0;
        c1561a2.m6475f(cn0Var, cn0Var2, cn0.TLS_1_1, cn0Var3);
        c1561a2.m6473d(true);
        f5097g = c1561a2.m6470a();
        C1561a c1561a3 = new C1561a(true);
        c1561a3.m6472c(km0VarArr2);
        c1561a3.m6475f(cn0Var3);
        c1561a3.m6473d(true);
        c1561a3.m6470a();
        f5098h = new C1561a(false).m6470a();
    }

    public mm0(C1561a c1561a) {
        this.f5099a = c1561a.f5103a;
        this.f5101c = c1561a.f5104b;
        this.f5102d = c1561a.f5105c;
        this.f5100b = c1561a.f5106d;
    }

    /* renamed from: a */
    public void m6463a(SSLSocket sSLSocket, boolean z) {
        mm0 m6467e = m6467e(sSLSocket, z);
        String[] strArr = m6467e.f5102d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = m6467e.f5101c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    @Nullable
    /* renamed from: b */
    public List<km0> m6464b() {
        String[] strArr = this.f5101c;
        if (strArr != null) {
            return km0.m5950b(strArr);
        }
        return null;
    }

    /* renamed from: c */
    public boolean m6465c(SSLSocket sSLSocket) {
        if (!this.f5099a) {
            return false;
        }
        String[] strArr = this.f5102d;
        if (strArr != null && !fn0.m3811B(fn0.f2736o, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f5101c;
        return strArr2 == null || fn0.m3811B(km0.f4597b, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    /* renamed from: d */
    public boolean m6466d() {
        return this.f5099a;
    }

    /* renamed from: e */
    public final mm0 m6467e(SSLSocket sSLSocket, boolean z) {
        String[] m3845z = this.f5101c != null ? fn0.m3845z(km0.f4597b, sSLSocket.getEnabledCipherSuites(), this.f5101c) : sSLSocket.getEnabledCipherSuites();
        String[] m3845z2 = this.f5102d != null ? fn0.m3845z(fn0.f2736o, sSLSocket.getEnabledProtocols(), this.f5102d) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int m3842w = fn0.m3842w(km0.f4597b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && m3842w != -1) {
            m3845z = fn0.m3828i(m3845z, supportedCipherSuites[m3842w]);
        }
        C1561a c1561a = new C1561a(this);
        c1561a.m6471b(m3845z);
        c1561a.m6474e(m3845z2);
        return c1561a.m6470a();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof mm0)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        mm0 mm0Var = (mm0) obj;
        boolean z = this.f5099a;
        if (z != mm0Var.f5099a) {
            return false;
        }
        return !z || (Arrays.equals(this.f5101c, mm0Var.f5101c) && Arrays.equals(this.f5102d, mm0Var.f5102d) && this.f5100b == mm0Var.f5100b);
    }

    /* renamed from: f */
    public boolean m6468f() {
        return this.f5100b;
    }

    @Nullable
    /* renamed from: g */
    public List<cn0> m6469g() {
        String[] strArr = this.f5102d;
        if (strArr != null) {
            return cn0.m2888h(strArr);
        }
        return null;
    }

    public int hashCode() {
        if (this.f5099a) {
            return ((((527 + Arrays.hashCode(this.f5101c)) * 31) + Arrays.hashCode(this.f5102d)) * 31) + (!this.f5100b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f5099a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + (this.f5101c != null ? m6464b().toString() : "[all enabled]") + ", tlsVersions=" + (this.f5102d != null ? m6469g().toString() : "[all enabled]") + ", supportsTlsExtensions=" + this.f5100b + ")";
    }
}
