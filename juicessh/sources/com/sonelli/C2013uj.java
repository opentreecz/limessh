package com.sonelli;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import com.sonelli.C2224wi;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* renamed from: com.sonelli.uj */
/* loaded from: classes.dex */
public final class C2013uj extends C2224wi.a {

    /* renamed from: S */
    public final /* synthetic */ Activity f6983S;

    /* renamed from: T */
    public final /* synthetic */ C2224wi.c f6984T;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2013uj(C2224wi.c cVar, Activity activity) {
        super(C2224wi.this);
        this.f6984T = cVar;
        this.f6983S = activity;
    }

    @Override // com.sonelli.C2224wi.a
    /* renamed from: a */
    public final void mo2112a() throws RemoteException {
        zzr zzrVar;
        zzrVar = C2224wi.this.f7726g;
        zzrVar.onActivityStopped(BinderC1548md.m6402O0(this.f6983S), this.f7728P);
    }
}
