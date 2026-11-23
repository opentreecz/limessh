package com.sonelli;

import android.support.v4.media.session.PlaybackStateCompat;
import javax.annotation.Nullable;

/* compiled from: SegmentPool.java */
/* loaded from: classes.dex */
public final class kp0 {

    /* renamed from: a */
    @Nullable
    public static jp0 f4639a;

    /* renamed from: b */
    public static long f4640b;

    /* renamed from: a */
    public static void m5987a(jp0 jp0Var) {
        if (jp0Var.f3643f != null || jp0Var.f3644g != null) {
            throw new IllegalArgumentException();
        }
        if (jp0Var.f3641d) {
            return;
        }
        synchronized (kp0.class) {
            long j = f4640b;
            if (j + PlaybackStateCompat.ACTION_PLAY_FROM_URI > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                return;
            }
            f4640b = j + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            jp0Var.f3643f = f4639a;
            jp0Var.f3640c = 0;
            jp0Var.f3639b = 0;
            f4639a = jp0Var;
        }
    }

    /* renamed from: b */
    public static jp0 m5988b() {
        synchronized (kp0.class) {
            jp0 jp0Var = f4639a;
            if (jp0Var == null) {
                return new jp0();
            }
            f4639a = jp0Var.f3643f;
            jp0Var.f3643f = null;
            f4640b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return jp0Var;
        }
    }
}
