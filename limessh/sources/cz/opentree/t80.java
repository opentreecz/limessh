package cz.opentree;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class t80 {

    /* renamed from: a */
    public final Float f6723a;

    /* renamed from: b */
    public final boolean f6724b;

    public t80(Float f, boolean z) {
        this.f6724b = z;
        this.f6723a = f;
    }

    /* renamed from: a */
    public static t80 m8602a(Context context) {
        boolean z;
        Float f = null;
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            z = m8604e(registerReceiver);
            f = m8603d(registerReceiver);
        } else {
            z = false;
        }
        return new t80(f, z);
    }

    /* renamed from: d */
    public static Float m8603d(Intent intent) {
        int intExtra = intent.getIntExtra("level", -1);
        int intExtra2 = intent.getIntExtra("scale", -1);
        if (intExtra == -1 || intExtra2 == -1) {
            return null;
        }
        return Float.valueOf(intExtra / intExtra2);
    }

    /* renamed from: e */
    public static boolean m8604e(Intent intent) {
        int intExtra = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
        if (intExtra == -1) {
            return false;
        }
        return intExtra == 2 || intExtra == 5;
    }

    /* renamed from: b */
    public Float m8605b() {
        return this.f6723a;
    }

    /* renamed from: c */
    public int m8606c() {
        Float f;
        if (!this.f6724b || (f = this.f6723a) == null) {
            return 1;
        }
        return ((double) f.floatValue()) < 0.99d ? 2 : 3;
    }
}
