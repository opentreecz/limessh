package com.sonelli;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.accounttransfer.zzr;
import com.google.android.gms.auth.api.accounttransfer.zzt;
import com.sonelli.C1032ga;
import java.util.HashSet;

/* renamed from: com.sonelli.t4 */
/* loaded from: classes.dex */
public final class C1899t4 implements Parcelable.Creator<zzr> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        zzt zztVar = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u == 1) {
                i = C1032ga.m4064D(parcel, m4062B);
                hashSet.add(1);
            } else if (m4093u == 2) {
                zztVar = (zzt) C1032ga.m4086n(parcel, m4062B, zzt.CREATOR);
                hashSet.add(2);
            } else if (m4093u == 3) {
                str = C1032ga.m4087o(parcel, m4062B);
                hashSet.add(3);
            } else if (m4093u == 4) {
                str2 = C1032ga.m4087o(parcel, m4062B);
                hashSet.add(4);
            } else if (m4093u != 5) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                str3 = C1032ga.m4087o(parcel, m4062B);
                hashSet.add(5);
            }
        }
        if (parcel.dataPosition() == m4070J) {
            return new zzr(hashSet, i, zztVar, str, str2, str3);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(m4070J);
        throw new C1032ga.a(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr[] newArray(int i) {
        return new zzr[i];
    }
}
