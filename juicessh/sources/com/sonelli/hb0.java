package com.sonelli;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class hb0 implements FilenameFilter {

    /* renamed from: a */
    public static final hb0 f3134a = new hb0();

    /* renamed from: a */
    public static FilenameFilter m4428a() {
        return f3134a;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        boolean m6123t;
        m6123t = lb0.m6123t(file, str);
        return m6123t;
    }
}
