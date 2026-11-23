package com.sonelli;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzv;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: com.sonelli.t5 */
/* loaded from: classes.dex */
public final class C1900t5 extends AbstractC2159v9<zzv> {

    /* renamed from: z */
    public final GoogleSignInOptions f6709z;

    public C1900t5(Context context, Looper looper, C1850s9 c1850s9, @Nullable GoogleSignInOptions googleSignInOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 91, c1850s9, connectionCallbacks, onConnectionFailedListener);
        GoogleSignInOptions.C0424a c0424a = googleSignInOptions != null ? new GoogleSignInOptions.C0424a(googleSignInOptions) : new GoogleSignInOptions.C0424a();
        c0424a.m933g(C0707ae.m2045a());
        if (!c1850s9.m8403d().isEmpty()) {
            Iterator<Scope> it = c1850s9.m8403d().iterator();
            while (it.hasNext()) {
                c0424a.m932f(it.next(), new Scope[0]);
            }
        }
        this.f6709z = c0424a.m927a();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    /* renamed from: i */
    public final String mo1085i() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    /* renamed from: j */
    public final /* synthetic */ IInterface mo1086j(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        return queryLocalInterface instanceof zzv ? (zzv) queryLocalInterface : new C0913e6(iBinder);
    }

    /* renamed from: k0 */
    public final GoogleSignInOptions m8595k0() {
        return this.f6709z;
    }

    @Override // com.sonelli.AbstractC2159v9, com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    /* renamed from: l */
    public final int mo972l() {
        return C0810c7.f1875a;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    /* renamed from: o */
    public final String mo1089o() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }
}
