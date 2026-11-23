package com.sonelli;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: com.sonelli.y4 */
/* loaded from: classes.dex */
public final class C2324y4 implements Parcelable.Creator<CredentialPickerConfig> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CredentialPickerConfig createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u == 1) {
                z = C1032ga.m4094v(parcel, m4062B);
            } else if (m4093u == 2) {
                z2 = C1032ga.m4094v(parcel, m4062B);
            } else if (m4093u == 3) {
                z3 = C1032ga.m4094v(parcel, m4062B);
            } else if (m4093u == 4) {
                i2 = C1032ga.m4064D(parcel, m4062B);
            } else if (m4093u != 1000) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                i = C1032ga.m4064D(parcel, m4062B);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new CredentialPickerConfig(i, z, z2, z3, i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CredentialPickerConfig[] newArray(int i) {
        return new CredentialPickerConfig[i];
    }
}
