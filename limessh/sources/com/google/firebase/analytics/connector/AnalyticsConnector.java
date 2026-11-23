package com.google.firebase.analytics.connector;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public interface AnalyticsConnector {

    /* loaded from: classes.dex */
    public interface AnalyticsConnectorHandle {
    }

    /* loaded from: classes.dex */
    public interface AnalyticsConnectorListener {
        /* renamed from: c */
        void mo1597c(int i, @Nullable Bundle bundle);
    }

    /* renamed from: a */
    void mo1595a(@NonNull String str, @NonNull String str2, Bundle bundle);

    /* renamed from: b */
    AnalyticsConnectorHandle mo1596b(String str, AnalyticsConnectorListener analyticsConnectorListener);
}
