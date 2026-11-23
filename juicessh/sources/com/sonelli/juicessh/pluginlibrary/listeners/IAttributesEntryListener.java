package com.sonelli.juicessh.pluginlibrary.listeners;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.sonelli.juicessh.pluginlibrary.parcelables.ParcelableAttributesEntry;

/* loaded from: classes.dex */
public interface IAttributesEntryListener extends IInterface {

    /* renamed from: com.sonelli.juicessh.pluginlibrary.listeners.IAttributesEntryListener$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC1356a extends Binder implements IAttributesEntryListener {

        /* renamed from: com.sonelli.juicessh.pluginlibrary.listeners.IAttributesEntryListener$a$a */
        /* loaded from: classes.dex */
        public static class a implements IAttributesEntryListener {

            /* renamed from: b */
            public static IAttributesEntryListener f4106b;

            /* renamed from: a */
            public IBinder f4107a;

            public a(IBinder iBinder) {
                this.f4107a = iBinder;
            }

            @Override // com.sonelli.juicessh.pluginlibrary.listeners.IAttributesEntryListener
            /* renamed from: J0 */
            public void mo5571J0(ParcelableAttributesEntry[] parcelableAttributesEntryArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.sonelli.juicessh.pluginlibrary.listeners.IAttributesEntryListener");
                    obtain.writeTypedArray(parcelableAttributesEntryArr, 0);
                    if (this.f4107a.transact(1, obtain, obtain2, 0) || AbstractBinderC1356a.m5575r() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC1356a.m5575r().mo5571J0(parcelableAttributesEntryArr);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4107a;
            }

            @Override // com.sonelli.juicessh.pluginlibrary.listeners.IAttributesEntryListener
            /* renamed from: f */
            public void mo5572f(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.sonelli.juicessh.pluginlibrary.listeners.IAttributesEntryListener");
                    obtain.writeString(str);
                    if (this.f4107a.transact(3, obtain, obtain2, 0) || AbstractBinderC1356a.m5575r() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC1356a.m5575r().mo5572f(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.sonelli.juicessh.pluginlibrary.listeners.IAttributesEntryListener
            /* renamed from: g */
            public void mo5573g(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.sonelli.juicessh.pluginlibrary.listeners.IAttributesEntryListener");
                    obtain.writeString(str);
                    if (this.f4107a.transact(2, obtain, obtain2, 0) || AbstractBinderC1356a.m5575r() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC1356a.m5575r().mo5573g(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: q */
        public static IAttributesEntryListener m5574q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.sonelli.juicessh.pluginlibrary.listeners.IAttributesEntryListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IAttributesEntryListener)) ? new a(iBinder) : (IAttributesEntryListener) queryLocalInterface;
        }

        /* renamed from: r */
        public static IAttributesEntryListener m5575r() {
            return a.f4106b;
        }
    }

    /* renamed from: J0 */
    void mo5571J0(ParcelableAttributesEntry[] parcelableAttributesEntryArr) throws RemoteException;

    /* renamed from: f */
    void mo5572f(String str) throws RemoteException;

    /* renamed from: g */
    void mo5573g(String str) throws RemoteException;
}
