package cz.opentree;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.firebase.analytics.FirebaseAnalytics;
import cz.opentree.juicessh.R;

/* compiled from: Analytics.java */
/* loaded from: classes.dex */
public class qi0 {

    /* renamed from: d */
    public static qi0 f6006d;

    /* renamed from: a */
    public Context f6007a;

    /* renamed from: b */
    public C2323y3 f6008b;

    /* renamed from: c */
    public FirebaseAnalytics f6009c;

    public qi0(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f6007a = applicationContext;
        this.f6008b = GoogleAnalytics.m813k(applicationContext).m820n(R.xml.google_analytics);
        this.f6009c = FirebaseAnalytics.getInstance(this.f6007a);
    }

    /* renamed from: c */
    public static qi0 m7716c(Context context) {
        if (f6006d == null) {
            f6006d = new qi0(context);
        }
        return f6006d;
    }

    /* renamed from: a */
    public void m7717a(String str, String str2, String str3) {
        m7718b(str, str2, str3, 0L);
    }

    /* renamed from: b */
    public void m7718b(String str, String str2, String str3, long j) {
        m7720e(str, str2, str3, j);
        m7719d(str, str2, str3, j);
    }

    /* renamed from: d */
    public final void m7719d(String str, String str2, String str3, long j) {
        Bundle bundle = new Bundle();
        bundle.putString("item_category", str);
        bundle.putString("content_type", str2);
        bundle.putString("content", str3);
        bundle.putLong("quantity", j);
        this.f6009c.m1594a("select_item", bundle);
    }

    /* renamed from: e */
    public final void m7720e(String str, String str2, String str3, long j) {
        C2323y3 c2323y3 = this.f6008b;
        C1992u3 c1992u3 = new C1992u3();
        c1992u3.m8839d(str2);
        c1992u3.m8838c(str2);
        c1992u3.m8840e(str3);
        c1992u3.m8841f(j);
        c2323y3.m10072I0(c1992u3.m9401a());
    }
}
