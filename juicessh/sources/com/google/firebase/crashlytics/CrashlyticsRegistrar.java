package com.google.firebase.crashlytics;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.sonelli.b80;
import com.sonelli.k80;
import com.sonelli.l80;
import com.sonelli.og0;
import com.sonelli.v70;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class CrashlyticsRegistrar implements ComponentRegistrar {
    /* renamed from: b */
    public final l80 m1610b(ComponentContainer componentContainer) {
        return l80.m6097a((FirebaseApp) componentContainer.mo1598a(FirebaseApp.class), (FirebaseInstanceIdInternal) componentContainer.mo1599b(FirebaseInstanceIdInternal.class).get(), (CrashlyticsNativeComponent) componentContainer.mo1598a(CrashlyticsNativeComponent.class), (AnalyticsConnector) componentContainer.mo1598a(AnalyticsConnector.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<v70<?>> getComponents() {
        v70.C2157b m9172a = v70.m9172a(l80.class);
        m9172a.m9187b(b80.m2394f(FirebaseApp.class));
        m9172a.m9187b(b80.m2395g(FirebaseInstanceIdInternal.class));
        m9172a.m9187b(b80.m2393e(AnalyticsConnector.class));
        m9172a.m9187b(b80.m2393e(CrashlyticsNativeComponent.class));
        m9172a.m9191f(k80.m5848b(this));
        m9172a.m9190e();
        return Arrays.asList(m9172a.m9189d(), og0.m7033a("fire-cls", "17.0.0"));
    }
}
