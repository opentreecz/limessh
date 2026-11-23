package cz.opentree;

import androidx.annotation.Nullable;
import cz.opentree.AbstractC1742q;
import java.util.Arrays;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* renamed from: cz.opentree.k */
/* loaded from: classes.dex */
public final class C1418k extends AbstractC1742q {

    /* renamed from: a */
    public final long f4399a;

    /* renamed from: b */
    public final Integer f4400b;

    /* renamed from: c */
    public final long f4401c;

    /* renamed from: d */
    public final byte[] f4402d;

    /* renamed from: e */
    public final String f4403e;

    /* renamed from: f */
    public final long f4404f;

    /* renamed from: g */
    public final AbstractC1892t f4405g;

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* renamed from: cz.opentree.k$b */
    /* loaded from: classes.dex */
    public static final class b extends AbstractC1742q.a {

        /* renamed from: a */
        public Long f4406a;

        /* renamed from: b */
        public Integer f4407b;

        /* renamed from: c */
        public Long f4408c;

        /* renamed from: d */
        public byte[] f4409d;

        /* renamed from: e */
        public String f4410e;

        /* renamed from: f */
        public Long f4411f;

        /* renamed from: g */
        public AbstractC1892t f4412g;

        @Override // cz.opentree.AbstractC1742q.a
        /* renamed from: a */
        public AbstractC1742q.a mo5756a(long j) {
            this.f4406a = Long.valueOf(j);
            return this;
        }

        @Override // cz.opentree.AbstractC1742q.a
        /* renamed from: b */
        public AbstractC1742q.a mo5757b(@Nullable AbstractC1892t abstractC1892t) {
            this.f4412g = abstractC1892t;
            return this;
        }

        @Override // cz.opentree.AbstractC1742q.a
        /* renamed from: c */
        public AbstractC1742q.a mo5758c(@Nullable Integer num) {
            this.f4407b = num;
            return this;
        }

        @Override // cz.opentree.AbstractC1742q.a
        /* renamed from: d */
        public AbstractC1742q.a mo5759d(@Nullable String str) {
            this.f4410e = str;
            return this;
        }

        @Override // cz.opentree.AbstractC1742q.a
        /* renamed from: e */
        public AbstractC1742q.a mo5760e(@Nullable byte[] bArr) {
            this.f4409d = bArr;
            return this;
        }

        @Override // cz.opentree.AbstractC1742q.a
        /* renamed from: f */
        public AbstractC1742q mo5761f() {
            String str = "";
            if (this.f4406a == null) {
                str = " eventTimeMs";
            }
            if (this.f4408c == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f4411f == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new C1418k(this.f4406a.longValue(), this.f4407b, this.f4408c.longValue(), this.f4409d, this.f4410e, this.f4411f.longValue(), this.f4412g, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // cz.opentree.AbstractC1742q.a
        /* renamed from: g */
        public AbstractC1742q.a mo5762g(long j) {
            this.f4408c = Long.valueOf(j);
            return this;
        }

        @Override // cz.opentree.AbstractC1742q.a
        /* renamed from: h */
        public AbstractC1742q.a mo5763h(long j) {
            this.f4411f = Long.valueOf(j);
            return this;
        }
    }

    public /* synthetic */ C1418k(long j, Integer num, long j2, byte[] bArr, String str, long j3, AbstractC1892t abstractC1892t, a aVar) {
        this.f4399a = j;
        this.f4400b = num;
        this.f4401c = j2;
        this.f4402d = bArr;
        this.f4403e = str;
        this.f4404f = j3;
        this.f4405g = abstractC1892t;
    }

    @Override // cz.opentree.AbstractC1742q
    @Nullable
    /* renamed from: c */
    public Integer mo5749c() {
        return this.f4400b;
    }

    @Override // cz.opentree.AbstractC1742q
    /* renamed from: d */
    public long mo5750d() {
        return this.f4399a;
    }

    @Override // cz.opentree.AbstractC1742q
    /* renamed from: e */
    public long mo5751e() {
        return this.f4401c;
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1742q)) {
            return false;
        }
        AbstractC1742q abstractC1742q = (AbstractC1742q) obj;
        if (this.f4399a == abstractC1742q.mo5750d() && ((num = this.f4400b) != null ? num.equals(((C1418k) abstractC1742q).f4400b) : ((C1418k) abstractC1742q).f4400b == null) && this.f4401c == abstractC1742q.mo5751e()) {
            if (Arrays.equals(this.f4402d, abstractC1742q instanceof C1418k ? ((C1418k) abstractC1742q).f4402d : abstractC1742q.mo5753g()) && ((str = this.f4403e) != null ? str.equals(((C1418k) abstractC1742q).f4403e) : ((C1418k) abstractC1742q).f4403e == null) && this.f4404f == abstractC1742q.mo5755i()) {
                AbstractC1892t abstractC1892t = this.f4405g;
                if (abstractC1892t == null) {
                    if (((C1418k) abstractC1742q).f4405g == null) {
                        return true;
                    }
                } else if (abstractC1892t.equals(((C1418k) abstractC1742q).f4405g)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // cz.opentree.AbstractC1742q
    @Nullable
    /* renamed from: f */
    public AbstractC1892t mo5752f() {
        return this.f4405g;
    }

    @Override // cz.opentree.AbstractC1742q
    @Nullable
    /* renamed from: g */
    public byte[] mo5753g() {
        return this.f4402d;
    }

    @Override // cz.opentree.AbstractC1742q
    @Nullable
    /* renamed from: h */
    public String mo5754h() {
        return this.f4403e;
    }

    public int hashCode() {
        long j = this.f4399a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f4400b;
        int hashCode = num == null ? 0 : num.hashCode();
        long j2 = this.f4401c;
        int hashCode2 = (((((i ^ hashCode) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f4402d)) * 1000003;
        String str = this.f4403e;
        int hashCode3 = str == null ? 0 : str.hashCode();
        long j3 = this.f4404f;
        int i2 = (((hashCode2 ^ hashCode3) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        AbstractC1892t abstractC1892t = this.f4405g;
        return i2 ^ (abstractC1892t != null ? abstractC1892t.hashCode() : 0);
    }

    @Override // cz.opentree.AbstractC1742q
    /* renamed from: i */
    public long mo5755i() {
        return this.f4404f;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f4399a + ", eventCode=" + this.f4400b + ", eventUptimeMs=" + this.f4401c + ", sourceExtension=" + Arrays.toString(this.f4402d) + ", sourceExtensionJsonProto3=" + this.f4403e + ", timezoneOffsetSeconds=" + this.f4404f + ", networkConnectionInfo=" + this.f4405g + "}";
    }
}
