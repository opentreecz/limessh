package com.sonelli.juicessh.pluginlibrary;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.sonelli.juicessh.pluginlibrary.listeners.IPingListener;
import com.sonelli.juicessh.pluginlibrary.listeners.ISessionFinishedListener;

/* loaded from: classes.dex */
public interface IConnectionPluginService extends IInterface {

    /* renamed from: com.sonelli.juicessh.pluginlibrary.IConnectionPluginService$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC1353a extends Binder implements IConnectionPluginService {
        public AbstractBinderC1353a() {
            attachInterface(this, "com.sonelli.juicessh.pluginlibrary.IConnectionPluginService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.IConnectionPluginService");
                mo5546l(IPingListener.AbstractBinderC1358a.m5582q(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.IConnectionPluginService");
                mo5545k(parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.IConnectionPluginService");
                mo5548o(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i != 4) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.sonelli.juicessh.pluginlibrary.IConnectionPluginService");
                return true;
            }
            parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.IConnectionPluginService");
            mo5547n(parcel.readInt(), parcel.readString(), ISessionFinishedListener.AbstractBinderC1360a.m5590q(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: k */
    void mo5545k(String str) throws RemoteException;

    /* renamed from: l */
    void mo5546l(IPingListener iPingListener) throws RemoteException;

    /* renamed from: n */
    void mo5547n(int i, String str, ISessionFinishedListener iSessionFinishedListener) throws RemoteException;

    /* renamed from: o */
    void mo5548o(int i, String str) throws RemoteException;
}
