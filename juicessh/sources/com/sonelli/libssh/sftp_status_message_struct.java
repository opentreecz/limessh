package com.sonelli.libssh;

import androidx.core.app.NotificationCompat;
import com.sonelli.libssh.ssh_string_struct;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class sftp_status_message_struct extends Structure {
    public ssh_string_struct.ByReference error_unused;
    public Pointer errormsg;

    /* renamed from: id */
    public int f4844id;
    public ssh_string_struct.ByReference lang_unused;
    public Pointer langmsg;
    public int status;

    /* loaded from: classes.dex */
    public static class ByReference extends sftp_status_message_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends sftp_status_message_struct implements Structure.ByValue {
    }

    public sftp_status_message_struct() {
    }

    public sftp_status_message_struct(int i, int i2, ssh_string_struct.ByReference byReference, ssh_string_struct.ByReference byReference2, Pointer pointer, Pointer pointer2) {
        this.f4844id = i;
        this.status = i2;
        this.error_unused = byReference;
        this.lang_unused = byReference2;
        this.errormsg = pointer;
        this.langmsg = pointer2;
    }

    public sftp_status_message_struct(Pointer pointer) {
        super(pointer);
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("id", NotificationCompat.CATEGORY_STATUS, "error_unused", "lang_unused", "errormsg", "langmsg");
    }
}
