package cz.opentree;

/* loaded from: classes.dex */
public class d51 {

    /* renamed from: a */
    public u41 f2131a;

    /* renamed from: b */
    public b51 f2132b;

    /* renamed from: c */
    public b51[] f2133c;

    /* renamed from: d */
    public b51[] f2134d;

    public d51(u41 u41Var, b51 b51Var) {
        this.f2131a = u41Var;
        this.f2132b = b51Var;
        m3157b();
        m3156a();
    }

    /* renamed from: d */
    public static void m3155d(b51[] b51VarArr, int i, int i2) {
        b51 b51Var = b51VarArr[i];
        b51VarArr[i] = b51VarArr[i2];
        b51VarArr[i2] = b51Var;
    }

    /* renamed from: a */
    public final void m3156a() {
        int m2383f;
        int m2384g = this.f2132b.m2384g();
        b51[] b51VarArr = new b51[m2384g];
        int i = m2384g - 1;
        for (int i2 = i; i2 >= 0; i2--) {
            b51VarArr[i2] = new b51(this.f2133c[i2]);
        }
        this.f2134d = new b51[m2384g];
        while (i >= 0) {
            this.f2134d[i] = new b51(this.f2131a, i);
            i--;
        }
        for (int i3 = 0; i3 < m2384g; i3++) {
            if (b51VarArr[i3].m2383f(i3) == 0) {
                int i4 = i3 + 1;
                boolean z = false;
                while (i4 < m2384g) {
                    if (b51VarArr[i4].m2383f(i3) != 0) {
                        m3155d(b51VarArr, i3, i4);
                        m3155d(this.f2134d, i3, i4);
                        i4 = m2384g;
                        z = true;
                    }
                    i4++;
                }
                if (!z) {
                    throw new ArithmeticException("Squaring matrix is not invertible.");
                }
            }
            int m8849f = this.f2131a.m8849f(b51VarArr[i3].m2383f(i3));
            b51VarArr[i3].m2388m(m8849f);
            this.f2134d[i3].m2388m(m8849f);
            for (int i5 = 0; i5 < m2384g; i5++) {
                if (i5 != i3 && (m2383f = b51VarArr[i5].m2383f(i3)) != 0) {
                    b51 m2389n = b51VarArr[i3].m2389n(m2383f);
                    b51 m2389n2 = this.f2134d[i3].m2389n(m2383f);
                    b51VarArr[i5].m2380b(m2389n);
                    this.f2134d[i5].m2380b(m2389n2);
                }
            }
        }
    }

    /* renamed from: b */
    public final void m3157b() {
        int i;
        int m2384g = this.f2132b.m2384g();
        this.f2133c = new b51[m2384g];
        int i2 = 0;
        while (true) {
            i = m2384g >> 1;
            if (i2 >= i) {
                break;
            }
            int i3 = i2 << 1;
            int[] iArr = new int[i3 + 1];
            iArr[i3] = 1;
            this.f2133c[i2] = new b51(this.f2131a, iArr);
            i2++;
        }
        while (i < m2384g) {
            int i4 = i << 1;
            int[] iArr2 = new int[i4 + 1];
            iArr2[i4] = 1;
            this.f2133c[i] = new b51(this.f2131a, iArr2).m2386k(this.f2132b);
            i++;
        }
    }

    /* renamed from: c */
    public b51[] m3158c() {
        return this.f2134d;
    }
}
