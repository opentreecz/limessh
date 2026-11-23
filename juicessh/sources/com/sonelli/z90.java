package com.sonelli;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.sonelli.oa0;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class z90 extends oa0.AbstractC1645d.a {

    /* renamed from: a */
    public final String f8470a;

    /* renamed from: b */
    public final String f8471b;

    /* renamed from: c */
    public final String f8472c;

    /* renamed from: d */
    public final oa0.AbstractC1645d.a.b f8473d;

    /* renamed from: e */
    public final String f8474e;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.z90$b */
    /* loaded from: classes.dex */
    public static final class C2418b extends oa0.AbstractC1645d.a.AbstractC2501a {

        /* renamed from: a */
        public String f8475a;

        /* renamed from: b */
        public String f8476b;

        /* renamed from: c */
        public String f8477c;

        /* renamed from: d */
        public oa0.AbstractC1645d.a.b f8478d;

        /* renamed from: e */
        public String f8479e;

        @Override // com.sonelli.oa0.AbstractC1645d.a.AbstractC2501a
        /* renamed from: a */
        public oa0.AbstractC1645d.a mo6976a() {
            String str = "";
            if (this.f8475a == null) {
                str = " identifier";
            }
            if (this.f8476b == null) {
                str = str + " version";
            }
            if (str.isEmpty()) {
                return new z90(this.f8475a, this.f8476b, this.f8477c, this.f8478d, this.f8479e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.sonelli.oa0.AbstractC1645d.a.AbstractC2501a
        /* renamed from: b */
        public oa0.AbstractC1645d.a.AbstractC2501a mo6977b(String str) {
            this.f8477c = str;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.a.AbstractC2501a
        /* renamed from: c */
        public oa0.AbstractC1645d.a.AbstractC2501a mo6978c(String str) {
            Objects.requireNonNull(str, "Null identifier");
            this.f8475a = str;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.a.AbstractC2501a
        /* renamed from: d */
        public oa0.AbstractC1645d.a.AbstractC2501a mo6979d(String str) {
            this.f8479e = str;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.a.AbstractC2501a
        /* renamed from: e */
        public oa0.AbstractC1645d.a.AbstractC2501a mo6980e(String str) {
            Objects.requireNonNull(str, "Null version");
            this.f8476b = str;
            return this;
        }
    }

    public z90(String str, String str2, @Nullable String str3, @Nullable oa0.AbstractC1645d.a.b bVar, @Nullable String str4) {
        this.f8470a = str;
        this.f8471b = str2;
        this.f8472c = str3;
        this.f8473d = bVar;
        this.f8474e = str4;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.a
    @Nullable
    /* renamed from: b */
    public String mo6971b() {
        return this.f8472c;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.a
    @NonNull
    /* renamed from: c */
    public String mo6972c() {
        return this.f8470a;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.a
    @Nullable
    /* renamed from: d */
    public String mo6973d() {
        return this.f8474e;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.a
    @Nullable
    /* renamed from: e */
    public oa0.AbstractC1645d.a.b mo6974e() {
        return this.f8473d;
    }

    public boolean equals(Object obj) {
        String str;
        oa0.AbstractC1645d.a.b bVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oa0.AbstractC1645d.a)) {
            return false;
        }
        oa0.AbstractC1645d.a aVar = (oa0.AbstractC1645d.a) obj;
        if (this.f8470a.equals(aVar.mo6972c()) && this.f8471b.equals(aVar.mo6975f()) && ((str = this.f8472c) != null ? str.equals(aVar.mo6971b()) : aVar.mo6971b() == null) && ((bVar = this.f8473d) != null ? bVar.equals(aVar.mo6974e()) : aVar.mo6974e() == null)) {
            String str2 = this.f8474e;
            if (str2 == null) {
                if (aVar.mo6973d() == null) {
                    return true;
                }
            } else if (str2.equals(aVar.mo6973d())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.a
    @NonNull
    /* renamed from: f */
    public String mo6975f() {
        return this.f8471b;
    }

    public int hashCode() {
        int hashCode = (((this.f8470a.hashCode() ^ 1000003) * 1000003) ^ this.f8471b.hashCode()) * 1000003;
        String str = this.f8472c;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        oa0.AbstractC1645d.a.b bVar = this.f8473d;
        int hashCode3 = (hashCode2 ^ (bVar == null ? 0 : bVar.hashCode())) * 1000003;
        String str2 = this.f8474e;
        return hashCode3 ^ (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Application{identifier=" + this.f8470a + ", version=" + this.f8471b + ", displayVersion=" + this.f8472c + ", organization=" + this.f8473d + ", installationUuid=" + this.f8474e + "}";
    }
}
