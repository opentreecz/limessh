package com.sonelli;

import java.io.File;
import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class ib0 implements Comparator {

    /* renamed from: a */
    public static final ib0 f3283a = new ib0();

    /* renamed from: a */
    public static Comparator m4743a() {
        return f3283a;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        int m6103A;
        m6103A = lb0.m6103A((File) obj, (File) obj2);
        return m6103A;
    }
}
