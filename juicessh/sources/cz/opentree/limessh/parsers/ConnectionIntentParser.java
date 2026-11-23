package cz.opentree.limessh.parsers;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Pair;
import cz.opentree.gj0;
import cz.opentree.limessh.R;
import cz.opentree.limessh.connections.transports.ConnectionProvider;
import cz.opentree.limessh.models.Connection;
import cz.opentree.limessh.models.Identity;
import cz.opentree.limessh.models.Snippet;
import cz.opentree.limessh.p002db.C1328DB;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class ConnectionIntentParser {

    /* loaded from: classes.dex */
    public interface ParsedConnectionIntentHandler {
        /* renamed from: a */
        void mo5315a(Connection connection, Snippet snippet, boolean z);

        /* renamed from: b */
        void mo5316b(int i, UUID uuid);

        /* renamed from: c */
        void mo5317c(ConnectionProvider connectionProvider, boolean z, boolean z2);

        /* renamed from: d */
        void mo5318d(int i, String str);

        /* renamed from: e */
        void mo5319e(int i, UUID uuid, Snippet snippet, boolean z);

        /* renamed from: f */
        void mo5320f(int i, UUID uuid);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0036 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static cz.opentree.limessh.connections.transports.ConnectionProvider m5536a(android.content.Context r2, java.util.UUID r3) throws java.lang.IllegalArgumentException {
        /*
            r0 = 0
            java.lang.Class<cz.opentree.limessh.models.Connection> r1 = cz.opentree.limessh.models.Connection.class
            cz.opentree.limessh.db.DAO r1 = cz.opentree.limessh.p002db.C1328DB.m5404d(r1, r2)     // Catch: java.sql.SQLException -> L30
            cz.opentree.limessh.db.BaseModel r1 = r1.queryForId(r3)     // Catch: java.sql.SQLException -> L30
            cz.opentree.limessh.connections.transports.ConnectionProvider r1 = (cz.opentree.limessh.connections.transports.ConnectionProvider) r1     // Catch: java.sql.SQLException -> L30
            if (r1 != 0) goto L1f
            java.lang.Class<cz.opentree.limessh.models.PortForward> r0 = cz.opentree.limessh.models.PortForward.class
            cz.opentree.limessh.db.DAO r0 = cz.opentree.limessh.p002db.C1328DB.m5404d(r0, r2)     // Catch: java.sql.SQLException -> L1c
            cz.opentree.limessh.db.BaseModel r0 = r0.queryForId(r3)     // Catch: java.sql.SQLException -> L1c
            cz.opentree.limessh.connections.transports.ConnectionProvider r0 = (cz.opentree.limessh.connections.transports.ConnectionProvider) r0     // Catch: java.sql.SQLException -> L1c
            goto L20
        L1c:
            r2 = move-exception
            r0 = r1
            goto L31
        L1f:
            r0 = r1
        L20:
            if (r0 != 0) goto L34
            java.lang.Class<cz.opentree.limessh.models.ec2link.Ec2Connection> r1 = cz.opentree.limessh.models.ec2link.Ec2Connection.class
            cz.opentree.limessh.db.DAO r2 = cz.opentree.limessh.p002db.C1328DB.m5404d(r1, r2)     // Catch: java.sql.SQLException -> L30
            cz.opentree.limessh.db.BaseModel r2 = r2.queryForId(r3)     // Catch: java.sql.SQLException -> L30
            cz.opentree.limessh.connections.transports.ConnectionProvider r2 = (cz.opentree.limessh.connections.transports.ConnectionProvider) r2     // Catch: java.sql.SQLException -> L30
            r0 = r2
            goto L34
        L30:
            r2 = move-exception
        L31:
            r2.printStackTrace()
        L34:
            if (r0 == 0) goto L37
            return r0
        L37:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Connection Provider not found"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.limessh.parsers.ConnectionIntentParser.m5536a(android.content.Context, java.util.UUID):cz.opentree.limessh.connections.transports.ConnectionProvider");
    }

    /* renamed from: b */
    public static Snippet m5537b(Context context, UUID uuid) {
        try {
            return (Snippet) C1328DB.m5404d(Snippet.class, context).queryForId(uuid);
        } catch (SQLException unused) {
            return null;
        }
    }

    /* renamed from: c */
    public static Pair<ConnectionProvider, Identity> m5538c(Uri uri) throws IllegalArgumentException {
        Connection connection = new Connection();
        connection.address = uri.getHost();
        connection.port = uri.getPort();
        String scheme = uri.getScheme();
        if (scheme == null) {
            throw new IllegalArgumentException("ConnectionIntent's scheme has not been specified");
        }
        if (scheme.equals("juicessh")) {
            throw new IllegalArgumentException("Plugins must specify a valid UUID for intenthostname");
        }
        if ((scheme.equalsIgnoreCase("ssh") | scheme.equalsIgnoreCase("ssh-forward")) || scheme.equalsIgnoreCase("sftp")) {
            connection.type = 0;
        } else if (scheme.equalsIgnoreCase("local")) {
            connection.type = 2;
        } else if (scheme.equalsIgnoreCase("mosh")) {
            connection.type = 1;
        } else {
            if (!scheme.equalsIgnoreCase("telnet")) {
                throw new IllegalArgumentException("Intent scheme not recognised");
            }
            connection.type = 3;
        }
        if (uri.getPort() == -1) {
            if (connection.type == 3) {
                connection.port = 23;
            } else {
                connection.port = 22;
            }
        }
        String userInfo = uri.getUserInfo();
        Identity identity = userInfo != null ? new Identity(userInfo) : null;
        connection.temporaryQuickConnectIdentity = identity;
        if (scheme.equalsIgnoreCase("ssh-forward")) {
            throw new IllegalArgumentException("SSH-Forward intents must specify a valid UUID for a PortForward item.");
        }
        return new Pair<>(connection, identity);
    }

    /* renamed from: d */
    public static void m5539d(Context context, Intent intent, ParsedConnectionIntentHandler parsedConnectionIntentHandler) {
        ConnectionProvider connectionProvider;
        Uri data = intent.getData();
        if (data == null) {
            parsedConnectionIntentHandler.mo5318d(400, "ConnectionIntent has no data");
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("background", false);
        boolean booleanExtra2 = intent.getBooleanExtra("sftp", false);
        try {
            try {
                try {
                    try {
                        connectionProvider = m5536a(context, UUID.fromString(data.getHost()));
                        if (connectionProvider == null) {
                            parsedConnectionIntentHandler.mo5318d(500, context.getString(R.string.connection_or_forward_not_found));
                            return;
                        }
                    } catch (Throwable unused) {
                        parsedConnectionIntentHandler.mo5318d(500, context.getString(R.string.connection_or_forward_not_found));
                        return;
                    }
                } catch (IllegalArgumentException unused2) {
                    parsedConnectionIntentHandler.mo5318d(404, context.getString(R.string.connection_or_forward_not_found));
                    parsedConnectionIntentHandler.mo5318d(500, context.getString(R.string.connection_or_forward_not_found));
                    return;
                }
            } catch (IllegalArgumentException unused3) {
                Pair<ConnectionProvider, Identity> m5538c = m5538c(data);
                connectionProvider = (ConnectionProvider) m5538c.first;
                Connection mo5368g = connectionProvider.mo5368g();
                if (intent.getBooleanExtra("save", false)) {
                    try {
                        m5544i(context, (Identity) m5538c.second, mo5368g);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        parsedConnectionIntentHandler.mo5318d(500, "Could not save one or both of Identity and Connection");
                    }
                }
            }
            parsedConnectionIntentHandler.mo5317c(connectionProvider, booleanExtra, booleanExtra2);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            parsedConnectionIntentHandler.mo5318d(400, e2.getMessage());
        }
    }

    /* renamed from: e */
    public static void m5540e(Context context, Intent intent, ParsedConnectionIntentHandler parsedConnectionIntentHandler) {
        Uri data = intent.getData();
        if (data == null) {
            parsedConnectionIntentHandler.mo5318d(400, "ConnectionIntent has no data");
            return;
        }
        String host = data.getHost();
        if (host == null || host.isEmpty()) {
            parsedConnectionIntentHandler.mo5318d(400, "Disconnect requires a validsession_id as host");
            return;
        }
        if (!intent.hasExtra("session_key")) {
            parsedConnectionIntentHandler.mo5318d(400, "Disconnect requires a validsession_key as an extra");
        }
        try {
            parsedConnectionIntentHandler.mo5320f(Integer.valueOf(host).intValue(), UUID.fromString(intent.getStringExtra("session_key")));
        } catch (NumberFormatException unused) {
            parsedConnectionIntentHandler.mo5318d(400, "Disconnect requires a validinteger session_id as host");
        } catch (IllegalArgumentException unused2) {
            parsedConnectionIntentHandler.mo5318d(400, "Disconnect requires a UUID session_key");
        } catch (NullPointerException unused3) {
            parsedConnectionIntentHandler.mo5318d(400, "Disconnect requires a valid non-null UUID for session_key");
        }
    }

    /* renamed from: f */
    public static void m5541f(Context context, Intent intent, ParsedConnectionIntentHandler parsedConnectionIntentHandler) {
        Uri data = intent.getData();
        if (data == null) {
            return;
        }
        int intExtra = intent.getIntExtra("NOTIFICATION_TO_CANCEL", 0);
        if (intExtra > 0) {
            ((NotificationManager) context.getSystemService("notification")).cancel(intExtra);
        }
        gj0.m4141b("ConnectionIntentParser", "Got a URL: " + data);
        List<String> pathSegments = data.getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            m5539d(context, intent, parsedConnectionIntentHandler);
            return;
        }
        String str = pathSegments.get(0);
        if (str.equalsIgnoreCase("connect")) {
            m5542g(context, intent, parsedConnectionIntentHandler);
            return;
        }
        if (str.equalsIgnoreCase("resume")) {
            m5542g(context, intent, parsedConnectionIntentHandler);
            return;
        }
        if (str.equalsIgnoreCase("run")) {
            m5543h(context, intent, parsedConnectionIntentHandler);
        } else if (str.equalsIgnoreCase("disconnect")) {
            m5540e(context, intent, parsedConnectionIntentHandler);
        } else {
            parsedConnectionIntentHandler.mo5318d(400, "Intent path must be connect, resume, run or disconnect");
        }
    }

    /* renamed from: g */
    public static void m5542g(Context context, Intent intent, ParsedConnectionIntentHandler parsedConnectionIntentHandler) {
        Uri data = intent.getData();
        if (data == null) {
            parsedConnectionIntentHandler.mo5318d(400, "ConnectionIntent has no data");
            return;
        }
        String host = data.getHost();
        if (host == null || host.isEmpty()) {
            parsedConnectionIntentHandler.mo5318d(400, "Resume requires a valid session_id as host");
            return;
        }
        if (!intent.hasExtra("session_key")) {
            parsedConnectionIntentHandler.mo5318d(400, "Resume requires a valid session key as extra");
            return;
        }
        try {
            Integer valueOf = Integer.valueOf(host);
            parsedConnectionIntentHandler.mo5316b(valueOf.intValue(), UUID.fromString(intent.getStringExtra("session_key")));
        } catch (NumberFormatException unused) {
            parsedConnectionIntentHandler.mo5318d(400, "Resume requires a valid session_id integer for the host");
        } catch (IllegalArgumentException unused2) {
            parsedConnectionIntentHandler.mo5318d(400, "Resume requires a valid UUID for session_key");
        } catch (NullPointerException unused3) {
            parsedConnectionIntentHandler.mo5318d(400, "Resume requires a valid non-null UUID for session_key");
        }
    }

    /* renamed from: h */
    public static void m5543h(Context context, Intent intent, ParsedConnectionIntentHandler parsedConnectionIntentHandler) {
        String stringExtra;
        UUID uuid;
        Connection connection;
        Uri data = intent.getData();
        if (data == null) {
            parsedConnectionIntentHandler.mo5318d(400, "ConnectionIntent has no data");
            return;
        }
        if (intent.hasExtra("snippet_id") && intent.hasExtra("command")) {
            parsedConnectionIntentHandler.mo5318d(400, "Run requires command OR snippet_id as an extra");
            return;
        }
        Snippet snippet = null;
        if (intent.hasExtra("snippet_id")) {
            uuid = UUID.fromString(intent.getStringExtra("snippet_id"));
            stringExtra = null;
        } else if (!intent.hasExtra("command")) {
            parsedConnectionIntentHandler.mo5318d(400, "Neither snippet_id nor command have been specified as an extra");
            return;
        } else {
            stringExtra = intent.getStringExtra("command");
            uuid = null;
        }
        if (uuid != null) {
            try {
                snippet = m5537b(context, uuid);
            } catch (IllegalArgumentException unused) {
                parsedConnectionIntentHandler.mo5318d(404, context.getString(R.string.snippet_not_found));
                return;
            }
        } else if (stringExtra != null) {
            snippet = new Snippet("", stringExtra);
        } else {
            parsedConnectionIntentHandler.mo5318d(404, context.getString(R.string.no_command_or_snippet));
        }
        String host = data.getHost();
        if (host == null || host.isEmpty()) {
            parsedConnectionIntentHandler.mo5318d(400, "Run requires a valid session_id, connection_id or address string as host");
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("background", false);
        if (intent.hasExtra("session_key")) {
            try {
                parsedConnectionIntentHandler.mo5319e(Integer.valueOf(host).intValue(), UUID.fromString("session_key"), snippet, booleanExtra);
                return;
            } catch (NullPointerException unused2) {
                parsedConnectionIntentHandler.mo5318d(400, "Run requires that session_key be a non-null UUID");
                return;
            } catch (NumberFormatException unused3) {
                parsedConnectionIntentHandler.mo5318d(400, "Run requires a valid integer session_id as host when specifying a session key");
                return;
            } catch (IllegalArgumentException unused4) {
                parsedConnectionIntentHandler.mo5318d(400, "Run requires that session_key be a valid UUID");
                return;
            }
        }
        new Connection();
        try {
            try {
                connection = m5536a(context, UUID.fromString(host)).mo5368g();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                parsedConnectionIntentHandler.mo5318d(400, e.getMessage());
                return;
            }
        } catch (IllegalArgumentException unused5) {
            Pair<ConnectionProvider, Identity> m5538c = m5538c(data);
            Connection mo5368g = ((ConnectionProvider) m5538c.first).mo5368g();
            if (intent.getBooleanExtra("should_save", false)) {
                try {
                    m5544i(context, (Identity) m5538c.second, mo5368g);
                    C1328DB.m5404d(Snippet.class, context).create(snippet);
                } catch (SQLException e2) {
                    e2.printStackTrace();
                    parsedConnectionIntentHandler.mo5318d(500, "Couldn't saveconnection, identity or snippet");
                    return;
                }
            }
            connection = mo5368g;
        }
        parsedConnectionIntentHandler.mo5315a(connection, snippet, booleanExtra);
    }

    /* renamed from: i */
    public static void m5544i(Context context, Identity identity, Connection connection) throws SQLException {
        if (connection.type == 2) {
            connection.nickname = context.getString(R.string.local_device);
            connection.address = "localhost";
        }
        C1328DB.m5404d(Connection.class, context).create(connection);
        if (identity != null) {
            C1328DB.m5404d(Identity.class, context).create(identity);
            connection.m5472z(identity, context);
        }
    }
}
