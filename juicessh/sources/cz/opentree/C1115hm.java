package cz.opentree;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.hm */
/* loaded from: classes.dex */
public final class C1115hm {

    /* renamed from: a */
    public final ConcurrentHashMap<C1050gm, List<Throwable>> f3171a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b */
    public final ReferenceQueue<Throwable> f3172b = new ReferenceQueue<>();

    /* renamed from: a */
    public final List<Throwable> m4487a(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.f3172b.poll();
        while (poll != null) {
            this.f3171a.remove(poll);
            poll = this.f3172b.poll();
        }
        List<Throwable> list = this.f3171a.get(new C1050gm(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f3171a.putIfAbsent(new C1050gm(th, this.f3172b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
