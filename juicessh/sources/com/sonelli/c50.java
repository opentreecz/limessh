package com.sonelli;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zae;
import com.google.android.gms.signin.internal.zai;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public final class c50 extends C1929te implements zae {
    public c50(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.signin.internal.zae
    /* renamed from: K0 */
    public final void mo1507K0(zai zaiVar, zac zacVar) throws RemoteException {
        Parcel m8643q = m8643q();
        C2005ue.m8873c(m8643q, zaiVar);
        C2005ue.m8872b(m8643q, zacVar);
        m8645s(12, m8643q);
    }
}
