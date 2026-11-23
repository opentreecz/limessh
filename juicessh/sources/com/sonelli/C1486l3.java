package com.sonelli;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import java.util.EnumMap;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.l3 */
/* loaded from: classes.dex */
public final class C1486l3 {

    /* renamed from: a */
    public static SparseArray<EnumC0854d> f4726a = new SparseArray<>();

    /* renamed from: b */
    public static EnumMap<EnumC0854d, Integer> f4727b;

    static {
        EnumMap<EnumC0854d, Integer> enumMap = new EnumMap<>((Class<EnumC0854d>) EnumC0854d.class);
        f4727b = enumMap;
        enumMap.put((EnumMap<EnumC0854d, Integer>) EnumC0854d.DEFAULT, (EnumC0854d) 0);
        f4727b.put((EnumMap<EnumC0854d, Integer>) EnumC0854d.VERY_LOW, (EnumC0854d) 1);
        f4727b.put((EnumMap<EnumC0854d, Integer>) EnumC0854d.HIGHEST, (EnumC0854d) 2);
        for (EnumC0854d enumC0854d : f4727b.keySet()) {
            f4726a.append(f4727b.get(enumC0854d).intValue(), enumC0854d);
        }
    }

    /* renamed from: a */
    public static int m6046a(@NonNull EnumC0854d enumC0854d) {
        Integer num = f4727b.get(enumC0854d);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + enumC0854d);
    }

    @NonNull
    /* renamed from: b */
    public static EnumC0854d m6047b(int i) {
        EnumC0854d enumC0854d = f4726a.get(i);
        if (enumC0854d != null) {
            return enumC0854d;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i);
    }
}
