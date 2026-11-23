package com.sonelli;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.sonelli.oa0;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class u90 extends oa0 {

    /* renamed from: b */
    public final String f6929b;

    /* renamed from: c */
    public final String f6930c;

    /* renamed from: d */
    public final int f6931d;

    /* renamed from: e */
    public final String f6932e;

    /* renamed from: f */
    public final String f6933f;

    /* renamed from: g */
    public final String f6934g;

    /* renamed from: h */
    public final oa0.AbstractC1645d f6935h;

    /* renamed from: i */
    public final oa0.AbstractC1644c f6936i;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.u90$b */
    /* loaded from: classes.dex */
    public static final class C2000b extends oa0.AbstractC1642a {

        /* renamed from: a */
        public String f6937a;

        /* renamed from: b */
        public String f6938b;

        /* renamed from: c */
        public Integer f6939c;

        /* renamed from: d */
        public String f6940d;

        /* renamed from: e */
        public String f6941e;

        /* renamed from: f */
        public String f6942f;

        /* renamed from: g */
        public oa0.AbstractC1645d f6943g;

        /* renamed from: h */
        public oa0.AbstractC1644c f6944h;

        public C2000b() {
        }

        public C2000b(oa0 oa0Var) {
            this.f6937a = oa0Var.mo6920i();
            this.f6938b = oa0Var.mo6916e();
            this.f6939c = Integer.valueOf(oa0Var.mo6919h());
            this.f6940d = oa0Var.mo6917f();
            this.f6941e = oa0Var.mo6914c();
            this.f6942f = oa0Var.mo6915d();
            this.f6943g = oa0Var.mo6921j();
            this.f6944h = oa0Var.mo6918g();
        }

        @Override // com.sonelli.oa0.AbstractC1642a
        /* renamed from: a */
        public oa0 mo6927a() {
            String str = "";
            if (this.f6937a == null) {
                str = " sdkVersion";
            }
            if (this.f6938b == null) {
                str = str + " gmpAppId";
            }
            if (this.f6939c == null) {
                str = str + " platform";
            }
            if (this.f6940d == null) {
                str = str + " installationUuid";
            }
            if (this.f6941e == null) {
                str = str + " buildVersion";
            }
            if (this.f6942f == null) {
                str = str + " displayVersion";
            }
            if (str.isEmpty()) {
                return new u90(this.f6937a, this.f6938b, this.f6939c.intValue(), this.f6940d, this.f6941e, this.f6942f, this.f6943g, this.f6944h);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.sonelli.oa0.AbstractC1642a
        /* renamed from: b */
        public oa0.AbstractC1642a mo6928b(String str) {
            Objects.requireNonNull(str, "Null buildVersion");
            this.f6941e = str;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1642a
        /* renamed from: c */
        public oa0.AbstractC1642a mo6929c(String str) {
            Objects.requireNonNull(str, "Null displayVersion");
            this.f6942f = str;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1642a
        /* renamed from: d */
        public oa0.AbstractC1642a mo6930d(String str) {
            Objects.requireNonNull(str, "Null gmpAppId");
            this.f6938b = str;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1642a
        /* renamed from: e */
        public oa0.AbstractC1642a mo6931e(String str) {
            Objects.requireNonNull(str, "Null installationUuid");
            this.f6940d = str;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1642a
        /* renamed from: f */
        public oa0.AbstractC1642a mo6932f(oa0.AbstractC1644c abstractC1644c) {
            this.f6944h = abstractC1644c;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1642a
        /* renamed from: g */
        public oa0.AbstractC1642a mo6933g(int i) {
            this.f6939c = Integer.valueOf(i);
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1642a
        /* renamed from: h */
        public oa0.AbstractC1642a mo6934h(String str) {
            Objects.requireNonNull(str, "Null sdkVersion");
            this.f6937a = str;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1642a
        /* renamed from: i */
        public oa0.AbstractC1642a mo6935i(oa0.AbstractC1645d abstractC1645d) {
            this.f6943g = abstractC1645d;
            return this;
        }
    }

    public u90(String str, String str2, int i, String str3, String str4, String str5, @Nullable oa0.AbstractC1645d abstractC1645d, @Nullable oa0.AbstractC1644c abstractC1644c) {
        this.f6929b = str;
        this.f6930c = str2;
        this.f6931d = i;
        this.f6932e = str3;
        this.f6933f = str4;
        this.f6934g = str5;
        this.f6935h = abstractC1645d;
        this.f6936i = abstractC1644c;
    }

    @Override // com.sonelli.oa0
    @NonNull
    /* renamed from: c */
    public String mo6914c() {
        return this.f6933f;
    }

    @Override // com.sonelli.oa0
    @NonNull
    /* renamed from: d */
    public String mo6915d() {
        return this.f6934g;
    }

    @Override // com.sonelli.oa0
    @NonNull
    /* renamed from: e */
    public String mo6916e() {
        return this.f6930c;
    }

    public boolean equals(Object obj) {
        oa0.AbstractC1645d abstractC1645d;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oa0)) {
            return false;
        }
        oa0 oa0Var = (oa0) obj;
        if (this.f6929b.equals(oa0Var.mo6920i()) && this.f6930c.equals(oa0Var.mo6916e()) && this.f6931d == oa0Var.mo6919h() && this.f6932e.equals(oa0Var.mo6917f()) && this.f6933f.equals(oa0Var.mo6914c()) && this.f6934g.equals(oa0Var.mo6915d()) && ((abstractC1645d = this.f6935h) != null ? abstractC1645d.equals(oa0Var.mo6921j()) : oa0Var.mo6921j() == null)) {
            oa0.AbstractC1644c abstractC1644c = this.f6936i;
            if (abstractC1644c == null) {
                if (oa0Var.mo6918g() == null) {
                    return true;
                }
            } else if (abstractC1644c.equals(oa0Var.mo6918g())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.sonelli.oa0
    @NonNull
    /* renamed from: f */
    public String mo6917f() {
        return this.f6932e;
    }

    @Override // com.sonelli.oa0
    @Nullable
    /* renamed from: g */
    public oa0.AbstractC1644c mo6918g() {
        return this.f6936i;
    }

    @Override // com.sonelli.oa0
    /* renamed from: h */
    public int mo6919h() {
        return this.f6931d;
    }

    public int hashCode() {
        int hashCode = (((((((((((this.f6929b.hashCode() ^ 1000003) * 1000003) ^ this.f6930c.hashCode()) * 1000003) ^ this.f6931d) * 1000003) ^ this.f6932e.hashCode()) * 1000003) ^ this.f6933f.hashCode()) * 1000003) ^ this.f6934g.hashCode()) * 1000003;
        oa0.AbstractC1645d abstractC1645d = this.f6935h;
        int hashCode2 = (hashCode ^ (abstractC1645d == null ? 0 : abstractC1645d.hashCode())) * 1000003;
        oa0.AbstractC1644c abstractC1644c = this.f6936i;
        return hashCode2 ^ (abstractC1644c != null ? abstractC1644c.hashCode() : 0);
    }

    @Override // com.sonelli.oa0
    @NonNull
    /* renamed from: i */
    public String mo6920i() {
        return this.f6929b;
    }

    @Override // com.sonelli.oa0
    @Nullable
    /* renamed from: j */
    public oa0.AbstractC1645d mo6921j() {
        return this.f6935h;
    }

    @Override // com.sonelli.oa0
    /* renamed from: l */
    public oa0.AbstractC1642a mo6923l() {
        return new C2000b(this);
    }

    public String toString() {
        return "CrashlyticsReport{sdkVersion=" + this.f6929b + ", gmpAppId=" + this.f6930c + ", platform=" + this.f6931d + ", installationUuid=" + this.f6932e + ", buildVersion=" + this.f6933f + ", displayVersion=" + this.f6934g + ", session=" + this.f6935h + ", ndkPayload=" + this.f6936i + "}";
    }
}
