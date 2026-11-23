package cz.opentree;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import cz.opentree.juicessh.connections.transports.ConnectionProvider;
import cz.opentree.juicessh.models.Connection;
import cz.opentree.juicessh.models.PortForward;
import java.util.UUID;

/* compiled from: ConnectionStateChangeReceiver.java */
/* loaded from: classes.dex */
public class sj0 extends BroadcastReceiver {
    /* renamed from: a */
    public static void m8455a(Context context, Connection connection, ConnectionProvider connectionProvider, int i) {
        UUID uuid;
        UUID uuid2;
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
        Intent intent = new Intent("cz.opentree.juicessh.connection.state");
        intent.putExtra("state", i);
        if (connection != null && (uuid2 = connection.f3993id) != null) {
            intent.putExtra("connection_id", uuid2);
        }
        if ((connectionProvider instanceof PortForward) && (uuid = ((PortForward) connectionProvider).f3993id) != null) {
            intent.putExtra("portforward_id", uuid);
        }
        localBroadcastManager.sendBroadcast(intent);
    }
}
