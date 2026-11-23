package cz.opentree.limessh.pluginlibrary.listeners;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IPingListener extends IInterface {

    /* renamed from: cz.opentree.limessh.pluginlibrary.listeners.IPingListener$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC1358a extends Binder implements IPingListener {

        /* renamed from: cz.opentree.limessh.pluginlibrary.listeners.IPingListener$a$a */
        /* loaded from: classes.dex */
        public static class a implements IPingListener {

            /* renamed from: b */
            public static IPingListener f4110b;

            /* renamed from: a */
            public IBinder f4111a;

            public a(IBinder iBinder) {
                this.f4111a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4111a;
            }

            @Override // cz.opentree.limessh.pluginlibrary.listeners.IPingListener
            /* renamed from: z */
            public void mo5581z() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("cz.opentree.limessh.pluginlibrary.listeners.IPingListener");
                    if (this.f4111a.transact(1, obtain, obtain2, 0) || AbstractBinderC1358a.m5583r() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC1358a.m5583r().mo5581z();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: q */
        public static IPingListener m5582q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("cz.opentree.limessh.pluginlibrary.listeners.IPingListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IPingListener)) ? new a(iBinder) : (IPingListener) queryLocalInterface;
        }

        /* renamed from: r */
        public static IPingListener m5583r() {
            return a.f4110b;
        }
    }

    /* renamed from: z */
    void mo5581z() throws RemoteException;
}
