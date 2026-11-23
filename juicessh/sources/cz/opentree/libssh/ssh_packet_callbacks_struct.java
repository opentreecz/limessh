package cz.opentree.libssh;

import cz.opentree.libssh.SshLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ssh_packet_callbacks_struct extends Structure {
    public SshLibrary.ssh_packet_callback callbacks;
    public byte n_callbacks;
    public byte start;
    public Pointer user;

    /* loaded from: classes.dex */
    public static class ByReference extends ssh_packet_callbacks_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends ssh_packet_callbacks_struct implements Structure.ByValue {
    }

    public ssh_packet_callbacks_struct() {
    }

    public ssh_packet_callbacks_struct(byte b, byte b2, SshLibrary.ssh_packet_callback ssh_packet_callbackVar, Pointer pointer) {
        this.start = b;
        this.n_callbacks = b2;
        this.callbacks = ssh_packet_callbackVar;
        this.user = pointer;
    }

    public ssh_packet_callbacks_struct(Pointer pointer) {
        super(pointer);
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("start", "n_callbacks", "callbacks", "user");
    }
}
