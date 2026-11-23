package cz.opentree;

import android.content.Context;
import androidx.annotation.RestrictTo;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.Destination;
import com.google.android.datatransport.runtime.EncodedDestination;
import com.google.android.datatransport.runtime.TransportInternal;
import com.google.android.datatransport.runtime.TransportRuntimeComponent;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.time.Clock;
import cz.opentree.AbstractC0906e0;
import cz.opentree.AbstractC1138i0;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.l0 */
/* loaded from: classes.dex */
public class C1483l0 implements TransportInternal {

    /* renamed from: e */
    public static volatile TransportRuntimeComponent f4704e;

    /* renamed from: a */
    public final Clock f4705a;

    /* renamed from: b */
    public final Clock f4706b;

    /* renamed from: c */
    public final Scheduler f4707c;

    /* renamed from: d */
    public final C1894t1 f4708d;

    public C1483l0(Clock clock, Clock clock2, Scheduler scheduler, C1894t1 c1894t1, C2254x1 c2254x1) {
        this.f4705a = clock;
        this.f4706b = clock2;
        this.f4707c = scheduler;
        this.f4708d = c1894t1;
        c2254x1.m9667a();
    }

    /* renamed from: c */
    public static C1483l0 m6032c() {
        TransportRuntimeComponent transportRuntimeComponent = f4704e;
        if (transportRuntimeComponent != null) {
            return transportRuntimeComponent.mo744b();
        }
        throw new IllegalStateException("Not initialized!");
    }

    /* renamed from: d */
    public static Set<C0746b> m6033d(Destination destination) {
        return destination instanceof EncodedDestination ? Collections.unmodifiableSet(((EncodedDestination) destination).mo741a()) : Collections.singleton(C0746b.m2321b("proto"));
    }

    /* renamed from: f */
    public static void m6034f(Context context) {
        if (f4704e == null) {
            synchronized (C1483l0.class) {
                if (f4704e == null) {
                    f4704e = C0803c0.m2647c().mo746b(context).mo745a();
                }
            }
        }
    }

    @Override // com.google.android.datatransport.runtime.TransportInternal
    /* renamed from: a */
    public void mo742a(AbstractC1088h0 abstractC1088h0, TransportScheduleCallback transportScheduleCallback) {
        this.f4707c.mo751a(abstractC1088h0.mo1934f().m4682e(abstractC1088h0.mo1932c().mo1930c()), m6035b(abstractC1088h0), transportScheduleCallback);
    }

    /* renamed from: b */
    public final AbstractC0906e0 m6035b(AbstractC1088h0 abstractC1088h0) {
        AbstractC0906e0.a m3349a = AbstractC0906e0.m3349a();
        m3349a.mo3369i(this.f4705a.mo807a());
        m3349a.mo3371k(this.f4706b.mo807a());
        m3349a.mo3370j(abstractC1088h0.mo1935g());
        m3349a.mo3368h(new C0855d0(abstractC1088h0.mo1931b(), abstractC1088h0.m4297d()));
        m3349a.mo3367g(abstractC1088h0.mo1932c().mo1928a());
        return m3349a.mo3364d();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: e */
    public C1894t1 m6036e() {
        return this.f4708d;
    }

    /* renamed from: g */
    public TransportFactory m6037g(Destination destination) {
        Set<C0746b> m6033d = m6033d(destination);
        AbstractC1138i0.a m4681a = AbstractC1138i0.m4681a();
        m4681a.mo2327b(destination.getName());
        m4681a.mo2328c(destination.getExtras());
        return new C1191j0(m6033d, m4681a.mo2326a(), this);
    }
}
