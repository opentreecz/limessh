package cz.opentree;

import dagger.Lazy;
import dagger.internal.Factory;

/* compiled from: InstanceFactory.java */
/* loaded from: classes.dex */
public final class em0<T> implements Factory<T>, Lazy<T> {

    /* renamed from: a */
    public final T f2495a;

    public em0(T t) {
        this.f2495a = t;
    }

    /* renamed from: a */
    public static <T> Factory<T> m3531a(T t) {
        fm0.m3809c(t, "instance cannot be null");
        return new em0(t);
    }

    @Override // javax.inject.Provider
    public T get() {
        return this.f2495a;
    }
}
