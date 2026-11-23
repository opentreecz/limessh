package cz.opentree;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.proxy.ProxyResponse;

/* renamed from: cz.opentree.i5 */
/* loaded from: classes.dex */
public final class C1143i5 implements Parcelable.Creator<ProxyResponse> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ProxyResponse createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        PendingIntent pendingIntent = null;
        Bundle bundle = null;
        byte[] bArr = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u == 1) {
                i2 = C1032ga.m4064D(parcel, m4062B);
            } else if (m4093u == 2) {
                pendingIntent = (PendingIntent) C1032ga.m4086n(parcel, m4062B, PendingIntent.CREATOR);
            } else if (m4093u == 3) {
                i3 = C1032ga.m4064D(parcel, m4062B);
            } else if (m4093u == 4) {
                bundle = C1032ga.m4078f(parcel, m4062B);
            } else if (m4093u == 5) {
                bArr = C1032ga.m4079g(parcel, m4062B);
            } else if (m4093u != 1000) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                i = C1032ga.m4064D(parcel, m4062B);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new ProxyResponse(i, i2, pendingIntent, i3, bundle, bArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ProxyResponse[] newArray(int i) {
        return new ProxyResponse[i];
    }
}
