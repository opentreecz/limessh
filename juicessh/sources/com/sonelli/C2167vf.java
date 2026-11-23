package com.sonelli;

/* renamed from: com.sonelli.vf */
/* loaded from: classes.dex */
public final class C2167vf {

    /* renamed from: a */
    public static final String f7453a;

    /* renamed from: b */
    public static final String f7454b;

    static {
        String replaceAll = String.valueOf(C2326y6.f8141a / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
        f7453a = replaceAll;
        String valueOf = String.valueOf(replaceAll);
        f7454b = valueOf.length() != 0 ? "ma".concat(valueOf) : new String("ma");
    }
}
