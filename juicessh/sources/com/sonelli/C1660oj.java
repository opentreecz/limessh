package com.sonelli;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import com.sonelli.C2224wi;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* renamed from: com.sonelli.oj */
/* loaded from: classes.dex */
public final class C1660oj extends C2224wi.a {

    /* renamed from: S */
    public final /* synthetic */ boolean f5500S;

    /* renamed from: T */
    public final /* synthetic */ C2224wi f5501T;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1660oj(C2224wi c2224wi, boolean z) {
        super(c2224wi);
        this.f5501T = c2224wi;
        this.f5500S = z;
    }

    @Override // com.sonelli.C2224wi.a
    /* renamed from: a */
    public final void mo2112a() throws RemoteException {
        zzr zzrVar;
        zzrVar = this.f5501T.f7726g;
        zzrVar.setDataCollectionEnabled(this.f5500S);
    }
}
