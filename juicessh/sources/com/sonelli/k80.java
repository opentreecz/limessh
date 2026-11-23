package com.sonelli;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.crashlytics.CrashlyticsRegistrar;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class k80 implements ComponentFactory {

    /* renamed from: a */
    public final CrashlyticsRegistrar f4496a;

    public k80(CrashlyticsRegistrar crashlyticsRegistrar) {
        this.f4496a = crashlyticsRegistrar;
    }

    /* renamed from: b */
    public static ComponentFactory m5848b(CrashlyticsRegistrar crashlyticsRegistrar) {
        return new k80(crashlyticsRegistrar);
    }

    @Override // com.google.firebase.components.ComponentFactory
    /* renamed from: a */
    public Object mo1608a(ComponentContainer componentContainer) {
        l80 m1610b;
        m1610b = this.f4496a.m1610b(componentContainer);
        return m1610b;
    }
}
