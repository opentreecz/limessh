package cz.opentree;

import android.text.TextUtils;
import cz.opentree.C2199w3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: cz.opentree.w3 */
/* loaded from: classes.dex */
public class C2199w3<T extends C2199w3> {

    /* renamed from: b */
    public C0694a4 f7614b;

    /* renamed from: a */
    public Map<String, String> f7613a = new HashMap();

    /* renamed from: c */
    public Map<String, List<C2409z3>> f7615c = new HashMap();

    /* renamed from: d */
    public List<C0752b4> f7616d = new ArrayList();

    /* renamed from: e */
    public List<C2409z3> f7617e = new ArrayList();

    /* renamed from: a */
    public Map<String, String> m9401a() {
        HashMap hashMap = new HashMap(this.f7613a);
        C0694a4 c0694a4 = this.f7614b;
        if (c0694a4 != null) {
            c0694a4.m1978a();
            throw null;
        }
        Iterator<C0752b4> it = this.f7616d.iterator();
        int i = 1;
        while (it.hasNext()) {
            hashMap.putAll(it.next().m2371a(C0910e4.m3423f(i)));
            i++;
        }
        Iterator<C2409z3> it2 = this.f7617e.iterator();
        int i2 = 1;
        while (it2.hasNext()) {
            hashMap.putAll(it2.next().m10329a(C0910e4.m3421d(i2)));
            i2++;
        }
        int i3 = 1;
        for (Map.Entry<String, List<C2409z3>> entry : this.f7615c.entrySet()) {
            List<C2409z3> value = entry.getValue();
            String m3426i = C0910e4.m3426i(i3);
            int i4 = 1;
            for (C2409z3 c2409z3 : value) {
                String valueOf = String.valueOf(m3426i);
                String valueOf2 = String.valueOf(C0910e4.m3425h(i4));
                hashMap.putAll(c2409z3.m10329a(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
                i4++;
            }
            if (!TextUtils.isEmpty(entry.getKey())) {
                String valueOf3 = String.valueOf(m3426i);
                hashMap.put("nm".length() != 0 ? valueOf3.concat("nm") : new String(valueOf3), entry.getKey());
            }
            i3++;
        }
        return hashMap;
    }

    /* renamed from: b */
    public final T m9402b(String str, String str2) {
        if (str != null) {
            this.f7613a.put(str, str2);
        } else {
            C1212jh.m5112c("HitBuilder.set() called with a null paramName.");
        }
        return this;
    }
}
