package com.sonelli;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.crypto.xmss.XMSSOid;

/* loaded from: classes.dex */
public final class j31 {

    /* renamed from: i */
    public static final Map<Integer, j31> f3477i;

    /* renamed from: a */
    public final XMSSOid f3478a;

    /* renamed from: b */
    public final int f3479b;

    /* renamed from: c */
    public final int f3480c;

    /* renamed from: d */
    public final aq0 f3481d;

    /* renamed from: e */
    public final int f3482e;

    /* renamed from: f */
    public final String f3483f;

    /* renamed from: g */
    public final int f3484g;

    /* renamed from: h */
    public final z21 f3485h;

    static {
        HashMap hashMap = new HashMap();
        Integer m4057c = g51.m4057c(1);
        aq0 aq0Var = NISTObjectIdentifiers.f8736c;
        hashMap.put(m4057c, new j31(10, aq0Var));
        hashMap.put(g51.m4057c(2), new j31(16, aq0Var));
        hashMap.put(g51.m4057c(3), new j31(20, aq0Var));
        Integer m4057c2 = g51.m4057c(4);
        aq0 aq0Var2 = NISTObjectIdentifiers.f8738e;
        hashMap.put(m4057c2, new j31(10, aq0Var2));
        hashMap.put(g51.m4057c(5), new j31(16, aq0Var2));
        hashMap.put(g51.m4057c(6), new j31(20, aq0Var2));
        Integer m4057c3 = g51.m4057c(7);
        aq0 aq0Var3 = NISTObjectIdentifiers.f8742i;
        hashMap.put(m4057c3, new j31(10, aq0Var3));
        hashMap.put(g51.m4057c(8), new j31(16, aq0Var3));
        hashMap.put(g51.m4057c(9), new j31(20, aq0Var3));
        Integer m4057c4 = g51.m4057c(10);
        aq0 aq0Var4 = NISTObjectIdentifiers.f8743j;
        hashMap.put(m4057c4, new j31(10, aq0Var4));
        hashMap.put(g51.m4057c(11), new j31(16, aq0Var4));
        hashMap.put(g51.m4057c(12), new j31(20, aq0Var4));
        f3477i = Collections.unmodifiableMap(hashMap);
    }

    public j31(int i, aq0 aq0Var) {
        if (i < 2) {
            throw new IllegalArgumentException("height must be >= 2");
        }
        Objects.requireNonNull(aq0Var, "digest == null");
        this.f3479b = i;
        this.f3480c = m5040a();
        String m8308b = s21.m8308b(aq0Var);
        this.f3483f = m8308b;
        this.f3481d = aq0Var;
        z21 z21Var = new z21(aq0Var);
        this.f3485h = z21Var;
        int m10327c = z21Var.m10327c();
        this.f3484g = m10327c;
        int m10328d = z21Var.m10328d();
        this.f3482e = m10328d;
        this.f3478a = r21.m7852c(m8308b, m10327c, m10328d, z21Var.m10325a(), i);
    }

    public j31(int i, Digest digest) {
        this(i, s21.m8309c(digest.mo7097e()));
    }

    /* renamed from: k */
    public static j31 m5039k(int i) {
        return f3477i.get(g51.m4057c(i));
    }

    /* renamed from: a */
    public final int m5040a() {
        int i = 2;
        while (true) {
            int i2 = this.f3479b;
            if (i > i2) {
                throw new IllegalStateException("should never happen...");
            }
            if ((i2 - i) % 2 == 0) {
                return i;
            }
            i++;
        }
    }

    /* renamed from: b */
    public int m5041b() {
        return this.f3479b;
    }

    /* renamed from: c */
    public int m5042c() {
        return this.f3480c;
    }

    /* renamed from: d */
    public int m5043d() {
        return this.f3485h.m10325a();
    }

    /* renamed from: e */
    public XMSSOid m5044e() {
        return this.f3478a;
    }

    /* renamed from: f */
    public String m5045f() {
        return this.f3483f;
    }

    /* renamed from: g */
    public aq0 m5046g() {
        return this.f3481d;
    }

    /* renamed from: h */
    public int m5047h() {
        return this.f3484g;
    }

    /* renamed from: i */
    public x21 m5048i() {
        return new x21(this.f3485h);
    }

    /* renamed from: j */
    public int m5049j() {
        return this.f3482e;
    }
}
