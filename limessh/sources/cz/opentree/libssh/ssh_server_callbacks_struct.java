package cz.opentree.libssh;

import com.ochafik.lang.jnaerator.runtime.NativeSize;
import cz.opentree.libssh.SshLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ssh_server_callbacks_struct extends Structure {
    public SshLibrary.ssh_auth_gssapi_mic_callback auth_gssapi_mic_function;
    public SshLibrary.ssh_auth_none_callback auth_none_function;
    public SshLibrary.ssh_auth_password_callback auth_password_function;
    public SshLibrary.ssh_auth_pubkey_callback auth_pubkey_function;
    public SshLibrary.ssh_channel_open_request_session_callback channel_open_request_session_function;
    public SshLibrary.ssh_gssapi_accept_sec_ctx_callback gssapi_accept_sec_ctx_function;
    public SshLibrary.ssh_gssapi_select_oid_callback gssapi_select_oid_function;
    public SshLibrary.ssh_gssapi_verify_mic_callback gssapi_verify_mic_function;
    public SshLibrary.ssh_service_request_callback service_request_function;
    public NativeSize size;
    public Pointer userdata;

    /* loaded from: classes.dex */
    public static class ByReference extends ssh_server_callbacks_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends ssh_server_callbacks_struct implements Structure.ByValue {
    }

    public ssh_server_callbacks_struct() {
    }

    public ssh_server_callbacks_struct(Pointer pointer) {
        super(pointer);
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("size", "userdata", "auth_password_function", "auth_none_function", "auth_gssapi_mic_function", "auth_pubkey_function", "service_request_function", "channel_open_request_session_function", "gssapi_select_oid_function", "gssapi_accept_sec_ctx_function", "gssapi_verify_mic_function");
    }
}
