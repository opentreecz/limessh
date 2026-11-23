package com.sonelli;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.ads_identifier.zze;

/* renamed from: com.sonelli.yd */
/* loaded from: classes.dex */
public abstract class AbstractBinderC2340yd extends BinderC2214wd implements zze {
    /* renamed from: q */
    public static zze m10124q(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        return queryLocalInterface instanceof zze ? (zze) queryLocalInterface : new C2422zd(iBinder);
    }
}
