package cz.opentree;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: cz.opentree.sc */
/* loaded from: classes.dex */
public final class C1855sc {

    /* renamed from: b */
    public static long f6426b;

    /* renamed from: a */
    public static final IntentFilter f6425a = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* renamed from: c */
    public static float f6427c = Float.NaN;

    @TargetApi(20)
    /* renamed from: a */
    public static int m8424a(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, f6425a);
        int i = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & (C1501lc.m6144d() ? 7 : 3)) != 0 ? 1 : 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        return (C1501lc.m6147g() ? powerManager.isInteractive() : powerManager.isScreenOn() ? 2 : 0) | i;
    }

    /* renamed from: b */
    public static synchronized float m8425b(Context context) {
        synchronized (C1855sc.class) {
            if (SystemClock.elapsedRealtime() - f6426b < 60000 && !Float.isNaN(f6427c)) {
                return f6427c;
            }
            if (context.getApplicationContext().registerReceiver(null, f6425a) != null) {
                f6427c = r5.getIntExtra("level", -1) / r5.getIntExtra("scale", -1);
            }
            f6426b = SystemClock.elapsedRealtime();
            return f6427c;
        }
    }
}
