package com.sonelli;

import android.content.Intent;
import android.util.Log;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final class le0 {

    /* renamed from: a */
    public final Intent f4787a;

    /* renamed from: b */
    public final k60<Void> f4788b = new k60<>();

    public le0(Intent intent) {
        this.f4787a = intent;
    }

    /* renamed from: a */
    public final j60<Void> m6152a() {
        return this.f4788b.m5842a();
    }

    /* renamed from: b */
    public final void m6153b() {
        this.f4788b.m5846e(null);
    }

    /* renamed from: c */
    public final /* synthetic */ void m6154c() {
        String action = this.f4787a.getAction();
        StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
        sb.append("Service took too long to process intent: ");
        sb.append(action);
        sb.append(" App may get closed.");
        Log.w("FirebaseInstanceId", sb.toString());
        m6153b();
    }
}
