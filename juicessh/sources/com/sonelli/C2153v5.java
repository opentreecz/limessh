package com.sonelli;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzv;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: com.sonelli.v5 */
/* loaded from: classes.dex */
public final class C2153v5 extends AbstractC0754b6<C1490l5> {

    /* renamed from: o */
    public final /* synthetic */ Context f7405o;

    /* renamed from: p */
    public final /* synthetic */ GoogleSignInOptions f7406p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2153v5(GoogleApiClient googleApiClient, Context context, GoogleSignInOptions googleSignInOptions) {
        super(googleApiClient);
        this.f7405o = context;
        this.f7406p = googleSignInOptions;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    /* renamed from: c */
    public final /* synthetic */ Result mo1010c(Status status) {
        return new C1490l5(null, status);
    }

    @Override // com.sonelli.AbstractC1802r7
    /* renamed from: n */
    public final /* synthetic */ void mo7883n(C1900t5 c1900t5) throws RemoteException {
        ((zzv) c1900t5.m1100z()).mo949H0(new BinderC1994u5(this), this.f7406p);
    }
}
