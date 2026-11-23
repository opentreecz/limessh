package com.sonelli;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.OnCompleteListener;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final class me0 implements ServiceConnection {

    /* renamed from: a */
    public final Context f5024a;

    /* renamed from: b */
    public final Intent f5025b;

    /* renamed from: c */
    public final ScheduledExecutorService f5026c;

    /* renamed from: d */
    public final Queue<le0> f5027d;

    /* renamed from: e */
    @Nullable
    public ie0 f5028e;

    /* renamed from: f */
    @GuardedBy("this")
    public boolean f5029f;

    public me0(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new ThreadFactoryC1755qc("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    @VisibleForTesting
    public me0(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f5027d = new ArrayDeque();
        this.f5029f = false;
        Context applicationContext = context.getApplicationContext();
        this.f5024a = applicationContext;
        this.f5025b = new Intent(str).setPackage(applicationContext.getPackageName());
        this.f5026c = scheduledExecutorService;
    }

    /* renamed from: a */
    public final synchronized j60<Void> m6404a(Intent intent) {
        final le0 le0Var;
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "new intent queued in the bind-strategy delivery");
        }
        le0Var = new le0(intent);
        ScheduledExecutorService scheduledExecutorService = this.f5026c;
        final ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new Runnable(le0Var) { // from class: com.sonelli.oe0

            /* renamed from: O */
            public final le0 f5477O;

            {
                this.f5477O = le0Var;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f5477O.m6154c();
            }
        }, 9000L, TimeUnit.MILLISECONDS);
        le0Var.m6152a().mo2690c(scheduledExecutorService, new OnCompleteListener(schedule) { // from class: com.sonelli.ne0

            /* renamed from: a */
            public final ScheduledFuture f5260a;

            {
                this.f5260a = schedule;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            /* renamed from: a */
            public final void mo1554a(j60 j60Var) {
                this.f5260a.cancel(false);
            }
        });
        this.f5027d.add(le0Var);
        m6405b();
        return le0Var.m6152a();
    }

    /* renamed from: b */
    public final synchronized void m6405b() {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "flush queue called");
        }
        while (!this.f5027d.isEmpty()) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "found intent to be delivered");
            }
            ie0 ie0Var = this.f5028e;
            if (ie0Var == null || !ie0Var.isBinderAlive()) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    boolean z = !this.f5029f;
                    StringBuilder sb = new StringBuilder(39);
                    sb.append("binder is dead. start connection? ");
                    sb.append(z);
                    Log.d("FirebaseInstanceId", sb.toString());
                }
                if (!this.f5029f) {
                    this.f5029f = true;
                    try {
                    } catch (SecurityException e) {
                        Log.e("FirebaseInstanceId", "Exception while binding the service", e);
                    }
                    if (C1926tb.m8637b().m8638a(this.f5024a, this.f5025b, this, 65)) {
                        return;
                    }
                    Log.e("FirebaseInstanceId", "binding to the service failed");
                    this.f5029f = false;
                    m6406c();
                }
                return;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "binder is alive, sending the intent.");
            }
            this.f5028e.m4752a(this.f5027d.poll());
        }
    }

    @GuardedBy("this")
    /* renamed from: c */
    public final void m6406c() {
        while (!this.f5027d.isEmpty()) {
            this.f5027d.poll().m6153b();
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
            sb.append("onServiceConnected: ");
            sb.append(valueOf);
            Log.d("FirebaseInstanceId", sb.toString());
        }
        this.f5029f = false;
        if (iBinder instanceof ie0) {
            this.f5028e = (ie0) iBinder;
            m6405b();
            return;
        }
        String valueOf2 = String.valueOf(iBinder);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 28);
        sb2.append("Invalid service connection: ");
        sb2.append(valueOf2);
        Log.e("FirebaseInstanceId", sb2.toString());
        m6406c();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("onServiceDisconnected: ");
            sb.append(valueOf);
            Log.d("FirebaseInstanceId", sb.toString());
        }
        m6405b();
    }
}
