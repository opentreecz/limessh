package com.sonelli.juicessh.pluginlibrary.listeners;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface ISessionFinishedListener extends IInterface {

    /* renamed from: com.sonelli.juicessh.pluginlibrary.listeners.ISessionFinishedListener$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC1360a extends Binder implements ISessionFinishedListener {

        /* renamed from: com.sonelli.juicessh.pluginlibrary.listeners.ISessionFinishedListener$a$a */
        /* loaded from: classes.dex */
        public static class a implements ISessionFinishedListener {

            /* renamed from: b */
            public static ISessionFinishedListener f4114b;

            /* renamed from: a */
            public IBinder f4115a;

            public a(IBinder iBinder) {
                this.f4115a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f4115a;
            }

            @Override // com.sonelli.juicessh.pluginlibrary.listeners.ISessionFinishedListener
            /* renamed from: t0 */
            public void mo5589t0() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.sonelli.juicessh.pluginlibrary.listeners.ISessionFinishedListener");
                    if (this.f4115a.transact(1, obtain, obtain2, 0) || AbstractBinderC1360a.m5591r() == null) {
                        obtain2.readException();
                    } else {
                        AbstractBinderC1360a.m5591r().mo5589t0();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        /* renamed from: q */
        public static ISessionFinishedListener m5590q(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.sonelli.juicessh.pluginlibrary.listeners.ISessionFinishedListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ISessionFinishedListener)) ? new a(iBinder) : (ISessionFinishedListener) queryLocalInterface;
        }

        /* renamed from: r */
        public static ISessionFinishedListener m5591r() {
            return a.f4114b;
        }
    }

    /* renamed from: t0 */
    void mo5589t0() throws RemoteException;
}
