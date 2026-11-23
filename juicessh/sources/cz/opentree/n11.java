package cz.opentree;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;

/* loaded from: classes.dex */
public class n11 {

    /* renamed from: e */
    public static final n11 f5188e;

    /* renamed from: f */
    public static final n11 f5189f;

    /* renamed from: g */
    public static final n11 f5190g;

    /* renamed from: h */
    public static final n11 f5191h;

    /* renamed from: i */
    public static final n11 f5192i;

    /* renamed from: j */
    public static Map<Object, n11> f5193j;

    /* renamed from: a */
    public final int f5194a;

    /* renamed from: b */
    public final int f5195b;

    /* renamed from: c */
    public final int f5196c;

    /* renamed from: d */
    public final aq0 f5197d;

    /* renamed from: cz.opentree.n11$a */
    /* loaded from: classes.dex */
    public static class C1584a extends HashMap<Object, n11> {
        public C1584a() {
            n11 n11Var = n11.f5188e;
            put(Integer.valueOf(n11Var.f5194a), n11Var);
            n11 n11Var2 = n11.f5189f;
            put(Integer.valueOf(n11Var2.f5194a), n11Var2);
            n11 n11Var3 = n11.f5190g;
            put(Integer.valueOf(n11Var3.f5194a), n11Var3);
            n11 n11Var4 = n11.f5191h;
            put(Integer.valueOf(n11Var4.f5194a), n11Var4);
            n11 n11Var5 = n11.f5192i;
            put(Integer.valueOf(n11Var5.f5194a), n11Var5);
        }
    }

    static {
        aq0 aq0Var = NISTObjectIdentifiers.f8736c;
        f5188e = new n11(5, 32, 5, aq0Var);
        f5189f = new n11(6, 32, 10, aq0Var);
        f5190g = new n11(7, 32, 15, aq0Var);
        f5191h = new n11(8, 32, 20, aq0Var);
        f5192i = new n11(9, 32, 25, aq0Var);
        f5193j = new C1584a();
    }

    public n11(int i, int i2, int i3, aq0 aq0Var) {
        this.f5194a = i;
        this.f5195b = i2;
        this.f5196c = i3;
        this.f5197d = aq0Var;
    }

    /* renamed from: e */
    public static n11 m6622e(int i) {
        return f5193j.get(Integer.valueOf(i));
    }

    /* renamed from: b */
    public aq0 m6623b() {
        return this.f5197d;
    }

    /* renamed from: c */
    public int m6624c() {
        return this.f5196c;
    }

    /* renamed from: d */
    public int m6625d() {
        return this.f5195b;
    }

    /* renamed from: f */
    public int m6626f() {
        return this.f5194a;
    }
}
