package com.sonelli;

import androidx.annotation.NonNull;
import com.sonelli.oa0;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class ia0 extends oa0.AbstractC1645d.d.a.b.e {

    /* renamed from: a */
    public final String f3274a;

    /* renamed from: b */
    public final int f3275b;

    /* renamed from: c */
    public final pa0<oa0.AbstractC1645d.d.a.b.e.AbstractC2510b> f3276c;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.ia0$b */
    /* loaded from: classes.dex */
    public static final class C1153b extends oa0.AbstractC1645d.d.a.b.e.AbstractC2509a {

        /* renamed from: a */
        public String f3277a;

        /* renamed from: b */
        public Integer f3278b;

        /* renamed from: c */
        public pa0<oa0.AbstractC1645d.d.a.b.e.AbstractC2510b> f3279c;

        @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.e.AbstractC2509a
        /* renamed from: a */
        public oa0.AbstractC1645d.d.a.b.e mo4735a() {
            String str = "";
            if (this.f3277a == null) {
                str = " name";
            }
            if (this.f3278b == null) {
                str = str + " importance";
            }
            if (this.f3279c == null) {
                str = str + " frames";
            }
            if (str.isEmpty()) {
                return new ia0(this.f3277a, this.f3278b.intValue(), this.f3279c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.e.AbstractC2509a
        /* renamed from: b */
        public oa0.AbstractC1645d.d.a.b.e.AbstractC2509a mo4736b(pa0<oa0.AbstractC1645d.d.a.b.e.AbstractC2510b> pa0Var) {
            Objects.requireNonNull(pa0Var, "Null frames");
            this.f3279c = pa0Var;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.e.AbstractC2509a
        /* renamed from: c */
        public oa0.AbstractC1645d.d.a.b.e.AbstractC2509a mo4737c(int i) {
            this.f3278b = Integer.valueOf(i);
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.e.AbstractC2509a
        /* renamed from: d */
        public oa0.AbstractC1645d.d.a.b.e.AbstractC2509a mo4738d(String str) {
            Objects.requireNonNull(str, "Null name");
            this.f3277a = str;
            return this;
        }
    }

    public ia0(String str, int i, pa0<oa0.AbstractC1645d.d.a.b.e.AbstractC2510b> pa0Var) {
        this.f3274a = str;
        this.f3275b = i;
        this.f3276c = pa0Var;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.e
    @NonNull
    /* renamed from: b */
    public pa0<oa0.AbstractC1645d.d.a.b.e.AbstractC2510b> mo4732b() {
        return this.f3276c;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.e
    /* renamed from: c */
    public int mo4733c() {
        return this.f3275b;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.e
    @NonNull
    /* renamed from: d */
    public String mo4734d() {
        return this.f3274a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oa0.AbstractC1645d.d.a.b.e)) {
            return false;
        }
        oa0.AbstractC1645d.d.a.b.e eVar = (oa0.AbstractC1645d.d.a.b.e) obj;
        return this.f3274a.equals(eVar.mo4734d()) && this.f3275b == eVar.mo4733c() && this.f3276c.equals(eVar.mo4732b());
    }

    public int hashCode() {
        return ((((this.f3274a.hashCode() ^ 1000003) * 1000003) ^ this.f3275b) * 1000003) ^ this.f3276c.hashCode();
    }

    public String toString() {
        return "Thread{name=" + this.f3274a + ", importance=" + this.f3275b + ", frames=" + this.f3276c + "}";
    }
}
