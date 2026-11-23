package com.sonelli;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.xe */
/* loaded from: classes.dex */
public class BinderC2274xe extends Binder implements IInterface {
    public BinderC2274xe(String str) {
        attachInterface(this, str);
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        boolean z;
        if (i > 16777215) {
            z = super.onTransact(i, parcel, parcel2, i2);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            z = false;
        }
        if (z) {
            return true;
        }
        return mo1120q(i, parcel, parcel2, i2);
    }

    /* renamed from: q */
    public boolean mo1120q(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        return false;
    }
}
