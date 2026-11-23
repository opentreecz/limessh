package com.sonelli;

import com.google.android.gms.internal.gtm.zzbp;

/* renamed from: com.sonelli.yh */
/* loaded from: classes.dex */
public final class C2347yh extends C1930tf implements zzbp<C2426zh> {

    /* renamed from: P */
    public final C2426zh f8219P;

    public C2347yh(C2216wf c2216wf) {
        super(c2216wf);
        this.f8219P = new C2426zh();
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    /* renamed from: b */
    public final /* synthetic */ C2426zh mo1210b() {
        return this.f8219P;
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    /* renamed from: c */
    public final void mo1211c(String str, int i) {
        if ("ga_sessionTimeout".equals(str)) {
            this.f8219P.f8509c = i;
        } else {
            m8672t0("int configuration name not recognized", str);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    /* renamed from: d */
    public final void mo1212d(String str, String str2) {
        if ("ga_trackingId".equals(str)) {
            this.f8219P.f8507a = str2;
            return;
        }
        if (!"ga_sampleFrequency".equals(str)) {
            m8672t0("string configuration name not recognized", str);
            return;
        }
        try {
            this.f8219P.f8508b = Double.parseDouble(str2);
        } catch (NumberFormatException e) {
            m8657e0("Error parsing ga_sampleFrequency value", str2, e);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    /* renamed from: f */
    public final void mo1213f(String str, String str2) {
        this.f8219P.f8513g.put(str, str2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    /* renamed from: p */
    public final void mo1214p(String str, boolean z) {
        if ("ga_autoActivityTracking".equals(str)) {
            this.f8219P.f8510d = z ? 1 : 0;
        } else if ("ga_anonymizeIp".equals(str)) {
            this.f8219P.f8511e = z ? 1 : 0;
        } else if (!"ga_reportUncaughtExceptions".equals(str)) {
            m8672t0("bool configuration name not recognized", str);
        } else {
            this.f8219P.f8512f = z ? 1 : 0;
        }
    }
}
