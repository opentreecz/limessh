package cz.opentree.limessh.models;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import cz.opentree.ai0;
import cz.opentree.limessh.connections.listeners.BasicTransportChainListener;
import cz.opentree.limessh.connections.transports.ConnectionProvider;
import cz.opentree.limessh.p002db.BaseModel;
import cz.opentree.limessh.p002db.C1328DB;
import cz.opentree.limessh.p002db.DAO;
import java.sql.SQLException;
import java.util.UUID;
import org.apache.http.conn.util.InetAddressUtils;

@DatabaseTable(daoClass = DAO.class, tableName = "connection")
/* loaded from: classes.dex */
public class Connection extends BaseModel<Connection> implements Comparable<Connection>, ConnectionProvider, Cloneable {
    public static final int BACKSPACE_MODE_DEFAULT = 0;
    public static final int BACKSPACE_MODE_LEGACY = 1;
    public static final int REQUESTID_ADD_IDENTITY_FOR_CONNECTION = 45839;
    public static final int TYPE_LOCAL = 2;
    public static final int TYPE_MOSH = 1;
    public static final int TYPE_SSH = 0;
    public static final int TYPE_TELNET = 3;

    @DatabaseField
    public String address;

    @DatabaseField
    public int backspaceMode;

    @DatabaseField(foreign = true)
    public ConnectionGroup group;

    @DatabaseField(columnName = "mosh_command")
    public String moshCommand;

    @DatabaseField
    public String nickname;

    @DatabaseField
    public int port;
    public String redirectedAddress;
    public int redirectedPort;

    @DatabaseField(foreign = true)
    public Snippet snippet;
    public Identity temporaryQuickConnectIdentity;

    @DatabaseField
    public int type;

    @DatabaseField(foreign = true)
    public Connection via;

    public Connection() {
        this.port = 22;
        this.type = 0;
        this.backspaceMode = 0;
    }

    public Connection(String str, int i) {
        this.port = 22;
        this.type = 0;
        this.backspaceMode = 0;
        this.address = str;
        this.port = i;
    }

    /* renamed from: t */
    public static String m5464t(Context context, String str) {
        try {
            Connection connection = (Connection) C1328DB.m5404d(Connection.class, context).queryForId(UUID.fromString(str));
            if (connection == null) {
                return null;
            }
            return connection.m5471w();
        } catch (IllegalArgumentException | NullPointerException | SQLException unused) {
            return null;
        }
    }

    /* renamed from: y */
    public static boolean m5465y(String str) {
        if (str.contains("%")) {
            str = str.split("%")[0];
        }
        return str.matches("^(([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-\\_]*[a-zA-Z0-9])\\.)*([A-Za-z0-9]|[A-Za-z0-9][A-Za-z0-9\\-\\_]*[A-Za-z0-9])$") || InetAddressUtils.isIPv4Address(str) || InetAddressUtils.isIPv6Address(str);
    }

    /* renamed from: A */
    public ai0 m5466A(FragmentActivity fragmentActivity, BasicTransportChainListener basicTransportChainListener) {
        ai0 ai0Var = new ai0(fragmentActivity, this);
        ai0Var.m2109w(true);
        ai0Var.m2094g();
        ai0Var.m2098l().m2506m(basicTransportChainListener);
        return ai0Var;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override // cz.opentree.limessh.connections.transports.ConnectionProvider
    /* renamed from: g */
    public Connection mo5368g() {
        return this;
    }

    @Override // cz.opentree.limessh.connections.transports.ConnectionProvider
    public UUID getId() {
        return this.f3993id;
    }

    @Override // java.lang.Comparable
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public int compareTo(Connection connection) {
        return toString().compareToIgnoreCase(connection.toString());
    }

    /* renamed from: s */
    public ai0 m5468s(FragmentActivity fragmentActivity, BasicTransportChainListener basicTransportChainListener) {
        ai0 ai0Var = new ai0(fragmentActivity, this);
        Snippet snippet = this.snippet;
        if (snippet != null) {
            snippet.m5383m();
            Snippet snippet2 = this.snippet;
            if (snippet2 != null && snippet2.content != null) {
                ai0Var.m2110x(snippet2);
            }
        }
        ai0Var.m2094g();
        ai0Var.m2098l().m2506m(basicTransportChainListener);
        return ai0Var;
    }

    public String toString() {
        return m5471w();
    }

    /* renamed from: u */
    public String m5469u() {
        int i = this.type;
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "Unknown" : "Telnet" : "Local Device" : "Mosh" : "SSH";
    }

    /* renamed from: v */
    public Identity m5470v(Context context) {
        Identity identity = this.temporaryQuickConnectIdentity;
        return identity != null ? identity : ConnectionIdentity.m5477r(this, context);
    }

    /* renamed from: w */
    public String m5471w() {
        String str = this.nickname;
        if (str != null && !str.isEmpty()) {
            return this.nickname;
        }
        String str2 = this.address;
        return (str2 == null || str2.isEmpty()) ? this.type == 2 ? "localhost" : "Invalid Connection" : this.address;
    }

    /* renamed from: z */
    public void m5472z(Identity identity, Context context) {
        new ConnectionIdentity(this, identity, context);
    }
}
