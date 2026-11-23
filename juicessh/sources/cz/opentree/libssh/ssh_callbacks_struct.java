package cz.opentree.libssh;

import com.ochafik.lang.jnaerator.runtime.NativeSize;
import cz.opentree.libssh.SshLibrary;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ssh_callbacks_struct extends Structure {
    public SshLibrary.ssh_auth_callback auth_function;
    public SshLibrary.ssh_channel_open_request_auth_agent_callback channel_open_request_auth_agent_function;
    public SshLibrary.ssh_channel_open_request_x11_callback channel_open_request_x11_function;
    public connect_status_function_callback connect_status_function;
    public SshLibrary.ssh_global_request_callback global_request_function;
    public SshLibrary.ssh_log_callback log_function;
    public NativeSize size;
    public Pointer userdata;

    /* loaded from: classes.dex */
    public static class ByReference extends ssh_callbacks_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends ssh_callbacks_struct implements Structure.ByValue {
    }

    /* loaded from: classes.dex */
    public interface connect_status_function_callback extends Callback {
        void apply(Pointer pointer, float f);
    }

    public ssh_callbacks_struct() {
    }

    public ssh_callbacks_struct(NativeSize nativeSize, Pointer pointer, SshLibrary.ssh_auth_callback ssh_auth_callbackVar, SshLibrary.ssh_log_callback ssh_log_callbackVar, connect_status_function_callback connect_status_function_callbackVar, SshLibrary.ssh_global_request_callback ssh_global_request_callbackVar, SshLibrary.ssh_channel_open_request_x11_callback ssh_channel_open_request_x11_callbackVar, SshLibrary.ssh_channel_open_request_auth_agent_callback ssh_channel_open_request_auth_agent_callbackVar) {
        this.size = nativeSize;
        this.userdata = pointer;
        this.auth_function = ssh_auth_callbackVar;
        this.log_function = ssh_log_callbackVar;
        this.connect_status_function = connect_status_function_callbackVar;
        this.global_request_function = ssh_global_request_callbackVar;
        this.channel_open_request_x11_function = ssh_channel_open_request_x11_callbackVar;
        this.channel_open_request_auth_agent_function = ssh_channel_open_request_auth_agent_callbackVar;
    }

    public ssh_callbacks_struct(Pointer pointer) {
        super(pointer);
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("size", "userdata", "auth_function", "log_function", "connect_status_function", "global_request_function", "channel_open_request_x11_function", "channel_open_request_auth_agent_function");
    }
}
