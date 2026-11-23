package com.amazonaws.util;

/* loaded from: classes.dex */
public enum CodecUtils {
    ;

    /* renamed from: f */
    public static byte[] m652f(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            char c = charArray[i];
            if (c > 127) {
                throw new IllegalArgumentException("Invalid character found at position " + i + " for " + str);
            }
            bArr[i] = (byte) c;
        }
        return bArr;
    }

    /* renamed from: h */
    public static String m653h(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            cArr[i2] = (char) bArr[i];
            i++;
            i2++;
        }
        return new String(cArr);
    }
}
