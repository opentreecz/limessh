package com.sonelli;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* renamed from: com.sonelli.lh */
/* loaded from: classes.dex */
public class C1506lh extends BroadcastReceiver {

    /* renamed from: d */
    public static final String f4797d = C1506lh.class.getName();

    /* renamed from: a */
    public final C2216wf f4798a;

    /* renamed from: b */
    public boolean f4799b;

    /* renamed from: c */
    public boolean f4800c;

    public C1506lh(C2216wf c2216wf) {
        C0813ca.m2729k(c2216wf);
        this.f4798a = c2216wf;
    }

    /* renamed from: a */
    public final boolean m6159a() {
        if (!this.f4799b) {
            this.f4798a.m9477e().m8649A0("Connectivity unknown. Receiver not registered");
        }
        return this.f4800c;
    }

    /* renamed from: b */
    public final void m6160b() {
        if (this.f4799b) {
            this.f4798a.m9477e().m8676x0("Unregistering connectivity change receiver");
            this.f4799b = false;
            this.f4800c = false;
            try {
                this.f4798a.m9475a().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.f4798a.m9477e().m8674w0("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    /* renamed from: c */
    public final void m6161c() {
        m6162d();
        if (this.f4799b) {
            return;
        }
        Context m9475a = this.f4798a.m9475a();
        m9475a.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
        intentFilter.addCategory(m9475a.getPackageName());
        m9475a.registerReceiver(this, intentFilter);
        this.f4800c = m6164f();
        this.f4798a.m9477e().m8679z("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f4800c));
        this.f4799b = true;
    }

    /* renamed from: d */
    public final void m6162d() {
        this.f4798a.m9477e();
        this.f4798a.m9480h();
    }

    /* renamed from: e */
    public final void m6163e() {
        Context m9475a = this.f4798a.m9475a();
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(m9475a.getPackageName());
        intent.putExtra(f4797d, true);
        m9475a.sendOrderedBroadcast(intent, null);
    }

    /* renamed from: f */
    public final boolean m6164f() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f4798a.m9475a().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
        } catch (SecurityException unused) {
        }
        return false;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        m6162d();
        String action = intent.getAction();
        this.f4798a.m9477e().m8679z("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean m6164f = m6164f();
            if (this.f4800c != m6164f) {
                this.f4800c = m6164f;
                C1652of m9480h = this.f4798a.m9480h();
                m9480h.m8679z("Network connectivity status changed", Boolean.valueOf(m6164f));
                m9480h.m8662j0().m5829e(new RunnableC1701pf(m9480h, m6164f));
                return;
            }
            return;
        }
        if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
            this.f4798a.m9477e().m8672t0("NetworkBroadcastReceiver received unknown action", action);
        } else {
            if (intent.hasExtra(f4797d)) {
                return;
            }
            C1652of m9480h2 = this.f4798a.m9480h();
            m9480h2.m8676x0("Radio powered up");
            m9480h2.m7021M0();
        }
    }
}
