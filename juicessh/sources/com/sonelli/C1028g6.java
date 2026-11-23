package com.sonelli;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: com.sonelli.g6 */
/* loaded from: classes.dex */
public final class C1028g6 implements Parcelable.Creator<SignInConfiguration> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInConfiguration createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        String str = null;
        GoogleSignInOptions googleSignInOptions = null;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u == 2) {
                str = C1032ga.m4087o(parcel, m4062B);
            } else if (m4093u != 5) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                googleSignInOptions = (GoogleSignInOptions) C1032ga.m4086n(parcel, m4062B, GoogleSignInOptions.CREATOR);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new SignInConfiguration(str, googleSignInOptions);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInConfiguration[] newArray(int i) {
        return new SignInConfiguration[i];
    }
}
