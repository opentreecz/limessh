package cz.opentree;

import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
/* loaded from: classes.dex */
public final class t10 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ zzs f6687O;

    /* renamed from: P */
    public final /* synthetic */ AppMeasurementDynamiteService f6688P;

    public t10(AppMeasurementDynamiteService appMeasurementDynamiteService, zzs zzsVar) {
        this.f6688P = appMeasurementDynamiteService;
        this.f6687O = zzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6688P.f979a.m9111Q().m3941G(this.f6687O);
    }
}
