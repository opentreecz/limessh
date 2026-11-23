package cz.opentree;

import cz.opentree.b31;

/* loaded from: classes.dex */
public final class w21 extends b31 {

    /* renamed from: e */
    public final int f7607e;

    /* renamed from: f */
    public final int f7608f;

    /* renamed from: g */
    public final int f7609g;

    /* renamed from: cz.opentree.w21$b */
    /* loaded from: classes.dex */
    public static class C2198b extends b31.AbstractC0751a<C2198b> {

        /* renamed from: e */
        public int f7610e;

        /* renamed from: f */
        public int f7611f;

        /* renamed from: g */
        public int f7612g;

        public C2198b() {
            super(0);
            this.f7610e = 0;
            this.f7611f = 0;
            this.f7612g = 0;
        }

        @Override // cz.opentree.b31.AbstractC0751a
        /* renamed from: e */
        public /* bridge */ /* synthetic */ C2198b mo2367e() {
            m9397m();
            return this;
        }

        /* renamed from: l */
        public b31 m9396l() {
            return new w21(this);
        }

        /* renamed from: m */
        public C2198b m9397m() {
            return this;
        }

        /* renamed from: n */
        public C2198b m9398n(int i) {
            this.f7611f = i;
            return this;
        }

        /* renamed from: o */
        public C2198b m9399o(int i) {
            this.f7612g = i;
            return this;
        }

        /* renamed from: p */
        public C2198b m9400p(int i) {
            this.f7610e = i;
            return this;
        }
    }

    public w21(C2198b c2198b) {
        super(c2198b);
        this.f7607e = c2198b.f7610e;
        this.f7608f = c2198b.f7611f;
        this.f7609g = c2198b.f7612g;
    }

    @Override // cz.opentree.b31
    /* renamed from: d */
    public byte[] mo2362d() {
        byte[] mo2362d = super.mo2362d();
        h51.m4367c(this.f7607e, mo2362d, 16);
        h51.m4367c(this.f7608f, mo2362d, 20);
        h51.m4367c(this.f7609g, mo2362d, 24);
        return mo2362d;
    }

    /* renamed from: e */
    public int m9390e() {
        return this.f7608f;
    }

    /* renamed from: f */
    public int m9391f() {
        return this.f7609g;
    }

    /* renamed from: g */
    public int m9392g() {
        return this.f7607e;
    }
}
