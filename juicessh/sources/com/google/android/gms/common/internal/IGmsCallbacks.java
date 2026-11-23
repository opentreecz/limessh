package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.sonelli.BinderC2274xe;
import com.sonelli.C2423ze;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes.dex */
public interface IGmsCallbacks extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* renamed from: com.google.android.gms.common.internal.IGmsCallbacks$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0445a extends BinderC2274xe implements IGmsCallbacks {
        public AbstractBinderC0445a() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        @Override // com.sonelli.BinderC2274xe
        /* renamed from: q */
        public final boolean mo1120q(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                mo1117l0(parcel.readInt(), parcel.readStrongBinder(), (Bundle) C2423ze.m10429b(parcel, Bundle.CREATOR));
            } else if (i == 2) {
                mo1115d0(parcel.readInt(), (Bundle) C2423ze.m10429b(parcel, Bundle.CREATOR));
            } else {
                if (i != 3) {
                    return false;
                }
                mo1116k0(parcel.readInt(), parcel.readStrongBinder(), (zza) C2423ze.m10429b(parcel, zza.CREATOR));
            }
            parcel2.writeNoException();
            return true;
        }
    }

    /* renamed from: d0 */
    void mo1115d0(int i, Bundle bundle) throws RemoteException;

    /* renamed from: k0 */
    void mo1116k0(int i, IBinder iBinder, zza zzaVar) throws RemoteException;

    /* renamed from: l0 */
    void mo1117l0(int i, IBinder iBinder, Bundle bundle) throws RemoteException;
}
