package cz.opentree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.annotation.Nullable;
import okio.BufferedSink;

/* compiled from: MultipartBody.java */
/* loaded from: classes.dex */
public final class tm0 extends ym0 {

    /* renamed from: e */
    public static final sm0 f6793e = sm0.m8469c("multipart/mixed");

    /* renamed from: f */
    public static final sm0 f6794f;

    /* renamed from: g */
    public static final byte[] f6795g;

    /* renamed from: h */
    public static final byte[] f6796h;

    /* renamed from: i */
    public static final byte[] f6797i;

    /* renamed from: a */
    public final ap0 f6798a;

    /* renamed from: b */
    public final sm0 f6799b;

    /* renamed from: c */
    public final List<C1941b> f6800c;

    /* renamed from: d */
    public long f6801d = -1;

    /* compiled from: MultipartBody.java */
    /* renamed from: cz.opentree.tm0$a */
    /* loaded from: classes.dex */
    public static final class C1940a {

        /* renamed from: a */
        public final ap0 f6802a;

        /* renamed from: b */
        public sm0 f6803b;

        /* renamed from: c */
        public final List<C1941b> f6804c;

        public C1940a() {
            this(UUID.randomUUID().toString());
        }

        public C1940a(String str) {
            this.f6803b = tm0.f6793e;
            this.f6804c = new ArrayList();
            this.f6802a = ap0.m2233o(str);
        }

        /* renamed from: a */
        public C1940a m8774a(String str, String str2) {
            m8776c(C1941b.m8780b(str, str2));
            return this;
        }

        /* renamed from: b */
        public C1940a m8775b(String str, @Nullable String str2, ym0 ym0Var) {
            m8776c(C1941b.m8781c(str, str2, ym0Var));
            return this;
        }

        /* renamed from: c */
        public C1940a m8776c(C1941b c1941b) {
            Objects.requireNonNull(c1941b, "part == null");
            this.f6804c.add(c1941b);
            return this;
        }

        /* renamed from: d */
        public tm0 m8777d() {
            if (this.f6804c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new tm0(this.f6802a, this.f6803b, this.f6804c);
        }

        /* renamed from: e */
        public C1940a m8778e(sm0 sm0Var) {
            Objects.requireNonNull(sm0Var, "type == null");
            if (sm0Var.m8473e().equals("multipart")) {
                this.f6803b = sm0Var;
                return this;
            }
            throw new IllegalArgumentException("multipart != " + sm0Var);
        }
    }

    /* compiled from: MultipartBody.java */
    /* renamed from: cz.opentree.tm0$b */
    /* loaded from: classes.dex */
    public static final class C1941b {

        /* renamed from: a */
        @Nullable
        public final qm0 f6805a;

        /* renamed from: b */
        public final ym0 f6806b;

        public C1941b(@Nullable qm0 qm0Var, ym0 ym0Var) {
            this.f6805a = qm0Var;
            this.f6806b = ym0Var;
        }

        /* renamed from: a */
        public static C1941b m8779a(@Nullable qm0 qm0Var, ym0 ym0Var) {
            Objects.requireNonNull(ym0Var, "body == null");
            if (qm0Var != null && qm0Var.m7749c("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (qm0Var == null || qm0Var.m7749c("Content-Length") == null) {
                return new C1941b(qm0Var, ym0Var);
            }
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }

        /* renamed from: b */
        public static C1941b m8780b(String str, String str2) {
            return m8781c(str, null, ym0.m10191d(null, str2));
        }

        /* renamed from: c */
        public static C1941b m8781c(String str, @Nullable String str2, ym0 ym0Var) {
            Objects.requireNonNull(str, "name == null");
            StringBuilder sb = new StringBuilder("form-data; name=");
            tm0.m8769h(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                tm0.m8769h(sb, str2);
            }
            return m8779a(qm0.m7748g("Content-Disposition", sb.toString()), ym0Var);
        }
    }

    static {
        sm0.m8469c("multipart/alternative");
        sm0.m8469c("multipart/digest");
        sm0.m8469c("multipart/parallel");
        f6794f = sm0.m8469c("multipart/form-data");
        f6795g = new byte[]{58, 32};
        f6796h = new byte[]{13, 10};
        f6797i = new byte[]{45, 45};
    }

    public tm0(ap0 ap0Var, sm0 sm0Var, List<C1941b> list) {
        this.f6798a = ap0Var;
        this.f6799b = sm0.m8469c(sm0Var + "; boundary=" + ap0Var.mo2236B());
        this.f6800c = fn0.m3839t(list);
    }

    /* renamed from: h */
    public static StringBuilder m8769h(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\n') {
                sb.append("%0A");
            } else if (charAt == '\r') {
                sb.append("%0D");
            } else if (charAt != '\"') {
                sb.append(charAt);
            } else {
                sb.append("%22");
            }
        }
        sb.append('\"');
        return sb;
    }

    @Override // cz.opentree.ym0
    /* renamed from: a */
    public long mo8770a() throws IOException {
        long j = this.f6801d;
        if (j != -1) {
            return j;
        }
        long m8773i = m8773i(null, true);
        this.f6801d = m8773i;
        return m8773i;
    }

    @Override // cz.opentree.ym0
    /* renamed from: b */
    public sm0 mo8771b() {
        return this.f6799b;
    }

    @Override // cz.opentree.ym0
    /* renamed from: g */
    public void mo8772g(BufferedSink bufferedSink) throws IOException {
        m8773i(bufferedSink, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: i */
    public final long m8773i(@Nullable BufferedSink bufferedSink, boolean z) throws IOException {
        zo0 zo0Var;
        if (z) {
            bufferedSink = new zo0();
            zo0Var = bufferedSink;
        } else {
            zo0Var = 0;
        }
        int size = this.f6800c.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            C1941b c1941b = this.f6800c.get(i);
            qm0 qm0Var = c1941b.f6805a;
            ym0 ym0Var = c1941b.f6806b;
            bufferedSink.mo4615N(f6797i);
            bufferedSink.mo4616O(this.f6798a);
            bufferedSink.mo4615N(f6796h);
            if (qm0Var != null) {
                int m7752h = qm0Var.m7752h();
                for (int i2 = 0; i2 < m7752h; i2++) {
                    bufferedSink.mo4611A(qm0Var.m7750e(i2)).mo4615N(f6795g).mo4611A(qm0Var.m7753i(i2)).mo4615N(f6796h);
                }
            }
            sm0 mo8771b = ym0Var.mo8771b();
            if (mo8771b != null) {
                bufferedSink.mo4611A("Content-Type: ").mo4611A(mo8771b.toString()).mo4615N(f6796h);
            }
            long mo8770a = ym0Var.mo8770a();
            if (mo8770a != -1) {
                bufferedSink.mo4611A("Content-Length: ").mo4617V(mo8770a).mo4615N(f6796h);
            } else if (z) {
                zo0Var.m10550b();
                return -1L;
            }
            byte[] bArr = f6796h;
            bufferedSink.mo4615N(bArr);
            if (z) {
                j += mo8770a;
            } else {
                ym0Var.mo8772g(bufferedSink);
            }
            bufferedSink.mo4615N(bArr);
        }
        byte[] bArr2 = f6797i;
        bufferedSink.mo4615N(bArr2);
        bufferedSink.mo4616O(this.f6798a);
        bufferedSink.mo4615N(bArr2);
        bufferedSink.mo4615N(f6796h);
        if (!z) {
            return j;
        }
        long m10557f0 = j + zo0Var.m10557f0();
        zo0Var.m10550b();
        return m10557f0;
    }
}
