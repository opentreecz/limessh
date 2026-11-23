package cz.opentree;

import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zza;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
/* loaded from: classes.dex */
public final class k70 implements zza {

    /* renamed from: a */
    public Set<String> f4491a;

    /* renamed from: b */
    public AnalyticsConnector.AnalyticsConnectorListener f4492b;

    /* renamed from: c */
    public AppMeasurement f4493c;

    /* renamed from: d */
    public n70 f4494d;

    public k70(AppMeasurement appMeasurement, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.f4492b = analyticsConnectorListener;
        this.f4493c = appMeasurement;
        n70 n70Var = new n70(this);
        this.f4494d = n70Var;
        appMeasurement.m1439a(n70Var);
        this.f4491a = new HashSet();
    }
}
