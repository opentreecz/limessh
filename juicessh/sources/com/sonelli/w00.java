package com.sonelli;

import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import com.google.android.gms.measurement.internal.zzaq;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
/* loaded from: classes.dex */
public final class w00 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ zzs f7580O;

    /* renamed from: P */
    public final /* synthetic */ zzaq f7581P;

    /* renamed from: Q */
    public final /* synthetic */ String f7582Q;

    /* renamed from: R */
    public final /* synthetic */ AppMeasurementDynamiteService f7583R;

    public w00(AppMeasurementDynamiteService appMeasurementDynamiteService, zzs zzsVar, zzaq zzaqVar, String str) {
        this.f7583R = appMeasurementDynamiteService;
        this.f7580O = zzsVar;
        this.f7581P = zzaqVar;
        this.f7582Q = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7583R.f979a.m9111Q().m3942H(this.f7580O, this.f7581P, this.f7582Q);
    }
}
