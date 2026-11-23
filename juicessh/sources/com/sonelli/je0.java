package com.sonelli;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.gms.stats.WakeLock;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final class je0 {

    /* renamed from: a */
    public static final long f3549a = TimeUnit.MINUTES.toMillis(1);

    /* renamed from: b */
    public static final Object f3550b = new Object();

    /* renamed from: c */
    @GuardedBy("WakeLockHolder.syncObject")
    public static WakeLock f3551c;

    /* renamed from: a */
    public static ComponentName m5107a(@NonNull Context context, @NonNull Intent intent) {
        synchronized (f3550b) {
            if (f3551c == null) {
                WakeLock wakeLock = new WakeLock(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
                f3551c = wakeLock;
                wakeLock.m1515d(true);
            }
            boolean booleanExtra = intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
            m5108b(intent, true);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            if (!booleanExtra) {
                f3551c.m1512a(f3549a);
            }
            return startService;
        }
    }

    /* renamed from: b */
    public static void m5108b(@NonNull Intent intent, boolean z) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z);
    }
}
