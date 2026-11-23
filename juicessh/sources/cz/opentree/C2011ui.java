package cz.opentree;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.ui */
/* loaded from: classes.dex */
public class C2011ui implements IInterface {

    /* renamed from: a */
    public final IBinder f6969a;

    /* renamed from: b */
    public final String f6970b;

    public C2011ui(IBinder iBinder, String str) {
        this.f6969a = iBinder;
        this.f6970b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f6969a;
    }

    /* renamed from: q */
    public final Parcel m8894q() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f6970b);
        return obtain;
    }

    /* renamed from: r */
    public final Parcel m8895r(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f6969a.transact(i, parcel, obtain, 0);
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
    public final void m8896s(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.f6969a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
