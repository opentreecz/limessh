package com.sonelli.libssh;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class sftp_statvfs_struct extends Structure {
    public long f_bavail;
    public long f_bfree;
    public long f_blocks;
    public long f_bsize;
    public long f_favail;
    public long f_ffree;
    public long f_files;
    public long f_flag;
    public long f_frsize;
    public long f_fsid;
    public long f_namemax;

    /* loaded from: classes.dex */
    public static class ByReference extends sftp_statvfs_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends sftp_statvfs_struct implements Structure.ByValue {
    }

    public sftp_statvfs_struct() {
    }

    public sftp_statvfs_struct(Pointer pointer) {
        super(pointer);
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("f_bsize", "f_frsize", "f_blocks", "f_bfree", "f_bavail", "f_files", "f_ffree", "f_favail", "f_fsid", "f_flag", "f_namemax");
    }
}
