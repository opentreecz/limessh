package cz.opentree;

import androidx.annotation.NonNull;
import cz.opentree.oa0;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class ba0 extends oa0.AbstractC1645d.c {

    /* renamed from: a */
    public final int f1618a;

    /* renamed from: b */
    public final String f1619b;

    /* renamed from: c */
    public final int f1620c;

    /* renamed from: d */
    public final long f1621d;

    /* renamed from: e */
    public final long f1622e;

    /* renamed from: f */
    public final boolean f1623f;

    /* renamed from: g */
    public final int f1624g;

    /* renamed from: h */
    public final String f1625h;

    /* renamed from: i */
    public final String f1626i;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.ba0$b */
    /* loaded from: classes.dex */
    public static final class C0760b extends oa0.AbstractC1645d.c.a {

        /* renamed from: a */
        public Integer f1627a;

        /* renamed from: b */
        public String f1628b;

        /* renamed from: c */
        public Integer f1629c;

        /* renamed from: d */
        public Long f1630d;

        /* renamed from: e */
        public Long f1631e;

        /* renamed from: f */
        public Boolean f1632f;

        /* renamed from: g */
        public Integer f1633g;

        /* renamed from: h */
        public String f1634h;

        /* renamed from: i */
        public String f1635i;

        @Override // cz.opentree.oa0.AbstractC1645d.c.a
        /* renamed from: a */
        public oa0.AbstractC1645d.c mo2417a() {
            String str = "";
            if (this.f1627a == null) {
                str = " arch";
            }
            if (this.f1628b == null) {
                str = str + " model";
            }
            if (this.f1629c == null) {
                str = str + " cores";
            }
            if (this.f1630d == null) {
                str = str + " ram";
            }
            if (this.f1631e == null) {
                str = str + " diskSpace";
            }
            if (this.f1632f == null) {
                str = str + " simulator";
            }
            if (this.f1633g == null) {
                str = str + " state";
            }
            if (this.f1634h == null) {
                str = str + " manufacturer";
            }
            if (this.f1635i == null) {
                str = str + " modelClass";
            }
            if (str.isEmpty()) {
                return new ba0(this.f1627a.intValue(), this.f1628b, this.f1629c.intValue(), this.f1630d.longValue(), this.f1631e.longValue(), this.f1632f.booleanValue(), this.f1633g.intValue(), this.f1634h, this.f1635i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // cz.opentree.oa0.AbstractC1645d.c.a
        /* renamed from: b */
        public oa0.AbstractC1645d.c.a mo2418b(int i) {
            this.f1627a = Integer.valueOf(i);
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1645d.c.a
        /* renamed from: c */
        public oa0.AbstractC1645d.c.a mo2419c(int i) {
            this.f1629c = Integer.valueOf(i);
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1645d.c.a
        /* renamed from: d */
        public oa0.AbstractC1645d.c.a mo2420d(long j) {
            this.f1631e = Long.valueOf(j);
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1645d.c.a
        /* renamed from: e */
        public oa0.AbstractC1645d.c.a mo2421e(String str) {
            Objects.requireNonNull(str, "Null manufacturer");
            this.f1634h = str;
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1645d.c.a
        /* renamed from: f */
        public oa0.AbstractC1645d.c.a mo2422f(String str) {
            Objects.requireNonNull(str, "Null model");
            this.f1628b = str;
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1645d.c.a
        /* renamed from: g */
        public oa0.AbstractC1645d.c.a mo2423g(String str) {
            Objects.requireNonNull(str, "Null modelClass");
            this.f1635i = str;
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1645d.c.a
        /* renamed from: h */
        public oa0.AbstractC1645d.c.a mo2424h(long j) {
            this.f1630d = Long.valueOf(j);
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1645d.c.a
        /* renamed from: i */
        public oa0.AbstractC1645d.c.a mo2425i(boolean z) {
            this.f1632f = Boolean.valueOf(z);
            return this;
        }

        @Override // cz.opentree.oa0.AbstractC1645d.c.a
        /* renamed from: j */
        public oa0.AbstractC1645d.c.a mo2426j(int i) {
            this.f1633g = Integer.valueOf(i);
            return this;
        }
    }

    public ba0(int i, String str, int i2, long j, long j2, boolean z, int i3, String str2, String str3) {
        this.f1618a = i;
        this.f1619b = str;
        this.f1620c = i2;
        this.f1621d = j;
        this.f1622e = j2;
        this.f1623f = z;
        this.f1624g = i3;
        this.f1625h = str2;
        this.f1626i = str3;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.c
    @NonNull
    /* renamed from: b */
    public int mo2408b() {
        return this.f1618a;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.c
    /* renamed from: c */
    public int mo2409c() {
        return this.f1620c;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.c
    /* renamed from: d */
    public long mo2410d() {
        return this.f1622e;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.c
    @NonNull
    /* renamed from: e */
    public String mo2411e() {
        return this.f1625h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof oa0.AbstractC1645d.c)) {
            return false;
        }
        oa0.AbstractC1645d.c cVar = (oa0.AbstractC1645d.c) obj;
        return this.f1618a == cVar.mo2408b() && this.f1619b.equals(cVar.mo2412f()) && this.f1620c == cVar.mo2409c() && this.f1621d == cVar.mo2414h() && this.f1622e == cVar.mo2410d() && this.f1623f == cVar.mo2416j() && this.f1624g == cVar.mo2415i() && this.f1625h.equals(cVar.mo2411e()) && this.f1626i.equals(cVar.mo2413g());
    }

    @Override // cz.opentree.oa0.AbstractC1645d.c
    @NonNull
    /* renamed from: f */
    public String mo2412f() {
        return this.f1619b;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.c
    @NonNull
    /* renamed from: g */
    public String mo2413g() {
        return this.f1626i;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.c
    /* renamed from: h */
    public long mo2414h() {
        return this.f1621d;
    }

    public int hashCode() {
        int hashCode = (((((this.f1618a ^ 1000003) * 1000003) ^ this.f1619b.hashCode()) * 1000003) ^ this.f1620c) * 1000003;
        long j = this.f1621d;
        int i = (hashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.f1622e;
        return ((((((((i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ (this.f1623f ? 1231 : 1237)) * 1000003) ^ this.f1624g) * 1000003) ^ this.f1625h.hashCode()) * 1000003) ^ this.f1626i.hashCode();
    }

    @Override // cz.opentree.oa0.AbstractC1645d.c
    /* renamed from: i */
    public int mo2415i() {
        return this.f1624g;
    }

    @Override // cz.opentree.oa0.AbstractC1645d.c
    /* renamed from: j */
    public boolean mo2416j() {
        return this.f1623f;
    }

    public String toString() {
        return "Device{arch=" + this.f1618a + ", model=" + this.f1619b + ", cores=" + this.f1620c + ", ram=" + this.f1621d + ", diskSpace=" + this.f1622e + ", simulator=" + this.f1623f + ", state=" + this.f1624g + ", manufacturer=" + this.f1625h + ", modelClass=" + this.f1626i + "}";
    }
}
