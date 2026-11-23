package com.sonelli;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zza;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
/* loaded from: classes.dex */
public final class m70 implements zza {

    /* renamed from: a */
    public AnalyticsConnector.AnalyticsConnectorListener f4995a;

    /* renamed from: b */
    public AppMeasurement f4996b;

    /* renamed from: c */
    public o70 f4997c;

    public m70(AppMeasurement appMeasurement, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.f4995a = analyticsConnectorListener;
        this.f4996b = appMeasurement;
        o70 o70Var = new o70(this);
        this.f4997c = o70Var;
        appMeasurement.m1439a(o70Var);
    }
}
