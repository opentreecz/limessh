package com.sonelli;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.sonelli.oa0;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class va0 implements CrashlyticsReportJsonTransform.ObjectParser {

    /* renamed from: a */
    public static final va0 f7436a = new va0();

    /* renamed from: b */
    public static CrashlyticsReportJsonTransform.ObjectParser m9206b() {
        return f7436a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
    /* renamed from: a */
    public Object mo1817a(JsonReader jsonReader) {
        oa0.AbstractC1645d.d.a.b.e.AbstractC2510b m1807u;
        m1807u = CrashlyticsReportJsonTransform.m1807u(jsonReader);
        return m1807u;
    }
}
