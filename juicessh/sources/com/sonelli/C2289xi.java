package com.sonelli;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.measurement.zzaa;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.xi */
/* loaded from: classes.dex */
public final class C2289xi implements Parcelable.Creator<zzaa> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaa createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        long j = 0;
        long j2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        boolean z = false;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            switch (C1032ga.m4093u(m4062B)) {
                case 1:
                    j = C1032ga.m4066F(parcel, m4062B);
                    break;
                case 2:
                    j2 = C1032ga.m4066F(parcel, m4062B);
                    break;
                case 3:
                    z = C1032ga.m4094v(parcel, m4062B);
                    break;
                case 4:
                    str = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 5:
                    str2 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 6:
                    str3 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 7:
                    bundle = C1032ga.m4078f(parcel, m4062B);
                    break;
                default:
                    C1032ga.m4069I(parcel, m4062B);
                    break;
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new zzaa(j, j2, z, str, str2, str3, bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaa[] newArray(int i) {
        return new zzaa[i];
    }
}
