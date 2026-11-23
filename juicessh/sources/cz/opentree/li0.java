package cz.opentree;

import androidx.fragment.app.FragmentActivity;
import cz.opentree.juicessh.models.Connection;
import cz.opentree.juicessh.models.Snippet;
import java.util.UUID;

/* compiled from: TelnetTransport.java */
/* loaded from: classes.dex */
public class li0 extends ei0 {

    /* renamed from: q */
    public Connection f4815q;

    public li0(FragmentActivity fragmentActivity, int i, UUID uuid, bi0 bi0Var, int i2, Connection connection, Snippet snippet) {
        super(fragmentActivity, i, uuid, bi0Var, i2, connection, snippet);
        this.f4815q = connection;
        m3510s();
    }

    @Override // cz.opentree.juicessh.connections.transports.TerminalSessionProvider
    /* renamed from: c */
    public String mo2813c() {
        return "Telnet: " + this.f4815q.m5471w();
    }

    @Override // cz.opentree.juicessh.connections.transports.TerminalSessionProvider
    /* renamed from: d */
    public String mo2814d() {
        return this.f4815q.address;
    }

    @Override // cz.opentree.ei0
    /* renamed from: t */
    public String[] mo2818t() {
        Connection connection = this.f4815q;
        return new String[]{connection.address, String.valueOf(connection.port), null};
    }

    @Override // cz.opentree.ei0
    /* renamed from: u */
    public String mo2819u() {
        return this.f2407d.getApplicationInfo().nativeLibraryDir + "/libcom_sonelli_telnet.so";
    }
}
