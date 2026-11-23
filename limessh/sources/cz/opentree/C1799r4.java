package cz.opentree;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.accounttransfer.zzl;
import com.google.android.gms.auth.api.accounttransfer.zzo;
import com.google.android.gms.auth.api.accounttransfer.zzr;
import cz.opentree.C1032ga;
import java.util.ArrayList;
import java.util.HashSet;

/* renamed from: cz.opentree.r4 */
/* loaded from: classes.dex */
public final class C1799r4 implements Parcelable.Creator<zzl> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzl createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        ArrayList arrayList = null;
        zzo zzoVar = null;
        int i2 = 0;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u == 1) {
                i = C1032ga.m4064D(parcel, m4062B);
                hashSet.add(1);
            } else if (m4093u == 2) {
                arrayList = C1032ga.m4091s(parcel, m4062B, zzr.CREATOR);
                hashSet.add(2);
            } else if (m4093u == 3) {
                i2 = C1032ga.m4064D(parcel, m4062B);
                hashSet.add(3);
            } else if (m4093u != 4) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                zzoVar = (zzo) C1032ga.m4086n(parcel, m4062B, zzo.CREATOR);
                hashSet.add(4);
            }
        }
        if (parcel.dataPosition() == m4070J) {
            return new zzl(hashSet, i, arrayList, i2, zzoVar);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(m4070J);
        throw new C1032ga.a(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzl[] newArray(int i) {
        return new zzl[i];
    }
}
