package com.sonelli;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import com.sonelli.C2224wi;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* renamed from: com.sonelli.kj */
/* loaded from: classes.dex */
public final class C1459kj extends C2224wi.a {

    /* renamed from: T */
    public final /* synthetic */ String f4575T;

    /* renamed from: U */
    public final /* synthetic */ Object f4576U;

    /* renamed from: X */
    public final /* synthetic */ C2224wi f4579X;

    /* renamed from: S */
    public final /* synthetic */ int f4574S = 5;

    /* renamed from: V */
    public final /* synthetic */ Object f4577V = null;

    /* renamed from: W */
    public final /* synthetic */ Object f4578W = null;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1459kj(C2224wi c2224wi, boolean z, int i, String str, Object obj, Object obj2, Object obj3) {
        super(false);
        this.f4579X = c2224wi;
        this.f4575T = str;
        this.f4576U = obj;
    }

    @Override // com.sonelli.C2224wi.a
    /* renamed from: a */
    public final void mo2112a() throws RemoteException {
        zzr zzrVar;
        zzrVar = this.f4579X.f7726g;
        zzrVar.logHealthData(this.f4574S, this.f4575T, BinderC1548md.m6402O0(this.f4576U), BinderC1548md.m6402O0(this.f4577V), BinderC1548md.m6402O0(this.f4578W));
    }
}
