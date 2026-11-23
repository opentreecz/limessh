package cz.opentree.juicessh.services;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import cz.opentree.ai0;
import cz.opentree.ek0;
import cz.opentree.gj0;
import cz.opentree.hi0;
import cz.opentree.juicessh.connections.ConnectionManager;
import cz.opentree.juicessh.connections.listeners.BasicTransportChainListener;
import cz.opentree.juicessh.controllers.SftpControllerInterface;
import cz.opentree.juicessh.models.PluginLog;
import cz.opentree.juicessh.pluginlibrary.ISftpPluginService;
import cz.opentree.juicessh.pluginlibrary.listeners.IAttributesEntryListener;
import cz.opentree.juicessh.pluginlibrary.listeners.ICommandSuccessListener;
import cz.opentree.juicessh.pluginlibrary.listeners.IStatResultListener;
import cz.opentree.juicessh.pluginlibrary.listeners.IStringResultListener;
import cz.opentree.juicessh.pluginlibrary.parcelables.ParcelableAttributesEntry;
import cz.opentree.libssh.adapter.SSHSftp;
import cz.opentree.lk0;
import cz.opentree.yi0;
import java.util.UUID;
import java.util.Vector;

/* loaded from: classes.dex */
public class SftpPluginService extends Service {

    /* renamed from: O */
    public static final Vector<SftpControllerInterface> f4226O = new Vector<>();

    /* loaded from: classes.dex */
    public interface OnActiveSftpShellListener {
        /* renamed from: a */
        void mo5648a(String str);

        /* renamed from: b */
        void mo5649b(hi0 hi0Var, SSHSftp sSHSftp);
    }

