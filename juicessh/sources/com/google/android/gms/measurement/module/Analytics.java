package com.google.android.gms.measurement.module;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.RequiresPermission;
import com.sonelli.C0813ca;
import com.sonelli.C2144uz;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public class Analytics {

    /* renamed from: a */
    public static volatile Analytics f1030a;

    public Analytics(C2144uz c2144uz) {
        C0813ca.m2729k(c2144uz);
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @Keep
    public static Analytics getInstance(Context context) {
        if (f1030a == null) {
            synchronized (Analytics.class) {
                if (f1030a == null) {
                    f1030a = new Analytics(C2144uz.m9091a(context, null, null));
                }
            }
        }
        return f1030a;
    }
}
