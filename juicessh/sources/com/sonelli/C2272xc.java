package com.sonelli;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.xc */
/* loaded from: classes.dex */
public class C2272xc {

    /* renamed from: b */
    public static C2272xc f7918b = new C2272xc();

    /* renamed from: a */
    public C2213wc f7919a = null;

    /* renamed from: a */
    public static C2213wc m9755a(Context context) {
        return f7918b.m9756b(context);
    }

    /* renamed from: b */
    public final synchronized C2213wc m9756b(Context context) {
        if (this.f7919a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f7919a = new C2213wc(context);
        }
        return this.f7919a;
    }
}
