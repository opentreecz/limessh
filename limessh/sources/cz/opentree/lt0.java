package cz.opentree;

import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Memoable;

/* loaded from: classes.dex */
public abstract class lt0 implements ExtendedDigest, Memoable {

    /* renamed from: a */
    public final byte[] f4914a = new byte[4];

    /* renamed from: b */
    public int f4915b = 0;

    /* renamed from: c */
    public long f4916c;

    @Override // org.bouncycastle.crypto.Digest
    /* renamed from: a */
    public void mo6293a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        int max = Math.max(0, i2);
        if (this.f4915b != 0) {
            int i4 = 0;
            while (true) {
                if (i4 >= max) {
                    i3 = i4;
                    break;
                }
                byte[] bArr2 = this.f4914a;
                int i5 = this.f4915b;
                int i6 = i5 + 1;
                this.f4915b = i6;
                int i7 = i4 + 1;
                bArr2[i5] = bArr[i4 + i];
                if (i6 == 4) {
                    mo6298j(bArr2, 0);
                    this.f4915b = 0;
                    i3 = i7;
                    break;
                }
                i4 = i7;
            }
        }
        int i8 = ((max - i3) & (-4)) + i3;
        while (i3 < i8) {
            mo6298j(bArr, i + i3);
            i3 += 4;
        }
        while (i3 < max) {
            byte[] bArr3 = this.f4914a;
            int i9 = this.f4915b;
            this.f4915b = i9 + 1;
            bArr3[i9] = bArr[i3 + i];
            i3++;
        }
        this.f4916c += max;
    }

    @Override // org.bouncycastle.crypto.Digest
    /* renamed from: c */
    public void mo6294c(byte b) {
        byte[] bArr = this.f4914a;
        int i = this.f4915b;
        int i2 = i + 1;
        this.f4915b = i2;
        bArr[i] = b;
        if (i2 == bArr.length) {
            mo6298j(bArr, 0);
            this.f4915b = 0;
        }
        this.f4916c++;
    }

    /* renamed from: g */
    public void m6295g() {
        long j = this.f4916c << 3;
        byte b = Byte.MIN_VALUE;
        while (true) {
            mo6294c(b);
            if (this.f4915b == 0) {
                mo6297i(j);
                mo6296h();
                return;
            }
            b = 0;
        }
    }

    /* renamed from: h */
    public abstract void mo6296h();

    /* renamed from: i */
    public abstract void mo6297i(long j);

    /* renamed from: j */
    public abstract void mo6298j(byte[] bArr, int i);

    /* renamed from: k */
    public void mo6299k() {
        this.f4916c = 0L;
        this.f4915b = 0;
        int i = 0;
        while (true) {
            byte[] bArr = this.f4914a;
            if (i >= bArr.length) {
                return;
            }
            bArr[i] = 0;
            i++;
        }
    }
}
