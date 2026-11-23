package com.sonelli;

import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.zzaq;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
public final class k50 implements zzaq {

    /* renamed from: a */
    public final /* synthetic */ DataLayer f4488a;

    public k50(DataLayer dataLayer) {
        this.f4488a = dataLayer;
    }

    @Override // com.google.android.gms.tagmanager.zzaq
    /* renamed from: a */
    public final void mo1540a(List<DataLayer.C0453a> list) {
        CountDownLatch countDownLatch;
        for (DataLayer.C0453a c0453a : list) {
            this.f4488a.m1530h(DataLayer.m1525i(c0453a.f1061a, c0453a.f1062b));
        }
        countDownLatch = this.f4488a.f1060f;
        countDownLatch.countDown();
    }
}
