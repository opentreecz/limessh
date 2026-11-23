package com.sonelli.juicessh.pluginlibrary;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.sonelli.juicessh.pluginlibrary.listeners.IPingListener;
import com.sonelli.juicessh.pluginlibrary.listeners.ISessionExecuteListener;
import com.sonelli.juicessh.pluginlibrary.listeners.ISessionFinishedListener;

/* loaded from: classes.dex */
public interface IPluginService extends IInterface {

    /* renamed from: com.sonelli.juicessh.pluginlibrary.IPluginService$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC1354a extends Binder implements IPluginService {
        public AbstractBinderC1354a() {
            attachInterface(this, "com.sonelli.juicessh.pluginlibrary.IPluginService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.sonelli.juicessh.pluginlibrary.IPluginService");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.IPluginService");
                    mo5552l(IPingListener.AbstractBinderC1358a.m5582q(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.IPluginService");
                    mo5551k(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.IPluginService");
                    mo5554o(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.IPluginService");
                    mo5553n(parcel.readInt(), parcel.readString(), ISessionFinishedListener.AbstractBinderC1360a.m5590q(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.IPluginService");
                    mo5549Z(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.IPluginService");
                    mo5555w0(parcel.readInt(), parcel.readString(), parcel.readString(), ISessionExecuteListener.AbstractBinderC1359a.m5587q(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.IPluginService");
                    mo5550f0(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: Z */
    void mo5549Z(int i, String str) throws RemoteException;

    /* renamed from: f0 */
    void mo5550f0(int i, String str, String str2) throws RemoteException;

    /* renamed from: k */
    void mo5551k(String str) throws RemoteException;

    /* renamed from: l */
    void mo5552l(IPingListener iPingListener) throws RemoteException;

    /* renamed from: n */
    void mo5553n(int i, String str, ISessionFinishedListener iSessionFinishedListener) throws RemoteException;

    /* renamed from: o */
    void mo5554o(int i, String str) throws RemoteException;

    /* renamed from: w0 */
    void mo5555w0(int i, String str, String str2, ISessionExecuteListener iSessionExecuteListener) throws RemoteException;
}
