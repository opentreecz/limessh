package com.sonelli;

import androidx.appcompat.widget.ActivityChooserView;
import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzhf;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.wn */
/* loaded from: classes.dex */
public final class C2236wn extends AbstractC1612nm<Float> implements zzfq<Float>, zzhf, RandomAccess {

    /* renamed from: P */
    public float[] f7775P;

    /* renamed from: Q */
    public int f7776Q;

    static {
        new C2236wn(new float[0], 0).mo1238l();
    }

    public C2236wn() {
        this(new float[10], 0);
    }

    public C2236wn(float[] fArr, int i) {
        this.f7775P = fArr;
        this.f7776Q = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        float floatValue = ((Float) obj).floatValue();
        m6739e();
        if (i < 0 || i > (i2 = this.f7776Q)) {
            throw new IndexOutOfBoundsException(m9599h(i));
        }
        float[] fArr = this.f7775P;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[((i2 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.f7775P, i, fArr2, i + 1, this.f7776Q - i);
            this.f7775P = fArr2;
        }
        this.f7775P[i] = floatValue;
        this.f7776Q++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.sonelli.AbstractC1612nm, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        m9597f(((Float) obj).floatValue());
        return true;
    }

    @Override // com.sonelli.AbstractC1612nm, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        m6739e();
        C2435zn.m10538d(collection);
        if (!(collection instanceof C2236wn)) {
            return super.addAll(collection);
        }
        C2236wn c2236wn = (C2236wn) collection;
        int i = c2236wn.f7776Q;
        if (i == 0) {
            return false;
        }
        int i2 = this.f7776Q;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        float[] fArr = this.f7775P;
        if (i3 > fArr.length) {
            this.f7775P = Arrays.copyOf(fArr, i3);
        }
        System.arraycopy(c2236wn.f7775P, 0, this.f7775P, this.f7776Q, c2236wn.f7776Q);
        this.f7776Q = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzfq
    /* renamed from: c */
    public final /* synthetic */ zzfq<Float> mo1237c(int i) {
        if (i >= this.f7776Q) {
            return new C2236wn(Arrays.copyOf(this.f7775P, i), this.f7776Q);
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
        if (!(obj instanceof C2236wn)) {
            return super.equals(obj);
        }
        C2236wn c2236wn = (C2236wn) obj;
        if (this.f7776Q != c2236wn.f7776Q) {
            return false;
        }
        float[] fArr = c2236wn.f7775P;
        for (int i = 0; i < this.f7776Q; i++) {
            if (Float.floatToIntBits(this.f7775P[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public final void m9597f(float f) {
        m6739e();
        int i = this.f7776Q;
        float[] fArr = this.f7775P;
        if (i == fArr.length) {
            float[] fArr2 = new float[((i * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.f7775P = fArr2;
        }
        float[] fArr3 = this.f7775P;
        int i2 = this.f7776Q;
        this.f7776Q = i2 + 1;
        fArr3[i2] = f;
    }

    /* renamed from: g */
    public final void m9598g(int i) {
        if (i < 0 || i >= this.f7776Q) {
            throw new IndexOutOfBoundsException(m9599h(i));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        m9598g(i);
        return Float.valueOf(this.f7775P[i]);
    }

    /* renamed from: h */
    public final String m9599h(int i) {
        int i2 = this.f7776Q;
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
        for (int i2 = 0; i2 < this.f7776Q; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.f7775P[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f7775P[i] == floatValue) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        m6739e();
        m9598g(i);
        float[] fArr = this.f7775P;
        float f = fArr[i];
        if (i < this.f7776Q - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (r2 - i) - 1);
        }
        this.f7776Q--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f);
    }

    @Override // com.sonelli.AbstractC1612nm, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        m6739e();
        for (int i = 0; i < this.f7776Q; i++) {
            if (obj.equals(Float.valueOf(this.f7775P[i]))) {
                float[] fArr = this.f7775P;
                System.arraycopy(fArr, i + 1, fArr, i, (this.f7776Q - i) - 1);
                this.f7776Q--;
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
        float[] fArr = this.f7775P;
        System.arraycopy(fArr, i2, fArr, i, this.f7776Q - i2);
        this.f7776Q -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        m6739e();
        m9598g(i);
        float[] fArr = this.f7775P;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7776Q;
    }
}
