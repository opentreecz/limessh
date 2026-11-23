package com.sonelli;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public final class v70<T> {

    /* renamed from: a */
    public final Set<Class<? super T>> f7414a;

    /* renamed from: b */
    public final Set<b80> f7415b;

    /* renamed from: c */
    public final int f7416c;

    /* renamed from: d */
    public final int f7417d;

    /* renamed from: e */
    public final ComponentFactory<T> f7418e;

    /* renamed from: f */
    public final Set<Class<?>> f7419f;

    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    /* renamed from: com.sonelli.v70$b */
    /* loaded from: classes.dex */
    public static class C2157b<T> {

        /* renamed from: a */
        public final Set<Class<? super T>> f7420a;

        /* renamed from: b */
        public final Set<b80> f7421b;

        /* renamed from: c */
        public int f7422c;

        /* renamed from: d */
        public int f7423d;

        /* renamed from: e */
        public ComponentFactory<T> f7424e;

        /* renamed from: f */
        public Set<Class<?>> f7425f;

        @SafeVarargs
        public C2157b(Class<T> cls, Class<? super T>... clsArr) {
            HashSet hashSet = new HashSet();
            this.f7420a = hashSet;
            this.f7421b = new HashSet();
            this.f7422c = 0;
            this.f7423d = 0;
            this.f7425f = new HashSet();
            i80.m4728c(cls, "Null interface");
            hashSet.add(cls);
            for (Class<? super T> cls2 : clsArr) {
                i80.m4728c(cls2, "Null interface");
            }
            Collections.addAll(this.f7420a, clsArr);
        }

        /* renamed from: a */
        public static /* synthetic */ C2157b m9186a(C2157b c2157b) {
            c2157b.m9192g();
            return c2157b;
        }

        /* renamed from: b */
        public C2157b<T> m9187b(b80 b80Var) {
            i80.m4728c(b80Var, "Null dependency");
            m9194i(b80Var.m2397a());
            this.f7421b.add(b80Var);
            return this;
        }

        /* renamed from: c */
        public C2157b<T> m9188c() {
            m9193h(1);
            return this;
        }

        /* renamed from: d */
        public v70<T> m9189d() {
            i80.m4729d(this.f7424e != null, "Missing required property: factory.");
            return new v70<>(new HashSet(this.f7420a), new HashSet(this.f7421b), this.f7422c, this.f7423d, this.f7424e, this.f7425f);
        }

        /* renamed from: e */
        public C2157b<T> m9190e() {
            m9193h(2);
            return this;
        }

        /* renamed from: f */
        public C2157b<T> m9191f(ComponentFactory<T> componentFactory) {
            i80.m4728c(componentFactory, "Null factory");
            this.f7424e = componentFactory;
            return this;
        }

        /* renamed from: g */
        public final C2157b<T> m9192g() {
            this.f7423d = 1;
            return this;
        }

        /* renamed from: h */
        public final C2157b<T> m9193h(int i) {
            i80.m4729d(this.f7422c == 0, "Instantiation type has already been set.");
            this.f7422c = i;
            return this;
        }

        /* renamed from: i */
        public final void m9194i(Class<?> cls) {
            i80.m4726a(!this.f7420a.contains(cls), "Components are not allowed to depend on interfaces they themselves provide.");
        }
    }

    public v70(Set<Class<? super T>> set, Set<b80> set2, int i, int i2, ComponentFactory<T> componentFactory, Set<Class<?>> set3) {
        this.f7414a = Collections.unmodifiableSet(set);
        this.f7415b = Collections.unmodifiableSet(set2);
        this.f7416c = i;
        this.f7417d = i2;
        this.f7418e = componentFactory;
        this.f7419f = Collections.unmodifiableSet(set3);
    }

    /* renamed from: a */
    public static <T> C2157b<T> m9172a(Class<T> cls) {
        return new C2157b<>(cls, new Class[0]);
    }

    @SafeVarargs
    /* renamed from: b */
    public static <T> C2157b<T> m9173b(Class<T> cls, Class<? super T>... clsArr) {
        return new C2157b<>(cls, clsArr);
    }

    /* renamed from: g */
    public static <T> v70<T> m9174g(T t, Class<T> cls) {
        C2157b m9175h = m9175h(cls);
        m9175h.m9191f(u70.m8858b(t));
        return m9175h.m9189d();
    }

    /* renamed from: h */
    public static <T> C2157b<T> m9175h(Class<T> cls) {
        C2157b<T> m9172a = m9172a(cls);
        C2157b.m9186a(m9172a);
        return m9172a;
    }

    /* renamed from: l */
    public static /* synthetic */ Object m9176l(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    /* renamed from: m */
    public static /* synthetic */ Object m9177m(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    @SafeVarargs
    /* renamed from: n */
    public static <T> v70<T> m9178n(T t, Class<T> cls, Class<? super T>... clsArr) {
        C2157b m9173b = m9173b(cls, clsArr);
        m9173b.m9191f(t70.m8601b(t));
        return m9173b.m9189d();
    }

    /* renamed from: c */
    public Set<b80> m9179c() {
        return this.f7415b;
    }

    /* renamed from: d */
    public ComponentFactory<T> m9180d() {
        return this.f7418e;
    }

    /* renamed from: e */
    public Set<Class<? super T>> m9181e() {
        return this.f7414a;
    }

    /* renamed from: f */
    public Set<Class<?>> m9182f() {
        return this.f7419f;
    }

    /* renamed from: i */
    public boolean m9183i() {
        return this.f7416c == 1;
    }

    /* renamed from: j */
    public boolean m9184j() {
        return this.f7416c == 2;
    }

    /* renamed from: k */
    public boolean m9185k() {
        return this.f7417d == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f7414a.toArray()) + ">{" + this.f7416c + ", type=" + this.f7417d + ", deps=" + Arrays.toString(this.f7415b.toArray()) + "}";
    }
}
