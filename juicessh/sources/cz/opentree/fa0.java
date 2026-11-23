package cz.opentree;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cz.opentree.oa0;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class fa0 extends oa0.AbstractC1645d.d.a.b.AbstractC2503a {

    /* renamed from: a */
    public final long f2639a;

    /* renamed from: b */
    public final long f2640b;

    /* renamed from: c */
    public final String f2641c;

    /* renamed from: d */
    public final String f2642d;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.fa0$b */
    /* loaded from: classes.dex */
    public static final class C0979b extends oa0.AbstractC1645d.d.a.b.AbstractC2503a.AbstractC2504a {

        /* renamed from: a */
        public Long f2643a;

        /* renamed from: b */
        public Long f2644b;

        /* renamed from: c */
        public String f2645c;

        /* renamed from: d */
        public String f2646d;

        @Override // cz.opentree.oa0.AbstractC1645d.d.a.b.AbstractC2503a.AbstractC2504a
        /* renamed from: a */
        public oa0.AbstractC1645d.d.a.b.AbstractC2503a mo3701a() {
            String str = "";
            if (this.f2643a == null) {
                str = " baseAddress";
            }
            if (this.f2644b == null) {
                str = str + " size";
            }
            if (this.f2645c == null) {
                str = str + " name";
            }
            if (str.isEmpty()) {
                return new fa0(this.f2643a.longValue(), this.f2644b.longValue(), this.f2645c, this.f2646d);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // cz.opentree.oa0.AbstractC1645d.d.a.b.AbstractC2503a.AbstractC2504a
        /* renamed from: b */
        public oa0.AbstractC1645d.d.a.b.AbstractC2503a.AbstractC2504a mo3702b(long j) {
            this.f2643a = Long.valueOf(j);
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1645d.d.a.b.AbstractC2503a.AbstractC2504a
        /* renamed from: c */
        public oa0.AbstractC1645d.d.a.b.AbstractC2503a.AbstractC2504a mo3703c(String str) {
            Objects.requireNonNull(str, "Null name");
            this.f2645c = str;
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1645d.d.a.b.AbstractC2503a.AbstractC2504a
        /* renamed from: d */
        public oa0.AbstractC1645d.d.a.b.AbstractC2503a.AbstractC2504a mo3704d(long j) {
            this.f2644b = Long.valueOf(j);
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1645d.d.a.b.AbstractC2503a.AbstractC2504a
        /* renamed from: e */
        public oa0.AbstractC1645d.d.a.b.AbstractC2503a.AbstractC2504a mo3705e(@Nullable String str) {
            this.f2646d = str;
            return this;
        }
    }

    public fa0(long j, long j2, String str, @Nullable String str2) {
        this.f2639a = j;
        this.f2640b = j2;
        this.f2641c = str;
        this.f2642d = str2;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.d.a.b.AbstractC2503a
    @NonNull
    /* renamed from: b */
    public long mo3697b() {
        return this.f2639a;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.d.a.b.AbstractC2503a
    @NonNull
    /* renamed from: c */
    public String mo3698c() {
        return this.f2641c;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.d.a.b.AbstractC2503a
    /* renamed from: d */
    public long mo3699d() {
        return this.f2640b;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.d.a.b.AbstractC2503a
    @Nullable
    /* renamed from: e */
    public String mo3700e() {
        return this.f2642d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oa0.AbstractC1645d.d.a.b.AbstractC2503a)) {
            return false;
        }
        oa0.AbstractC1645d.d.a.b.AbstractC2503a abstractC2503a = (oa0.AbstractC1645d.d.a.b.AbstractC2503a) obj;
        if (this.f2639a == abstractC2503a.mo3697b() && this.f2640b == abstractC2503a.mo3699d() && this.f2641c.equals(abstractC2503a.mo3698c())) {
            String str = this.f2642d;
            if (str == null) {
                if (abstractC2503a.mo3700e() == null) {
                    return true;
                }
            } else if (str.equals(abstractC2503a.mo3700e())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.f2639a;
        long j2 = this.f2640b;
        int hashCode = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f2641c.hashCode()) * 1000003;
        String str = this.f2642d;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "BinaryImage{baseAddress=" + this.f2639a + ", size=" + this.f2640b + ", name=" + this.f2641c + ", uuid=" + this.f2642d + "}";
    }
}
