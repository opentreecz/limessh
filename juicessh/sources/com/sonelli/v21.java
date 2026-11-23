package com.sonelli;

import com.sonelli.b31;

/* loaded from: classes.dex */
public final class v21 extends b31 {

    /* renamed from: e */
    public final int f7396e;

    /* renamed from: f */
    public final int f7397f;

    /* renamed from: g */
    public final int f7398g;

    /* renamed from: com.sonelli.v21$b */
    /* loaded from: classes.dex */
    public static class C2150b extends b31.AbstractC0751a<C2150b> {

        /* renamed from: e */
        public int f7399e;

        /* renamed from: f */
        public int f7400f;

        /* renamed from: g */
        public int f7401g;

        public C2150b() {
            super(1);
            this.f7399e = 0;
            this.f7400f = 0;
            this.f7401g = 0;
        }

        @Override // com.sonelli.b31.AbstractC0751a
        /* renamed from: e */
        public /* bridge */ /* synthetic */ C2150b mo2367e() {
            m9154m();
            return this;
        }

        /* renamed from: l */
        public b31 m9153l() {
            return new v21(this);
        }

        /* renamed from: m */
        public C2150b m9154m() {
            return this;
        }

        /* renamed from: n */
        public C2150b m9155n(int i) {
            this.f7399e = i;
            return this;
        }

        /* renamed from: o */
        public C2150b m9156o(int i) {
            this.f7400f = i;
            return this;
        }

        /* renamed from: p */
        public C2150b m9157p(int i) {
            this.f7401g = i;
            return this;
        }
    }

    public v21(C2150b c2150b) {
        super(c2150b);
        this.f7396e = c2150b.f7399e;
        this.f7397f = c2150b.f7400f;
        this.f7398g = c2150b.f7401g;
    }

    @Override // com.sonelli.b31
    /* renamed from: d */
    public byte[] mo2362d() {
        byte[] mo2362d = super.mo2362d();
        h51.m4367c(this.f7396e, mo2362d, 16);
        h51.m4367c(this.f7397f, mo2362d, 20);
        h51.m4367c(this.f7398g, mo2362d, 24);
        return mo2362d;
    }

    /* renamed from: e */
    public int m9147e() {
        return this.f7396e;
    }

    /* renamed from: f */
    public int m9148f() {
        return this.f7397f;
    }

    /* renamed from: g */
    public int m9149g() {
        return this.f7398g;
    }
}
