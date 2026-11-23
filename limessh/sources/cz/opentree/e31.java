package cz.opentree;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.crypto.xmss.XMSSOid;

/* loaded from: classes.dex */
public final class e31 {

    /* renamed from: e */
    public static final Map<Integer, e31> f2329e;

    /* renamed from: a */
    public final XMSSOid f2330a;

    /* renamed from: b */
    public final j31 f2331b;

    /* renamed from: c */
    public final int f2332c;

    /* renamed from: d */
    public final int f2333d;

    static {
        HashMap hashMap = new HashMap();
        Integer m4057c = g51.m4057c(1);
        aq0 aq0Var = NISTObjectIdentifiers.f8736c;
        hashMap.put(m4057c, new e31(20, 2, aq0Var));
        hashMap.put(g51.m4057c(2), new e31(20, 4, aq0Var));
        hashMap.put(g51.m4057c(3), new e31(40, 2, aq0Var));
        hashMap.put(g51.m4057c(4), new e31(40, 4, aq0Var));
        hashMap.put(g51.m4057c(5), new e31(40, 8, aq0Var));
        hashMap.put(g51.m4057c(6), new e31(60, 3, aq0Var));
        hashMap.put(g51.m4057c(7), new e31(60, 6, aq0Var));
        hashMap.put(g51.m4057c(8), new e31(60, 12, aq0Var));
        Integer m4057c2 = g51.m4057c(9);
        aq0 aq0Var2 = NISTObjectIdentifiers.f8738e;
        hashMap.put(m4057c2, new e31(20, 2, aq0Var2));
        hashMap.put(g51.m4057c(10), new e31(20, 4, aq0Var2));
        hashMap.put(g51.m4057c(11), new e31(40, 2, aq0Var2));
        hashMap.put(g51.m4057c(12), new e31(40, 4, aq0Var2));
        hashMap.put(g51.m4057c(13), new e31(40, 8, aq0Var2));
        hashMap.put(g51.m4057c(14), new e31(60, 3, aq0Var2));
        hashMap.put(g51.m4057c(15), new e31(60, 6, aq0Var2));
        hashMap.put(g51.m4057c(16), new e31(60, 12, aq0Var2));
        Integer m4057c3 = g51.m4057c(17);
        aq0 aq0Var3 = NISTObjectIdentifiers.f8742i;
        hashMap.put(m4057c3, new e31(20, 2, aq0Var3));
        hashMap.put(g51.m4057c(18), new e31(20, 4, aq0Var3));
        hashMap.put(g51.m4057c(19), new e31(40, 2, aq0Var3));
        hashMap.put(g51.m4057c(20), new e31(40, 4, aq0Var3));
        hashMap.put(g51.m4057c(21), new e31(40, 8, aq0Var3));
        hashMap.put(g51.m4057c(22), new e31(60, 3, aq0Var3));
        hashMap.put(g51.m4057c(23), new e31(60, 6, aq0Var3));
        hashMap.put(g51.m4057c(24), new e31(60, 12, aq0Var3));
        Integer m4057c4 = g51.m4057c(25);
        aq0 aq0Var4 = NISTObjectIdentifiers.f8743j;
        hashMap.put(m4057c4, new e31(20, 2, aq0Var4));
        hashMap.put(g51.m4057c(26), new e31(20, 4, aq0Var4));
        hashMap.put(g51.m4057c(27), new e31(40, 2, aq0Var4));
        hashMap.put(g51.m4057c(28), new e31(40, 4, aq0Var4));
        hashMap.put(g51.m4057c(29), new e31(40, 8, aq0Var4));
        hashMap.put(g51.m4057c(30), new e31(60, 3, aq0Var4));
        hashMap.put(g51.m4057c(31), new e31(60, 6, aq0Var4));
        hashMap.put(g51.m4057c(32), new e31(60, 12, aq0Var4));
        f2329e = Collections.unmodifiableMap(hashMap);
    }

    public e31(int i, int i2, aq0 aq0Var) {
        this.f2332c = i;
        this.f2333d = i2;
        this.f2331b = new j31(m3409j(i, i2), aq0Var);
        this.f2330a = q21.m7605c(m3414e(), m3415f(), m3416g(), m3412c(), m3410a(), i2);
    }

    public e31(int i, int i2, Digest digest) {
        this(i, i2, s21.m8309c(digest.mo7097e()));
    }

    /* renamed from: i */
    public static e31 m3408i(int i) {
        return f2329e.get(g51.m4057c(i));
    }

    /* renamed from: j */
    public static int m3409j(int i, int i2) throws IllegalArgumentException {
        if (i < 2) {
            throw new IllegalArgumentException("totalHeight must be > 1");
        }
        if (i % i2 != 0) {
            throw new IllegalArgumentException("layers must divide totalHeight without remainder");
        }
        int i3 = i / i2;
        if (i3 != 1) {
            return i3;
        }
        throw new IllegalArgumentException("height / layers must be greater than 1");
    }

    /* renamed from: a */
    public int m3410a() {
        return this.f2332c;
    }

    /* renamed from: b */
    public int m3411b() {
        return this.f2333d;
    }

    /* renamed from: c */
    public int m3412c() {
        return this.f2331b.m5043d();
    }

    /* renamed from: d */
    public XMSSOid m3413d() {
        return this.f2330a;
    }

    /* renamed from: e */
    public String m3414e() {
        return this.f2331b.m5045f();
    }

    /* renamed from: f */
    public int m3415f() {
        return this.f2331b.m5047h();
    }

    /* renamed from: g */
    public int m3416g() {
        return this.f2331b.m5049j();
    }

    /* renamed from: h */
    public j31 m3417h() {
        return this.f2331b;
    }
}
