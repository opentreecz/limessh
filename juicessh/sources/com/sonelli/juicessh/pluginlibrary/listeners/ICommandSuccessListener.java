package com.sonelli.juicessh.pluginlibrary.listeners;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ICommandSuccessListener extends IInterface {

    /* renamed from: com.sonelli.juicessh.pluginlibrary.listeners.ICommandSuccessListener$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC1357a extends Binder implements ICommandSuccessListener {

        /* renamed from: com.sonelli.juicessh.pluginlibrary.listeners.ICommandSuccessListener$a$a */
        /* loaded from: classes.dex */
        public static class a implements ICommandSuccessListener {

            /* renamed from: b */
            public static ICommandSuccessListener f4108b;

            /* renamed from: a */
            public IBinder f4109a;

            public a(IBinder iBinder) {
                this.f4109a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4109a;
            }

            @Override // com.sonelli.juicessh.pluginlibrary.listeners.ICommandSuccessListener
            /* renamed from: d */
            public void mo5576d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.sonelli.juicessh.pluginlibrary.listeners.ICommandSuccessListener");
                    if (this.f4109a.transact(1, obtain, obtain2, 0) || AbstractBinderC1357a.m5580r() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC1357a.m5580r().mo5576d();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.sonelli.juicessh.pluginlibrary.listeners.ICommandSuccessListener
            /* renamed from: f */
            public void mo5577f(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.sonelli.juicessh.pluginlibrary.listeners.ICommandSuccessListener");
                    obtain.writeString(str);
                    if (this.f4109a.transact(3, obtain, obtain2, 0) || AbstractBinderC1357a.m5580r() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC1357a.m5580r().mo5577f(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.sonelli.juicessh.pluginlibrary.listeners.ICommandSuccessListener
            /* renamed from: g */
            public void mo5578g(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.sonelli.juicessh.pluginlibrary.listeners.ICommandSuccessListener");
                    obtain.writeString(str);
                    if (this.f4109a.transact(2, obtain, obtain2, 0) || AbstractBinderC1357a.m5580r() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC1357a.m5580r().mo5578g(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: q */
        public static ICommandSuccessListener m5579q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.sonelli.juicessh.pluginlibrary.listeners.ICommandSuccessListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ICommandSuccessListener)) ? new a(iBinder) : (ICommandSuccessListener) queryLocalInterface;
        }

        /* renamed from: r */
        public static ICommandSuccessListener m5580r() {
            return a.f4108b;
        }
    }

    /* renamed from: d */
    void mo5576d() throws RemoteException;

    /* renamed from: f */
    void mo5577f(String str) throws RemoteException;

    /* renamed from: g */
    void mo5578g(String str) throws RemoteException;
}
