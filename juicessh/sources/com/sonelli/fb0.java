package com.sonelli;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class fb0 implements FilenameFilter {

    /* renamed from: a */
    public final String f2651a;

    public fb0(String str) {
        this.f2651a = str;
    }

    /* renamed from: a */
    public static FilenameFilter m3709a(String str) {
        return new fb0(str);
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        boolean startsWith;
        startsWith = str.startsWith(this.f2651a);
        return startsWith;
    }
}
