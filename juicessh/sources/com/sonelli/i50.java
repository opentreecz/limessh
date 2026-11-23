package com.sonelli;

import com.google.android.gms.stats.WakeLock;

/* loaded from: classes.dex */
public final class i50 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ WakeLock f3264O;

    public i50(WakeLock wakeLock) {
        this.f3264O = wakeLock;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3264O.m1518g(0);
    }
}
