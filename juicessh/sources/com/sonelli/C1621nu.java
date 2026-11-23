package com.sonelli;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzal;
import com.google.android.gms.measurement.internal.zzaq;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.nu */
/* loaded from: classes.dex */
public final class C1621nu implements Parcelable.Creator<zzaq> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaq createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        String str = null;
        zzal zzalVar = null;
        String str2 = null;
        long j = 0;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u == 2) {
                str = C1032ga.m4087o(parcel, m4062B);
            } else if (m4093u == 3) {
                zzalVar = (zzal) C1032ga.m4086n(parcel, m4062B, zzal.CREATOR);
            } else if (m4093u == 4) {
                str2 = C1032ga.m4087o(parcel, m4062B);
            } else if (m4093u != 5) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                j = C1032ga.m4066F(parcel, m4062B);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new zzaq(str, zzalVar, str2, j);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaq[] newArray(int i) {
        return new zzaq[i];
    }
}
