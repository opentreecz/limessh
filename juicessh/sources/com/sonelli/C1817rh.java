package com.sonelli;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.stats.WakeLock;

/* renamed from: com.sonelli.rh */
/* loaded from: classes.dex */
public final class C1817rh {

    /* renamed from: a */
    public static Object f6210a = new Object();

    /* renamed from: b */
    public static WakeLock f6211b;

    /* renamed from: c */
    public static Boolean f6212c;

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    /* renamed from: a */
    public static void m7904a(Context context, Intent intent) {
        C1451kh m9477e = C2216wf.m9474c(context).m9477e();
        if (intent == null) {
            m9477e.m8649A0("AnalyticsReceiver called with null intent");
            return;
        }
        String action = intent.getAction();
        m9477e.m8679z("Local AnalyticsReceiver got", action);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            boolean m8431i = C1860sh.m8431i(context);
            Intent intent2 = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent2.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
            intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            synchronized (f6210a) {
                context.startService(intent2);
                if (m8431i) {
                    try {
                        if (f6211b == null) {
                            WakeLock wakeLock = new WakeLock(context, 1, "Analytics WakeLock");
                            f6211b = wakeLock;
                            wakeLock.m1515d(false);
                        }
                        f6211b.m1512a(1000L);
                    } catch (SecurityException unused) {
                        m9477e.m8649A0("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public static boolean m7905b(Context context) {
        C0813ca.m2729k(context);
        Boolean bool = f6212c;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean m2077f = C0713ai.m2077f(context, "com.google.android.gms.analytics.AnalyticsReceiver", false);
        f6212c = Boolean.valueOf(m2077f);
        return m2077f;
    }
}
