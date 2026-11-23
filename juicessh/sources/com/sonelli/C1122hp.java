package com.sonelli;

import com.google.android.gms.internal.measurement.zzfq;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.hp */
/* loaded from: classes.dex */
public final class C1122hp<E> extends AbstractC1612nm<E> implements RandomAccess {

    /* renamed from: R */
    public static final C1122hp<Object> f3210R;

    /* renamed from: P */
    public E[] f3211P;

    /* renamed from: Q */
    public int f3212Q;

    static {
        C1122hp<Object> c1122hp = new C1122hp<>(new Object[0], 0);
        f3210R = c1122hp;
        c1122hp.mo1238l();
    }

    public C1122hp(E[] eArr, int i) {
        this.f3211P = eArr;
        this.f3212Q = i;
    }

    /* renamed from: h */
    public static <E> C1122hp<E> m4608h() {
        return (C1122hp<E>) f3210R;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, E e) {
        int i2;
        m6739e();
        if (i < 0 || i > (i2 = this.f3212Q)) {
            throw new IndexOutOfBoundsException(m4610g(i));
        }
        E[] eArr = this.f3211P;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = (E[]) new Object[((i2 * 3) / 2) + 1];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.f3211P, i, eArr2, i + 1, this.f3212Q - i);
            this.f3211P = eArr2;
        }
        this.f3211P[i] = e;
        this.f3212Q++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.sonelli.AbstractC1612nm, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e) {
        m6739e();
        int i = this.f3212Q;
        E[] eArr = this.f3211P;
        if (i == eArr.length) {
            this.f3211P = (E[]) Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.f3211P;
        int i2 = this.f3212Q;
        this.f3212Q = i2 + 1;
        eArr2[i2] = e;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzfq
    /* renamed from: c */
    public final /* synthetic */ zzfq mo1237c(int i) {
        if (i >= this.f3212Q) {
            return new C1122hp(Arrays.copyOf(this.f3211P, i), this.f3212Q);
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: f */
    public final void m4609f(int i) {
        if (i < 0 || i >= this.f3212Q) {
            throw new IndexOutOfBoundsException(m4610g(i));
        }
    }

    /* renamed from: g */
    public final String m4610g(int i) {
        int i2 = this.f3212Q;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        m4609f(i);
        return this.f3211P[i];
    }

    @Override // java.util.AbstractList, java.util.List
    public final E remove(int i) {
        m6739e();
        m4609f(i);
        E[] eArr = this.f3211P;
        E e = eArr[i];
        if (i < this.f3212Q - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (r2 - i) - 1);
        }
        this.f3212Q--;
        ((AbstractList) this).modCount++;
        return e;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int i, E e) {
        m6739e();
        m4609f(i);
        E[] eArr = this.f3211P;
        E e2 = eArr[i];
        eArr[i] = e;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3212Q;
    }
}
