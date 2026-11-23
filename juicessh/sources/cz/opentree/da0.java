package cz.opentree;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cz.opentree.oa0;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class da0 extends oa0.AbstractC1645d.d.a {

    /* renamed from: a */
    public final oa0.AbstractC1645d.d.a.b f2145a;

    /* renamed from: b */
    public final pa0<oa0.AbstractC1643b> f2146b;

    /* renamed from: c */
    public final Boolean f2147c;

    /* renamed from: d */
    public final int f2148d;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.da0$b */
    /* loaded from: classes.dex */
    public static final class C0867b extends oa0.AbstractC1645d.d.a.AbstractC2502a {

        /* renamed from: a */
        public oa0.AbstractC1645d.d.a.b f2149a;

        /* renamed from: b */
        public pa0<oa0.AbstractC1643b> f2150b;

        /* renamed from: c */
        public Boolean f2151c;

        /* renamed from: d */
        public Integer f2152d;

        public C0867b() {
        }

        public C0867b(oa0.AbstractC1645d.d.a aVar) {
            this.f2149a = aVar.mo3173d();
            this.f2150b = aVar.mo3172c();
            this.f2151c = aVar.mo3171b();
            this.f2152d = Integer.valueOf(aVar.mo3174e());
        }

        @Override // cz.opentree.oa0.AbstractC1645d.d.a.AbstractC2502a
        /* renamed from: a */
        public oa0.AbstractC1645d.d.a mo3176a() {
            String str = "";
            if (this.f2149a == null) {
                str = " execution";
            }
            if (this.f2152d == null) {
                str = str + " uiOrientation";
            }
            if (str.isEmpty()) {
                return new da0(this.f2149a, this.f2150b, this.f2151c, this.f2152d.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // cz.opentree.oa0.AbstractC1645d.d.a.AbstractC2502a
        /* renamed from: b */
        public oa0.AbstractC1645d.d.a.AbstractC2502a mo3177b(@Nullable Boolean bool) {
            this.f2151c = bool;
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1645d.d.a.AbstractC2502a
        /* renamed from: c */
        public oa0.AbstractC1645d.d.a.AbstractC2502a mo3178c(pa0<oa0.AbstractC1643b> pa0Var) {
            this.f2150b = pa0Var;
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1645d.d.a.AbstractC2502a
        /* renamed from: d */
        public oa0.AbstractC1645d.d.a.AbstractC2502a mo3179d(oa0.AbstractC1645d.d.a.b bVar) {
            Objects.requireNonNull(bVar, "Null execution");
            this.f2149a = bVar;
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1645d.d.a.AbstractC2502a
        /* renamed from: e */
        public oa0.AbstractC1645d.d.a.AbstractC2502a mo3180e(int i) {
            this.f2152d = Integer.valueOf(i);
            return this;
        }
    }

    public da0(oa0.AbstractC1645d.d.a.b bVar, @Nullable pa0<oa0.AbstractC1643b> pa0Var, @Nullable Boolean bool, int i) {
        this.f2145a = bVar;
        this.f2146b = pa0Var;
        this.f2147c = bool;
        this.f2148d = i;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.d.a
    @Nullable
    /* renamed from: b */
    public Boolean mo3171b() {
        return this.f2147c;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.d.a
    @Nullable
    /* renamed from: c */
    public pa0<oa0.AbstractC1643b> mo3172c() {
        return this.f2146b;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.d.a
    @NonNull
    /* renamed from: d */
    public oa0.AbstractC1645d.d.a.b mo3173d() {
        return this.f2145a;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.d.a
    /* renamed from: e */
    public int mo3174e() {
        return this.f2148d;
    }

    public boolean equals(Object obj) {
        pa0<oa0.AbstractC1643b> pa0Var;
        Boolean bool;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oa0.AbstractC1645d.d.a)) {
            return false;
        }
        oa0.AbstractC1645d.d.a aVar = (oa0.AbstractC1645d.d.a) obj;
        return this.f2145a.equals(aVar.mo3173d()) && ((pa0Var = this.f2146b) != null ? pa0Var.equals(aVar.mo3172c()) : aVar.mo3172c() == null) && ((bool = this.f2147c) != null ? bool.equals(aVar.mo3171b()) : aVar.mo3171b() == null) && this.f2148d == aVar.mo3174e();
    }

    @Override // cz.opentree.oa0.AbstractC1645d.d.a
    /* renamed from: f */
    public oa0.AbstractC1645d.d.a.AbstractC2502a mo3175f() {
        return new C0867b(this);
    }

    public int hashCode() {
        int hashCode = (this.f2145a.hashCode() ^ 1000003) * 1000003;
        pa0<oa0.AbstractC1643b> pa0Var = this.f2146b;
        int hashCode2 = (hashCode ^ (pa0Var == null ? 0 : pa0Var.hashCode())) * 1000003;
        Boolean bool = this.f2147c;
        return ((hashCode2 ^ (bool != null ? bool.hashCode() : 0)) * 1000003) ^ this.f2148d;
    }

    public String toString() {
        return "Application{execution=" + this.f2145a + ", customAttributes=" + this.f2146b + ", background=" + this.f2147c + ", uiOrientation=" + this.f2148d + "}";
    }
}
