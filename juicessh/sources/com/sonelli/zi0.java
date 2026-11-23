package com.sonelli;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Vibrator;
import androidx.core.app.NotificationCompat;
import com.sonelli.juicessh.R;
import com.sonelli.juicessh.connections.ConnectionManager;
import com.sonelli.juicessh.models.Config;
import jackpal.androidterm.emulatorview.TermSession;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TerminalBellListener.java */
/* loaded from: classes.dex */
public class zi0 implements TermSession.OnBellListener {

    /* renamed from: a */
    public Context f8523a;

    /* renamed from: b */
    public int f8524b;

    /* renamed from: c */
    public UUID f8525c;

    /* renamed from: d */
    public AtomicInteger f8526d = new AtomicInteger(0);

    /* compiled from: TerminalBellListener.java */
    /* renamed from: com.sonelli.zi0$a */
    /* loaded from: classes.dex */
    public class C2428a implements ConnectionManager.ChainRequest {
        public C2428a() {
        }

        @Override // com.sonelli.juicessh.connections.ConnectionManager.ChainRequest
        /* renamed from: a */
        public UUID mo5334a() {
            return zi0.this.f8525c;
        }

        @Override // com.sonelli.juicessh.connections.ConnectionManager.ChainRequest
        /* renamed from: b */
        public void mo5335b(ai0 ai0Var) {
            NotificationCompat.Builder m2103q = ai0Var.m2103q();
            if (ai0Var.m2105s()) {
                gj0.m4141b("TerminalBellListener", "Supressing terminal bell notification as session is in foreground");
                return;
            }
            int incrementAndGet = zi0.this.f8526d.incrementAndGet();
            m2103q.setTicker(zi0.this.f8523a.getString(R.string.terminal_bell_received));
            m2103q.setDefaults(-1);
            m2103q.setNumber(incrementAndGet);
            if (incrementAndGet > 1) {
                m2103q.setContentTitle(zi0.this.f8523a.getString(R.string.app_name) + ": " + String.format(zi0.this.f8523a.getString(R.string.x_terminal_bells), Integer.valueOf(incrementAndGet)) + "!");
            } else {
                m2103q.setContentTitle(zi0.this.f8523a.getString(R.string.app_name) + ": " + zi0.this.f8523a.getString(R.string.terminal_bell) + "!");
            }
            NotificationManager notificationManager = (NotificationManager) zi0.this.f8523a.getSystemService("notification");
            notificationManager.notify(zi0.this.f8524b, m2103q.build());
            notificationManager.notify(zi0.this.f8524b, m2103q.setTicker(null).build());
        }

        @Override // com.sonelli.juicessh.connections.ConnectionManager.ChainRequest
        /* renamed from: c */
        public void mo5336c() {
            gj0.m4142c("TerminalBellListener", "Couldn't show notification for terminal bell as no valid transport chain found");
        }

        @Override // com.sonelli.juicessh.connections.ConnectionManager.ChainRequest
        /* renamed from: d */
        public int mo5337d() {
            return zi0.this.f8524b;
        }

        @Override // com.sonelli.juicessh.connections.ConnectionManager.ChainRequest
        /* renamed from: e */
        public void mo5338e() {
            gj0.m4142c("TerminalBellListener", "Couldn't show notification for terminal bell as session key is incorrect");
        }
    }

    public zi0(Context context, int i, UUID uuid) {
        this.f8523a = context;
        this.f8524b = i;
        this.f8525c = uuid;
    }

    /* renamed from: e */
    public void m10461e(ai0 ai0Var) {
        if (this.f8526d.getAndSet(0) < 1) {
            return;
        }
        ((NotificationManager) this.f8523a.getSystemService("notification")).notify(this.f8524b, ai0Var.m2103q().setContentTitle(this.f8523a.getString(R.string.app_name) + ": " + this.f8523a.getString(R.string.connected)).setNumber(0).setDefaults(0).build());
    }

    @Override // jackpal.androidterm.emulatorview.TermSession.OnBellListener
    public void onBellRecieved() {
        int m5460f = Config.m5460f(this.f8523a, "terminal:bell_mode");
        if (m5460f == -1 || m5460f == 0) {
            gj0.m4141b("TerminalBellListener", "Got a terminal bell - but bell is disabled");
            return;
        }
        if (m5460f == 1) {
            gj0.m4141b("TerminalBellListener", "Got a terminal bell - vibrating device!");
            ((Vibrator) this.f8523a.getSystemService("vibrator")).vibrate(100L);
        } else {
            if (m5460f != 2) {
                return;
            }
            gj0.m4141b("TerminalBellListener", "Got a terminal bell - showing notification!");
            ConnectionManager.m5349b(this.f8523a, new C2428a());
        }
    }
}
