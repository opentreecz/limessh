package com.sonelli;

import android.content.Context;

/* renamed from: com.sonelli.yf */
/* loaded from: classes.dex */
public final class C2342yf {

    /* renamed from: a */
    public final Context f8200a;

    /* renamed from: b */
    public final Context f8201b;

    public C2342yf(Context context) {
        C0813ca.m2729k(context);
        Context applicationContext = context.getApplicationContext();
        C0813ca.m2730l(applicationContext, "Application context can't be null");
        this.f8200a = applicationContext;
        this.f8201b = applicationContext;
    }

    /* renamed from: a */
    public final Context m10127a() {
        return this.f8200a;
    }

    /* renamed from: b */
    public final Context m10128b() {
        return this.f8201b;
    }
}
