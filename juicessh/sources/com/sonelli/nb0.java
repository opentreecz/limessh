package com.sonelli;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class nb0 {

    /* renamed from: a */
    public final byte[] f5246a;

    /* renamed from: b */
    public volatile int f5247b = 0;

    public nb0(byte[] bArr) {
        this.f5246a = bArr;
    }

    /* renamed from: a */
    public static nb0 m6657a(byte[] bArr) {
        return m6658b(bArr, 0, bArr.length);
    }

    /* renamed from: b */
    public static nb0 m6658b(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new nb0(bArr2);
    }

    /* renamed from: c */
    public static nb0 m6659c(String str) {
        try {
            return new nb0(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    /* renamed from: d */
    public void m6660d(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f5246a, i, bArr, i2, i3);
    }

    /* renamed from: e */
    public InputStream m6661e() {
        return new ByteArrayInputStream(this.f5246a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof nb0)) {
            return false;
        }
        byte[] bArr = this.f5246a;
        int length = bArr.length;
        byte[] bArr2 = ((nb0) obj).f5246a;
        if (length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public int m6662f() {
        return this.f5246a.length;
    }

    public int hashCode() {
        int i = this.f5247b;
        if (i == 0) {
            byte[] bArr = this.f5246a;
            int length = bArr.length;
            for (byte b : bArr) {
                length = (length * 31) + b;
            }
            i = length == 0 ? 1 : length;
            this.f5247b = i;
        }
        return i;
    }
}
