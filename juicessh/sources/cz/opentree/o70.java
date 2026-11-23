package cz.opentree;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
/* loaded from: classes.dex */
public final class o70 implements AppMeasurement.OnEventListener {

    /* renamed from: a */
    public final /* synthetic */ m70 f5440a;

    public o70(m70 m70Var) {
        this.f5440a = m70Var;
    }

    @Override // com.google.android.gms.measurement.internal.zzha
    /* renamed from: a */
    public final void mo1451a(String str, String str2, Bundle bundle, long j) {
        AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener;
        if (str == null || str.equals("crash") || !l70.m6095e(str2)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str2);
        bundle2.putLong("timestampInMillis", j);
        bundle2.putBundle("params", bundle);
        analyticsConnectorListener = this.f5440a.f4995a;
        analyticsConnectorListener.mo1597c(3, bundle2);
    }
}
