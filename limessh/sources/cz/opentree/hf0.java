package cz.opentree;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.firebase.iid.zzx;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final class hf0 implements zzx {

    /* renamed from: a */
    public final IBinder f3142a;

    public hf0(@NonNull IBinder iBinder) {
        this.f3142a = iBinder;
    }

    @Override // com.google.firebase.iid.zzx
    /* renamed from: D0 */
    public final void mo1907D0(@NonNull Message message) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
        obtain.writeInt(1);
        message.writeToParcel(obtain, 0);
        try {
            this.f3142a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    @NonNull
    public final IBinder asBinder() {
        return this.f3142a;
    }
}
