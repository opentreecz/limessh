package com.sonelli.juicessh.pluginlibrary.listeners;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.sonelli.juicessh.pluginlibrary.parcelables.ParcelableAttributesEntry;

/* loaded from: classes.dex */
public interface IStatResultListener extends IInterface {

    /* renamed from: com.sonelli.juicessh.pluginlibrary.listeners.IStatResultListener$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC1361a extends Binder implements IStatResultListener {

        /* renamed from: com.sonelli.juicessh.pluginlibrary.listeners.IStatResultListener$a$a */
        /* loaded from: classes.dex */
        public static class a implements IStatResultListener {

            /* renamed from: b */
            public static IStatResultListener f4116b;

            /* renamed from: a */
            public IBinder f4117a;

            public a(IBinder iBinder) {
                this.f4117a = iBinder;
            }

            @Override // com.sonelli.juicessh.pluginlibrary.listeners.IStatResultListener
            /* renamed from: S */
            public void mo5592S(ParcelableAttributesEntry parcelableAttributesEntry) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.sonelli.juicessh.pluginlibrary.listeners.IStatResultListener");
                    if (parcelableAttributesEntry != null) {
                        obtain.writeInt(1);
                        parcelableAttributesEntry.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f4117a.transact(1, obtain, obtain2, 0) || AbstractBinderC1361a.m5596r() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC1361a.m5596r().mo5592S(parcelableAttributesEntry);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4117a;
            }

            @Override // com.sonelli.juicessh.pluginlibrary.listeners.IStatResultListener
            /* renamed from: f */
            public void mo5593f(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.sonelli.juicessh.pluginlibrary.listeners.IStatResultListener");
                    obtain.writeString(str);
                    if (this.f4117a.transact(3, obtain, obtain2, 0) || AbstractBinderC1361a.m5596r() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC1361a.m5596r().mo5593f(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.sonelli.juicessh.pluginlibrary.listeners.IStatResultListener
            /* renamed from: g */
            public void mo5594g(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.sonelli.juicessh.pluginlibrary.listeners.IStatResultListener");
                    obtain.writeString(str);
                    if (this.f4117a.transact(2, obtain, obtain2, 0) || AbstractBinderC1361a.m5596r() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC1361a.m5596r().mo5594g(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: q */
        public static IStatResultListener m5595q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.sonelli.juicessh.pluginlibrary.listeners.IStatResultListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IStatResultListener)) ? new a(iBinder) : (IStatResultListener) queryLocalInterface;
        }

        /* renamed from: r */
        public static IStatResultListener m5596r() {
            return a.f4116b;
        }
    }

    /* renamed from: S */
    void mo5592S(ParcelableAttributesEntry parcelableAttributesEntry) throws RemoteException;

    /* renamed from: f */
    void mo5593f(String str) throws RemoteException;

    /* renamed from: g */
    void mo5594g(String str) throws RemoteException;
}
