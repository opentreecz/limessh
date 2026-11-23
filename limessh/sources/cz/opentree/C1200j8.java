package cz.opentree;

import com.google.android.gms.common.internal.BaseGmsClient;
import cz.opentree.C1848s7;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.j8 */
/* loaded from: classes.dex */
public final class C1200j8 implements BaseGmsClient.SignOutCallbacks {

    /* renamed from: a */
    public final /* synthetic */ C1848s7.a f3513a;

    public C1200j8(C1848s7.a aVar) {
        this.f3513a = aVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks
    /* renamed from: a */
    public final void mo1105a() {
        C1848s7.this.f6375m.post(new RunnableC1149i8(this));
    }
}
