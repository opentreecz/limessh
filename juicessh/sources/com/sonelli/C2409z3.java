package com.sonelli;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.sonelli.z3 */
/* loaded from: classes.dex */
public class C2409z3 {

    /* renamed from: a */
    public Map<String, String> f8425a = new HashMap();

    /* renamed from: a */
    public final Map<String, String> m10329a(String str) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : this.f8425a.entrySet()) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf(entry.getKey());
            hashMap.put(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), entry.getValue());
        }
        return hashMap;
    }

    public String toString() {
        return AbstractC1142i4.m4717c(this.f8425a);
    }
}
