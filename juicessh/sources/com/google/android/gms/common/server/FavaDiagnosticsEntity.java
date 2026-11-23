package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sonelli.C1099ha;
import com.sonelli.C1854sb;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new C1854sb();

    /* renamed from: O */
    public final int f873O;

    /* renamed from: P */
    public final String f874P;

    /* renamed from: Q */
    public final int f875Q;

    public FavaDiagnosticsEntity(int i, String str, int i2) {
        this.f873O = i;
        this.f874P = str;
        this.f875Q = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f873O);
        C1099ha.m4412q(parcel, 2, this.f874P, false);
        C1099ha.m4406k(parcel, 3, this.f875Q);
        C1099ha.m4397b(parcel, m4396a);
    }
}
