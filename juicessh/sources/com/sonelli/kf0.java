package com.sonelli;

import androidx.annotation.NonNull;
import com.sonelli.vf0;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-installations-interop@@16.0.0 */
/* loaded from: classes.dex */
public final class kf0 extends vf0 {

    /* renamed from: a */
    public final String f4529a;

    /* renamed from: b */
    public final long f4530b;

    /* renamed from: c */
    public final long f4531c;

    /* compiled from: com.google.firebase:firebase-installations-interop@@16.0.0 */
    /* renamed from: com.sonelli.kf0$b */
    /* loaded from: classes.dex */
    public static final class C1449b extends vf0.AbstractC2168a {

        /* renamed from: a */
        public String f4532a;

        /* renamed from: b */
        public Long f4533b;

        /* renamed from: c */
        public Long f4534c;

        @Override // com.sonelli.vf0.AbstractC2168a
        /* renamed from: a */
        public vf0 mo5880a() {
            String str = "";
            if (this.f4532a == null) {
                str = " token";
            }
            if (this.f4533b == null) {
                str = str + " tokenExpirationTimestamp";
            }
            if (this.f4534c == null) {
                str = str + " tokenCreationTimestamp";
            }
            if (str.isEmpty()) {
                return new kf0(this.f4532a, this.f4533b.longValue(), this.f4534c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.sonelli.vf0.AbstractC2168a
        /* renamed from: b */
        public vf0.AbstractC2168a mo5881b(String str) {
            Objects.requireNonNull(str, "Null token");
            this.f4532a = str;
            return this;
        }

        @Override // com.sonelli.vf0.AbstractC2168a
        /* renamed from: c */
        public vf0.AbstractC2168a mo5882c(long j) {
            this.f4534c = Long.valueOf(j);
            return this;
        }

        @Override // com.sonelli.vf0.AbstractC2168a
        /* renamed from: d */
        public vf0.AbstractC2168a mo5883d(long j) {
            this.f4533b = Long.valueOf(j);
            return this;
        }
    }

    public kf0(String str, long j, long j2) {
        this.f4529a = str;
        this.f4530b = j;
        this.f4531c = j2;
    }

    @Override // com.sonelli.vf0
    @NonNull
    /* renamed from: b */
    public String mo5877b() {
        return this.f4529a;
    }

    @Override // com.sonelli.vf0
    @NonNull
    /* renamed from: c */
    public long mo5878c() {
        return this.f4531c;
    }

    @Override // com.sonelli.vf0
    @NonNull
    /* renamed from: d */
    public long mo5879d() {
        return this.f4530b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof vf0)) {
            return false;
        }
        vf0 vf0Var = (vf0) obj;
        return this.f4529a.equals(vf0Var.mo5877b()) && this.f4530b == vf0Var.mo5879d() && this.f4531c == vf0Var.mo5878c();
    }

    public int hashCode() {
        int hashCode = (this.f4529a.hashCode() ^ 1000003) * 1000003;
        long j = this.f4530b;
        long j2 = this.f4531c;
        return ((hashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.f4529a + ", tokenExpirationTimestamp=" + this.f4530b + ", tokenCreationTimestamp=" + this.f4531c + "}";
    }
}
