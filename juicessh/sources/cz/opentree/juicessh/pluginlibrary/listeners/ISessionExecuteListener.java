package cz.opentree.juicessh.pluginlibrary.listeners;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ISessionExecuteListener extends IInterface {

    /* renamed from: cz.opentree.juicessh.pluginlibrary.listeners.ISessionExecuteListener$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC1359a extends Binder implements ISessionExecuteListener {

        /* renamed from: cz.opentree.juicessh.pluginlibrary.listeners.ISessionExecuteListener$a$a */
        /* loaded from: classes.dex */
        public static class a implements ISessionExecuteListener {

            /* renamed from: b */
            public static ISessionExecuteListener f4112b;

            /* renamed from: a */
            public IBinder f4113a;

            public a(IBinder iBinder) {
                this.f4113a = iBinder;
            }

            @Override // cz.opentree.juicessh.pluginlibrary.listeners.ISessionExecuteListener
            /* renamed from: N */
            public void mo5584N(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("cz.opentree.juicessh.pluginlibrary.listeners.ISessionExecuteListener");
                    obtain.writeString(str);
                    if (this.f4113a.transact(2, obtain, obtain2, 0) || AbstractBinderC1359a.m5588r() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC1359a.m5588r().mo5584N(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // cz.opentree.juicessh.pluginlibrary.listeners.ISessionExecuteListener
            /* renamed from: O */
            public void mo5585O(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("cz.opentree.juicessh.pluginlibrary.listeners.ISessionExecuteListener");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (this.f4113a.transact(3, obtain, obtain2, 0) || AbstractBinderC1359a.m5588r() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC1359a.m5588r().mo5585O(i, str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4113a;
            }

            @Override // cz.opentree.juicessh.pluginlibrary.listeners.ISessionExecuteListener
            /* renamed from: x */
            public void mo5586x(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("cz.opentree.juicessh.pluginlibrary.listeners.ISessionExecuteListener");
                    obtain.writeInt(i);
                    if (this.f4113a.transact(1, obtain, obtain2, 0) || AbstractBinderC1359a.m5588r() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC1359a.m5588r().mo5586x(i);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: q */
        public static ISessionExecuteListener m5587q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("cz.opentree.juicessh.pluginlibrary.listeners.ISessionExecuteListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ISessionExecuteListener)) ? new a(iBinder) : (ISessionExecuteListener) queryLocalInterface;
        }

        /* renamed from: r */
        public static ISessionExecuteListener m5588r() {
            return a.f4112b;
        }
    }

    /* renamed from: N */
    void mo5584N(String str) throws RemoteException;

    /* renamed from: O */
    void mo5585O(int i, String str) throws RemoteException;

    /* renamed from: x */
    void mo5586x(int i) throws RemoteException;
}
