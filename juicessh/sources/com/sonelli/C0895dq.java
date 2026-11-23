package com.sonelli;

import com.google.android.gms.internal.measurement.zzga;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.dq */
/* loaded from: classes.dex */
public final class C0895dq implements Iterator<String> {

    /* renamed from: O */
    public Iterator<String> f2270O;

    /* renamed from: P */
    public final /* synthetic */ C0792bq f2271P;

    public C0895dq(C0792bq c0792bq) {
        zzga zzgaVar;
        this.f2271P = c0792bq;
        zzgaVar = c0792bq.f1781O;
        this.f2270O = zzgaVar.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2270O.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f2270O.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
