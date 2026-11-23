package com.sonelli;

/* compiled from: SSHKeyParserBuffer.java */
/* loaded from: classes.dex */
public class ik0 {

    /* renamed from: a */
    public final byte[] f3335a;

    /* renamed from: b */
    public int f3336b = 0;

    public ik0(byte[] bArr) {
        this.f3335a = bArr;
    }

    public ik0(byte[] bArr, byte[] bArr2) {
        this.f3335a = bArr2;
        for (int i = 0; i != bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                throw new IllegalArgumentException("magic-number incorrect");
            }
        }
        this.f3336b += bArr.length;
    }

    /* renamed from: a */
    public boolean m4787a() {
        return this.f3336b < this.f3335a.length;
    }

    /* renamed from: b */
    public byte[] m4788b() {
        int m4792f = m4792f();
        if (m4792f == 0) {
            return new byte[0];
        }
        int i = this.f3336b;
        byte[] bArr = this.f3335a;
        if (i > bArr.length - m4792f) {
            throw new IllegalArgumentException("not enough data for block");
        }
        int i2 = m4792f + i;
        this.f3336b = i2;
        return e51.m3441j(bArr, i, i2);
    }

    /* renamed from: c */
    public byte[] m4789c() {
        return m4790d(8);
    }

    /* renamed from: d */
    public byte[] m4790d(int i) {
        int i2;
        int m4792f = m4792f();
        if (m4792f == 0) {
            return new byte[0];
        }
        int i3 = this.f3336b;
        byte[] bArr = this.f3335a;
        if (i3 > bArr.length - m4792f) {
            throw new IllegalArgumentException("not enough data for block");
        }
        if (m4792f % i != 0) {
            throw new IllegalArgumentException("missing padding");
        }
        int i4 = i3 + m4792f;
        this.f3336b = i4;
        if (m4792f > 0 && (i2 = bArr[i4 - 1] & 255) > 0 && i2 < i) {
            i4 -= i2;
            int i5 = 1;
            int i6 = i4;
            while (i5 <= i2) {
                if (i5 != (this.f3335a[i6] & 255)) {
                    throw new IllegalArgumentException("incorrect padding");
                }
                i5++;
                i6++;
            }
        }
        return e51.m3441j(this.f3335a, i3, i4);
    }

    /* renamed from: e */
    public String m4791e() {
        return j51.m5063b(m4788b());
    }

    /* renamed from: f */
    public int m4792f() {
        int i = this.f3336b;
        byte[] bArr = this.f3335a;
        if (i > bArr.length - 4) {
            throw new IllegalArgumentException("4 bytes for U32 exceeds buffer.");
        }
        int i2 = i + 1;
        this.f3336b = i2;
        int i3 = (bArr[i] & 255) << 24;
        int i4 = i2 + 1;
        this.f3336b = i4;
        int i5 = i3 | ((bArr[i2] & 255) << 16);
        int i6 = i4 + 1;
        this.f3336b = i6;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        this.f3336b = i6 + 1;
        return i7 | (bArr[i6] & 255);
    }

    /* renamed from: g */
    public void m4793g() {
        int m4792f = m4792f();
        int i = this.f3336b;
        if (i > this.f3335a.length - m4792f) {
            throw new IllegalArgumentException("not enough data for block");
        }
        this.f3336b = i + m4792f;
    }
}
