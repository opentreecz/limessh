package com.sonelli;

import com.google.android.gms.internal.measurement.zzfn;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.vo */
/* loaded from: classes.dex */
public final class C2181vo<K, V> extends LinkedHashMap<K, V> {

    /* renamed from: P */
    public static final C2181vo f7541P;

    /* renamed from: O */
    public boolean f7542O;

    static {
        C2181vo c2181vo = new C2181vo();
        f7541P = c2181vo;
        c2181vo.f7542O = false;
    }

    public C2181vo() {
        this.f7542O = true;
    }

    public C2181vo(Map<K, V> map) {
        super(map);
        this.f7542O = true;
    }

    /* renamed from: b */
    public static int m9327b(Object obj) {
        if (obj instanceof byte[]) {
            return C2435zn.m10544j((byte[]) obj);
        }
        if (obj instanceof zzfn) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    /* renamed from: c */
    public static <K, V> C2181vo<K, V> m9328c() {
        return f7541P;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        m9333k();
        super.clear();
    }

    /* renamed from: d */
    public final void m9329d(C2181vo<K, V> c2181vo) {
        m9333k();
        if (c2181vo.isEmpty()) {
            return;
        }
        putAll(c2181vo);
    }

    /* renamed from: e */
    public final C2181vo<K, V> m9330e() {
        return isEmpty() ? new C2181vo<>() : new C2181vo<>(this);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x005c A[RETURN] */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof java.util.Map
            r1 = 0
            if (r0 == 0) goto L5d
            java.util.Map r7 = (java.util.Map) r7
            r0 = 1
            if (r6 == r7) goto L59
            int r2 = r6.size()
            int r3 = r7.size()
            if (r2 == r3) goto L16
        L14:
            r7 = r1
            goto L5a
        L16:
            java.util.Set r2 = r6.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L1e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L59
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            boolean r4 = r7.containsKey(r4)
            if (r4 != 0) goto L35
            goto L14
        L35:
            java.lang.Object r4 = r3.getValue()
            java.lang.Object r3 = r3.getKey()
            java.lang.Object r3 = r7.get(r3)
            boolean r5 = r4 instanceof byte[]
            if (r5 == 0) goto L52
            boolean r5 = r3 instanceof byte[]
            if (r5 == 0) goto L52
            byte[] r4 = (byte[]) r4
            byte[] r3 = (byte[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L56
        L52:
            boolean r3 = r4.equals(r3)
        L56:
            if (r3 != 0) goto L1e
            goto L14
        L59:
            r7 = r0
        L5a:
            if (r7 == 0) goto L5d
            return r0
        L5d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.C2181vo.equals(java.lang.Object):boolean");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            i += m9327b(entry.getValue()) ^ m9327b(entry.getKey());
        }
        return i;
    }

    /* renamed from: i */
    public final void m9331i() {
        this.f7542O = false;
    }

    /* renamed from: j */
    public final boolean m9332j() {
        return this.f7542O;
    }

    /* renamed from: k */
    public final void m9333k() {
        if (!this.f7542O) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        m9333k();
        C2435zn.m10538d(k);
        C2435zn.m10538d(v);
        return (V) super.put(k, v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        m9333k();
        for (K k : map.keySet()) {
            C2435zn.m10538d(k);
            C2435zn.m10538d(map.get(k));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        m9333k();
        return (V) super.remove(obj);
    }
}
