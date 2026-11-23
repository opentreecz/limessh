package com.sonelli.libssh;

import com.sonelli.libssh.sftp_session_struct;
import com.sonelli.libssh.ssh_string_struct;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class sftp_file_struct extends Structure {
    public int eof;
    public ssh_string_struct.ByReference handle;
    public Pointer name;
    public int nonblocking;
    public long offset;
    public sftp_session_struct.ByReference sftp;

    /* loaded from: classes.dex */
    public static class ByReference extends sftp_file_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends sftp_file_struct implements Structure.ByValue {
    }

    public sftp_file_struct() {
    }

    public sftp_file_struct(sftp_session_struct.ByReference byReference, Pointer pointer, long j, ssh_string_struct.ByReference byReference2, int i, int i2) {
        this.sftp = byReference;
        this.name = pointer;
        this.offset = j;
        this.handle = byReference2;
        this.eof = i;
        this.nonblocking = i2;
    }

    public sftp_file_struct(Pointer pointer) {
        super(pointer);
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("sftp", "name", "offset", "handle", "eof", "nonblocking");
    }
}
