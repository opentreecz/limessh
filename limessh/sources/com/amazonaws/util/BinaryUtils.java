package com.amazonaws.util;

/* loaded from: classes.dex */
public class BinaryUtils {
    /* renamed from: a */
    public static String m646a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b);
            if (hexString.length() == 1) {
                sb.append("0");
            } else if (hexString.length() == 8) {
                hexString = hexString.substring(6);
            }
            sb.append(hexString);
        }
        return StringUtils.m679d(sb.toString());
    }
}
