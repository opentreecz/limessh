package com.sonelli;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.analytics.zzn;
import com.google.android.gms.analytics.zzo;
import java.lang.Thread;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressLint({"StaticFieldLeak"})
/* renamed from: com.sonelli.k4 */
/* loaded from: classes.dex */
public final class C1434k4 {

    /* renamed from: f */
    public static volatile C1434k4 f4468f;

    /* renamed from: a */
    public final Context f4469a;

    /* renamed from: b */
    public final List<zzn> f4470b;

    /* renamed from: c */
    public final a f4471c;

    /* renamed from: d */
    public volatile C1455ki f4472d;

    /* renamed from: e */
    public Thread.UncaughtExceptionHandler f4473e;

    /* renamed from: com.sonelli.k4$a */
    /* loaded from: classes.dex */
    public class a extends ThreadPoolExecutor {
        public a() {
            super(1, 1, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue());
            setThreadFactory(new b(null));
            allowCoreThreadTimeOut(true);
        }

        @Override // java.util.concurrent.AbstractExecutorService
        public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
            return new C1537m4(this, runnable, t);
        }
    }

    /* renamed from: com.sonelli.k4$b */
    /* loaded from: classes.dex */
    public static class b implements ThreadFactory {

        /* renamed from: a */
        public static final AtomicInteger f4475a = new AtomicInteger();

        public b() {
        }

        public /* synthetic */ b(RunnableC1489l4 runnableC1489l4) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            int incrementAndGet = f4475a.incrementAndGet();
            StringBuilder sb = new StringBuilder(23);
            sb.append("measurement-");
            sb.append(incrementAndGet);
            return new c(runnable, sb.toString());
        }
    }

    /* renamed from: com.sonelli.k4$c */
    /* loaded from: classes.dex */
    public static class c extends Thread {
        public c(Runnable runnable, String str) {
            super(runnable, str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    public C1434k4(Context context) {
        Context applicationContext = context.getApplicationContext();
        C0813ca.m2729k(applicationContext);
        this.f4469a = applicationContext;
        this.f4471c = new a();
        this.f4470b = new CopyOnWriteArrayList();
        new C0969f4();
    }

    /* renamed from: i */
    public static void m5823i() {
        if (!(Thread.currentThread() instanceof c)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    /* renamed from: j */
    public static C1434k4 m5824j(Context context) {
        C0813ca.m2729k(context);
        if (f4468f == null) {
            synchronized (C1434k4.class) {
                if (f4468f == null) {
                    f4468f = new C1434k4(context);
                }
            }
        }
        return f4468f;
    }

    /* renamed from: l */
    public static void m5826l(C1093h4 c1093h4) {
        C0813ca.m2728j("deliver should be called from worker thread");
        C0813ca.m2720b(c1093h4.m4358i(), "Measurement must be submitted");
        List<zzo> m4355f = c1093h4.m4355f();
        if (m4355f.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (zzo zzoVar : m4355f) {
            Uri mo835l = zzoVar.mo835l();
            if (!hashSet.contains(mo835l)) {
                hashSet.add(mo835l);
                zzoVar.mo836n(c1093h4);
            }
        }
    }

    /* renamed from: a */
    public final Context m5827a() {
        return this.f4469a;
    }

    /* renamed from: c */
    public final <V> Future<V> m5828c(Callable<V> callable) {
        C0813ca.m2729k(callable);
        if (!(Thread.currentThread() instanceof c)) {
            return this.f4471c.submit(callable);
        }
        FutureTask futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    /* renamed from: e */
    public final void m5829e(Runnable runnable) {
        C0813ca.m2729k(runnable);
        this.f4471c.submit(runnable);
    }

    /* renamed from: f */
    public final void m5830f(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f4473e = uncaughtExceptionHandler;
    }

    /* renamed from: g */
    public final C1455ki m5831g() {
        if (this.f4472d == null) {
            synchronized (this) {
                if (this.f4472d == null) {
                    C1455ki c1455ki = new C1455ki();
                    PackageManager packageManager = this.f4469a.getPackageManager();
                    String packageName = this.f4469a.getPackageName();
                    c1455ki.m5902e(packageName);
                    c1455ki.m5903f(packageManager.getInstallerPackageName(packageName));
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(this.f4469a.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        String valueOf = String.valueOf(packageName);
                        Log.e("GAv4", valueOf.length() != 0 ? "Error retrieving package info: appName set to ".concat(valueOf) : new String("Error retrieving package info: appName set to "));
                    }
                    c1455ki.m5904g(packageName);
                    c1455ki.m5905h(str);
                    this.f4472d = c1455ki;
                }
            }
        }
        return this.f4472d;
    }

    /* renamed from: h */
    public final C1704pi m5832h() {
        DisplayMetrics displayMetrics = this.f4469a.getResources().getDisplayMetrics();
        C1704pi c1704pi = new C1704pi();
        c1704pi.m7321f(C0713ai.m2074c(Locale.getDefault()));
        c1704pi.f5665c = displayMetrics.widthPixels;
        c1704pi.f5666d = displayMetrics.heightPixels;
        return c1704pi;
    }

    /* renamed from: m */
    public final void m5833m(C1093h4 c1093h4) {
        if (c1093h4.m4361l()) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        }
        if (c1093h4.m4358i()) {
            throw new IllegalStateException("Measurement can only be submitted once");
        }
        C1093h4 m4353d = c1093h4.m4353d();
        m4353d.m4359j();
        this.f4471c.execute(new RunnableC1489l4(this, m4353d));
    }
}
