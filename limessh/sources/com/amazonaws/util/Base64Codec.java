package com.amazonaws.util;

/* loaded from: classes.dex */
public class Base64Codec implements Codec {

    /* renamed from: a */
    public final byte[] f476a = CodecUtils.m652f("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");

    /* renamed from: a */
    public byte[] m642a(byte[] bArr) {
        int length = bArr.length / 3;
        int length2 = bArr.length % 3;
        int i = 0;
        if (length2 == 0) {
            byte[] bArr2 = new byte[length * 4];
            int i2 = 0;
            while (i < bArr.length) {
                m645d(bArr, i, bArr2, i2);
                i += 3;
                i2 += 4;
            }
            return bArr2;
        }
        byte[] bArr3 = new byte[(length + 1) * 4];
        int i3 = 0;
        while (i < bArr.length - length2) {
            m645d(bArr, i, bArr3, i3);
            i += 3;
            i3 += 4;
        }
        if (length2 == 1) {
            m643b(bArr, i, bArr3, i3);
        } else if (length2 == 2) {
            m644c(bArr, i, bArr3, i3);
        }
        return bArr3;
    }

    /* renamed from: b */
    public void m643b(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = i2 + 1;
        byte[] bArr3 = this.f476a;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 2) & 63];
        int i4 = i3 + 1;
        bArr2[i3] = bArr3[(b & 3) << 4];
        bArr2[i4] = 61;
        bArr2[i4 + 1] = 61;
    }

    /* renamed from: c */
    public void m644c(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = i2 + 1;
        byte[] bArr3 = this.f476a;
        int i4 = i + 1;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 2) & 63];
        int i5 = i3 + 1;
        byte b2 = bArr[i4];
        bArr2[i3] = bArr3[((b & 3) << 4) | ((b2 >>> 4) & 15)];
        bArr2[i5] = bArr3[(b2 & 15) << 2];
        bArr2[i5 + 1] = 61;
    }

    /* renamed from: d */
    public void m645d(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = i2 + 1;
        byte[] bArr3 = this.f476a;
        int i4 = i + 1;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 2) & 63];
        int i5 = i3 + 1;
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        bArr2[i3] = bArr3[((b & 3) << 4) | ((b2 >>> 4) & 15)];
        byte b3 = bArr[i6];
        bArr2[i5] = bArr3[((b2 & 15) << 2) | ((b3 >>> 6) & 3)];
        bArr2[i5 + 1] = bArr3[b3 & 63];
    }
}
