package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.events.Subscriber;
import com.sonelli.b80;
import com.sonelli.j70;
import com.sonelli.og0;
import com.sonelli.v70;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
@Keep
/* loaded from: classes.dex */
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    @SuppressLint({"MissingPermission"})
    public List<v70<?>> getComponents() {
        v70.C2157b m9172a = v70.m9172a(AnalyticsConnector.class);
        m9172a.m9187b(b80.m2394f(FirebaseApp.class));
        m9172a.m9187b(b80.m2394f(Context.class));
        m9172a.m9187b(b80.m2394f(Subscriber.class));
        m9172a.m9191f(j70.f3512a);
        m9172a.m9190e();
        return Arrays.asList(m9172a.m9189d(), og0.m7033a("fire-analytics", "17.4.1"));
    }
}
