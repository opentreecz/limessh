package cz.opentree;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.squareup.picasso.Cache;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* compiled from: Dispatcher.java */
/* loaded from: classes.dex */
public class jl0 {

    /* renamed from: a */
    public final HandlerThreadC1223b f3604a;

    /* renamed from: b */
    public final Context f3605b;

    /* renamed from: c */
    public final ExecutorService f3606c;

    /* renamed from: d */
    public final Downloader f3607d;

    /* renamed from: e */
    public final Map<String, fl0> f3608e;

    /* renamed from: f */
    public final Map<Object, dl0> f3609f;

    /* renamed from: g */
    public final Handler f3610g;

    /* renamed from: h */
    public final Handler f3611h;

    /* renamed from: i */
    public final Cache f3612i;

    /* renamed from: j */
    public final xl0 f3613j;

    /* renamed from: k */
    public final List<fl0> f3614k;

    /* renamed from: l */
    public final C1224c f3615l;

    /* renamed from: m */
    public final boolean f3616m;

    /* renamed from: n */
    public boolean f3617n;

    /* compiled from: Dispatcher.java */
    /* renamed from: cz.opentree.jl0$a */
    /* loaded from: classes.dex */
    public static class HandlerC1222a extends Handler {

        /* renamed from: a */
        public final jl0 f3618a;

        /* compiled from: Dispatcher.java */
        /* renamed from: cz.opentree.jl0$a$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: O */
            public final /* synthetic */ Message f3619O;

            public a(HandlerC1222a handlerC1222a, Message message) {
                this.f3619O = message;
            }

            @Override // java.lang.Runnable
            public void run() {
                throw new AssertionError("Unknown handler message received: " + this.f3619O.what);
            }
        }

