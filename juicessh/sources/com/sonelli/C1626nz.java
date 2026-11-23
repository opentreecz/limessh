package com.sonelli;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.internal.measurement.zzd;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.nz */
/* loaded from: classes.dex */
public final class C1626nz {

    /* renamed from: a */
    public final C2144uz f5391a;

    public C1626nz(C2144uz c2144uz) {
        this.f5391a = c2144uz;
    }

    @Nullable
    @WorkerThread
    /* renamed from: a */
    public final Bundle m6819a(String str, zzd zzdVar) {
        this.f5391a.mo1481g().mo7585d();
        if (zzdVar == null) {
            this.f5391a.mo1484j().m8525K().m9083a("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            Bundle mo1222j = zzdVar.mo1222j(bundle);
            if (mo1222j != null) {
                return mo1222j;
            }
            this.f5391a.mo1484j().m8522H().m9083a("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e) {
            this.f5391a.mo1484j().m8522H().m9084b("Exception occurred while retrieving the Install Referrer", e.getMessage());
            return null;
        }
    }

    @WorkerThread
    /* renamed from: b */
    public final void m6820b(String str) {
        if (str == null || str.isEmpty()) {
            this.f5391a.mo1484j().m8526L().m9083a("Install Referrer Reporter was called with invalid app package name");
            return;
        }
        this.f5391a.mo1481g().mo7585d();
        if (!m6821c()) {
            this.f5391a.mo1484j().m8528N().m9083a("Install Referrer Reporter is not available");
            return;
        }
        ServiceConnectionC1579mz serviceConnectionC1579mz = new ServiceConnectionC1579mz(this, str);
        this.f5391a.mo1481g().mo7585d();
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        PackageManager packageManager = this.f5391a.mo1482h().getPackageManager();
        if (packageManager == null) {
            this.f5391a.mo1484j().m8526L().m9083a("Failed to obtain Package Manager to verify binding conditions for Install Referrer");
            return;
        }
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            this.f5391a.mo1484j().m8528N().m9083a("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
        if (serviceInfo != null) {
            String str2 = serviceInfo.packageName;
            if (serviceInfo.name == null || !"com.android.vending".equals(str2) || !m6821c()) {
                this.f5391a.mo1484j().m8525K().m9083a("Play Store version 8.3.73 or higher required for Install Referrer");
                return;
            }
            try {
                this.f5391a.mo1484j().m8530P().m9084b("Install Referrer Service is", C1926tb.m8637b().m8638a(this.f5391a.mo1482h(), new Intent(intent), serviceConnectionC1579mz, 1) ? "available" : "not available");
            } catch (Exception e) {
                this.f5391a.mo1484j().m8522H().m9084b("Exception occurred while binding to Install Referrer Service", e.getMessage());
            }
        }
    }

    /* renamed from: c */
    public final boolean m6821c() {
        try {
            C2213wc m9755a = C2272xc.m9755a(this.f5391a.mo1482h());
            if (m9755a != null) {
                return m9755a.m9468e("com.android.vending", 128).versionCode >= 80837300;
            }
            this.f5391a.mo1484j().m8530P().m9083a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e) {
            this.f5391a.mo1484j().m8530P().m9084b("Failed to retrieve Play Store version for Install Referrer", e);
            return false;
        }
    }
}
