package cz.opentree;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.yt */
/* loaded from: classes.dex */
public abstract class AbstractBinderC2391yt extends BinderC2357yk implements zzx {
    public AbstractBinderC2391yt() {
        super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // cz.opentree.BinderC2357yk
    /* renamed from: q */
    public final boolean mo6818q(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            mo1435s0(parcel.readString(), parcel.readString(), (Bundle) C1557mj.m6426a(parcel, Bundle.CREATOR), parcel.readLong());
            parcel2.writeNoException();
        } else {
            if (i != 2) {
                return false;
            }
            int mo1434a = mo1434a();
            parcel2.writeNoException();
            parcel2.writeInt(mo1434a);
        }
        return true;
    }
}
