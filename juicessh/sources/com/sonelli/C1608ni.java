package com.sonelli;

import android.annotation.SuppressLint;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.sonelli.ni */
/* loaded from: classes.dex */
public final class C1608ni extends AbstractC1142i4<C1608ni> {

    /* renamed from: a */
    public Map<Integer, Double> f5290a = new HashMap(4);

    @SuppressLint({"UseSparseArrays"})
    public C1608ni() {
    }

    @Override // com.sonelli.AbstractC1142i4
    /* renamed from: d */
    public final /* synthetic */ void mo4718d(C1608ni c1608ni) {
        c1608ni.f5290a.putAll(this.f5290a);
    }

    /* renamed from: e */
    public final Map<Integer, Double> m6687e() {
        return Collections.unmodifiableMap(this.f5290a);
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Integer, Double> entry : this.f5290a.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 6);
            sb.append("metric");
            sb.append(valueOf);
            hashMap.put(sb.toString(), entry.getValue());
        }
        return AbstractC1142i4.m4715a(hashMap);
    }
}
