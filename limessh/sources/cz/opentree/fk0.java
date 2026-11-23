package cz.opentree;

import android.util.Log;
import cz.opentree.libssh.SshLibrary;
import java.util.Scanner;

/* compiled from: SSHExec.java */
/* loaded from: classes.dex */
public class fk0 extends bk0 {

    /* compiled from: SSHExec.java */
    /* renamed from: cz.opentree.fk0$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0995a {
        /* renamed from: a */
        public void mo3777a(int i) {
        }

        /* renamed from: b */
        public void mo3778b(String str) {
        }
    }

    public fk0(SshLibrary sshLibrary, SshLibrary.ssh_session ssh_sessionVar, String str, AbstractC0995a abstractC0995a) throws ek0 {
        super(sshLibrary, ssh_sessionVar);
        if (sshLibrary.ssh_channel_open_session(this.f1761b) != 0) {
            sshLibrary.ssh_channel_close(this.f1761b);
            Log.e("SSHChannel", "Failed to open session for exec on SSH channel");
            throw new ek0(ek0.f2469g0);
        }
        Log.d("SSHChannel", "Opened session for exec on SSH channel successfully");
        if (sshLibrary.ssh_channel_request_exec(this.f1761b, str) != 0) {
            Log.e("SSHChannel", "Failed to exec on SSH channel");
            sshLibrary.ssh_channel_close(this.f1761b);
            sshLibrary.ssh_channel_free(this.f1761b);
            throw new ek0(ek0.f2470h0, str);
        }
        Log.d("SSHChannel", "Ran command on SSH channel successfully");
        byte[] bArr = new byte[4096];
        while (true) {
            int read = m2549d().read(bArr);
            if (read <= -1) {
                break;
            }
            if (abstractC0995a != null) {
                Scanner scanner = new Scanner(new String(bArr, 0, read));
                while (scanner.hasNextLine()) {
                    abstractC0995a.mo3778b(scanner.nextLine());
                }
            }
        }
        if (abstractC0995a != null) {
            abstractC0995a.mo3777a(sshLibrary.ssh_channel_get_exit_status(this.f1761b));
        }
        Log.d("SSHChannel", "Closing SSH exec channel");
        sshLibrary.ssh_channel_close(this.f1761b);
        sshLibrary.channel_free(this.f1761b);
    }
}
