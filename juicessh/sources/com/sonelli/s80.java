package com.sonelli;

import android.os.Process;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public abstract class s80 implements Runnable {
    /* renamed from: a */
    public abstract void mo1834a();

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        mo1834a();
    }
}
