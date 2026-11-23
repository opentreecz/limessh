package com.sonelli.libssh;

import androidx.core.app.NotificationCompat;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.PointerByReference;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ssh_key_struct extends Structure {
    public Pointer cert;
    public int cert_type;
    public PointerByReference dsa;
    public PointerByReference ecdsa;
    public int ecdsa_nid;
    public Pointer ed25519_privkey;
    public Pointer ed25519_pubkey;
    public int flags;
    public PointerByReference rsa;
    public int type;
    public Pointer type_c;

    /* loaded from: classes.dex */
    public static class ByReference extends ssh_key_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends ssh_key_struct implements Structure.ByValue {
    }

    public ssh_key_struct() {
    }

    public ssh_key_struct(Pointer pointer) {
        super(pointer);
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, "flags", "type_c", "ecdsa_nid", "dsa", "rsa", "ecdsa", "ed25519_pubkey", "ed25519_privkey", "cert", "cert_type");
    }
}
