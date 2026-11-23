package cz.opentree;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.google.android.gms.common.internal.IGmsServiceBroker;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.z9 */
/* loaded from: classes.dex */
public final class C2416z9 implements IGmsServiceBroker {

    /* renamed from: a */
    public final IBinder f8469a;

    public C2416z9(IBinder iBinder) {
        this.f8469a = iBinder;
    }

    @Override // com.google.android.gms.common.internal.IGmsServiceBroker
    /* renamed from: K */
    public final void mo1121K(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(iGmsCallbacks != null ? iGmsCallbacks.asBinder() : null);
            if (getServiceRequest != null) {
                obtain.writeInt(1);
                getServiceRequest.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f8469a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f8469a;
    }
}
