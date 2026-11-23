package com.sonelli;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import com.sonelli.C2224wi;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* renamed from: com.sonelli.ej */
/* loaded from: classes.dex */
public final class C0937ej extends C2224wi.a {

    /* renamed from: S */
    public final /* synthetic */ BinderC1981tt f2424S;

    /* renamed from: T */
    public final /* synthetic */ C2224wi f2425T;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0937ej(C2224wi c2224wi, BinderC1981tt binderC1981tt) {
        super(c2224wi);
        this.f2425T = c2224wi;
        this.f2424S = binderC1981tt;
    }

    @Override // com.sonelli.C2224wi.a
    /* renamed from: a */
    public final void mo2112a() throws RemoteException {
        zzr zzrVar;
        zzrVar = this.f2425T.f7726g;
        zzrVar.getCachedAppInstanceId(this.f2424S);
    }

    @Override // com.sonelli.C2224wi.a
    /* renamed from: b */
    public final void mo2113b() {
        this.f2424S.mo1433j(null);
    }
}
