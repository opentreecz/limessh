package com.sonelli;

import java.io.File;
import java.io.FileFilter;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class gb0 implements FileFilter {

    /* renamed from: a */
    public final String f2855a;

    public gb0(String str) {
        this.f2855a = str;
    }

    /* renamed from: a */
    public static FileFilter m4110a(String str) {
        return new gb0(str);
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        return lb0.m6124u(this.f2855a, file);
    }
}
