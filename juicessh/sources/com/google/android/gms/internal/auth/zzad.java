package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sonelli.C0813ca;
import com.sonelli.C1099ha;
import com.sonelli.C1503le;

/* loaded from: classes.dex */
public final class zzad extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzad> CREATOR = new C1503le();

    /* renamed from: O */
    public final int f952O = 1;

    /* renamed from: P */
    public final String f953P;

    public zzad(int i, String str) {
        C0813ca.m2729k(str);
        this.f953P = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f952O);
        C1099ha.m4412q(parcel, 2, this.f953P, false);
        C1099ha.m4397b(parcel, m4396a);
    }
}
