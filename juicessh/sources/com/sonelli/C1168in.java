package com.sonelli;

import androidx.appcompat.widget.ActivityChooserView;
import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzhf;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.in */
/* loaded from: classes.dex */
public final class C1168in extends AbstractC1612nm<Double> implements zzfq<Double>, zzhf, RandomAccess {

    /* renamed from: P */
    public double[] f3363P;

    /* renamed from: Q */
    public int f3364Q;

    static {
        new C1168in(new double[0], 0).mo1238l();
    }

    public C1168in() {
        this(new double[10], 0);
    }

    public C1168in(double[] dArr, int i) {
        this.f3363P = dArr;
        this.f3364Q = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        double doubleValue = ((Double) obj).doubleValue();
        m6739e();
        if (i < 0 || i > (i2 = this.f3364Q)) {
            throw new IndexOutOfBoundsException(m4813h(i));
        }
        double[] dArr = this.f3363P;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.f3363P, i, dArr2, i + 1, this.f3364Q - i);
            this.f3363P = dArr2;
        }
        this.f3363P[i] = doubleValue;
        this.f3364Q++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.sonelli.AbstractC1612nm, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        m4811f(((Double) obj).doubleValue());
        return true;
    }

    @Override // com.sonelli.AbstractC1612nm, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        m6739e();
        C2435zn.m10538d(collection);
        if (!(collection instanceof C1168in)) {
            return super.addAll(collection);
        }
        C1168in c1168in = (C1168in) collection;
        int i = c1168in.f3364Q;
        if (i == 0) {
            return false;
        }
        int i2 = this.f3364Q;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        double[] dArr = this.f3363P;
        if (i3 > dArr.length) {
            this.f3363P = Arrays.copyOf(dArr, i3);
        }
        System.arraycopy(c1168in.f3363P, 0, this.f3363P, this.f3364Q, c1168in.f3364Q);
        this.f3364Q = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzfq
    /* renamed from: c */
    public final /* synthetic */ zzfq<Double> mo1237c(int i) {
        if (i >= this.f3364Q) {
            return new C1168in(Arrays.copyOf(this.f3363P, i), this.f3364Q);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.sonelli.AbstractC1612nm, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1168in)) {
            return super.equals(obj);
        }
        C1168in c1168in = (C1168in) obj;
        if (this.f3364Q != c1168in.f3364Q) {
            return false;
        }
        double[] dArr = c1168in.f3363P;
        for (int i = 0; i < this.f3364Q; i++) {
            if (Double.doubleToLongBits(this.f3363P[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public final void m4811f(double d) {
        m6739e();
        int i = this.f3364Q;
        double[] dArr = this.f3363P;
        if (i == dArr.length) {
            double[] dArr2 = new double[((i * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.f3363P = dArr2;
        }
        double[] dArr3 = this.f3363P;
        int i2 = this.f3364Q;
        this.f3364Q = i2 + 1;
        dArr3[i2] = d;
    }

    /* renamed from: g */
    public final void m4812g(int i) {
        if (i < 0 || i >= this.f3364Q) {
            throw new IndexOutOfBoundsException(m4813h(i));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        m4812g(i);
        return Double.valueOf(this.f3363P[i]);
    }

    /* renamed from: h */
    public final String m4813h(int i) {
        int i2 = this.f3364Q;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // com.sonelli.AbstractC1612nm, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f3364Q; i2++) {
            i = (i * 31) + C2435zn.m10536b(Double.doubleToLongBits(this.f3363P[i2]));
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f3363P[i] == doubleValue) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        m6739e();
        m4812g(i);
        double[] dArr = this.f3363P;
        double d = dArr[i];
        if (i < this.f3364Q - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (r3 - i) - 1);
        }
        this.f3364Q--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d);
    }

    @Override // com.sonelli.AbstractC1612nm, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        m6739e();
        for (int i = 0; i < this.f3364Q; i++) {
            if (obj.equals(Double.valueOf(this.f3363P[i]))) {
                double[] dArr = this.f3363P;
                System.arraycopy(dArr, i + 1, dArr, i, (this.f3364Q - i) - 1);
                this.f3364Q--;
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
        double[] dArr = this.f3363P;
        System.arraycopy(dArr, i2, dArr, i, this.f3364Q - i2);
        this.f3364Q -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        m6739e();
        m4812g(i);
        double[] dArr = this.f3363P;
        double d = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3364Q;
    }
}
