package cz.opentree;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import cz.opentree.C2224wi;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* renamed from: cz.opentree.dj */
/* loaded from: classes.dex */
public final class C0882dj extends C2224wi.a {

    /* renamed from: S */
    public final /* synthetic */ String f2197S;

    /* renamed from: T */
    public final /* synthetic */ C2224wi f2198T;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0882dj(C2224wi c2224wi, String str) {
        super(c2224wi);
        this.f2198T = c2224wi;
        this.f2197S = str;
    }

    @Override // cz.opentree.C2224wi.a
    /* renamed from: a */
    public final void mo2112a() throws RemoteException {
        zzr zzrVar;
        zzrVar = this.f2198T.f7726g;
        zzrVar.endAdUnitExposure(this.f2197S, this.f7728P);
    }
}
