package cz.opentree;

import android.util.Log;
import cz.opentree.libssh.SshLibrary;

/* compiled from: SSHShell.java */
/* loaded from: classes.dex */
public class mk0 extends bk0 {
    public mk0(SshLibrary sshLibrary, SshLibrary.ssh_session ssh_sessionVar, String str, int i, int i2, dk0 dk0Var) throws ek0 {
        super(sshLibrary, ssh_sessionVar);
        if (sshLibrary.ssh_channel_open_session(this.f1761b) != 0) {
            throw new ek0(ek0.f2469g0);
        }
        if (sshLibrary.ssh_channel_request_pty_size(this.f1761b, str, i, i2) != 0) {
            throw new ek0(ek0.f2468f0);
        }
        if (dk0Var.m3251g() && sshLibrary.ssh_channel_request_auth_agent(this.f1761b) != 0) {
            Log.e("SSHChannel", "Request for ssh auth agent forwarding failed");
        }
        if (sshLibrary.ssh_channel_request_shell(this.f1761b) != 0) {
            throw new ek0(ek0.f2468f0);
        }
    }

    @Override // cz.opentree.bk0
    /* renamed from: e */
    public boolean mo2550e() {
        if (this.f1760a.ssh_channel_is_eof(this.f1761b) != 0) {
            return true;
        }
        return super.mo2550e();
    }

    /* renamed from: f */
    public void m6444f(int i, int i2) throws ek0 {
        if (!mo2550e() && this.f1760a.ssh_channel_change_pty_size(this.f1761b, i, i2) != 0) {
            throw new ek0(ek0.f2467e0);
        }
    }
}
