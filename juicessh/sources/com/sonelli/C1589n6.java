package com.sonelli;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: com.sonelli.n6 */
/* loaded from: classes.dex */
public final class C1589n6 implements Parcelable.Creator<SignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInAccount createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        String str = "";
        GoogleSignInAccount googleSignInAccount = null;
        String str2 = "";
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u == 4) {
                str = C1032ga.m4087o(parcel, m4062B);
            } else if (m4093u == 7) {
                googleSignInAccount = (GoogleSignInAccount) C1032ga.m4086n(parcel, m4062B, GoogleSignInAccount.CREATOR);
            } else if (m4093u != 8) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                str2 = C1032ga.m4087o(parcel, m4062B);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new SignInAccount(str, googleSignInAccount, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInAccount[] newArray(int i) {
        return new SignInAccount[i];
    }
}
