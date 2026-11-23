package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.RequiresPermission;
import com.sonelli.C0771bi;
import com.sonelli.C0807c4;
import com.sonelli.C2216wf;
import com.sonelli.C2277xh;
import com.sonelli.C2323y3;
import com.sonelli.C2426zh;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class GoogleAnalytics extends C0807c4 {

    /* renamed from: k */
    public static List<Runnable> f532k = new ArrayList();

    /* renamed from: f */
    public boolean f533f;

    /* renamed from: g */
    public Set<zza> f534g;

    /* renamed from: h */
    public boolean f535h;

    /* renamed from: i */
    public boolean f536i;

    /* renamed from: j */
    public volatile boolean f537j;

    @TargetApi(14)
    /* renamed from: com.google.android.gms.analytics.GoogleAnalytics$a */
    /* loaded from: classes.dex */
    public class C0422a implements Application.ActivityLifecycleCallbacks {
        public C0422a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            GoogleAnalytics.this.m822p(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            GoogleAnalytics.this.m825t(activity);
        }
    }

    /* loaded from: classes.dex */
    public interface zza {
        /* renamed from: a */
        void mo827a(Activity activity);

        /* renamed from: h */
        void mo828h(Activity activity);
    }

    public GoogleAnalytics(C2216wf c2216wf) {
        super(c2216wf);
        this.f534g = new HashSet();
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    /* renamed from: k */
    public static GoogleAnalytics m813k(Context context) {
        return C2216wf.m9474c(context).m9488p();
    }

    /* renamed from: s */
    public static void m814s() {
        synchronized (GoogleAnalytics.class) {
            List<Runnable> list = f532k;
            if (list != null) {
                Iterator<Runnable> it = list.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                f532k = null;
            }
        }
    }

    /* renamed from: h */
    public final void m815h() {
        m2667g().m9480h().m7021M0();
    }

    @TargetApi(14)
    /* renamed from: i */
    public final void m816i(Application application) {
        if (this.f535h) {
            return;
        }
        application.registerActivityLifecycleCallbacks(new C0422a());
        this.f535h = true;
    }

    /* renamed from: j */
    public final boolean m817j() {
        return this.f537j;
    }

    /* renamed from: l */
    public final boolean m818l() {
        return this.f536i;
    }

    /* renamed from: m */
    public final boolean m819m() {
        return this.f533f;
    }

    /* renamed from: n */
    public final C2323y3 m820n(int i) {
        C2323y3 c2323y3;
        C2426zh m8682D0;
        synchronized (this) {
            c2323y3 = new C2323y3(m2667g(), null, null);
            if (i > 0 && (m8682D0 = new C2277xh(m2667g()).m8682D0(i)) != null) {
                c2323y3.m10076O0(m8682D0);
            }
            c2323y3.m8877D0();
        }
        return c2323y3;
    }

    /* renamed from: o */
    public final void m821o(boolean z) {
        this.f536i = z;
    }

    /* renamed from: p */
    public final void m822p(Activity activity) {
        Iterator<zza> it = this.f534g.iterator();
        while (it.hasNext()) {
            it.next().mo827a(activity);
        }
    }

    /* renamed from: q */
    public final void m823q(zza zzaVar) {
        this.f534g.add(zzaVar);
        Context m9475a = m2667g().m9475a();
        if (m9475a instanceof Application) {
            m816i((Application) m9475a);
        }
    }

    /* renamed from: r */
    public final void m824r() {
        C0771bi m9482j = m2667g().m9482j();
        m9482j.m2488I0();
        if (m9482j.m2489J0()) {
            m821o(m9482j.m2490K0());
        }
        m9482j.m2488I0();
        this.f533f = true;
    }

    /* renamed from: t */
    public final void m825t(Activity activity) {
        Iterator<zza> it = this.f534g.iterator();
        while (it.hasNext()) {
            it.next().mo828h(activity);
        }
    }

    /* renamed from: u */
    public final void m826u(zza zzaVar) {
        this.f534g.remove(zzaVar);
    }
}
