package com.sonelli;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzs;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.hb */
/* loaded from: classes.dex */
public final class C1102hb implements Parcelable.Creator<zzs> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzs createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        int i = 0;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            if (C1032ga.m4093u(m4062B) != 1) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                i = C1032ga.m4064D(parcel, m4062B);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new zzs(i);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzs[] newArray(int i) {
        return new zzs[i];
    }
}
