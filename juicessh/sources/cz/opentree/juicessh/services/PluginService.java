package cz.opentree.juicessh.services;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import cz.opentree.ai0;
import cz.opentree.ek0;
import cz.opentree.fk0;
import cz.opentree.ji0;
import cz.opentree.juicessh.connections.ConnectionManager;
import cz.opentree.juicessh.connections.transports.TerminalSessionProvider;
import cz.opentree.juicessh.models.PluginLog;
import cz.opentree.juicessh.pluginlibrary.IConnectionPluginService;
import cz.opentree.juicessh.pluginlibrary.IPluginService;
import cz.opentree.juicessh.pluginlibrary.listeners.IPingListener;
import cz.opentree.juicessh.pluginlibrary.listeners.ISessionExecuteListener;
import cz.opentree.juicessh.pluginlibrary.listeners.ISessionFinishedListener;
import cz.opentree.uj0;
import java.util.UUID;

/* loaded from: classes.dex */
public class PluginService extends Service {

    /* renamed from: cz.opentree.juicessh.services.PluginService$a */
    /* loaded from: classes.dex */
    public class BinderC1387a extends IPluginService.AbstractBinderC1354a {

        /* renamed from: a */
        public IConnectionPluginService.AbstractBinderC1353a f4207a;

        /* renamed from: cz.opentree.juicessh.services.PluginService$a$a */
        /* loaded from: classes.dex */
        public class a implements ConnectionManager.ChainRequest {

            /* renamed from: a */
            public final /* synthetic */ int f4209a;

            /* renamed from: b */
            public final /* synthetic */ String f4210b;

            /* renamed from: c */
            public final /* synthetic */ String f4211c;

            /* renamed from: d */
            public final /* synthetic */ String f4212d;

            public a(int i, String str, String str2, String str3) {
                this.f4209a = i;
                this.f4210b = str;
                this.f4211c = str2;
                this.f4212d = str3;
            }

            @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
            /* renamed from: a */
            public UUID mo5334a() {
                return UUID.fromString(this.f4210b);
            }

            @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
            /* renamed from: b */
            public void mo5335b(ai0 ai0Var) {
                Object m2102p = ai0Var.m2102p();
                if (!TerminalSessionProvider.class.isAssignableFrom(m2102p.getClass())) {
                    PluginLog.m5491s(PluginService.this.getApplicationContext(), this.f4211c, "Attempted to write to a non-terminal providing session");
                    return;
                }
                PluginLog.m5491s(PluginService.this.getApplicationContext(), this.f4211c, "Wrote: '" + this.f4212d + "' to session " + ai0Var.m2102p().mo2815k().m5471w());
                ((TerminalSessionProvider) m2102p).mo3213e().write(this.f4212d);
            }

            @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
            /* renamed from: c */
            public void mo5336c() {
                PluginLog.m5491s(PluginService.this.getApplicationContext(), this.f4211c, "Attempted to write command: '" + this.f4212d + "' but the requested session doesn't exist");
            }

            @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
            /* renamed from: d */
            public int mo5337d() {
                return this.f4209a;
            }

            @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
            /* renamed from: e */
            public void mo5338e() {
                PluginLog.m5491s(PluginService.this.getApplicationContext(), this.f4211c, "Attempted to write command: '" + this.f4212d + "' but the requested session doesn't exist");
            }
        }

        /* renamed from: cz.opentree.juicessh.services.PluginService$a$b */
        /* loaded from: classes.dex */
        public class b implements ConnectionManager.ChainRequest {

            /* renamed from: a */
            public final /* synthetic */ int f4214a;

            /* renamed from: b */
            public final /* synthetic */ String f4215b;

            /* renamed from: c */
            public final /* synthetic */ String f4216c;

            /* renamed from: d */
            public final /* synthetic */ ISessionExecuteListener f4217d;

            /* renamed from: e */
            public final /* synthetic */ String f4218e;

            /* renamed from: cz.opentree.juicessh.services.PluginService$a$b$a */
            /* loaded from: classes.dex */
            public class a extends fk0.AbstractC0995a {

                /* renamed from: a */
                public final /* synthetic */ ai0 f4220a;

                public a(ai0 ai0Var) {
                    this.f4220a = ai0Var;
                }

