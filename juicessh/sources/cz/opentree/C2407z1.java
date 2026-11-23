package cz.opentree;

import cz.opentree.AbstractC0749b2;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.z1 */
/* loaded from: classes.dex */
public final class C2407z1 extends AbstractC0749b2 {

    /* renamed from: b */
    public final long f8397b;

    /* renamed from: c */
    public final int f8398c;

    /* renamed from: d */
    public final int f8399d;

    /* renamed from: e */
    public final long f8400e;

    /* renamed from: f */
    public final int f8401f;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* renamed from: cz.opentree.z1$b */
    /* loaded from: classes.dex */
    public static final class b extends AbstractC0749b2.a {

        /* renamed from: a */
        public Long f8402a;

        /* renamed from: b */
        public Integer f8403b;

        /* renamed from: c */
        public Integer f8404c;

        /* renamed from: d */
        public Long f8405d;

        /* renamed from: e */
        public Integer f8406e;

        @Override // cz.opentree.AbstractC0749b2.a
        /* renamed from: a */
        public AbstractC0749b2 mo2350a() {
            String str = "";
            if (this.f8402a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.f8403b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f8404c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f8405d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f8406e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new C2407z1(this.f8402a.longValue(), this.f8403b.intValue(), this.f8404c.intValue(), this.f8405d.longValue(), this.f8406e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // cz.opentree.AbstractC0749b2.a
        /* renamed from: b */
        public AbstractC0749b2.a mo2351b(int i) {
            this.f8404c = Integer.valueOf(i);
            return this;
        }

        @Override // cz.opentree.AbstractC0749b2.a
        /* renamed from: c */
        public AbstractC0749b2.a mo2352c(long j) {
            this.f8405d = Long.valueOf(j);
            return this;
        }

        @Override // cz.opentree.AbstractC0749b2.a
        /* renamed from: d */
        public AbstractC0749b2.a mo2353d(int i) {
            this.f8403b = Integer.valueOf(i);
            return this;
        }

        @Override // cz.opentree.AbstractC0749b2.a
        /* renamed from: e */
        public AbstractC0749b2.a mo2354e(int i) {
            this.f8406e = Integer.valueOf(i);
            return this;
        }

        @Override // cz.opentree.AbstractC0749b2.a
        /* renamed from: f */
        public AbstractC0749b2.a mo2355f(long j) {
            this.f8402a = Long.valueOf(j);
            return this;
        }
    }

    public C2407z1(long j, int i, int i2, long j2, int i3) {
        this.f8397b = j;
        this.f8398c = i;
        this.f8399d = i2;
        this.f8400e = j2;
        this.f8401f = i3;
    }

    @Override // cz.opentree.AbstractC0749b2
    /* renamed from: b */
    public int mo2345b() {
        return this.f8399d;
    }

    @Override // cz.opentree.AbstractC0749b2
    /* renamed from: c */
    public long mo2346c() {
        return this.f8400e;
    }

    @Override // cz.opentree.AbstractC0749b2
    /* renamed from: d */
    public int mo2347d() {
        return this.f8398c;
    }

    @Override // cz.opentree.AbstractC0749b2
    /* renamed from: e */
    public int mo2348e() {
        return this.f8401f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC0749b2)) {
            return false;
        }
        AbstractC0749b2 abstractC0749b2 = (AbstractC0749b2) obj;
        return this.f8397b == abstractC0749b2.mo2349f() && this.f8398c == abstractC0749b2.mo2347d() && this.f8399d == abstractC0749b2.mo2345b() && this.f8400e == abstractC0749b2.mo2346c() && this.f8401f == abstractC0749b2.mo2348e();
    }

    @Override // cz.opentree.AbstractC0749b2
    /* renamed from: f */
    public long mo2349f() {
        return this.f8397b;
    }

    public int hashCode() {
        long j = this.f8397b;
        int i = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f8398c) * 1000003) ^ this.f8399d) * 1000003;
        long j2 = this.f8400e;
        return ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f8401f;
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f8397b + ", loadBatchSize=" + this.f8398c + ", criticalSectionEnterTimeoutMs=" + this.f8399d + ", eventCleanUpAge=" + this.f8400e + ", maxBlobByteSizePerRow=" + this.f8401f + "}";
    }
}
