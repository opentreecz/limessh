package com.sonelli;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import com.sonelli.C2224wi;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* renamed from: com.sonelli.wj */
/* loaded from: classes.dex */
public final class C2226wj extends C2224wi.a {

    /* renamed from: S */
    public final /* synthetic */ Activity f7750S;

    /* renamed from: T */
    public final /* synthetic */ C2224wi.c f7751T;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2226wj(C2224wi.c cVar, Activity activity) {
        super(C2224wi.this);
        this.f7751T = cVar;
        this.f7750S = activity;
    }

    @Override // com.sonelli.C2224wi.a
    /* renamed from: a */
    public final void mo2112a() throws RemoteException {
        zzr zzrVar;
        zzrVar = C2224wi.this.f7726g;
        zzrVar.onActivityDestroyed(BinderC1548md.m6402O0(this.f7750S), this.f7728P);
    }
}
