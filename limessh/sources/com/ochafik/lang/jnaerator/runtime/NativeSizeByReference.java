package com.ochafik.lang.jnaerator.runtime;

import com.sun.jna.ptr.ByReference;

/* loaded from: classes.dex */
public class NativeSizeByReference extends ByReference {
    public NativeSizeByReference() {
        this(new NativeSize(0L));
    }

    public NativeSizeByReference(NativeSize nativeSize) {
        super(NativeSize.SIZE);
        setValue(nativeSize);
    }

    public NativeSize getValue() {
        int i = NativeSize.SIZE;
        if (i == 4) {
            return new NativeSize(getPointer().getInt(0L));
        }
        if (i == 8) {
            return new NativeSize(getPointer().getLong(0L));
        }
        throw new RuntimeException("GCCLong has to be either 4 or 8 bytes.");
    }

    public void setValue(NativeSize nativeSize) {
        int i = NativeSize.SIZE;
        if (i == 4) {
            getPointer().setInt(0L, nativeSize.intValue());
        } else {
            if (i != 8) {
                throw new RuntimeException("GCCLong has to be either 4 or 8 bytes.");
            }
            getPointer().setLong(0L, nativeSize.longValue());
        }
    }
}
