package com.sonelli;

import androidx.annotation.Nullable;
import com.sonelli.fg0;

/* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
/* loaded from: classes.dex */
public final class cg0 extends fg0 {

    /* renamed from: a */
    public final String f1932a;

    /* renamed from: b */
    public final String f1933b;

    /* renamed from: c */
    public final String f1934c;

    /* renamed from: d */
    public final gg0 f1935d;

    /* renamed from: e */
    public final fg0.EnumC0988b f1936e;

    /* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
    /* renamed from: com.sonelli.cg0$b */
    /* loaded from: classes.dex */
    public static final class C0823b extends fg0.AbstractC0987a {

        /* renamed from: a */
        public String f1937a;

        /* renamed from: b */
        public String f1938b;

        /* renamed from: c */
        public String f1939c;

        /* renamed from: d */
        public gg0 f1940d;

        /* renamed from: e */
        public fg0.EnumC0988b f1941e;

        @Override // com.sonelli.fg0.AbstractC0987a
        /* renamed from: a */
        public fg0 mo2790a() {
            return new cg0(this.f1937a, this.f1938b, this.f1939c, this.f1940d, this.f1941e);
        }

        @Override // com.sonelli.fg0.AbstractC0987a
        /* renamed from: b */
        public fg0.AbstractC0987a mo2791b(gg0 gg0Var) {
            this.f1940d = gg0Var;
            return this;
        }

        @Override // com.sonelli.fg0.AbstractC0987a
        /* renamed from: c */
        public fg0.AbstractC0987a mo2792c(String str) {
            this.f1938b = str;
            return this;
        }

        @Override // com.sonelli.fg0.AbstractC0987a
        /* renamed from: d */
        public fg0.AbstractC0987a mo2793d(String str) {
            this.f1939c = str;
            return this;
        }

        @Override // com.sonelli.fg0.AbstractC0987a
        /* renamed from: e */
        public fg0.AbstractC0987a mo2794e(fg0.EnumC0988b enumC0988b) {
            this.f1941e = enumC0988b;
            return this;
        }

        @Override // com.sonelli.fg0.AbstractC0987a
        /* renamed from: f */
        public fg0.AbstractC0987a mo2795f(String str) {
            this.f1937a = str;
            return this;
        }
    }

    public cg0(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable gg0 gg0Var, @Nullable fg0.EnumC0988b enumC0988b) {
        this.f1932a = str;
        this.f1933b = str2;
        this.f1934c = str3;
        this.f1935d = gg0Var;
        this.f1936e = enumC0988b;
    }

    @Override // com.sonelli.fg0
    @Nullable
    /* renamed from: b */
    public gg0 mo2785b() {
        return this.f1935d;
    }

    @Override // com.sonelli.fg0
    @Nullable
    /* renamed from: c */
    public String mo2786c() {
        return this.f1933b;
    }

    @Override // com.sonelli.fg0
    @Nullable
    /* renamed from: d */
    public String mo2787d() {
        return this.f1934c;
    }

    @Override // com.sonelli.fg0
    @Nullable
    /* renamed from: e */
    public fg0.EnumC0988b mo2788e() {
        return this.f1936e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fg0)) {
            return false;
        }
        fg0 fg0Var = (fg0) obj;
        String str = this.f1932a;
        if (str != null ? str.equals(fg0Var.mo2789f()) : fg0Var.mo2789f() == null) {
            String str2 = this.f1933b;
            if (str2 != null ? str2.equals(fg0Var.mo2786c()) : fg0Var.mo2786c() == null) {
                String str3 = this.f1934c;
                if (str3 != null ? str3.equals(fg0Var.mo2787d()) : fg0Var.mo2787d() == null) {
                    gg0 gg0Var = this.f1935d;
                    if (gg0Var != null ? gg0Var.equals(fg0Var.mo2785b()) : fg0Var.mo2785b() == null) {
                        fg0.EnumC0988b enumC0988b = this.f1936e;
                        if (enumC0988b == null) {
                            if (fg0Var.mo2788e() == null) {
                                return true;
                            }
                        } else if (enumC0988b.equals(fg0Var.mo2788e())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.sonelli.fg0
    @Nullable
    /* renamed from: f */
    public String mo2789f() {
        return this.f1932a;
    }

    public int hashCode() {
        String str = this.f1932a;
        int hashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f1933b;
        int hashCode2 = (hashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f1934c;
        int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        gg0 gg0Var = this.f1935d;
        int hashCode4 = (hashCode3 ^ (gg0Var == null ? 0 : gg0Var.hashCode())) * 1000003;
        fg0.EnumC0988b enumC0988b = this.f1936e;
        return hashCode4 ^ (enumC0988b != null ? enumC0988b.hashCode() : 0);
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.f1932a + ", fid=" + this.f1933b + ", refreshToken=" + this.f1934c + ", authToken=" + this.f1935d + ", responseCode=" + this.f1936e + "}";
    }
}
