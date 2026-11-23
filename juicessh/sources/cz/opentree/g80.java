package cz.opentree;

import com.google.firebase.inject.Provider;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public class g80<T> implements Provider<T> {

    /* renamed from: c */
    public static final Object f2839c = new Object();

    /* renamed from: a */
    public volatile Object f2840a = f2839c;

    /* renamed from: b */
    public volatile Provider<T> f2841b;

    public g80(Provider<T> provider) {
        this.f2841b = provider;
    }

    @Override // com.google.firebase.inject.Provider
    public T get() {
        T t = (T) this.f2840a;
        Object obj = f2839c;
        if (t == obj) {
            synchronized (this) {
                t = (T) this.f2840a;
                if (t == obj) {
                    t = this.f2841b.get();
                    this.f2840a = t;
                    this.f2841b = null;
                }
            }
        }
        return t;
    }
}
