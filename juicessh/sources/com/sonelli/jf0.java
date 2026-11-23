package com.sonelli;

import android.content.Intent;
import android.util.Log;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.zzb;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final class jf0 implements zzb {

    /* renamed from: a */
    public final ExecutorService f3553a;

    public jf0(ExecutorService executorService) {
        this.f3553a = executorService;
    }

    @Override // com.google.firebase.iid.zzb
    /* renamed from: a */
    public final j60<Integer> mo1903a(final Intent intent) {
        return Tasks.m1560c(this.f3553a, new Callable(intent) { // from class: com.sonelli.if0

            /* renamed from: a */
            public final Intent f3300a;

            {
                this.f3300a = intent;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                Intent intent2 = this.f3300a;
                String stringExtra = intent2.getStringExtra("CMD");
                if (stringExtra != null) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String valueOf = String.valueOf(intent2.getExtras());
                        StringBuilder sb = new StringBuilder(String.valueOf(stringExtra).length() + 21 + String.valueOf(valueOf).length());
                        sb.append("Received command: ");
                        sb.append(stringExtra);
                        sb.append(" - ");
                        sb.append(valueOf);
                        Log.d("FirebaseInstanceId", sb.toString());
                    }
                    if ("RST".equals(stringExtra) || "RST_FULL".equals(stringExtra)) {
                        FirebaseInstanceId.m1866b().m1892w();
                    } else if ("SYNC".equals(stringExtra)) {
                        FirebaseInstanceId.m1866b().m1894y();
                    }
                }
                return -1;
            }
        });
    }
}
