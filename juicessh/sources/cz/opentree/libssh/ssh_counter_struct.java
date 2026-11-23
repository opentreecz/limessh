package cz.opentree.libssh;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ssh_counter_struct extends Structure {
    public long in_bytes;
    public long in_packets;
    public long out_bytes;
    public long out_packets;

    /* loaded from: classes.dex */
    public static class ByReference extends ssh_counter_struct implements Structure.ByReference {
    }

    /* loaded from: classes.dex */
    public static class ByValue extends ssh_counter_struct implements Structure.ByValue {
    }

    public ssh_counter_struct() {
    }

    public ssh_counter_struct(long j, long j2, long j3, long j4) {
        this.in_bytes = j;
        this.out_bytes = j2;
        this.in_packets = j3;
        this.out_packets = j4;
    }

    public ssh_counter_struct(Pointer pointer) {
        super(pointer);
    }

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        return Arrays.asList("in_bytes", "out_bytes", "in_packets", "out_packets");
    }
}
