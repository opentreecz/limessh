package com.sonelli;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.sonelli.AbstractC1743q0;
import com.sonelli.AbstractC1795r0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.t1 */
/* loaded from: classes.dex */
public class C1894t1 {

    /* renamed from: a */
    public final Context f6680a;

    /* renamed from: b */
    public final BackendRegistry f6681b;

    /* renamed from: c */
    public final EventStore f6682c;

    /* renamed from: d */
    public final WorkScheduler f6683d;

    /* renamed from: e */
    public final Executor f6684e;

    /* renamed from: f */
    public final SynchronizationGuard f6685f;

    /* renamed from: g */
    public final Clock f6686g;

    public C1894t1(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock) {
        this.f6680a = context;
        this.f6681b = backendRegistry;
        this.f6682c = eventStore;
        this.f6683d = workScheduler;
        this.f6684e = executor;
        this.f6685f = synchronizationGuard;
        this.f6686g = clock;
    }

    /* renamed from: c */
    public static /* synthetic */ Object m8568c(C1894t1 c1894t1, AbstractC1795r0 abstractC1795r0, Iterable iterable, AbstractC1138i0 abstractC1138i0, int i) {
        if (abstractC1795r0.mo6824c() == AbstractC1795r0.a.TRANSIENT_ERROR) {
            c1894t1.f6682c.mo758T(iterable);
            c1894t1.f6683d.mo754a(abstractC1138i0, i + 1);
            return null;
        }
        c1894t1.f6682c.mo760j(iterable);
        if (abstractC1795r0.mo6824c() == AbstractC1795r0.a.OK) {
            c1894t1.f6682c.mo762r(abstractC1138i0, c1894t1.f6686g.mo807a() + abstractC1795r0.mo6823b());
        }
        if (!c1894t1.f6682c.mo757S(abstractC1138i0)) {
            return null;
        }
        c1894t1.f6683d.mo754a(abstractC1138i0, 1);
        return null;
    }

    /* renamed from: d */
    public static /* synthetic */ Object m8569d(C1894t1 c1894t1, AbstractC1138i0 abstractC1138i0, int i) {
        c1894t1.f6683d.mo754a(abstractC1138i0, i + 1);
        return null;
    }

    /* renamed from: e */
    public static /* synthetic */ void m8570e(C1894t1 c1894t1, AbstractC1138i0 abstractC1138i0, int i, Runnable runnable) {
        try {
            try {
                SynchronizationGuard synchronizationGuard = c1894t1.f6685f;
                EventStore eventStore = c1894t1.f6682c;
                eventStore.getClass();
                synchronizationGuard.mo784a(C1796r1.m7846a(eventStore));
                if (c1894t1.m8571a()) {
                    c1894t1.m8572f(abstractC1138i0, i);
                } else {
                    c1894t1.f6685f.mo784a(C1842s1.m8299a(c1894t1, abstractC1138i0, i));
                }
            } catch (C0966f3 unused) {
                c1894t1.f6683d.mo754a(abstractC1138i0, i + 1);
            }
        } finally {
            runnable.run();
        }
    }

    /* renamed from: a */
    public boolean m8571a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f6680a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* renamed from: f */
    public void m8572f(AbstractC1138i0 abstractC1138i0, int i) {
        AbstractC1795r0 mo748a;
        TransportBackend mo747a = this.f6681b.mo747a(abstractC1138i0.mo2323b());
        Iterable iterable = (Iterable) this.f6685f.mo784a(C1686p1.m7216a(this, abstractC1138i0));
        if (iterable.iterator().hasNext()) {
            if (mo747a == null) {
                C2253x0.m9656a("Uploader", "Unknown backend for %s, deleting event batch for it...", abstractC1138i0);
                mo748a = AbstractC1795r0.m7836a();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((AbstractC1022g2) it.next()).mo1951b());
                }
                AbstractC1743q0.a m7581a = AbstractC1743q0.m7581a();
                m7581a.mo6606b(arrayList);
                m7581a.mo6607c(abstractC1138i0.mo2324c());
                mo748a = mo747a.mo748a(m7581a.mo6605a());
            }
            this.f6685f.mo784a(C1744q1.m7598a(this, mo748a, iterable, abstractC1138i0, i));
        }
    }

    /* renamed from: g */
    public void m8573g(AbstractC1138i0 abstractC1138i0, int i, Runnable runnable) {
        this.f6684e.execute(RunnableC1629o1.m6833a(this, abstractC1138i0, i, runnable));
    }
}
