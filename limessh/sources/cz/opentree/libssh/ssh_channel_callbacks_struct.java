package cz.opentree.libssh;

import com.ochafik.lang.jnaerator.runtime.NativeSize;
import cz.opentree.libssh.SshLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ssh_channel_callbacks_struct extends Structure {
    public SshLibrary.ssh_channel_auth_agent_req_callback channel_auth_agent_req_function;
    public SshLibrary.ssh_channel_close_callback channel_close_function;
    public SshLibrary.ssh_channel_data_callback channel_data_function;
    public SshLibrary.ssh_channel_env_request_callback channel_env_request_function;
    public SshLibrary.ssh_channel_eof_callback channel_eof_function;
    public SshLibrary.ssh_channel_exec_request_callback channel_exec_request_function;
    public SshLibrary.ssh_channel_exit_signal_callback channel_exit_signal_function;
    public SshLibrary.ssh_channel_exit_status_callback channel_exit_status_function;
    public SshLibrary.ssh_channel_pty_request_callback channel_pty_request_function;
    public SshLibrary.ssh_channel_pty_window_change_callback channel_pty_window_change_function;
    public SshLibrary.ssh_channel_shell_request_callback channel_shell_request_function;
    public SshLibrary.ssh_channel_signal_callback channel_signal_function;
    public SshLibrary.ssh_channel_subsystem_request_callback channel_subsystem_request_function;
    public SshLibrary.ssh_channel_write_wontblock_callback channel_write_wontblock_function;
    public SshLibrary.ssh_channel_x11_req_callback channel_x11_req_function;
    public NativeSize size;
    public Pointer userdata;

    /* loaded from: classes.dex */
    public static class ByReference extends ssh_channel_callbacks_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends ssh_channel_callbacks_struct implements Structure.ByValue {
    }

    public ssh_channel_callbacks_struct() {
    }

    public ssh_channel_callbacks_struct(Pointer pointer) {
        super(pointer);
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("size", "userdata", "channel_data_function", "channel_eof_function", "channel_close_function", "channel_signal_function", "channel_exit_status_function", "channel_exit_signal_function", "channel_pty_request_function", "channel_shell_request_function", "channel_auth_agent_req_function", "channel_x11_req_function", "channel_pty_window_change_function", "channel_exec_request_function", "channel_env_request_function", "channel_subsystem_request_function", "channel_write_wontblock_function");
    }
}
