package cz.opentree;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: cz.opentree.vd */
/* loaded from: classes.dex */
public class C2165vd implements IInterface {

    /* renamed from: a */
    public final IBinder f7446a;

    /* renamed from: b */
    public final String f7447b;

    public C2165vd(IBinder iBinder, String str) {
        this.f7446a = iBinder;
        this.f7447b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f7446a;
    }

    /* renamed from: q */
    public final Parcel m9211q() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f7447b);
        return obtain;
    }

    /* renamed from: r */
    public final Parcel m9212r(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f7446a.transact(i, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e) {
                obtain.recycle();
                throw e;
            }
        } finally {
            parcel.recycle();
        }
    }
}
