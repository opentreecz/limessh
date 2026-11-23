package com.sonelli;

import com.google.android.gms.internal.measurement.zzfq;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.no */
/* loaded from: classes.dex */
public final class C1614no extends AbstractC1563mo {
    public C1614no() {
        super();
    }

    /* renamed from: e */
    public static <E> zzfq<E> m6757e(Object obj, long j) {
        return (zzfq) C0841cq.m2907F(obj, j);
    }

    @Override // com.sonelli.AbstractC1563mo
    /* renamed from: b */
    public final <E> void mo6488b(Object obj, Object obj2, long j) {
        zzfq m6757e = m6757e(obj, j);
        zzfq m6757e2 = m6757e(obj2, j);
        int size = m6757e.size();
        int size2 = m6757e2.size();
        if (size > 0 && size2 > 0) {
            if (!m6757e.mo1236a()) {
                m6757e = m6757e.mo1237c(size2 + size);
            }
            m6757e.addAll(m6757e2);
        }
        if (size > 0) {
            m6757e2 = m6757e;
        }
        C0841cq.m2926j(obj, j, m6757e2);
    }

    @Override // com.sonelli.AbstractC1563mo
    /* renamed from: d */
    public final void mo6489d(Object obj, long j) {
        m6757e(obj, j).mo1238l();
    }
}
