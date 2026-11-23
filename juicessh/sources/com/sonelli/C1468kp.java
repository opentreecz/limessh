package com.sonelli;

import com.google.android.gms.internal.measurement.zzfd;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.kp */
/* loaded from: classes.dex */
public class C1468kp<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: O */
    public final int f4632O;

    /* renamed from: P */
    public List<C1730pp> f4633P;

    /* renamed from: Q */
    public Map<K, V> f4634Q;

    /* renamed from: R */
    public boolean f4635R;

    /* renamed from: S */
    public volatile C1829rp f4636S;

    /* renamed from: T */
    public Map<K, V> f4637T;

    /* renamed from: U */
    public volatile C1518lp f4638U;

    public C1468kp(int i) {
        this.f4632O = i;
        this.f4633P = Collections.emptyList();
        this.f4634Q = Collections.emptyMap();
        this.f4637T = Collections.emptyMap();
    }

    public /* synthetic */ C1468kp(int i, C1231jp c1231jp) {
        this(i);
    }

    /* renamed from: b */
    public static <FieldDescriptorType extends zzfd<FieldDescriptorType>> C1468kp<FieldDescriptorType, Object> m5971b(int i) {
        return new C1231jp(i);
    }

    /* renamed from: a */
    public final int m5977a(K k) {
        int size = this.f4633P.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.f4633P.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) this.f4633P.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i2;
                }
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        m5985p();
        if (!this.f4633P.isEmpty()) {
            this.f4633P.clear();
        }
        if (this.f4634Q.isEmpty()) {
            return;
        }
        this.f4634Q.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return m5977a(comparable) >= 0 || this.f4634Q.containsKey(comparable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final V put(K k, V v) {
        m5985p();
        int m5977a = m5977a(k);
        if (m5977a >= 0) {
            return (V) this.f4633P.get(m5977a).setValue(v);
        }
        m5985p();
        if (this.f4633P.isEmpty() && !(this.f4633P instanceof ArrayList)) {
            this.f4633P = new ArrayList(this.f4632O);
        }
        int i = -(m5977a + 1);
        if (i >= this.f4632O) {
            return m5986q().put(k, v);
        }
        int size = this.f4633P.size();
        int i2 = this.f4632O;
        if (size == i2) {
            C1730pp remove = this.f4633P.remove(i2 - 1);
            m5986q().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.f4633P.add(i, new C1730pp(this, k, v));
        return null;
    }

    /* renamed from: e */
    public void mo5180e() {
        if (this.f4635R) {
            return;
        }
        this.f4634Q = this.f4634Q.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f4634Q);
        this.f4637T = this.f4637T.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f4637T);
        this.f4635R = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f4636S == null) {
            this.f4636S = new C1829rp(this, null);
        }
        return this.f4636S;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1468kp)) {
            return super.equals(obj);
        }
        C1468kp c1468kp = (C1468kp) obj;
        int size = size();
        if (size != c1468kp.size()) {
            return false;
        }
        int m5981j = m5981j();
        if (m5981j != c1468kp.m5981j()) {
            return entrySet().equals(c1468kp.entrySet());
        }
        for (int i = 0; i < m5981j; i++) {
            if (!m5979h(i).equals(c1468kp.m5979h(i))) {
                return false;
            }
        }
        if (m5981j != size) {
            return this.f4634Q.equals(c1468kp.f4634Q);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int m5977a = m5977a(comparable);
        return m5977a >= 0 ? (V) this.f4633P.get(m5977a).getValue() : this.f4634Q.get(comparable);
    }

    /* renamed from: h */
    public final Map.Entry<K, V> m5979h(int i) {
        return this.f4633P.get(i);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int m5981j = m5981j();
        int i = 0;
        for (int i2 = 0; i2 < m5981j; i2++) {
            i += this.f4633P.get(i2).hashCode();
        }
        return this.f4634Q.size() > 0 ? i + this.f4634Q.hashCode() : i;
    }

    /* renamed from: i */
    public final boolean m5980i() {
        return this.f4635R;
    }

    /* renamed from: j */
    public final int m5981j() {
        return this.f4633P.size();
    }

    /* renamed from: k */
    public final V m5982k(int i) {
        m5985p();
        V v = (V) this.f4633P.remove(i).getValue();
        if (!this.f4634Q.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = m5986q().entrySet().iterator();
            this.f4633P.add(new C1730pp(this, it.next()));
            it.remove();
        }
        return v;
    }

    /* renamed from: m */
    public final Iterable<Map.Entry<K, V>> m5983m() {
        return this.f4634Q.isEmpty() ? C1667op.m7077a() : this.f4634Q.entrySet();
    }

    /* renamed from: o */
    public final Set<Map.Entry<K, V>> m5984o() {
        if (this.f4638U == null) {
            this.f4638U = new C1518lp(this, null);
        }
        return this.f4638U;
    }

    /* renamed from: p */
    public final void m5985p() {
        if (this.f4635R) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: q */
    public final SortedMap<K, V> m5986q() {
        m5985p();
        if (this.f4634Q.isEmpty() && !(this.f4634Q instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f4634Q = treeMap;
            this.f4637T = treeMap.descendingMap();
        }
        return (SortedMap) this.f4634Q;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        m5985p();
        Comparable comparable = (Comparable) obj;
        int m5977a = m5977a(comparable);
        if (m5977a >= 0) {
            return (V) m5982k(m5977a);
        }
        if (this.f4634Q.isEmpty()) {
            return null;
        }
        return this.f4634Q.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f4633P.size() + this.f4634Q.size();
    }
}
