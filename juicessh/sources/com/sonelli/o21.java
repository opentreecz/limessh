package com.sonelli;

import com.sonelli.w21;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class o21 implements Serializable {

    /* renamed from: O */
    public final Map<Integer, n21> f5408O = new TreeMap();

    /* renamed from: P */
    public transient long f5409P;

    public o21(long j) {
        this.f5409P = j;
    }

    public o21(e31 e31Var, long j, byte[] bArr, byte[] bArr2) {
        this.f5409P = (1 << e31Var.m3410a()) - 1;
        for (long j2 = 0; j2 < j; j2++) {
            m6840e(e31Var, j2, bArr, bArr2);
        }
    }

    public o21(o21 o21Var, long j) {
        for (Integer num : o21Var.f5408O.keySet()) {
            this.f5408O.put(num, new n21(o21Var.f5408O.get(num)));
        }
        this.f5409P = j;
    }

    /* renamed from: a */
    public n21 m6836a(int i) {
        return this.f5408O.get(g51.m4057c(i));
    }

    /* renamed from: b */
    public long m6837b() {
        return this.f5409P;
    }

    /* renamed from: c */
    public void m6838c(int i, n21 n21Var) {
        this.f5408O.put(g51.m4057c(i), n21Var);
    }

    /* renamed from: d */
    public n21 m6839d(int i, byte[] bArr, byte[] bArr2, w21 w21Var) {
        return this.f5408O.put(g51.m4057c(i), this.f5408O.get(g51.m4057c(i)).m6631d(bArr, bArr2, w21Var));
    }

    /* renamed from: e */
    public void m6840e(e31 e31Var, long j, byte[] bArr, byte[] bArr2) {
        j31 m3417h = e31Var.m3417h();
        int m5041b = m3417h.m5041b();
        long m6360j = m31.m6360j(j, m5041b);
        int m6359i = m31.m6359i(j, m5041b);
        w21.C2198b m2370h = new w21.C2198b().m2370h(m6360j);
        m2370h.m9400p(m6359i);
        w21 w21Var = (w21) m2370h.m9396l();
        int i = (1 << m5041b) - 1;
        if (m6359i < i) {
            if (m6836a(0) == null || m6359i == 0) {
                m6838c(0, new n21(m3417h, bArr, bArr2, w21Var));
            }
            m6839d(0, bArr, bArr2, w21Var);
        }
        for (int i2 = 1; i2 < e31Var.m3411b(); i2++) {
            int m6359i2 = m31.m6359i(m6360j, m5041b);
            m6360j = m31.m6360j(m6360j, m5041b);
            w21.C2198b m2370h2 = new w21.C2198b().m2369g(i2).m2370h(m6360j);
            m2370h2.m9400p(m6359i2);
            w21 w21Var2 = (w21) m2370h2.m9396l();
            if (this.f5408O.get(Integer.valueOf(i2)) == null || m31.m6364n(j, m5041b, i2)) {
                this.f5408O.put(Integer.valueOf(i2), new n21(m3417h, bArr, bArr2, w21Var2));
            }
            if (m6359i2 < i && m31.m6363m(j, m5041b, i2)) {
                m6839d(i2, bArr, bArr2, w21Var2);
            }
        }
    }

    /* renamed from: f */
    public o21 m6841f(aq0 aq0Var) {
        o21 o21Var = new o21(this.f5409P);
        for (Integer num : this.f5408O.keySet()) {
            o21Var.f5408O.put(num, this.f5408O.get(num).m6635i(aq0Var));
        }
        return o21Var;
    }
}
