package com.sonelli;

import androidx.appcompat.widget.ActivityChooserView;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzhf;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.qo */
/* loaded from: classes.dex */
public final class C1778qo extends AbstractC1612nm<Long> implements zzfr, zzhf, RandomAccess {

    /* renamed from: R */
    public static final C1778qo f6059R;

    /* renamed from: P */
    public long[] f6060P;

    /* renamed from: Q */
    public int f6061Q;

    static {
        C1778qo c1778qo = new C1778qo(new long[0], 0);
        f6059R = c1778qo;
        c1778qo.mo1238l();
    }

    public C1778qo() {
        this(new long[10], 0);
    }

    public C1778qo(long[] jArr, int i) {
        this.f6060P = jArr;
        this.f6061Q = i;
    }

    /* renamed from: g */
    public static C1778qo m7762g() {
        return f6059R;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        long longValue = ((Long) obj).longValue();
        m6739e();
        if (i < 0 || i > (i2 = this.f6061Q)) {
            throw new IndexOutOfBoundsException(m7765i(i));
        }
        long[] jArr = this.f6060P;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.f6060P, i, jArr2, i + 1, this.f6061Q - i);
            this.f6060P = jArr2;
        }
        this.f6060P[i] = longValue;
        this.f6061Q++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.sonelli.AbstractC1612nm, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        m7763f(((Long) obj).longValue());
        return true;
    }

    @Override // com.sonelli.AbstractC1612nm, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        m6739e();
        C2435zn.m10538d(collection);
        if (!(collection instanceof C1778qo)) {
            return super.addAll(collection);
        }
        C1778qo c1778qo = (C1778qo) collection;
        int i = c1778qo.f6061Q;
        if (i == 0) {
            return false;
        }
        int i2 = this.f6061Q;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        long[] jArr = this.f6060P;
        if (i3 > jArr.length) {
            this.f6060P = Arrays.copyOf(jArr, i3);
        }
        System.arraycopy(c1778qo.f6060P, 0, this.f6060P, this.f6061Q, c1778qo.f6061Q);
        this.f6061Q = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzfr
    /* renamed from: d */
    public final long mo1239d(int i) {
        m7764h(i);
        return this.f6060P[i];
    }

    @Override // com.sonelli.AbstractC1612nm, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1778qo)) {
            return super.equals(obj);
        }
        C1778qo c1778qo = (C1778qo) obj;
        if (this.f6061Q != c1778qo.f6061Q) {
            return false;
        }
        long[] jArr = c1778qo.f6060P;
        for (int i = 0; i < this.f6061Q; i++) {
            if (this.f6060P[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public final void m7763f(long j) {
        m6739e();
        int i = this.f6061Q;
        long[] jArr = this.f6060P;
        if (i == jArr.length) {
            long[] jArr2 = new long[((i * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.f6060P = jArr2;
        }
        long[] jArr3 = this.f6060P;
        int i2 = this.f6061Q;
        this.f6061Q = i2 + 1;
        jArr3[i2] = j;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(mo1239d(i));
    }

    /* renamed from: h */
    public final void m7764h(int i) {
        if (i < 0 || i >= this.f6061Q) {
            throw new IndexOutOfBoundsException(m7765i(i));
        }
    }

    @Override // com.sonelli.AbstractC1612nm, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f6061Q; i2++) {
            i = (i * 31) + C2435zn.m10536b(this.f6060P[i2]);
        }
        return i;
    }

    /* renamed from: i */
    public final String m7765i(int i) {
        int i2 = this.f6061Q;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f6060P[i] == longValue) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        m6739e();
        m7764h(i);
        long[] jArr = this.f6060P;
        long j = jArr[i];
        if (i < this.f6061Q - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (r3 - i) - 1);
        }
        this.f6061Q--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // com.sonelli.AbstractC1612nm, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        m6739e();
        for (int i = 0; i < this.f6061Q; i++) {
            if (obj.equals(Long.valueOf(this.f6060P[i]))) {
                long[] jArr = this.f6060P;
                System.arraycopy(jArr, i + 1, jArr, i, (this.f6061Q - i) - 1);
                this.f6061Q--;
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
        long[] jArr = this.f6060P;
        System.arraycopy(jArr, i2, jArr, i, this.f6061Q - i2);
        this.f6061Q -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        m6739e();
        m7764h(i);
        long[] jArr = this.f6060P;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6061Q;
    }

    @Override // com.google.android.gms.internal.measurement.zzfq
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public final zzfr mo1237c(int i) {
        if (i >= this.f6061Q) {
            return new C1778qo(Arrays.copyOf(this.f6060P, i), this.f6061Q);
        }
        throw new IllegalArgumentException();
    }
}
