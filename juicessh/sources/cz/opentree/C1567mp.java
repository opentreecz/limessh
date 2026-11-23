package cz.opentree;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.mp */
/* loaded from: classes.dex */
public final class C1567mp<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: O */
    public int f5122O;

    /* renamed from: P */
    public Iterator<Map.Entry<K, V>> f5123P;

    /* renamed from: Q */
    public final /* synthetic */ C1468kp f5124Q;

    public C1567mp(C1468kp c1468kp) {
        List list;
        this.f5124Q = c1468kp;
        list = c1468kp.f4633P;
        this.f5122O = list.size();
    }

    public /* synthetic */ C1567mp(C1468kp c1468kp, C1231jp c1231jp) {
        this(c1468kp);
    }

    /* renamed from: b */
    public final Iterator<Map.Entry<K, V>> m6509b() {
        Map map;
        if (this.f5123P == null) {
            map = this.f5124Q.f4637T;
            this.f5123P = map.entrySet().iterator();
        }
        return this.f5123P;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        int i = this.f5122O;
        if (i > 0) {
            list = this.f5124Q.f4633P;
            if (i <= list.size()) {
                return true;
            }
        }
        return m6509b().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        if (m6509b().hasNext()) {
            return m6509b().next();
        }
        list = this.f5124Q.f4633P;
        int i = this.f5122O - 1;
        this.f5122O = i;
        return (Map.Entry) list.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
