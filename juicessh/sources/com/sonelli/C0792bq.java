package com.sonelli;

import com.google.android.gms.internal.measurement.zzga;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.bq */
/* loaded from: classes.dex */
public final class C0792bq extends AbstractList<String> implements zzga, RandomAccess {

    /* renamed from: O */
    public final zzga f1781O;

    public C0792bq(zzga zzgaVar) {
        this.f1781O = zzgaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzga
    /* renamed from: D */
    public final zzga mo1241D() {
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzga
    /* renamed from: b */
    public final List<?> mo1242b() {
        return this.f1781O.mo1242b();
    }

    @Override // com.google.android.gms.internal.measurement.zzga
    /* renamed from: d */
    public final Object mo1243d(int i) {
        return this.f1781O.mo1243d(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.f1781O.get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new C0895dq(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new C0733aq(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1781O.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzga
    /* renamed from: y */
    public final void mo1244y(AbstractC1939tm abstractC1939tm) {
        throw new UnsupportedOperationException();
    }
}
