package cz.opentree;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.proxy.ProxyRequest;

/* renamed from: cz.opentree.h5 */
/* loaded from: classes.dex */
public final class C1094h5 implements Parcelable.Creator<ProxyRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ProxyRequest createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        int i = 0;
        int i2 = 0;
        String str = null;
        byte[] bArr = null;
        Bundle bundle = null;
        long j = 0;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            int m4093u = C1032ga.m4093u(m4062B);
            if (m4093u == 1) {
                str = C1032ga.m4087o(parcel, m4062B);
            } else if (m4093u == 2) {
                i2 = C1032ga.m4064D(parcel, m4062B);
            } else if (m4093u == 3) {
                j = C1032ga.m4066F(parcel, m4062B);
            } else if (m4093u == 4) {
                bArr = C1032ga.m4079g(parcel, m4062B);
            } else if (m4093u == 5) {
                bundle = C1032ga.m4078f(parcel, m4062B);
            } else if (m4093u != 1000) {
                C1032ga.m4069I(parcel, m4062B);
            } else {
                i = C1032ga.m4064D(parcel, m4062B);
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new ProxyRequest(i, str, i2, j, bArr, bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ProxyRequest[] newArray(int i) {
        return new ProxyRequest[i];
    }
}
