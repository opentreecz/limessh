package com.sonelli;

import android.os.SystemClock;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.ec */
/* loaded from: classes.dex */
public class C0921ec implements Clock {

    /* renamed from: a */
    public static final C0921ec f2364a = new C0921ec();

    /* renamed from: d */
    public static Clock m3474d() {
        return f2364a;
    }

    @Override // com.google.android.gms.common.util.Clock
    /* renamed from: a */
    public long mo1177a() {
        return System.currentTimeMillis();
    }

    @Override // com.google.android.gms.common.util.Clock
    /* renamed from: b */
    public long mo1178b() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.common.util.Clock
    /* renamed from: c */
    public long mo1179c() {
        return System.nanoTime();
    }
}
