package com.sonelli.juicessh.pluginlibrary.listeners;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IStringResultListener extends IInterface {

    /* renamed from: com.sonelli.juicessh.pluginlibrary.listeners.IStringResultListener$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC1362a extends Binder implements IStringResultListener {

        /* renamed from: com.sonelli.juicessh.pluginlibrary.listeners.IStringResultListener$a$a */
        /* loaded from: classes.dex */
        public static class a implements IStringResultListener {

            /* renamed from: b */
            public static IStringResultListener f4118b;

            /* renamed from: a */
            public IBinder f4119a;

            public a(IBinder iBinder) {
                this.f4119a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4119a;
            }

            @Override // com.sonelli.juicessh.pluginlibrary.listeners.IStringResultListener
            /* renamed from: e */
            public void mo5597e(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.sonelli.juicessh.pluginlibrary.listeners.IStringResultListener");
                    obtain.writeString(str);
                    if (this.f4119a.transact(1, obtain, obtain2, 0) || AbstractBinderC1362a.m5601r() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC1362a.m5601r().mo5597e(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.sonelli.juicessh.pluginlibrary.listeners.IStringResultListener
            /* renamed from: f */
            public void mo5598f(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.sonelli.juicessh.pluginlibrary.listeners.IStringResultListener");
                    obtain.writeString(str);
                    if (this.f4119a.transact(3, obtain, obtain2, 0) || AbstractBinderC1362a.m5601r() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC1362a.m5601r().mo5598f(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.sonelli.juicessh.pluginlibrary.listeners.IStringResultListener
            /* renamed from: g */
            public void mo5599g(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.sonelli.juicessh.pluginlibrary.listeners.IStringResultListener");
                    obtain.writeString(str);
                    if (this.f4119a.transact(2, obtain, obtain2, 0) || AbstractBinderC1362a.m5601r() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC1362a.m5601r().mo5599g(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: q */
        public static IStringResultListener m5600q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.sonelli.juicessh.pluginlibrary.listeners.IStringResultListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IStringResultListener)) ? new a(iBinder) : (IStringResultListener) queryLocalInterface;
        }

        /* renamed from: r */
        public static IStringResultListener m5601r() {
            return a.f4118b;
        }
    }

    /* renamed from: e */
    void mo5597e(String str) throws RemoteException;

    /* renamed from: f */
    void mo5598f(String str) throws RemoteException;

    /* renamed from: g */
    void mo5599g(String str) throws RemoteException;
}
