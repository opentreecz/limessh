package com.sonelli.libssh.adapter;

import android.util.Log;
import com.ochafik.lang.jnaerator.runtime.NativeSize;
import com.sonelli.ak0;
import com.sonelli.ck0;
import com.sonelli.libssh.SshLibrary;
import com.sonelli.libssh.ssh_callbacks_struct;
import com.sonelli.libssh.ssh_channel_callbacks_struct;
import com.sun.jna.Pointer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class SSHAuthAgent implements SshLibrary.ssh_channel_open_request_auth_agent_callback {
    public static final String TAG = "SSHAuthAgent";
    private final ArrayList<ak0> keys = new ArrayList<>();
    private final SshLibrary libssh;
    private final SshLibrary.ssh_session session;
    private final ck0 ssh;

    public SSHAuthAgent(SshLibrary sshLibrary, SshLibrary.ssh_session ssh_sessionVar, ck0 ck0Var) {
        this.libssh = sshLibrary;
        this.session = ssh_sessionVar;
        this.ssh = ck0Var;
        ssh_callbacks_struct ssh_callbacks_structVar = new ssh_callbacks_struct();
        ssh_callbacks_structVar.size = new NativeSize(ssh_callbacks_structVar.size());
        ssh_callbacks_structVar.channel_open_request_auth_agent_function = this;
        if (sshLibrary.ssh_set_callbacks(ssh_sessionVar, ssh_callbacks_structVar) != 0) {
            Log.e(TAG, "Failed to register callback for ssh auth agent forwarding");
        }
    }

    public void addKey(int i, String str, String str2) {
        this.keys.add(new ak0(this.ssh, i, str, str2));
        this.ssh.m2849j("Added public key to ssh agent: " + str2);
    }

    @Override // com.sonelli.libssh.SshLibrary.ssh_channel_open_request_auth_agent_callback
    public SshLibrary.ssh_channel apply(Pointer pointer, Pointer pointer2) {
        SshLibrary.ssh_channel ssh_channel_new = this.libssh.ssh_channel_new(this.session);
        if (ssh_channel_new == null) {
            String ssh_get_error = this.libssh.ssh_get_error(this.session.getPointer());
            this.ssh.m2849j("Failed to open channel for ssh auth forward request: " + ssh_get_error);
            return null;
        }
        ssh_channel_callbacks_struct ssh_channel_callbacks_structVar = new ssh_channel_callbacks_struct();
        ssh_channel_callbacks_structVar.size = new NativeSize(ssh_channel_callbacks_structVar.size());
        ssh_channel_callbacks_structVar.channel_data_function = new SSHAuthAgentRequest(this.libssh, this.ssh, this);
        if (this.libssh.ssh_set_channel_callbacks(ssh_channel_new, ssh_channel_callbacks_structVar) == 0) {
            return ssh_channel_new;
        }
        this.ssh.m2849j("Failed to register callback on ssh auth forwarding channel: " + this.libssh.ssh_get_error(pointer));
        return null;
    }

    public ak0 getKeyWithPublicKeyBlob(byte[] bArr) {
        Iterator<ak0> it = this.keys.iterator();
        while (it.hasNext()) {
            ak0 next = it.next();
            if (Arrays.equals(next.m2135b(), bArr)) {
                return next;
            }
        }
        return null;
    }

    public List<ak0> getKeys() {
        return this.keys;
    }
}
