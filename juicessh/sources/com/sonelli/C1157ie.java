package com.sonelli;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.internal.p006authapi.zzz;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: com.sonelli.ie */
/* loaded from: classes.dex */
public final class C1157ie implements Parcelable.Creator<zzz> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzz createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        Credential credential = null;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            if (C1032ga.m4093u(m4062B) != 1) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                credential = (Credential) C1032ga.m4086n(parcel, m4062B, Credential.CREATOR);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new zzz(credential);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzz[] newArray(int i) {
        return new zzz[i];
    }
}
