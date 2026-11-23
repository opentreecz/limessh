package cz.opentree;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.auth.zzan;

/* renamed from: cz.opentree.oe */
/* loaded from: classes.dex */
public final class C1651oe extends AbstractC2159v9<zzan> {

    /* renamed from: z */
    public final Bundle f5476z;

    public C1651oe(Context context, Looper looper, C1850s9 c1850s9, C1747q4 c1747q4, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 16, c1850s9, connectionCallbacks, onConnectionFailedListener);
        if (c1747q4 != null) {
            throw new NoSuchMethodError();
        }
        this.f5476z = new Bundle();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    /* renamed from: i */
    public final String mo1085i() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    /* renamed from: j */
    public final /* synthetic */ IInterface mo1086j(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        return queryLocalInterface instanceof zzan ? (zzan) queryLocalInterface : new C1700pe(iBinder);
    }

    @Override // cz.opentree.AbstractC2159v9, com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    /* renamed from: l */
    public final int mo972l() {
        return C0810c7.f1875a;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    /* renamed from: n */
    public final boolean mo974n() {
        C1850s9 m9203f0 = m9203f0();
        return (TextUtils.isEmpty(m9203f0.m8401b()) || m9203f0.m8404e(C1689p4.f5618c).isEmpty()) ? false : true;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    /* renamed from: o */
    public final String mo1089o() {
        return "com.google.android.gms.auth.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    /* renamed from: w */
    public final Bundle mo1097w() {
        return this.f5476z;
    }
}
