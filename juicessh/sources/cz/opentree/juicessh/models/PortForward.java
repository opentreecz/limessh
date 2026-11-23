package cz.opentree.juicessh.models;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cz.opentree.ai0;
import cz.opentree.gj0;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.activities.TerminalEmulatorActivity;
import cz.opentree.juicessh.connections.ConnectionManager;
import cz.opentree.juicessh.connections.listeners.BasicTransportChainListener;
import cz.opentree.juicessh.connections.transports.ConnectionProvider;
import cz.opentree.juicessh.p002db.BaseModel;
import cz.opentree.juicessh.p002db.DAO;
import cz.opentree.sj0;
import java.util.List;
import java.util.UUID;

@DatabaseTable(daoClass = DAO.class, tableName = "portforward")
/* loaded from: classes.dex */
public class PortForward extends BaseModel<PortForward> implements Comparable<PortForward>, ConnectionProvider {
    public static final int MODE_LOCAL = 0;
    public static final int MODE_REMOTE = 1;
    public static final int MODE_SOCKS = 2;

    @DatabaseField(foreign = true)
    public Connection connection;

    @DatabaseField
    public String host;

    @DatabaseField
    public int localPort;

    @DatabaseField
    public int mode;

    @DatabaseField
    public String name;

    @DatabaseField
    public Boolean openInBrowser;

    @DatabaseField
    public int remotePort;

    @DatabaseField
    public Boolean useAsProxy;

    /* loaded from: classes.dex */
    public interface OnToggleCompleteListener {
        /* renamed from: a */
        void mo5344a(boolean z);
    }

    @Override // cz.opentree.juicessh.connections.transports.ConnectionProvider
    /* renamed from: g */
    public Connection mo5368g() {
        return this.connection.m5383m();
    }

    @Override // cz.opentree.juicessh.connections.transports.ConnectionProvider
    public UUID getId() {
        return this.f3993id;
    }

    @Override // java.lang.Comparable
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public int compareTo(PortForward portForward) {
        return toString().compareToIgnoreCase(portForward.toString());
    }

    /* renamed from: s */
    public void m5494s(final FragmentActivity fragmentActivity, final OnToggleCompleteListener onToggleCompleteListener) {
        this.connection.m5383m();
        Connection connection = this.connection;
        if (connection.f3993id == null || connection.address == null) {
            sj0.m8455a(fragmentActivity, null, this, ai0.f1396o);
            Toast.makeText(fragmentActivity, fragmentActivity.getString(R.string.invalid_connection), 0).show();
            gj0.m4142c(BaseModel.TAG, "Attempted to connect to a port forward with no valid connection associated");
        } else {
            ai0 ai0Var = new ai0(fragmentActivity, this);
            ai0Var.m2094g();
            ai0Var.m2098l().m2506m(new BasicTransportChainListener() { // from class: cz.opentree.juicessh.models.PortForward.3
                @Override // cz.opentree.juicessh.connections.listeners.BasicTransportChainListener
                /* renamed from: a */
                public void mo3218a() {
                }

                @Override // cz.opentree.juicessh.connections.listeners.BasicTransportChainListener
                /* renamed from: b */
                public void mo3219b(int i, UUID uuid) {
                    if (PortForward.this.openInBrowser.booleanValue()) {
                        int i2 = PortForward.this.mode;
                        if (i2 == 0) {
                            String str = "http://localhost:" + PortForward.this.localPort;
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setData(Uri.parse(str));
                            gj0.m4141b(BaseModel.TAG, "Opening local port forward in browser: " + str);
                            fragmentActivity.startActivity(intent);
                            fragmentActivity.finish();
                        } else if (i2 == 1) {
                            String str2 = "http://" + PortForward.this.connection.address + ":" + PortForward.this.localPort;
                            Intent intent2 = new Intent("android.intent.action.VIEW");
                            intent2.setData(Uri.parse(str2));
                            gj0.m4141b(BaseModel.TAG, "Opening remote port forward in browser: " + str2);
                            fragmentActivity.startActivity(intent2);
                            fragmentActivity.finish();
                        }
                    } else if (fragmentActivity instanceof TerminalEmulatorActivity) {
                        gj0.m4141b(BaseModel.TAG, "Closing terminal activity as port forward has been toggled and no browser request has been made");
                        fragmentActivity.finish();
                    }
                    OnToggleCompleteListener onToggleCompleteListener2 = onToggleCompleteListener;
                    if (onToggleCompleteListener2 != null) {
                        onToggleCompleteListener2.mo5344a(true);
                    }
                }
            });
        }
    }

    /* renamed from: t */
    public String m5495t(Context context) {
        this.connection.m5383m();
        if (this.connection.address == null) {
            return context.getString(R.string.invalid_connection);
        }
        int i = this.mode;
        if (i == 0) {
            if (this.host.equals("127.0.0.1") || this.host.equals("localhost")) {
                this.host = this.connection.address;
            }
            return String.format(context.getString(R.string.local_forward_description_short), Integer.valueOf(this.localPort), this.host, Integer.valueOf(this.remotePort));
        }
        if (i != 1) {
            return i != 2 ? "" : String.format(context.getString(R.string.socks_forward_description), Integer.valueOf(this.localPort));
        }
        if (this.host.equals("127.0.0.1") || this.host.equals("localhost")) {
            this.host = this.connection.address;
        }
        return String.format(context.getString(R.string.remote_forward_description_short), this.connection.address, Integer.valueOf(this.localPort), this.host, Integer.valueOf(this.remotePort));
    }

