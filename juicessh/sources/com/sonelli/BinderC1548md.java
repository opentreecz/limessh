package com.sonelli;

import android.os.IBinder;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.reflect.Field;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.md */
/* loaded from: classes.dex */
public final class BinderC1548md<T> extends IObjectWrapper.AbstractBinderC0446a {

    /* renamed from: a */
    public final T f5022a;

    public BinderC1548md(T t) {
        this.f5022a = t;
    }

    /* renamed from: O0 */
    public static <T> IObjectWrapper m6402O0(T t) {
        return new BinderC1548md(t);
    }

    /* renamed from: s */
    public static <T> T m6403s(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper instanceof BinderC1548md) {
            return ((BinderC1548md) iObjectWrapper).f5022a;
        }
        IBinder asBinder = iObjectWrapper.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i++;
                field = field2;
            }
        }
        if (i != 1) {
            int length = declaredFields.length;
            StringBuilder sb = new StringBuilder(64);
            sb.append("Unexpected number of IObjectWrapper declared fields: ");
            sb.append(length);
            throw new IllegalArgumentException(sb.toString());
        }
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return (T) field.get(asBinder);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
        } catch (NullPointerException e2) {
            throw new IllegalArgumentException("Binder object is null.", e2);
        }
    }
}
