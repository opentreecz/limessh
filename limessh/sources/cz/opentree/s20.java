package cz.opentree;

import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.4.1 */
/* loaded from: classes.dex */
public final class s20 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ zzs f6334O;

    /* renamed from: P */
    public final /* synthetic */ String f6335P;

    /* renamed from: Q */
    public final /* synthetic */ String f6336Q;

    /* renamed from: R */
    public final /* synthetic */ AppMeasurementDynamiteService f6337R;

    public s20(AppMeasurementDynamiteService appMeasurementDynamiteService, zzs zzsVar, String str, String str2) {
        this.f6337R = appMeasurementDynamiteService;
        this.f6334O = zzsVar;
        this.f6335P = str;
        this.f6336Q = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6337R.f979a.m9111Q().m3943I(this.f6334O, this.f6335P, this.f6336Q);
    }
}
