package com.sonelli;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.measurement.internal.zzm;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.py */
/* loaded from: classes.dex */
public final class C1740py extends AbstractC0742ay {

    /* renamed from: c */
    public String f5884c;

    /* renamed from: d */
    public String f5885d;

    /* renamed from: e */
    public int f5886e;

    /* renamed from: f */
    public String f5887f;

    /* renamed from: g */
    public long f5888g;

    /* renamed from: h */
    public long f5889h;

    /* renamed from: i */
    public List<String> f5890i;

    /* renamed from: j */
    public int f5891j;

    /* renamed from: k */
    public String f5892k;

    /* renamed from: l */
    public String f5893l;

    /* renamed from: m */
    public String f5894m;

    public C1740py(C2144uz c2144uz, long j) {
        super(c2144uz);
        this.f5889h = j;
    }

    @Override // com.sonelli.AbstractC0742ay
    /* renamed from: B */
    public final boolean mo1960B() {
        return true;
    }

    @WorkerThread
    /* renamed from: C */
    public final zzm m7570C(String str) {
        boolean z;
        long min;
        mo7585d();
        mo7583b();
        String m7571D = m7571D();
        String m7572E = m7572E();
        m2299y();
        String str2 = this.f5885d;
        long m7575H = m7575H();
        m2299y();
        String str3 = this.f5887f;
        long m2611E = m7590o().m2611E();
        m2299y();
        mo7585d();
        if (this.f5888g == 0) {
            this.f5888g = this.f5899a.m9102H().m4052y(mo1482h(), mo1482h().getPackageName());
        }
        long j = this.f5888g;
        boolean m9122q = this.f5899a.m9122q();
        boolean z2 = !m7589n().f2578w;
        mo7585d();
        mo7583b();
        String m7578K = !this.f5899a.m9122q() ? null : m7578K();
        C2144uz c2144uz = this.f5899a;
        Long valueOf = Long.valueOf(c2144uz.m9096B().f2565j.m4968a());
        if (valueOf.longValue() == 0) {
            min = c2144uz.f7339F;
            z = m9122q;
        } else {
            z = m9122q;
            min = Math.min(c2144uz.f7339F, valueOf.longValue());
        }
        int m7576I = m7576I();
        boolean booleanValue = m7590o().m2617K().booleanValue();
        C0796bu m7590o = m7590o();
        m7590o.mo7583b();
        Boolean m2635z = m7590o.m2635z("google_analytics_ssaid_collection_enabled");
        boolean booleanValue2 = Boolean.valueOf(m2635z == null || m2635z.booleanValue()).booleanValue();
        C0960ez m7589n = m7589n();
        m7589n.mo7585d();
        return new zzm(m7571D, m7572E, str2, m7575H, str3, m2611E, j, str, z, z2, m7578K, 0L, min, m7576I, booleanValue, booleanValue2, m7589n.m3588D().getBoolean("deferred_analytics_collection", false), m7573F(), m7590o().m2635z("google_analytics_default_allow_ad_personalization_signals") == null ? null : Boolean.valueOf(!r1.booleanValue()), this.f5889h, m7590o().m2630u(C1735pu.f5832e0) ? this.f5890i : null, (C1011fs.m3874b() && m7590o().m2630u(C1735pu.f5856q0)) ? m7574G() : null);
    }

    /* renamed from: D */
    public final String m7571D() {
        m2299y();
        return this.f5884c;
    }

    /* renamed from: E */
    public final String m7572E() {
        m2299y();
        return this.f5892k;
    }

    /* renamed from: F */
    public final String m7573F() {
        m2299y();
        return this.f5893l;
    }

    /* renamed from: G */
    public final String m7574G() {
        m2299y();
        return this.f5894m;
    }

    /* renamed from: H */
    public final int m7575H() {
        m2299y();
        return this.f5886e;
    }

    /* renamed from: I */
    public final int m7576I() {
        m2299y();
        return this.f5891j;
    }

    @Nullable
    /* renamed from: J */
    public final List<String> m7577J() {
        return this.f5890i;
    }

