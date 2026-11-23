package com.sonelli;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.zzt;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: com.sonelli.d6 */
/* loaded from: classes.dex */
public abstract class AbstractBinderC0861d6 extends BinderC0819ce implements zzt {
    public AbstractBinderC0861d6() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    @Override // com.sonelli.BinderC0819ce
    /* renamed from: q */
    public final boolean mo2675q(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 101:
                mo945U((GoogleSignInAccount) C0923ee.m3476a(parcel, GoogleSignInAccount.CREATOR), (Status) C0923ee.m3476a(parcel, Status.CREATOR));
                break;
            case 102:
                mo946y((Status) C0923ee.m3476a(parcel, Status.CREATOR));
                break;
            case 103:
                mo944J((Status) C0923ee.m3476a(parcel, Status.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
