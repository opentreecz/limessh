package cz.opentree;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.la */
/* loaded from: classes.dex */
public final class C1497la implements BaseGmsClient.BaseConnectionCallbacks {

    /* renamed from: a */
    public final /* synthetic */ ConnectionCallbacks f4771a;

    public C1497la(ConnectionCallbacks connectionCallbacks) {
        this.f4771a = connectionCallbacks;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    /* renamed from: q */
    public final void mo1101q(int i) {
        this.f4771a.mo1018q(i);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    /* renamed from: s */
    public final void mo1102s(@Nullable Bundle bundle) {
        this.f4771a.mo1019s(bundle);
    }
}
