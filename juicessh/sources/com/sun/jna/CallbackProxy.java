package com.sun.jna;

/* loaded from: classes.dex */
public interface CallbackProxy extends Callback {
    Object callback(Object[] objArr);

    Class<?>[] getParameterTypes();

    Class<?> getReturnType();
}
