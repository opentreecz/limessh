package com.sonelli;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.R$string;
import com.google.android.gms.common.api.Status;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
@Deprecated
/* renamed from: com.sonelli.t7 */
/* loaded from: classes.dex */
public final class C1902t7 {

    /* renamed from: d */
    public static final Object f6716d = new Object();

    /* renamed from: e */
    @GuardedBy("sLock")
    public static C1902t7 f6717e;

    /* renamed from: a */
    public final String f6718a;

    /* renamed from: b */
    public final Status f6719b;

    /* renamed from: c */
    public final boolean f6720c;

    public C1902t7(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R$string.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            this.f6720c = !(resources.getInteger(identifier) != 0);
        } else {
            this.f6720c = false;
        }
        String m3706a = C0980fb.m3706a(context);
        m3706a = m3706a == null ? new C0977fa(context).m3696a("google_app_id") : m3706a;
        if (TextUtils.isEmpty(m3706a)) {
            this.f6719b = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f6718a = null;
        } else {
            this.f6718a = m3706a;
            this.f6719b = Status.f727S;
        }
    }

    /* renamed from: a */
    public static C1902t7 m8597a(String str) {
        C1902t7 c1902t7;
        synchronized (f6716d) {
            c1902t7 = f6717e;
            if (c1902t7 == null) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
        }
        return c1902t7;
    }

    /* renamed from: b */
    public static String m8598b() {
        return m8597a("getGoogleAppId").f6718a;
    }

    /* renamed from: c */
    public static Status m8599c(Context context) {
        Status status;
        C0813ca.m2730l(context, "Context must not be null.");
        synchronized (f6716d) {
            if (f6717e == null) {
                f6717e = new C1902t7(context);
            }
            status = f6717e.f6719b;
        }
        return status;
    }

    /* renamed from: d */
    public static boolean m8600d() {
        return m8597a("isMeasurementExplicitlyDisabled").f6720c;
    }
}
