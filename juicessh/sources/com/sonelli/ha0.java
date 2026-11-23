package com.sonelli;

import androidx.annotation.NonNull;
import com.sonelli.oa0;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class ha0 extends oa0.AbstractC1645d.d.a.b.AbstractC2507d {

    /* renamed from: a */
    public final String f3128a;

    /* renamed from: b */
    public final String f3129b;

    /* renamed from: c */
    public final long f3130c;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.ha0$b */
    /* loaded from: classes.dex */
    public static final class C1101b extends oa0.AbstractC1645d.d.a.b.AbstractC2507d.AbstractC2508a {

        /* renamed from: a */
        public String f3131a;

        /* renamed from: b */
        public String f3132b;

        /* renamed from: c */
        public Long f3133c;

        @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.AbstractC2507d.AbstractC2508a
        /* renamed from: a */
        public oa0.AbstractC1645d.d.a.b.AbstractC2507d mo4424a() {
            String str = "";
            if (this.f3131a == null) {
                str = " name";
            }
            if (this.f3132b == null) {
                str = str + " code";
            }
            if (this.f3133c == null) {
                str = str + " address";
            }
            if (str.isEmpty()) {
                return new ha0(this.f3131a, this.f3132b, this.f3133c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.AbstractC2507d.AbstractC2508a
        /* renamed from: b */
        public oa0.AbstractC1645d.d.a.b.AbstractC2507d.AbstractC2508a mo4425b(long j) {
            this.f3133c = Long.valueOf(j);
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.AbstractC2507d.AbstractC2508a
        /* renamed from: c */
        public oa0.AbstractC1645d.d.a.b.AbstractC2507d.AbstractC2508a mo4426c(String str) {
            Objects.requireNonNull(str, "Null code");
            this.f3132b = str;
            return this;
        }

        @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.AbstractC2507d.AbstractC2508a
        /* renamed from: d */
        public oa0.AbstractC1645d.d.a.b.AbstractC2507d.AbstractC2508a mo4427d(String str) {
            Objects.requireNonNull(str, "Null name");
            this.f3131a = str;
            return this;
        }
    }

    public ha0(String str, String str2, long j) {
        this.f3128a = str;
        this.f3129b = str2;
        this.f3130c = j;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.AbstractC2507d
    @NonNull
    /* renamed from: b */
    public long mo4421b() {
        return this.f3130c;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.AbstractC2507d
    @NonNull
    /* renamed from: c */
    public String mo4422c() {
        return this.f3129b;
    }

    @Override // com.sonelli.oa0.AbstractC1645d.d.a.b.AbstractC2507d
    @NonNull
    /* renamed from: d */
    public String mo4423d() {
        return this.f3128a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oa0.AbstractC1645d.d.a.b.AbstractC2507d)) {
            return false;
        }
        oa0.AbstractC1645d.d.a.b.AbstractC2507d abstractC2507d = (oa0.AbstractC1645d.d.a.b.AbstractC2507d) obj;
        return this.f3128a.equals(abstractC2507d.mo4423d()) && this.f3129b.equals(abstractC2507d.mo4422c()) && this.f3130c == abstractC2507d.mo4421b();
    }

    public int hashCode() {
        int hashCode = (((this.f3128a.hashCode() ^ 1000003) * 1000003) ^ this.f3129b.hashCode()) * 1000003;
        long j = this.f3130c;
        return hashCode ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "Signal{name=" + this.f3128a + ", code=" + this.f3129b + ", address=" + this.f3130c + "}";
    }
}
