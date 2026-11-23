package com.sonelli;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.auth.api.accounttransfer.zzt;
import com.sonelli.C1032ga;
import java.util.HashSet;

/* renamed from: com.sonelli.u4 */
/* loaded from: classes.dex */
public final class C1993u4 implements Parcelable.Creator<zzt> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzt createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        HashSet hashSet = new HashSet();
        int i = 0;
        String str = null;
        byte[] bArr = null;
        PendingIntent pendingIntent = null;
        DeviceMetaData deviceMetaData = null;
        int i2 = 0;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            switch (C1032ga.m4093u(m4062B)) {
                case 1:
                    i2 = C1032ga.m4064D(parcel, m4062B);
                    hashSet.add(1);
                    break;
                case 2:
                    str = C1032ga.m4087o(parcel, m4062B);
                    hashSet.add(2);
                    break;
                case 3:
                    i = C1032ga.m4064D(parcel, m4062B);
                    hashSet.add(3);
                    break;
                case 4:
                    bArr = C1032ga.m4079g(parcel, m4062B);
                    hashSet.add(4);
                    break;
                case 5:
                    pendingIntent = (PendingIntent) C1032ga.m4086n(parcel, m4062B, PendingIntent.CREATOR);
                    hashSet.add(5);
                    break;
                case 6:
                    deviceMetaData = (DeviceMetaData) C1032ga.m4086n(parcel, m4062B, DeviceMetaData.CREATOR);
                    hashSet.add(6);
                    break;
                default:
                    C1032ga.m4069I(parcel, m4062B);
                    break;
            }
        }
        if (parcel.dataPosition() == m4070J) {
            return new zzt(hashSet, i2, str, i, bArr, pendingIntent, deviceMetaData);
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(m4070J);
        throw new C1032ga.a(sb.toString(), parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzt[] newArray(int i) {
        return new zzt[i];
    }
}
