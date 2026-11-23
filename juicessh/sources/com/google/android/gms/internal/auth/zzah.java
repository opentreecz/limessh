package com.google.android.gms.internal.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sonelli.C0813ca;
import com.sonelli.C1099ha;
import com.sonelli.C1601ne;

/* loaded from: classes.dex */
public final class zzah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzah> CREATOR = new C1601ne();

    /* renamed from: O */
    public final int f957O = 1;

    /* renamed from: P */
    public final String f958P;

    /* renamed from: Q */
    public final PendingIntent f959Q;

    public zzah(int i, String str, PendingIntent pendingIntent) {
        C0813ca.m2729k(str);
        this.f958P = str;
        C0813ca.m2729k(pendingIntent);
        this.f959Q = pendingIntent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f957O);
        C1099ha.m4412q(parcel, 2, this.f958P, false);
        C1099ha.m4411p(parcel, 3, this.f959Q, i, false);
        C1099ha.m4397b(parcel, m4396a);
    }
}
