package com.sonelli;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.lp */
/* loaded from: classes.dex */
public final class C1518lp extends C1829rp {

    /* renamed from: P */
    public final /* synthetic */ C1468kp f4899P;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1518lp(C1468kp c1468kp) {
        super(c1468kp, null);
        this.f4899P = c1468kp;
    }

    public /* synthetic */ C1518lp(C1468kp c1468kp, C1231jp c1231jp) {
        this(c1468kp);
    }

    @Override // com.sonelli.C1829rp, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new C1567mp(this.f4899P, null);
    }
}
