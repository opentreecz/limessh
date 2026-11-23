package com.sonelli;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzn;
import com.google.android.gms.common.zzj;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.eb */
/* loaded from: classes.dex */
public final class C0920eb extends C2341ye implements zzn {
    public C0920eb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override // com.google.android.gms.common.internal.zzn
    /* renamed from: E0 */
    public final boolean mo1141E0(zzj zzjVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel m10125q = m10125q();
        C2423ze.m10431d(m10125q, zzjVar);
        C2423ze.m10430c(m10125q, iObjectWrapper);
        Parcel m10126r = m10126r(5, m10125q);
        boolean m10432e = C2423ze.m10432e(m10126r);
        m10126r.recycle();
        return m10432e;
    }
}
