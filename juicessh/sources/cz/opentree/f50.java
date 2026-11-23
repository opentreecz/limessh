package cz.opentree;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public final class f50 extends Api.AbstractC0426a<y40, x40> {
    @Override // com.google.android.gms.common.api.Api.AbstractC0426a
    /* renamed from: a */
    public final /* synthetic */ y40 mo979a(Context context, Looper looper, C1850s9 c1850s9, x40 x40Var, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        x40 x40Var2 = x40Var;
        if (x40Var2 == null) {
            x40Var2 = x40.f7866X;
        }
        return new y40(context, looper, true, c1850s9, x40Var2, connectionCallbacks, onConnectionFailedListener);
    }
}
