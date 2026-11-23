package com.sun.jna;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public interface FunctionMapper {
    String getFunctionName(NativeLibrary nativeLibrary, Method method);
}
