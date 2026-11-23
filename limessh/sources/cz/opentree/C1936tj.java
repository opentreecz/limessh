package cz.opentree;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import cz.opentree.C2224wi;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* renamed from: cz.opentree.tj */
/* loaded from: classes.dex */
public final class C1936tj extends C2224wi.a {

    /* renamed from: S */
    public final /* synthetic */ Activity f6787S;

    /* renamed from: T */
    public final /* synthetic */ C2224wi.c f6788T;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1936tj(C2224wi.c cVar, Activity activity) {
        super(C2224wi.this);
        this.f6788T = cVar;
        this.f6787S = activity;
    }

    @Override // cz.opentree.C2224wi.a
    /* renamed from: a */
    public final void mo2112a() throws RemoteException {
        zzr zzrVar;
        zzrVar = C2224wi.this.f7726g;
        zzrVar.onActivityStarted(BinderC1548md.m6402O0(this.f6787S), this.f7728P);
    }
}
