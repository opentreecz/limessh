package cz.opentree;

import org.bouncycastle.crypto.Digest;

/* loaded from: classes.dex */
public class q11 {

    /* renamed from: a */
    public final byte[] f5913a;

    /* renamed from: b */
    public final byte[] f5914b;

    /* renamed from: c */
    public final Digest f5915c;

    /* renamed from: d */
    public int f5916d;

    /* renamed from: e */
    public int f5917e;

    public q11(byte[] bArr, byte[] bArr2, Digest digest) {
        this.f5913a = bArr;
        this.f5914b = bArr2;
        this.f5915c = digest;
    }

    /* renamed from: a */
    public void m7599a(byte[] bArr, boolean z, int i) {
        m7600b(bArr, i);
        if (z) {
            this.f5917e++;
        }
    }

    /* renamed from: b */
    public byte[] m7600b(byte[] bArr, int i) {
        if (bArr.length < this.f5915c.mo6519f()) {
            throw new IllegalArgumentException("target length is less than digest size.");
        }
        Digest digest = this.f5915c;
        byte[] bArr2 = this.f5913a;
        digest.mo6293a(bArr2, 0, bArr2.length);
        this.f5915c.mo6294c((byte) (this.f5916d >>> 24));
        this.f5915c.mo6294c((byte) (this.f5916d >>> 16));
        this.f5915c.mo6294c((byte) (this.f5916d >>> 8));
        this.f5915c.mo6294c((byte) this.f5916d);
        this.f5915c.mo6294c((byte) (this.f5917e >>> 8));
        this.f5915c.mo6294c((byte) this.f5917e);
        this.f5915c.mo6294c((byte) -1);
        Digest digest2 = this.f5915c;
        byte[] bArr3 = this.f5914b;
        digest2.mo6293a(bArr3, 0, bArr3.length);
        this.f5915c.mo7096b(bArr, i);
        return bArr;
    }

    /* renamed from: c */
    public void m7601c(int i) {
        this.f5917e = i;
    }

    /* renamed from: d */
    public void m7602d(int i) {
        this.f5916d = i;
    }
}
