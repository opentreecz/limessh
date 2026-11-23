package com.sonelli;

import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;

/* loaded from: classes.dex */
public class h11 {

    /* renamed from: f */
    public static final h11 f3068f;

    /* renamed from: g */
    public static final h11 f3069g;

    /* renamed from: h */
    public static final h11 f3070h;

    /* renamed from: i */
    public static final h11 f3071i;

    /* renamed from: j */
    public static final Map<Object, h11> f3072j;

    /* renamed from: a */
    public final int f3073a;

    /* renamed from: b */
    public final int f3074b;

    /* renamed from: c */
    public final int f3075c;

    /* renamed from: d */
    public final int f3076d;

    /* renamed from: e */
    public final aq0 f3077e;

    /* renamed from: com.sonelli.h11$a */
    /* loaded from: classes.dex */
    public static class C1090a extends HashMap<Object, h11> {
        public C1090a() {
            h11 h11Var = h11.f3068f;
            put(Integer.valueOf(h11Var.f3073a), h11Var);
            h11 h11Var2 = h11.f3069g;
            put(Integer.valueOf(h11Var2.f3073a), h11Var2);
            h11 h11Var3 = h11.f3070h;
            put(Integer.valueOf(h11Var3.f3073a), h11Var3);
            h11 h11Var4 = h11.f3071i;
            put(Integer.valueOf(h11Var4.f3073a), h11Var4);
        }
    }

    static {
        aq0 aq0Var = NISTObjectIdentifiers.f8736c;
        f3068f = new h11(1, 32, 1, 265, 7, 8516, aq0Var);
        f3069g = new h11(2, 32, 2, KeycodeConstants.KEYCODE_F3, 6, 4292, aq0Var);
        f3070h = new h11(3, 32, 4, 67, 4, 2180, aq0Var);
        f3071i = new h11(4, 32, 8, 34, 0, 1124, aq0Var);
        f3072j = new C1090a();
    }

    public h11(int i, int i2, int i3, int i4, int i5, int i6, aq0 aq0Var) {
        this.f3073a = i;
        this.f3074b = i2;
        this.f3075c = i3;
        this.f3076d = i4;
        this.f3077e = aq0Var;
    }

    /* renamed from: e */
    public static h11 m4336e(int i) {
        return f3072j.get(Integer.valueOf(i));
    }

    /* renamed from: b */
    public aq0 m4337b() {
        return this.f3077e;
    }

    /* renamed from: c */
    public int m4338c() {
        return this.f3074b;
    }

    /* renamed from: d */
    public int m4339d() {
        return this.f3076d;
    }

    /* renamed from: f */
    public int m4340f() {
        return this.f3073a;
    }

    /* renamed from: g */
    public int m4341g() {
        return this.f3075c;
    }
}
