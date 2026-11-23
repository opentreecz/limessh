package cz.opentree;

import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzga;
import com.google.android.gms.internal.measurement.zzhf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.oo */
/* loaded from: classes.dex */
public final class C1666oo extends AbstractC1563mo {

    /* renamed from: c */
    public static final Class<?> f5525c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public C1666oo() {
        super();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    public static <L> List<L> m7074e(Object obj, long j, int i) {
        C1467ko c1467ko;
        List<L> m7075f = m7075f(obj, j);
        if (m7075f.isEmpty()) {
            List<L> c1467ko2 = m7075f instanceof zzga ? new C1467ko(i) : ((m7075f instanceof zzhf) && (m7075f instanceof zzfq)) ? ((zzfq) m7075f).mo1237c(i) : new ArrayList<>(i);
            C0841cq.m2926j(obj, j, c1467ko2);
            return c1467ko2;
        }
        if (f5525c.isAssignableFrom(m7075f.getClass())) {
            ArrayList arrayList = new ArrayList(m7075f.size() + i);
            arrayList.addAll(m7075f);
            C0841cq.m2926j(obj, j, arrayList);
            c1467ko = arrayList;
        } else {
            if (!(m7075f instanceof C0792bq)) {
                if (!(m7075f instanceof zzhf) || !(m7075f instanceof zzfq)) {
                    return m7075f;
                }
                zzfq zzfqVar = (zzfq) m7075f;
                if (zzfqVar.mo1236a()) {
                    return m7075f;
                }
                zzfq mo1237c = zzfqVar.mo1237c(m7075f.size() + i);
                C0841cq.m2926j(obj, j, mo1237c);
                return mo1237c;
            }
            C1467ko c1467ko3 = new C1467ko(m7075f.size() + i);
            c1467ko3.addAll((C0792bq) m7075f);
            C0841cq.m2926j(obj, j, c1467ko3);
            c1467ko = c1467ko3;
        }
        return c1467ko;
    }

    /* renamed from: f */
    public static <E> List<E> m7075f(Object obj, long j) {
        return (List) C0841cq.m2907F(obj, j);
    }

    @Override // cz.opentree.AbstractC1563mo
    /* renamed from: b */
    public final <E> void mo6488b(Object obj, Object obj2, long j) {
        List m7075f = m7075f(obj2, j);
        List m7074e = m7074e(obj, j, m7075f.size());
        int size = m7074e.size();
        int size2 = m7075f.size();
        if (size > 0 && size2 > 0) {
            m7074e.addAll(m7075f);
        }
        if (size > 0) {
            m7075f = m7074e;
        }
        C0841cq.m2926j(obj, j, m7075f);
    }

    @Override // cz.opentree.AbstractC1563mo
    /* renamed from: d */
    public final void mo6489d(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) C0841cq.m2907F(obj, j);
        if (list instanceof zzga) {
            unmodifiableList = ((zzga) list).mo1241D();
        } else {
            if (f5525c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzhf) && (list instanceof zzfq)) {
                zzfq zzfqVar = (zzfq) list;
                if (zzfqVar.mo1236a()) {
                    zzfqVar.mo1238l();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        C0841cq.m2926j(obj, j, unmodifiableList);
    }
}
