package com.sonelli;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.p006authapi.zzx;
import com.sonelli.C1632o4;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: com.sonelli.fe */
/* loaded from: classes.dex */
public final class C0984fe extends AbstractC2159v9<zzx> {

    /* renamed from: z */
    public final C1632o4.a f2666z;

    public C0984fe(Context context, Looper looper, C1850s9 c1850s9, C1632o4.a aVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 68, c1850s9, connectionCallbacks, onConnectionFailedListener);
        C1632o4.a.C2500a c2500a = new C1632o4.a.C2500a(aVar == null ? C1632o4.a.f5422R : aVar);
        c2500a.m6865a(C0707ae.m2045a());
        this.f2666z = c2500a.m6866b();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    /* renamed from: i */
    public final String mo1085i() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    /* renamed from: j */
    public final /* synthetic */ IInterface mo1086j(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        return queryLocalInterface instanceof zzx ? (zzx) queryLocalInterface : new C1105he(iBinder);
    }

    @Override // com.sonelli.AbstractC2159v9, com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    /* renamed from: l */
    public final int mo972l() {
        return 12800000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    /* renamed from: o */
    public final String mo1089o() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    /* renamed from: w */
    public final Bundle mo1097w() {
        return this.f2666z.m6864a();
    }
}
