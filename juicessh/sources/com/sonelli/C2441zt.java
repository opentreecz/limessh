package com.sonelli;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.zt */
/* loaded from: classes.dex */
public final class C2441zt extends C2011ui implements zzx {
    public C2441zt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.zzx
    /* renamed from: a */
    public final int mo1434a() throws RemoteException {
        Parcel m8895r = m8895r(2, m8894q());
        int readInt = m8895r.readInt();
        m8895r.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.measurement.zzx
    /* renamed from: s0 */
    public final void mo1435s0(String str, String str2, Bundle bundle, long j) throws RemoteException {
        Parcel m8894q = m8894q();
        m8894q.writeString(str);
        m8894q.writeString(str2);
        C1557mj.m6428c(m8894q, bundle);
        m8894q.writeLong(j);
        m8896s(1, m8894q);
    }
}
