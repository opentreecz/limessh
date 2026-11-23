package com.sonelli;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.zal;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: com.sonelli.ob */
/* loaded from: classes.dex */
public final class C1647ob implements Parcelable.Creator<zal> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zal createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        String str = null;
        int i = 0;
        FastJsonResponse.Field field = null;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u == 1) {
                i = C1032ga.m4064D(parcel, m4062B);
            } else if (m4093u == 2) {
                str = C1032ga.m4087o(parcel, m4062B);
            } else if (m4093u != 3) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                field = (FastJsonResponse.Field) C1032ga.m4086n(parcel, m4062B, FastJsonResponse.Field.CREATOR);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new zal(i, str, field);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zal[] newArray(int i) {
        return new zal[i];
    }
}
