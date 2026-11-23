package com.sonelli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public class a80 {

    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    /* renamed from: com.sonelli.a80$b */
    /* loaded from: classes.dex */
    public static class C0700b {

        /* renamed from: a */
        public final v70<?> f1343a;

        /* renamed from: b */
        public final Set<C0700b> f1344b = new HashSet();

        /* renamed from: c */
        public final Set<C0700b> f1345c = new HashSet();

        public C0700b(v70<?> v70Var) {
            this.f1343a = v70Var;
        }

        /* renamed from: a */
        public void m1993a(C0700b c0700b) {
            this.f1344b.add(c0700b);
        }

        /* renamed from: b */
        public void m1994b(C0700b c0700b) {
            this.f1345c.add(c0700b);
        }

        /* renamed from: c */
        public v70<?> m1995c() {
            return this.f1343a;
        }

        /* renamed from: d */
        public Set<C0700b> m1996d() {
            return this.f1344b;
        }

        /* renamed from: e */
        public boolean m1997e() {
            return this.f1344b.isEmpty();
        }

        /* renamed from: f */
        public boolean m1998f() {
            return this.f1345c.isEmpty();
        }

        /* renamed from: g */
        public void m1999g(C0700b c0700b) {
            this.f1345c.remove(c0700b);
        }
    }

    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    /* renamed from: com.sonelli.a80$c */
    /* loaded from: classes.dex */
    public static class C0701c {

        /* renamed from: a */
        public final Class<?> f1346a;

        /* renamed from: b */
        public final boolean f1347b;

        public C0701c(Class<?> cls, boolean z) {
            this.f1346a = cls;
            this.f1347b = z;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0701c)) {
                return false;
            }
            C0701c c0701c = (C0701c) obj;
            return c0701c.f1346a.equals(this.f1346a) && c0701c.f1347b == this.f1347b;
        }

        public int hashCode() {
            return ((this.f1346a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f1347b).hashCode();
        }
    }

    /* renamed from: a */
    public static void m1990a(List<v70<?>> list) {
        Set<C0700b> m1992c = m1992c(list);
        Set<C0700b> m1991b = m1991b(m1992c);
        int i = 0;
        while (!m1991b.isEmpty()) {
            C0700b next = m1991b.iterator().next();
            m1991b.remove(next);
            i++;
            for (C0700b c0700b : next.m1996d()) {
                c0700b.m1999g(next);
                if (c0700b.m1998f()) {
                    m1991b.add(c0700b);
                }
            }
        }
        if (i == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (C0700b c0700b2 : m1992c) {
            if (!c0700b2.m1998f() && !c0700b2.m1997e()) {
                arrayList.add(c0700b2.m1995c());
            }
        }
        throw new c80(arrayList);
    }

    /* renamed from: b */
    public static Set<C0700b> m1991b(Set<C0700b> set) {
        HashSet hashSet = new HashSet();
        for (C0700b c0700b : set) {
            if (c0700b.m1998f()) {
                hashSet.add(c0700b);
            }
        }
        return hashSet;
    }

    /* renamed from: c */
    public static Set<C0700b> m1992c(List<v70<?>> list) {
        Set<C0700b> set;
        HashMap hashMap = new HashMap(list.size());
        Iterator<v70<?>> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                Iterator it2 = hashMap.values().iterator();
                while (it2.hasNext()) {
                    for (C0700b c0700b : (Set) it2.next()) {
                        for (b80 b80Var : c0700b.m1995c().m9179c()) {
                            if (b80Var.m2398b() && (set = (Set) hashMap.get(new C0701c(b80Var.m2397a(), b80Var.m2400d()))) != null) {
                                for (C0700b c0700b2 : set) {
                                    c0700b.m1993a(c0700b2);
                                    c0700b2.m1994b(c0700b);
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it3 = hashMap.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                return hashSet;
            }
            v70<?> next = it.next();
            C0700b c0700b3 = new C0700b(next);
            for (Class<? super Object> cls : next.m9181e()) {
                C0701c c0701c = new C0701c(cls, !next.m9185k());
                if (!hashMap.containsKey(c0701c)) {
                    hashMap.put(c0701c, new HashSet());
                }
                Set set2 = (Set) hashMap.get(c0701c);
                if (!set2.isEmpty() && !c0701c.f1347b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", cls));
                }
                set2.add(c0700b3);
            }
        }
    }
}
