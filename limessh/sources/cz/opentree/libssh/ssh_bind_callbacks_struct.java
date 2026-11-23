package cz.opentree.libssh;

import com.ochafik.lang.jnaerator.runtime.NativeSize;
import cz.opentree.libssh.SshLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ssh_bind_callbacks_struct extends Structure {
    public SshLibrary.ssh_bind_incoming_connection_callback incoming_connection;
    public NativeSize size;

    /* loaded from: classes.dex */
    public static class ByReference extends ssh_bind_callbacks_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends ssh_bind_callbacks_struct implements Structure.ByValue {
    }

    public ssh_bind_callbacks_struct() {
    }

    public ssh_bind_callbacks_struct(NativeSize nativeSize, SshLibrary.ssh_bind_incoming_connection_callback ssh_bind_incoming_connection_callbackVar) {
        this.size = nativeSize;
        this.incoming_connection = ssh_bind_incoming_connection_callbackVar;
    }

    public ssh_bind_callbacks_struct(Pointer pointer) {
        super(pointer);
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("size", "incoming_connection");
    }
}
