package com.sonelli;

import java.io.IOException;

/* loaded from: classes.dex */
public class br0 extends vp0 {
    public br0(byte[] bArr) {
        super(bArr);
    }

    @Override // com.sonelli.vp0, com.sonelli.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        cq0Var.m2968n(z, 24, m2599x());
    }

    @Override // com.sonelli.vp0, com.sonelli.eq0
    /* renamed from: n */
    public int mo2261n() {
        int length = m2599x().length;
        return ks0.m5992a(length) + 1 + length;
    }

    @Override // com.sonelli.vp0, com.sonelli.eq0
    /* renamed from: r */
    public eq0 mo2596r() {
        return this;
    }

    @Override // com.sonelli.vp0, com.sonelli.eq0
    /* renamed from: s */
    public eq0 mo2597s() {
        return this;
    }

    /* renamed from: x */
    public final byte[] m2599x() {
        byte[] bArr = this.f7544O;
        if (bArr[bArr.length - 1] != 90) {
            return bArr;
        }
        if (!m9336u()) {
            byte[] bArr2 = this.f7544O;
            byte[] bArr3 = new byte[bArr2.length + 4];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length - 1);
            System.arraycopy(j51.m5065d("0000Z"), 0, bArr3, this.f7544O.length - 1, 5);
            return bArr3;
        }
        if (!m9337v()) {
            byte[] bArr4 = this.f7544O;
            byte[] bArr5 = new byte[bArr4.length + 2];
            System.arraycopy(bArr4, 0, bArr5, 0, bArr4.length - 1);
            System.arraycopy(j51.m5065d("00Z"), 0, bArr5, this.f7544O.length - 1, 3);
            return bArr5;
        }
        if (!m9335t()) {
            return this.f7544O;
        }
        int length = this.f7544O.length - 2;
        while (length > 0 && this.f7544O[length] == 48) {
            length--;
        }
        byte[] bArr6 = this.f7544O;
        if (bArr6[length] == 46) {
            byte[] bArr7 = new byte[length + 1];
            System.arraycopy(bArr6, 0, bArr7, 0, length);
            bArr7[length] = 90;
            return bArr7;
        }
        byte[] bArr8 = new byte[length + 2];
        int i = length + 1;
        System.arraycopy(bArr6, 0, bArr8, 0, i);
        bArr8[i] = 90;
        return bArr8;
    }
}
