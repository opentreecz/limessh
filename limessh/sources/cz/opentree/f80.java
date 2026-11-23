package cz.opentree;

import androidx.annotation.GuardedBy;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public class f80 implements Subscriber, Publisher {

    /* renamed from: a */
    @GuardedBy("this")
    public final Map<Class<?>, ConcurrentHashMap<EventHandler<Object>, Executor>> f2627a = new HashMap();

    /* renamed from: b */
    @GuardedBy("this")
    public Queue<dd0<?>> f2628b = new ArrayDeque();

    /* renamed from: c */
    public final Executor f2629c;

    public f80(Executor executor) {
        this.f2629c = executor;
    }

    @Override // com.google.firebase.events.Subscriber
    /* renamed from: a */
    public <T> void mo1862a(Class<T> cls, EventHandler<? super T> eventHandler) {
        mo1863b(cls, this.f2629c, eventHandler);
    }

    @Override // com.google.firebase.events.Subscriber
    /* renamed from: b */
    public synchronized <T> void mo1863b(Class<T> cls, Executor executor, EventHandler<? super T> eventHandler) {
        i80.m4727b(cls);
        i80.m4727b(eventHandler);
        i80.m4727b(executor);
        if (!this.f2627a.containsKey(cls)) {
            this.f2627a.put(cls, new ConcurrentHashMap<>());
        }
        this.f2627a.get(cls).put(eventHandler, executor);
    }

    /* renamed from: c */
    public void m3689c() {
        Queue<dd0<?>> queue;
        synchronized (this) {
            queue = this.f2628b;
            if (queue != null) {
                this.f2628b = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            Iterator<dd0<?>> it = queue.iterator();
            while (it.hasNext()) {
                m3691f(it.next());
            }
        }
    }

    /* renamed from: d */
    public final synchronized Set<Map.Entry<EventHandler<Object>, Executor>> m3690d(dd0<?> dd0Var) {
        ConcurrentHashMap<EventHandler<Object>, Executor> concurrentHashMap;
        concurrentHashMap = this.f2627a.get(dd0Var.m3192b());
        return concurrentHashMap == null ? Collections.emptySet() : concurrentHashMap.entrySet();
    }

    /* renamed from: f */
    public void m3691f(dd0<?> dd0Var) {
        i80.m4727b(dd0Var);
        synchronized (this) {
            Queue<dd0<?>> queue = this.f2628b;
            if (queue != null) {
                queue.add(dd0Var);
                return;
            }
            for (Map.Entry<EventHandler<Object>, Executor> entry : m3690d(dd0Var)) {
                entry.getValue().execute(e80.m3457a(entry, dd0Var));
            }
        }
    }
}
