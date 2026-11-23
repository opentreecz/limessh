package com.sonelli.libssh;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class error_struct extends Structure {
    public byte[] error_buffer;
    public int error_code;

    /* loaded from: classes.dex */
    public static class ByReference extends error_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends error_struct implements Structure.ByValue {
    }

    public error_struct() {
        this.error_buffer = new byte[1024];
    }

    public error_struct(int i, byte[] bArr) {
        byte[] bArr2 = new byte[1024];
        this.error_buffer = bArr2;
        this.error_code = i;
        if (bArr.length != bArr2.length) {
            throw new IllegalArgumentException("Wrong array size !");
        }
        this.error_buffer = bArr;
    }

    public error_struct(Pointer pointer) {
        super(pointer);
        this.error_buffer = new byte[1024];
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("error_code", "error_buffer");
    }
}
