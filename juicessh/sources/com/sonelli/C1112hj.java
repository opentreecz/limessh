package com.sonelli;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import com.sonelli.C2224wi;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* renamed from: com.sonelli.hj */
/* loaded from: classes.dex */
public final class C1112hj extends C2224wi.a {

    /* renamed from: S */
    public final /* synthetic */ BinderC1981tt f3163S;

    /* renamed from: T */
    public final /* synthetic */ C2224wi f3164T;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1112hj(C2224wi c2224wi, BinderC1981tt binderC1981tt) {
        super(c2224wi);
        this.f3164T = c2224wi;
        this.f3163S = binderC1981tt;
    }

    @Override // com.sonelli.C2224wi.a
    /* renamed from: a */
    public final void mo2112a() throws RemoteException {
        zzr zzrVar;
        zzrVar = this.f3164T.f7726g;
        zzrVar.generateEventId(this.f3163S);
    }

    @Override // com.sonelli.C2224wi.a
    /* renamed from: b */
    public final void mo2113b() {
        this.f3163S.mo1433j(null);
    }
}
