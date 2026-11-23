package cz.opentree;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import cz.opentree.C2224wi;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* renamed from: cz.opentree.vj */
/* loaded from: classes.dex */
public final class C2172vj extends C2224wi.a {

    /* renamed from: S */
    public final /* synthetic */ Activity f7476S;

    /* renamed from: T */
    public final /* synthetic */ C2224wi.c f7477T;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2172vj(C2224wi.c cVar, Activity activity) {
        super(C2224wi.this);
        this.f7477T = cVar;
        this.f7476S = activity;
    }

    @Override // cz.opentree.C2224wi.a
    /* renamed from: a */
    public final void mo2112a() throws RemoteException {
        zzr zzrVar;
        zzrVar = C2224wi.this.f7726g;
        zzrVar.onActivityPaused(BinderC1548md.m6402O0(this.f7476S), this.f7728P);
    }
}
