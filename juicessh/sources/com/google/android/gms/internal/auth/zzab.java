package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sonelli.C0813ca;
import com.sonelli.C1099ha;
import com.sonelli.C1446ke;

/* loaded from: classes.dex */
public final class zzab extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzab> CREATOR = new C1446ke();

    /* renamed from: O */
    public final int f949O = 1;

    /* renamed from: P */
    public final String f950P;

    /* renamed from: Q */
    public final int f951Q;

    public zzab(int i, String str, int i2) {
        C0813ca.m2729k(str);
        this.f950P = str;
        this.f951Q = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f949O);
        C1099ha.m4412q(parcel, 2, this.f950P, false);
        C1099ha.m4406k(parcel, 3, this.f951Q);
        C1099ha.m4397b(parcel, m4396a);
    }
}
