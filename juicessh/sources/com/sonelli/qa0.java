package com.sonelli;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.sonelli.oa0;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class qa0 implements CrashlyticsReportJsonTransform.ObjectParser {

    /* renamed from: a */
    public static final qa0 f5967a = new qa0();

    /* renamed from: b */
    public static CrashlyticsReportJsonTransform.ObjectParser m7642b() {
        return f5967a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
    /* renamed from: a */
    public Object mo1817a(JsonReader jsonReader) {
        oa0.AbstractC1645d.d m1801o;
        m1801o = CrashlyticsReportJsonTransform.m1801o(jsonReader);
        return m1801o;
    }
}
