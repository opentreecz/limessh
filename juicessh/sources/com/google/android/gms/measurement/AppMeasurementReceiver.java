package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzfs;
import com.sonelli.C1683oz;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzfs {

    /* renamed from: a */
    public C1683oz f977a;

    @Override // com.google.android.gms.measurement.internal.zzfs
    @MainThread
    /* renamed from: a */
    public final void mo1446a(Context context, Intent intent) {
        WakefulBroadcastReceiver.startWakefulService(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    @MainThread
    public final void onReceive(Context context, Intent intent) {
        if (this.f977a == null) {
            this.f977a = new C1683oz(this);
        }
        this.f977a.m7135a(context, intent);
    }
}