        public HandlerC1222a(Looper looper, jl0 jl0Var) {
            super(looper);
            this.f3618a = jl0Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.f3618a.m5162t((dl0) message.obj);
                    return;
                case 2:
                    this.f3618a.m5157o((dl0) message.obj);
                    return;
                case 3:
                case 8:
                default:
                    Picasso.f8618n.post(new a(this, message));
                    return;
                case 4:
                    this.f3618a.m5158p((fl0) message.obj);
                    return;
                case 5:
                    this.f3618a.m5161s((fl0) message.obj);
                    return;
                case 6:
                    this.f3618a.m5159q((fl0) message.obj, false);
                    return;
                case 7:
                    this.f3618a.m5156n();
                    return;
                case 9:
                    this.f3618a.m5160r((NetworkInfo) message.obj);
                    return;
                case 10:
                    this.f3618a.m5155m(message.arg1 == 1);
                    return;
            }
        }
    }

    /* compiled from: Dispatcher.java */
    /* renamed from: cz.opentree.jl0$b */
    /* loaded from: classes.dex */
    public static class HandlerThreadC1223b extends HandlerThread {
        public HandlerThreadC1223b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    /* compiled from: Dispatcher.java */
    /* renamed from: cz.opentree.jl0$c */
    /* loaded from: classes.dex */
    public static class C1224c extends BroadcastReceiver {

        /* renamed from: a */
        public final jl0 f3620a;

        public C1224c(jl0 jl0Var) {
            this.f3620a = jl0Var;
        }

        /* renamed from: a */
        public void m5163a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.f3620a.f3616m) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.f3620a.f3605b.registerReceiver(this, intentFilter);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                if (intent.hasExtra("state")) {
                    this.f3620a.m5144b(intent.getBooleanExtra("state", false));
                }
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                this.f3620a.m5148f(((ConnectivityManager) bm0.m2574o(context, "connectivity")).getActiveNetworkInfo());
            }
        }
    }

    public jl0(Context context, ExecutorService executorService, Handler handler, Downloader downloader, Cache cache, xl0 xl0Var) {
        HandlerThreadC1223b handlerThreadC1223b = new HandlerThreadC1223b();
        this.f3604a = handlerThreadC1223b;
        handlerThreadC1223b.start();
        this.f3605b = context;
        this.f3606c = executorService;
        this.f3608e = new LinkedHashMap();
        this.f3609f = new WeakHashMap();
        this.f3610g = new HandlerC1222a(handlerThreadC1223b.getLooper(), this);
        this.f3607d = downloader;
        this.f3611h = handler;
        this.f3612i = cache;
        this.f3613j = xl0Var;
        this.f3614k = new ArrayList(4);
        this.f3617n = bm0.m2576q(context);
        this.f3616m = bm0.m2575p(context, "android.permission.ACCESS_NETWORK_STATE");
        C1224c c1224c = new C1224c(this);
        this.f3615l = c1224c;
        c1224c.m5163a();
    }

    /* renamed from: a */
    public final void m5143a(fl0 fl0Var) {
        if (fl0Var.m3799s()) {
            return;
        }
        this.f3614k.add(fl0Var);
        if (this.f3610g.hasMessages(7)) {
            return;
        }
        this.f3610g.sendEmptyMessageDelayed(7, 200L);
    }

    /* renamed from: b */
    public void m5144b(boolean z) {
        Handler handler = this.f3610g;
        handler.sendMessage(handler.obtainMessage(10, z ? 1 : 0, 0));
    }

    /* renamed from: c */
    public void m5145c(dl0 dl0Var) {
        Handler handler = this.f3610g;
        handler.sendMessage(handler.obtainMessage(2, dl0Var));
    }

    /* renamed from: d */
    public void m5146d(fl0 fl0Var) {
        Handler handler = this.f3610g;
        handler.sendMessage(handler.obtainMessage(4, fl0Var));
    }

    /* renamed from: e */
    public void m5147e(fl0 fl0Var) {
        Handler handler = this.f3610g;
        handler.sendMessage(handler.obtainMessage(6, fl0Var));
    }

    /* renamed from: f */
    public void m5148f(NetworkInfo networkInfo) {
        Handler handler = this.f3610g;
        handler.sendMessage(handler.obtainMessage(9, networkInfo));
    }

    /* renamed from: g */
    public void m5149g(fl0 fl0Var) {
        Handler handler = this.f3610g;
        handler.sendMessageDelayed(handler.obtainMessage(5, fl0Var), 500L);
    }

    /* renamed from: h */
    public void m5150h(dl0 dl0Var) {
        Handler handler = this.f3610g;
        handler.sendMessage(handler.obtainMessage(1, dl0Var));
    }

    /* renamed from: i */
    public final void m5151i() {
        if (this.f3609f.isEmpty()) {
            return;
        }
        Iterator<dl0> it = this.f3609f.values().iterator();
        while (it.hasNext()) {
            dl0 next = it.next();
            it.remove();
            if (next.m3258e().f8631l) {
                bm0.m2579t("Dispatcher", "replaying", next.m3259f().m8921d());
            }
            m5162t(next);
        }
    }

    /* renamed from: j */
    public final void m5152j(List<fl0> list) {
        if (list == null || list.isEmpty() || !list.get(0).m3796p().f8631l) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (fl0 fl0Var : list) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(bm0.m2570k(fl0Var));
        }
        bm0.m2579t("Dispatcher", "delivered", sb.toString());
    }

    /* renamed from: k */
    public final void m5153k(dl0 dl0Var) {
        Object m3260g = dl0Var.m3260g();
        if (m3260g != null) {
            dl0Var.f2240i = true;
            this.f3609f.put(m3260g, dl0Var);
        }
    }

    /* renamed from: l */
    public final void m5154l(fl0 fl0Var) {
        dl0 m3791j = fl0Var.m3791j();
        if (m3791j != null) {
            m5153k(m3791j);
        }
        List<dl0> m3792k = fl0Var.m3792k();
        if (m3792k != null) {
            int size = m3792k.size();
            for (int i = 0; i < size; i++) {
                m5153k(m3792k.get(i));
            }
        }
    }

    /* renamed from: m */
    public void m5155m(boolean z) {
        this.f3617n = z;
    }

    /* renamed from: n */
    public void m5156n() {
        ArrayList arrayList = new ArrayList(this.f3614k);
        this.f3614k.clear();
        Handler handler = this.f3611h;
        handler.sendMessage(handler.obtainMessage(8, arrayList));
        m5152j(arrayList);
    }

    /* renamed from: o */
    public void m5157o(dl0 dl0Var) {
        String m3257d = dl0Var.m3257d();
        fl0 fl0Var = this.f3608e.get(m3257d);
        if (fl0Var != null) {
            fl0Var.m3790h(dl0Var);
            if (fl0Var.m3789e()) {
                this.f3608e.remove(m3257d);
                if (dl0Var.m3258e().f8631l) {
                    bm0.m2579t("Dispatcher", "canceled", dl0Var.m3259f().m8921d());
                }
            }
        }
        dl0 remove = this.f3609f.remove(dl0Var.m3260g());
        if (remove == null || !remove.m3258e().f8631l) {
            return;
        }
        bm0.m2580u("Dispatcher", "canceled", remove.m3259f().m8921d(), "from replaying");
    }

    /* renamed from: p */
    public void m5158p(fl0 fl0Var) {
        if (!fl0Var.m3802w()) {
            this.f3612i.mo6737c(fl0Var.m3795n(), fl0Var.m3797q());
        }
        this.f3608e.remove(fl0Var.m3795n());
        m5143a(fl0Var);
        if (fl0Var.m3796p().f8631l) {
            bm0.m2580u("Dispatcher", "batched", bm0.m2570k(fl0Var), "for completion");
        }
    }

    /* renamed from: q */
    public void m5159q(fl0 fl0Var, boolean z) {
        if (fl0Var.m3796p().f8631l) {
            String m2570k = bm0.m2570k(fl0Var);
            StringBuilder sb = new StringBuilder();
            sb.append("for error");
            sb.append(z ? " (will replay)" : "");
            bm0.m2580u("Dispatcher", "batched", m2570k, sb.toString());
        }
        this.f3608e.remove(fl0Var.m3795n());
        m5143a(fl0Var);
    }

    /* renamed from: r */
    public void m5160r(NetworkInfo networkInfo) {
        ExecutorService executorService = this.f3606c;
        if (executorService instanceof tl0) {
            ((tl0) executorService).m8761a(networkInfo);
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return;
        }
        m5151i();
    }

    /* renamed from: s */
    public void m5161s(fl0 fl0Var) {
        if (fl0Var.m3799s()) {
            return;
        }
        boolean z = false;
        if (this.f3606c.isShutdown()) {
            m5159q(fl0Var, false);
            return;
        }
        NetworkInfo activeNetworkInfo = this.f3616m ? ((ConnectivityManager) bm0.m2574o(this.f3605b, "connectivity")).getActiveNetworkInfo() : null;
        boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        boolean mo3801v = fl0Var.mo3801v(this.f3617n, activeNetworkInfo);
        boolean mo3803x = fl0Var.mo3803x();
        if (!mo3801v) {
            if (this.f3616m && mo3803x) {
                z = true;
            }
            m5159q(fl0Var, z);
            if (z) {
                m5154l(fl0Var);
                return;
            }
            return;
        }
        if (!this.f3616m || z2) {
            if (fl0Var.m3796p().f8631l) {
                bm0.m2579t("Dispatcher", "retrying", bm0.m2570k(fl0Var));
            }
            fl0Var.f2714Y = this.f3606c.submit(fl0Var);
        } else {
            m5159q(fl0Var, mo3803x);
            if (mo3803x) {
                m5154l(fl0Var);
            }
        }
    }

    /* renamed from: t */
    public void m5162t(dl0 dl0Var) {
        fl0 fl0Var = this.f3608e.get(dl0Var.m3257d());
        if (fl0Var != null) {
            fl0Var.m3788b(dl0Var);
            return;
        }
        if (this.f3606c.isShutdown()) {
            if (dl0Var.m3258e().f8631l) {
                bm0.m2580u("Dispatcher", "ignored", dl0Var.f2233b.m8921d(), "because shut down");
                return;
            }
            return;
        }
        fl0 m3784i = fl0.m3784i(this.f3605b, dl0Var.m3258e(), this, this.f3612i, this.f3613j, dl0Var, this.f3607d);
        m3784i.f2714Y = this.f3606c.submit(m3784i);
        this.f3608e.put(dl0Var.m3257d(), m3784i);
        this.f3609f.remove(dl0Var.m3260g());
        if (dl0Var.m3258e().f8631l) {
            bm0.m2579t("Dispatcher", "enqueued", dl0Var.f2233b.m8921d());
        }
    }
}
