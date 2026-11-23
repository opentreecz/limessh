package cz.opentree;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.ResolveAccountRequest;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.ra */
/* loaded from: classes.dex */
public final class C1809ra implements Parcelable.Creator<ResolveAccountRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ResolveAccountRequest createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        Account account = null;
        int i = 0;
        int i2 = 0;
        GoogleSignInAccount googleSignInAccount = null;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u == 1) {
                i = C1032ga.m4064D(parcel, m4062B);
            } else if (m4093u == 2) {
                account = (Account) C1032ga.m4086n(parcel, m4062B, Account.CREATOR);
            } else if (m4093u == 3) {
                i2 = C1032ga.m4064D(parcel, m4062B);
            } else if (m4093u != 4) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                googleSignInAccount = (GoogleSignInAccount) C1032ga.m4086n(parcel, m4062B, GoogleSignInAccount.CREATOR);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new ResolveAccountRequest(i, account, i2, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ResolveAccountRequest[] newArray(int i) {
        return new ResolveAccountRequest[i];
    }
}
