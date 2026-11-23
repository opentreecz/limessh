package cz.opentree;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: cz.opentree.f5 */
/* loaded from: classes.dex */
public final class C0970f5 implements Parcelable.Creator<BeginSignInRequest.PasswordRequestOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ BeginSignInRequest.PasswordRequestOptions createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        boolean z = false;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            if (C1032ga.m4093u(m4062B) != 1) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                z = C1032ga.m4094v(parcel, m4062B);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new BeginSignInRequest.PasswordRequestOptions(z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ BeginSignInRequest.PasswordRequestOptions[] newArray(int i) {
        return new BeginSignInRequest.PasswordRequestOptions[i];
    }
}
