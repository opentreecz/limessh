package com.sonelli;

import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class vc0 {

    /* renamed from: a */
    public final String f7442a;

    /* renamed from: b */
    public final String f7443b;

    /* renamed from: c */
    public final StackTraceElement[] f7444c;

    /* renamed from: d */
    public final vc0 f7445d;

    public vc0(Throwable th, StackTraceTrimmingStrategy stackTraceTrimmingStrategy) {
        this.f7442a = th.getLocalizedMessage();
        this.f7443b = th.getClass().getName();
        this.f7444c = stackTraceTrimmingStrategy.mo1848a(th.getStackTrace());
        Throwable cause = th.getCause();
        this.f7445d = cause != null ? new vc0(cause, stackTraceTrimmingStrategy) : null;
    }
}
