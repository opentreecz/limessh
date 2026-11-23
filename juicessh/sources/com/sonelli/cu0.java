package com.sonelli;

/* loaded from: classes.dex */
public class cu0 {

    /* renamed from: a */
    public byte[] f2056a;

    /* renamed from: b */
    public int f2057b;

    public cu0(byte[] bArr, int i) {
        this(bArr, i, -1);
    }

    public cu0(byte[] bArr, int i, int i2) {
        this.f2056a = e51.m3436e(bArr);
        this.f2057b = i;
    }

    /* renamed from: a */
    public int m3044a() {
        return this.f2057b;
    }

    /* renamed from: b */
    public byte[] m3045b() {
        return e51.m3436e(this.f2056a);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof cu0)) {
            return false;
        }
        cu0 cu0Var = (cu0) obj;
        if (cu0Var.f2057b != this.f2057b) {
            return false;
        }
        return e51.m3432a(this.f2056a, cu0Var.f2056a);
    }

    public int hashCode() {
        return this.f2057b ^ e51.m3445n(this.f2056a);
    }
}
