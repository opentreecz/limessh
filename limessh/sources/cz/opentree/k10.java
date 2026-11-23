package cz.opentree;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class k10 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ AtomicReference f4427O;

    /* renamed from: P */
    public final /* synthetic */ String f4428P;

    /* renamed from: Q */
    public final /* synthetic */ String f4429Q;

    /* renamed from: R */
    public final /* synthetic */ String f4430R;

    /* renamed from: S */
    public final /* synthetic */ y00 f4431S;

    public k10(y00 y00Var, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f4431S = y00Var;
        this.f4427O = atomicReference;
        this.f4428P = str;
        this.f4429Q = str2;
        this.f4430R = str3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4431S.f5899a.m9111Q().m3953T(this.f4427O, this.f4428P, this.f4429Q, this.f4430R);
    }
}
