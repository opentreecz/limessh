package com.sonelli.libssh;

import androidx.core.app.NotificationCompat;
import com.sonelli.libssh.SshLibrary;
import com.sonelli.libssh.sftp_attributes_struct;
import com.sonelli.libssh.sftp_session_struct;
import com.sonelli.libssh.ssh_string_struct;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class sftp_client_message_struct extends Structure {
    public sftp_attributes_struct.ByReference attr;
    public int attr_num;
    public SshLibrary.ssh_buffer attrbuf;
    public SshLibrary.ssh_buffer complete_message;
    public ssh_string_struct.ByReference data;
    public Pointer filename;
    public int flags;
    public ssh_string_struct.ByReference handle;

    /* renamed from: id */
    public int f4842id;
    public int len;
    public long offset;
    public sftp_session_struct.ByReference sftp;
    public Pointer str_data;
    public Pointer submessage;
    public byte type;

    /* loaded from: classes.dex */
    public static class ByReference extends sftp_client_message_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends sftp_client_message_struct implements Structure.ByValue {
    }

    public sftp_client_message_struct() {
    }

    public sftp_client_message_struct(Pointer pointer) {
        super(pointer);
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("sftp", NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, "id", "filename", "flags", "attr", "handle", "offset", "len", "attr_num", "attrbuf", "data", "complete_message", "str_data", "submessage");
    }
}
