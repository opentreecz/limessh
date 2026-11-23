package cz.opentree;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.internal.zab;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zak;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public abstract class b50 extends BinderC1857se implements zac {
    public b50() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // cz.opentree.BinderC1857se
    /* renamed from: O0 */
    public boolean mo2373O0(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 3) {
            mo1502C0((ConnectionResult) C2005ue.m8871a(parcel, ConnectionResult.CREATOR), (zab) C2005ue.m8871a(parcel, zab.CREATOR));
        } else if (i == 4) {
            mo1504i0((Status) C2005ue.m8871a(parcel, Status.CREATOR));
        } else if (i == 6) {
            mo1505p0((Status) C2005ue.m8871a(parcel, Status.CREATOR));
        } else if (i == 7) {
            mo1506u((Status) C2005ue.m8871a(parcel, Status.CREATOR), (GoogleSignInAccount) C2005ue.m8871a(parcel, GoogleSignInAccount.CREATOR));
        } else {
            if (i != 8) {
                return false;
            }
            mo1503L((zak) C2005ue.m8871a(parcel, zak.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
