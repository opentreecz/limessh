package com.sonelli;

import java.util.Objects;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Xof;

/* loaded from: classes.dex */
public final class u21 {

    /* renamed from: a */
    public final Digest f6911a;

    /* renamed from: b */
    public final int f6912b;

    public u21(aq0 aq0Var, int i) {
        Objects.requireNonNull(aq0Var, "digest == null");
        this.f6911a = s21.m8307a(aq0Var);
        this.f6912b = i;
    }

    /* renamed from: a */
    public byte[] m8834a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = this.f6912b;
        if (length != i) {
            throw new IllegalArgumentException("wrong key length");
        }
        if (bArr2.length == i) {
            return m8837d(0, bArr, bArr2);
        }
        throw new IllegalArgumentException("wrong in length");
    }

    /* renamed from: b */
    public byte[] m8835b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = this.f6912b;
        if (length != i) {
            throw new IllegalArgumentException("wrong key length");
        }
        if (bArr2.length == i * 2) {
            return m8837d(1, bArr, bArr2);
        }
        throw new IllegalArgumentException("wrong in length");
    }

    /* renamed from: c */
    public byte[] m8836c(byte[] bArr, byte[] bArr2) {
        if (bArr.length != this.f6912b) {
            throw new IllegalArgumentException("wrong key length");
        }
        if (bArr2.length == 32) {
            return m8837d(3, bArr, bArr2);
        }
        throw new IllegalArgumentException("wrong address length");
    }

    /* renamed from: d */
    public final byte[] m8837d(int i, byte[] bArr, byte[] bArr2) {
        byte[] m6367q = m31.m6367q(i, this.f6912b);
        this.f6911a.mo6293a(m6367q, 0, m6367q.length);
        this.f6911a.mo6293a(bArr, 0, bArr.length);
        this.f6911a.mo6293a(bArr2, 0, bArr2.length);
        int i2 = this.f6912b;
        byte[] bArr3 = new byte[i2];
        Digest digest = this.f6911a;
        if (digest instanceof Xof) {
            ((Xof) digest).mo8811d(bArr3, 0, i2);
        } else {
            digest.mo7096b(bArr3, 0);
        }
        return bArr3;
    }
}
