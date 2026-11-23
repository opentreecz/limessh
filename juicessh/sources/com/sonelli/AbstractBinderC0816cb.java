package com.sonelli;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.cb */
/* loaded from: classes.dex */
public abstract class AbstractBinderC0816cb extends BinderC2274xe implements zzi {
    public AbstractBinderC0816cb() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    /* renamed from: r */
    public static zzi m2747r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return queryLocalInterface instanceof zzi ? (zzi) queryLocalInterface : new C0761bb(iBinder);
    }

    @Override // com.sonelli.BinderC2274xe
    /* renamed from: q */
    public final boolean mo1120q(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            IObjectWrapper mo1139b = mo1139b();
            parcel2.writeNoException();
            C2423ze.m10430c(parcel2, mo1139b);
        } else {
            if (i != 2) {
                return false;
            }
            int mo1140c = mo1140c();
            parcel2.writeNoException();
            parcel2.writeInt(mo1140c);
        }
        return true;
    }
}
