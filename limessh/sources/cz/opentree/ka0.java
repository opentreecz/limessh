package cz.opentree;

import androidx.annotation.Nullable;
import cz.opentree.oa0;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class ka0 extends oa0.AbstractC1645d.d.c {

    /* renamed from: a */
    public final Double f4500a;

    /* renamed from: b */
    public final int f4501b;

    /* renamed from: c */
    public final boolean f4502c;

    /* renamed from: d */
    public final int f4503d;

    /* renamed from: e */
    public final long f4504e;

    /* renamed from: f */
    public final long f4505f;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.ka0$b */
    /* loaded from: classes.dex */
    public static final class C1442b extends oa0.AbstractC1645d.d.c.a {

        /* renamed from: a */
        public Double f4506a;

        /* renamed from: b */
        public Integer f4507b;

        /* renamed from: c */
        public Boolean f4508c;

        /* renamed from: d */
        public Integer f4509d;

        /* renamed from: e */
        public Long f4510e;

        /* renamed from: f */
        public Long f4511f;

        @Override // cz.opentree.oa0.AbstractC1645d.d.c.a
        /* renamed from: a */
        public oa0.AbstractC1645d.d.c mo5858a() {
            String str = "";
            if (this.f4507b == null) {
                str = " batteryVelocity";
            }
            if (this.f4508c == null) {
                str = str + " proximityOn";
            }
            if (this.f4509d == null) {
                str = str + " orientation";
            }
            if (this.f4510e == null) {
                str = str + " ramUsed";
            }
            if (this.f4511f == null) {
                str = str + " diskUsed";
            }
            if (str.isEmpty()) {
                return new ka0(this.f4506a, this.f4507b.intValue(), this.f4508c.booleanValue(), this.f4509d.intValue(), this.f4510e.longValue(), this.f4511f.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // cz.opentree.oa0.AbstractC1645d.d.c.a
        /* renamed from: b */
        public oa0.AbstractC1645d.d.c.a mo5859b(Double d) {
            this.f4506a = d;
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1645d.d.c.a
        /* renamed from: c */
        public oa0.AbstractC1645d.d.c.a mo5860c(int i) {
            this.f4507b = Integer.valueOf(i);
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1645d.d.c.a
        /* renamed from: d */
        public oa0.AbstractC1645d.d.c.a mo5861d(long j) {
            this.f4511f = Long.valueOf(j);
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1645d.d.c.a
        /* renamed from: e */
        public oa0.AbstractC1645d.d.c.a mo5862e(int i) {
            this.f4509d = Integer.valueOf(i);
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1645d.d.c.a
        /* renamed from: f */
        public oa0.AbstractC1645d.d.c.a mo5863f(boolean z) {
            this.f4508c = Boolean.valueOf(z);
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1645d.d.c.a
        /* renamed from: g */
        public oa0.AbstractC1645d.d.c.a mo5864g(long j) {
            this.f4510e = Long.valueOf(j);
            return this;
        }
    }

    public ka0(@Nullable Double d, int i, boolean z, int i2, long j, long j2) {
        this.f4500a = d;
        this.f4501b = i;
        this.f4502c = z;
        this.f4503d = i2;
        this.f4504e = j;
        this.f4505f = j2;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.d.c
    @Nullable
    /* renamed from: b */
    public Double mo5852b() {
        return this.f4500a;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.d.c
    /* renamed from: c */
    public int mo5853c() {
        return this.f4501b;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.d.c
    /* renamed from: d */
    public long mo5854d() {
        return this.f4505f;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.d.c
    /* renamed from: e */
    public int mo5855e() {
        return this.f4503d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oa0.AbstractC1645d.d.c)) {
            return false;
        }
        oa0.AbstractC1645d.d.c cVar = (oa0.AbstractC1645d.d.c) obj;
        Double d = this.f4500a;
        if (d != null ? d.equals(cVar.mo5852b()) : cVar.mo5852b() == null) {
            if (this.f4501b == cVar.mo5853c() && this.f4502c == cVar.mo5857g() && this.f4503d == cVar.mo5855e() && this.f4504e == cVar.mo5856f() && this.f4505f == cVar.mo5854d()) {
                return true;
            }
        }
        return false;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.d.c
    /* renamed from: f */
    public long mo5856f() {
        return this.f4504e;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.d.c
    /* renamed from: g */
    public boolean mo5857g() {
        return this.f4502c;
    }

    public int hashCode() {
        Double d = this.f4500a;
        int hashCode = ((((((((d == null ? 0 : d.hashCode()) ^ 1000003) * 1000003) ^ this.f4501b) * 1000003) ^ (this.f4502c ? 1231 : 1237)) * 1000003) ^ this.f4503d) * 1000003;
        long j = this.f4504e;
        long j2 = this.f4505f;
        return ((hashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "Device{batteryLevel=" + this.f4500a + ", batteryVelocity=" + this.f4501b + ", proximityOn=" + this.f4502c + ", orientation=" + this.f4503d + ", ramUsed=" + this.f4504e + ", diskUsed=" + this.f4505f + "}";
    }
}
