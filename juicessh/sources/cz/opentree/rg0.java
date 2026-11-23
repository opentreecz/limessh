package cz.opentree;

/* compiled from: Hex.java */
/* loaded from: classes.dex */
public class rg0 {

    /* renamed from: a */
    public static final char[] f6209a = "0123456789abcdef".toCharArray();

    /* renamed from: a */
    public static String m7903a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = f6209a;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }
}
