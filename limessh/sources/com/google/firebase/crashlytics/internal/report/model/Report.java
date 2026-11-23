package com.google.firebase.crashlytics.internal.report.model;

import java.io.File;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public interface Report {

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.report.model.Report$a */
    /* loaded from: classes.dex */
    public enum EnumC0663a {
        JAVA,
        NATIVE
    }

    /* renamed from: a */
    Map<String, String> mo1836a();

    /* renamed from: b */
    String mo1837b();

    /* renamed from: c */
    File mo1838c();

    /* renamed from: d */
    File[] mo1839d();

    /* renamed from: e */
    String mo1840e();

    EnumC0663a getType();

    void remove();
}
