package com.sonelli;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.auth.zzad;

/* renamed from: com.sonelli.le */
/* loaded from: classes.dex */
public final class C1503le implements Parcelable.Creator<zzad> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzad createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u == 1) {
                i = C1032ga.m4064D(parcel, m4062B);
            } else if (m4093u != 2) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                str = C1032ga.m4087o(parcel, m4062B);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new zzad(i, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzad[] newArray(int i) {
        return new zzad[i];
    }
}
