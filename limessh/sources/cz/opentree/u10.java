package cz.opentree;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class u10 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ boolean f6897O;

    /* renamed from: P */
    public final /* synthetic */ Uri f6898P;

    /* renamed from: Q */
    public final /* synthetic */ String f6899Q;

    /* renamed from: R */
    public final /* synthetic */ String f6900R;

    /* renamed from: S */
    public final /* synthetic */ r10 f6901S;

    public u10(r10 r10Var, boolean z, Uri uri, String str, String str2) {
        this.f6901S = r10Var;
        this.f6897O = z;
        this.f6898P = uri;
        this.f6899Q = str;
        this.f6900R = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6901S.m7848b(this.f6897O, this.f6898P, this.f6899Q, this.f6900R);
    }
}