    /* loaded from: classes.dex */
    public static class Receiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            gj0.m4145f("SftpPluginService", "Received an Sftp Service intent");
            Uri data = intent.getData();
            if (data == null) {
                gj0.m4142c("SftpPluginService", "Intent has no data. Sftp Service intents require data with the host as job id.");
                return;
            }
            try {
                int parseInt = Integer.parseInt(data.getHost());
                SftpControllerInterface sftpControllerInterface = SftpPluginService.f4226O.get(parseInt);
                if (sftpControllerInterface == null) {
                    gj0.m4142c("SftpPluginService", "Could not find job with that ID!");
                    return;
                }
                String action = intent.getAction();
                action.hashCode();
                char c = 65535;
                switch (action.hashCode()) {
                    case -2126195437:
                        if (action.equals("cz.opentree.juicessh.action.SFTP_CANCEL")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1692897594:
                        if (action.equals("cz.opentree.juicessh.action.SFTP_RESUME")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1051804701:
                        if (action.equals("cz.opentree.juicessh.action.SFTP_PAUSE")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        gj0.m4141b("SftpPluginService", "Cancelling sftp job (ID:" + parseInt + ")");
                        sftpControllerInterface.cancel(true);
                        return;
                    case 1:
                        gj0.m4141b("SftpPluginService", "Resuming sftp job (ID:" + parseInt + ")");
                        sftpControllerInterface.mo5380b();
                        return;
                    case 2:
                        gj0.m4141b("SftpPluginService", "Pausing sftp job (ID:" + parseInt + ")");
                        sftpControllerInterface.pause();
                        return;
                    default:
                        return;
                }
            } catch (NullPointerException | NumberFormatException unused) {
                gj0.m4142c("SftpPluginService", "Improperly formatted Sftp Service intent. Host should be job id.");
            }
        }
    }

    /* renamed from: cz.opentree.juicessh.services.SftpPluginService$a */
    /* loaded from: classes.dex */
    public class BinderC1389a extends ISftpPluginService.AbstractBinderC1355a {

        /* renamed from: a */
        public final String f4227a;

        /* renamed from: cz.opentree.juicessh.services.SftpPluginService$a$a */
        /* loaded from: classes.dex */
        public class a implements OnActiveSftpShellListener {

            /* renamed from: a */
            public final /* synthetic */ IStringResultListener f4229a;

            public a(IStringResultListener iStringResultListener) {
                this.f4229a = iStringResultListener;
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: a */
            public void mo5648a(String str) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to get an active shell");
                try {
                    this.f4229a.mo5598f(str);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                }
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: b */
            public void mo5649b(hi0 hi0Var, SSHSftp sSHSftp) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Got an active shell");
                try {
                    try {
                        String m6222r = sSHSftp.m6222r();
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Successful pwd");
                        this.f4229a.mo5597e(m6222r);
                    } catch (ek0 e) {
                        e.printStackTrace();
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed pwd");
                        this.f4229a.mo5599g(e.getMessage());
                        SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e.getMessage()));
                    }
                } catch (RemoteException e2) {
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                    e2.printStackTrace();
                    SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e2.getMessage()));
                }
            }
        }

        /* renamed from: cz.opentree.juicessh.services.SftpPluginService$a$b */
        /* loaded from: classes.dex */
        public class b implements OnActiveSftpShellListener {

            /* renamed from: a */
            public final /* synthetic */ String f4231a;

            /* renamed from: b */
            public final /* synthetic */ IStringResultListener f4232b;

            public b(String str, IStringResultListener iStringResultListener) {
                this.f4231a = str;
                this.f4232b = iStringResultListener;
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: a */
            public void mo5648a(String str) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to get an active shell");
                try {
                    this.f4232b.mo5598f(str);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                }
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: b */
            public void mo5649b(hi0 hi0Var, SSHSftp sSHSftp) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Got an active shell");
                try {
                    try {
                        String m6223s = sSHSftp.m6223s(this.f4231a);
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Successful readlink");
                        this.f4232b.mo5597e(m6223s);
                    } catch (ek0 e) {
                        e.printStackTrace();
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed readlink");
                        this.f4232b.mo5599g(e.getMessage());
                        SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e.getMessage()));
                    }
                } catch (RemoteException e2) {
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                    e2.printStackTrace();
                    SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e2.getMessage()));
                }
            }
        }

        /* renamed from: cz.opentree.juicessh.services.SftpPluginService$a$c */
        /* loaded from: classes.dex */
        public class c implements OnActiveSftpShellListener {

            /* renamed from: a */
            public final /* synthetic */ String f4234a;

            /* renamed from: b */
            public final /* synthetic */ ICommandSuccessListener f4235b;

            public c(String str, ICommandSuccessListener iCommandSuccessListener) {
                this.f4234a = str;
                this.f4235b = iCommandSuccessListener;
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: a */
            public void mo5648a(String str) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to get an active shell");
                try {
                    this.f4235b.mo5577f(str);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                }
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: b */
            public void mo5649b(hi0 hi0Var, SSHSftp sSHSftp) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Got an active shell");
                try {
                    try {
                        sSHSftp.m6225u(this.f4234a);
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Successful rm");
                        this.f4235b.mo5576d();
                    } catch (ek0 e) {
                        e.printStackTrace();
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed rm");
                        this.f4235b.mo5578g(e.getMessage());
                        SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e.getMessage()));
                    }
                } catch (RemoteException e2) {
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                    e2.printStackTrace();
                    SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e2.getMessage()));
                }
            }
        }

        /* renamed from: cz.opentree.juicessh.services.SftpPluginService$a$d */
        /* loaded from: classes.dex */
        public class d implements OnActiveSftpShellListener {

            /* renamed from: a */
            public final /* synthetic */ String f4237a;

            /* renamed from: b */
            public final /* synthetic */ ICommandSuccessListener f4238b;

            public d(String str, ICommandSuccessListener iCommandSuccessListener) {
                this.f4237a = str;
                this.f4238b = iCommandSuccessListener;
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: a */
            public void mo5648a(String str) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to get an active shell");
                try {
                    this.f4238b.mo5577f(str);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                }
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: b */
            public void mo5649b(hi0 hi0Var, SSHSftp sSHSftp) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Got an active shell");
                try {
                    try {
                        sSHSftp.m6226v(this.f4237a);
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Successful rmdir");
                        this.f4238b.mo5576d();
                    } catch (ek0 e) {
                        e.printStackTrace();
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed rmdir");
                        this.f4238b.mo5578g(e.getMessage());
                        SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e.getMessage()));
                    }
                } catch (RemoteException e2) {
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                    e2.printStackTrace();
                    SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e2.getMessage()));
                }
            }
        }

        /* renamed from: cz.opentree.juicessh.services.SftpPluginService$a$e */
        /* loaded from: classes.dex */
        public class e implements OnActiveSftpShellListener {

            /* renamed from: a */
            public final /* synthetic */ String f4240a;

            /* renamed from: b */
            public final /* synthetic */ IStatResultListener f4241b;

            public e(String str, IStatResultListener iStatResultListener) {
                this.f4240a = str;
                this.f4241b = iStatResultListener;
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: a */
            public void mo5648a(String str) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to get an active shell");
                try {
                    this.f4241b.mo5593f(str);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                }
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: b */
            public void mo5649b(hi0 hi0Var, SSHSftp sSHSftp) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Got an active shell");
                try {
                    try {
                        lk0 m6227w = sSHSftp.m6227w(this.f4240a);
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Successful stat");
                        this.f4241b.mo5592S(new ParcelableAttributesEntry(m6227w));
                    } catch (ek0 e) {
                        e.printStackTrace();
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed stat");
                        this.f4241b.mo5594g(e.getMessage());
                        SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e.getMessage()));
                    }
                } catch (RemoteException e2) {
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                    e2.printStackTrace();
                    SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e2.getMessage()));
                }
            }
        }

        /* renamed from: cz.opentree.juicessh.services.SftpPluginService$a$f */
        /* loaded from: classes.dex */
        public class f implements ConnectionManager.ChainRequest {

            /* renamed from: a */
            public final /* synthetic */ int f4243a;

            /* renamed from: b */
            public final /* synthetic */ String f4244b;

            /* renamed from: c */
            public final /* synthetic */ String f4245c;

            /* renamed from: d */
            public final /* synthetic */ OnActiveSftpShellListener f4246d;

            /* renamed from: cz.opentree.juicessh.services.SftpPluginService$a$f$a */
            /* loaded from: classes.dex */
            public class a implements BasicTransportChainListener {

                /* renamed from: a */
                public final /* synthetic */ ai0 f4248a;

                /* renamed from: b */
                public final /* synthetic */ String f4249b;

                /* renamed from: c */
                public final /* synthetic */ String f4250c;

                public a(ai0 ai0Var, String str, String str2) {
                    this.f4248a = ai0Var;
                    this.f4249b = str;
                    this.f4250c = str2;
                }

                @Override // cz.opentree.juicessh.connections.listeners.BasicTransportChainListener
                /* renamed from: a */
                public void mo3218a() {
                    f.this.f4246d.mo5648a("Failed to reconnect: Cancelled");
                }

                @Override // cz.opentree.juicessh.connections.listeners.BasicTransportChainListener
                /* renamed from: b */
                public void mo3219b(int i, UUID uuid) {
                    hi0 hi0Var = (hi0) this.f4248a.m2102p();
                    String str = this.f4249b;
                    if (str != null) {
                        hi0Var.m4457I(str);
                    }
                    String str2 = this.f4250c;
                    if (str2 != null) {
                        hi0Var.m4456H(str2);
                    }
                    f.this.f4246d.mo5649b(hi0Var, hi0Var.m4454F());
                }
            }

            public f(int i, String str, String str2, OnActiveSftpShellListener onActiveSftpShellListener) {
                this.f4243a = i;
                this.f4244b = str;
                this.f4245c = str2;
                this.f4246d = onActiveSftpShellListener;
            }

            @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
            /* renamed from: a */
            public UUID mo5334a() {
                return UUID.fromString(this.f4244b);
            }

            @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
            /* renamed from: b */
            public void mo5335b(ai0 ai0Var) {
                if (!(ai0Var.m2102p() instanceof hi0)) {
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), this.f4245c, "Not an SFTP connection.");
                    this.f4246d.mo5648a("Not an SFTP connection.");
                    return;
                }
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), this.f4245c, "Found connection");
                hi0 hi0Var = (hi0) ai0Var.m2102p();
                if (hi0Var.m4455G()) {
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), this.f4245c, "Returning (already active) connection");
                    this.f4246d.mo5649b(hi0Var, hi0Var.m4454F());
                    return;
                }
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), this.f4245c, "Attempting reconnect");
                String m4452D = hi0Var.m4452D();
                String m4453E = hi0Var.m4453E();
                ai0Var.m2098l().m2516w();
                ai0Var.m2098l().m2513t();
                ai0Var.m2098l().m2506m(new a(ai0Var, m4453E, m4452D));
                ai0Var.m2098l().m2517x();
            }

            @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
            /* renamed from: c */
            public void mo5336c() {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), this.f4245c, "Could not find connection");
                this.f4246d.mo5648a("Could not find");
            }

            @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
            /* renamed from: d */
            public int mo5337d() {
                return this.f4243a;
            }

            @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
            /* renamed from: e */
            public void mo5338e() {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), this.f4245c, "Access denied");
                this.f4246d.mo5648a("Access Denied");
            }
        }

        /* renamed from: cz.opentree.juicessh.services.SftpPluginService$a$g */
        /* loaded from: classes.dex */
        public class g implements OnActiveSftpShellListener {

            /* renamed from: a */
            public final /* synthetic */ String f4252a;

            /* renamed from: b */
            public final /* synthetic */ ICommandSuccessListener f4253b;

            public g(String str, ICommandSuccessListener iCommandSuccessListener) {
                this.f4252a = str;
                this.f4253b = iCommandSuccessListener;
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: a */
            public void mo5648a(String str) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to get an active shell");
                try {
                    this.f4253b.mo5577f(str);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                }
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: b */
            public void mo5649b(hi0 hi0Var, SSHSftp sSHSftp) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Got an active shell");
                try {
                    try {
                        sSHSftp.m6206a(this.f4252a);
                        hi0Var.m4456H(this.f4252a);
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Successful cd");
                        this.f4253b.mo5576d();
                    } catch (ek0 e) {
                        e.printStackTrace();
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed cd");
                        this.f4253b.mo5578g(e.getMessage());
                        SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e.getMessage()));
                    }
                } catch (RemoteException e2) {
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                    e2.printStackTrace();
                    SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e2.getMessage()));
                }
            }
        }

        /* renamed from: cz.opentree.juicessh.services.SftpPluginService$a$h */
        /* loaded from: classes.dex */
        public class h implements OnActiveSftpShellListener {

            /* renamed from: a */
            public final /* synthetic */ int f4255a;

            /* renamed from: b */
            public final /* synthetic */ String f4256b;

            /* renamed from: c */
            public final /* synthetic */ ICommandSuccessListener f4257c;

            public h(int i, String str, ICommandSuccessListener iCommandSuccessListener) {
                this.f4255a = i;
                this.f4256b = str;
                this.f4257c = iCommandSuccessListener;
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: a */
            public void mo5648a(String str) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to get an active shell");
                try {
                    this.f4257c.mo5577f(str);
                } catch (RemoteException e) {
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                    e.printStackTrace();
                }
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: b */
            public void mo5649b(hi0 hi0Var, SSHSftp sSHSftp) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Got an active shell");
                try {
                    try {
                        sSHSftp.m6209d(this.f4255a, this.f4256b);
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Successful chmod");
                        this.f4257c.mo5576d();
                    } catch (ek0 e) {
                        e.printStackTrace();
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed chmod");
                        this.f4257c.mo5578g(e.getMessage());
                        SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e.getMessage()));
                    }
                } catch (RemoteException e2) {
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                    e2.printStackTrace();
                    SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e2.getMessage()));
                }
            }
        }

        /* renamed from: cz.opentree.juicessh.services.SftpPluginService$a$i */
        /* loaded from: classes.dex */
        public class i implements OnActiveSftpShellListener {

            /* renamed from: a */
            public final /* synthetic */ int f4259a;

            /* renamed from: b */
            public final /* synthetic */ String f4260b;

            /* renamed from: c */
            public final /* synthetic */ ICommandSuccessListener f4261c;

            public i(int i, String str, ICommandSuccessListener iCommandSuccessListener) {
                this.f4259a = i;
                this.f4260b = str;
                this.f4261c = iCommandSuccessListener;
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: a */
            public void mo5648a(String str) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to get an active shell");
                try {
                    this.f4261c.mo5577f(str);
                } catch (RemoteException e) {
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                    e.printStackTrace();
                }
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: b */
            public void mo5649b(hi0 hi0Var, SSHSftp sSHSftp) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Got an active shell");
                try {
                    try {
                        sSHSftp.m6210e(this.f4259a, this.f4260b);
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Successful chown");
                        this.f4261c.mo5576d();
                    } catch (ek0 e) {
                        e.printStackTrace();
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed chown");
                        this.f4261c.mo5578g(e.getMessage());
                        SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e.getMessage()));
                    }
                } catch (RemoteException e2) {
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                    e2.printStackTrace();
                    SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e2.getMessage()));
                }
            }
        }

        /* renamed from: cz.opentree.juicessh.services.SftpPluginService$a$j */
        /* loaded from: classes.dex */
        public class j implements OnActiveSftpShellListener {

            /* renamed from: a */
            public final /* synthetic */ String f4263a;

            /* renamed from: b */
            public final /* synthetic */ String f4264b;

            /* renamed from: c */
            public final /* synthetic */ ICommandSuccessListener f4265c;

            public j(String str, String str2, ICommandSuccessListener iCommandSuccessListener) {
                this.f4263a = str;
                this.f4264b = str2;
                this.f4265c = iCommandSuccessListener;
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: a */
            public void mo5648a(String str) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to get an active shell");
                try {
                    this.f4265c.mo5577f(str);
                } catch (RemoteException e) {
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                    e.printStackTrace();
                }
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: b */
            public void mo5649b(hi0 hi0Var, SSHSftp sSHSftp) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Got an active shell");
                try {
                    try {
                        sSHSftp.m6211f(this.f4263a, this.f4264b);
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Successful chown");
                        this.f4265c.mo5576d();
                    } catch (ek0 e) {
                        e.printStackTrace();
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed chown");
                        this.f4265c.mo5578g(e.getMessage());
                        SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e.getMessage()));
                    }
                } catch (RemoteException e2) {
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                    e2.printStackTrace();
                    SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e2.getMessage()));
                }
            }
        }

        /* renamed from: cz.opentree.juicessh.services.SftpPluginService$a$k */
        /* loaded from: classes.dex */
        public class k implements OnActiveSftpShellListener {

            /* renamed from: a */
            public final /* synthetic */ int f4267a;

            /* renamed from: b */
            public final /* synthetic */ String f4268b;

            /* renamed from: c */
            public final /* synthetic */ ICommandSuccessListener f4269c;

            public k(int i, String str, ICommandSuccessListener iCommandSuccessListener) {
                this.f4267a = i;
                this.f4268b = str;
                this.f4269c = iCommandSuccessListener;
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: a */
            public void mo5648a(String str) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to get an active shell");
                try {
                    this.f4269c.mo5577f(str);
                } catch (RemoteException e) {
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                    e.printStackTrace();
                }
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: b */
            public void mo5649b(hi0 hi0Var, SSHSftp sSHSftp) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Got an active shell");
                try {
                    try {
                        sSHSftp.m6207b(this.f4267a, this.f4268b);
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Successful chgrp");
                        this.f4269c.mo5576d();
                    } catch (ek0 e) {
                        e.printStackTrace();
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed chgrp");
                        this.f4269c.mo5578g(e.getMessage());
                        SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e.getMessage()));
                    }
                } catch (RemoteException e2) {
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                    e2.printStackTrace();
                    SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e2.getMessage()));
                }
            }
        }

        /* renamed from: cz.opentree.juicessh.services.SftpPluginService$a$l */
        /* loaded from: classes.dex */
        public class l implements OnActiveSftpShellListener {

            /* renamed from: a */
            public final /* synthetic */ String f4271a;

            /* renamed from: b */
            public final /* synthetic */ String f4272b;

            /* renamed from: c */
            public final /* synthetic */ ICommandSuccessListener f4273c;

            public l(String str, String str2, ICommandSuccessListener iCommandSuccessListener) {
                this.f4271a = str;
                this.f4272b = str2;
                this.f4273c = iCommandSuccessListener;
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: a */
            public void mo5648a(String str) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to get an active shell");
                try {
                    this.f4273c.mo5577f(str);
                } catch (RemoteException e) {
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                    e.printStackTrace();
                }
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: b */
            public void mo5649b(hi0 hi0Var, SSHSftp sSHSftp) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Got an active shell");
                try {
                    try {
                        sSHSftp.m6208c(this.f4271a, this.f4272b);
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Successful chgrp");
                        this.f4273c.mo5576d();
                    } catch (ek0 e) {
                        e.printStackTrace();
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed chgrp");
                        this.f4273c.mo5578g(e.getMessage());
                        SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e.getMessage()));
                    }
                } catch (RemoteException e2) {
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                    e2.printStackTrace();
                    SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e2.getMessage()));
                }
            }
        }

        /* renamed from: cz.opentree.juicessh.services.SftpPluginService$a$m */
        /* loaded from: classes.dex */
        public class m implements OnActiveSftpShellListener {

            /* renamed from: a */
            public final /* synthetic */ String f4275a;

            /* renamed from: b */
            public final /* synthetic */ String f4276b;

            /* renamed from: c */
            public final /* synthetic */ ICommandSuccessListener f4277c;

            public m(String str, String str2, ICommandSuccessListener iCommandSuccessListener) {
                this.f4275a = str;
                this.f4276b = str2;
                this.f4277c = iCommandSuccessListener;
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: a */
            public void mo5648a(String str) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to get an active shell");
                try {
                    this.f4277c.mo5577f(str);
                } catch (RemoteException e) {
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                    e.printStackTrace();
                }
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: b */
            public void mo5649b(hi0 hi0Var, SSHSftp sSHSftp) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Got an active shell");
                try {
                    try {
                        sSHSftp.m6221q(this.f4275a, this.f4276b);
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Successful mv");
                        this.f4277c.mo5576d();
                    } catch (ek0 e) {
                        e.printStackTrace();
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed mv");
                        this.f4277c.mo5578g(e.getMessage());
                        SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e.getMessage()));
                    }
                } catch (RemoteException e2) {
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                    e2.printStackTrace();
                    SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e2.getMessage()));
                }
            }
        }

        /* renamed from: cz.opentree.juicessh.services.SftpPluginService$a$n */
        /* loaded from: classes.dex */
        public class n implements OnActiveSftpShellListener {

            /* renamed from: a */
            public final /* synthetic */ String[] f4279a;

            /* renamed from: b */
            public final /* synthetic */ String[] f4280b;

            /* renamed from: c */
            public final /* synthetic */ String[] f4281c;

            /* renamed from: d */
            public final /* synthetic */ ICommandSuccessListener f4282d;

            public n(String[] strArr, String[] strArr2, String[] strArr3, ICommandSuccessListener iCommandSuccessListener) {
                this.f4279a = strArr;
                this.f4280b = strArr2;
                this.f4281c = strArr3;
                this.f4282d = iCommandSuccessListener;
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: a */
            public void mo5648a(String str) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to get an active shell");
                try {
                    this.f4282d.mo5577f(str);
                } catch (RemoteException e) {
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                    e.printStackTrace();
                }
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: b */
            public void mo5649b(hi0 hi0Var, SSHSftp sSHSftp) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Got an active shell");
                try {
                    yi0 yi0Var = new yi0(hi0Var, this.f4279a, this.f4280b, this.f4281c);
                    Vector<SftpControllerInterface> vector = SftpPluginService.f4226O;
                    synchronized (vector) {
                        int size = vector.size();
                        vector.add(size, yi0Var);
                        yi0Var.m10158p(size);
                        gj0.m4141b("SftpPluginService", "Added new gets controller with job id: " + size);
                    }
                    yi0Var.mo5380b();
                } catch (yi0.C2354f e) {
                    e.printStackTrace();
                    SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e.getMessage()));
                }
            }
        }

        /* renamed from: cz.opentree.juicessh.services.SftpPluginService$a$o */
        /* loaded from: classes.dex */
        public class o implements OnActiveSftpShellListener {

            /* renamed from: a */
            public final /* synthetic */ String f4284a;

            /* renamed from: b */
            public final /* synthetic */ IAttributesEntryListener f4285b;

            public o(String str, IAttributesEntryListener iAttributesEntryListener) {
                this.f4284a = str;
                this.f4285b = iAttributesEntryListener;
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: a */
            public void mo5648a(String str) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to get an active shell");
                try {
                    this.f4285b.mo5572f(str);
                } catch (RemoteException e) {
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                    e.printStackTrace();
                }
            }

            @Override // cz.opentree.juicessh.services.SftpPluginService.OnActiveSftpShellListener
            /* renamed from: b */
            public void mo5649b(hi0 hi0Var, SSHSftp sSHSftp) {
                PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Got an active shell");
                try {
                    try {
                        Vector<lk0> m6220p = sSHSftp.m6220p(this.f4284a);
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Successful ls");
                        ParcelableAttributesEntry[] parcelableAttributesEntryArr = new ParcelableAttributesEntry[m6220p.size()];
                        for (int i = 0; i < m6220p.size(); i++) {
                            parcelableAttributesEntryArr[i] = new ParcelableAttributesEntry(m6220p.get(i));
                        }
                        this.f4285b.mo5571J0(parcelableAttributesEntryArr);
                    } catch (ek0 e) {
                        e.printStackTrace();
                        PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed ls");
                        this.f4285b.mo5573g(e.getMessage());
                        SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e.getMessage()));
                    }
                } catch (RemoteException e2) {
                    PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), BinderC1389a.this.f4227a, "Failed to relay failure");
                    e2.printStackTrace();
                    SftpPluginService.this.sendBroadcast(new Intent("cz.opentree.juicessh.sftp.error_message").putExtra("message", e2.getMessage()));
                }
            }
        }

        public BinderC1389a() {
            this.f4227a = PluginLog.m5490r(SftpPluginService.this.getApplicationContext());
        }

        @Override // cz.opentree.juicessh.pluginlibrary.ISftpPluginService
        /* renamed from: B0 */
        public void mo5556B0(int i2, String str, String str2, IAttributesEntryListener iAttributesEntryListener) {
            PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), this.f4227a, "Received a ls request");
            m5651r(this.f4227a, i2, str, new o(str2, iAttributesEntryListener));
        }

        @Override // cz.opentree.juicessh.pluginlibrary.ISftpPluginService
        /* renamed from: C */
        public void mo5557C(int i2, String str, String str2, ICommandSuccessListener iCommandSuccessListener) {
            PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), this.f4227a, "Received a cd request");
            m5651r(this.f4227a, i2, str, new g(str2, iCommandSuccessListener));
        }

        @Override // cz.opentree.juicessh.pluginlibrary.ISftpPluginService
        /* renamed from: F0 */
        public void mo5558F0(int i2, String str, String str2, ICommandSuccessListener iCommandSuccessListener) {
            PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), this.f4227a, "Received a rm request");
            m5651r(this.f4227a, i2, str, new c(str2, iCommandSuccessListener));
        }

        @Override // cz.opentree.juicessh.pluginlibrary.ISftpPluginService
        /* renamed from: I */
        public void mo5559I(int i2, String str, String[] strArr, String[] strArr2, String[] strArr3, ICommandSuccessListener iCommandSuccessListener) {
            PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), this.f4227a, "Received a get request");
            m5651r(this.f4227a, i2, str, new n(strArr, strArr2, strArr3, iCommandSuccessListener));
        }

        @Override // cz.opentree.juicessh.pluginlibrary.ISftpPluginService
        /* renamed from: M */
        public void mo5560M(int i2, String str, int i3, String str2, ICommandSuccessListener iCommandSuccessListener) {
            PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), this.f4227a, "Received a chmod request");
            m5651r(this.f4227a, i2, str, new h(i3, str2, iCommandSuccessListener));
        }

        @Override // cz.opentree.juicessh.pluginlibrary.ISftpPluginService
        /* renamed from: N0 */
        public void mo5561N0(int i2, String str, String str2, IStatResultListener iStatResultListener) {
            PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), this.f4227a, "Received a stat request");
            m5651r(this.f4227a, i2, str, new e(str2, iStatResultListener));
        }

        @Override // cz.opentree.juicessh.pluginlibrary.ISftpPluginService
        /* renamed from: Q */
        public String mo5562Q(int i2) throws RemoteException {
            SftpControllerInterface sftpControllerInterface = SftpPluginService.f4226O.get(i2);
            if (sftpControllerInterface != null) {
                return sftpControllerInterface.mo5379a();
            }
            PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), this.f4227a, "Failed to fetch job for transcript");
            throw new RemoteException("Failed to fetch job for transcript");
        }

        @Override // cz.opentree.juicessh.pluginlibrary.ISftpPluginService
        /* renamed from: W */
        public void mo5563W(int i2, String str, int i3, String str2, ICommandSuccessListener iCommandSuccessListener) {
            PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), this.f4227a, "Received a chgrp request");
            m5651r(this.f4227a, i2, str, new k(i3, str2, iCommandSuccessListener));
        }

        @Override // cz.opentree.juicessh.pluginlibrary.ISftpPluginService
        /* renamed from: e0 */
        public void mo5564e0(int i2, String str, String str2, ICommandSuccessListener iCommandSuccessListener) {
            PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), this.f4227a, "Received a rmdir request");
            m5651r(this.f4227a, i2, str, new d(str2, iCommandSuccessListener));
        }

        @Override // cz.opentree.juicessh.pluginlibrary.ISftpPluginService
        /* renamed from: n0 */
        public void mo5565n0(int i2, String str, int i3, String str2, ICommandSuccessListener iCommandSuccessListener) {
            PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), this.f4227a, "Received a chown request");
            m5651r(this.f4227a, i2, str, new i(i3, str2, iCommandSuccessListener));
        }

        @Override // cz.opentree.juicessh.pluginlibrary.ISftpPluginService
        /* renamed from: q0 */
        public void mo5566q0(int i2, String str, String str2, String str3, ICommandSuccessListener iCommandSuccessListener) {
            PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), this.f4227a, "Received a chown request");
            m5651r(this.f4227a, i2, str, new j(str2, str3, iCommandSuccessListener));
        }

        /* renamed from: r */
        public final void m5651r(String str, int i2, String str2, OnActiveSftpShellListener onActiveSftpShellListener) {
            PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), str, "Searching for connection");
            ConnectionManager.m5349b(SftpPluginService.this.getApplicationContext(), new f(i2, str2, str, onActiveSftpShellListener));
        }

        @Override // cz.opentree.juicessh.pluginlibrary.ISftpPluginService
        /* renamed from: r0 */
        public void mo5567r0(int i2, String str, String str2, String str3, ICommandSuccessListener iCommandSuccessListener) {
            PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), this.f4227a, "Received a mv request");
            m5651r(this.f4227a, i2, str, new m(str2, str3, iCommandSuccessListener));
        }

        @Override // cz.opentree.juicessh.pluginlibrary.ISftpPluginService
        /* renamed from: t */
        public void mo5568t(int i2, String str, IStringResultListener iStringResultListener) {
            PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), this.f4227a, "Received a pwd request");
            m5651r(this.f4227a, i2, str, new a(iStringResultListener));
        }

        @Override // cz.opentree.juicessh.pluginlibrary.ISftpPluginService
        /* renamed from: w */
        public void mo5569w(int i2, String str, String str2, String str3, ICommandSuccessListener iCommandSuccessListener) {
            PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), this.f4227a, "Received a chgrp request");
            m5651r(this.f4227a, i2, str, new l(str2, str3, iCommandSuccessListener));
        }

        @Override // cz.opentree.juicessh.pluginlibrary.ISftpPluginService
        /* renamed from: x0 */
        public void mo5570x0(int i2, String str, String str2, IStringResultListener iStringResultListener) throws RemoteException {
            PluginLog.m5491s(SftpPluginService.this.getApplicationContext(), this.f4227a, "Received a readlink request");
            m5651r(this.f4227a, i2, str, new b(str2, iStringResultListener));
        }
    }

    public SftpPluginService() {
        new Handler();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new BinderC1389a();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
