package com.sonelli;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;

/* compiled from: com.google.firebase:firebase-common@@19.3.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class f70 implements Provider {

    /* renamed from: a */
    public final FirebaseApp f2624a;

    /* renamed from: b */
    public final Context f2625b;

    public f70(FirebaseApp firebaseApp, Context context) {
        this.f2624a = firebaseApp;
        this.f2625b = context;
    }

    /* renamed from: a */
    public static Provider m3687a(FirebaseApp firebaseApp, Context context) {
        return new f70(firebaseApp, context);
    }

    @Override // com.google.firebase.inject.Provider
    public Object get() {
        return FirebaseApp.m1576r(this.f2624a, this.f2625b);
    }
}
