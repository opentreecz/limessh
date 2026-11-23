package com.sonelli;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.zacf;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.internal.zak;
import com.google.android.gms.signin.zac;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: com.sonelli.q8 */
/* loaded from: classes.dex */
public final class BinderC1751q8 extends a50 implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: h */
    public static Api.AbstractC0426a<? extends zac, x40> f5951h = g50.f2834c;

    /* renamed from: a */
    public final Context f5952a;

    /* renamed from: b */
    public final Handler f5953b;

    /* renamed from: c */
    public final Api.AbstractC0426a<? extends zac, x40> f5954c;

    /* renamed from: d */
    public Set<Scope> f5955d;

    /* renamed from: e */
    public C1850s9 f5956e;

    /* renamed from: f */
    public zac f5957f;

    /* renamed from: g */
    public zacf f5958g;

    @WorkerThread
    public BinderC1751q8(Context context, Handler handler, @NonNull C1850s9 c1850s9) {
        this(context, handler, c1850s9, f5951h);
    }

    @WorkerThread
    public BinderC1751q8(Context context, Handler handler, @NonNull C1850s9 c1850s9, Api.AbstractC0426a<? extends zac, x40> abstractC0426a) {
        this.f5952a = context;
        this.f5953b = handler;
        C0813ca.m2730l(c1850s9, "ClientSettings must not be null");
        this.f5956e = c1850s9;
        this.f5955d = c1850s9.m8408i();
        this.f5954c = abstractC0426a;
    }

    @Override // com.google.android.gms.signin.internal.zac
    @BinderThread
    /* renamed from: L */
    public final void mo1503L(zak zakVar) {
        this.f5953b.post(new RunnableC1803r8(this, zakVar));
    }

    @WorkerThread
    /* renamed from: R0 */
    public final void m7633R0(zacf zacfVar) {
        zac zacVar = this.f5957f;
        if (zacVar != null) {
            zacVar.disconnect();
        }
        this.f5956e.m8410k(Integer.valueOf(System.identityHashCode(this)));
        Api.AbstractC0426a<? extends zac, x40> abstractC0426a = this.f5954c;
        Context context = this.f5952a;
        Looper looper = this.f5953b.getLooper();
        C1850s9 c1850s9 = this.f5956e;
        this.f5957f = abstractC0426a.mo979a(context, looper, c1850s9, c1850s9.m8409j(), this, this);
        this.f5958g = zacfVar;
        Set<Scope> set = this.f5955d;
        if (set == null || set.isEmpty()) {
            this.f5953b.post(new RunnableC1693p8(this));
        } else {
            this.f5957f.connect();
        }
    }

    /* renamed from: S0 */
    public final void m7634S0() {
        zac zacVar = this.f5957f;
        if (zacVar != null) {
            zacVar.disconnect();
        }
    }

    @WorkerThread
    /* renamed from: T0 */
    public final void m7635T0(zak zakVar) {
        ConnectionResult m1509x = zakVar.m1509x();
        if (m1509x.m954a0()) {
            ResolveAccountResponse m1508K = zakVar.m1508K();
            ConnectionResult m1130K = m1508K.m1130K();
            if (!m1130K.m954a0()) {
                String valueOf = String.valueOf(m1130K);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                sb.append("Sign-in succeeded with resolve account failure: ");
                sb.append(valueOf);
                Log.wtf("SignInCoordinator", sb.toString(), new Exception());
                this.f5958g.mo1022c(m1130K);
                this.f5957f.disconnect();
                return;
            }
            this.f5958g.mo1021b(m1508K.m1133x(), this.f5955d);
        } else {
            this.f5958g.mo1022c(m1509x);
        }
        this.f5957f.disconnect();
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    @WorkerThread
    /* renamed from: q */
    public final void mo1018q(int i) {
        this.f5957f.disconnect();
    }

    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    @WorkerThread
    /* renamed from: r */
    public final void mo1020r(@NonNull ConnectionResult connectionResult) {
        this.f5958g.mo1022c(connectionResult);
    }

    @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
    @WorkerThread
    /* renamed from: s */
    public final void mo1019s(@Nullable Bundle bundle) {
        this.f5957f.mo1510c(this);
    }
}
