package cz.opentree.libssh;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ssh_kex_struct extends Structure {
    public byte[] cookie;
    public Pointer[] methods;

    /* loaded from: classes.dex */
    public static class ByReference extends ssh_kex_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends ssh_kex_struct implements Structure.ByValue {
    }

    public ssh_kex_struct() {
        this.cookie = new byte[16];
        this.methods = new Pointer[10];
    }

    public ssh_kex_struct(Pointer pointer) {
        super(pointer);
        this.cookie = new byte[16];
        this.methods = new Pointer[10];
    }

    public ssh_kex_struct(byte[] bArr, Pointer[] pointerArr) {
        byte[] bArr2 = new byte[16];
        this.cookie = bArr2;
        Pointer[] pointerArr2 = new Pointer[10];
        this.methods = pointerArr2;
        if (bArr.length != bArr2.length) {
            throw new IllegalArgumentException("Wrong array size !");
        }
        this.cookie = bArr;
        if (pointerArr.length != pointerArr2.length) {
            throw new IllegalArgumentException("Wrong array size !");
        }
        this.methods = pointerArr;
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("cookie", "methods");
    }
}
