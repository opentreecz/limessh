package com.sun.jna;

/* loaded from: classes.dex */
public class FromNativeContext {
    private Class<?> type;

    public FromNativeContext(Class<?> cls) {
        this.type = cls;
    }

    public Class<?> getTargetType() {
        return this.type;
    }
}
