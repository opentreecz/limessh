package com.sonelli;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.sonelli.oa0;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class y90 extends oa0.AbstractC1645d {

    /* renamed from: a */
    public final String f8168a;

    /* renamed from: b */
    public final String f8169b;

    /* renamed from: c */
    public final long f8170c;

    /* renamed from: d */
    public final Long f8171d;

    /* renamed from: e */
    public final boolean f8172e;

    /* renamed from: f */
    public final oa0.AbstractC1645d.a f8173f;

    /* renamed from: g */
    public final oa0.AbstractC1645d.f f8174g;

    /* renamed from: h */
    public final oa0.AbstractC1645d.e f8175h;

    /* renamed from: i */
    public final oa0.AbstractC1645d.c f8176i;

    /* renamed from: j */
    public final pa0<oa0.AbstractC1645d.d> f8177j;

    /* renamed from: k */
    public final int f8178k;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.y90$b */
    /* loaded from: classes.dex */
    public static final class C2336b extends oa0.AbstractC1645d.b {

        /* renamed from: a */
        public String f8179a;

        /* renamed from: b */
        public String f8180b;

        /* renamed from: c */
        public Long f8181c;

        /* renamed from: d */
        public Long f8182d;

        /* renamed from: e */
        public Boolean f8183e;

        /* renamed from: f */
        public oa0.AbstractC1645d.a f8184f;

        /* renamed from: g */
        public oa0.AbstractC1645d.f f8185g;

        /* renamed from: h */
        public oa0.AbstractC1645d.e f8186h;

        /* renamed from: i */
        public oa0.AbstractC1645d.c f8187i;

        /* renamed from: j */
        public pa0<oa0.AbstractC1645d.d> f8188j;

        /* renamed from: k */
        public Integer f8189k;

        public C2336b() {
        }

        public C2336b(oa0.AbstractC1645d abstractC1645d) {
            this.f8179a = abstractC1645d.mo6959f();
            this.f8180b = abstractC1645d.mo6961h();
            this.f8181c = Long.valueOf(abstractC1645d.mo6964k());
            this.f8182d = abstractC1645d.mo6957d();
            this.f8183e = Boolean.valueOf(abstractC1645d.mo6966m());
            this.f8184f = abstractC1645d.mo6955b();
            this.f8185g = abstractC1645d.mo6965l();
            this.f8186h = abstractC1645d.mo6963j();
            this.f8187i = abstractC1645d.mo6956c();
            this.f8188j = abstractC1645d.mo6958e();
            this.f8189k = Integer.valueOf(abstractC1645d.mo6960g());
        }

        @Override // com.sonelli.oa0.AbstractC1645d.b
        /* renamed from: a */
        public oa0.AbstractC1645d mo6981a() {
            String str = "";
            if (this.f8179a == null) {
                str = " generator";
            }
            if (this.f8180b == null) {
                str = str + " identifier";
            }
            if (this.f8181c == null) {
                str = str + " startedAt";
            }
            if (this.f8183e == null) {
                str = str + " crashed";
            }
            if (this.f8184f == null) {
                str = str + " app";
            }
            if (this.f8189k == null) {
                str = str + " generatorType";
            }
            if (str.isEmpty()) {
                return new y90(this.f8179a, this.f8180b, this.f8181c.longValue(), this.f8182d, this.f8183e.booleanValue(), this.f8184f, this.f8185g, this.f8186h, this.f8187i, this.f8188j, this.f8189k.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.sonelli.oa0.AbstractC1645d.b
        /* renamed from: b */
        public oa0.AbstractC1645d.b mo6982b(oa0.AbstractC1645d.a aVar) {
            Objects.requireNonNull(aVar, "Null app");
            this.f8184f = aVar;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.b
        /* renamed from: c */
        public oa0.AbstractC1645d.b mo6983c(boolean z) {
            this.f8183e = Boolean.valueOf(z);
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.b
        /* renamed from: d */
        public oa0.AbstractC1645d.b mo6984d(oa0.AbstractC1645d.c cVar) {
            this.f8187i = cVar;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.b
        /* renamed from: e */
        public oa0.AbstractC1645d.b mo6985e(Long l) {
            this.f8182d = l;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.b
        /* renamed from: f */
        public oa0.AbstractC1645d.b mo6986f(pa0<oa0.AbstractC1645d.d> pa0Var) {
            this.f8188j = pa0Var;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.b
        /* renamed from: g */
        public oa0.AbstractC1645d.b mo6987g(String str) {
            Objects.requireNonNull(str, "Null generator");
            this.f8179a = str;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.b
        /* renamed from: h */
        public oa0.AbstractC1645d.b mo6988h(int i) {
            this.f8189k = Integer.valueOf(i);
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.b
        /* renamed from: i */
        public oa0.AbstractC1645d.b mo6989i(String str) {
            Objects.requireNonNull(str, "Null identifier");
            this.f8180b = str;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.b
        /* renamed from: k */
        public oa0.AbstractC1645d.b mo6991k(oa0.AbstractC1645d.e eVar) {
            this.f8186h = eVar;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.b
        /* renamed from: l */
        public oa0.AbstractC1645d.b mo6992l(long j) {
            this.f8181c = Long.valueOf(j);
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.b
        /* renamed from: m */
        public oa0.AbstractC1645d.b mo6993m(oa0.AbstractC1645d.f fVar) {
            this.f8185g = fVar;
            return this;
        }
    }

    public y90(String str, String str2, long j, @Nullable Long l, boolean z, oa0.AbstractC1645d.a aVar, @Nullable oa0.AbstractC1645d.f fVar, @Nullable oa0.AbstractC1645d.e eVar, @Nullable oa0.AbstractC1645d.c cVar, @Nullable pa0<oa0.AbstractC1645d.d> pa0Var, int i) {
        this.f8168a = str;
        this.f8169b = str2;
        this.f8170c = j;
        this.f8171d = l;
        this.f8172e = z;
        this.f8173f = aVar;
        this.f8174g = fVar;
        this.f8175h = eVar;
        this.f8176i = cVar;
        this.f8177j = pa0Var;
        this.f8178k = i;
    }

    @Override // com.sonelli.oa0.AbstractC1645d
    @NonNull
    /* renamed from: b */
    public oa0.AbstractC1645d.a mo6955b() {
        return this.f8173f;
    }

    @Override // com.sonelli.oa0.AbstractC1645d
    @Nullable
    /* renamed from: c */
    public oa0.AbstractC1645d.c mo6956c() {
        return this.f8176i;
    }

    @Override // com.sonelli.oa0.AbstractC1645d
    @Nullable
    /* renamed from: d */
    public Long mo6957d() {
        return this.f8171d;
    }

    @Override // com.sonelli.oa0.AbstractC1645d
    @Nullable
    /* renamed from: e */
    public pa0<oa0.AbstractC1645d.d> mo6958e() {
        return this.f8177j;
    }

    public boolean equals(Object obj) {
        Long l;
        oa0.AbstractC1645d.f fVar;
        oa0.AbstractC1645d.e eVar;
        oa0.AbstractC1645d.c cVar;
        pa0<oa0.AbstractC1645d.d> pa0Var;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oa0.AbstractC1645d)) {
            return false;
        }
        oa0.AbstractC1645d abstractC1645d = (oa0.AbstractC1645d) obj;
        return this.f8168a.equals(abstractC1645d.mo6959f()) && this.f8169b.equals(abstractC1645d.mo6961h()) && this.f8170c == abstractC1645d.mo6964k() && ((l = this.f8171d) != null ? l.equals(abstractC1645d.mo6957d()) : abstractC1645d.mo6957d() == null) && this.f8172e == abstractC1645d.mo6966m() && this.f8173f.equals(abstractC1645d.mo6955b()) && ((fVar = this.f8174g) != null ? fVar.equals(abstractC1645d.mo6965l()) : abstractC1645d.mo6965l() == null) && ((eVar = this.f8175h) != null ? eVar.equals(abstractC1645d.mo6963j()) : abstractC1645d.mo6963j() == null) && ((cVar = this.f8176i) != null ? cVar.equals(abstractC1645d.mo6956c()) : abstractC1645d.mo6956c() == null) && ((pa0Var = this.f8177j) != null ? pa0Var.equals(abstractC1645d.mo6958e()) : abstractC1645d.mo6958e() == null) && this.f8178k == abstractC1645d.mo6960g();
    }

    @Override // com.sonelli.oa0.AbstractC1645d
    @NonNull
    /* renamed from: f */
    public String mo6959f() {
        return this.f8168a;
    }

    @Override // com.sonelli.oa0.AbstractC1645d
    /* renamed from: g */
    public int mo6960g() {
        return this.f8178k;
    }

    @Override // com.sonelli.oa0.AbstractC1645d
    @NonNull
    /* renamed from: h */
    public String mo6961h() {
        return this.f8169b;
    }

    public int hashCode() {
        int hashCode = (((this.f8168a.hashCode() ^ 1000003) * 1000003) ^ this.f8169b.hashCode()) * 1000003;
        long j = this.f8170c;
        int i = (hashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        Long l = this.f8171d;
        int hashCode2 = (((((i ^ (l == null ? 0 : l.hashCode())) * 1000003) ^ (this.f8172e ? 1231 : 1237)) * 1000003) ^ this.f8173f.hashCode()) * 1000003;
        oa0.AbstractC1645d.f fVar = this.f8174g;
        int hashCode3 = (hashCode2 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        oa0.AbstractC1645d.e eVar = this.f8175h;
        int hashCode4 = (hashCode3 ^ (eVar == null ? 0 : eVar.hashCode())) * 1000003;
        oa0.AbstractC1645d.c cVar = this.f8176i;
        int hashCode5 = (hashCode4 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        pa0<oa0.AbstractC1645d.d> pa0Var = this.f8177j;
        return ((hashCode5 ^ (pa0Var != null ? pa0Var.hashCode() : 0)) * 1000003) ^ this.f8178k;
    }

    @Override // com.sonelli.oa0.AbstractC1645d
    @Nullable
    /* renamed from: j */
    public oa0.AbstractC1645d.e mo6963j() {
        return this.f8175h;
    }

    @Override // com.sonelli.oa0.AbstractC1645d
    /* renamed from: k */
    public long mo6964k() {
        return this.f8170c;
    }

    @Override // com.sonelli.oa0.AbstractC1645d
    @Nullable
    /* renamed from: l */
    public oa0.AbstractC1645d.f mo6965l() {
        return this.f8174g;
    }

    @Override // com.sonelli.oa0.AbstractC1645d
    /* renamed from: m */
    public boolean mo6966m() {
        return this.f8172e;
    }

    @Override // com.sonelli.oa0.AbstractC1645d
    /* renamed from: n */
    public oa0.AbstractC1645d.b mo6967n() {
        return new C2336b(this);
    }

    public String toString() {
        return "Session{generator=" + this.f8168a + ", identifier=" + this.f8169b + ", startedAt=" + this.f8170c + ", endedAt=" + this.f8171d + ", crashed=" + this.f8172e + ", app=" + this.f8173f + ", user=" + this.f8174g + ", os=" + this.f8175h + ", device=" + this.f8176i + ", events=" + this.f8177j + ", generatorType=" + this.f8178k + "}";
    }
}
