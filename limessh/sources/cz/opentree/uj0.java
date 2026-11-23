package cz.opentree;

import android.content.Context;
import android.os.RemoteException;
import cz.opentree.limessh.connections.ConnectionManager;
import cz.opentree.limessh.connections.listeners.BasicTransportChainListener;
import cz.opentree.limessh.models.Connection;
import cz.opentree.limessh.models.PluginLog;
import cz.opentree.limessh.pluginlibrary.IConnectionPluginService;
import cz.opentree.limessh.pluginlibrary.listeners.IPingListener;
import cz.opentree.limessh.pluginlibrary.listeners.ISessionFinishedListener;
import java.util.UUID;

/* compiled from: ConnectionPluginServiceStub.java */
/* loaded from: classes.dex */
public class uj0 extends IConnectionPluginService.AbstractBinderC1353a {

    /* renamed from: a */
    public Context f6985a;

    /* compiled from: ConnectionPluginServiceStub.java */
    /* renamed from: cz.opentree.uj0$a */
    /* loaded from: classes.dex */
    public class C2014a implements ConnectionManager.ChainRequest {

        /* renamed from: a */
        public final /* synthetic */ int f6986a;

        /* renamed from: b */
        public final /* synthetic */ String f6987b;

        /* renamed from: c */
        public final /* synthetic */ ISessionFinishedListener f6988c;

        /* compiled from: ConnectionPluginServiceStub.java */
        /* renamed from: cz.opentree.uj0$a$a */
        /* loaded from: classes.dex */
        public class a implements BasicTransportChainListener {
            public a() {
            }

            @Override // cz.opentree.limessh.connections.listeners.BasicTransportChainListener
            /* renamed from: a */
            public void mo3218a() {
                try {
                    C2014a.this.f6988c.mo5589t0();
                } catch (RemoteException unused) {
                }
            }

            @Override // cz.opentree.limessh.connections.listeners.BasicTransportChainListener
            /* renamed from: b */
            public void mo3219b(int i, UUID uuid) {
            }
        }

        public C2014a(uj0 uj0Var, int i, String str, ISessionFinishedListener iSessionFinishedListener) {
            this.f6986a = i;
            this.f6987b = str;
            this.f6988c = iSessionFinishedListener;
        }

        @Override // cz.opentree.limessh.connections.ConnectionManager.ChainRequest
        /* renamed from: a */
        public UUID mo5334a() {
            return UUID.fromString(this.f6987b);
        }

        @Override // cz.opentree.limessh.connections.ConnectionManager.ChainRequest
        /* renamed from: b */
        public void mo5335b(ai0 ai0Var) {
            ai0Var.m2098l().m2506m(new a());
        }

        @Override // cz.opentree.limessh.connections.ConnectionManager.ChainRequest
        /* renamed from: c */
        public void mo5336c() {
        }

        @Override // cz.opentree.limessh.connections.ConnectionManager.ChainRequest
        /* renamed from: d */
        public int mo5337d() {
            return this.f6986a;
        }

        @Override // cz.opentree.limessh.connections.ConnectionManager.ChainRequest
        /* renamed from: e */
        public void mo5338e() {
        }
    }

    /* compiled from: ConnectionPluginServiceStub.java */
    /* renamed from: cz.opentree.uj0$b */
    /* loaded from: classes.dex */
    public class C2015b implements ConnectionManager.ChainRequest {

        /* renamed from: a */
        public final /* synthetic */ int f6990a;

        /* renamed from: b */
        public final /* synthetic */ String f6991b;

        /* renamed from: c */
        public final /* synthetic */ String f6992c;

        public C2015b(int i, String str, String str2) {
            this.f6990a = i;
            this.f6991b = str;
            this.f6992c = str2;
        }

        @Override // cz.opentree.limessh.connections.ConnectionManager.ChainRequest
        /* renamed from: a */
        public UUID mo5334a() {
            return UUID.fromString(this.f6991b);
        }

        @Override // cz.opentree.limessh.connections.ConnectionManager.ChainRequest
        /* renamed from: b */
        public void mo5335b(ai0 ai0Var) {
        }

        @Override // cz.opentree.limessh.connections.ConnectionManager.ChainRequest
        /* renamed from: c */
        public void mo5336c() {
            PluginLog.m5491s(uj0.this.f6985a, this.f6992c, "Attempted to disconnect an invalid session");
        }

        @Override // cz.opentree.limessh.connections.ConnectionManager.ChainRequest
        /* renamed from: d */
        public int mo5337d() {
            return this.f6990a;
        }

        @Override // cz.opentree.limessh.connections.ConnectionManager.ChainRequest
        /* renamed from: e */
        public void mo5338e() {
            PluginLog.m5491s(uj0.this.f6985a, this.f6992c, "Attempted to disconnect a session but was denied access");
        }
    }

    public uj0(Context context) {
        this.f6985a = context;
    }

    @Override // cz.opentree.limessh.pluginlibrary.IConnectionPluginService
    /* renamed from: k */
    public void mo5545k(String str) throws RemoteException {
        String m5490r = PluginLog.m5490r(this.f6985a);
        String m5464t = Connection.m5464t(this.f6985a, str);
        if (m5464t != null) {
            PluginLog.m5491s(this.f6985a, m5490r, "Opened a session to " + m5464t);
            return;
        }
        PluginLog.m5491s(this.f6985a, m5490r, "Opened a session to unknown connection (id:" + str + ")");
    }

    @Override // cz.opentree.limessh.pluginlibrary.IConnectionPluginService
    /* renamed from: l */
    public void mo5546l(IPingListener iPingListener) throws RemoteException {
        PluginLog.m5491s(this.f6985a, PluginLog.m5490r(this.f6985a), "Sent a PING");
        iPingListener.mo5581z();
    }

    @Override // cz.opentree.limessh.pluginlibrary.IConnectionPluginService
    /* renamed from: n */
    public void mo5547n(int i, String str, ISessionFinishedListener iSessionFinishedListener) throws RemoteException {
        ConnectionManager.m5349b(this.f6985a, new C2014a(this, i, str, iSessionFinishedListener));
    }

    @Override // cz.opentree.limessh.pluginlibrary.IConnectionPluginService
    /* renamed from: o */
    public void mo5548o(int i, String str) throws RemoteException {
        String m5490r = PluginLog.m5490r(this.f6985a);
        PluginLog.m5491s(this.f6985a, m5490r, "Disconnected session " + i);
        ConnectionManager.m5348a(this.f6985a, new C2015b(i, str, m5490r));
    }
}
