package cz.opentree;

/* loaded from: classes.dex */
public class a51 {

    /* renamed from: a */
    public int[] f1332a;

    public a51(byte[] bArr) {
        if (bArr.length <= 4) {
            throw new IllegalArgumentException("invalid encoding");
        }
        int m10087e = y41.m10087e(bArr, 0);
        int m9699a = x41.m9699a(m10087e - 1);
        if (bArr.length != (m10087e * m9699a) + 4) {
            throw new IllegalArgumentException("invalid encoding");
        }
        this.f1332a = new int[m10087e];
        for (int i = 0; i < m10087e; i++) {
            this.f1332a[i] = y41.m10088f(bArr, (i * m9699a) + 4, m9699a);
        }
        if (!m1981b(this.f1332a)) {
            throw new IllegalArgumentException("invalid encoding");
        }
    }

    /* renamed from: a */
    public byte[] m1980a() {
        int length = this.f1332a.length;
        int m9699a = x41.m9699a(length - 1);
        byte[] bArr = new byte[(length * m9699a) + 4];
        y41.m10083a(length, bArr, 0);
        for (int i = 0; i < length; i++) {
            y41.m10084b(this.f1332a[i], bArr, (i * m9699a) + 4, m9699a);
        }
        return bArr;
    }

    /* renamed from: b */
    public final boolean m1981b(int[] iArr) {
        int length = iArr.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (iArr[i] < 0 || iArr[i] >= length || zArr[iArr[i]]) {
                return false;
            }
            zArr[iArr[i]] = true;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a51) {
            return w41.m9409b(this.f1332a, ((a51) obj).f1332a);
        }
        return false;
    }

    public int hashCode() {
        return e51.m3448q(this.f1332a);
    }

    public String toString() {
        String str = "[" + this.f1332a[0];
        for (int i = 1; i < this.f1332a.length; i++) {
            str = str + ", " + this.f1332a[i];
        }
        return str + "]";
    }
}
