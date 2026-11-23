package com.sonelli;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.sonelli.ji */
/* loaded from: classes.dex */
public class C1213ji implements IInterface {

    /* renamed from: a */
    public final IBinder f3559a;

    /* renamed from: b */
    public final String f3560b;

    public C1213ji(IBinder iBinder, String str) {
        this.f3559a = iBinder;
        this.f3560b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f3559a;
    }

    /* renamed from: q */
    public final Parcel m5117q() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f3560b);
        return obtain;
    }

    /* renamed from: r */
    public final void m5118r(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f3559a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
