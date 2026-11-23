package com.sonelli;

import android.os.Bundle;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final class wd0 extends ud0<Bundle> {
    public wd0(int i, int i2, Bundle bundle) {
        super(i, 1, bundle);
    }

    @Override // com.sonelli.ud0
    /* renamed from: a */
    public final void mo8867a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        m8869c(bundle2);
    }

    @Override // com.sonelli.ud0
    /* renamed from: d */
    public final boolean mo8870d() {
        return false;
    }
}
