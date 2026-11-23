package com.sonelli;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.zk */
/* loaded from: classes.dex */
public final class C2431zk extends ContentObserver {
    public C2431zk(Handler handler) {
        super(null);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        AtomicBoolean atomicBoolean;
        atomicBoolean = C0719al.f1438e;
        atomicBoolean.set(true);
    }
}
