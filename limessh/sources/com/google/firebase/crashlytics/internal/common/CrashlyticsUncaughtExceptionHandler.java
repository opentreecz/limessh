package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import cz.opentree.m80;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class CrashlyticsUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    public final CrashListener f1214a;

    /* renamed from: b */
    public final SettingsDataProvider f1215b;

    /* renamed from: c */
    public final Thread.UncaughtExceptionHandler f1216c;

    /* renamed from: d */
    public final AtomicBoolean f1217d = new AtomicBoolean(false);

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes.dex */
    public interface CrashListener {
        /* renamed from: a */
        void mo1726a(SettingsDataProvider settingsDataProvider, Thread thread, Throwable th);
    }

    public CrashlyticsUncaughtExceptionHandler(CrashListener crashListener, SettingsDataProvider settingsDataProvider, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f1214a = crashListener;
        this.f1215b = settingsDataProvider;
        this.f1216c = uncaughtExceptionHandler;
    }

    /* renamed from: a */
    public boolean m1738a() {
        return this.f1217d.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Thread$UncaughtExceptionHandler] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Thread$UncaughtExceptionHandler] */
    /* JADX WARN: Type inference failed for: r3v1, types: [cz.opentree.m80] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.concurrent.atomic.AtomicBoolean] */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        this.f1217d.set(true);
        var r1 = "Crashlytics completed exception processing. Invoking default exception handler.";
        try {
            try {
                if (thread == 0) {
                    m80.m6375f().m6379d("Could not handle uncaught exception; null thread");
                } else if (th == null) {
                    m80.m6375f().m6379d("Could not handle uncaught exception; null throwable");
                } else {
                    this.f1214a.mo1726a(this.f1215b, thread, th);
                }
            } catch (Exception e) {
                m80.m6375f().m6380e("An error occurred in the uncaught exception handler", e);
            }
            m80.m6375f().m6377b("Crashlytics completed exception processing. Invoking default exception handler.");
            r1 = this.f1216c;
            r1.uncaughtException(thread, th);
            thread = this.f1217d;
            thread.set(false);
        } catch (Throwable th2) {
            m80.m6375f().m6377b(r1);
            this.f1216c.uncaughtException(thread, th);
            this.f1217d.set(false);
            throw th2;
        }
    }
}
