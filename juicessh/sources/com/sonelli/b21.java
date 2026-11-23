package com.sonelli;

/* loaded from: classes.dex */
public final class b21 extends vt0 {

    /* renamed from: O */
    public int f1593O;

    /* renamed from: P */
    public byte[] f1594P;

    public b21(int i, byte[] bArr) {
        super(false);
        if (bArr.length != c21.m2660c(i)) {
            throw new IllegalArgumentException("invalid key size for security category");
        }
        this.f1593O = i;
        this.f1594P = e51.m3436e(bArr);
    }

    /* renamed from: a */
    public byte[] m2356a() {
        return e51.m3436e(this.f1594P);
    }

    /* renamed from: b */
    public int m2357b() {
        return this.f1593O;
    }
}
