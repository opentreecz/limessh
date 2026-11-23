package cz.opentree;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public final class j80 extends s70 {

    /* renamed from: a */
    public final Set<Class<?>> f3514a;

    /* renamed from: b */
    public final Set<Class<?>> f3515b;

    /* renamed from: c */
    public final Set<Class<?>> f3516c;

    /* renamed from: d */
    public final Set<Class<?>> f3517d;

    /* renamed from: e */
    public final Set<Class<?>> f3518e;

    /* renamed from: f */
    public final ComponentContainer f3519f;

    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    /* renamed from: cz.opentree.j80$a */
    /* loaded from: classes.dex */
    public static class C1201a implements Publisher {

        /* renamed from: a */
        public final Set<Class<?>> f3520a;

        /* renamed from: b */
        public final Publisher f3521b;

        public C1201a(Set<Class<?>> set, Publisher publisher) {
            this.f3520a = set;
            this.f3521b = publisher;
        }
    }

    public j80(v70<?> v70Var, ComponentContainer componentContainer) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (b80 b80Var : v70Var.m9179c()) {
            if (b80Var.m2398b()) {
                if (b80Var.m2400d()) {
                    hashSet3.add(b80Var.m2397a());
                } else {
                    hashSet.add(b80Var.m2397a());
                }
            } else if (b80Var.m2400d()) {
                hashSet4.add(b80Var.m2397a());
            } else {
                hashSet2.add(b80Var.m2397a());
            }
        }
        if (!v70Var.m9182f().isEmpty()) {
            hashSet.add(Publisher.class);
        }
        this.f3514a = Collections.unmodifiableSet(hashSet);
        this.f3515b = Collections.unmodifiableSet(hashSet2);
        this.f3516c = Collections.unmodifiableSet(hashSet3);
        this.f3517d = Collections.unmodifiableSet(hashSet4);
        this.f3518e = v70Var.m9182f();
        this.f3519f = componentContainer;
    }

    @Override // cz.opentree.s70, com.google.firebase.components.ComponentContainer
    /* renamed from: a */
    public <T> T mo1598a(Class<T> cls) {
        if (!this.f3514a.contains(cls)) {
            throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        T t = (T) this.f3519f.mo1598a(cls);
        return !cls.equals(Publisher.class) ? t : (T) new C1201a(this.f3518e, (Publisher) t);
    }

    @Override // com.google.firebase.components.ComponentContainer
    /* renamed from: b */
    public <T> Provider<T> mo1599b(Class<T> cls) {
        if (this.f3515b.contains(cls)) {
            return this.f3519f.mo1599b(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", cls));
    }

    @Override // com.google.firebase.components.ComponentContainer
    /* renamed from: c */
    public <T> Provider<Set<T>> mo1600c(Class<T> cls) {
        if (this.f3517d.contains(cls)) {
            return this.f3519f.mo1600c(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", cls));
    }

    @Override // cz.opentree.s70, com.google.firebase.components.ComponentContainer
    /* renamed from: d */
    public <T> Set<T> mo1601d(Class<T> cls) {
        if (this.f3516c.contains(cls)) {
            return this.f3519f.mo1601d(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", cls));
    }
}
