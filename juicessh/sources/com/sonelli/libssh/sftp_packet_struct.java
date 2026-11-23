package com.sonelli.libssh;

import androidx.core.app.NotificationCompat;
import com.sonelli.libssh.SshLibrary;
import com.sonelli.libssh.sftp_session_struct;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class sftp_packet_struct extends Structure {
    public SshLibrary.ssh_buffer payload;
    public sftp_session_struct.ByReference sftp;
    public byte type;

    /* loaded from: classes.dex */
    public static class ByReference extends sftp_packet_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends sftp_packet_struct implements Structure.ByValue {
    }

    public sftp_packet_struct() {
    }

    public sftp_packet_struct(sftp_session_struct.ByReference byReference, byte b, SshLibrary.ssh_buffer ssh_bufferVar) {
        this.sftp = byReference;
        this.type = b;
        this.payload = ssh_bufferVar;
    }

    public sftp_packet_struct(Pointer pointer) {
        super(pointer);
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("sftp", NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, "payload");
    }
}
