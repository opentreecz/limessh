package com.amazonaws.util;

/* loaded from: classes.dex */
public enum Base64 {
    ;


    /* renamed from: O */
    public static final Base64Codec f474O = new Base64Codec();

    /* renamed from: f */
    public static String m641f(byte... bArr) {
        if (bArr == null) {
            return null;
        }
        return bArr.length == 0 ? "" : CodecUtils.m653h(f474O.m642a(bArr));
    }
}
