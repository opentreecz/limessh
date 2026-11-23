package com.sonelli;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import com.sonelli.C2224wi;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* renamed from: com.sonelli.cj */
/* loaded from: classes.dex */
public final class C0826cj extends C2224wi.a {

    /* renamed from: S */
    public final /* synthetic */ String f1952S;

    /* renamed from: T */
    public final /* synthetic */ C2224wi f1953T;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0826cj(C2224wi c2224wi, String str) {
        super(c2224wi);
        this.f1953T = c2224wi;
        this.f1952S = str;
    }

    @Override // com.sonelli.C2224wi.a
    /* renamed from: a */
    public final void mo2112a() throws RemoteException {
        zzr zzrVar;
        zzrVar = this.f1953T.f7726g;
        zzrVar.beginAdUnitExposure(this.f1952S, this.f7728P);
    }
}
