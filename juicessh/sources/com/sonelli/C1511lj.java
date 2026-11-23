package com.sonelli;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import com.sonelli.C2224wi;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* renamed from: com.sonelli.lj */
/* loaded from: classes.dex */
public final class C1511lj extends C2224wi.a {

    /* renamed from: S */
    public final /* synthetic */ String f4845S;

    /* renamed from: T */
    public final /* synthetic */ BinderC1981tt f4846T;

    /* renamed from: U */
    public final /* synthetic */ C2224wi f4847U;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1511lj(C2224wi c2224wi, String str, BinderC1981tt binderC1981tt) {
        super(c2224wi);
        this.f4847U = c2224wi;
        this.f4845S = str;
        this.f4846T = binderC1981tt;
    }

    @Override // com.sonelli.C2224wi.a
    /* renamed from: a */
    public final void mo2112a() throws RemoteException {
        zzr zzrVar;
        zzrVar = this.f4847U.f7726g;
        zzrVar.getMaxUserProperties(this.f4845S, this.f4846T);
    }

    @Override // com.sonelli.C2224wi.a
    /* renamed from: b */
    public final void mo2113b() {
        this.f4846T.mo1433j(null);
    }
}
