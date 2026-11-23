package com.sun.jna;

/* loaded from: classes.dex */
public class CallbackReferenceHack {
    public static Callback getCallback(Class<?> cls, Pointer pointer) {
        return CallbackReference.getCallback(cls, pointer);
    }

    public static Pointer getFunctionPointer(Callback callback) {
        return CallbackReference.getFunctionPointer(callback);
    }
}
