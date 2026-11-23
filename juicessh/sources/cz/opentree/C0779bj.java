package cz.opentree;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzr;
import cz.opentree.C2224wi;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* renamed from: cz.opentree.bj */
/* loaded from: classes.dex */
public final class C0779bj extends C2224wi.a {

    /* renamed from: S */
    public final /* synthetic */ Activity f1739S;

    /* renamed from: T */
    public final /* synthetic */ String f1740T;

    /* renamed from: U */
    public final /* synthetic */ String f1741U;

    /* renamed from: V */
    public final /* synthetic */ C2224wi f1742V;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0779bj(C2224wi c2224wi, Activity activity, String str, String str2) {
        super(c2224wi);
        this.f1742V = c2224wi;
        this.f1739S = activity;
        this.f1740T = str;
        this.f1741U = str2;
    }

    @Override // cz.opentree.C2224wi.a
    /* renamed from: a */
    public final void mo2112a() throws RemoteException {
        zzr zzrVar;
        zzrVar = this.f1742V.f7726g;
        zzrVar.setCurrentScreen(BinderC1548md.m6402O0(this.f1739S), this.f1740T, this.f1741U, this.f7727O);
    }
}
