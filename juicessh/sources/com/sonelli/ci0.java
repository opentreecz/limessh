package com.sonelli;

import androidx.fragment.app.FragmentActivity;
import com.sonelli.juicessh.R;
import com.sonelli.juicessh.models.Connection;
import com.sonelli.juicessh.models.Snippet;
import java.io.File;
import java.util.UUID;

/* compiled from: LocalTransport.java */
/* loaded from: classes.dex */
public class ci0 extends ei0 {
    public ci0(FragmentActivity fragmentActivity, int i, UUID uuid, bi0 bi0Var, int i2, Connection connection, Snippet snippet) {
        super(fragmentActivity, i, uuid, bi0Var, i2, connection, snippet);
        m3510s();
    }

    @Override // com.sonelli.juicessh.connections.transports.TerminalSessionProvider
    /* renamed from: c */
    public String mo2813c() {
        return this.f2407d.getString(R.string.local_terminal);
    }

    @Override // com.sonelli.juicessh.connections.transports.TerminalSessionProvider
    /* renamed from: d */
    public String mo2814d() {
        return "localhost";
    }

    @Override // com.sonelli.ei0, com.sonelli.mi0
    /* renamed from: k */
    public Connection mo2815k() {
        return this.f2411h;
    }

    @Override // com.sonelli.mi0
    /* renamed from: p */
    public boolean mo2816p() {
        return false;
    }

    @Override // com.sonelli.mi0
    /* renamed from: q */
    public boolean mo2817q() {
        return false;
    }

    @Override // com.sonelli.ei0
    /* renamed from: t */
    public String[] mo2818t() {
        return new String[]{"--rcfile", new File(this.f2407d.getApplicationInfo().nativeLibraryDir) + "/libcom_sonelli_bashrc.so", null};
    }

    @Override // com.sonelli.ei0
    /* renamed from: u */
    public String mo2819u() {
        return this.f2407d.getApplicationInfo().nativeLibraryDir + "/libcom_sonelli_bash.so";
    }
}
