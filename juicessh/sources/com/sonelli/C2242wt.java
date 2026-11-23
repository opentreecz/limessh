package com.sonelli;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzs;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.wt */
/* loaded from: classes.dex */
public final class C2242wt extends C2011ui implements zzs {
    public C2242wt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // com.google.android.gms.internal.measurement.zzs
    /* renamed from: j */
    public final void mo1433j(Bundle bundle) throws RemoteException {
        Parcel m8894q = m8894q();
        C1557mj.m6428c(m8894q, bundle);
        m8896s(1, m8894q);
    }
}
