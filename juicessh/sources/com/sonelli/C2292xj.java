package com.sonelli;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import com.sonelli.C2224wi;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* renamed from: com.sonelli.xj */
/* loaded from: classes.dex */
public final class C2292xj extends C2224wi.a {

    /* renamed from: S */
    public final /* synthetic */ Activity f7969S;

    /* renamed from: T */
    public final /* synthetic */ BinderC1981tt f7970T;

    /* renamed from: U */
    public final /* synthetic */ C2224wi.c f7971U;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2292xj(C2224wi.c cVar, Activity activity, BinderC1981tt binderC1981tt) {
        super(C2224wi.this);
        this.f7971U = cVar;
        this.f7969S = activity;
        this.f7970T = binderC1981tt;
    }

    @Override // com.sonelli.C2224wi.a
    /* renamed from: a */
    public final void mo2112a() throws RemoteException {
        zzr zzrVar;
        zzrVar = C2224wi.this.f7726g;
        zzrVar.onActivitySaveInstanceState(BinderC1548md.m6402O0(this.f7969S), this.f7970T, this.f7728P);
    }
}
