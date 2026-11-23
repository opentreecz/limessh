package cz.opentree.libssh;

import cz.opentree.libssh.SshLibrary;
import cz.opentree.libssh.sftp_session_struct;
import cz.opentree.libssh.ssh_string_struct;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class sftp_dir_struct extends Structure {
    public SshLibrary.ssh_buffer buffer;
    public int count;
    public int eof;
    public ssh_string_struct.ByReference handle;
    public Pointer name;
    public sftp_session_struct.ByReference sftp;

    /* loaded from: classes.dex */
    public static class ByReference extends sftp_dir_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends sftp_dir_struct implements Structure.ByValue {
    }

    public sftp_dir_struct() {
    }

    public sftp_dir_struct(sftp_session_struct.ByReference byReference, Pointer pointer, ssh_string_struct.ByReference byReference2, SshLibrary.ssh_buffer ssh_bufferVar, int i, int i2) {
        this.sftp = byReference;
        this.name = pointer;
        this.handle = byReference2;
        this.buffer = ssh_bufferVar;
        this.count = i;
        this.eof = i2;
    }

    public sftp_dir_struct(Pointer pointer) {
        super(pointer);
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("sftp", "name", "handle", "buffer", "count", "eof");
    }
}
