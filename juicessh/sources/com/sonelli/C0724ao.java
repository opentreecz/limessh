package com.sonelli;

import androidx.appcompat.widget.ActivityChooserView;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzhf;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.ao */
/* loaded from: classes.dex */
public final class C0724ao extends AbstractC1612nm<Integer> implements zzfo, zzhf, RandomAccess {

    /* renamed from: R */
    public static final C0724ao f1457R;

    /* renamed from: P */
    public int[] f1458P;

    /* renamed from: Q */
    public int f1459Q;

    static {
        C0724ao c0724ao = new C0724ao(new int[0], 0);
        f1457R = c0724ao;
        c0724ao.mo1238l();
    }

    public C0724ao() {
        this(new int[10], 0);
    }

    public C0724ao(int[] iArr, int i) {
        this.f1458P = iArr;
        this.f1459Q = i;
    }

    /* renamed from: g */
    public static C0724ao m2166g() {
        return f1457R;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        int intValue = ((Integer) obj).intValue();
        m6739e();
        if (i < 0 || i > (i2 = this.f1459Q)) {
            throw new IndexOutOfBoundsException(m2170j(i));
        }
        int[] iArr = this.f1458P;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.f1458P, i, iArr2, i + 1, this.f1459Q - i);
            this.f1458P = iArr2;
        }
        this.f1458P[i] = intValue;
        this.f1459Q++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.sonelli.AbstractC1612nm, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        m2168h(((Integer) obj).intValue());
        return true;
    }

    @Override // com.sonelli.AbstractC1612nm, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        m6739e();
        C2435zn.m10538d(collection);
        if (!(collection instanceof C0724ao)) {
            return super.addAll(collection);
        }
        C0724ao c0724ao = (C0724ao) collection;
        int i = c0724ao.f1459Q;
        if (i == 0) {
            return false;
        }
        int i2 = this.f1459Q;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        int[] iArr = this.f1458P;
        if (i3 > iArr.length) {
            this.f1458P = Arrays.copyOf(iArr, i3);
        }
        System.arraycopy(c0724ao.f1458P, 0, this.f1458P, this.f1459Q, c0724ao.f1459Q);
        this.f1459Q = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzfq
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final zzfo mo1237c(int i) {
        if (i >= this.f1459Q) {
            return new C0724ao(Arrays.copyOf(this.f1458P, i), this.f1459Q);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.sonelli.AbstractC1612nm, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0724ao)) {
            return super.equals(obj);
        }
        C0724ao c0724ao = (C0724ao) obj;
        if (this.f1459Q != c0724ao.f1459Q) {
            return false;
        }
        int[] iArr = c0724ao.f1458P;
        for (int i = 0; i < this.f1459Q; i++) {
            if (this.f1458P[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public final int m2167f(int i) {
        m2169i(i);
        return this.f1458P[i];
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(m2167f(i));
    }

    /* renamed from: h */
    public final void m2168h(int i) {
        m6739e();
        int i2 = this.f1459Q;
        int[] iArr = this.f1458P;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.f1458P = iArr2;
        }
        int[] iArr3 = this.f1458P;
        int i3 = this.f1459Q;
        this.f1459Q = i3 + 1;
        iArr3[i3] = i;
    }

    @Override // com.sonelli.AbstractC1612nm, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f1459Q; i2++) {
            i = (i * 31) + this.f1458P[i2];
        }
        return i;
    }

    /* renamed from: i */
    public final void m2169i(int i) {
        if (i < 0 || i >= this.f1459Q) {
            throw new IndexOutOfBoundsException(m2170j(i));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f1458P[i] == intValue) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: j */
    public final String m2170j(int i) {
        int i2 = this.f1459Q;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        m6739e();
        m2169i(i);
        int[] iArr = this.f1458P;
        int i2 = iArr[i];
        if (i < this.f1459Q - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (r2 - i) - 1);
        }
        this.f1459Q--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // com.sonelli.AbstractC1612nm, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        m6739e();
        for (int i = 0; i < this.f1459Q; i++) {
            if (obj.equals(Integer.valueOf(this.f1458P[i]))) {
                int[] iArr = this.f1458P;
                System.arraycopy(iArr, i + 1, iArr, i, (this.f1459Q - i) - 1);
                this.f1459Q--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        m6739e();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f1458P;
        System.arraycopy(iArr, i2, iArr, i, this.f1459Q - i2);
        this.f1459Q -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        m6739e();
        m2169i(i);
        int[] iArr = this.f1458P;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1459Q;
    }
}
