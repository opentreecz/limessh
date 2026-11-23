package com.sonelli;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzj;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.jd */
/* loaded from: classes.dex */
public final class C1208jd implements Parcelable.Creator<zzj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzj createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        boolean z = false;
        String str = null;
        IBinder iBinder = null;
        boolean z2 = false;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u == 1) {
                str = C1032ga.m4087o(parcel, m4062B);
            } else if (m4093u == 2) {
                iBinder = C1032ga.m4063C(parcel, m4062B);
            } else if (m4093u == 3) {
                z = C1032ga.m4094v(parcel, m4062B);
            } else if (m4093u != 4) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                z2 = C1032ga.m4094v(parcel, m4062B);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new zzj(str, iBinder, z, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzj[] newArray(int i) {
        return new zzj[i];
    }
}
