package com.sonelli;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import com.sonelli.C2224wi;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* renamed from: com.sonelli.yi */
/* loaded from: classes.dex */
public final class C2348yi extends C2224wi.a {

    /* renamed from: S */
    public final /* synthetic */ String f8224S;

    /* renamed from: T */
    public final /* synthetic */ String f8225T;

    /* renamed from: U */
    public final /* synthetic */ Bundle f8226U;

    /* renamed from: V */
    public final /* synthetic */ C2224wi f8227V;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2348yi(C2224wi c2224wi, String str, String str2, Bundle bundle) {
        super(c2224wi);
        this.f8227V = c2224wi;
        this.f8224S = str;
        this.f8225T = str2;
        this.f8226U = bundle;
    }

    @Override // com.sonelli.C2224wi.a
    /* renamed from: a */
    public final void mo2112a() throws RemoteException {
        zzr zzrVar;
        zzrVar = this.f8227V.f7726g;
        zzrVar.clearConditionalUserProperty(this.f8224S, this.f8225T, this.f8226U);
    }
}
