package com.sonelli;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.server.converter.zab;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: com.sonelli.nb */
/* loaded from: classes.dex */
public final class C1598nb implements Parcelable.Creator<FastJsonResponse.Field> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FastJsonResponse.Field createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        String str = null;
        String str2 = null;
        zab zabVar = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        int i4 = 0;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            switch (C1032ga.m4093u(m4062B)) {
                case 1:
                    i = C1032ga.m4064D(parcel, m4062B);
                    break;
                case 2:
                    i2 = C1032ga.m4064D(parcel, m4062B);
                    break;
                case 3:
                    z = C1032ga.m4094v(parcel, m4062B);
                    break;
                case 4:
                    i3 = C1032ga.m4064D(parcel, m4062B);
                    break;
                case 5:
                    z2 = C1032ga.m4094v(parcel, m4062B);
                    break;
                case 6:
                    str = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 7:
                    i4 = C1032ga.m4064D(parcel, m4062B);
                    break;
                case 8:
                    str2 = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 9:
                    zabVar = (zab) C1032ga.m4086n(parcel, m4062B, zab.CREATOR);
                    break;
                default:
                    C1032ga.m4069I(parcel, m4062B);
                    break;
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new FastJsonResponse.Field(i, i2, z, i3, z2, str, i4, str2, zabVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FastJsonResponse.Field[] newArray(int i) {
        return new FastJsonResponse.Field[i];
    }
}
