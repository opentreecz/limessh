package cz.opentree.libssh;

import cz.opentree.libssh.ssh_key_struct;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ssh_knownhosts_entry extends Structure {
    public Pointer comment;
    public Pointer hostname;
    public ssh_key_struct.ByReference publickey;
    public Pointer unparsed;

    /* loaded from: classes.dex */
    public static class ByReference extends ssh_knownhosts_entry implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends ssh_knownhosts_entry implements Structure.ByValue {
    }

    public ssh_knownhosts_entry() {
    }

    public ssh_knownhosts_entry(Pointer pointer) {
        super(pointer);
    }

    public ssh_knownhosts_entry(Pointer pointer, Pointer pointer2, ssh_key_struct.ByReference byReference, Pointer pointer3) {
        this.hostname = pointer;
        this.unparsed = pointer2;
        this.publickey = byReference;
        this.comment = pointer3;
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("hostname", "unparsed", "publickey", "comment");
    }
}
