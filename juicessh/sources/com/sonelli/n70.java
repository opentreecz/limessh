package com.sonelli;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
/* loaded from: classes.dex */
public final class n70 implements AppMeasurement.OnEventListener {

    /* renamed from: a */
    public final /* synthetic */ k70 f5238a;

    public n70(k70 k70Var) {
        this.f5238a = k70Var;
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    /* renamed from: a */
    public final void mo1451a(String str, String str2, Bundle bundle, long j) {
        AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener;
        if (this.f5238a.f4491a.contains(str2)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("events", l70.m6096f(str2));
            analyticsConnectorListener = this.f5238a.f4492b;
            analyticsConnectorListener.mo1597c(2, bundle2);
        }
    }
}
