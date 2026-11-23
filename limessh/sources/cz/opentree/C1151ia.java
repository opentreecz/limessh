package cz.opentree;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AuthAccountRequest;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.ia */
/* loaded from: classes.dex */
public final class C1151ia implements Parcelable.Creator<AuthAccountRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AuthAccountRequest createFromParcel(Parcel parcel) {
        int m4070J = C1032ga.m4070J(parcel);
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Integer num = null;
        Integer num2 = null;
        Account account = null;
        int i = 0;
        while (parcel.dataPosition() < m4070J) {
            int m4062B = C1032ga.m4062B(parcel);
            switch (C1032ga.m4093u(m4062B)) {
                case 1:
                    i = C1032ga.m4064D(parcel, m4062B);
                    break;
                case 2:
                    iBinder = C1032ga.m4063C(parcel, m4062B);
                    break;
                case 3:
                    scopeArr = (Scope[]) C1032ga.m4090r(parcel, m4062B, Scope.CREATOR);
                    break;
                case 4:
                    num = C1032ga.m4065E(parcel, m4062B);
                    break;
                case 5:
                    num2 = C1032ga.m4065E(parcel, m4062B);
                    break;
                case 6:
                    account = (Account) C1032ga.m4086n(parcel, m4062B, Account.CREATOR);
                    break;
                default:
                    C1032ga.m4069I(parcel, m4062B);
                    break;
            }
        }
        C1032ga.m4092t(parcel, m4070J);
        return new AuthAccountRequest(i, iBinder, scopeArr, num, num2, account);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AuthAccountRequest[] newArray(int i) {
        return new AuthAccountRequest[i];
    }
}
