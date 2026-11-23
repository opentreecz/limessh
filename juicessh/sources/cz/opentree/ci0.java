package cz.opentree;

import androidx.fragment.app.FragmentActivity;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.models.Connection;
import cz.opentree.juicessh.models.Snippet;
import java.io.File;
import java.util.UUID;

/* compiled from: LocalTransport.java */
/* loaded from: classes.dex */
public class ci0 extends ei0 {
    public ci0(FragmentActivity fragmentActivity, int i, UUID uuid, bi0 bi0Var, int i2, Connection connection, Snippet snippet) {
        super(fragmentActivity, i, uuid, bi0Var, i2, connection, snippet);
        m3510s();
    }

    @Override // cz.opentree.juicessh.connections.transports.TerminalSessionProvider
    /* renamed from: c */
    public String mo2813c() {
        return this.f2407d.getString(R.string.local_terminal);
    }

    @Override // cz.opentree.juicessh.connections.transports.TerminalSessionProvider
    /* renamed from: d */
    public String mo2814d() {
        return "localhost";
    }

    @Override // cz.opentree.ei0, cz.opentree.mi0
    /* renamed from: k */
    public Connection mo2815k() {
        return this.f2411h;
    }

    @Override // cz.opentree.mi0
    /* renamed from: p */
    public boolean mo2816p() {
        return false;
    }

    @Override // cz.opentree.mi0
    /* renamed from: q */
    public boolean mo2817q() {
        return false;
    }

    @Override // cz.opentree.ei0
    /* renamed from: t */
    public String[] mo2818t() {
        return new String[]{"--rcfile", new File(this.f2407d.getApplicationInfo().nativeLibraryDir) + "/libcom_sonelli_bashrc.so", null};
    }

    @Override // cz.opentree.ei0
    /* renamed from: u */
    public String mo2819u() {
        return this.f2407d.getApplicationInfo().nativeLibraryDir + "/libcom_sonelli_bash.so";
    }
}
