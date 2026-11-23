package com.sonelli;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzd;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.pz */
/* loaded from: classes.dex */
public final class RunnableC1741pz implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ zzd f5895O;

    /* renamed from: P */
    public final /* synthetic */ ServiceConnection f5896P;

    /* renamed from: Q */
    public final /* synthetic */ ServiceConnectionC1579mz f5897Q;

    public RunnableC1741pz(ServiceConnectionC1579mz serviceConnectionC1579mz, zzd zzdVar, ServiceConnection serviceConnection) {
        this.f5897Q = serviceConnectionC1579mz;
        this.f5895O = zzdVar;
        this.f5896P = serviceConnection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        ServiceConnectionC1579mz serviceConnectionC1579mz = this.f5897Q;
        C1626nz c1626nz = serviceConnectionC1579mz.f5163b;
        str = serviceConnectionC1579mz.f5162a;
        zzd zzdVar = this.f5895O;
        ServiceConnection serviceConnection = this.f5896P;
        Bundle m6819a = c1626nz.m6819a(str, zzdVar);
        c1626nz.f5391a.mo1481g().mo7585d();
        if (m6819a != null) {
            long j = m6819a.getLong("install_begin_timestamp_seconds", 0L) * 1000;
            if (j == 0) {
                c1626nz.f5391a.mo1484j().m8522H().m9083a("Service response is missing Install Referrer install timestamp");
            } else {
                String string = m6819a.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    c1626nz.f5391a.mo1484j().m8522H().m9083a("No referrer defined in Install Referrer response");
                } else {
                    c1626nz.f5391a.mo1484j().m8530P().m9084b("InstallReferrer API result", string);
                    g40 m9102H = c1626nz.f5391a.m9102H();
                    String valueOf = String.valueOf(string);
                    Bundle m4010B = m9102H.m4010B(Uri.parse(valueOf.length() != 0 ? "?".concat(valueOf) : new String("?")));
                    if (m4010B == null) {
                        c1626nz.f5391a.mo1484j().m8522H().m9083a("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = m4010B.getString("medium");
                        if ((string2 == null || "(not set)".equalsIgnoreCase(string2) || "organic".equalsIgnoreCase(string2)) ? false : true) {
                            long j2 = m6819a.getLong("referrer_click_timestamp_seconds", 0L) * 1000;
                            if (j2 == 0) {
                                c1626nz.f5391a.mo1484j().m8522H().m9083a("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                m4010B.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == c1626nz.f5391a.m9096B().f2566k.m4968a()) {
                            c1626nz.f5391a.mo1480f();
                            c1626nz.f5391a.mo1484j().m8530P().m9083a("Install Referrer campaign has already been logged");
                        } else if (!C1882sr.m8481b() || !c1626nz.f5391a.m9130y().m2630u(C1735pu.f5785D0) || c1626nz.f5391a.m9122q()) {
                            c1626nz.f5391a.m9096B().f2566k.m4969b(j);
                            c1626nz.f5391a.mo1480f();
                            c1626nz.f5391a.mo1484j().m8530P().m9084b("Logging Install Referrer campaign from sdk with ", "referrer API");
                            m4010B.putString("_cis", "referrer API");
                            c1626nz.f5391a.m9101G().m10009S("auto", "_cmp", m4010B);
                        }
                    }
                }
            }
        }
        if (serviceConnection != null) {
            C1926tb.m8637b().m8639c(c1626nz.f5391a.mo1482h(), serviceConnection);
        }
    }
}
