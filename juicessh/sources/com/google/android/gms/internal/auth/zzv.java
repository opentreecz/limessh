package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sonelli.C0813ca;
import com.sonelli.C1099ha;
import com.sonelli.C1813re;

/* loaded from: classes.dex */
public final class zzv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzv> CREATOR = new C1813re();

    /* renamed from: O */
    public final int f960O = 1;

    /* renamed from: P */
    public final String f961P;

    public zzv(int i, String str) {
        C0813ca.m2729k(str);
        this.f961P = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f960O);
        C1099ha.m4412q(parcel, 2, this.f961P, false);
        C1099ha.m4397b(parcel, m4396a);
    }
}
