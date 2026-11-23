package com.sonelli;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.measurement.internal.zzy;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class v40 implements Parcelable.Creator<zzy> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzy createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        String str = null;
        String str2 = null;
        zzkn zzknVar = null;
        String str3 = null;
        zzaq zzaqVar = null;
        zzaq zzaqVar2 = null;
        zzaq zzaqVar3 = null;
        boolean z = false;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            switch (C1032ga.m4093u(m4062B)) {
                case 2:
                    str = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 3:
                    str2 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 4:
                    zzknVar = (zzkn) C1032ga.m4086n(parcel, m4062B, zzkn.CREATOR);
                    break;
                case 5:
                    j = C1032ga.m4066F(parcel, m4062B);
                    break;
                case 6:
                    z = C1032ga.m4094v(parcel, m4062B);
                    break;
                case 7:
                    str3 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 8:
                    zzaqVar = (zzaq) C1032ga.m4086n(parcel, m4062B, zzaq.CREATOR);
                    break;
                case 9:
                    j2 = C1032ga.m4066F(parcel, m4062B);
                    break;
                case 10:
                    zzaqVar2 = (zzaq) C1032ga.m4086n(parcel, m4062B, zzaq.CREATOR);
                    break;
                case 11:
                    j3 = C1032ga.m4066F(parcel, m4062B);
                    break;
                case 12:
                    zzaqVar3 = (zzaq) C1032ga.m4086n(parcel, m4062B, zzaq.CREATOR);
                    break;
                default:
                    C1032ga.m4069I(parcel, m4062B);
                    break;
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new zzy(str, str2, zzknVar, j, z, str3, zzaqVar, j2, zzaqVar2, j3, zzaqVar3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzy[] newArray(int i) {
        return new zzy[i];
    }
}
