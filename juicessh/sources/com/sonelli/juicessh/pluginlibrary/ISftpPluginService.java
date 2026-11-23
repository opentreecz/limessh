package com.sonelli.juicessh.pluginlibrary;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.sonelli.juicessh.pluginlibrary.listeners.IAttributesEntryListener;
import com.sonelli.juicessh.pluginlibrary.listeners.ICommandSuccessListener;
import com.sonelli.juicessh.pluginlibrary.listeners.IStatResultListener;
import com.sonelli.juicessh.pluginlibrary.listeners.IStringResultListener;

/* loaded from: classes.dex */
public interface ISftpPluginService extends IInterface {

    /* renamed from: com.sonelli.juicessh.pluginlibrary.ISftpPluginService$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC1355a extends Binder implements ISftpPluginService {
        public AbstractBinderC1355a() {
            attachInterface(this, "com.sonelli.juicessh.pluginlibrary.ISftpPluginService");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("com.sonelli.juicessh.pluginlibrary.ISftpPluginService");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.ISftpPluginService");
                    mo5557C(parcel.readInt(), parcel.readString(), parcel.readString(), ICommandSuccessListener.AbstractBinderC1357a.m5579q(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.ISftpPluginService");
                    mo5560M(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), ICommandSuccessListener.AbstractBinderC1357a.m5579q(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.ISftpPluginService");
                    mo5565n0(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), ICommandSuccessListener.AbstractBinderC1357a.m5579q(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.ISftpPluginService");
                    mo5566q0(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), ICommandSuccessListener.AbstractBinderC1357a.m5579q(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.ISftpPluginService");
                    mo5563W(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), ICommandSuccessListener.AbstractBinderC1357a.m5579q(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.ISftpPluginService");
                    mo5569w(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), ICommandSuccessListener.AbstractBinderC1357a.m5579q(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.ISftpPluginService");
                    mo5567r0(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), ICommandSuccessListener.AbstractBinderC1357a.m5579q(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.ISftpPluginService");
                    mo5559I(parcel.readInt(), parcel.readString(), parcel.createStringArray(), parcel.createStringArray(), parcel.createStringArray(), ICommandSuccessListener.AbstractBinderC1357a.m5579q(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.ISftpPluginService");
                    mo5556B0(parcel.readInt(), parcel.readString(), parcel.readString(), IAttributesEntryListener.AbstractBinderC1356a.m5574q(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.ISftpPluginService");
                    mo5568t(parcel.readInt(), parcel.readString(), IStringResultListener.AbstractBinderC1362a.m5600q(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.ISftpPluginService");
                    mo5570x0(parcel.readInt(), parcel.readString(), parcel.readString(), IStringResultListener.AbstractBinderC1362a.m5600q(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.ISftpPluginService");
                    mo5558F0(parcel.readInt(), parcel.readString(), parcel.readString(), ICommandSuccessListener.AbstractBinderC1357a.m5579q(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.ISftpPluginService");
                    mo5564e0(parcel.readInt(), parcel.readString(), parcel.readString(), ICommandSuccessListener.AbstractBinderC1357a.m5579q(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.ISftpPluginService");
                    mo5561N0(parcel.readInt(), parcel.readString(), parcel.readString(), IStatResultListener.AbstractBinderC1361a.m5595q(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface("com.sonelli.juicessh.pluginlibrary.ISftpPluginService");
                    String mo5562Q = mo5562Q(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(mo5562Q);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    /* renamed from: B0 */
    void mo5556B0(int i, String str, String str2, IAttributesEntryListener iAttributesEntryListener) throws RemoteException;

    /* renamed from: C */
    void mo5557C(int i, String str, String str2, ICommandSuccessListener iCommandSuccessListener) throws RemoteException;

    /* renamed from: F0 */
    void mo5558F0(int i, String str, String str2, ICommandSuccessListener iCommandSuccessListener) throws RemoteException;

    /* renamed from: I */
    void mo5559I(int i, String str, String[] strArr, String[] strArr2, String[] strArr3, ICommandSuccessListener iCommandSuccessListener) throws RemoteException;

    /* renamed from: M */
    void mo5560M(int i, String str, int i2, String str2, ICommandSuccessListener iCommandSuccessListener) throws RemoteException;

    /* renamed from: N0 */
    void mo5561N0(int i, String str, String str2, IStatResultListener iStatResultListener) throws RemoteException;

    /* renamed from: Q */
    String mo5562Q(int i) throws RemoteException;

    /* renamed from: W */
    void mo5563W(int i, String str, int i2, String str2, ICommandSuccessListener iCommandSuccessListener) throws RemoteException;

    /* renamed from: e0 */
    void mo5564e0(int i, String str, String str2, ICommandSuccessListener iCommandSuccessListener) throws RemoteException;

    /* renamed from: n0 */
    void mo5565n0(int i, String str, int i2, String str2, ICommandSuccessListener iCommandSuccessListener) throws RemoteException;

    /* renamed from: q0 */
    void mo5566q0(int i, String str, String str2, String str3, ICommandSuccessListener iCommandSuccessListener) throws RemoteException;

    /* renamed from: r0 */
    void mo5567r0(int i, String str, String str2, String str3, ICommandSuccessListener iCommandSuccessListener) throws RemoteException;

    /* renamed from: t */
    void mo5568t(int i, String str, IStringResultListener iStringResultListener) throws RemoteException;

    /* renamed from: w */
    void mo5569w(int i, String str, String str2, String str3, ICommandSuccessListener iCommandSuccessListener) throws RemoteException;

    /* renamed from: x0 */
    void mo5570x0(int i, String str, String str2, IStringResultListener iStringResultListener) throws RemoteException;
}
