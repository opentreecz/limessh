package com.ochafik.lang.jnaerator.runtime;

import com.sun.jna.Native;
import com.sun.jna.ptr.ByReference;

/* loaded from: classes.dex */
public class CharByReference extends ByReference {
    public CharByReference() {
        this((char) 0);
    }

    public CharByReference(char c) {
        super(Native.WCHAR_SIZE);
        setValue(c);
    }

    public char getValue() {
        return getPointer().getChar(0L);
    }

    public void setValue(char c) {
        getPointer().setChar(0L, c);
    }
}
