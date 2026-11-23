package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sonelli.C1099ha;
import com.sonelli.C1524lu;
import com.sonelli.C1573mu;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class zzal extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzal> CREATOR = new C1524lu();

    /* renamed from: O */
    public final Bundle f985O;

    public zzal(Bundle bundle) {
        this.f985O = bundle;
    }

    /* renamed from: Y */
    public final Object m1456Y(String str) {
        return this.f985O.get(str);
    }

    /* renamed from: Z */
    public final Bundle m1457Z() {
        return new Bundle(this.f985O);
    }

    /* renamed from: a0 */
    public final Long m1458a0(String str) {
        return Long.valueOf(this.f985O.getLong(str));
    }

    /* renamed from: b0 */
    public final Double m1459b0(String str) {
        return Double.valueOf(this.f985O.getDouble(str));
    }

    /* renamed from: c0 */
    public final String m1460c0(String str) {
        return this.f985O.getString(str);
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new C1573mu(this);
    }

    public final String toString() {
        return this.f985O.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4400e(parcel, 2, m1457Z(), false);
        C1099ha.m4397b(parcel, m4396a);
    }

    /* renamed from: x */
    public final int m1461x() {
        return this.f985O.size();
    }
}
