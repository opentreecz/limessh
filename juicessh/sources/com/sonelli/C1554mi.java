package com.sonelli;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.sonelli.mi */
/* loaded from: classes.dex */
public final class C1554mi extends AbstractC1142i4<C1554mi> {

    /* renamed from: a */
    public Map<Integer, String> f5047a = new HashMap(4);

    @Override // com.sonelli.AbstractC1142i4
    /* renamed from: d */
    public final /* synthetic */ void mo4718d(C1554mi c1554mi) {
        c1554mi.f5047a.putAll(this.f5047a);
    }

    /* renamed from: e */
    public final Map<Integer, String> m6424e() {
        return Collections.unmodifiableMap(this.f5047a);
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Integer, String> entry : this.f5047a.entrySet()) {
            String valueOf = String.valueOf(entry.getKey());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 9);
            sb.append("dimension");
            sb.append(valueOf);
            hashMap.put(sb.toString(), entry.getValue());
        }
        return AbstractC1142i4.m4715a(hashMap);
    }
}
