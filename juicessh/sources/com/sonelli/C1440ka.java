package com.sonelli;

import android.app.Activity;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: com.sonelli.ka */
/* loaded from: classes.dex */
public final class C1440ka extends AbstractDialogInterfaceOnClickListenerC1998u9 {

    /* renamed from: O */
    public final /* synthetic */ Intent f4497O;

    /* renamed from: P */
    public final /* synthetic */ Activity f4498P;

    /* renamed from: Q */
    public final /* synthetic */ int f4499Q;

    public C1440ka(Intent intent, Activity activity, int i) {
        this.f4497O = intent;
        this.f4498P = activity;
        this.f4499Q = i;
    }

    @Override // com.sonelli.AbstractDialogInterfaceOnClickListenerC1998u9
    /* renamed from: b */
    public final void mo5851b() {
        Intent intent = this.f4497O;
        if (intent != null) {
            this.f4498P.startActivityForResult(intent, this.f4499Q);
        }
    }
}
