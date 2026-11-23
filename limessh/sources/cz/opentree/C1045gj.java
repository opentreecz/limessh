package cz.opentree;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import cz.opentree.C2224wi;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* renamed from: cz.opentree.gj */
/* loaded from: classes.dex */
public final class C1045gj extends C2224wi.a {

    /* renamed from: S */
    public final /* synthetic */ BinderC1981tt f2880S;

    /* renamed from: T */
    public final /* synthetic */ C2224wi f2881T;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1045gj(C2224wi c2224wi, BinderC1981tt binderC1981tt) {
        super(c2224wi);
        this.f2881T = c2224wi;
        this.f2880S = binderC1981tt;
    }

    @Override // cz.opentree.C2224wi.a
    /* renamed from: a */
    public final void mo2112a() throws RemoteException {
        zzr zzrVar;
        zzrVar = this.f2881T.f7726g;
        zzrVar.getCurrentScreenName(this.f2880S);
    }

    @Override // cz.opentree.C2224wi.a
    /* renamed from: b */
    public final void mo2113b() {
        this.f2880S.mo1433j(null);
    }
}
