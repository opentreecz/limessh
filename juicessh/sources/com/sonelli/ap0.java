package com.sonelli;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* compiled from: ByteString.java */
/* loaded from: classes.dex */
public class ap0 implements Serializable, Comparable<ap0> {

    /* renamed from: R */
    public static final char[] f1501R = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: S */
    public static final ap0 f1502S = m2234r(new byte[0]);

    /* renamed from: O */
    public final byte[] f1503O;

    /* renamed from: P */
    public transient int f1504P;

    /* renamed from: Q */
    public transient String f1505Q;

    public ap0(byte[] bArr) {
        this.f1503O = bArr;
    }

    /* renamed from: h */
    public static int m2230h(String str, int i) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            if (i3 == i) {
                return i2;
            }
            int codePointAt = str.codePointAt(i2);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i3++;
            i2 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    /* renamed from: l */
    public static ap0 m2231l(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((m2232m(str.charAt(i2)) << 4) + m2232m(str.charAt(i2 + 1)));
        }
        return m2234r(bArr);
    }

    /* renamed from: m */
    public static int m2232m(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: " + c);
            }
        }
        return (c - c2) + 10;
    }

    /* renamed from: o */
    public static ap0 m2233o(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        ap0 ap0Var = new ap0(str.getBytes(np0.f5329a));
        ap0Var.f1505Q = str;
        return ap0Var;
    }

    /* renamed from: r */
    public static ap0 m2234r(byte... bArr) {
        if (bArr != null) {
            return new ap0((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    /* renamed from: A */
    public byte[] mo2235A() {
        return (byte[]) this.f1503O.clone();
    }

    /* renamed from: B */
    public String mo2236B() {
        String str = this.f1505Q;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f1503O, np0.f5329a);
        this.f1505Q = str2;
        return str2;
    }

    /* renamed from: C */
    public void mo2237C(zo0 zo0Var) {
        byte[] bArr = this.f1503O;
        zo0Var.m10564l0(bArr, 0, bArr.length);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ap0) {
            ap0 ap0Var = (ap0) obj;
            int mo2247w = ap0Var.mo2247w();
            byte[] bArr = this.f1503O;
            if (mo2247w == bArr.length && ap0Var.mo2244t(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public String mo2238f() {
        return yo0.m10208a(this.f1503O);
    }

    public int hashCode() {
        int i = this.f1504P;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f1503O);
        this.f1504P = hashCode;
        return hashCode;
    }

    @Override // java.lang.Comparable
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public int compareTo(ap0 ap0Var) {
        int mo2247w = mo2247w();
        int mo2247w2 = ap0Var.mo2247w();
        int min = Math.min(mo2247w, mo2247w2);
        for (int i = 0; i < min; i++) {
            int mo2241p = mo2241p(i) & 255;
            int mo2241p2 = ap0Var.mo2241p(i) & 255;
            if (mo2241p != mo2241p2) {
                return mo2241p < mo2241p2 ? -1 : 1;
            }
        }
        if (mo2247w == mo2247w2) {
            return 0;
        }
        return mo2247w < mo2247w2 ? -1 : 1;
    }

    /* renamed from: n */
    public final ap0 m2240n(String str) {
        try {
            return m2234r(MessageDigest.getInstance(str).digest(this.f1503O));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: p */
    public byte mo2241p(int i) {
        return this.f1503O[i];
    }

    /* renamed from: q */
    public String mo2242q() {
        byte[] bArr = this.f1503O;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f1501R;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    /* renamed from: s */
    public boolean mo2243s(int i, ap0 ap0Var, int i2, int i3) {
        return ap0Var.mo2244t(i2, this.f1503O, i, i3);
    }

    /* renamed from: t */
    public boolean mo2244t(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.f1503O;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && np0.m6761a(bArr2, i, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        if (this.f1503O.length == 0) {
            return "[size=0]";
        }
        String mo2236B = mo2236B();
        int m2230h = m2230h(mo2236B, 64);
        if (m2230h == -1) {
            if (this.f1503O.length <= 64) {
                return "[hex=" + mo2242q() + "]";
            }
            return "[size=" + this.f1503O.length + " hex=" + mo2249y(0, 64).mo2242q() + "…]";
        }
        String replace = mo2236B.substring(0, m2230h).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (m2230h >= mo2236B.length()) {
            return "[text=" + replace + "]";
        }
        return "[size=" + this.f1503O.length + " text=" + replace + "…]";
    }

    /* renamed from: u */
    public ap0 mo2245u() {
        return m2240n("SHA-1");
    }

    /* renamed from: v */
    public ap0 mo2246v() {
        return m2240n("SHA-256");
    }

    /* renamed from: w */
    public int mo2247w() {
        return this.f1503O.length;
    }

    /* renamed from: x */
    public final boolean m2248x(ap0 ap0Var) {
        return mo2243s(0, ap0Var, 0, ap0Var.mo2247w());
    }

    /* renamed from: y */
    public ap0 mo2249y(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.f1503O;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.f1503O.length + ")");
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i == 0 && i2 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return new ap0(bArr2);
    }

    /* renamed from: z */
    public ap0 mo2250z() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f1503O;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b >= 65 && b <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b2 = bArr2[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr2[i2] = (byte) (b2 + 32);
                    }
                }
                return new ap0(bArr2);
            }
            i++;
        }
    }
}
