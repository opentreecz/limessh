package cz.opentree;

import androidx.media.AudioAttributesCompat;
import jackpal.androidterm.emulatorview.compat.KeycodeConstants;

/* loaded from: classes.dex */
public class q51 {

    /* renamed from: a */
    public static final short[] f5941a = new short[128];

    /* renamed from: b */
    public static final byte[] f5942b;

    static {
        byte[] bArr = new byte[112];
        f5942b = bArr;
        byte[] bArr2 = new byte[128];
        m7625a(bArr2, 0, 15, (byte) 1);
        m7625a(bArr2, 16, 31, (byte) 2);
        m7625a(bArr2, 32, 63, (byte) 3);
        m7625a(bArr2, 64, 65, (byte) 0);
        m7625a(bArr2, 66, 95, (byte) 4);
        m7625a(bArr2, 96, 96, (byte) 5);
        m7625a(bArr2, 97, 108, (byte) 6);
        m7625a(bArr2, 109, 109, (byte) 7);
        m7625a(bArr2, 110, 111, (byte) 6);
        m7625a(bArr2, 112, 112, (byte) 8);
        m7625a(bArr2, 113, 115, (byte) 9);
        m7625a(bArr2, 116, 116, (byte) 10);
        m7625a(bArr2, 117, KeycodeConstants.KEYCODE_MEDIA_PAUSE, (byte) 0);
        m7625a(bArr, 0, bArr.length - 1, (byte) -2);
        m7625a(bArr, 8, 11, (byte) -1);
        m7625a(bArr, 24, 27, (byte) 0);
        m7625a(bArr, 40, 43, (byte) 16);
        m7625a(bArr, 58, 59, (byte) 0);
        m7625a(bArr, 72, 73, (byte) 0);
        m7625a(bArr, 89, 91, (byte) 16);
        m7625a(bArr, 104, 104, (byte) 16);
        byte[] bArr3 = {0, 0, 0, 0, 31, 15, 15, 15, 7, 7, 7};
        byte[] bArr4 = {-2, -2, -2, -2, 0, 48, 16, 64, 80, 32, 96};
        for (int i = 0; i < 128; i++) {
            byte b = bArr2[i];
            f5941a[i] = (short) (bArr4[b] | ((bArr3[b] & i) << 8));
        }
    }

    /* renamed from: a */
    public static void m7625a(byte[] bArr, int i, int i2, byte b) {
        while (i <= i2) {
            bArr[i] = b;
            i++;
        }
    }

    /* renamed from: b */
    public static int m7626b(byte[] bArr, char[] cArr) {
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            int i3 = i + 1;
            byte b = bArr[i];
            if (b < 0) {
                short s = f5941a[b & Byte.MAX_VALUE];
                int i4 = s >>> 8;
                byte b2 = (byte) s;
                while (b2 >= 0) {
                    if (i3 >= bArr.length) {
                        return -1;
                    }
                    int i5 = i3 + 1;
                    byte b3 = bArr[i3];
                    i4 = (i4 << 6) | (b3 & 63);
                    b2 = f5942b[b2 + ((b3 & 255) >>> 4)];
                    i3 = i5;
                }
                if (b2 == -2) {
                    return -1;
                }
                if (i4 <= 65535) {
                    if (i2 >= cArr.length) {
                        return -1;
                    }
                    cArr[i2] = (char) i4;
                    i2++;
                } else {
                    if (i2 >= cArr.length - 1) {
                        return -1;
                    }
                    int i6 = i2 + 1;
                    cArr[i2] = (char) ((i4 >>> 10) + 55232);
                    i2 = i6 + 1;
                    cArr[i6] = (char) (56320 | (i4 & AudioAttributesCompat.FLAG_ALL));
                }
                i = i3;
            } else {
                if (i2 >= cArr.length) {
                    return -1;
                }
                cArr[i2] = (char) b;
                i = i3;
                i2++;
            }
        }
        return i2;
    }
}
