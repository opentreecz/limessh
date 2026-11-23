package com.sonelli;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.zza;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.va */
/* loaded from: classes.dex */
public final class C2162va implements Parcelable.Creator<zza> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zza createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        Bundle bundle = null;
        int i = 0;
        Feature[] featureArr = null;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u == 1) {
                bundle = C1032ga.m4078f(parcel, m4062B);
            } else if (m4093u == 2) {
                featureArr = (Feature[]) C1032ga.m4090r(parcel, m4062B, Feature.CREATOR);
            } else if (m4093u != 3) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                i = C1032ga.m4064D(parcel, m4062B);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new zza(bundle, featureArr, i);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zza[] newArray(int i) {
        return new zza[i];
    }
}
