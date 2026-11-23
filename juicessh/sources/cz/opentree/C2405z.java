package cz.opentree;

import androidx.annotation.Nullable;
import cz.opentree.AbstractC0906e0;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.z */
/* loaded from: classes.dex */
public final class C2405z extends AbstractC0906e0 {

    /* renamed from: a */
    public final String f8371a;

    /* renamed from: b */
    public final Integer f8372b;

    /* renamed from: c */
    public final C0855d0 f8373c;

    /* renamed from: d */
    public final long f8374d;

    /* renamed from: e */
    public final long f8375e;

    /* renamed from: f */
    public final Map<String, String> f8376f;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* renamed from: cz.opentree.z$b */
    /* loaded from: classes.dex */
    public static final class b extends AbstractC0906e0.a {

        /* renamed from: a */
        public String f8377a;

        /* renamed from: b */
        public Integer f8378b;

        /* renamed from: c */
        public C0855d0 f8379c;

        /* renamed from: d */
        public Long f8380d;

        /* renamed from: e */
        public Long f8381e;

        /* renamed from: f */
        public Map<String, String> f8382f;

        @Override // cz.opentree.AbstractC0906e0.a
        /* renamed from: d */
        public AbstractC0906e0 mo3364d() {
            String str = "";
            if (this.f8377a == null) {
                str = " transportName";
            }
            if (this.f8379c == null) {
                str = str + " encodedPayload";
            }
            if (this.f8380d == null) {
                str = str + " eventMillis";
            }
            if (this.f8381e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f8382f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new C2405z(this.f8377a, this.f8378b, this.f8379c, this.f8380d.longValue(), this.f8381e.longValue(), this.f8382f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // cz.opentree.AbstractC0906e0.a
        /* renamed from: e */
        public Map<String, String> mo3365e() {
            Map<String, String> map = this.f8382f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        @Override // cz.opentree.AbstractC0906e0.a
        /* renamed from: f */
        public AbstractC0906e0.a mo3366f(Map<String, String> map) {
            Objects.requireNonNull(map, "Null autoMetadata");
            this.f8382f = map;
            return this;
        }

        @Override // cz.opentree.AbstractC0906e0.a
        /* renamed from: g */
        public AbstractC0906e0.a mo3367g(Integer num) {
            this.f8378b = num;
            return this;
        }

        @Override // cz.opentree.AbstractC0906e0.a
        /* renamed from: h */
        public AbstractC0906e0.a mo3368h(C0855d0 c0855d0) {
            Objects.requireNonNull(c0855d0, "Null encodedPayload");
            this.f8379c = c0855d0;
            return this;
        }

        @Override // cz.opentree.AbstractC0906e0.a
        /* renamed from: i */
        public AbstractC0906e0.a mo3369i(long j) {
            this.f8380d = Long.valueOf(j);
            return this;
        }

        @Override // cz.opentree.AbstractC0906e0.a
        /* renamed from: j */
        public AbstractC0906e0.a mo3370j(String str) {
            Objects.requireNonNull(str, "Null transportName");
            this.f8377a = str;
            return this;
        }

        @Override // cz.opentree.AbstractC0906e0.a
        /* renamed from: k */
        public AbstractC0906e0.a mo3371k(long j) {
            this.f8381e = Long.valueOf(j);
            return this;
        }
    }

    public C2405z(String str, @Nullable Integer num, C0855d0 c0855d0, long j, long j2, Map<String, String> map) {
        this.f8371a = str;
        this.f8372b = num;
        this.f8373c = c0855d0;
        this.f8374d = j;
        this.f8375e = j2;
        this.f8376f = map;
    }

    @Override // cz.opentree.AbstractC0906e0
    /* renamed from: c */
    public Map<String, String> mo3351c() {
        return this.f8376f;
    }

    @Override // cz.opentree.AbstractC0906e0
    @Nullable
    /* renamed from: d */
    public Integer mo3352d() {
        return this.f8372b;
    }

    @Override // cz.opentree.AbstractC0906e0
    /* renamed from: e */
    public C0855d0 mo3353e() {
        return this.f8373c;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC0906e0)) {
            return false;
        }
        AbstractC0906e0 abstractC0906e0 = (AbstractC0906e0) obj;
        return this.f8371a.equals(abstractC0906e0.mo3358j()) && ((num = this.f8372b) != null ? num.equals(abstractC0906e0.mo3352d()) : abstractC0906e0.mo3352d() == null) && this.f8373c.equals(abstractC0906e0.mo3353e()) && this.f8374d == abstractC0906e0.mo3354f() && this.f8375e == abstractC0906e0.mo3359k() && this.f8376f.equals(abstractC0906e0.mo3351c());
    }

    @Override // cz.opentree.AbstractC0906e0
    /* renamed from: f */
    public long mo3354f() {
        return this.f8374d;
    }

    public int hashCode() {
        int hashCode = (this.f8371a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f8372b;
        int hashCode2 = (((hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f8373c.hashCode()) * 1000003;
        long j = this.f8374d;
        int i = (hashCode2 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.f8375e;
        return ((i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.f8376f.hashCode();
    }

    @Override // cz.opentree.AbstractC0906e0
    /* renamed from: j */
    public String mo3358j() {
        return this.f8371a;
    }

    @Override // cz.opentree.AbstractC0906e0
    /* renamed from: k */
    public long mo3359k() {
        return this.f8375e;
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f8371a + ", code=" + this.f8372b + ", encodedPayload=" + this.f8373c + ", eventMillis=" + this.f8374d + ", uptimeMillis=" + this.f8375e + ", autoMetadata=" + this.f8376f + "}";
    }
}
