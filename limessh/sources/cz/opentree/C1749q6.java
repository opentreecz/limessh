package cz.opentree;

import android.content.Context;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: cz.opentree.q6 */
/* loaded from: classes.dex */
public final class C1749q6 extends Api.AbstractC0426a<C1900t5, GoogleSignInOptions> {
    @Override // com.google.android.gms.common.api.Api.AbstractC0426a
    /* renamed from: a */
    public final /* synthetic */ C1900t5 mo979a(Context context, Looper looper, C1850s9 c1850s9, @Nullable GoogleSignInOptions googleSignInOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new C1900t5(context, looper, c1850s9, googleSignInOptions, connectionCallbacks, onConnectionFailedListener);
    }
}
