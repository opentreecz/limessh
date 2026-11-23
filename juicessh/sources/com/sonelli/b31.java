package com.sonelli;

/* loaded from: classes.dex */
public abstract class b31 {

    /* renamed from: a */
    public final int f1598a;

    /* renamed from: b */
    public final long f1599b;

    /* renamed from: c */
    public final int f1600c;

    /* renamed from: d */
    public final int f1601d;

    /* renamed from: com.sonelli.b31$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0751a<T extends AbstractC0751a> {

        /* renamed from: a */
        public final int f1602a;

        /* renamed from: b */
        public int f1603b = 0;

        /* renamed from: c */
        public long f1604c = 0;

        /* renamed from: d */
        public int f1605d = 0;

        public AbstractC0751a(int i) {
            this.f1602a = i;
        }

        /* renamed from: e */
        public abstract T mo2367e();

        /* renamed from: f */
        public T m2368f(int i) {
            this.f1605d = i;
            return mo2367e();
        }

        /* renamed from: g */
        public T m2369g(int i) {
            this.f1603b = i;
            return mo2367e();
        }

        /* renamed from: h */
        public T m2370h(long j) {
            this.f1604c = j;
            return mo2367e();
        }
    }

    public b31(AbstractC0751a abstractC0751a) {
        this.f1598a = abstractC0751a.f1603b;
        this.f1599b = abstractC0751a.f1604c;
        this.f1600c = abstractC0751a.f1602a;
        this.f1601d = abstractC0751a.f1605d;
    }

    /* renamed from: a */
    public final int m2359a() {
        return this.f1601d;
    }

    /* renamed from: b */
    public final int m2360b() {
        return this.f1598a;
    }

    /* renamed from: c */
    public final long m2361c() {
        return this.f1599b;
    }

    /* renamed from: d */
    public byte[] mo2362d() {
        byte[] bArr = new byte[32];
        h51.m4367c(this.f1598a, bArr, 0);
        h51.m4372h(this.f1599b, bArr, 4);
        h51.m4367c(this.f1600c, bArr, 12);
        h51.m4367c(this.f1601d, bArr, 28);
        return bArr;
    }
}
