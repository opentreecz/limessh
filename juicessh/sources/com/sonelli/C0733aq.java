package com.sonelli;

import com.google.android.gms.internal.measurement.zzga;
import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.aq */
/* loaded from: classes.dex */
public final class C0733aq implements ListIterator<String> {

    /* renamed from: O */
    public ListIterator<String> f1506O;

    /* renamed from: P */
    public final /* synthetic */ int f1507P;

    /* renamed from: Q */
    public final /* synthetic */ C0792bq f1508Q;

    public C0733aq(C0792bq c0792bq, int i) {
        zzga zzgaVar;
        this.f1508Q = c0792bq;
        this.f1507P = i;
        zzgaVar = c0792bq.f1781O;
        this.f1506O = zzgaVar.listIterator(i);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f1506O.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f1506O.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f1506O.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f1506O.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.f1506O.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f1506O.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }
}
