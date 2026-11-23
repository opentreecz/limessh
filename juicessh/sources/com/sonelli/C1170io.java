package com.sonelli;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.io */
/* loaded from: classes.dex */
public final class C1170io<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: O */
    public Iterator<Map.Entry<K, Object>> f3379O;

    public C1170io(Iterator<Map.Entry<K, Object>> it) {
        this.f3379O = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3379O.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.f3379O.next();
        return next.getValue() instanceof C0891do ? new C1005fo(next) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f3379O.remove();
    }
}
