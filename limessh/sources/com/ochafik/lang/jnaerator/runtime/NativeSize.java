package com.ochafik.lang.jnaerator.runtime;

import com.sun.jna.IntegerType;
import com.sun.jna.Native;

/* loaded from: classes.dex */
public class NativeSize extends IntegerType {
    public static int SIZE = Native.SIZE_T_SIZE;
    private static final long serialVersionUID = 2398288011955445078L;

    public NativeSize() {
        this(0L);
    }

    public NativeSize(long j) {
        super(SIZE, j);
    }
}
