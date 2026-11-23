package com.sonelli;

import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
/* loaded from: classes.dex */
public final class s30 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ zzs f6341O;

    /* renamed from: P */
    public final /* synthetic */ String f6342P;

    /* renamed from: Q */
    public final /* synthetic */ String f6343Q;

    /* renamed from: R */
    public final /* synthetic */ boolean f6344R;

    /* renamed from: S */
    public final /* synthetic */ AppMeasurementDynamiteService f6345S;

    public s30(AppMeasurementDynamiteService appMeasurementDynamiteService, zzs zzsVar, String str, String str2, boolean z) {
        this.f6345S = appMeasurementDynamiteService;
        this.f6341O = zzsVar;
        this.f6342P = str;
        this.f6343Q = str2;
        this.f6344R = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6345S.f979a.m9111Q().m3944J(this.f6341O, this.f6342P, this.f6343Q, this.f6344R);
    }
}
