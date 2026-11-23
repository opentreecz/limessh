package cz.opentree;

import java.security.PrivilegedAction;

/* loaded from: classes.dex */
public final class j51 {

    /* renamed from: cz.opentree.j51$a */
    /* loaded from: classes.dex */
    public static class C1197a implements PrivilegedAction<String> {
        @Override // java.security.PrivilegedAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String run() {
            return System.getProperty("line.separator");
        }
    }

    static {
        try {
            try {
            } catch (Exception unused) {
                String.format("%n", new Object[0]);
            }
        } catch (Exception unused2) {
        }
    }

    /* renamed from: a */
    public static char[] m5062a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i != length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        return cArr;
    }

    /* renamed from: b */
    public static String m5063b(byte[] bArr) {
        return new String(m5062a(bArr));
    }

    /* renamed from: c */
    public static String m5064c(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        int m7626b = q51.m7626b(bArr, cArr);
        if (m7626b >= 0) {
            return new String(cArr, 0, m7626b);
        }
        throw new IllegalArgumentException("Invalid UTF-8 input");
    }

    /* renamed from: d */
    public static byte[] m5065d(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    /* renamed from: e */
    public static String m5066e(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c = charArray[i];
            if ('A' <= c && 'Z' >= c) {
                charArray[i] = (char) ((c - 'A') + 97);
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }

    /* renamed from: f */
    public static String m5067f(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c = charArray[i];
            if ('a' <= c && 'z' >= c) {
                charArray[i] = (char) ((c - 'a') + 65);
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }
}
