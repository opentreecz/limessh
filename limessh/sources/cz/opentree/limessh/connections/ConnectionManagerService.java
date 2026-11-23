package cz.opentree.limessh.connections;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import cz.opentree.ai0;
import cz.opentree.gj0;
import cz.opentree.limessh.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class ConnectionManagerService extends Service {

    /* renamed from: V */
    public static AtomicBoolean f3966V = new AtomicBoolean(false);

    /* renamed from: O */
    public NotificationManager f3967O;

    /* renamed from: P */
    public int f3968P;

    /* renamed from: Q */
    public Thread f3969Q;

    /* renamed from: R */
    public PowerManager.WakeLock f3970R;

    /* renamed from: S */
    public WifiManager.WifiLock f3971S;

    /* renamed from: T */
    public Thread f3972T = new Thread(new RunnableC1319a());

    /* renamed from: U */
    public HashMap<Integer, ai0> f3973U = new HashMap<>();

    /* renamed from: cz.opentree.limessh.connections.ConnectionManagerService$a */
    /* loaded from: classes.dex */
    public class RunnableC1319a implements Runnable {
        public RunnableC1319a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(60000);
                if (ConnectionManagerService.this.f3972T.isInterrupted() || ConnectionManagerService.this.f3973U.size() != 0) {
                    return;
                }
                gj0.m4142c("ConnectionManagerService", "Have waited 60000ms since service creation and still haven't registered any chains. KAMIKAZE!");
                ConnectionManagerService.this.stopSelf();
            } catch (InterruptedException unused) {
            }
        }
    }

    /* renamed from: cz.opentree.limessh.connections.ConnectionManagerService$b */
    /* loaded from: classes.dex */
    public class RunnableC1320b implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ Handler f3975O;

        /* renamed from: cz.opentree.limessh.connections.ConnectionManagerService$b$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: O */
            public final /* synthetic */ ai0 f3977O;

            public a(ai0 ai0Var) {
                this.f3977O = ai0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                ConnectionManagerService.this.f3967O.notify(this.f3977O.f1399b, this.f3977O.m2101o().build());
            }
        }

        public RunnableC1320b(Handler handler) {
            this.f3975O = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            boolean z2;
            while (Thread.currentThread() == ConnectionManagerService.this.f3969Q) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                }
                Iterator<ai0> it = ConnectionManagerService.this.f3973U.values().iterator();
                while (true) {
                    z = true;
                    if (it.hasNext()) {
                        if (it.next().m2102p().mo2816p()) {
                            z2 = true;
                            break;
                        }
                    } else {
                        z2 = false;
                        break;
                    }
                }
                Iterator<ai0> it2 = ConnectionManagerService.this.f3973U.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next().m2102p().mo2817q()) {
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z2) {
                    if (!ConnectionManagerService.this.f3970R.isHeld()) {
                        gj0.m4142c("ConnectionManagerService", "Acquiring a wakelock for ConnectionManagerService");
                        ConnectionManagerService.this.f3970R.acquire();
                    }
                } else if (ConnectionManagerService.this.f3970R.isHeld()) {
                    gj0.m4142c("ConnectionManagerService", "Releasing wakelock for ConnectionManagerService");
                    try {
                        ConnectionManagerService.this.f3970R.release();
                    } catch (RuntimeException e) {
                        gj0.m4142c("ConnectionManagerService", "Failed to release wakelock: " + e.getMessage());
                    }
                }
                if (z) {
                    if (!ConnectionManagerService.this.f3971S.isHeld()) {
                        gj0.m4142c("ConnectionManagerService", "Acquiring a wifilock for ConnectionManagerService");
                        ConnectionManagerService.this.f3971S.acquire();
                    }
                } else if (ConnectionManagerService.this.f3971S.isHeld()) {
                    gj0.m4142c("ConnectionManagerService", "Releasing wifilock for ConnectionManagerService");
                    try {
                        ConnectionManagerService.this.f3971S.release();
                    } catch (RuntimeException e2) {
                        gj0.m4142c("ConnectionManagerService", "Failed to release wifilock: " + e2.getMessage());
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (ai0 ai0Var : ConnectionManagerService.this.f3973U.values()) {
                    if (!ai0Var.m2106t()) {
                        arrayList.add(ai0Var);
                    }
                }
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    ai0 ai0Var2 = (ai0) it3.next();
                    ConnectionManagerService.this.m5359d(Integer.valueOf(ai0Var2.f1399b));
                    if (ai0Var2.m2100n() != 0 && ai0Var2.m2101o() != null) {
                        try {
                            this.f3975O.post(new a(ai0Var2));
                        } catch (NullPointerException unused2) {
                            gj0.m4142c("ConnectionManagerService", "Couldn't notify of failed connection with an invalid notification");
                        }
                    }
                }
            }
        }
    }

    /* renamed from: cz.opentree.limessh.connections.ConnectionManagerService$c */
    /* loaded from: classes.dex */
    public class BinderC1321c extends Binder {
        public BinderC1321c() {
        }

        /* renamed from: a */
        public ConnectionManagerService m5367a() {
            return ConnectionManagerService.this;
        }
    }

    /* renamed from: h */
    public static boolean m5357h() {
        return f3966V.get();
    }

    /* renamed from: c */
    public void m5358c() {
        m5360e((Integer[]) this.f3973U.keySet().toArray(new Integer[this.f3973U.size()]));
    }

    /* renamed from: d */
    public void m5359d(Integer num) {
        ai0 ai0Var = this.f3973U.get(num);
        if (ai0Var != null) {
            ai0Var.m2096i();
            this.f3973U.remove(num);
            if (this.f3968P == num.intValue()) {
                stopForeground(true);
                if (this.f3973U.size() > 0) {
                    ai0 next = this.f3973U.values().iterator().next();
                    this.f3968P = next.f1399b;
                    gj0.m4141b("ConnectionManagerService", "Using transport chain " + ai0Var.f1399b + " to prevent ConnectionManager from being killed");
                    try {
                        startForeground(this.f3968P, next.m2103q().build());
                    } catch (NullPointerException unused) {
                        gj0.m4142c("ConnectionManagerService", "Couldn't put ConnectionManagerService into foreground mode without a valid notification");
                    }
                }
            } else {
                this.f3967O.cancel(num.intValue());
            }
        } else {
            this.f3967O.cancel(num.intValue());
        }
        if (this.f3973U.size() == 0) {
            stopSelf();
        }
    }

    /* renamed from: e */
    public void m5360e(Integer[] numArr) {
        for (Integer num : numArr) {
            m5359d(Integer.valueOf(num.intValue()));
        }
    }

    /* renamed from: f */
    public Collection<ai0> m5361f() {
        return this.f3973U.values();
    }

    /* renamed from: g */
    public ai0 m5362g(int i, UUID uuid) throws IllegalAccessException {
        ai0 ai0Var = this.f3973U.get(Integer.valueOf(i));
        if (ai0Var == null) {
            return null;
        }
        if (ai0Var.m2097k().toString().equals(uuid.toString())) {
            return ai0Var;
        }
        throw new IllegalAccessException("The session key specified does not match");
    }

    /* renamed from: i */
    public void m5363i(ai0 ai0Var) {
        if (ai0Var == null || ai0Var.m2103q() == null) {
            gj0.m4142c("ConnectionManagerService", "Refusing to register transport chain with null HealthyNotification");
            return;
        }
        if (this.f3973U.size() == 0) {
            this.f3968P = ai0Var.f1399b;
            gj0.m4141b("ConnectionManagerService", "Using transport chain " + ai0Var.f1399b + " to prevent ConnectionManager from being killed");
            try {
                startForeground(ai0Var.f1399b, ai0Var.m2103q().build());
            } catch (NullPointerException unused) {
                gj0.m4142c("ConnectionManagerService", "Couldn't put ConnectionManagerService into foreground mode without a valid notification");
            }
        } else {
            try {
                this.f3967O.notify(ai0Var.f1399b, ai0Var.m2103q().build());
            } catch (NullPointerException unused2) {
                gj0.m4142c("ConnectionManagerService", "Couldn't notify connection with invalid notification");
            }
        }
        this.f3973U.put(Integer.valueOf(ai0Var.f1399b), ai0Var);
    }

    /* renamed from: j */
    public void m5364j(ai0[] ai0VarArr) {
        if (this.f3972T.isAlive()) {
            this.f3972T.interrupt();
        }
        for (ai0 ai0Var : ai0VarArr) {
            m5363i(ai0Var);
        }
    }

    /* renamed from: k */
    public synchronized void m5365k() {
        this.f3970R = ((PowerManager) getApplicationContext().getSystemService("power")).newWakeLock(1, "LimeSSH: background sessions");
        this.f3971S = ((WifiManager) getApplicationContext().getSystemService("wifi")).createWifiLock(1, "LimeSSH background sessions");
        Thread thread = new Thread(new RunnableC1320b(new Handler()));
        this.f3969Q = thread;
        thread.start();
    }

    /* renamed from: l */
    public synchronized void m5366l() {
        PowerManager.WakeLock wakeLock = this.f3970R;
        if (wakeLock != null && wakeLock.isHeld()) {
            gj0.m4142c("ConnectionManagerService", "Releasing wakelock for ConnectionManagerService");
            try {
                this.f3970R.release();
            } catch (RuntimeException e) {
                gj0.m4142c("ConnectionManagerService", "Failed to release wakelock: " + e.getMessage());
            }
        }
        WifiManager.WifiLock wifiLock = this.f3971S;
        if (wifiLock != null && wifiLock.isHeld()) {
            gj0.m4142c("ConnectionManagerService", "Releasing wifilock for ConnectionManagerService");
            try {
                this.f3971S.release();
            } catch (RuntimeException e2) {
                gj0.m4142c("ConnectionManagerService", "Failed to release wifilock: " + e2.getMessage());
            }
        }
        if (this.f3969Q != null) {
            gj0.m4142c("ConnectionManagerService", "Shutting down ConnectionManagerService poller");
            Thread thread = this.f3969Q;
            this.f3969Q = null;
            thread.interrupt();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new BinderC1321c();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        stopForeground(true);
        NotificationChannel notificationChannel = new NotificationChannel("limessh", getString(R.string.app_name), 0);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        notificationManager.createNotificationChannel(notificationChannel);
        gj0.m4141b("ConnectionManagerService", "Creating ConnectionManager Service");
        this.f3967O = notificationManager;
        f3966V.set(true);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        gj0.m4141b("ConnectionManagerService", "Destroying ConnectionManager Service");
        m5358c();
        m5366l();
        f3966V.set(false);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        gj0.m4141b("ConnectionManagerService", "Received start command");
        if (!this.f3972T.isAlive()) {
            this.f3972T.start();
        }
        m5365k();
        f3966V.set(true);
        return 2;
    }
}
