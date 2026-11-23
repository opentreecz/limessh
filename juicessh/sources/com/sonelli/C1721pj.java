package com.sonelli;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import com.sonelli.C2224wi;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* renamed from: com.sonelli.pj */
/* loaded from: classes.dex */
public final class C1721pj extends C2224wi.a {

    /* renamed from: S */
    public final /* synthetic */ Long f5706S;

    /* renamed from: T */
    public final /* synthetic */ String f5707T;

    /* renamed from: U */
    public final /* synthetic */ String f5708U;

    /* renamed from: V */
    public final /* synthetic */ Bundle f5709V;

    /* renamed from: W */
    public final /* synthetic */ boolean f5710W;

    /* renamed from: X */
    public final /* synthetic */ boolean f5711X;

    /* renamed from: Y */
    public final /* synthetic */ C2224wi f5712Y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1721pj(C2224wi c2224wi, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(c2224wi);
        this.f5712Y = c2224wi;
        this.f5706S = l;
        this.f5707T = str;
        this.f5708U = str2;
        this.f5709V = bundle;
        this.f5710W = z;
        this.f5711X = z2;
    }

    @Override // com.sonelli.C2224wi.a
    /* renamed from: a */
    public final void mo2112a() throws RemoteException {
        zzr zzrVar;
        Long l = this.f5706S;
        long longValue = l == null ? this.f7727O : l.longValue();
        zzrVar = this.f5712Y.f7726g;
        zzrVar.logEvent(this.f5707T, this.f5708U, this.f5709V, this.f5710W, this.f5711X, longValue);
    }
}
