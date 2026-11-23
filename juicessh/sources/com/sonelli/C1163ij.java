package com.sonelli;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import com.sonelli.C2224wi;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* renamed from: com.sonelli.ij */
/* loaded from: classes.dex */
public final class C1163ij extends C2224wi.a {

    /* renamed from: S */
    public final /* synthetic */ String f3330S;

    /* renamed from: T */
    public final /* synthetic */ String f3331T;

    /* renamed from: U */
    public final /* synthetic */ boolean f3332U;

    /* renamed from: V */
    public final /* synthetic */ BinderC1981tt f3333V;

    /* renamed from: W */
    public final /* synthetic */ C2224wi f3334W;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1163ij(C2224wi c2224wi, String str, String str2, boolean z, BinderC1981tt binderC1981tt) {
        super(c2224wi);
        this.f3334W = c2224wi;
        this.f3330S = str;
        this.f3331T = str2;
        this.f3332U = z;
        this.f3333V = binderC1981tt;
    }

    @Override // com.sonelli.C2224wi.a
    /* renamed from: a */
    public final void mo2112a() throws RemoteException {
        zzr zzrVar;
        zzrVar = this.f3334W.f7726g;
        zzrVar.getUserProperties(this.f3330S, this.f3331T, this.f3332U, this.f3333V);
    }

    @Override // com.sonelli.C2224wi.a
    /* renamed from: b */
    public final void mo2113b() {
        this.f3333V.mo1433j(null);
    }
}
