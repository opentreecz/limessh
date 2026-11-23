package com.sonelli;

/* loaded from: classes.dex */
public class d21 {

    /* renamed from: a */
    public int f2110a;

    /* renamed from: b */
    public int f2111b;

    /* renamed from: c */
    public int f2112c;

    /* renamed from: d */
    public short[][][] f2113d;

    /* renamed from: e */
    public short[][][] f2114e;

    /* renamed from: f */
    public short[][] f2115f;

    /* renamed from: g */
    public short[] f2116g;

    public d21(byte b, byte b2, short[][][] sArr, short[][][] sArr2, short[][] sArr3, short[] sArr4) {
        int i = b & 255;
        this.f2110a = i;
        int i2 = b2 & 255;
        this.f2111b = i2;
        this.f2112c = i2 - i;
        this.f2113d = sArr;
        this.f2114e = sArr2;
        this.f2115f = sArr3;
        this.f2116g = sArr4;
    }

    /* renamed from: a */
    public short[][][] m3104a() {
        return this.f2113d;
    }

    /* renamed from: b */
    public short[][][] m3105b() {
        return this.f2114e;
    }

    /* renamed from: c */
    public short[] m3106c() {
        return this.f2116g;
    }

    /* renamed from: d */
    public short[][] m3107d() {
        return this.f2115f;
    }

    /* renamed from: e */
    public int m3108e() {
        return this.f2112c;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof d21)) {
            return false;
        }
        d21 d21Var = (d21) obj;
        return this.f2110a == d21Var.m3109f() && this.f2111b == d21Var.m3110g() && this.f2112c == d21Var.m3108e() && e21.m3394k(this.f2113d, d21Var.m3104a()) && e21.m3394k(this.f2114e, d21Var.m3105b()) && e21.m3393j(this.f2115f, d21Var.m3107d()) && e21.m3392i(this.f2116g, d21Var.m3106c());
    }

    /* renamed from: f */
    public int m3109f() {
        return this.f2110a;
    }

    /* renamed from: g */
    public int m3110g() {
        return this.f2111b;
    }

    public int hashCode() {
        return (((((((((((this.f2110a * 37) + this.f2111b) * 37) + this.f2112c) * 37) + e51.m3453v(this.f2113d)) * 37) + e51.m3453v(this.f2114e)) * 37) + e51.m3452u(this.f2115f)) * 37) + e51.m3451t(this.f2116g);
    }
}
