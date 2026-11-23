package com.sonelli;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: com.sonelli.z4 */
/* loaded from: classes.dex */
public final class C2411z4 implements Parcelable.Creator<CredentialRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CredentialRequest createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String[] strArr = null;
        CredentialPickerConfig credentialPickerConfig = null;
        CredentialPickerConfig credentialPickerConfig2 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u != 1000) {
                switch (m4093u) {
                    case 1:
                        z = C1032ga.m4094v(parcel, m4062B);
                        break;
                    case 2:
                        strArr = C1032ga.m4088p(parcel, m4062B);
                        break;
                    case 3:
                        credentialPickerConfig = (CredentialPickerConfig) C1032ga.m4086n(parcel, m4062B, CredentialPickerConfig.CREATOR);
                        break;
                    case 4:
                        credentialPickerConfig2 = (CredentialPickerConfig) C1032ga.m4086n(parcel, m4062B, CredentialPickerConfig.CREATOR);
                        break;
                    case 5:
                        z2 = C1032ga.m4094v(parcel, m4062B);
                        break;
                    case 6:
                        str = C1032ga.m4087o(parcel, m4062B);
                        break;
                    case 7:
                        str2 = C1032ga.m4087o(parcel, m4062B);
                        break;
                    case 8:
                        z3 = C1032ga.m4094v(parcel, m4062B);
                        break;
                    default:
                        C1032ga.m4069I(parcel, m4062B);
                        break;
                }
            } else {
                i = C1032ga.m4064D(parcel, m4062B);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new CredentialRequest(i, z, strArr, credentialPickerConfig, credentialPickerConfig2, z2, str, str2, z3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CredentialRequest[] newArray(int i) {
        return new CredentialRequest[i];
    }
}
