package com.sonelli;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class d10 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ String f2098O;

    /* renamed from: P */
    public final /* synthetic */ String f2099P;

    /* renamed from: Q */
    public final /* synthetic */ Object f2100Q;

    /* renamed from: R */
    public final /* synthetic */ long f2101R;

    /* renamed from: S */
    public final /* synthetic */ y00 f2102S;

    public d10(y00 y00Var, String str, String str2, Object obj, long j) {
        this.f2102S = y00Var;
        this.f2098O = str;
        this.f2099P = str2;
        this.f2100Q = obj;
        this.f2101R = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2102S.m10012V(this.f2098O, this.f2099P, this.f2100Q, this.f2101R);
    }
}
