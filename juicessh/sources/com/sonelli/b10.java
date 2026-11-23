package com.sonelli;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class b10 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ String f1570O;

    /* renamed from: P */
    public final /* synthetic */ String f1571P;

    /* renamed from: Q */
    public final /* synthetic */ long f1572Q;

    /* renamed from: R */
    public final /* synthetic */ Bundle f1573R;

    /* renamed from: S */
    public final /* synthetic */ boolean f1574S;

    /* renamed from: T */
    public final /* synthetic */ boolean f1575T;

    /* renamed from: U */
    public final /* synthetic */ boolean f1576U;

    /* renamed from: V */
    public final /* synthetic */ String f1577V;

    /* renamed from: W */
    public final /* synthetic */ y00 f1578W;

    public b10(y00 y00Var, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.f1578W = y00Var;
        this.f1570O = str;
        this.f1571P = str2;
        this.f1572Q = j;
        this.f1573R = bundle;
        this.f1574S = z;
        this.f1575T = z2;
        this.f1576U = z3;
        this.f1577V = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1578W.m10007Q(this.f1570O, this.f1571P, this.f1572Q, this.f1573R, this.f1574S, this.f1575T, this.f1576U, this.f1577V);
    }
}
