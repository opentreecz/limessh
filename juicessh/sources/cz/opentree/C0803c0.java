package cz.opentree;

import android.content.Context;
import com.google.android.datatransport.runtime.TransportRuntimeComponent;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import dagger.internal.Factory;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.c0 */
/* loaded from: classes.dex */
public final class C0803c0 extends TransportRuntimeComponent {

    /* renamed from: O */
    public Provider<Executor> f1841O;

    /* renamed from: P */
    public Provider<Context> f1842P;

    /* renamed from: Q */
    public Provider f1843Q;

    /* renamed from: R */
    public Provider f1844R;

    /* renamed from: S */
    public Provider f1845S;

    /* renamed from: T */
    public Provider<SQLiteEventStore> f1846T;

    /* renamed from: U */
    public Provider<AbstractC1583n1> f1847U;

    /* renamed from: V */
    public Provider<WorkScheduler> f1848V;

    /* renamed from: W */
    public Provider<C0748b1> f1849W;

    /* renamed from: X */
    public Provider<C1894t1> f1850X;

    /* renamed from: Y */
    public Provider<C2254x1> f1851Y;

    /* renamed from: Z */
    public Provider<C1483l0> f1852Z;

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* renamed from: cz.opentree.c0$b */
    /* loaded from: classes.dex */
    public static final class b implements TransportRuntimeComponent.Builder {

        /* renamed from: a */
        public Context f1853a;

        public b() {
        }

        @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent.Builder
        /* renamed from: a */
        public TransportRuntimeComponent mo745a() {
            fm0.m3807a(this.f1853a, Context.class);
            return new C0803c0(this.f1853a);
        }

        @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent.Builder
        /* renamed from: b */
        public /* bridge */ /* synthetic */ TransportRuntimeComponent.Builder mo746b(Context context) {
            m2649c(context);
            return this;
        }

        /* renamed from: c */
        public b m2649c(Context context) {
            fm0.m3808b(context);
            this.f1853a = context;
            return this;
        }
    }

    public C0803c0(Context context) {
        m2648d(context);
    }

    /* renamed from: c */
    public static TransportRuntimeComponent.Builder m2647c() {
        return new b();
    }

    @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent
    /* renamed from: a */
    public EventStore mo743a() {
        return this.f1846T.get();
    }

    @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent
    /* renamed from: b */
    public C1483l0 mo744b() {
        return this.f1852Z.get();
    }

    /* renamed from: d */
    public final void m2648d(Context context) {
        this.f1841O = dm0.m3263a(C1020g0.m3901a());
        Factory m3531a = em0.m3531a(context);
        this.f1842P = m3531a;
        C1989u0 m8821a = C1989u0.m8821a(m3531a, C1092h3.m4344a(), C1141i3.m4710a());
        this.f1843Q = m8821a;
        this.f1844R = dm0.m3263a(C2194w0.m9377a(this.f1842P, m8821a));
        this.f1845S = C0909e3.m3395a(this.f1842P, C0857d2.m3101a(), C0908e2.m3381a());
        this.f1846T = dm0.m3263a(C2408z2.m10323a(C1092h3.m4344a(), C1141i3.m4710a(), C0965f2.m3657a(), this.f1845S));
        C0907e1 m3378b = C0907e1.m3378b(C1092h3.m4344a());
        this.f1847U = m3378b;
        C1021g1 m3926a = C1021g1.m3926a(this.f1842P, this.f1846T, m3378b, C1141i3.m4710a());
        this.f1848V = m3926a;
        Provider<Executor> provider = this.f1841O;
        Provider provider2 = this.f1844R;
        Provider<SQLiteEventStore> provider3 = this.f1846T;
        this.f1849W = C0804c1.m2650a(provider, provider2, m3926a, provider3, provider3);
        Provider<Context> provider4 = this.f1842P;
        Provider provider5 = this.f1844R;
        Provider<SQLiteEventStore> provider6 = this.f1846T;
        this.f1850X = C1990u1.m8831a(provider4, provider5, provider6, this.f1848V, this.f1841O, provider6, C1092h3.m4344a());
        Provider<Executor> provider7 = this.f1841O;
        Provider<SQLiteEventStore> provider8 = this.f1846T;
        this.f1851Y = C2321y1.m10046a(provider7, provider8, this.f1848V, provider8);
        this.f1852Z = dm0.m3263a(C1532m0.m6327a(C1092h3.m4344a(), C1141i3.m4710a(), this.f1849W, this.f1850X, this.f1851Y));
    }
}
