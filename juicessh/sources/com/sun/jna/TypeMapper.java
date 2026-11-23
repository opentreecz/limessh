package com.sun.jna;

/* loaded from: classes.dex */
public interface TypeMapper {
    FromNativeConverter getFromNativeConverter(Class<?> cls);

    ToNativeConverter getToNativeConverter(Class<?> cls);
}
