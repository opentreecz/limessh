package com.sun.jna;

/* loaded from: classes.dex */
public class PointerUtils {
    public static Pointer fromAddress(long j) {
        return new Pointer(j);
    }

    public static long getAddress(Pointer pointer) {
        return pointer.peer;
    }

    public static long getAddress(PointerType pointerType) {
        return pointerType.getPointer().peer;
    }
}
