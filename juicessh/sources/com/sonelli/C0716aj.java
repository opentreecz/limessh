package com.sonelli;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import com.sonelli.C2224wi;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* renamed from: com.sonelli.aj */
/* loaded from: classes.dex */
public final class C0716aj extends C2224wi.a {

    /* renamed from: S */
    public final /* synthetic */ String f1413S;

    /* renamed from: T */
    public final /* synthetic */ String f1414T;

    /* renamed from: U */
    public final /* synthetic */ BinderC1981tt f1415U;

    /* renamed from: V */
    public final /* synthetic */ C2224wi f1416V;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0716aj(C2224wi c2224wi, String str, String str2, BinderC1981tt binderC1981tt) {
        super(c2224wi);
        this.f1416V = c2224wi;
        this.f1413S = str;
        this.f1414T = str2;
        this.f1415U = binderC1981tt;
    }

    @Override // com.sonelli.C2224wi.a
    /* renamed from: a */
    public final void mo2112a() throws RemoteException {
        zzr zzrVar;
        zzrVar = this.f1416V.f7726g;
        zzrVar.getConditionalUserProperties(this.f1413S, this.f1414T, this.f1415U);
    }

    @Override // com.sonelli.C2224wi.a
    /* renamed from: b */
    public final void mo2113b() {
        this.f1415U.mo1433j(null);
    }
}
