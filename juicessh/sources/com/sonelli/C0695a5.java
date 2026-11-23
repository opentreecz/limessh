package com.sonelli;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.HintRequest;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: com.sonelli.a5 */
/* loaded from: classes.dex */
public final class C0695a5 implements Parcelable.Creator<HintRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ HintRequest createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        CredentialPickerConfig credentialPickerConfig = null;
        String[] strArr = null;
        String str = null;
        String str2 = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u != 1000) {
                switch (m4093u) {
                    case 1:
                        credentialPickerConfig = (CredentialPickerConfig) C1032ga.m4086n(parcel, m4062B, CredentialPickerConfig.CREATOR);
                        break;
                    case 2:
                        z = C1032ga.m4094v(parcel, m4062B);
                        break;
                    case 3:
                        z2 = C1032ga.m4094v(parcel, m4062B);
                        break;
                    case 4:
                        strArr = C1032ga.m4088p(parcel, m4062B);
                        break;
                    case 5:
                        z3 = C1032ga.m4094v(parcel, m4062B);
                        break;
                    case 6:
                        str = C1032ga.m4087o(parcel, m4062B);
                        break;
                    case 7:
                        str2 = C1032ga.m4087o(parcel, m4062B);
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
        return new HintRequest(i, credentialPickerConfig, z, z2, strArr, z3, str, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ HintRequest[] newArray(int i) {
        return new HintRequest[i];
    }
}
