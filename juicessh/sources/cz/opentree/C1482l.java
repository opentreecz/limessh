package cz.opentree;

import androidx.annotation.Nullable;
import cz.opentree.AbstractC1794r;
import java.util.List;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* renamed from: cz.opentree.l */
/* loaded from: classes.dex */
public final class C1482l extends AbstractC1794r {

    /* renamed from: a */
    public final long f4690a;

    /* renamed from: b */
    public final long f4691b;

    /* renamed from: c */
    public final AbstractC1684p f4692c;

    /* renamed from: d */
    public final Integer f4693d;

    /* renamed from: e */
    public final String f4694e;

    /* renamed from: f */
    public final List<AbstractC1742q> f4695f;

    /* renamed from: g */
    public final EnumC1988u f4696g;

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* renamed from: cz.opentree.l$b */
    /* loaded from: classes.dex */
    public static final class b extends AbstractC1794r.a {

        /* renamed from: a */
        public Long f4697a;

        /* renamed from: b */
        public Long f4698b;

        /* renamed from: c */
        public AbstractC1684p f4699c;

        /* renamed from: d */
        public Integer f4700d;

        /* renamed from: e */
        public String f4701e;

        /* renamed from: f */
        public List<AbstractC1742q> f4702f;

        /* renamed from: g */
        public EnumC1988u f4703g;

        @Override // cz.opentree.AbstractC1794r.a
        /* renamed from: b */
        public AbstractC1794r.a mo6024b(long j) {
            this.f4697a = Long.valueOf(j);
            return this;
        }

        @Override // cz.opentree.AbstractC1794r.a
        /* renamed from: c */
        public AbstractC1794r.a mo6025c(@Nullable AbstractC1684p abstractC1684p) {
            this.f4699c = abstractC1684p;
            return this;
        }

        @Override // cz.opentree.AbstractC1794r.a
        /* renamed from: d */
        public AbstractC1794r.a mo6026d(@Nullable EnumC1988u enumC1988u) {
            this.f4703g = enumC1988u;
            return this;
        }

        @Override // cz.opentree.AbstractC1794r.a
        /* renamed from: e */
        public AbstractC1794r.a mo6027e(@Nullable Integer num) {
            this.f4700d = num;
            return this;
        }

        @Override // cz.opentree.AbstractC1794r.a
        /* renamed from: f */
        public AbstractC1794r.a mo6028f(@Nullable String str) {
            this.f4701e = str;
            return this;
        }

        @Override // cz.opentree.AbstractC1794r.a
        /* renamed from: g */
        public AbstractC1794r.a mo6029g(@Nullable List<AbstractC1742q> list) {
            this.f4702f = list;
            return this;
        }

        @Override // cz.opentree.AbstractC1794r.a
        /* renamed from: h */
        public AbstractC1794r mo6030h() {
            String str = "";
            if (this.f4697a == null) {
                str = " requestTimeMs";
            }
            if (this.f4698b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new C1482l(this.f4697a.longValue(), this.f4698b.longValue(), this.f4699c, this.f4700d, this.f4701e, this.f4702f, this.f4703g, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // cz.opentree.AbstractC1794r.a
        /* renamed from: i */
        public AbstractC1794r.a mo6031i(long j) {
            this.f4698b = Long.valueOf(j);
            return this;
        }
    }

    public /* synthetic */ C1482l(long j, long j2, AbstractC1684p abstractC1684p, Integer num, String str, List list, EnumC1988u enumC1988u, a aVar) {
        this.f4690a = j;
        this.f4691b = j2;
        this.f4692c = abstractC1684p;
        this.f4693d = num;
        this.f4694e = str;
        this.f4695f = list;
        this.f4696g = enumC1988u;
    }

    @Override // cz.opentree.AbstractC1794r
    @Nullable
    /* renamed from: b */
    public AbstractC1684p mo6017b() {
        return this.f4692c;
    }

    @Override // cz.opentree.AbstractC1794r
    @Nullable
    /* renamed from: c */
    public List<AbstractC1742q> mo6018c() {
        return this.f4695f;
    }

    @Override // cz.opentree.AbstractC1794r
    @Nullable
    /* renamed from: d */
    public Integer mo6019d() {
        return this.f4693d;
    }

    @Override // cz.opentree.AbstractC1794r
    @Nullable
    /* renamed from: e */
    public String mo6020e() {
        return this.f4694e;
    }

    public boolean equals(Object obj) {
        AbstractC1684p abstractC1684p;
        Integer num;
        String str;
        List<AbstractC1742q> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1794r)) {
            return false;
        }
        AbstractC1794r abstractC1794r = (AbstractC1794r) obj;
        if (this.f4690a == abstractC1794r.mo6022g() && this.f4691b == abstractC1794r.mo6023h() && ((abstractC1684p = this.f4692c) != null ? abstractC1684p.equals(((C1482l) abstractC1794r).f4692c) : ((C1482l) abstractC1794r).f4692c == null) && ((num = this.f4693d) != null ? num.equals(((C1482l) abstractC1794r).f4693d) : ((C1482l) abstractC1794r).f4693d == null) && ((str = this.f4694e) != null ? str.equals(((C1482l) abstractC1794r).f4694e) : ((C1482l) abstractC1794r).f4694e == null) && ((list = this.f4695f) != null ? list.equals(((C1482l) abstractC1794r).f4695f) : ((C1482l) abstractC1794r).f4695f == null)) {
            EnumC1988u enumC1988u = this.f4696g;
            if (enumC1988u == null) {
                if (((C1482l) abstractC1794r).f4696g == null) {
                    return true;
                }
            } else if (enumC1988u.equals(((C1482l) abstractC1794r).f4696g)) {
                return true;
            }
        }
        return false;
    }

    @Override // cz.opentree.AbstractC1794r
    @Nullable
    /* renamed from: f */
    public EnumC1988u mo6021f() {
        return this.f4696g;
    }

    @Override // cz.opentree.AbstractC1794r
    /* renamed from: g */
    public long mo6022g() {
        return this.f4690a;
    }

    @Override // cz.opentree.AbstractC1794r
    /* renamed from: h */
    public long mo6023h() {
        return this.f4691b;
    }

    public int hashCode() {
        long j = this.f4690a;
        long j2 = this.f4691b;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        AbstractC1684p abstractC1684p = this.f4692c;
        int hashCode = (i ^ (abstractC1684p == null ? 0 : abstractC1684p.hashCode())) * 1000003;
        Integer num = this.f4693d;
        int hashCode2 = (hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f4694e;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<AbstractC1742q> list = this.f4695f;
        int hashCode4 = (hashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        EnumC1988u enumC1988u = this.f4696g;
        return hashCode4 ^ (enumC1988u != null ? enumC1988u.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f4690a + ", requestUptimeMs=" + this.f4691b + ", clientInfo=" + this.f4692c + ", logSource=" + this.f4693d + ", logSourceName=" + this.f4694e + ", logEvents=" + this.f4695f + ", qosTier=" + this.f4696g + "}";
    }
}
