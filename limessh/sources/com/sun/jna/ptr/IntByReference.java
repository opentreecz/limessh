package com.sun.jna.ptr;

/* loaded from: classes.dex */
public class IntByReference extends ByReference {
    public IntByReference() {
        this(0);
    }

    public IntByReference(int i) {
        super(4);
        setValue(i);
    }

    public int getValue() {
        return getPointer().getInt(0L);
    }

    public void setValue(int i) {
        getPointer().setInt(0L, i);
    }
}
