package cz.opentree;

import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class o40 extends w30 {

    /* renamed from: d */
    public String f5429d;

    /* renamed from: e */
    public Set<Integer> f5430e;

    /* renamed from: f */
    public Map<Integer, q40> f5431f;

    /* renamed from: g */
    public Long f5432g;

    /* renamed from: h */
    public Long f5433h;

    public o40(z30 z30Var) {
        super(z30Var);
    }

    @Override // cz.opentree.w30
    /* renamed from: v */
    public final boolean mo2315v() {
        return false;
    }

    /* renamed from: w */
    public final q40 m6867w(int i) {
        if (this.f5431f.containsKey(Integer.valueOf(i))) {
            return this.f5431f.get(Integer.valueOf(i));
        }
        q40 q40Var = new q40(this, this.f5429d, null);
        this.f5431f.put(Integer.valueOf(i), q40Var);
        return q40Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02bb A[SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /* renamed from: x */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<cz.opentree.C1512lk> m6868x(java.lang.String r47, java.util.List<cz.opentree.C1610nk> r48, java.util.List<cz.opentree.C2175vk> r49, java.lang.Long r50, java.lang.Long r51) {
        /*
            Method dump skipped, instructions count: 1743
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.o40.m6868x(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    /* renamed from: y */
    public final boolean m6869y(int i, int i2) {
        if (this.f5431f.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return q40.m7621b(this.f5431f.get(Integer.valueOf(i))).get(i2);
    }
}
