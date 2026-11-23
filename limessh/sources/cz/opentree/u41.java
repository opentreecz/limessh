package cz.opentree;

/* loaded from: classes.dex */
public class u41 {

    /* renamed from: a */
    public int f6917a;

    /* renamed from: b */
    public int f6918b;

    public u41(byte[] bArr) {
        this.f6917a = 0;
        if (bArr.length != 4) {
            throw new IllegalArgumentException("byte array is not an encoded finite field");
        }
        int m10086d = y41.m10086d(bArr);
        this.f6918b = m10086d;
        if (!c51.m2672c(m10086d)) {
            throw new IllegalArgumentException("byte array is not an encoded finite field");
        }
        this.f6917a = c51.m2670a(this.f6918b);
    }

    /* renamed from: i */
    public static String m8843i(int i) {
        if (i == 0) {
            return "0";
        }
        String str = ((byte) (i & 1)) == 1 ? "1" : "";
        int i2 = i >>> 1;
        int i3 = 1;
        while (i2 != 0) {
            if (((byte) (i2 & 1)) == 1) {
                str = str + "+x^" + i3;
            }
            i2 >>>= 1;
            i3++;
        }
        return str;
    }

    /* renamed from: a */
    public int m8844a(int i, int i2) {
        return i ^ i2;
    }

    /* renamed from: b */
    public String m8845b(int i) {
        StringBuilder sb;
        String str;
        String str2 = "";
        for (int i2 = 0; i2 < this.f6917a; i2++) {
            if ((((byte) i) & 1) == 0) {
                sb = new StringBuilder();
                str = "0";
            } else {
                sb = new StringBuilder();
                str = "1";
            }
            sb.append(str);
            sb.append(str2);
            str2 = sb.toString();
            i >>>= 1;
        }
        return str2;
    }

    /* renamed from: c */
    public int m8846c(int i, int i2) {
        if (i2 == 0) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        if (i2 < 0) {
            i = m8849f(i);
            i2 = -i2;
        }
        int i3 = 1;
        while (i2 != 0) {
            if ((i2 & 1) == 1) {
                i3 = m8851h(i3, i);
            }
            i = m8851h(i, i);
            i2 >>>= 1;
        }
        return i3;
    }

    /* renamed from: d */
    public int m8847d() {
        return this.f6917a;
    }

    /* renamed from: e */
    public byte[] m8848e() {
        return y41.m10085c(this.f6918b);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof u41)) {
            u41 u41Var = (u41) obj;
            if (this.f6917a == u41Var.f6917a && this.f6918b == u41Var.f6918b) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public int m8849f(int i) {
        return m8846c(i, (1 << this.f6917a) - 2);
    }

    /* renamed from: g */
    public boolean m8850g(int i) {
        int i2 = this.f6917a;
        return i2 == 31 ? i >= 0 : i >= 0 && i < (1 << i2);
    }

    /* renamed from: h */
    public int m8851h(int i, int i2) {
        return c51.m2673d(i, i2, this.f6918b);
    }

    public int hashCode() {
        return this.f6918b;
    }

    public String toString() {
        return "Finite Field GF(2^" + this.f6917a + ") = GF(2)[X]/<" + m8843i(this.f6918b) + "> ";
    }
}
