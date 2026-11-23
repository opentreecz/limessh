package cz.opentree;

import android.util.Log;
import cz.opentree.libssh.SshLibrary;
import cz.opentree.sk0;
import java.io.IOException;

/* compiled from: SSHChannel.java */
/* loaded from: classes.dex */
public abstract class bk0 {

    /* renamed from: a */
    public SshLibrary f1760a;

    /* renamed from: b */
    public SshLibrary.ssh_channel f1761b;

    /* renamed from: c */
    public sk0.C1873a f1762c;

    /* renamed from: d */
    public sk0.C1874b f1763d;

    public bk0(SshLibrary sshLibrary, SshLibrary.ssh_session ssh_sessionVar) throws ek0 {
        this.f1760a = sshLibrary;
        SshLibrary.ssh_channel ssh_channel_new = sshLibrary.ssh_channel_new(ssh_sessionVar);
        this.f1761b = ssh_channel_new;
        if (ssh_channel_new != null) {
            Log.d("SSHChannel", "Successfully created new SSH channel");
        } else {
            Log.e("SSHChannel", "Failed to create new SSH channel");
            throw new ek0(ek0.f2466d0);
        }
    }

    /* renamed from: a */
    public void m2546a() {
        try {
            sk0.C1874b c1874b = this.f1763d;
            if (c1874b != null) {
                c1874b.close();
            }
            Log.d("SSHChannel", "SSH channel OutputStream closed");
        } catch (IOException e) {
            Log.e("SSHChannel", "IO Exception while trying to close SSH channel input/output streams: " + e.getMessage());
        }
        Log.d("SSHChannel", "Sending EOF to SSH channel");
        this.f1760a.ssh_channel_send_eof(this.f1761b);
        this.f1760a.ssh_channel_close(this.f1761b);
        Log.d("SSHChannel", "SSH channel closed");
    }

    /* renamed from: b */
    public int m2547b() {
        if (mo2550e()) {
            return this.f1760a.ssh_channel_get_exit_status(this.f1761b);
        }
        return -1;
    }

    /* renamed from: c */
    public sk0.C1874b m2548c() {
        sk0.C1874b c1874b = this.f1763d;
        if (c1874b == null || c1874b.m8460a()) {
            this.f1763d = new sk0.C1874b(this.f1760a, this.f1761b);
        }
        return this.f1763d;
    }

    /* renamed from: d */
    public sk0.C1873a m2549d() {
        sk0.C1873a c1873a = this.f1762c;
        if (c1873a == null || c1873a.m8459a()) {
            this.f1762c = new sk0.C1873a(this.f1760a, this.f1761b, false);
        }
        return this.f1762c;
    }

    /* renamed from: e */
    public boolean mo2550e() {
        return this.f1760a.ssh_channel_is_closed(this.f1761b) != 0;
    }
}
