package cz.opentree;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import cz.opentree.C2224wi;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* renamed from: cz.opentree.qj */
/* loaded from: classes.dex */
public final class C1765qj extends C2224wi.a {

    /* renamed from: S */
    public final /* synthetic */ Bundle f6010S;

    /* renamed from: T */
    public final /* synthetic */ C2224wi f6011T;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1765qj(C2224wi c2224wi, Bundle bundle) {
        super(c2224wi);
        this.f6011T = c2224wi;
        this.f6010S = bundle;
    }

    @Override // cz.opentree.C2224wi.a
    /* renamed from: a */
    public final void mo2112a() throws RemoteException {
        zzr zzrVar;
        zzrVar = this.f6011T.f7726g;
        zzrVar.setConditionalUserProperty(this.f6010S, this.f7727O);
    }
}
