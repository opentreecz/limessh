package com.sonelli;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.sonelli.oa0;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class ua0 implements CrashlyticsReportJsonTransform.ObjectParser {

    /* renamed from: a */
    public static final ua0 f6945a = new ua0();

    /* renamed from: b */
    public static CrashlyticsReportJsonTransform.ObjectParser m8863b() {
        return f6945a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
    /* renamed from: a */
    public Object mo1817a(JsonReader jsonReader) {
        oa0.AbstractC1645d.d.a.b.AbstractC2503a m1803q;
        m1803q = CrashlyticsReportJsonTransform.m1803q(jsonReader);
        return m1803q;
    }
}
