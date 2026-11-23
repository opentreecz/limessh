package cz.opentree;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import java.io.UnsupportedEncodingException;

/* compiled from: Util.java */
/* loaded from: classes.dex */
public class tk0 {
    /* renamed from: a */
    public static String m8746a(byte[] bArr) {
        return m8747b(bArr, 0, bArr.length, "UTF-8");
    }

    /* renamed from: b */
    public static String m8747b(byte[] bArr, int i, int i2, String str) {
        try {
            return new String(bArr, i, i2, str);
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr, i, i2);
        }
    }

    /* renamed from: c */
    public static boolean m8748c(byte[] bArr, int i, byte[] bArr2, int i2) {
        int m8756k;
        int length = bArr.length;
        if (length == 0) {
            return false;
        }
        int length2 = bArr2.length;
        while (i < length && i2 < length2) {
            if (bArr[i] == 92) {
                int i3 = i + 1;
                if (i3 == length || bArr[i3] != bArr2[i2]) {
                    return false;
                }
                i = i3 + m8756k(bArr[i3]);
                m8756k = m8756k(bArr2[i2]);
            } else {
                if (bArr[i] == 42) {
                    while (i < length && bArr[i] == 42) {
                        i++;
                    }
                    if (length == i) {
                        return true;
                    }
                    byte b = bArr[i];
                    if (b == 63) {
                        while (i2 < length2) {
                            if (m8748c(bArr, i, bArr2, i2)) {
                                return true;
                            }
                            i2 += m8756k(bArr2[i2]);
                        }
                        return false;
                    }
                    if (b != 92) {
                        while (i2 < length2) {
                            if (b == bArr2[i2] && m8748c(bArr, i, bArr2, i2)) {
                                return true;
                            }
                            i2 += m8756k(bArr2[i2]);
                        }
                        return false;
                    }
                    int i4 = i + 1;
                    if (i4 == length) {
                        return false;
                    }
                    byte b2 = bArr[i4];
                    while (i2 < length2) {
                        if (b2 == bArr2[i2] && m8748c(bArr, m8756k(b2) + i4, bArr2, m8756k(bArr2[i2]) + i2)) {
                            return true;
                        }
                        i2 += m8756k(bArr2[i2]);
                    }
                    return false;
                }
                if (bArr[i] == 63) {
                    i++;
                    m8756k = m8756k(bArr2[i2]);
                } else {
                    if (bArr[i] != bArr2[i2]) {
                        return false;
                    }
                    i += m8756k(bArr[i]);
                    i2 += m8756k(bArr2[i2]);
                    if (i2 < length2) {
                        continue;
                    } else {
                        if (i >= length) {
                            return true;
                        }
                        if (bArr[i] == 42) {
                            break;
                        }
                    }
                }
            }
            i2 += m8756k;
        }
        if (i == length && i2 == length2) {
            return true;
        }
        if (i2 < length2 || bArr[i] != 42) {
            return false;
        }
        while (i < length) {
            int i5 = i + 1;
            if (bArr[i] != 42) {
                return false;
            }
            i = i5;
        }
        return true;
    }

    /* renamed from: d */
    public static boolean m8749d(byte[] bArr, byte[] bArr2) {
        return m8750e(bArr, 0, bArr2, 0);
    }

    /* renamed from: e */
    public static boolean m8750e(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (bArr2.length <= 0 || bArr2[0] != 46) {
            return m8748c(bArr, i, bArr2, i2);
        }
        if (bArr.length <= 0 || bArr[0] != 46) {
            return false;
        }
        if (bArr.length == 2 && bArr[1] == 42) {
            return true;
        }
        return m8748c(bArr, i + 1, bArr2, i2 + 1);
    }

    /* renamed from: f */
    public static boolean m8751f(String str, byte[][] bArr) {
        byte[] m8758m = m8758m(str, "UTF-8");
        if (bArr != null) {
            bArr[0] = m8758m;
        }
        return m8752g(m8758m);
    }

    /* renamed from: g */
    public static boolean m8752g(byte[] bArr) {
        int i;
        int length = bArr.length;
        int i2 = 0;
        while (i2 < length) {
            if (bArr[i2] == 42 || bArr[i2] == 63) {
                return true;
            }
            if (bArr[i2] == 92 && (i = i2 + 1) < length) {
                i2 = i;
            }
            i2++;
        }
        return false;
    }

    /* renamed from: h */
    public static Pointer m8753h(Integer num) {
        return new IntByReference(num.intValue()).getPointer();
    }

    /* renamed from: i */
    public static Pointer m8754i(String str) {
        Memory memory = new Memory(Native.WCHAR_SIZE * (str.length() + 1));
        memory.setString(0L, str);
        return memory;
    }

    /* renamed from: j */
    public static Pointer m8755j(boolean z) {
        return new IntByReference(z ? 1 : 0).getPointer();
    }

    /* renamed from: k */
    public static int m8756k(byte b) {
        if (((byte) (b & 128)) == 0) {
            return 1;
        }
        if (((byte) (b & 224)) == -64) {
            return 2;
        }
        return ((byte) (b & 240)) == -32 ? 3 : 1;
    }

    /* renamed from: l */
    public static byte[] m8757l(String str) {
        return m8758m(str, "UTF-8");
    }

    /* renamed from: m */
    public static byte[] m8758m(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    /* renamed from: n */
    public static String m8759n(String str) {
        byte[] m8757l = m8757l(str);
        byte[] m8760o = m8760o(m8757l);
        return m8757l.length == m8760o.length ? str : m8746a(m8760o);
    }

    /* renamed from: o */
    public static byte[] m8760o(byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            if (bArr[i] == 92) {
                int i2 = i + 1;
                if (i2 == length) {
                    break;
                }
                System.arraycopy(bArr, i2, bArr, i, bArr.length - i2);
                length--;
                i = i2;
            } else {
                i++;
            }
        }
        if (length == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }
}
