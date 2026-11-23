package cz.opentree;

import java.lang.Thread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.tz */
/* loaded from: classes.dex */
public final class C1987tz implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    public final String f6868a;

    /* renamed from: b */
    public final /* synthetic */ C1839rz f6869b;

    public C1987tz(C1839rz c1839rz, String str) {
        this.f6869b = c1839rz;
        C0813ca.m2729k(str);
        this.f6868a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f6869b.mo1484j().m8522H().m9084b(this.f6868a, th);
    }
}
