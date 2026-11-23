package cz.opentree;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.internal.zzr;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: cz.opentree.c6 */
/* loaded from: classes.dex */
public abstract class AbstractBinderC0809c6 extends BinderC0819ce implements zzr {
    public AbstractBinderC0809c6() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    @Override // cz.opentree.BinderC0819ce
    /* renamed from: q */
    public final boolean mo2675q(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            mo943i();
        } else {
            if (i != 2) {
                return false;
            }
            mo942h();
        }
        return true;
    }
}
