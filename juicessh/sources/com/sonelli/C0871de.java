package com.sonelli;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: com.sonelli.de */
/* loaded from: classes.dex */
public class C0871de implements IInterface {

    /* renamed from: a */
    public final IBinder f2157a;

    /* renamed from: b */
    public final String f2158b;

    public C0871de(IBinder iBinder, String str) {
        this.f2157a = iBinder;
        this.f2158b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f2157a;
    }

    /* renamed from: q */
    public final Parcel m3193q() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f2158b);
        return obtain;
    }

    /* renamed from: r */
    public final void m3194r(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f2157a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
