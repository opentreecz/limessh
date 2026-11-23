package com.sonelli;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.sonelli.oa0;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class ca0 extends oa0.AbstractC1645d.d {

    /* renamed from: a */
    public final long f1896a;

    /* renamed from: b */
    public final String f1897b;

    /* renamed from: c */
    public final oa0.AbstractC1645d.d.a f1898c;

    /* renamed from: d */
    public final oa0.AbstractC1645d.d.c f1899d;

    /* renamed from: e */
    public final oa0.AbstractC1645d.d.AbstractC2512d f1900e;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.ca0$b */
    /* loaded from: classes.dex */
    public static final class C0815b extends oa0.AbstractC1645d.d.b {

        /* renamed from: a */
        public Long f1901a;

        /* renamed from: b */
        public String f1902b;

        /* renamed from: c */
        public oa0.AbstractC1645d.d.a f1903c;

        /* renamed from: d */
        public oa0.AbstractC1645d.d.c f1904d;

        /* renamed from: e */
        public oa0.AbstractC1645d.d.AbstractC2512d f1905e;

        public C0815b() {
        }

        public C0815b(oa0.AbstractC1645d.d dVar) {
            this.f1901a = Long.valueOf(dVar.mo2738e());
            this.f1902b = dVar.mo2739f();
            this.f1903c = dVar.mo2735b();
            this.f1904d = dVar.mo2736c();
            this.f1905e = dVar.mo2737d();
        }

        @Override // com.sonelli.oa0.AbstractC1645d.d.b
        /* renamed from: a */
        public oa0.AbstractC1645d.d mo2741a() {
            String str = "";
            if (this.f1901a == null) {
                str = " timestamp";
            }
            if (this.f1902b == null) {
                str = str + " type";
            }
            if (this.f1903c == null) {
                str = str + " app";
            }
            if (this.f1904d == null) {
                str = str + " device";
            }
            if (str.isEmpty()) {
                return new ca0(this.f1901a.longValue(), this.f1902b, this.f1903c, this.f1904d, this.f1905e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.sonelli.oa0.AbstractC1645d.d.b
        /* renamed from: b */
        public oa0.AbstractC1645d.d.b mo2742b(oa0.AbstractC1645d.d.a aVar) {
            Objects.requireNonNull(aVar, "Null app");
            this.f1903c = aVar;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.d.b
        /* renamed from: c */
        public oa0.AbstractC1645d.d.b mo2743c(oa0.AbstractC1645d.d.c cVar) {
            Objects.requireNonNull(cVar, "Null device");
            this.f1904d = cVar;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.d.b
        /* renamed from: d */
        public oa0.AbstractC1645d.d.b mo2744d(oa0.AbstractC1645d.d.AbstractC2512d abstractC2512d) {
            this.f1905e = abstractC2512d;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.d.b
        /* renamed from: e */
        public oa0.AbstractC1645d.d.b mo2745e(long j) {
            this.f1901a = Long.valueOf(j);
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.d.b
        /* renamed from: f */
        public oa0.AbstractC1645d.d.b mo2746f(String str) {
            Objects.requireNonNull(str, "Null type");
            this.f1902b = str;
            return this;
        }
    }

    public ca0(long j, String str, oa0.AbstractC1645d.d.a aVar, oa0.AbstractC1645d.d.c cVar, @Nullable oa0.AbstractC1645d.d.AbstractC2512d abstractC2512d) {
        this.f1896a = j;
        this.f1897b = str;
        this.f1898c = aVar;
        this.f1899d = cVar;
        this.f1900e = abstractC2512d;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.d
    @NonNull
    /* renamed from: b */
    public oa0.AbstractC1645d.d.a mo2735b() {
        return this.f1898c;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.d
    @NonNull
    /* renamed from: c */
    public oa0.AbstractC1645d.d.c mo2736c() {
        return this.f1899d;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.d
    @Nullable
    /* renamed from: d */
    public oa0.AbstractC1645d.d.AbstractC2512d mo2737d() {
        return this.f1900e;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.d
    /* renamed from: e */
    public long mo2738e() {
        return this.f1896a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oa0.AbstractC1645d.d)) {
            return false;
        }
        oa0.AbstractC1645d.d dVar = (oa0.AbstractC1645d.d) obj;
        if (this.f1896a == dVar.mo2738e() && this.f1897b.equals(dVar.mo2739f()) && this.f1898c.equals(dVar.mo2735b()) && this.f1899d.equals(dVar.mo2736c())) {
            oa0.AbstractC1645d.d.AbstractC2512d abstractC2512d = this.f1900e;
            if (abstractC2512d == null) {
                if (dVar.mo2737d() == null) {
                    return true;
                }
            } else if (abstractC2512d.equals(dVar.mo2737d())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.d
    @NonNull
    /* renamed from: f */
    public String mo2739f() {
        return this.f1897b;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.d
    /* renamed from: g */
    public oa0.AbstractC1645d.d.b mo2740g() {
        return new C0815b(this);
    }

    public int hashCode() {
        long j = this.f1896a;
        int hashCode = (((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f1897b.hashCode()) * 1000003) ^ this.f1898c.hashCode()) * 1000003) ^ this.f1899d.hashCode()) * 1000003;
        oa0.AbstractC1645d.d.AbstractC2512d abstractC2512d = this.f1900e;
        return hashCode ^ (abstractC2512d == null ? 0 : abstractC2512d.hashCode());
    }

    public String toString() {
        return "Event{timestamp=" + this.f1896a + ", type=" + this.f1897b + ", app=" + this.f1898c + ", device=" + this.f1899d + ", log=" + this.f1900e + "}";
    }
}
