package cz.opentree;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class su0 {

    /* renamed from: a */
    public final byte[] f6594a;

    /* renamed from: b */
    public int f6595b = 0;

    public su0(byte[] bArr) {
        this.f6594a = bArr;
    }

    /* renamed from: a */
    public boolean m8487a() {
        return this.f6595b < this.f6594a.length;
    }

    /* renamed from: b */
    public BigInteger m8488b() {
        int m8491e = m8491e();
        int i = this.f6595b;
        int i2 = i + m8491e;
        byte[] bArr = this.f6594a;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("not enough data for big num");
        }
        int i3 = m8491e + i;
        this.f6595b = i3;
        return new BigInteger(1, e51.m3441j(bArr, i, i3));
    }

    /* renamed from: c */
    public byte[] m8489c() {
        int m8491e = m8491e();
        if (m8491e == 0) {
            return new byte[0];
        }
        int i = this.f6595b;
        byte[] bArr = this.f6594a;
        if (i > bArr.length - m8491e) {
            throw new IllegalArgumentException("not enough data for block");
        }
        int i2 = m8491e + i;
        this.f6595b = i2;
        return e51.m3441j(bArr, i, i2);
    }

    /* renamed from: d */
    public String m8490d() {
        return j51.m5063b(m8489c());
    }

    /* renamed from: e */
    public int m8491e() {
        int i = this.f6595b;
        byte[] bArr = this.f6594a;
        if (i > bArr.length - 4) {
            throw new IllegalArgumentException("4 bytes for U32 exceeds buffer.");
        }
        int i2 = i + 1;
        this.f6595b = i2;
        int i3 = (bArr[i] & 255) << 24;
        int i4 = i2 + 1;
        this.f6595b = i4;
        int i5 = i3 | ((bArr[i2] & 255) << 16);
        int i6 = i4 + 1;
        this.f6595b = i6;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        this.f6595b = i6 + 1;
        return i7 | (bArr[i6] & 255);
    }
}
