package com.sonelli;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;

/* renamed from: com.sonelli.v4 */
/* loaded from: classes.dex */
public final class C2152v4 implements Parcelable.Creator<DeviceMetaData> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DeviceMetaData createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        long j = 0;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u == 1) {
                i = C1032ga.m4064D(parcel, m4062B);
            } else if (m4093u == 2) {
                z = C1032ga.m4094v(parcel, m4062B);
            } else if (m4093u == 3) {
                j = C1032ga.m4066F(parcel, m4062B);
            } else if (m4093u != 4) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                z2 = C1032ga.m4094v(parcel, m4062B);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new DeviceMetaData(i, z, j, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DeviceMetaData[] newArray(int i) {
        return new DeviceMetaData[i];
    }
}
