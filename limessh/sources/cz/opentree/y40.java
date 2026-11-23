package cz.opentree;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.internal.zae;
import com.google.android.gms.signin.internal.zai;
import com.google.android.gms.signin.internal.zak;
import com.google.android.gms.signin.zac;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public class y40 extends AbstractC2159v9<zae> implements zac {

    /* renamed from: A */
    public final C1850s9 f8136A;

    /* renamed from: B */
    public final Bundle f8137B;

    /* renamed from: C */
    public Integer f8138C;

    /* renamed from: z */
    public final boolean f8139z;

    public y40(Context context, Looper looper, boolean z, C1850s9 c1850s9, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, c1850s9, connectionCallbacks, onConnectionFailedListener);
        this.f8139z = true;
        this.f8136A = c1850s9;
        this.f8137B = bundle;
        this.f8138C = c1850s9.m8405f();
    }

    public y40(Context context, Looper looper, boolean z, C1850s9 c1850s9, x40 x40Var, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, true, c1850s9, m10082k0(c1850s9), connectionCallbacks, onConnectionFailedListener);
    }

    /* renamed from: k0 */
    public static Bundle m10082k0(C1850s9 c1850s9) {
        x40 m8409j = c1850s9.m8409j();
        Integer m8405f = c1850s9.m8405f();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", c1850s9.m8400a());
        if (m8405f != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", m8405f.intValue());
        }
        if (m8409j != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", m8409j.m9697i());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", m8409j.m9696g());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", m8409j.m9694e());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", m8409j.m9695f());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", m8409j.m9691b());
            bundle.putString("com.google.android.gms.signin.internal.logSessionId", m8409j.m9692c());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", m8409j.m9698j());
            if (m8409j.m9690a() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", m8409j.m9690a().longValue());
            }
            if (m8409j.m9693d() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", m8409j.m9693d().longValue());
            }
        }
        return bundle;
    }

    @Override // com.google.android.gms.signin.zac
    /* renamed from: c */
    public final void mo1510c(com.google.android.gms.signin.internal.zac zacVar) {
        C0813ca.m2730l(zacVar, "Expecting a valid ISignInCallbacks");
        try {
            Account m8402c = this.f8136A.m8402c();
            ((zae) m1100z()).mo1507K0(new zai(new ResolveAccountRequest(m8402c, this.f8138C.intValue(), "<<default account>>".equals(m8402c.name) ? C1588n5.m6639b(m1096v()).m6642c() : null)), zacVar);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                zacVar.mo1503L(new zak(8));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    @Override // com.google.android.gms.signin.zac
    public final void connect() {
        m1083f(new BaseGmsClient.C0436a());
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    /* renamed from: i */
    public String mo1085i() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    /* renamed from: j */
    public /* synthetic */ IInterface mo1086j(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof zae ? (zae) queryLocalInterface : new c50(iBinder);
    }

    @Override // cz.opentree.AbstractC2159v9, com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    /* renamed from: l */
    public int mo972l() {
        return C0810c7.f1875a;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    /* renamed from: n */
    public boolean mo974n() {
        return this.f8139z;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    /* renamed from: o */
    public String mo1089o() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    /* renamed from: w */
    public Bundle mo1097w() {
        if (!m1096v().getPackageName().equals(this.f8136A.m8407h())) {
            this.f8137B.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f8136A.m8407h());
        }
        return this.f8137B;
    }
}
