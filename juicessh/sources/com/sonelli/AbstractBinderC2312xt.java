package com.sonelli;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzs;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.xt */
/* loaded from: classes.dex */
public abstract class AbstractBinderC2312xt extends BinderC2357yk implements zzs {
    public AbstractBinderC2312xt() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // com.sonelli.BinderC2357yk
    /* renamed from: q */
    public final boolean mo6818q(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        mo1433j((Bundle) C1557mj.m6426a(parcel, Bundle.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
