package cz.opentree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: cz.opentree.qi */
/* loaded from: classes.dex */
public final class C1764qi extends AbstractC1142i4<C1764qi> {

    /* renamed from: a */
    public final List<C2409z3> f6002a = new ArrayList();

    /* renamed from: b */
    public final List<C0752b4> f6003b = new ArrayList();

    /* renamed from: c */
    public final Map<String, List<C2409z3>> f6004c = new HashMap();

    /* renamed from: d */
    public C0694a4 f6005d;

    @Override // cz.opentree.AbstractC1142i4
    /* renamed from: d */
    public final /* synthetic */ void mo4718d(C1764qi c1764qi) {
        C1764qi c1764qi2 = c1764qi;
        c1764qi2.f6002a.addAll(this.f6002a);
        c1764qi2.f6003b.addAll(this.f6003b);
        for (Map.Entry<String, List<C2409z3>> entry : this.f6004c.entrySet()) {
            String key = entry.getKey();
            for (C2409z3 c2409z3 : entry.getValue()) {
                if (c2409z3 != null) {
                    String str = key == null ? "" : key;
                    if (!c1764qi2.f6004c.containsKey(str)) {
                        c1764qi2.f6004c.put(str, new ArrayList());
                    }
                    c1764qi2.f6004c.get(str).add(c2409z3);
                }
            }
        }
        C0694a4 c0694a4 = this.f6005d;
        if (c0694a4 != null) {
            c1764qi2.f6005d = c0694a4;
        }
    }

    /* renamed from: e */
    public final C0694a4 m7712e() {
        return this.f6005d;
    }

    /* renamed from: f */
    public final List<C2409z3> m7713f() {
        return Collections.unmodifiableList(this.f6002a);
    }

    /* renamed from: g */
    public final Map<String, List<C2409z3>> m7714g() {
        return this.f6004c;
    }

    /* renamed from: h */
    public final List<C0752b4> m7715h() {
        return Collections.unmodifiableList(this.f6003b);
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        if (!this.f6002a.isEmpty()) {
            hashMap.put("products", this.f6002a);
        }
        if (!this.f6003b.isEmpty()) {
            hashMap.put("promotions", this.f6003b);
        }
        if (!this.f6004c.isEmpty()) {
            hashMap.put("impressions", this.f6004c);
        }
        hashMap.put("productAction", this.f6005d);
        return AbstractC1142i4.m4715a(hashMap);
    }
}
