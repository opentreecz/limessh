package com.sonelli;

import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzga;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.ko */
/* loaded from: classes.dex */
public final class C1467ko extends AbstractC1612nm<String> implements zzga, RandomAccess {

    /* renamed from: Q */
    public static final C1467ko f4628Q;

    /* renamed from: P */
    public final List<Object> f4629P;

    static {
        C1467ko c1467ko = new C1467ko();
        f4628Q = c1467ko;
        c1467ko.mo1238l();
    }

    public C1467ko() {
        this(10);
    }

    public C1467ko(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    public C1467ko(ArrayList<Object> arrayList) {
        this.f4629P = arrayList;
    }

    /* renamed from: f */
    public static String m5960f(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof AbstractC1939tm ? ((AbstractC1939tm) obj).m8767q() : C2435zn.m10543i((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzga
    /* renamed from: D */
    public final zzga mo1241D() {
        return mo1236a() ? new C0792bq(this) : this;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        m6739e();
        this.f4629P.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.sonelli.AbstractC1612nm, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        m6739e();
        if (collection instanceof zzga) {
            collection = ((zzga) collection).mo1242b();
        }
        boolean addAll = this.f4629P.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.sonelli.AbstractC1612nm, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.measurement.zzga
    /* renamed from: b */
    public final List<?> mo1242b() {
        return Collections.unmodifiableList(this.f4629P);
    }

    @Override // com.google.android.gms.internal.measurement.zzfq
    /* renamed from: c */
    public final /* synthetic */ zzfq mo1237c(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.f4629P);
        return new C1467ko((ArrayList<Object>) arrayList);
    }

    @Override // com.sonelli.AbstractC1612nm, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        m6739e();
        this.f4629P.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzga
    /* renamed from: d */
    public final Object mo1243d(int i) {
        return this.f4629P.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.f4629P.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof AbstractC1939tm) {
            AbstractC1939tm abstractC1939tm = (AbstractC1939tm) obj;
            String m8767q = abstractC1939tm.m8767q();
            if (abstractC1939tm.mo2156s()) {
                this.f4629P.set(i, m8767q);
            }
            return m8767q;
        }
        byte[] bArr = (byte[]) obj;
        String m10543i = C2435zn.m10543i(bArr);
        if (C2435zn.m10542h(bArr)) {
            this.f4629P.set(i, m10543i);
        }
        return m10543i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        m6739e();
        Object remove = this.f4629P.remove(i);
        ((AbstractList) this).modCount++;
        return m5960f(remove);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        m6739e();
        return m5960f(this.f4629P.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f4629P.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzga
    /* renamed from: y */
    public final void mo1244y(AbstractC1939tm abstractC1939tm) {
        m6739e();
        this.f4629P.add(abstractC1939tm);
        ((AbstractList) this).modCount++;
    }
}