    public String toString() {
        return this.name;
    }

    /* renamed from: u */
    public void m5496u(final FragmentActivity fragmentActivity, final OnToggleCompleteListener onToggleCompleteListener) {
        gj0.m4141b(BaseModel.TAG, "Toggling Port Forward: " + this.name);
        ConnectionManager.m5350c(fragmentActivity, new ConnectionManager.ChainQuery() { // from class: cz.opentree.juicessh.models.PortForward.1
            @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainQuery
            /* renamed from: a */
            public void mo5353a(List<ai0> list) {
                gj0.m4141b(BaseModel.TAG, "Got port forward query result. Matching chains: " + list.size());
                if (list.isEmpty()) {
                    PortForward.this.m5494s(fragmentActivity, onToggleCompleteListener);
                    return;
                }
                for (final ai0 ai0Var : list) {
                    ConnectionManager.m5348a(fragmentActivity, new ConnectionManager.ChainRequest() { // from class: cz.opentree.juicessh.models.PortForward.1.1
                        @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
                        /* renamed from: a */
                        public UUID mo5334a() {
                            return ai0Var.m2097k();
                        }

                        @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
                        /* renamed from: b */
                        public void mo5335b(ai0 ai0Var2) {
                            OnToggleCompleteListener onToggleCompleteListener2 = onToggleCompleteListener;
                            if (onToggleCompleteListener2 != null) {
                                onToggleCompleteListener2.mo5344a(false);
                            }
                        }

                        @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
                        /* renamed from: c */
                        public void mo5336c() {
                            gj0.m4142c(BaseModel.TAG, "Attempting to disconnect a non-existent forward chain");
                        }

                        @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
                        /* renamed from: d */
                        public int mo5337d() {
                            return ai0Var.f1399b;
                        }

                        @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
                        /* renamed from: e */
                        public void mo5338e() {
                            gj0.m4142c(BaseModel.TAG, "Denied disconnect of forwarding chain");
                        }
                    });
                }
            }

            @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainQuery
            /* renamed from: b */
            public ConnectionProvider mo5354b() {
                return PortForward.this;
            }
        });
    }

    /* renamed from: v */
    public void m5497v(final FragmentActivity fragmentActivity, final boolean z) {
        gj0.m4141b(BaseModel.TAG, "Toggling Port Forward: " + this.name + ". Expected state: " + z);
        ConnectionManager.m5350c(fragmentActivity, new ConnectionManager.ChainQuery() { // from class: cz.opentree.juicessh.models.PortForward.2
            @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainQuery
            /* renamed from: a */
            public void mo5353a(List<ai0> list) {
                gj0.m4141b(BaseModel.TAG, "Got port forward query result. Matching chains: " + list.size());
                if (list.isEmpty()) {
                    if (z) {
                        PortForward.this.m5494s(fragmentActivity, null);
                    }
                } else {
                    if (z) {
                        return;
                    }
                    for (final ai0 ai0Var : list) {
                        ConnectionManager.m5348a(fragmentActivity, new ConnectionManager.ChainRequest(this) { // from class: cz.opentree.juicessh.models.PortForward.2.1
                            @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
                            /* renamed from: a */
                            public UUID mo5334a() {
                                return ai0Var.m2097k();
                            }

                            @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
                            /* renamed from: b */
                            public void mo5335b(ai0 ai0Var2) {
                            }

                            @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
                            /* renamed from: c */
                            public void mo5336c() {
                                gj0.m4142c(BaseModel.TAG, "Attempting to disconnect a non-existend forward chain");
                            }

                            @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
                            /* renamed from: d */
                            public int mo5337d() {
                                return ai0Var.f1399b;
                            }

                            @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainRequest
                            /* renamed from: e */
                            public void mo5338e() {
                                gj0.m4142c(BaseModel.TAG, "Denied disconnect of forwarding chain");
                            }
                        });
                    }
                }
            }

            @Override // cz.opentree.juicessh.connections.ConnectionManager.ChainQuery
            /* renamed from: b */
            public ConnectionProvider mo5354b() {
                return PortForward.this;
            }
        });
    }

    /* renamed from: w */
    public String m5498w(Context context) {
        String str = this.name;
        if (str == null || str.length() < 1) {
            return context.getString(R.string.you_must_enter_a_name);
        }
        if (this.connection == null) {
            return context.getString(R.string.you_must_pick_a_connection);
        }
        String str2 = this.host;
        if (str2 == null || str2.length() < 1) {
            this.host = "127.0.0.1";
        }
        int i = this.mode;
        if (i == 0 || i == 1) {
            gj0.m4141b(BaseModel.TAG, "Validating a local/remote: " + this.mode);
            if (this.remotePort <= 0) {
                return context.getString(R.string.you_must_enter_a_remote_port);
            }
        } else if (i != 2) {
            return null;
        }
        gj0.m4141b(BaseModel.TAG, "Validating a SOCKS: " + this.mode);
        int i2 = this.localPort;
        if (i2 <= 0) {
            return context.getString(R.string.you_must_enter_a_local_port);
        }
        if (i2 <= 1024) {
            return context.getString(R.string.local_port_must_be_higher_than_1024);
        }
        return null;
    }
}
