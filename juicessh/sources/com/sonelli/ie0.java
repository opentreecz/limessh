package com.sonelli;

import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.iid.zzbe;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final class ie0 extends Binder {

    /* renamed from: a */
    public final zzbe f3299a;

    /* renamed from: a */
    public final void m4752a(final le0 le0Var) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "service received new intent via bind strategy");
        }
        this.f3299a.m1904a(le0Var.f4787a).mo2690c(ue0.m8874a(), new OnCompleteListener(le0Var) { // from class: com.sonelli.ke0

            /* renamed from: a */
            public final le0 f4521a;

            {
                this.f4521a = le0Var;
            }

            @Override // com.google.android.gms.tasks.OnCompleteListener
            /* renamed from: a */
            public final void mo1554a(j60 j60Var) {
                this.f4521a.m6153b();
            }
        });
    }
}
