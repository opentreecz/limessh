package com.sonelli.libssh;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ssh_hmac_struct extends Structure {
    public byte etm;
    public int hmac_type;
    public Pointer name;

    /* loaded from: classes.dex */
    public static class ByReference extends ssh_hmac_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends ssh_hmac_struct implements Structure.ByValue {
    }

    public ssh_hmac_struct() {
    }

    public ssh_hmac_struct(Pointer pointer) {
        super(pointer);
    }

    public ssh_hmac_struct(Pointer pointer, int i, byte b) {
        this.name = pointer;
        this.hmac_type = i;
        this.etm = b;
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("name", "hmac_type", "etm");
    }
}
