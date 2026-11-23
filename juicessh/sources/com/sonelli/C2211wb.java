package com.sonelli;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.wb */
/* loaded from: classes.dex */
public class C2211wb {

    /* renamed from: a */
    public static C2211wb f7658a = new C2211wb();

    /* renamed from: b */
    public static Boolean f7659b;

    /* renamed from: a */
    public static C2211wb m9459a() {
        return f7658a;
    }

    /* renamed from: d */
    public static void m9460d(Context context, WakeLockEvent wakeLockEvent) {
        try {
            context.startService(new Intent().setComponent(C2002ub.f6946a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", wakeLockEvent));
        } catch (Exception e) {
            Log.wtf("WakeLockTracker", e);
        }
    }

    /* renamed from: e */
    public static boolean m9461e() {
        if (f7659b == null) {
            f7659b = Boolean.FALSE;
        }
        return f7659b.booleanValue();
    }

    /* renamed from: b */
    public void m9462b(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list) {
        m9463c(context, str, i, str2, str3, str4, i2, list, 0L);
    }

    /* renamed from: c */
    public void m9463c(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list, long j) {
        if (m9461e()) {
            if (TextUtils.isEmpty(str)) {
                String valueOf = String.valueOf(str);
                Log.e("WakeLockTracker", valueOf.length() != 0 ? "missing wakeLock key. ".concat(valueOf) : new String("missing wakeLock key. "));
            } else if (7 == i || 8 == i || 10 == i || 11 == i) {
                m9460d(context, new WakeLockEvent(System.currentTimeMillis(), i, str2, i2, C2163vb.m9208b(list), str, SystemClock.elapsedRealtime(), C1855sc.m8424a(context), str3, C2163vb.m9209c(context.getPackageName()), C1855sc.m8425b(context), j, str4, false));
            }
        }
    }
}
