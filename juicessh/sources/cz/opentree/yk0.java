package cz.opentree;

import java.util.Map;

/* compiled from: ListEntry.java */
/* loaded from: classes.dex */
public class yk0<K, V> implements Map.Entry<K, V> {

    /* renamed from: O */
    public final K f8259O;

    /* renamed from: P */
    public V f8260P;

    public yk0(K k, V v) {
        this.f8259O = k;
        this.f8260P = v;
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return this.f8259O;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.f8260P;
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        V v2 = this.f8260P;
        this.f8260P = v;
        return v2;
    }
}
