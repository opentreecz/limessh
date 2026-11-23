package cz.opentree;

import javax.annotation.Nullable;

/* compiled from: Segment.java */
/* loaded from: classes.dex */
public final class jp0 {

    /* renamed from: a */
    public final byte[] f3638a;

    /* renamed from: b */
    public int f3639b;

    /* renamed from: c */
    public int f3640c;

    /* renamed from: d */
    public boolean f3641d;

    /* renamed from: e */
    public boolean f3642e;

    /* renamed from: f */
    public jp0 f3643f;

    /* renamed from: g */
    public jp0 f3644g;

    public jp0() {
        this.f3638a = new byte[8192];
        this.f3642e = true;
        this.f3641d = false;
    }

    public jp0(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f3638a = bArr;
        this.f3639b = i;
        this.f3640c = i2;
        this.f3641d = z;
        this.f3642e = z2;
    }

    /* renamed from: a */
    public final void m5181a() {
        jp0 jp0Var = this.f3644g;
        if (jp0Var == this) {
            throw new IllegalStateException();
        }
        if (jp0Var.f3642e) {
            int i = this.f3640c - this.f3639b;
            if (i > (8192 - jp0Var.f3640c) + (jp0Var.f3641d ? 0 : jp0Var.f3639b)) {
                return;
            }
            m5186f(jp0Var, i);
            m5182b();
            kp0.m5987a(this);
        }
    }

    @Nullable
    /* renamed from: b */
    public final jp0 m5182b() {
        jp0 jp0Var = this.f3643f;
        jp0 jp0Var2 = jp0Var != this ? jp0Var : null;
        jp0 jp0Var3 = this.f3644g;
        jp0Var3.f3643f = jp0Var;
        this.f3643f.f3644g = jp0Var3;
        this.f3643f = null;
        this.f3644g = null;
        return jp0Var2;
    }

    /* renamed from: c */
    public final jp0 m5183c(jp0 jp0Var) {
        jp0Var.f3644g = this;
        jp0Var.f3643f = this.f3643f;
        this.f3643f.f3644g = jp0Var;
        this.f3643f = jp0Var;
        return jp0Var;
    }

    /* renamed from: d */
    public final jp0 m5184d() {
        this.f3641d = true;
        return new jp0(this.f3638a, this.f3639b, this.f3640c, true, false);
    }

    /* renamed from: e */
    public final jp0 m5185e(int i) {
        jp0 m5988b;
        if (i <= 0 || i > this.f3640c - this.f3639b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            m5988b = m5184d();
        } else {
            m5988b = kp0.m5988b();
            System.arraycopy(this.f3638a, this.f3639b, m5988b.f3638a, 0, i);
        }
        m5988b.f3640c = m5988b.f3639b + i;
        this.f3639b += i;
        this.f3644g.m5183c(m5988b);
        return m5988b;
    }

    /* renamed from: f */
    public final void m5186f(jp0 jp0Var, int i) {
        if (!jp0Var.f3642e) {
            throw new IllegalArgumentException();
        }
        int i2 = jp0Var.f3640c;
        if (i2 + i > 8192) {
            if (jp0Var.f3641d) {
                throw new IllegalArgumentException();
            }
            int i3 = jp0Var.f3639b;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jp0Var.f3638a;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            jp0Var.f3640c -= jp0Var.f3639b;
            jp0Var.f3639b = 0;
        }
        System.arraycopy(this.f3638a, this.f3639b, jp0Var.f3638a, jp0Var.f3640c, i);
        jp0Var.f3640c += i;
        this.f3639b += i;
    }
}
