package com.sonelli.libssh.adapter;

import com.sonelli.ak0;
import com.sonelli.ck0;
import com.sonelli.libssh.SshLibrary;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class SSHAuthAgentRequest implements SshLibrary.ssh_channel_data_callback {
    public static final int BUFFER_LENGTH = 32768;
    public static final int REQUEST_SSH_AGENTC_ADD_IDENTITY = 17;
    public static final int REQUEST_SSH_AGENTC_ADD_ID_CONSTRAINED = 25;
    public static final int REQUEST_SSH_AGENTC_ADD_SMARTCARD_KEY = 20;
    public static final int REQUEST_SSH_AGENTC_ADD_SMARTCARD_KEY_CONSTRAINED = 26;
    public static final int REQUEST_SSH_AGENTC_EXTENSION = 27;
    public static final int REQUEST_SSH_AGENTC_LOCK = 22;
    public static final int REQUEST_SSH_AGENTC_REMOVE_ALL_IDENTITIES = 19;
    public static final int REQUEST_SSH_AGENTC_REMOVE_IDENTITY = 18;
    public static final int REQUEST_SSH_AGENTC_REMOVE_SMARTCARD_KEY = 21;
    public static final int REQUEST_SSH_AGENTC_REQUEST_IDENTITIES = 11;
    public static final int REQUEST_SSH_AGENTC_SIGN_REQUEST = 13;
    public static final int REQUEST_SSH_AGENTC_UNLOCK = 23;
    public static final int RESPONSE_SSH_AGENT_EXTENSION_FAILURE = 28;
    public static final int RESPONSE_SSH_AGENT_FAILURE = 5;
    public static final int RESPONSE_SSH_AGENT_IDENTITIES_ANSWER = 12;
    public static final int RESPONSE_SSH_AGENT_SIGN_RESPONSE = 14;
    public static final int RESPONSE_SSH_AGENT_SUCCESS = 6;
    public static final int SSH_MSG_CHANNEL_DATA = 94;
    private final SSHAuthAgent agent;
    private final SshLibrary libssh;
    private final ck0 ssh;

    public SSHAuthAgentRequest(SshLibrary sshLibrary, ck0 ck0Var, SSHAuthAgent sSHAuthAgent) {
        this.libssh = sshLibrary;
        this.ssh = ck0Var;
        this.agent = sSHAuthAgent;
    }

    @Override // com.sonelli.libssh.SshLibrary.ssh_channel_data_callback
    public int apply(Pointer pointer, Pointer pointer2, Pointer pointer3, int i, int i2, Pointer pointer4) {
        if (i < 5) {
            return 5;
        }
        SshLibrary.ssh_channel ssh_channelVar = new SshLibrary.ssh_channel(pointer2);
        this.libssh.ssh_channel_set_blocking(ssh_channelVar, 0);
        byte[] byteArray = pointer3.getByteArray(0L, i);
        StringBuilder sb = new StringBuilder();
        for (byte b : byteArray) {
            sb.append(b & 255);
            sb.append(" ");
        }
        ByteBuffer wrap = ByteBuffer.wrap(byteArray);
        int i3 = wrap.getInt();
        byte b2 = wrap.get();
        ByteBuffer allocate = ByteBuffer.allocate(32768);
        allocate.order(ByteOrder.BIG_ENDIAN);
        if (b2 == 11) {
            this.ssh.m2849j("Received SSH agent request: REQUEST_SSH_AGENTC_REQUEST_IDENTITIES");
            allocate.put((byte) 12);
            allocate.putInt(this.agent.getKeys().size());
            for (ak0 ak0Var : this.agent.getKeys()) {
                this.ssh.m2849j("Adding public key to REQUEST_SSH_AGENTC_REQUEST_IDENTITIES response: " + (SSHAuthenticator.m6192f(ak0Var.m2136c()) + ak0Var.m2134a()));
                byte[] m2135b = ak0Var.m2135b();
                allocate.putInt(m2135b.length);
                allocate.put(m2135b);
                allocate.putInt("JuiceSSH (agent)".getBytes().length);
                allocate.put("JuiceSSH (agent)".getBytes());
            }
        } else {
            if (b2 != 13) {
                this.ssh.m2849j("Received unsupported SSH agent request: " + ((int) b2));
                return i3 + 4;
            }
            this.ssh.m2849j("Received SSH agent request: REQUEST_SSH_AGENTC_SIGN_REQUEST");
            byte[] bArr = new byte[wrap.getInt()];
            wrap.get(bArr);
            byte[] bArr2 = new byte[wrap.getInt()];
            wrap.get(bArr2);
            int i4 = wrap.getInt();
            ak0 keyWithPublicKeyBlob = this.agent.getKeyWithPublicKeyBlob(bArr);
            if (keyWithPublicKeyBlob == null) {
                this.ssh.m2849j("Could not find matching key for ssh agent signing request");
                allocate.put((byte) 5);
            } else {
                byte[] m2137d = keyWithPublicKeyBlob.m2137d(bArr2, i4);
                if (m2137d == null) {
                    this.ssh.m2849j("Failed to sign data for ssh agent signing request");
                    allocate.put((byte) 5);
                } else {
                    allocate.put((byte) 14);
                    allocate.putInt(m2137d.length);
                    allocate.put(m2137d);
                }
            }
        }
        allocate.flip();
        int remaining = allocate.remaining();
        ByteBuffer allocate2 = ByteBuffer.allocate(remaining + 4);
        allocate2.order(ByteOrder.BIG_ENDIAN);
        allocate2.putInt(remaining);
        allocate2.put(allocate);
        allocate2.flip();
        int remaining2 = allocate2.remaining();
        byte[] bArr3 = new byte[remaining2];
        allocate2.get(bArr3);
        Memory memory = new Memory(remaining2);
        memory.write(0L, bArr3, 0, remaining2);
        int ssh_channel_write = this.libssh.ssh_channel_write(ssh_channelVar, memory, remaining2);
        if (ssh_channel_write != remaining2) {
            this.ssh.m2849j(String.format("Failed to respond to ssh auth agent request: only sent %d out of %d bytes", Integer.valueOf(ssh_channel_write), Integer.valueOf(remaining2)));
        }
        this.ssh.m2849j(String.format("Responded to SSH agent request with %d bytes of data", Integer.valueOf(ssh_channel_write)));
        return i3 + 4;
    }
}