                @Override // cz.opentree.fk0.AbstractC0995a
                /* renamed from: a */
                public void mo3777a(int i) {
                    super.mo3777a(i);
                    PluginLog.m5491s(PluginService.this.getApplicationContext(), b.this.f4218e, "Executed command: '" + b.this.f4216c + "' on connection " + this.f4220a.m2102p().mo2815k().m5471w() + " and got exit status " + i);
                    try {
                        b.this.f4217d.mo5586x(i);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }

                @Override // cz.opentree.fk0.AbstractC0995a
                /* renamed from: b */
                public void mo3778b(String str) {
                    super.mo3778b(str);
                    try {
                        b.this.f4217d.mo5584N(str);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }

            public b(int i, String str, String str2, ISessionExecuteListener iSessionExecuteListener, String str3) {
                this.f4214a = i;
                this.f4215b = str;
                this.f4216c = str2;
                this.f4217d = iSessionExecuteListener;
                this.f4218e = str3;
            }

            @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
            /* renamed from: a */
            public UUID mo5334a() {
                return UUID.fromString(this.f4215b);
            }

            @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
            /* renamed from: b */
            public void mo5335b(ai0 ai0Var) {
                if (ai0Var.m2102p() instanceof ji0) {
                    try {
                        ((ji0) ai0Var.m2102p()).m5128y().m2845f(this.f4216c, new a(ai0Var));
                        return;
                    } catch (ek0 e) {
                        e.printStackTrace();
                        return;
                    }
                }
                try {
                    this.f4217d.mo5585O(1, "Can only execute commands on SSH sessions (not mosh/telnet/local)");
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }

            @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
            /* renamed from: c */
            public void mo5336c() {
                PluginLog.m5491s(PluginService.this.getApplicationContext(), this.f4218e, "Attempted to executed command: '" + this.f4216c + "' but the requested session doesn't exist");
            }

            @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
            /* renamed from: d */
            public int mo5337d() {
                return this.f4214a;
            }

            @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
            /* renamed from: e */
            public void mo5338e() {
                PluginLog.m5491s(PluginService.this.getApplicationContext(), this.f4218e, "Attempted to executed command: '" + this.f4216c + "' but was denied access");
            }
        }

        public BinderC1387a() {
            this.f4207a = new uj0(PluginService.this.getApplicationContext());
        }

        @Override // cz.opentree.juicessh.pluginlibrary.IPluginService
        /* renamed from: Z */
        public void mo5549Z(int i, String str) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268566528);
            intent.setData(Uri.parse("ssh://" + i + "/resume"));
            intent.putExtra("session_key", str);
            PluginService.this.getApplicationContext().startActivity(intent);
            String m5490r = PluginLog.m5490r(PluginService.this.getApplicationContext());
            PluginLog.m5491s(PluginService.this.getApplicationContext(), m5490r, "Attached to session " + i);
        }

        @Override // cz.opentree.juicessh.pluginlibrary.IPluginService
        /* renamed from: f0 */
        public void mo5550f0(int i, String str, String str2) {
            ConnectionManager.m5349b(PluginService.this.getApplicationContext(), new a(i, str, PluginLog.m5490r(PluginService.this.getApplicationContext()), str2));
        }

        @Override // cz.opentree.juicessh.pluginlibrary.IPluginService
        @Deprecated
        /* renamed from: k */
        public void mo5551k(String str) throws RemoteException {
            this.f4207a.mo5545k(str);
        }

        @Override // cz.opentree.juicessh.pluginlibrary.IPluginService
        @Deprecated
        /* renamed from: l */
        public void mo5552l(IPingListener iPingListener) throws RemoteException {
            this.f4207a.mo5546l(iPingListener);
        }

        @Override // cz.opentree.juicessh.pluginlibrary.IPluginService
        @Deprecated
        /* renamed from: n */
        public void mo5553n(int i, String str, ISessionFinishedListener iSessionFinishedListener) throws RemoteException {
            this.f4207a.mo5547n(i, str, iSessionFinishedListener);
        }

        @Override // cz.opentree.juicessh.pluginlibrary.IPluginService
        @Deprecated
        /* renamed from: o */
        public void mo5554o(int i, String str) throws RemoteException {
            this.f4207a.mo5548o(i, str);
        }

        @Override // cz.opentree.juicessh.pluginlibrary.IPluginService
        /* renamed from: w0 */
        public void mo5555w0(int i, String str, String str2, ISessionExecuteListener iSessionExecuteListener) {
            ConnectionManager.m5349b(PluginService.this.getApplicationContext(), new b(i, str, str2, iSessionExecuteListener, PluginLog.m5490r(PluginService.this.getApplicationContext())));
        }
    }

    public PluginService() {
        new Handler();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new BinderC1387a();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
