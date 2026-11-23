package com.sonelli;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.internal.zzm;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class m40 implements Parcelable.Creator<zzm> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzm createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        boolean z = false;
        int i = 0;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = true;
        boolean z5 = true;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        Boolean bool = null;
        ArrayList<String> arrayList = null;
        String str8 = null;
        long j6 = -2147483648L;
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
                    str3 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 5:
                    str4 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 6:
                    j = C1032ga.m4066F(parcel, m4062B);
                    break;
                case 7:
                    j2 = C1032ga.m4066F(parcel, m4062B);
                    break;
                case 8:
                    str5 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 9:
                    z3 = C1032ga.m4094v(parcel, m4062B);
                    break;
                case 10:
                    z = C1032ga.m4094v(parcel, m4062B);
                    break;
                case 11:
                    j6 = C1032ga.m4066F(parcel, m4062B);
                    break;
                case 12:
                    str6 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 13:
                    j3 = C1032ga.m4066F(parcel, m4062B);
                    break;
                case 14:
                    j4 = C1032ga.m4066F(parcel, m4062B);
                    break;
                case 15:
                    i = C1032ga.m4064D(parcel, m4062B);
                    break;
                case 16:
                    z4 = C1032ga.m4094v(parcel, m4062B);
                    break;
                case 17:
                    z5 = C1032ga.m4094v(parcel, m4062B);
                    break;
                case 18:
                    z2 = C1032ga.m4094v(parcel, m4062B);
                    break;
                case 19:
                    str7 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 20:
                default:
                    C1032ga.m4069I(parcel, m4062B);
                    break;
                case 21:
                    bool = C1032ga.m4095w(parcel, m4062B);
                    break;
                case 22:
                    j5 = C1032ga.m4066F(parcel, m4062B);
                    break;
                case 23:
                    arrayList = C1032ga.m4089q(parcel, m4062B);
                    break;
                case 24:
                    str8 = C1032ga.m4087o(parcel, m4062B);
                    break;
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new zzm(str, str2, str3, str4, j, j2, str5, z3, z, j6, str6, j3, j4, i, z4, z5, z2, str7, bool, j5, arrayList, str8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzm[] newArray(int i) {
        return new zzm[i];
    }
}
