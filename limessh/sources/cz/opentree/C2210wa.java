package cz.opentree;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.wa */
/* loaded from: classes.dex */
public final class C2210wa implements Parcelable.Creator<GetServiceRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GetServiceRequest createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        Feature[] featureArr = null;
        Feature[] featureArr2 = null;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            switch (C1032ga.m4093u(m4062B)) {
                case 1:
                    i = C1032ga.m4064D(parcel, m4062B);
                    break;
                case 2:
                    i2 = C1032ga.m4064D(parcel, m4062B);
                    break;
                case 3:
                    i3 = C1032ga.m4064D(parcel, m4062B);
                    break;
                case 4:
                    str = C1032ga.m4087o(parcel, m4062B);
                    break;
                case 5:
                    iBinder = C1032ga.m4063C(parcel, m4062B);
                    break;
                case 6:
                    scopeArr = (Scope[]) C1032ga.m4090r(parcel, m4062B, Scope.CREATOR);
                    break;
                case 7:
                    bundle = C1032ga.m4078f(parcel, m4062B);
                    break;
                case 8:
                    account = (Account) C1032ga.m4086n(parcel, m4062B, Account.CREATOR);
                    break;
                case 9:
                default:
                    C1032ga.m4069I(parcel, m4062B);
                    break;
                case 10:
                    featureArr = (Feature[]) C1032ga.m4090r(parcel, m4062B, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) C1032ga.m4090r(parcel, m4062B, Feature.CREATOR);
                    break;
                case 12:
                    z = C1032ga.m4094v(parcel, m4062B);
                    break;
                case 13:
                    i4 = C1032ga.m4064D(parcel, m4062B);
                    break;
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new GetServiceRequest(i, i2, i3, str, iBinder, scopeArr, bundle, account, featureArr, featureArr2, z, i4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GetServiceRequest[] newArray(int i) {
        return new GetServiceRequest[i];
    }
}
