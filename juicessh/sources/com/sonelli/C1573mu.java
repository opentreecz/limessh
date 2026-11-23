package com.sonelli;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.zzal;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.mu */
/* loaded from: classes.dex */
public final class C1573mu implements Iterator<String> {

    /* renamed from: O */
    public Iterator<String> f5146O;

    /* renamed from: P */
    public final /* synthetic */ zzal f5147P;

    public C1573mu(zzal zzalVar) {
        Bundle bundle;
        this.f5147P = zzalVar;
        bundle = zzalVar.f985O;
        this.f5146O = bundle.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5146O.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f5146O.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
