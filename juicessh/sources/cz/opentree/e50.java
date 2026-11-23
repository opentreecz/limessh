package cz.opentree;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.internal.zak;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public final class e50 implements Parcelable.Creator<zak> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zak createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        ConnectionResult connectionResult = null;
        int i = 0;
        ResolveAccountResponse resolveAccountResponse = null;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u == 1) {
                i = C1032ga.m4064D(parcel, m4062B);
            } else if (m4093u == 2) {
                connectionResult = (ConnectionResult) C1032ga.m4086n(parcel, m4062B, ConnectionResult.CREATOR);
            } else if (m4093u != 3) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                resolveAccountResponse = (ResolveAccountResponse) C1032ga.m4086n(parcel, m4062B, ResolveAccountResponse.CREATOR);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new zak(i, connectionResult, resolveAccountResponse);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zak[] newArray(int i) {
        return new zak[i];
    }
}
