package com.sonelli;

import com.sonelli.AbstractC1583n1;
import java.util.Objects;
import java.util.Set;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.k1 */
/* loaded from: classes.dex */
public final class C1420k1 extends AbstractC1583n1.b {

    /* renamed from: a */
    public final long f4421a;

    /* renamed from: b */
    public final long f4422b;

    /* renamed from: c */
    public final Set<AbstractC1583n1.c> f4423c;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* renamed from: com.sonelli.k1$b */
    /* loaded from: classes.dex */
    public static final class b extends AbstractC1583n1.b.a {

        /* renamed from: a */
        public Long f4424a;

        /* renamed from: b */
        public Long f4425b;

        /* renamed from: c */
        public Set<AbstractC1583n1.c> f4426c;

        @Override // com.sonelli.AbstractC1583n1.b.a
        /* renamed from: a */
        public AbstractC1583n1.b mo5775a() {
            String str = "";
            if (this.f4424a == null) {
                str = " delta";
            }
            if (this.f4425b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f4426c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new C1420k1(this.f4424a.longValue(), this.f4425b.longValue(), this.f4426c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.sonelli.AbstractC1583n1.b.a
        /* renamed from: b */
        public AbstractC1583n1.b.a mo5776b(long j) {
            this.f4424a = Long.valueOf(j);
            return this;
        }

        @Override // com.sonelli.AbstractC1583n1.b.a
        /* renamed from: c */
        public AbstractC1583n1.b.a mo5777c(Set<AbstractC1583n1.c> set) {
            Objects.requireNonNull(set, "Null flags");
            this.f4426c = set;
            return this;
        }

        @Override // com.sonelli.AbstractC1583n1.b.a
        /* renamed from: d */
        public AbstractC1583n1.b.a mo5778d(long j) {
            this.f4425b = Long.valueOf(j);
            return this;
        }
    }

    public C1420k1(long j, long j2, Set<AbstractC1583n1.c> set) {
        this.f4421a = j;
        this.f4422b = j2;
        this.f4423c = set;
    }

    @Override // com.sonelli.AbstractC1583n1.b
    /* renamed from: b */
    public long mo5772b() {
        return this.f4421a;
    }

    @Override // com.sonelli.AbstractC1583n1.b
    /* renamed from: c */
    public Set<AbstractC1583n1.c> mo5773c() {
        return this.f4423c;
    }

    @Override // com.sonelli.AbstractC1583n1.b
    /* renamed from: d */
    public long mo5774d() {
        return this.f4422b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1583n1.b)) {
            return false;
        }
        AbstractC1583n1.b bVar = (AbstractC1583n1.b) obj;
        return this.f4421a == bVar.mo5772b() && this.f4422b == bVar.mo5774d() && this.f4423c.equals(bVar.mo5773c());
    }

    public int hashCode() {
        long j = this.f4421a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        long j2 = this.f4422b;
        return ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f4423c.hashCode();
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f4421a + ", maxAllowedDelay=" + this.f4422b + ", flags=" + this.f4423c + "}";
    }
}
