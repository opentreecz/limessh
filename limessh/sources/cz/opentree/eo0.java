package cz.opentree;

import java.io.IOException;

/* compiled from: Http2.java */
/* loaded from: classes.dex */
public final class eo0 {

    /* renamed from: a */
    public static final ap0 f2515a = ap0.m2233o("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b */
    public static final String[] f2516b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c */
    public static final String[] f2517c = new String[64];

    /* renamed from: d */
    public static final String[] f2518d = new String[256];

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = f2518d;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = fn0.m3837r("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = f2517c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i3 = 0; i3 < 1; i3++) {
            int i4 = iArr[i3];
            String[] strArr3 = f2517c;
            strArr3[i4 | 8] = strArr3[i4] + "|PADDED";
        }
        String[] strArr4 = f2517c;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 < 1; i7++) {
                int i8 = iArr[i7];
                String[] strArr5 = f2517c;
                int i9 = i8 | i6;
                strArr5[i9] = strArr5[i8] + '|' + strArr5[i6];
                strArr5[i9 | 8] = strArr5[i8] + '|' + strArr5[i6] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr6 = f2517c;
            if (i >= strArr6.length) {
                return;
            }
            if (strArr6[i] == null) {
                strArr6[i] = f2518d[i];
            }
            i++;
        }
    }

    /* renamed from: a */
    public static String m3535a(byte b, byte b2) {
        if (b2 == 0) {
            return "";
        }
        if (b != 2 && b != 3) {
            if (b == 4 || b == 6) {
                return b2 == 1 ? "ACK" : f2518d[b2];
            }
            if (b != 7 && b != 8) {
                String[] strArr = f2517c;
                String str = b2 < strArr.length ? strArr[b2] : f2518d[b2];
                return (b != 5 || (b2 & 4) == 0) ? (b != 0 || (b2 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED") : str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f2518d[b2];
    }

    /* renamed from: b */
    public static String m3536b(boolean z, int i, int i2, byte b, byte b2) {
        String[] strArr = f2516b;
        String m3837r = b < strArr.length ? strArr[b] : fn0.m3837r("0x%02x", Byte.valueOf(b));
        String m3535a = m3535a(b, b2);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = m3837r;
        objArr[4] = m3535a;
        return fn0.m3837r("%s 0x%08x %5d %-13s %s", objArr);
    }

    /* renamed from: c */
    public static IllegalArgumentException m3537c(String str, Object... objArr) {
        throw new IllegalArgumentException(fn0.m3837r(str, objArr));
    }

    /* renamed from: d */
    public static IOException m3538d(String str, Object... objArr) throws IOException {
        throw new IOException(fn0.m3837r(str, objArr));
    }
}
