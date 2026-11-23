package com.sonelli;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.sonelli.oa0;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class sa0 implements CrashlyticsReportJsonTransform.ObjectParser {

    /* renamed from: a */
    public static final sa0 f6423a = new sa0();

    /* renamed from: b */
    public static CrashlyticsReportJsonTransform.ObjectParser m8419b() {
        return f6423a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
    /* renamed from: a */
    public Object mo1817a(JsonReader jsonReader) {
        oa0.AbstractC1643b m1799m;
        m1799m = CrashlyticsReportJsonTransform.m1799m(jsonReader);
        return m1799m;
    }
}
