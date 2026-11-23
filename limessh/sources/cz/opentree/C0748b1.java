package cz.opentree;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.b1 */
/* loaded from: classes.dex */
public class C0748b1 implements Scheduler {

    /* renamed from: f */
    public static final Logger f1564f = Logger.getLogger(C1483l0.class.getName());

    /* renamed from: a */
    public final WorkScheduler f1565a;

    /* renamed from: b */
    public final Executor f1566b;

    /* renamed from: c */
    public final BackendRegistry f1567c;

    /* renamed from: d */
    public final EventStore f1568d;

    /* renamed from: e */
    public final SynchronizationGuard f1569e;

    public C0748b1(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        this.f1566b = executor;
        this.f1567c = backendRegistry;
        this.f1565a = workScheduler;
        this.f1568d = eventStore;
        this.f1569e = synchronizationGuard;
    }

    /* renamed from: b */
    public static /* synthetic */ Object m2333b(C0748b1 c0748b1, AbstractC1138i0 abstractC1138i0, AbstractC0906e0 abstractC0906e0) {
        c0748b1.f1568d.mo755M(abstractC1138i0, abstractC0906e0);
        c0748b1.f1565a.mo754a(abstractC1138i0, 1);
        return null;
    }

    /* renamed from: c */
    public static /* synthetic */ void m2334c(C0748b1 c0748b1, AbstractC1138i0 abstractC1138i0, TransportScheduleCallback transportScheduleCallback, AbstractC0906e0 abstractC0906e0) {
        try {
            TransportBackend mo747a = c0748b1.f1567c.mo747a(abstractC1138i0.mo2323b());
            if (mo747a != null) {
                c0748b1.f1569e.mo784a(C0691a1.m1949a(c0748b1, abstractC1138i0, mo747a.mo749b(abstractC0906e0)));
                transportScheduleCallback.mo740a(null);
            } else {
                String format = String.format("Transport backend '%s' is not registered", abstractC1138i0.mo2323b());
                f1564f.warning(format);
                transportScheduleCallback.mo740a(new IllegalArgumentException(format));
            }
        } catch (Exception e) {
            f1564f.warning("Error scheduling event " + e.getMessage());
            transportScheduleCallback.mo740a(e);
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.Scheduler
    /* renamed from: a */
    public void mo751a(AbstractC1138i0 abstractC1138i0, AbstractC0906e0 abstractC0906e0, TransportScheduleCallback transportScheduleCallback) {
        this.f1566b.execute(RunnableC2406z0.m10311a(this, abstractC1138i0, transportScheduleCallback, abstractC0906e0));
    }
}
