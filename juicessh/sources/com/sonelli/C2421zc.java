package com.sonelli;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.zc */
/* loaded from: classes.dex */
public final class C2421zc implements Parcelable.Creator<Feature> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Feature createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        String str = null;
        int i = 0;
        long j = -1;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u == 1) {
                str = C1032ga.m4087o(parcel, m4062B);
            } else if (m4093u == 2) {
                i = C1032ga.m4064D(parcel, m4062B);
            } else if (m4093u != 3) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                j = C1032ga.m4066F(parcel, m4062B);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new Feature(str, i, j);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Feature[] newArray(int i) {
        return new Feature[i];
    }
}
