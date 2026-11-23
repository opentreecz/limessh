package com.sonelli;

import com.google.android.gms.internal.measurement.zzgt;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.fo */
/* loaded from: classes.dex */
public final class C1005fo<K> implements Map.Entry<K, Object> {

    /* renamed from: O */
    public Map.Entry<K, C0891do> f2741O;

    public C1005fo(Map.Entry<K, C0891do> entry) {
        this.f2741O = entry;
    }

    /* renamed from: a */
    public final C0891do m3847a() {
        return this.f2741O.getValue();
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.f2741O.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.f2741O.getValue() == null) {
            return null;
        }
        C0891do.m3276e();
        throw null;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzgt) {
            return this.f2741O.getValue().m4579a((zzgt) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
