package com.sonelli;

/* loaded from: classes.dex */
public final class ju0 extends vt0 {

    /* renamed from: O */
    public final byte[] f3659O;

    public ju0(byte[] bArr, int i) {
        super(false);
        byte[] bArr2 = new byte[32];
        this.f3659O = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, 32);
    }

    /* renamed from: a */
    public void m5198a(byte[] bArr, int i) {
        System.arraycopy(this.f3659O, 0, bArr, i, 32);
    }
}
