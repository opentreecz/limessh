package com.sonelli;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.measurement.zzd;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.jo */
/* loaded from: classes.dex */
public abstract class AbstractBinderC1229jo extends BinderC2357yk implements zzd {
    /* renamed from: r */
    public static zzd m5173r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
        return queryLocalInterface instanceof zzd ? (zzd) queryLocalInterface : new C1726pn(iBinder);
    }
}
