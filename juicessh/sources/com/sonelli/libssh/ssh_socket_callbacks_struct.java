package com.sonelli.libssh;

import com.sonelli.libssh.SshLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ssh_socket_callbacks_struct extends Structure {
    public SshLibrary.ssh_callback_int_int connected;
    public SshLibrary.ssh_callback_int controlflow;
    public SshLibrary.ssh_callback_data data;
    public SshLibrary.ssh_callback_int_int exception;
    public Pointer userdata;

    /* loaded from: classes.dex */
    public static class ByReference extends ssh_socket_callbacks_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends ssh_socket_callbacks_struct implements Structure.ByValue {
    }

    public ssh_socket_callbacks_struct() {
    }

    public ssh_socket_callbacks_struct(Pointer pointer) {
        super(pointer);
    }

    public ssh_socket_callbacks_struct(Pointer pointer, SshLibrary.ssh_callback_data ssh_callback_dataVar, SshLibrary.ssh_callback_int ssh_callback_intVar, SshLibrary.ssh_callback_int_int ssh_callback_int_intVar, SshLibrary.ssh_callback_int_int ssh_callback_int_intVar2) {
        this.userdata = pointer;
        this.data = ssh_callback_dataVar;
        this.controlflow = ssh_callback_intVar;
        this.exception = ssh_callback_int_intVar;
        this.connected = ssh_callback_int_intVar2;
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("userdata", "data", "controlflow", "exception", "connected");
    }
}
