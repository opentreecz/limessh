package com.sonelli.libssh;

import com.sonelli.libssh.SshLibrary;
import com.sonelli.libssh.sftp_packet_struct;
import com.sonelli.libssh.sftp_request_queue_struct;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.PointerByReference;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class sftp_session_struct extends Structure {
    public SshLibrary.ssh_channel channel;
    public int client_version;
    public int errnum;
    public SshLibrary.sftp_ext ext;
    public PointerByReference handles;
    public int id_counter;
    public sftp_request_queue_struct.ByReference queue;
    public sftp_packet_struct.ByReference read_packet;
    public int server_version;
    public SshLibrary.ssh_session session;
    public int version;

    /* loaded from: classes.dex */
    public static class ByReference extends sftp_session_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends sftp_session_struct implements Structure.ByValue {
    }

    public sftp_session_struct() {
    }

    public sftp_session_struct(Pointer pointer) {
        super(pointer);
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("session", "channel", "server_version", "client_version", "version", "queue", "id_counter", "errnum", "handles", "ext", "read_packet");
    }
}
