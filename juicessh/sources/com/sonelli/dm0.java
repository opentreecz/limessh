package com.sonelli;

import dagger.Lazy;
import javax.inject.Provider;

/* compiled from: DoubleCheck.java */
/* loaded from: classes.dex */
public final class dm0<T> implements Provider<T>, Lazy<T> {

    /* renamed from: c */
    public static final Object f2246c = new Object();

    /* renamed from: a */
    public volatile Provider<T> f2247a;

    /* renamed from: b */
    public volatile Object f2248b = f2246c;

    public dm0(Provider<T> provider) {
        this.f2247a = provider;
    }

    /* renamed from: a */
    public static <P extends Provider<T>, T> Provider<T> m3263a(P p) {
        fm0.m3808b(p);
        return p instanceof dm0 ? p : new dm0(p);
    }

    /* renamed from: b */
    public static Object m3264b(Object obj, Object obj2) {
        if (!(obj != f2246c) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // javax.inject.Provider
    public T get() {
        T t = (T) this.f2248b;
        Object obj = f2246c;
        if (t == obj) {
            synchronized (this) {
                t = (T) this.f2248b;
                if (t == obj) {
                    t = this.f2247a.get();
                    m3264b(this.f2248b, t);
                    this.f2248b = t;
                    this.f2247a = null;
                }
            }
        }
        return t;
    }
}
