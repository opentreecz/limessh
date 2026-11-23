package com.sonelli;

import android.util.SparseArray;

/* JADX WARN: $VALUES field not found */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* renamed from: com.sonelli.u */
/* loaded from: classes.dex */
public final class EnumC1988u {

    /* renamed from: O */
    public static final EnumC1988u f6870O;

    /* renamed from: P */
    public static final EnumC1988u f6871P;

    /* renamed from: Q */
    public static final EnumC1988u f6872Q;

    /* renamed from: R */
    public static final EnumC1988u f6873R;

    /* renamed from: S */
    public static final EnumC1988u f6874S;

    /* renamed from: T */
    public static final EnumC1988u f6875T;

    /* renamed from: U */
    public static final SparseArray<EnumC1988u> f6876U;

    static {
        EnumC1988u enumC1988u = new EnumC1988u("DEFAULT", 0, 0);
        f6870O = enumC1988u;
        EnumC1988u enumC1988u2 = new EnumC1988u("UNMETERED_ONLY", 1, 1);
        f6871P = enumC1988u2;
        EnumC1988u enumC1988u3 = new EnumC1988u("UNMETERED_OR_DAILY", 2, 2);
        f6872Q = enumC1988u3;
        EnumC1988u enumC1988u4 = new EnumC1988u("FAST_IF_RADIO_AWAKE", 3, 3);
        f6873R = enumC1988u4;
        EnumC1988u enumC1988u5 = new EnumC1988u("NEVER", 4, 4);
        f6874S = enumC1988u5;
        EnumC1988u enumC1988u6 = new EnumC1988u("UNRECOGNIZED", 5, -1);
        f6875T = enumC1988u6;
        SparseArray<EnumC1988u> sparseArray = new SparseArray<>();
        f6876U = sparseArray;
        sparseArray.put(0, enumC1988u);
        sparseArray.put(1, enumC1988u2);
        sparseArray.put(2, enumC1988u3);
        sparseArray.put(3, enumC1988u4);
        sparseArray.put(4, enumC1988u5);
        sparseArray.put(-1, enumC1988u6);
    }

    public EnumC1988u(String str, int i, int i2) {
    }
}
