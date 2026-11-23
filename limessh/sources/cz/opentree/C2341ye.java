package cz.opentree;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.ye */
/* loaded from: classes.dex */
public class C2341ye implements IInterface {

    /* renamed from: a */
    public final IBinder f8197a;

    /* renamed from: b */
    public final String f8198b;

    public C2341ye(IBinder iBinder, String str) {
        this.f8197a = iBinder;
        this.f8198b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f8197a;
    }

    /* renamed from: q */
    public final Parcel m10125q() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f8198b);
        return obtain;
    }

    /* renamed from: r */
    public final Parcel m10126r(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f8197a.transact(i, parcel, obtain, 0);
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
