package com.sonelli.libssh;

import com.sonelli.libssh.SshLibrary;
import com.sonelli.libssh.sftp_session_struct;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class sftp_message_struct extends Structure {

    /* renamed from: id */
    public int f4843id;
    public byte packet_type;
    public SshLibrary.ssh_buffer payload;
    public sftp_session_struct.ByReference sftp;

    /* loaded from: classes.dex */
    public static class ByReference extends sftp_message_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends sftp_message_struct implements Structure.ByValue {
    }

    public sftp_message_struct() {
    }

    public sftp_message_struct(sftp_session_struct.ByReference byReference, byte b, SshLibrary.ssh_buffer ssh_bufferVar, int i) {
        this.sftp = byReference;
        this.packet_type = b;
        this.payload = ssh_bufferVar;
        this.f4843id = i;
    }

    public sftp_message_struct(Pointer pointer) {
        super(pointer);
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("sftp", "packet_type", "payload", "id");
    }
}
