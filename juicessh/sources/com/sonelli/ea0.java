package com.sonelli;

import androidx.annotation.NonNull;
import com.sonelli.oa0;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class ea0 extends oa0.AbstractC1645d.d.a.b {

    /* renamed from: a */
    public final pa0<oa0.AbstractC1645d.d.a.b.e> f2353a;

    /* renamed from: b */
    public final oa0.AbstractC1645d.d.a.b.c f2354b;

    /* renamed from: c */
    public final oa0.AbstractC1645d.d.a.b.AbstractC2507d f2355c;

    /* renamed from: d */
    public final pa0<oa0.AbstractC1645d.d.a.b.AbstractC2503a> f2356d;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.ea0$b */
    /* loaded from: classes.dex */
    public static final class C0919b extends oa0.AbstractC1645d.d.a.b.AbstractC2505b {

        /* renamed from: a */
        public pa0<oa0.AbstractC1645d.d.a.b.e> f2357a;

        /* renamed from: b */
        public oa0.AbstractC1645d.d.a.b.c f2358b;

        /* renamed from: c */
        public oa0.AbstractC1645d.d.a.b.AbstractC2507d f2359c;

        /* renamed from: d */
        public pa0<oa0.AbstractC1645d.d.a.b.AbstractC2503a> f2360d;

        @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.AbstractC2505b
        /* renamed from: a */
        public oa0.AbstractC1645d.d.a.b mo3465a() {
            String str = "";
            if (this.f2357a == null) {
                str = " threads";
            }
            if (this.f2358b == null) {
                str = str + " exception";
            }
            if (this.f2359c == null) {
                str = str + " signal";
            }
            if (this.f2360d == null) {
                str = str + " binaries";
            }
            if (str.isEmpty()) {
                return new ea0(this.f2357a, this.f2358b, this.f2359c, this.f2360d);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.AbstractC2505b
        /* renamed from: b */
        public oa0.AbstractC1645d.d.a.b.AbstractC2505b mo3466b(pa0<oa0.AbstractC1645d.d.a.b.AbstractC2503a> pa0Var) {
            Objects.requireNonNull(pa0Var, "Null binaries");
            this.f2360d = pa0Var;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.AbstractC2505b
        /* renamed from: c */
        public oa0.AbstractC1645d.d.a.b.AbstractC2505b mo3467c(oa0.AbstractC1645d.d.a.b.c cVar) {
            Objects.requireNonNull(cVar, "Null exception");
            this.f2358b = cVar;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.AbstractC2505b
        /* renamed from: d */
        public oa0.AbstractC1645d.d.a.b.AbstractC2505b mo3468d(oa0.AbstractC1645d.d.a.b.AbstractC2507d abstractC2507d) {
            Objects.requireNonNull(abstractC2507d, "Null signal");
            this.f2359c = abstractC2507d;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.AbstractC2505b
        /* renamed from: e */
        public oa0.AbstractC1645d.d.a.b.AbstractC2505b mo3469e(pa0<oa0.AbstractC1645d.d.a.b.e> pa0Var) {
            Objects.requireNonNull(pa0Var, "Null threads");
            this.f2357a = pa0Var;
            return this;
        }
    }

    public ea0(pa0<oa0.AbstractC1645d.d.a.b.e> pa0Var, oa0.AbstractC1645d.d.a.b.c cVar, oa0.AbstractC1645d.d.a.b.AbstractC2507d abstractC2507d, pa0<oa0.AbstractC1645d.d.a.b.AbstractC2503a> pa0Var2) {
        this.f2353a = pa0Var;
        this.f2354b = cVar;
        this.f2355c = abstractC2507d;
        this.f2356d = pa0Var2;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.d.a.b
    @NonNull
    /* renamed from: b */
    public pa0<oa0.AbstractC1645d.d.a.b.AbstractC2503a> mo3461b() {
        return this.f2356d;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.d.a.b
    @NonNull
    /* renamed from: c */
    public oa0.AbstractC1645d.d.a.b.c mo3462c() {
        return this.f2354b;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.d.a.b
    @NonNull
    /* renamed from: d */
    public oa0.AbstractC1645d.d.a.b.AbstractC2507d mo3463d() {
        return this.f2355c;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.d.a.b
    @NonNull
    /* renamed from: e */
    public pa0<oa0.AbstractC1645d.d.a.b.e> mo3464e() {
        return this.f2353a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oa0.AbstractC1645d.d.a.b)) {
            return false;
        }
        oa0.AbstractC1645d.d.a.b bVar = (oa0.AbstractC1645d.d.a.b) obj;
        return this.f2353a.equals(bVar.mo3464e()) && this.f2354b.equals(bVar.mo3462c()) && this.f2355c.equals(bVar.mo3463d()) && this.f2356d.equals(bVar.mo3461b());
    }

    public int hashCode() {
        return ((((((this.f2353a.hashCode() ^ 1000003) * 1000003) ^ this.f2354b.hashCode()) * 1000003) ^ this.f2355c.hashCode()) * 1000003) ^ this.f2356d.hashCode();
    }

    public String toString() {
        return "Execution{threads=" + this.f2353a + ", exception=" + this.f2354b + ", signal=" + this.f2355c + ", binaries=" + this.f2356d + "}";
    }
}
