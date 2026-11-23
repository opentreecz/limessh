package com.sonelli;

import com.google.android.gms.internal.gtm.zzbp;

/* renamed from: com.sonelli.eh */
/* loaded from: classes.dex */
public final class C0926eh implements zzbp<C0989fh> {

    /* renamed from: O */
    public final C2216wf f2389O;

    /* renamed from: P */
    public final C0989fh f2390P = new C0989fh();

    public C0926eh(C2216wf c2216wf) {
        this.f2389O = c2216wf;
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    /* renamed from: b */
    public final /* synthetic */ C0989fh mo1210b() {
        return this.f2390P;
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    /* renamed from: c */
    public final void mo1211c(String str, int i) {
        if ("ga_dispatchPeriod".equals(str)) {
            this.f2390P.f2689d = i;
        } else {
            this.f2389O.m9477e().m8672t0("Int xml configuration name not recognized", str);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    /* renamed from: d */
    public final void mo1212d(String str, String str2) {
        if ("ga_appName".equals(str)) {
            this.f2390P.f2686a = str2;
            return;
        }
        if ("ga_appVersion".equals(str)) {
            this.f2390P.f2687b = str2;
        } else if ("ga_logLevel".equals(str)) {
            this.f2390P.f2688c = str2;
        } else {
            this.f2389O.m9477e().m8672t0("String xml configuration name not recognized", str);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    /* renamed from: f */
    public final void mo1213f(String str, String str2) {
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    /* renamed from: p */
    public final void mo1214p(String str, boolean z) {
        if (!"ga_dryRun".equals(str)) {
            this.f2389O.m9477e().m8672t0("Bool xml configuration name not recognized", str);
        } else {
            this.f2390P.f2690e = z ? 1 : 0;
        }
    }
}
