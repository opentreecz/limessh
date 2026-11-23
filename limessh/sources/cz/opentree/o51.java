package cz.opentree;

import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public class o51 {

    /* renamed from: a */
    public static final p51 f5435a = new p51();

    /* renamed from: a */
    public static byte[] m6872a(String str) {
        try {
            return f5435a.m7247b(str, 0, str.length());
        } catch (Exception e) {
            throw new m51("exception decoding Hex string: " + e.getMessage(), e);
        }
    }

    /* renamed from: b */
    public static byte[] m6873b(byte[] bArr) {
        return m6874c(bArr, 0, bArr.length);
    }

    /* renamed from: c */
    public static byte[] m6874c(byte[] bArr, int i, int i2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f5435a.m7248c(bArr, i, i2, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new n51("exception encoding Hex string: " + e.getMessage(), e);
        }
    }

    /* renamed from: d */
    public static String m6875d(byte[] bArr) {
        return m6876e(bArr, 0, bArr.length);
    }

    /* renamed from: e */
    public static String m6876e(byte[] bArr, int i, int i2) {
        return j51.m5063b(m6874c(bArr, i, i2));
    }
}
