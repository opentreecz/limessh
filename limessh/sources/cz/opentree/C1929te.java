package cz.opentree;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.te */
/* loaded from: classes.dex */
public class C1929te implements IInterface {

    /* renamed from: a */
    public final IBinder f6759a;

    /* renamed from: b */
    public final String f6760b;

    public C1929te(IBinder iBinder, String str) {
        this.f6759a = iBinder;
        this.f6760b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f6759a;
    }

    /* renamed from: q */
    public final Parcel m8643q() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f6760b);
        return obtain;
    }

    /* renamed from: r */
    public final Parcel m8644r(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f6759a.transact(i, parcel, obtain, 0);
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

    /* renamed from: s */
    public final void m8645s(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f6759a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
