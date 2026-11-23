package com.sonelli;

/* loaded from: classes.dex */
public final class iu0 extends vt0 {

    /* renamed from: O */
    public final byte[] f3423O;

    /* renamed from: P */
    public ju0 f3424P;

    public iu0(byte[] bArr, int i) {
        super(true);
        byte[] bArr2 = new byte[32];
        this.f3423O = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, 32);
    }

    /* renamed from: a */
    public ju0 m4927a() {
        ju0 ju0Var;
        synchronized (this.f3423O) {
            if (this.f3424P == null) {
                byte[] bArr = new byte[32];
                yz0.m10298n(this.f3423O, 0, bArr, 0);
                this.f3424P = new ju0(bArr, 0);
            }
            ju0Var = this.f3424P;
        }
        return ju0Var;
    }

    /* renamed from: b */
    public void m4928b(int i, byte[] bArr, byte[] bArr2, int i2, int i3, byte[] bArr3, int i4) {
        byte[] bArr4 = new byte[32];
        m4927a().m5198a(bArr4, 0);
        if (i == 0) {
            if (bArr != null) {
                throw new IllegalArgumentException("ctx");
            }
            yz0.m10282H(this.f3423O, 0, bArr4, 0, bArr2, i2, i3, bArr3, i4);
        } else if (i == 1) {
            yz0.m10283I(this.f3423O, 0, bArr4, 0, bArr, bArr2, i2, i3, bArr3, i4);
        } else {
            if (i != 2) {
                throw new IllegalArgumentException("algorithm");
            }
            if (64 != i3) {
                throw new IllegalArgumentException("msgLen");
            }
            yz0.m10284J(this.f3423O, 0, bArr4, 0, bArr, bArr2, i2, bArr3, i4);
        }
    }
}
