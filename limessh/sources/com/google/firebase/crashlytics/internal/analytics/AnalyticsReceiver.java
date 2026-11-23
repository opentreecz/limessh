package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public interface AnalyticsReceiver {

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes.dex */
    public interface CrashlyticsOriginEventListener {
        /* renamed from: a */
        void mo1632a(int i, Bundle bundle);
    }

    /* renamed from: a */
    void mo1627a(@Nullable CrashlyticsOriginEventListener crashlyticsOriginEventListener);

    /* renamed from: b */
    boolean mo1628b();
}
