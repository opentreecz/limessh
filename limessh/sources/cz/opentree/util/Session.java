package cz.opentree.util;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import cz.opentree.al0;
import cz.opentree.limessh.controllers.PinManager;
import cz.opentree.limessh.models.Config;
import cz.opentree.limessh.models.User;
import cz.opentree.kj0;
import cz.opentree.qg0;
import cz.opentree.zk0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONException;

/* loaded from: classes.dex */
public class Session {

    /* renamed from: f */
    public static Session f7255f = new Session();

    /* renamed from: a */
    public ArrayList<PinManager.PinPromptDialog> f7256a = new ArrayList<>();

    /* renamed from: b */
    public volatile Long f7257b = -1L;

    /* renamed from: c */
    public volatile zk0 f7258c = new zk0();

    /* renamed from: d */
    public volatile C2118b f7259d = null;

    /* renamed from: e */
    public SessionExtensionListener f7260e = new C2117a();

    /* loaded from: classes.dex */
    public interface SessionExtensionListener {
        /* renamed from: d */
        void mo9051d();

        /* renamed from: e */
        void mo9052e();
    }

    /* renamed from: cz.opentree.util.Session$a */
    /* loaded from: classes.dex */
    public class C2117a implements SessionExtensionListener {
        public C2117a() {
        }

        @Override // cz.opentree.util.Session.SessionExtensionListener
        /* renamed from: d */
        public void mo9051d() {
            Session.this.m9050i();
            Session.this.f7259d = null;
        }

        @Override // cz.opentree.util.Session.SessionExtensionListener
        /* renamed from: e */
        public void mo9052e() {
            Session.this.f7259d = null;
        }
    }

    /* renamed from: cz.opentree.util.Session$b */
    /* loaded from: classes.dex */
    public class C2118b {

        /* renamed from: a */
        public Vector<PinManager.PinPromptSimpleListener> f7262a;

        /* renamed from: cz.opentree.util.Session$b$a */
        /* loaded from: classes.dex */
        public class a implements PinManager.PinPromptSimpleListener {

            /* renamed from: a */
            public final /* synthetic */ SessionExtensionListener f7264a;

            public a(Session session, SessionExtensionListener sessionExtensionListener) {
                this.f7264a = sessionExtensionListener;
            }

            @Override // cz.opentree.limessh.controllers.PinManager.PinPromptSimpleListener
            /* renamed from: a */
            public synchronized void mo5376a(PinManager.PinPromptDialog pinPromptDialog) {
                Session.this.f7256a.add(pinPromptDialog);
                Iterator<PinManager.PinPromptSimpleListener> it = C2118b.this.m9055c().iterator();
                while (it.hasNext()) {
                    it.next().mo5376a(pinPromptDialog);
                }
            }

            @Override // cz.opentree.limessh.controllers.PinManager.PinPromptSimpleListener
            /* renamed from: d */
            public synchronized void mo5377d() {
                this.f7264a.mo9051d();
                Iterator<PinManager.PinPromptSimpleListener> it = C2118b.this.m9055c().iterator();
                while (it.hasNext()) {
                    it.next().mo5377d();
                }
                C2118b.this.m9054b();
            }

            @Override // cz.opentree.limessh.controllers.PinManager.PinPromptSimpleListener
            /* renamed from: e */
            public synchronized void mo5378e() {
                this.f7264a.mo9052e();
                Iterator<PinManager.PinPromptSimpleListener> it = C2118b.this.m9055c().iterator();
                while (it.hasNext()) {
                    it.next().mo5378e();
                }
                C2118b.this.m9054b();
            }
        }

        public C2118b(FragmentActivity fragmentActivity, PinManager.PinPromptSimpleListener pinPromptSimpleListener, SessionExtensionListener sessionExtensionListener) {
            Vector<PinManager.PinPromptSimpleListener> vector = new Vector<>(new ArrayList());
            this.f7262a = vector;
            vector.add(pinPromptSimpleListener);
            if (Session.m9046g().f7257b.longValue() + Session.m9046g().m9049h().m10496e(fragmentActivity) < System.currentTimeMillis()) {
                PinManager.m5373b(fragmentActivity, false, false, new a(Session.this, sessionExtensionListener));
                return;
            }
            sessionExtensionListener.mo9051d();
            Iterator<PinManager.PinPromptSimpleListener> it = m9055c().iterator();
            while (it.hasNext()) {
                it.next().mo5377d();
            }
            m9054b();
        }

        /* renamed from: a */
        public void m9053a(PinManager.PinPromptSimpleListener pinPromptSimpleListener) {
            this.f7262a.add(pinPromptSimpleListener);
        }

        /* renamed from: b */
        public void m9054b() {
            this.f7262a.clear();
        }

        /* renamed from: c */
        public Vector<PinManager.PinPromptSimpleListener> m9055c() {
            return this.f7262a;
        }
    }

    /* renamed from: e */
    public static void m9045e(Context context) {
        al0 al0Var = new al0();
        try {
            al0Var.put("pinlock:enabled", false);
            al0Var.put("pinlock:timeout", 0);
            al0Var.put("pinlock:attempts", 0);
            al0Var.put("session:timeout", 300000L);
            al0Var.put("version:code", kj0.m5918b(context));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Config.m5462h("session:cache", qg0.m7702c(al0Var.toString(), User.m5527u(context)), context);
    }

    /* renamed from: g */
    public static Session m9046g() {
        return f7255f;
    }

    /* renamed from: d */
    public void m9047d(Activity activity) {
        this.f7259d = null;
        PinManager.f3985a.set(false);
        Iterator<PinManager.PinPromptDialog> it = this.f7256a.iterator();
        while (it.hasNext()) {
            PinManager.PinPromptDialog next = it.next();
            if (!activity.isFinishing()) {
                try {
                    next.dismiss();
                } catch (IllegalStateException unused) {
                }
            }
        }
        this.f7256a.clear();
    }

    /* renamed from: f */
    public void m9048f(FragmentActivity fragmentActivity, PinManager.PinPromptSimpleListener pinPromptSimpleListener) {
        if (this.f7259d == null || this.f7259d.m9055c().isEmpty()) {
            this.f7259d = new C2118b(fragmentActivity, pinPromptSimpleListener, this.f7260e);
        } else {
            this.f7259d.m9053a(pinPromptSimpleListener);
        }
    }

    /* renamed from: h */
    public zk0 m9049h() {
        return this.f7258c;
    }

    /* renamed from: i */
    public final void m9050i() {
        this.f7257b = Long.valueOf(System.currentTimeMillis());
    }
}
