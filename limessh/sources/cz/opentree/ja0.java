package cz.opentree;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cz.opentree.oa0;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class ja0 extends oa0.AbstractC1645d.d.a.b.e.AbstractC2510b {

    /* renamed from: a */
    public final long f3523a;

    /* renamed from: b */
    public final String f3524b;

    /* renamed from: c */
    public final String f3525c;

    /* renamed from: d */
    public final long f3526d;

    /* renamed from: e */
    public final int f3527e;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.ja0$b */
    /* loaded from: classes.dex */
    public static final class C1205b extends oa0.AbstractC1645d.d.a.b.e.AbstractC2510b.AbstractC2511a {

        /* renamed from: a */
        public Long f3528a;

        /* renamed from: b */
        public String f3529b;

        /* renamed from: c */
        public String f3530c;

        /* renamed from: d */
        public Long f3531d;

        /* renamed from: e */
        public Integer f3532e;

        @Override // cz.opentree.oa0.AbstractC1645d.d.a.b.e.AbstractC2510b.AbstractC2511a
        /* renamed from: a */
        public oa0.AbstractC1645d.d.a.b.e.AbstractC2510b mo5093a() {
            String str = "";
            if (this.f3528a == null) {
                str = " pc";
            }
            if (this.f3529b == null) {
                str = str + " symbol";
            }
            if (this.f3531d == null) {
                str = str + " offset";
            }
            if (this.f3532e == null) {
                str = str + " importance";
            }
            if (str.isEmpty()) {
                return new ja0(this.f3528a.longValue(), this.f3529b, this.f3530c, this.f3531d.longValue(), this.f3532e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // cz.opentree.oa0.AbstractC1645d.d.a.b.e.AbstractC2510b.AbstractC2511a
        /* renamed from: b */
        public oa0.AbstractC1645d.d.a.b.e.AbstractC2510b.AbstractC2511a mo5094b(String str) {
            this.f3530c = str;
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1645d.d.a.b.e.AbstractC2510b.AbstractC2511a
        /* renamed from: c */
        public oa0.AbstractC1645d.d.a.b.e.AbstractC2510b.AbstractC2511a mo5095c(int i) {
            this.f3532e = Integer.valueOf(i);
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1645d.d.a.b.e.AbstractC2510b.AbstractC2511a
        /* renamed from: d */
        public oa0.AbstractC1645d.d.a.b.e.AbstractC2510b.AbstractC2511a mo5096d(long j) {
            this.f3531d = Long.valueOf(j);
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1645d.d.a.b.e.AbstractC2510b.AbstractC2511a
        /* renamed from: e */
        public oa0.AbstractC1645d.d.a.b.e.AbstractC2510b.AbstractC2511a mo5097e(long j) {
            this.f3528a = Long.valueOf(j);
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1645d.d.a.b.e.AbstractC2510b.AbstractC2511a
        /* renamed from: f */
        public oa0.AbstractC1645d.d.a.b.e.AbstractC2510b.AbstractC2511a mo5098f(String str) {
            Objects.requireNonNull(str, "Null symbol");
            this.f3529b = str;
            return this;
        }
    }

    public ja0(long j, String str, @Nullable String str2, long j2, int i) {
        this.f3523a = j;
        this.f3524b = str;
        this.f3525c = str2;
        this.f3526d = j2;
        this.f3527e = i;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.d.a.b.e.AbstractC2510b
    @Nullable
    /* renamed from: b */
    public String mo5088b() {
        return this.f3525c;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.d.a.b.e.AbstractC2510b
    /* renamed from: c */
    public int mo5089c() {
        return this.f3527e;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.d.a.b.e.AbstractC2510b
    /* renamed from: d */
    public long mo5090d() {
        return this.f3526d;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.d.a.b.e.AbstractC2510b
    /* renamed from: e */
    public long mo5091e() {
        return this.f3523a;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oa0.AbstractC1645d.d.a.b.e.AbstractC2510b)) {
            return false;
        }
        oa0.AbstractC1645d.d.a.b.e.AbstractC2510b abstractC2510b = (oa0.AbstractC1645d.d.a.b.e.AbstractC2510b) obj;
        return this.f3523a == abstractC2510b.mo5091e() && this.f3524b.equals(abstractC2510b.mo5092f()) && ((str = this.f3525c) != null ? str.equals(abstractC2510b.mo5088b()) : abstractC2510b.mo5088b() == null) && this.f3526d == abstractC2510b.mo5090d() && this.f3527e == abstractC2510b.mo5089c();
    }

    @Override // cz.opentree.oa0.AbstractC1645d.d.a.b.e.AbstractC2510b
    @NonNull
    /* renamed from: f */
    public String mo5092f() {
        return this.f3524b;
    }

    public int hashCode() {
        long j = this.f3523a;
        int hashCode = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f3524b.hashCode()) * 1000003;
        String str = this.f3525c;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j2 = this.f3526d;
        return ((hashCode2 ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f3527e;
    }

    public String toString() {
        return "Frame{pc=" + this.f3523a + ", symbol=" + this.f3524b + ", file=" + this.f3525c + ", offset=" + this.f3526d + ", importance=" + this.f3527e + "}";
    }
}
