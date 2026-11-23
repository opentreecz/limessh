package com.sonelli.libssh;

import androidx.core.app.NotificationCompat;
import com.sonelli.libssh.ssh_string_struct;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ssh_signature_struct extends Structure {
    public int hash_type;
    public ssh_string_struct.ByReference raw_sig;
    public int type;
    public Pointer type_c;

    /* loaded from: classes.dex */
    public static class ByReference extends ssh_signature_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends ssh_signature_struct implements Structure.ByValue {
    }

    public ssh_signature_struct() {
    }

    public ssh_signature_struct(int i, int i2, Pointer pointer, ssh_string_struct.ByReference byReference) {
        this.type = i;
        this.hash_type = i2;
        this.type_c = pointer;
        this.raw_sig = byReference;
    }

    public ssh_signature_struct(Pointer pointer) {
        super(pointer);
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, "hash_type", "type_c", "raw_sig");
    }
}
