package com.sonelli.juicessh.connections;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.sonelli.ai0;
import com.sonelli.gj0;
import com.sonelli.juicessh.connections.ConnectionManagerService;
import com.sonelli.juicessh.connections.transports.ConnectionProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class ConnectionManager {

    /* renamed from: a */
    public static CopyOnWriteArrayList<ai0> f3959a = new CopyOnWriteArrayList<>();

    /* renamed from: b */
    public static CopyOnWriteArrayList<ChainRequest> f3960b = new CopyOnWriteArrayList<>();

    /* renamed from: c */
    public static CopyOnWriteArrayList<ChainRequest> f3961c = new CopyOnWriteArrayList<>();

    /* renamed from: d */
    public static CopyOnWriteArrayList<ChainQuery> f3962d = new CopyOnWriteArrayList<>();

    /* loaded from: classes.dex */
    public interface ChainQuery {
        /* renamed from: a */
        void mo5353a(List<ai0> list);

        /* renamed from: b */
        ConnectionProvider mo5354b();
    }

    /* loaded from: classes.dex */
    public interface ChainRequest {
        /* renamed from: a */
        UUID mo5334a();

        /* renamed from: b */
        void mo5335b(ai0 ai0Var);

        /* renamed from: c */
        void mo5336c();

        /* renamed from: d */
        int mo5337d();

        /* renamed from: e */
        void mo5338e();
    }

    /* renamed from: com.sonelli.juicessh.connections.ConnectionManager$a */
    /* loaded from: classes.dex */
    public static class RunnableC1317a implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ ChainRequest f3963O;

        /* renamed from: P */
        public final /* synthetic */ ai0 f3964P;

        public RunnableC1317a(ChainRequest chainRequest, ai0 ai0Var) {
            this.f3963O = chainRequest;
            this.f3964P = ai0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3963O.mo5335b(this.f3964P);
        }
    }

    /* renamed from: com.sonelli.juicessh.connections.ConnectionManager$b */
    /* loaded from: classes.dex */
    public static class ServiceConnectionC1318b implements ServiceConnection {

        /* renamed from: a */
        public Context f3965a;

        public ServiceConnectionC1318b(Context context) {
            this.f3965a = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            gj0.m4145f("ConnectionManager", "Bound to ConnectionManager service and processing recent ServiceRequests");
            ConnectionManager.m5351d(((ConnectionManagerService.BinderC1321c) iBinder).m5367a());
            gj0.m4145f("ConnectionManager", "Unbinding from ConnectionManager");
            this.f3965a.unbindService(this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: a */
    public static synchronized void m5348a(Context context, ChainRequest chainRequest) {
        synchronized (ConnectionManager.class) {
            f3960b.add(chainRequest);
            context.bindService(new Intent(context, (Class<?>) ConnectionManagerService.class), new ServiceConnectionC1318b(context), 0);
        }
    }

    /* renamed from: b */
    public static synchronized void m5349b(Context context, ChainRequest chainRequest) {
        synchronized (ConnectionManager.class) {
            gj0.m4145f("ConnectionManager", "Received a get chain request");
            if (ConnectionManagerService.m5357h()) {
                gj0.m4145f("ConnectionManager", "Requesting chain from ConnectionManagerService");
                f3961c.add(chainRequest);
                context.bindService(new Intent(context, (Class<?>) ConnectionManagerService.class), new ServiceConnectionC1318b(context), 0);
                return;
            }
            Iterator<ai0> it = f3959a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ai0 next = it.next();
                if (next.f1399b == chainRequest.mo5337d()) {
                    if (next.m2097k() != chainRequest.mo5334a()) {
                        chainRequest.mo5338e();
                        return;
                    } else if (context instanceof Activity) {
                        ((Activity) context).runOnUiThread(new RunnableC1317a(chainRequest, next));
                    } else {
                        chainRequest.mo5335b(next);
                    }
                }
            }
            chainRequest.mo5336c();
        }
    }

    /* renamed from: c */
    public static synchronized void m5350c(Context context, ChainQuery chainQuery) {
        synchronized (ConnectionManager.class) {
            if (!ConnectionManagerService.m5357h()) {
                chainQuery.mo5353a(new ArrayList());
            } else {
                f3962d.add(chainQuery);
                context.bindService(new Intent(context, (Class<?>) ConnectionManagerService.class), new ServiceConnectionC1318b(context), 0);
            }
        }
    }

    /* renamed from: d */
    public static synchronized void m5351d(ConnectionManagerService connectionManagerService) {
        synchronized (ConnectionManager.class) {
            gj0.m4145f("ConnectionManager", "Bound to ConnectionManager to process pending requests");
            gj0.m4145f("ConnectionManager", "Processing " + f3959a.size() + " REGISTERS.");
            if (!f3959a.isEmpty()) {
                connectionManagerService.m5364j((ai0[]) f3959a.toArray(new ai0[f3960b.size()]));
                f3959a.clear();
            }
            gj0.m4145f("ConnectionManager", "Processing " + f3960b.size() + " DROPS.");
            if (!f3960b.isEmpty()) {
                Iterator<ChainRequest> it = f3960b.iterator();
                while (it.hasNext()) {
                    ChainRequest next = it.next();
                    try {
                        ai0 m5362g = connectionManagerService.m5362g(next.mo5337d(), next.mo5334a());
                        if (m5362g != null) {
                            connectionManagerService.m5359d(Integer.valueOf(next.mo5337d()));
                            next.mo5335b(m5362g);
                        } else {
                            next.mo5336c();
                        }
                    } catch (IllegalAccessException unused) {
                        next.mo5338e();
                    }
                    f3960b.remove(next);
                }
            }
            gj0.m4145f("ConnectionManager", "Processing " + f3961c.size() + " GETS.");
            if (!f3961c.isEmpty()) {
                Iterator<ChainRequest> it2 = f3961c.iterator();
                while (it2.hasNext()) {
                    ChainRequest next2 = it2.next();
                    try {
                        ai0 m5362g2 = connectionManagerService.m5362g(next2.mo5337d(), next2.mo5334a());
                        if (m5362g2 != null) {
                            next2.mo5335b(m5362g2);
                        } else {
                            next2.mo5336c();
                        }
                    } catch (IllegalAccessException unused2) {
                        next2.mo5338e();
                    }
                    f3961c.remove(next2);
                }
            }
            gj0.m4145f("ConnectionManager", "Processing " + f3962d.size() + " QUERIES.");
            if (!f3962d.isEmpty()) {
                Iterator<ChainQuery> it3 = f3962d.iterator();
                while (it3.hasNext()) {
                    ChainQuery next3 = it3.next();
                    ArrayList arrayList = new ArrayList();
                    for (ai0 ai0Var : connectionManagerService.m5361f()) {
                        if (ai0Var.m2099m().getId().toString().equals(next3.mo5354b().getId().toString())) {
                            arrayList.add(ai0Var);
                        }
                    }
                    next3.mo5353a(arrayList);
                    f3962d.remove(next3);
                }
            }
        }
    }

    /* renamed from: e */
    public static synchronized void m5352e(Context context, ai0 ai0Var) {
        synchronized (ConnectionManager.class) {
            gj0.m4141b("ConnectionManager", "ServiceRequest: Registering a new transport chain");
            f3959a.add(ai0Var);
            if (!ConnectionManagerService.m5357h()) {
                gj0.m4141b("ConnectionManager", "Starting the connection manager service");
                context.startService(new Intent(context, (Class<?>) ConnectionManagerService.class));
            }
            context.bindService(new Intent(context, (Class<?>) ConnectionManagerService.class), new ServiceConnectionC1318b(context), 0);
        }
    }
}
