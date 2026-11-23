package com.sun.jna.ptr;

import com.sun.jna.Memory;
import com.sun.jna.PointerType;

/* loaded from: classes.dex */
public abstract class ByReference extends PointerType {
    public ByReference(int i) {
        setPointer(new Memory(i));
    }
}
