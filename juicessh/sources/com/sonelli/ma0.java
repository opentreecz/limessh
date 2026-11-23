package com.sonelli;

import androidx.annotation.NonNull;
import com.sonelli.oa0;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class ma0 extends oa0.AbstractC1645d.e {

    /* renamed from: a */
    public final int f5007a;

    /* renamed from: b */
    public final String f5008b;

    /* renamed from: c */
    public final String f5009c;

    /* renamed from: d */
    public final boolean f5010d;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.ma0$b */
    /* loaded from: classes.dex */
    public static final class C1545b extends oa0.AbstractC1645d.e.a {

        /* renamed from: a */
        public Integer f5011a;

        /* renamed from: b */
        public String f5012b;

        /* renamed from: c */
        public String f5013c;

        /* renamed from: d */
        public Boolean f5014d;

        @Override // com.sonelli.oa0.AbstractC1645d.e.a
        /* renamed from: a */
        public oa0.AbstractC1645d.e mo6390a() {
            String str = "";
            if (this.f5011a == null) {
                str = " platform";
            }
            if (this.f5012b == null) {
                str = str + " version";
            }
            if (this.f5013c == null) {
                str = str + " buildVersion";
            }
            if (this.f5014d == null) {
                str = str + " jailbroken";
            }
            if (str.isEmpty()) {
                return new ma0(this.f5011a.intValue(), this.f5012b, this.f5013c, this.f5014d.booleanValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.sonelli.oa0.AbstractC1645d.e.a
        /* renamed from: b */
        public oa0.AbstractC1645d.e.a mo6391b(String str) {
            Objects.requireNonNull(str, "Null buildVersion");
            this.f5013c = str;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.e.a
        /* renamed from: c */
        public oa0.AbstractC1645d.e.a mo6392c(boolean z) {
            this.f5014d = Boolean.valueOf(z);
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.e.a
        /* renamed from: d */
        public oa0.AbstractC1645d.e.a mo6393d(int i) {
            this.f5011a = Integer.valueOf(i);
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.e.a
        /* renamed from: e */
        public oa0.AbstractC1645d.e.a mo6394e(String str) {
            Objects.requireNonNull(str, "Null version");
            this.f5012b = str;
            return this;
        }
    }

    public ma0(int i, String str, String str2, boolean z) {
        this.f5007a = i;
        this.f5008b = str;
        this.f5009c = str2;
        this.f5010d = z;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.e
    @NonNull
    /* renamed from: b */
    public String mo6386b() {
        return this.f5009c;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.e
    /* renamed from: c */
    public int mo6387c() {
        return this.f5007a;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.e
    @NonNull
    /* renamed from: d */
    public String mo6388d() {
        return this.f5008b;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.e
    /* renamed from: e */
    public boolean mo6389e() {
        return this.f5010d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oa0.AbstractC1645d.e)) {
            return false;
        }
        oa0.AbstractC1645d.e eVar = (oa0.AbstractC1645d.e) obj;
        return this.f5007a == eVar.mo6387c() && this.f5008b.equals(eVar.mo6388d()) && this.f5009c.equals(eVar.mo6386b()) && this.f5010d == eVar.mo6389e();
    }

    public int hashCode() {
        return ((((((this.f5007a ^ 1000003) * 1000003) ^ this.f5008b.hashCode()) * 1000003) ^ this.f5009c.hashCode()) * 1000003) ^ (this.f5010d ? 1231 : 1237);
    }

    public String toString() {
        return "OperatingSystem{platform=" + this.f5007a + ", version=" + this.f5008b + ", buildVersion=" + this.f5009c + ", jailbroken=" + this.f5010d + "}";
    }
}
