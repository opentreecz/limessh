package cz.opentree;

import androidx.appcompat.widget.ActivityChooserView;
import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzhf;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.rm */
/* loaded from: classes.dex */
public final class C1824rm extends AbstractC1612nm<Boolean> implements zzfq<Boolean>, zzhf, RandomAccess {

    /* renamed from: P */
    public boolean[] f6241P;

    /* renamed from: Q */
    public int f6242Q;

    static {
        new C1824rm(new boolean[0], 0).mo1238l();
    }

    public C1824rm() {
        this(new boolean[10], 0);
    }

    public C1824rm(boolean[] zArr, int i) {
        this.f6241P = zArr;
        this.f6242Q = i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        m6739e();
        if (i < 0 || i > (i2 = this.f6242Q)) {
            throw new IndexOutOfBoundsException(m8147h(i));
        }
        boolean[] zArr = this.f6241P;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.f6241P, i, zArr2, i + 1, this.f6242Q - i);
            this.f6241P = zArr2;
        }
        this.f6241P[i] = booleanValue;
        this.f6242Q++;
        ((AbstractList) this).modCount++;
    }

    @Override // cz.opentree.AbstractC1612nm, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        m8145f(((Boolean) obj).booleanValue());
        return true;
    }

    @Override // cz.opentree.AbstractC1612nm, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        m6739e();
        C2435zn.m10538d(collection);
        if (!(collection instanceof C1824rm)) {
            return super.addAll(collection);
        }
        C1824rm c1824rm = (C1824rm) collection;
        int i = c1824rm.f6242Q;
        if (i == 0) {
            return false;
        }
        int i2 = this.f6242Q;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        boolean[] zArr = this.f6241P;
        if (i3 > zArr.length) {
            this.f6241P = Arrays.copyOf(zArr, i3);
        }
        System.arraycopy(c1824rm.f6241P, 0, this.f6241P, this.f6242Q, c1824rm.f6242Q);
        this.f6242Q = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzfq
    /* renamed from: c */
    public final /* synthetic */ zzfq<Boolean> mo1237c(int i) {
        if (i >= this.f6242Q) {
            return new C1824rm(Arrays.copyOf(this.f6241P, i), this.f6242Q);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // cz.opentree.AbstractC1612nm, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1824rm)) {
            return super.equals(obj);
        }
        C1824rm c1824rm = (C1824rm) obj;
        if (this.f6242Q != c1824rm.f6242Q) {
            return false;
        }
        boolean[] zArr = c1824rm.f6241P;
        for (int i = 0; i < this.f6242Q; i++) {
            if (this.f6241P[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public final void m8145f(boolean z) {
        m6739e();
        int i = this.f6242Q;
        boolean[] zArr = this.f6241P;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[((i * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.f6241P = zArr2;
        }
        boolean[] zArr3 = this.f6241P;
        int i2 = this.f6242Q;
        this.f6242Q = i2 + 1;
        zArr3[i2] = z;
    }

    /* renamed from: g */
    public final void m8146g(int i) {
        if (i < 0 || i >= this.f6242Q) {
            throw new IndexOutOfBoundsException(m8147h(i));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        m8146g(i);
        return Boolean.valueOf(this.f6241P[i]);
    }

    /* renamed from: h */
    public final String m8147h(int i) {
        int i2 = this.f6242Q;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // cz.opentree.AbstractC1612nm, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f6242Q; i2++) {
            i = (i * 31) + C2435zn.m10537c(this.f6241P[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f6241P[i] == booleanValue) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        m6739e();
        m8146g(i);
        boolean[] zArr = this.f6241P;
        boolean z = zArr[i];
        if (i < this.f6242Q - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (r2 - i) - 1);
        }
        this.f6242Q--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // cz.opentree.AbstractC1612nm, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        m6739e();
        for (int i = 0; i < this.f6242Q; i++) {
            if (obj.equals(Boolean.valueOf(this.f6241P[i]))) {
                boolean[] zArr = this.f6241P;
                System.arraycopy(zArr, i + 1, zArr, i, (this.f6242Q - i) - 1);
                this.f6242Q--;
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
        boolean[] zArr = this.f6241P;
        System.arraycopy(zArr, i2, zArr, i, this.f6242Q - i2);
        this.f6242Q -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        m6739e();
        m8146g(i);
        boolean[] zArr = this.f6241P;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6242Q;
    }
}
