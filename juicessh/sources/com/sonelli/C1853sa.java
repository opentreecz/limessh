package com.sonelli;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: com.sonelli.sa */
/* loaded from: classes.dex */
public final class C1853sa implements Parcelable.Creator<ResolveAccountResponse> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ResolveAccountResponse createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        IBinder iBinder = null;
        ConnectionResult connectionResult = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u == 1) {
                i = C1032ga.m4064D(parcel, m4062B);
            } else if (m4093u == 2) {
                iBinder = C1032ga.m4063C(parcel, m4062B);
            } else if (m4093u == 3) {
                connectionResult = (ConnectionResult) C1032ga.m4086n(parcel, m4062B, ConnectionResult.CREATOR);
            } else if (m4093u == 4) {
                z = C1032ga.m4094v(parcel, m4062B);
            } else if (m4093u != 5) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                z2 = C1032ga.m4094v(parcel, m4062B);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new ResolveAccountResponse(i, iBinder, connectionResult, z, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ResolveAccountResponse[] newArray(int i) {
        return new ResolveAccountResponse[i];
    }
}
