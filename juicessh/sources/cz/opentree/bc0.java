package cz.opentree;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class bc0 {

    /* renamed from: c */
    public static final CrashlyticsReportJsonTransform f1641c = new CrashlyticsReportJsonTransform();

    /* renamed from: d */
    public static final String f1642d = m2431d("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");

    /* renamed from: e */
    public static final String f1643e = m2431d("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");

    /* renamed from: f */
    public static final Transformer<oa0, byte[]> f1644f = ac0.m2039a();

    /* renamed from: a */
    public final Transport<oa0> f1645a;

    /* renamed from: b */
    public final Transformer<oa0, byte[]> f1646b;

    public bc0(Transport<oa0> transport, Transformer<oa0, byte[]> transformer) {
        this.f1645a = transport;
        this.f1646b = transformer;
    }

    /* renamed from: a */
    public static bc0 m2428a(Context context) {
        C1483l0.m6034f(context);
        TransportFactory m6037g = C1483l0.m6032c().m6037g(new C0905e(f1642d, f1643e));
        C0746b m2321b = C0746b.m2321b("json");
        Transformer<oa0, byte[]> transformer = f1644f;
        return new bc0(m6037g.mo739a("FIREBASE_CRASHLYTICS_REPORT", oa0.class, m2321b, transformer), transformer);
    }

    /* renamed from: b */
    public static /* synthetic */ void m2429b(k60 k60Var, b90 b90Var, Exception exc) {
        if (exc != null) {
            k60Var.m5845d(exc);
        } else {
            k60Var.m5846e(b90Var);
        }
    }

    /* renamed from: d */
    public static String m2431d(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str.length() + str2.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str2.length() > i) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }

    @NonNull
    /* renamed from: e */
    public j60<b90> m2432e(@NonNull b90 b90Var) {
        oa0 mo2402b = b90Var.mo2402b();
        k60 k60Var = new k60();
        this.f1645a.mo738a(AbstractC0802c.m2646d(mo2402b), zb0.m10426b(k60Var, b90Var));
        return k60Var.m5842a();
    }
}
