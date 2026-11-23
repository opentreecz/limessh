package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;
import cz.opentree.hd0;
import cz.opentree.j60;
import cz.opentree.jf0;
import cz.opentree.ue0;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final class FirebaseInstanceIdReceiver extends WakefulBroadcastReceiver {

    /* renamed from: a */
    public final ExecutorService f1278a = ue0.m8875b();

    /* renamed from: b */
    public static final /* synthetic */ void m1900b(boolean z, BroadcastReceiver.PendingResult pendingResult, j60 j60Var) {
        if (z) {
            pendingResult.setResultCode(j60Var.mo2701n() ? ((Integer) j60Var.mo2697j()).intValue() : 500);
        }
        pendingResult.finish();
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(@NonNull Context context, @NonNull Intent intent) {
        if (intent == null) {
            return;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
        Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
        if (intent2 != null) {
            intent = intent2;
        }
        intent.setComponent(null);
        intent.setPackage(context.getPackageName());
        if (Build.VERSION.SDK_INT <= 18) {
            intent.removeCategory(context.getPackageName());
        }
        zzb jf0Var = "google.com/iid".equals(intent.getStringExtra("from")) ? new jf0(this.f1278a) : new hd0(context, this.f1278a);
        final boolean isOrderedBroadcast = isOrderedBroadcast();
        final BroadcastReceiver.PendingResult goAsync = goAsync();
        jf0Var.mo1903a(intent).mo2690c(this.f1278a, new OnCompleteListener(isOrderedBroadcast, goAsync) { // from class: cz.opentree.df0

            /* renamed from: a */
            public final boolean f2160a;

            /* renamed from: b */
            public final BroadcastReceiver.PendingResult f2161b;

            {
                this.f2160a = isOrderedBroadcast;
                this.f2161b = goAsync;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            /* renamed from: a */
            public final void mo1554a(j60 j60Var) {
                FirebaseInstanceIdReceiver.m1900b(this.f2160a, this.f2161b, j60Var);
            }
        });
    }
}
