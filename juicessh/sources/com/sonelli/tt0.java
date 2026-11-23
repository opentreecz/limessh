package com.sonelli;

import org.bouncycastle.crypto.Xof;

/* loaded from: classes.dex */
public class tt0 extends mt0 implements Xof {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tt0(int i) {
        super(i);
        m8810q(i);
    }

    /* renamed from: q */
    public static int m8810q(int i) {
        if (i == 128 || i == 256) {
            return i;
        }
        throw new IllegalArgumentException("'bitLength' " + i + " not supported for SHAKE");
    }

    @Override // org.bouncycastle.crypto.Digest
    /* renamed from: b */
    public int mo7096b(byte[] bArr, int i) {
        int mo6519f = mo6519f();
        mo8811d(bArr, i, mo6519f);
        return mo6519f;
    }

    @Override // org.bouncycastle.crypto.Xof
    /* renamed from: d */
    public int mo8811d(byte[] bArr, int i, int i2) {
        m8812r(bArr, i, i2);
        m6528o();
        return i2;
    }

    @Override // org.bouncycastle.crypto.Digest
    /* renamed from: e */
    public String mo7097e() {
        return "SHAKE" + this.f5144e;
    }

    /* renamed from: r */
    public int m8812r(byte[] bArr, int i, int i2) {
        if (!this.f5145f) {
            m6524k(15, 4);
        }
        m6529p(bArr, i, i2 * 8);
        return i2;
    }
}
