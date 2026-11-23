package com.sonelli;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final class ge0 extends BroadcastReceiver {

    /* renamed from: a */
    @Nullable
    public he0 f2862a;

    public ge0(he0 he0Var) {
        this.f2862a = he0Var;
    }

    /* renamed from: a */
    public final void m4118a() {
        if (FirebaseInstanceId.m1873v()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.f2862a.m4441a().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        he0 he0Var = this.f2862a;
        if (he0Var != null && he0Var.m4442b()) {
            if (FirebaseInstanceId.m1873v()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.m1870n(this.f2862a, 0L);
            this.f2862a.m4441a().unregisterReceiver(this);
            this.f2862a = null;
        }
    }
}
