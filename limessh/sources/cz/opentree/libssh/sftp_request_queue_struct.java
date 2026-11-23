package cz.opentree.libssh;

import cz.opentree.libssh.sftp_message_struct;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class sftp_request_queue_struct extends Structure {
    public sftp_message_struct.ByReference message;
    public ByReference next;

    /* loaded from: classes.dex */
    public static class ByReference extends sftp_request_queue_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends sftp_request_queue_struct implements Structure.ByValue {
    }

    public sftp_request_queue_struct() {
    }

    public sftp_request_queue_struct(ByReference byReference, sftp_message_struct.ByReference byReference2) {
        this.next = byReference;
        this.message = byReference2;
    }

    public sftp_request_queue_struct(Pointer pointer) {
        super(pointer);
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("next", "message");
    }
}
