package com.sonelli;

import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public class z70 extends s70 {

    /* renamed from: e */
    public static final Provider<Set<Object>> f8462e = y70.m10095a();

    /* renamed from: a */
    public final Map<v70<?>, g80<?>> f8463a = new HashMap();

    /* renamed from: b */
    public final Map<Class<?>, g80<?>> f8464b = new HashMap();

    /* renamed from: c */
    public final Map<Class<?>, g80<Set<?>>> f8465c = new HashMap();

    /* renamed from: d */
    public final f80 f8466d;

    public z70(Executor executor, Iterable<ComponentRegistrar> iterable, v70<?>... v70VarArr) {
        f80 f80Var = new f80(executor);
        this.f8466d = f80Var;
        ArrayList<v70<?>> arrayList = new ArrayList();
        arrayList.add(v70.m9178n(f80Var, f80.class, Subscriber.class, Publisher.class));
        Iterator<ComponentRegistrar> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getComponents());
        }
        for (v70<?> v70Var : v70VarArr) {
            if (v70Var != null) {
                arrayList.add(v70Var);
            }
        }
        a80.m1990a(arrayList);
        for (v70<?> v70Var2 : arrayList) {
            this.f8463a.put(v70Var2, new g80<>(w70.m9413a(this, v70Var2)));
        }
        m10399h();
        m10400i();
    }

    /* renamed from: g */
    public static /* synthetic */ Set m10397g(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(((g80) it.next()).get());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @Override // com.google.firebase.components.ComponentContainer
    /* renamed from: b */
    public <T> Provider<T> mo1599b(Class<T> cls) {
        i80.m4728c(cls, "Null interface requested.");
        return this.f8464b.get(cls);
    }

    @Override // com.google.firebase.components.ComponentContainer
    /* renamed from: c */
    public <T> Provider<Set<T>> mo1600c(Class<T> cls) {
        g80<Set<?>> g80Var = this.f8465c.get(cls);
        return g80Var != null ? g80Var : (Provider<Set<T>>) f8462e;
    }

    /* renamed from: e */
    public void m10398e(boolean z) {
        for (Map.Entry<v70<?>, g80<?>> entry : this.f8463a.entrySet()) {
            v70<?> key = entry.getKey();
            g80<?> value = entry.getValue();
            if (key.m9183i() || (key.m9184j() && z)) {
                value.get();
            }
        }
        this.f8466d.m3689c();
    }

    /* renamed from: h */
    public final void m10399h() {
        for (Map.Entry<v70<?>, g80<?>> entry : this.f8463a.entrySet()) {
            v70<?> key = entry.getKey();
            if (key.m9185k()) {
                g80<?> value = entry.getValue();
                Iterator<Class<? super Object>> it = key.m9181e().iterator();
                while (it.hasNext()) {
                    this.f8464b.put(it.next(), value);
                }
            }
        }
        m10401j();
    }

    /* renamed from: i */
    public final void m10400i() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<v70<?>, g80<?>> entry : this.f8463a.entrySet()) {
            v70<?> key = entry.getKey();
            if (!key.m9185k()) {
                g80<?> value = entry.getValue();
                for (Class<? super Object> cls : key.m9181e()) {
                    if (!hashMap.containsKey(cls)) {
                        hashMap.put(cls, new HashSet());
                    }
                    ((Set) hashMap.get(cls)).add(value);
                }
            }
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            this.f8465c.put((Class) entry2.getKey(), new g80<>(x70.m9727a((Set) entry2.getValue())));
        }
    }

    /* renamed from: j */
    public final void m10401j() {
        for (v70<?> v70Var : this.f8463a.keySet()) {
            for (b80 b80Var : v70Var.m9179c()) {
                if (b80Var.m2399c() && !this.f8464b.containsKey(b80Var.m2397a())) {
                    throw new h80(String.format("Unsatisfied dependency for component %s: %s", v70Var, b80Var.m2397a()));
                }
            }
        }
    }
}
