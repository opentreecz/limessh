package com.sonelli.libssh;

import androidx.core.app.NotificationCompat;
import com.sonelli.libssh.ssh_string_struct;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class sftp_attributes_struct extends Structure {
    public ssh_string_struct.ByReference acl;
    public int atime;
    public long atime64;
    public int atime_nseconds;
    public long createtime;
    public int createtime_nseconds;
    public int extended_count;
    public ssh_string_struct.ByReference extended_data;
    public ssh_string_struct.ByReference extended_type;
    public int flags;
    public int gid;
    public Pointer group;
    public Pointer longname;
    public int mtime;
    public long mtime64;
    public int mtime_nseconds;
    public Pointer name;
    public Pointer owner;
    public int permissions;
    public long size;
    public byte type;
    public int uid;

    /* loaded from: classes.dex */
    public static class ByReference extends sftp_attributes_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends sftp_attributes_struct implements Structure.ByValue {
    }

    public sftp_attributes_struct() {
    }

    public sftp_attributes_struct(Pointer pointer) {
        super(pointer);
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("name", "longname", "flags", NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, "size", "uid", "gid", "owner", "group", "permissions", "atime64", "atime", "atime_nseconds", "createtime", "createtime_nseconds", "mtime64", "mtime", "mtime_nseconds", "acl", "extended_count", "extended_type", "extended_data");
    }
}
