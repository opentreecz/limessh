package com.sonelli;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.sonelli.oa0;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class ta0 implements CrashlyticsReportJsonTransform.ObjectParser {

    /* renamed from: a */
    public static final ta0 f6747a = new ta0();

    /* renamed from: b */
    public static CrashlyticsReportJsonTransform.ObjectParser m8636b() {
        return f6747a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
    /* renamed from: a */
    public Object mo1817a(JsonReader jsonReader) {
        oa0.AbstractC1645d.d.a.b.e m1810x;
        m1810x = CrashlyticsReportJsonTransform.m1810x(jsonReader);
        return m1810x;
    }
}
