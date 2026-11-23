package cz.opentree;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import cz.opentree.oa0;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class wa0 implements CrashlyticsReportJsonTransform.ObjectParser {

    /* renamed from: a */
    public static final wa0 f7657a = new wa0();

    /* renamed from: b */
    public static CrashlyticsReportJsonTransform.ObjectParser m9458b() {
        return f7657a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
    /* renamed from: a */
    public Object mo1817a(JsonReader jsonReader) {
        oa0.AbstractC1645d.d.a.b.e.AbstractC2510b m1807u;
        m1807u = CrashlyticsReportJsonTransform.m1807u(jsonReader);
        return m1807u;
    }
}
