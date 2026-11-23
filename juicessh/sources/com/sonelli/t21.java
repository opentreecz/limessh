package com.sonelli;

import com.sonelli.b31;

/* loaded from: classes.dex */
public final class t21 extends b31 {

    /* renamed from: e */
    public final int f6695e;

    /* renamed from: f */
    public final int f6696f;

    /* renamed from: g */
    public final int f6697g;

    /* renamed from: com.sonelli.t21$b */
    /* loaded from: classes.dex */
    public static class C1897b extends b31.AbstractC0751a<C1897b> {

        /* renamed from: e */
        public int f6698e;

        /* renamed from: f */
        public int f6699f;

        public C1897b() {
            super(2);
            this.f6698e = 0;
            this.f6699f = 0;
        }

        @Override // com.sonelli.b31.AbstractC0751a
        /* renamed from: e */
        public /* bridge */ /* synthetic */ C1897b mo2367e() {
            m8583l();
            return this;
        }

        /* renamed from: k */
        public b31 m8582k() {
            return new t21(this);
        }

        /* renamed from: l */
        public C1897b m8583l() {
            return this;
        }

        /* renamed from: m */
        public C1897b m8584m(int i) {
            this.f6698e = i;
            return this;
        }

        /* renamed from: n */
        public C1897b m8585n(int i) {
            this.f6699f = i;
            return this;
        }
    }

    public t21(C1897b c1897b) {
        super(c1897b);
        this.f6695e = 0;
        this.f6696f = c1897b.f6698e;
        this.f6697g = c1897b.f6699f;
    }

    @Override // com.sonelli.b31
    /* renamed from: d */
    public byte[] mo2362d() {
        byte[] mo2362d = super.mo2362d();
        h51.m4367c(this.f6695e, mo2362d, 16);
        h51.m4367c(this.f6696f, mo2362d, 20);
        h51.m4367c(this.f6697g, mo2362d, 24);
        return mo2362d;
    }

    /* renamed from: e */
    public int m8578e() {
        return this.f6696f;
    }

    /* renamed from: f */
    public int m8579f() {
        return this.f6697g;
    }
}
