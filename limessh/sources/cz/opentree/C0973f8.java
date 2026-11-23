package cz.opentree;

import com.google.android.gms.common.api.internal.BackgroundDetector;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.f8 */
/* loaded from: classes.dex */
public final class C0973f8 implements BackgroundDetector.BackgroundStateChangeListener {

    /* renamed from: a */
    public final /* synthetic */ C1848s7 f2626a;

    public C0973f8(C1848s7 c1848s7) {
        this.f2626a = c1848s7;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    /* renamed from: a */
    public final void mo1005a(boolean z) {
        this.f2626a.f6375m.sendMessage(this.f2626a.f6375m.obtainMessage(1, Boolean.valueOf(z)));
    }
}
