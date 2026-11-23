package cz.opentree;

import android.os.Handler;
import com.google.android.gms.internal.gtm.zzbw;

/* renamed from: cz.opentree.vh */
/* loaded from: classes.dex */
public final class C2170vh implements zzbw {

    /* renamed from: a */
    public final /* synthetic */ Runnable f7458a;

    /* renamed from: b */
    public final /* synthetic */ C1860sh f7459b;

    public C2170vh(C1860sh c1860sh, Runnable runnable) {
        this.f7459b = c1860sh;
        this.f7458a = runnable;
    }

    @Override // com.google.android.gms.internal.gtm.zzbw
    /* renamed from: a */
    public final void mo1215a(Throwable th) {
        Handler handler;
        handler = this.f7459b.f6440a;
        handler.post(this.f7458a);
    }
}
