package cz.opentree.libssh;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ssh_string_struct extends Structure {
    public byte[] data;
    public int size;

    /* loaded from: classes.dex */
    public static class ByReference extends ssh_string_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends ssh_string_struct implements Structure.ByValue {
    }

    public ssh_string_struct() {
        this.data = new byte[1];
    }

    public ssh_string_struct(int i, byte[] bArr) {
        byte[] bArr2 = new byte[1];
        this.data = bArr2;
        this.size = i;
        if (bArr.length != bArr2.length) {
            throw new IllegalArgumentException("Wrong array size !");
        }
        this.data = bArr;
    }

    public ssh_string_struct(Pointer pointer) {
        super(pointer);
        this.data = new byte[1];
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("size", "data");
    }
}
