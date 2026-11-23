package com.sonelli;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import com.sonelli.C2224wi;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* renamed from: com.sonelli.jj */
/* loaded from: classes.dex */
public final class C1218jj extends C2224wi.a {

    /* renamed from: S */
    public final /* synthetic */ BinderC1981tt f3586S;

    /* renamed from: T */
    public final /* synthetic */ C2224wi f3587T;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1218jj(C2224wi c2224wi, BinderC1981tt binderC1981tt) {
        super(c2224wi);
        this.f3587T = c2224wi;
        this.f3586S = binderC1981tt;
    }

    @Override // com.sonelli.C2224wi.a
    /* renamed from: a */
    public final void mo2112a() throws RemoteException {
        zzr zzrVar;
        zzrVar = this.f3587T.f7726g;
        zzrVar.getCurrentScreenClass(this.f3586S);
    }

    @Override // com.sonelli.C2224wi.a
    /* renamed from: b */
    public final void mo2113b() {
        this.f3586S.mo1433j(null);
    }
}
