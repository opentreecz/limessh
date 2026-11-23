package cz.opentree;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cz.opentree.ag0;
import cz.opentree.bg0;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
/* loaded from: classes.dex */
public final class yf0 extends bg0 {

    /* renamed from: a */
    public final String f8202a;

    /* renamed from: b */
    public final ag0.EnumC0710a f8203b;

    /* renamed from: c */
    public final String f8204c;

    /* renamed from: d */
    public final String f8205d;

    /* renamed from: e */
    public final long f8206e;

    /* renamed from: f */
    public final long f8207f;

    /* renamed from: g */
    public final String f8208g;

    /* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
    /* renamed from: cz.opentree.yf0$b */
    /* loaded from: classes.dex */
    public static final class C2344b extends bg0.AbstractC0769a {

        /* renamed from: a */
        public String f8209a;

        /* renamed from: b */
        public ag0.EnumC0710a f8210b;

        /* renamed from: c */
        public String f8211c;

        /* renamed from: d */
        public String f8212d;

        /* renamed from: e */
        public Long f8213e;

        /* renamed from: f */
        public Long f8214f;

        /* renamed from: g */
        public String f8215g;

        public C2344b() {
        }

        public C2344b(bg0 bg0Var) {
            this.f8209a = bg0Var.mo2461d();
            this.f8210b = bg0Var.mo2464g();
            this.f8211c = bg0Var.mo2459b();
            this.f8212d = bg0Var.mo2463f();
            this.f8213e = Long.valueOf(bg0Var.mo2460c());
            this.f8214f = Long.valueOf(bg0Var.mo2465h());
            this.f8215g = bg0Var.mo2462e();
        }

        @Override // cz.opentree.bg0.AbstractC0769a
        /* renamed from: a */
        public bg0 mo2478a() {
            String str = "";
            if (this.f8210b == null) {
                str = " registrationStatus";
            }
            if (this.f8213e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f8214f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new yf0(this.f8209a, this.f8210b, this.f8211c, this.f8212d, this.f8213e.longValue(), this.f8214f.longValue(), this.f8215g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // cz.opentree.bg0.AbstractC0769a
        /* renamed from: b */
        public bg0.AbstractC0769a mo2479b(@Nullable String str) {
            this.f8211c = str;
            return this;
        }

        @Override // cz.opentree.bg0.AbstractC0769a
        /* renamed from: c */
        public bg0.AbstractC0769a mo2480c(long j) {
            this.f8213e = Long.valueOf(j);
            return this;
        }

        @Override // cz.opentree.bg0.AbstractC0769a
        /* renamed from: d */
        public bg0.AbstractC0769a mo2481d(String str) {
            this.f8209a = str;
            return this;
        }

        @Override // cz.opentree.bg0.AbstractC0769a
        /* renamed from: e */
        public bg0.AbstractC0769a mo2482e(@Nullable String str) {
            this.f8215g = str;
            return this;
        }

        @Override // cz.opentree.bg0.AbstractC0769a
        /* renamed from: f */
        public bg0.AbstractC0769a mo2483f(@Nullable String str) {
            this.f8212d = str;
            return this;
        }

        @Override // cz.opentree.bg0.AbstractC0769a
        /* renamed from: g */
        public bg0.AbstractC0769a mo2484g(ag0.EnumC0710a enumC0710a) {
            Objects.requireNonNull(enumC0710a, "Null registrationStatus");
            this.f8210b = enumC0710a;
            return this;
        }

        @Override // cz.opentree.bg0.AbstractC0769a
        /* renamed from: h */
        public bg0.AbstractC0769a mo2485h(long j) {
            this.f8214f = Long.valueOf(j);
            return this;
        }
    }

    public yf0(@Nullable String str, ag0.EnumC0710a enumC0710a, @Nullable String str2, @Nullable String str3, long j, long j2, @Nullable String str4) {
        this.f8202a = str;
        this.f8203b = enumC0710a;
        this.f8204c = str2;
        this.f8205d = str3;
        this.f8206e = j;
        this.f8207f = j2;
        this.f8208g = str4;
    }

    @Override // cz.opentree.bg0
    @Nullable
    /* renamed from: b */
    public String mo2459b() {
        return this.f8204c;
    }

    @Override // cz.opentree.bg0
    /* renamed from: c */
    public long mo2460c() {
        return this.f8206e;
    }

    @Override // cz.opentree.bg0
    @Nullable
    /* renamed from: d */
    public String mo2461d() {
        return this.f8202a;
    }

    @Override // cz.opentree.bg0
    @Nullable
    /* renamed from: e */
    public String mo2462e() {
        return this.f8208g;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bg0)) {
            return false;
        }
        bg0 bg0Var = (bg0) obj;
        String str3 = this.f8202a;
        if (str3 != null ? str3.equals(bg0Var.mo2461d()) : bg0Var.mo2461d() == null) {
            if (this.f8203b.equals(bg0Var.mo2464g()) && ((str = this.f8204c) != null ? str.equals(bg0Var.mo2459b()) : bg0Var.mo2459b() == null) && ((str2 = this.f8205d) != null ? str2.equals(bg0Var.mo2463f()) : bg0Var.mo2463f() == null) && this.f8206e == bg0Var.mo2460c() && this.f8207f == bg0Var.mo2465h()) {
                String str4 = this.f8208g;
                if (str4 == null) {
                    if (bg0Var.mo2462e() == null) {
                        return true;
                    }
                } else if (str4.equals(bg0Var.mo2462e())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // cz.opentree.bg0
    @Nullable
    /* renamed from: f */
    public String mo2463f() {
        return this.f8205d;
    }

    @Override // cz.opentree.bg0
    @NonNull
    /* renamed from: g */
    public ag0.EnumC0710a mo2464g() {
        return this.f8203b;
    }

    @Override // cz.opentree.bg0
    /* renamed from: h */
    public long mo2465h() {
        return this.f8207f;
    }

    public int hashCode() {
        String str = this.f8202a;
        int hashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f8203b.hashCode()) * 1000003;
        String str2 = this.f8204c;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f8205d;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j = this.f8206e;
        int i = (hashCode3 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.f8207f;
        int i2 = (i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        String str4 = this.f8208g;
        return i2 ^ (str4 != null ? str4.hashCode() : 0);
    }

    @Override // cz.opentree.bg0
    /* renamed from: n */
    public bg0.AbstractC0769a mo2471n() {
        return new C2344b(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f8202a + ", registrationStatus=" + this.f8203b + ", authToken=" + this.f8204c + ", refreshToken=" + this.f8205d + ", expiresInSecs=" + this.f8206e + ", tokenCreationEpochInSecs=" + this.f8207f + ", fisError=" + this.f8208g + "}";
    }
}
