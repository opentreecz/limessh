package com.sun.jna.win32;

import com.sun.jna.FunctionMapper;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.NativeMapped;
import com.sun.jna.NativeMappedConverter;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class StdCallFunctionMapper implements FunctionMapper {
    public int getArgumentNativeStackSize(Class<?> cls) {
        if (NativeMapped.class.isAssignableFrom(cls)) {
            cls = NativeMappedConverter.getInstance(cls).nativeType();
        }
        if (cls.isArray()) {
            return Native.POINTER_SIZE;
        }
        try {
            return Native.getNativeSize(cls);
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Unknown native stack allocation size for " + cls);
        }
    }

    @Override // com.sun.jna.FunctionMapper
    public String getFunctionName(NativeLibrary nativeLibrary, Method method) {
        String name = method.getName();
        int i = 0;
        for (Class<?> cls : method.getParameterTypes()) {
            i += getArgumentNativeStackSize(cls);
        }
        String str = name + "@" + i;
        try {
            try {
                return nativeLibrary.getFunction(str, 63).getName();
            } catch (UnsatisfiedLinkError unused) {
                return name;
            }
        } catch (UnsatisfiedLinkError unused2) {
            return nativeLibrary.getFunction("_" + str, 63).getName();
        }
    }
}
