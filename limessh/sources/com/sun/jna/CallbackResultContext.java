package com.sun.jna;

import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class CallbackResultContext extends ToNativeContext {
    private Method method;

    public CallbackResultContext(Method method) {
        this.method = method;
    }

    public Method getMethod() {
        return this.method;
    }
}
