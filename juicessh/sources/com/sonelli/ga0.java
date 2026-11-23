package com.sonelli;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.sonelli.oa0;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class ga0 extends oa0.AbstractC1645d.d.a.b.c {

    /* renamed from: a */
    public final String f2845a;

    /* renamed from: b */
    public final String f2846b;

    /* renamed from: c */
    public final pa0<oa0.AbstractC1645d.d.a.b.e.AbstractC2510b> f2847c;

    /* renamed from: d */
    public final oa0.AbstractC1645d.d.a.b.c f2848d;

    /* renamed from: e */
    public final int f2849e;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.ga0$b */
    /* loaded from: classes.dex */
    public static final class C1034b extends oa0.AbstractC1645d.d.a.b.c.AbstractC2506a {

        /* renamed from: a */
        public String f2850a;

        /* renamed from: b */
        public String f2851b;

        /* renamed from: c */
        public pa0<oa0.AbstractC1645d.d.a.b.e.AbstractC2510b> f2852c;

        /* renamed from: d */
        public oa0.AbstractC1645d.d.a.b.c f2853d;

        /* renamed from: e */
        public Integer f2854e;

        @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.c.AbstractC2506a
        /* renamed from: a */
        public oa0.AbstractC1645d.d.a.b.c mo4104a() {
            String str = "";
            if (this.f2850a == null) {
                str = " type";
            }
            if (this.f2852c == null) {
                str = str + " frames";
            }
            if (this.f2854e == null) {
                str = str + " overflowCount";
            }
            if (str.isEmpty()) {
                return new ga0(this.f2850a, this.f2851b, this.f2852c, this.f2853d, this.f2854e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.c.AbstractC2506a
        /* renamed from: b */
        public oa0.AbstractC1645d.d.a.b.c.AbstractC2506a mo4105b(oa0.AbstractC1645d.d.a.b.c cVar) {
            this.f2853d = cVar;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.c.AbstractC2506a
        /* renamed from: c */
        public oa0.AbstractC1645d.d.a.b.c.AbstractC2506a mo4106c(pa0<oa0.AbstractC1645d.d.a.b.e.AbstractC2510b> pa0Var) {
            Objects.requireNonNull(pa0Var, "Null frames");
            this.f2852c = pa0Var;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.c.AbstractC2506a
        /* renamed from: d */
        public oa0.AbstractC1645d.d.a.b.c.AbstractC2506a mo4107d(int i) {
            this.f2854e = Integer.valueOf(i);
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.c.AbstractC2506a
        /* renamed from: e */
        public oa0.AbstractC1645d.d.a.b.c.AbstractC2506a mo4108e(String str) {
            this.f2851b = str;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.c.AbstractC2506a
        /* renamed from: f */
        public oa0.AbstractC1645d.d.a.b.c.AbstractC2506a mo4109f(String str) {
            Objects.requireNonNull(str, "Null type");
            this.f2850a = str;
            return this;
        }
    }

    public ga0(String str, @Nullable String str2, pa0<oa0.AbstractC1645d.d.a.b.e.AbstractC2510b> pa0Var, @Nullable oa0.AbstractC1645d.d.a.b.c cVar, int i) {
        this.f2845a = str;
        this.f2846b = str2;
        this.f2847c = pa0Var;
        this.f2848d = cVar;
        this.f2849e = i;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.c
    @Nullable
    /* renamed from: b */
    public oa0.AbstractC1645d.d.a.b.c mo4099b() {
        return this.f2848d;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.c
    @NonNull
    /* renamed from: c */
    public pa0<oa0.AbstractC1645d.d.a.b.e.AbstractC2510b> mo4100c() {
        return this.f2847c;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.c
    /* renamed from: d */
    public int mo4101d() {
        return this.f2849e;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.c
    @Nullable
    /* renamed from: e */
    public String mo4102e() {
        return this.f2846b;
    }

    public boolean equals(Object obj) {
        String str;
        oa0.AbstractC1645d.d.a.b.c cVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oa0.AbstractC1645d.d.a.b.c)) {
            return false;
        }
        oa0.AbstractC1645d.d.a.b.c cVar2 = (oa0.AbstractC1645d.d.a.b.c) obj;
        return this.f2845a.equals(cVar2.mo4103f()) && ((str = this.f2846b) != null ? str.equals(cVar2.mo4102e()) : cVar2.mo4102e() == null) && this.f2847c.equals(cVar2.mo4100c()) && ((cVar = this.f2848d) != null ? cVar.equals(cVar2.mo4099b()) : cVar2.mo4099b() == null) && this.f2849e == cVar2.mo4101d();
    }

    @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.c
    @NonNull
    /* renamed from: f */
    public String mo4103f() {
        return this.f2845a;
    }

    public int hashCode() {
        int hashCode = (this.f2845a.hashCode() ^ 1000003) * 1000003;
        String str = this.f2846b;
        int hashCode2 = (((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f2847c.hashCode()) * 1000003;
        oa0.AbstractC1645d.d.a.b.c cVar = this.f2848d;
        return ((hashCode2 ^ (cVar != null ? cVar.hashCode() : 0)) * 1000003) ^ this.f2849e;
    }

    public String toString() {
        return "Exception{type=" + this.f2845a + ", reason=" + this.f2846b + ", frames=" + this.f2847c + ", causedBy=" + this.f2848d + ", overflowCount=" + this.f2849e + "}";
    }
}