    @WorkerThread
    /* renamed from: K */
    public final String m7578K() {
        if (C1523lt.m6291b() && m7590o().m2630u(C1735pu.f5862t0)) {
            mo1484j().m8530P().m9083a("Disabled IID for tests.");
            return null;
        }
        try {
            Class<?> loadClass = mo1482h().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (loadClass == null) {
                return null;
            }
            try {
                Object invoke = loadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, mo1482h());
                if (invoke == null) {
                    return null;
                }
                try {
                    return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                } catch (Exception unused) {
                    mo1484j().m8527M().m9083a("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception unused2) {
                mo1484j().m8526L().m9083a("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(28:1|(1:3)(6:104|105|(1:107)(2:122|(1:124))|108|109|(4:111|(1:113)(1:120)|115|116))|4|(1:103)(1:8)|9|(1:102)(1:13)|14|(1:(1:17)(1:18))|(3:20|21|(16:24|25|(1:27)|28|29|(1:90)(1:33)|34|(1:36)(1:89)|37|38|(2:86|(1:88))(4:42|(1:44)(1:85)|45|(1:84))|(3:50|(1:52)(1:55)|53)|56|(3:58|(3:60|(1:62)(3:64|(3:67|(1:69)(1:70)|65)|71)|63)|(1:73))|74|(1:(2:77|78)(2:80|81))(2:82|83)))|101|25|(0)|28|29|(1:31)|90|34|(0)(0)|37|38|(1:40)|86|(0)|(0)|56|(0)|74|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x024b, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x024c, code lost:
    
        mo1484j().m8522H().m9085c("Fetching Google App Id failed with exception. appId", com.sonelli.C1889sy.m8516y(r0), r2);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01ac A[Catch: IllegalStateException -> 0x024b, TryCatch #3 {IllegalStateException -> 0x024b, blocks: (B:29:0x01a6, B:31:0x01ac, B:33:0x01b8, B:34:0x01cc, B:37:0x01d5, B:40:0x01df, B:42:0x01eb, B:45:0x0202, B:47:0x020a, B:50:0x022e, B:52:0x0242, B:53:0x0247, B:55:0x0245, B:84:0x0210, B:86:0x0217, B:88:0x021d, B:90:0x01c8), top: B:28:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01df A[Catch: IllegalStateException -> 0x024b, TRY_ENTER, TryCatch #3 {IllegalStateException -> 0x024b, blocks: (B:29:0x01a6, B:31:0x01ac, B:33:0x01b8, B:34:0x01cc, B:37:0x01d5, B:40:0x01df, B:42:0x01eb, B:45:0x0202, B:47:0x020a, B:50:0x022e, B:52:0x0242, B:53:0x0247, B:55:0x0245, B:84:0x0210, B:86:0x0217, B:88:0x021d, B:90:0x01c8), top: B:28:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x022e A[Catch: IllegalStateException -> 0x024b, TryCatch #3 {IllegalStateException -> 0x024b, blocks: (B:29:0x01a6, B:31:0x01ac, B:33:0x01b8, B:34:0x01cc, B:37:0x01d5, B:40:0x01df, B:42:0x01eb, B:45:0x0202, B:47:0x020a, B:50:0x022e, B:52:0x0242, B:53:0x0247, B:55:0x0245, B:84:0x0210, B:86:0x0217, B:88:0x021d, B:90:0x01c8), top: B:28:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x021d A[Catch: IllegalStateException -> 0x024b, TryCatch #3 {IllegalStateException -> 0x024b, blocks: (B:29:0x01a6, B:31:0x01ac, B:33:0x01b8, B:34:0x01cc, B:37:0x01d5, B:40:0x01df, B:42:0x01eb, B:45:0x0202, B:47:0x020a, B:50:0x022e, B:52:0x0242, B:53:0x0247, B:55:0x0245, B:84:0x0210, B:86:0x0217, B:88:0x021d, B:90:0x01c8), top: B:28:0x01a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01d4  */
    @Override // com.sonelli.AbstractC0742ay
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void mo2297w() {
        /*
            Method dump skipped, instructions count: 734
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.C1740py.mo2297w():void");
    }
}
