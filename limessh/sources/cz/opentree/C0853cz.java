package cz.opentree;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* renamed from: cz.opentree.cz */
/* loaded from: classes.dex */
public class C0853cz extends BroadcastReceiver {

    /* renamed from: a */
    public final z30 f2084a;

    /* renamed from: b */
    public boolean f2085b;

    /* renamed from: c */
    public boolean f2086c;

    public C0853cz(z30 z30Var) {
        C0813ca.m2729k(z30Var);
        this.f2084a = z30Var;
    }

    @WorkerThread
    /* renamed from: b */
    public final void m3061b() {
        this.f2084a.m10364b0();
        this.f2084a.mo1481g().mo7585d();
        if (this.f2085b) {
            return;
        }
        this.f2084a.mo1482h().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f2086c = this.f2084a.m10353S().m2317z();
        this.f2084a.mo1484j().m8530P().m9084b("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f2086c));
        this.f2085b = true;
    }

    @WorkerThread
    /* renamed from: c */
    public final void m3062c() {
        this.f2084a.m10364b0();
        this.f2084a.mo1481g().mo7585d();
        this.f2084a.mo1481g().mo7585d();
        if (this.f2085b) {
            this.f2084a.mo1484j().m8530P().m9083a("Unregistering connectivity change receiver");
            this.f2085b = false;
            this.f2086c = false;
            try {
                this.f2084a.mo1482h().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.f2084a.mo1484j().m8522H().m9084b("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    @MainThread
    public void onReceive(Context context, Intent intent) {
        this.f2084a.m10364b0();
        String action = intent.getAction();
        this.f2084a.mo1484j().m8530P().m9084b("NetworkBroadcastReceiver received action", action);
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            this.f2084a.mo1484j().m8525K().m9084b("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        boolean m2317z = this.f2084a.m10353S().m2317z();
        if (this.f2086c != m2317z) {
            this.f2086c = m2317z;
            this.f2084a.mo1481g().m8281A(new RunnableC1018fz(this, m2317z));
        }
    }
}
