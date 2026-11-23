package com.sonelli;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: com.sonelli.ma */
/* loaded from: classes.dex */
public final class C1543ma implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a */
    public final /* synthetic */ OnConnectionFailedListener f5006a;

    public C1543ma(OnConnectionFailedListener onConnectionFailedListener) {
        this.f5006a = onConnectionFailedListener;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    /* renamed from: r */
    public final void mo1103r(@NonNull ConnectionResult connectionResult) {
        this.f5006a.mo1020r(connectionResult);
    }
}
