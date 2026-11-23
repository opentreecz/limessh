package com.sonelli;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.internal.zai;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public final class d50 implements Parcelable.Creator<zai> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zai createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        int i = 0;
        ResolveAccountRequest resolveAccountRequest = null;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u == 1) {
                i = C1032ga.m4064D(parcel, m4062B);
            } else if (m4093u != 2) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                resolveAccountRequest = (ResolveAccountRequest) C1032ga.m4086n(parcel, m4062B, ResolveAccountRequest.CREATOR);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new zai(i, resolveAccountRequest);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zai[] newArray(int i) {
        return new zai[i];
    }
}
