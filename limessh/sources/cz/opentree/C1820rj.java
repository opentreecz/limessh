package cz.opentree;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import cz.opentree.C2224wi;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* renamed from: cz.opentree.rj */
/* loaded from: classes.dex */
public final class C1820rj extends C2224wi.a {

    /* renamed from: S */
    public final /* synthetic */ Activity f6221S;

    /* renamed from: T */
    public final /* synthetic */ Bundle f6222T;

    /* renamed from: U */
    public final /* synthetic */ C2224wi.c f6223U;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1820rj(C2224wi.c cVar, Activity activity, Bundle bundle) {
        super(C2224wi.this);
        this.f6223U = cVar;
        this.f6221S = activity;
        this.f6222T = bundle;
    }

    @Override // cz.opentree.C2224wi.a
    /* renamed from: a */
    public final void mo2112a() throws RemoteException {
        zzr zzrVar;
        zzrVar = C2224wi.this.f7726g;
        zzrVar.onActivityCreated(BinderC1548md.m6402O0(this.f6221S), this.f6222T, this.f7728P);
    }
}
