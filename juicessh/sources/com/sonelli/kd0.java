package com.sonelli;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.MainThread;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final class kd0 implements ServiceConnection {

    /* renamed from: a */
    @GuardedBy("this")
    public int f4515a;

    /* renamed from: b */
    public final Messenger f4516b;

    /* renamed from: c */
    public sd0 f4517c;

    /* renamed from: d */
    @GuardedBy("this")
    public final Queue<ud0<?>> f4518d;

    /* renamed from: e */
    @GuardedBy("this")
    public final SparseArray<ud0<?>> f4519e;

    /* renamed from: f */
    public final /* synthetic */ jd0 f4520f;

    public kd0(jd0 jd0Var) {
        this.f4520f = jd0Var;
        this.f4515a = 0;
        this.f4516b = new Messenger(new HandlerC1158if(Looper.getMainLooper(), new Handler.Callback(this) { // from class: com.sonelli.nd0

            /* renamed from: a */
            public final kd0 f5259a;

            {
                this.f5259a = this;
            }

            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f5259a.m5870d(message);
            }
        }));
        this.f4518d = new ArrayDeque();
        this.f4519e = new SparseArray<>();
    }

    /* renamed from: a */
    public final void m5867a() {
        ScheduledExecutorService scheduledExecutorService;
        scheduledExecutorService = this.f4520f.f3545b;
        scheduledExecutorService.execute(new Runnable(this) { // from class: com.sonelli.od0

            /* renamed from: O */
            public final kd0 f5475O;

            {
                this.f5475O = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                final ud0<?> poll;
                ScheduledExecutorService scheduledExecutorService2;
                Context context;
                final kd0 kd0Var = this.f5475O;
                while (true) {
                    synchronized (kd0Var) {
                        if (kd0Var.f4515a != 2) {
                            return;
                        }
                        if (kd0Var.f4518d.isEmpty()) {
                            kd0Var.m5872f();
                            return;
                        }
                        poll = kd0Var.f4518d.poll();
                        kd0Var.f4519e.put(poll.f6949a, poll);
                        scheduledExecutorService2 = kd0Var.f4520f.f3545b;
                        scheduledExecutorService2.schedule(new Runnable(kd0Var, poll) { // from class: com.sonelli.qd0

                            /* renamed from: O */
                            public final kd0 f5973O;

                            /* renamed from: P */
                            public final ud0 f5974P;

                            {
                                this.f5973O = kd0Var;
                                this.f5974P = poll;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f5973O.m5868b(this.f5974P.f6949a);
                            }
                        }, 30L, TimeUnit.SECONDS);
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        String valueOf = String.valueOf(poll);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
                        sb.append("Sending ");
                        sb.append(valueOf);
                        Log.d("MessengerIpcClient", sb.toString());
                    }
                    context = kd0Var.f4520f.f3544a;
                    Messenger messenger = kd0Var.f4516b;
                    Message obtain = Message.obtain();
                    obtain.what = poll.f6951c;
                    obtain.arg1 = poll.f6949a;
                    obtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", poll.mo8870d());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", poll.f6952d);
                    obtain.setData(bundle);
                    try {
                        kd0Var.f4517c.m8426a(obtain);
                    } catch (RemoteException e) {
                        kd0Var.m5869c(2, e.getMessage());
                    }
                }
            }
        });
    }

    /* renamed from: b */
    public final synchronized void m5868b(int i) {
        ud0<?> ud0Var = this.f4519e.get(i);
        if (ud0Var != null) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Timing out request: ");
            sb.append(i);
            Log.w("MessengerIpcClient", sb.toString());
            this.f4519e.remove(i);
            ud0Var.m8868b(new td0(3, "Timed out waiting for response"));
            m5872f();
        }
    }

    /* renamed from: c */
    public final synchronized void m5869c(int i, String str) {
        Context context;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", valueOf.length() != 0 ? "Disconnected: ".concat(valueOf) : new String("Disconnected: "));
        }
        int i2 = this.f4515a;
        if (i2 == 0) {
            throw new IllegalStateException();
        }
        if (i2 != 1 && i2 != 2) {
            if (i2 == 3) {
                this.f4515a = 4;
                return;
            } else {
                if (i2 == 4) {
                    return;
                }
                int i3 = this.f4515a;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i3);
                throw new IllegalStateException(sb.toString());
            }
        }
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Unbinding service");
        }
        this.f4515a = 4;
        C1926tb m8637b = C1926tb.m8637b();
        context = this.f4520f.f3544a;
        m8637b.m8639c(context, this);
        td0 td0Var = new td0(i, str);
        Iterator<ud0<?>> it = this.f4518d.iterator();
        while (it.hasNext()) {
            it.next().m8868b(td0Var);
        }
        this.f4518d.clear();
        for (int i4 = 0; i4 < this.f4519e.size(); i4++) {
            this.f4519e.valueAt(i4).m8868b(td0Var);
        }
        this.f4519e.clear();
    }

    /* renamed from: d */
    public final boolean m5870d(Message message) {
        int i = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Received response to request: ");
            sb.append(i);
            Log.d("MessengerIpcClient", sb.toString());
        }
        synchronized (this) {
            ud0<?> ud0Var = this.f4519e.get(i);
            if (ud0Var == null) {
                StringBuilder sb2 = new StringBuilder(50);
                sb2.append("Received response for unknown request: ");
                sb2.append(i);
                Log.w("MessengerIpcClient", sb2.toString());
                return true;
            }
            this.f4519e.remove(i);
            m5872f();
            Bundle data = message.getData();
            if (data.getBoolean("unsupported", false)) {
                ud0Var.m8868b(new td0(4, "Not supported by GmsCore"));
            } else {
                ud0Var.mo8867a(data);
            }
            return true;
        }
    }

    /* renamed from: e */
    public final synchronized boolean m5871e(ud0<?> ud0Var) {
        Context context;
        ScheduledExecutorService scheduledExecutorService;
        int i = this.f4515a;
        if (i == 0) {
            this.f4518d.add(ud0Var);
            C0813ca.m2732n(this.f4515a == 0);
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.f4515a = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            C1926tb m8637b = C1926tb.m8637b();
            context = this.f4520f.f3544a;
            if (m8637b.m8638a(context, intent, this, 1)) {
                scheduledExecutorService = this.f4520f.f3545b;
                scheduledExecutorService.schedule(new Runnable(this) { // from class: com.sonelli.md0

                    /* renamed from: O */
                    public final kd0 f5023O;

                    {
                        this.f5023O = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f5023O.m5873g();
                    }
                }, 30L, TimeUnit.SECONDS);
            } else {
                m5869c(0, "Unable to bind to service");
            }
            return true;
        }
        if (i == 1) {
            this.f4518d.add(ud0Var);
            return true;
        }
        if (i == 2) {
            this.f4518d.add(ud0Var);
            m5867a();
            return true;
        }
        if (i != 3 && i != 4) {
            int i2 = this.f4515a;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Unknown state: ");
            sb.append(i2);
            throw new IllegalStateException(sb.toString());
        }
        return false;
    }

    /* renamed from: f */
    public final synchronized void m5872f() {
        Context context;
        if (this.f4515a == 2 && this.f4518d.isEmpty() && this.f4519e.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.f4515a = 3;
            C1926tb m8637b = C1926tb.m8637b();
            context = this.f4520f.f3544a;
            m8637b.m8639c(context, this);
        }
    }

    /* renamed from: g */
    public final synchronized void m5873g() {
        if (this.f4515a == 1) {
            m5869c(1, "Timed out while binding");
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        ScheduledExecutorService scheduledExecutorService;
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        scheduledExecutorService = this.f4520f.f3545b;
        scheduledExecutorService.execute(new Runnable(this, iBinder) { // from class: com.sonelli.pd0

            /* renamed from: O */
            public final kd0 f5653O;

            /* renamed from: P */
            public final IBinder f5654P;

            {
                this.f5653O = this;
                this.f5654P = iBinder;
            }

            @Override // java.lang.Runnable
            public final void run() {
                kd0 kd0Var = this.f5653O;
                IBinder iBinder2 = this.f5654P;
                synchronized (kd0Var) {
                    try {
                        if (iBinder2 == null) {
                            kd0Var.m5869c(0, "Null service connection");
                            return;
                        }
                        try {
                            kd0Var.f4517c = new sd0(iBinder2);
                            kd0Var.f4515a = 2;
                            kd0Var.m5867a();
                        } catch (RemoteException e) {
                            kd0Var.m5869c(0, e.getMessage());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        ScheduledExecutorService scheduledExecutorService;
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        scheduledExecutorService = this.f4520f.f3545b;
        scheduledExecutorService.execute(new Runnable(this) { // from class: com.sonelli.rd0

            /* renamed from: O */
            public final kd0 f6203O;

            {
                this.f6203O = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f6203O.m5869c(2, "Service disconnected");
            }
        });
    }
}
