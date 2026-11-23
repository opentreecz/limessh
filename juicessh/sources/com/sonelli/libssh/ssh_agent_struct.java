package com.sonelli.libssh;

import com.sonelli.libssh.SshLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ssh_agent_struct extends Structure {
    public SshLibrary.ssh_channel channel;
    public int count;
    public SshLibrary.ssh_buffer ident;
    public SshLibrary.ssh_socket_struct sock;

    /* loaded from: classes.dex */
    public static class ByReference extends ssh_agent_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends ssh_agent_struct implements Structure.ByValue {
    }

    public ssh_agent_struct() {
    }

    public ssh_agent_struct(SshLibrary.ssh_socket_struct ssh_socket_structVar, SshLibrary.ssh_buffer ssh_bufferVar, int i, SshLibrary.ssh_channel ssh_channelVar) {
        this.sock = ssh_socket_structVar;
        this.ident = ssh_bufferVar;
        this.count = i;
        this.channel = ssh_channelVar;
    }

    public ssh_agent_struct(Pointer pointer) {
        super(pointer);
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("sock", "ident", "count", "channel");
    }
}
