package cz.opentree;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.auth.zzaf;

/* renamed from: cz.opentree.me */
/* loaded from: classes.dex */
public final class C1549me implements Parcelable.Creator<zzaf> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaf createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        String str = null;
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u == 1) {
                i = C1032ga.m4064D(parcel, m4062B);
            } else if (m4093u == 2) {
                str = C1032ga.m4087o(parcel, m4062B);
            } else if (m4093u != 3) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                bArr = C1032ga.m4079g(parcel, m4062B);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new zzaf(i, str, bArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaf[] newArray(int i) {
        return new zzaf[i];
    }
}
