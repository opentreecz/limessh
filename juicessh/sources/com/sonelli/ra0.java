package com.sonelli;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.sonelli.oa0;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class ra0 implements CrashlyticsReportJsonTransform.ObjectParser {

    /* renamed from: a */
    public static final ra0 f6200a = new ra0();

    /* renamed from: b */
    public static CrashlyticsReportJsonTransform.ObjectParser m7901b() {
        return f6200a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
    /* renamed from: a */
    public Object mo1817a(JsonReader jsonReader) {
        oa0.AbstractC1644c.b m1811y;
        m1811y = CrashlyticsReportJsonTransform.m1811y(jsonReader);
        return m1811y;
    }
}
