package com.sonelli;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.gtm.zzbk;
import com.google.android.gms.internal.gtm.zzce;
import java.util.List;
import java.util.Map;

/* renamed from: com.sonelli.hh */
/* loaded from: classes.dex */
public final class C1108hh extends C1213ji implements zzce {
    public C1108hh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.analytics.internal.IAnalyticsService");
    }

    @Override // com.google.android.gms.internal.gtm.zzce
    /* renamed from: z0 */
    public final void mo1216z0(Map map, long j, String str, List<zzbk> list) throws RemoteException {
        Parcel m5117q = m5117q();
        m5117q.writeMap(map);
        m5117q.writeLong(j);
        m5117q.writeString(str);
        m5117q.writeTypedList(list);
        m5118r(1, m5117q);
    }
}
