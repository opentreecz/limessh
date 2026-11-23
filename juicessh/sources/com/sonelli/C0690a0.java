package com.sonelli;

import com.google.android.datatransport.Transformer;
import com.sonelli.AbstractC1088h0;
import java.util.Objects;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.a0 */
/* loaded from: classes.dex */
public final class C0690a0 extends AbstractC1088h0 {

    /* renamed from: a */
    public final AbstractC1138i0 f1291a;

    /* renamed from: b */
    public final String f1292b;

    /* renamed from: c */
    public final AbstractC0802c<?> f1293c;

    /* renamed from: d */
    public final Transformer<?, byte[]> f1294d;

    /* renamed from: e */
    public final C0746b f1295e;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* renamed from: com.sonelli.a0$b */
    /* loaded from: classes.dex */
    public static final class b extends AbstractC1088h0.a {

        /* renamed from: a */
        public AbstractC1138i0 f1296a;

        /* renamed from: b */
        public String f1297b;

        /* renamed from: c */
        public AbstractC0802c<?> f1298c;

        /* renamed from: d */
        public Transformer<?, byte[]> f1299d;

        /* renamed from: e */
        public C0746b f1300e;

        @Override // com.sonelli.AbstractC1088h0.a
        /* renamed from: a */
        public AbstractC1088h0 mo1936a() {
            String str = "";
            if (this.f1296a == null) {
                str = " transportContext";
            }
            if (this.f1297b == null) {
                str = str + " transportName";
            }
            if (this.f1298c == null) {
                str = str + " event";
            }
            if (this.f1299d == null) {
                str = str + " transformer";
            }
            if (this.f1300e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new C0690a0(this.f1296a, this.f1297b, this.f1298c, this.f1299d, this.f1300e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.sonelli.AbstractC1088h0.a
        /* renamed from: b */
        public AbstractC1088h0.a mo1937b(C0746b c0746b) {
            Objects.requireNonNull(c0746b, "Null encoding");
            this.f1300e = c0746b;
            return this;
        }

        @Override // com.sonelli.AbstractC1088h0.a
        /* renamed from: c */
        public AbstractC1088h0.a mo1938c(AbstractC0802c<?> abstractC0802c) {
            Objects.requireNonNull(abstractC0802c, "Null event");
            this.f1298c = abstractC0802c;
            return this;
        }

        @Override // com.sonelli.AbstractC1088h0.a
        /* renamed from: d */
        public AbstractC1088h0.a mo1939d(Transformer<?, byte[]> transformer) {
            Objects.requireNonNull(transformer, "Null transformer");
            this.f1299d = transformer;
            return this;
        }

        @Override // com.sonelli.AbstractC1088h0.a
        /* renamed from: e */
        public AbstractC1088h0.a mo1940e(AbstractC1138i0 abstractC1138i0) {
            Objects.requireNonNull(abstractC1138i0, "Null transportContext");
            this.f1296a = abstractC1138i0;
            return this;
        }

        @Override // com.sonelli.AbstractC1088h0.a
        /* renamed from: f */
        public AbstractC1088h0.a mo1941f(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.f1297b = str;
            return this;
        }
    }

    public C0690a0(AbstractC1138i0 abstractC1138i0, String str, AbstractC0802c<?> abstractC0802c, Transformer<?, byte[]> transformer, C0746b c0746b) {
        this.f1291a = abstractC1138i0;
        this.f1292b = str;
        this.f1293c = abstractC0802c;
        this.f1294d = transformer;
        this.f1295e = c0746b;
    }

    @Override // com.sonelli.AbstractC1088h0
    /* renamed from: b */
    public C0746b mo1931b() {
        return this.f1295e;
    }

    @Override // com.sonelli.AbstractC1088h0
    /* renamed from: c */
    public AbstractC0802c<?> mo1932c() {
        return this.f1293c;
    }

    @Override // com.sonelli.AbstractC1088h0
    /* renamed from: e */
    public Transformer<?, byte[]> mo1933e() {
        return this.f1294d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1088h0)) {
            return false;
        }
        AbstractC1088h0 abstractC1088h0 = (AbstractC1088h0) obj;
        return this.f1291a.equals(abstractC1088h0.mo1934f()) && this.f1292b.equals(abstractC1088h0.mo1935g()) && this.f1293c.equals(abstractC1088h0.mo1932c()) && this.f1294d.equals(abstractC1088h0.mo1933e()) && this.f1295e.equals(abstractC1088h0.mo1931b());
    }

    @Override // com.sonelli.AbstractC1088h0
    /* renamed from: f */
    public AbstractC1138i0 mo1934f() {
        return this.f1291a;
    }

    @Override // com.sonelli.AbstractC1088h0
    /* renamed from: g */
    public String mo1935g() {
        return this.f1292b;
    }

    public int hashCode() {
        return ((((((((this.f1291a.hashCode() ^ 1000003) * 1000003) ^ this.f1292b.hashCode()) * 1000003) ^ this.f1293c.hashCode()) * 1000003) ^ this.f1294d.hashCode()) * 1000003) ^ this.f1295e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f1291a + ", transportName=" + this.f1292b + ", event=" + this.f1293c + ", transformer=" + this.f1294d + ", encoding=" + this.f1295e + "}";
    }
}
