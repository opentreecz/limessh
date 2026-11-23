package cz.opentree;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import cz.opentree.C1558mk;
import cz.opentree.C2016uk;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class q40 {

    /* renamed from: a */
    public String f5932a;

    /* renamed from: b */
    public boolean f5933b;

    /* renamed from: c */
    public C1937tk f5934c;

    /* renamed from: d */
    public BitSet f5935d;

    /* renamed from: e */
    public BitSet f5936e;

    /* renamed from: f */
    public Map<Integer, Long> f5937f;

    /* renamed from: g */
    public Map<Integer, List<Long>> f5938g;

    /* renamed from: h */
    public final /* synthetic */ o40 f5939h;

    public q40(o40 o40Var, String str) {
        this.f5939h = o40Var;
        this.f5932a = str;
        this.f5933b = true;
        this.f5935d = new BitSet();
        this.f5936e = new BitSet();
        this.f5937f = new ArrayMap();
        this.f5938g = new ArrayMap();
    }

    public /* synthetic */ q40(o40 o40Var, String str, n40 n40Var) {
        this(o40Var, str);
    }

    public q40(o40 o40Var, String str, C1937tk c1937tk, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.f5939h = o40Var;
        this.f5932a = str;
        this.f5935d = bitSet;
        this.f5936e = bitSet2;
        this.f5937f = map;
        this.f5938g = new ArrayMap();
        if (map2 != null) {
            for (Integer num : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(num));
                this.f5938g.put(num, arrayList);
            }
        }
        this.f5933b = false;
        this.f5934c = c1937tk;
    }

    public /* synthetic */ q40(o40 o40Var, String str, C1937tk c1937tk, BitSet bitSet, BitSet bitSet2, Map map, Map map2, n40 n40Var) {
        this(o40Var, str, c1937tk, bitSet, bitSet2, map, map2);
    }

    /* renamed from: b */
    public static /* synthetic */ BitSet m7621b(q40 q40Var) {
        return q40Var.f5935d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [cz.opentree.xn$b, cz.opentree.lk$a] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r8v3, types: [cz.opentree.tk$a] */
    @NonNull
    /* renamed from: a */
    public final C1512lk m7622a(int i) {
        ArrayList arrayList;
        ?? arrayList2;
        ?? m6232T = C1512lk.m6232T();
        m6232T.m6245v(i);
        m6232T.m6248z(this.f5933b);
        C1937tk c1937tk = this.f5934c;
        if (c1937tk != null) {
            m6232T.m6247y(c1937tk);
        }
        ?? m8715c0 = C1937tk.m8715c0();
        m8715c0.m8739B(d40.m3122F(this.f5935d));
        m8715c0.m8744y(d40.m3122F(this.f5936e));
        if (this.f5937f == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.f5937f.size());
            Iterator<Integer> it = this.f5937f.keySet().iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                C1558mk.a m6434M = C1558mk.m6434M();
                m6434M.m6442v(intValue);
                m6434M.m6443w(this.f5937f.get(Integer.valueOf(intValue)).longValue());
                arrayList.add((C1558mk) ((AbstractC2303xn) m6434M.mo1259f()));
            }
        }
        m8715c0.m8740C(arrayList);
        if (this.f5938g == null) {
            arrayList2 = Collections.emptyList();
        } else {
            arrayList2 = new ArrayList(this.f5938g.size());
            for (Integer num : this.f5938g.keySet()) {
                C2016uk.a m8905N = C2016uk.m8905N();
                m8905N.m8914v(num.intValue());
                List<Long> list = this.f5938g.get(num);
                if (list != null) {
                    Collections.sort(list);
                    m8905N.m8915w(list);
                }
                arrayList2.add((C2016uk) ((AbstractC2303xn) m8905N.mo1259f()));
            }
        }
        m8715c0.m8741D(arrayList2);
        m6232T.m6246w(m8715c0);
        return (C1512lk) ((AbstractC2303xn) m6232T.mo1259f());
    }

    /* renamed from: c */
    public final void m7623c(@NonNull r40 r40Var) {
        int mo7869a = r40Var.mo7869a();
        Boolean bool = r40Var.f6173c;
        if (bool != null) {
            this.f5936e.set(mo7869a, bool.booleanValue());
        }
        Boolean bool2 = r40Var.f6174d;
        if (bool2 != null) {
            this.f5935d.set(mo7869a, bool2.booleanValue());
        }
        if (r40Var.f6175e != null) {
            Long l = this.f5937f.get(Integer.valueOf(mo7869a));
            long longValue = r40Var.f6175e.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.f5937f.put(Integer.valueOf(mo7869a), Long.valueOf(longValue));
            }
        }
        if (r40Var.f6176f != null) {
            List<Long> list = this.f5938g.get(Integer.valueOf(mo7869a));
            if (list == null) {
                list = new ArrayList<>();
                this.f5938g.put(Integer.valueOf(mo7869a), list);
            }
            if (r40Var.mo7870i()) {
                list.clear();
            }
            if (C1669or.m7080b() && this.f5939h.m7590o().m2607A(this.f5932a, C1735pu.f5840i0) && r40Var.mo7871j()) {
                list.clear();
            }
            if (!C1669or.m7080b() || !this.f5939h.m7590o().m2607A(this.f5932a, C1735pu.f5840i0)) {
                list.add(Long.valueOf(r40Var.f6176f.longValue() / 1000));
                return;
            }
            long longValue2 = r40Var.f6176f.longValue() / 1000;
            if (list.contains(Long.valueOf(longValue2))) {
                return;
            }
            list.add(Long.valueOf(longValue2));
        }
    }
}
