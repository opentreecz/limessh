package cz.opentree;

import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
/* loaded from: classes.dex */
public final class k40 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ zzs f4476O;

    /* renamed from: P */
    public final /* synthetic */ AppMeasurementDynamiteService f4477P;

    public k40(AppMeasurementDynamiteService appMeasurementDynamiteService, zzs zzsVar) {
        this.f4477P = appMeasurementDynamiteService;
        this.f4476O = zzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4477P.f979a.m9102H().m4034T(this.f4476O, this.f4477P.f979a.m9121p());
    }
}
