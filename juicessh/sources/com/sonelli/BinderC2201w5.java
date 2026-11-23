package com.sonelli;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: com.sonelli.w5 */
/* loaded from: classes.dex */
public final class BinderC2201w5 extends BinderC1748q5 {

    /* renamed from: a */
    public final /* synthetic */ C2258x5 f7620a;

    public BinderC2201w5(C2258x5 c2258x5) {
        this.f7620a = c2258x5;
    }

    @Override // com.sonelli.BinderC1748q5, com.google.android.gms.auth.api.signin.internal.zzt
    /* renamed from: y */
    public final void mo946y(Status status) throws RemoteException {
        this.f7620a.m1013f(status);
    }
}
