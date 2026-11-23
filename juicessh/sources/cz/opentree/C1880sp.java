package cz.opentree;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.sp */
/* loaded from: classes.dex */
public final class C1880sp<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: O */
    public int f6577O;

    /* renamed from: P */
    public boolean f6578P;

    /* renamed from: Q */
    public Iterator<Map.Entry<K, V>> f6579Q;

    /* renamed from: R */
    public final /* synthetic */ C1468kp f6580R;

    public C1880sp(C1468kp c1468kp) {
        this.f6580R = c1468kp;
        this.f6577O = -1;
    }

    public /* synthetic */ C1880sp(C1468kp c1468kp, C1231jp c1231jp) {
        this(c1468kp);
    }

    /* renamed from: b */
    public final Iterator<Map.Entry<K, V>> m8478b() {
        Map map;
        if (this.f6579Q == null) {
            map = this.f6580R.f4634Q;
            this.f6579Q = map.entrySet().iterator();
        }
        return this.f6579Q;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i = this.f6577O + 1;
        list = this.f6580R.f4633P;
        if (i >= list.size()) {
            map = this.f6580R.f4634Q;
            if (map.isEmpty() || !m8478b().hasNext()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        List list2;
        this.f6578P = true;
        int i = this.f6577O + 1;
        this.f6577O = i;
        list = this.f6580R.f4633P;
        if (i >= list.size()) {
            return m8478b().next();
        }
        list2 = this.f6580R.f4633P;
        return (Map.Entry) list2.get(this.f6577O);
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (!this.f6578P) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f6578P = false;
        this.f6580R.m5985p();
        int i = this.f6577O;
        list = this.f6580R.f4633P;
        if (i >= list.size()) {
            m8478b().remove();
            return;
        }
        C1468kp c1468kp = this.f6580R;
        int i2 = this.f6577O;
        this.f6577O = i2 - 1;
        c1468kp.m5982k(i2);
    }
}
