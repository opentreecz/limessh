package cz.opentree;

import android.app.job.JobInfo;
import androidx.annotation.RequiresApi;
import com.google.android.datatransport.runtime.time.Clock;
import cz.opentree.C1420k1;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.n1 */
/* loaded from: classes.dex */
public abstract class AbstractC1583n1 {

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* renamed from: cz.opentree.n1$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public Clock f5180a;

        /* renamed from: b */
        public Map<EnumC0854d, b> f5181b = new HashMap();

        /* renamed from: a */
        public a m6617a(EnumC0854d enumC0854d, b bVar) {
            this.f5181b.put(enumC0854d, bVar);
            return this;
        }

        /* renamed from: b */
        public AbstractC1583n1 m6618b() {
            Objects.requireNonNull(this.f5180a, "missing required property: clock");
            if (this.f5181b.keySet().size() < EnumC0854d.values().length) {
                throw new IllegalStateException("Not all priorities have been configured");
            }
            Map<EnumC0854d, b> map = this.f5181b;
            this.f5181b = new HashMap();
            return AbstractC1583n1.m6611c(this.f5180a, map);
        }

        /* renamed from: c */
        public a m6619c(Clock clock) {
            this.f5180a = clock;
            return this;
        }
    }

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* renamed from: cz.opentree.n1$b */
    /* loaded from: classes.dex */
    public static abstract class b {

        /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
        /* renamed from: cz.opentree.n1$b$a */
        /* loaded from: classes.dex */
        public static abstract class a {
            /* renamed from: a */
            public abstract b mo5775a();

            /* renamed from: b */
            public abstract a mo5776b(long j);

            /* renamed from: c */
            public abstract a mo5777c(Set<c> set);

            /* renamed from: d */
            public abstract a mo5778d(long j);
        }

        /* renamed from: a */
        public static a m6620a() {
            C1420k1.b bVar = new C1420k1.b();
            bVar.mo5777c(Collections.emptySet());
            return bVar;
        }

        /* renamed from: b */
        public abstract long mo5772b();

        /* renamed from: c */
        public abstract Set<c> mo5773c();

        /* renamed from: d */
        public abstract long mo5774d();
    }

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* renamed from: cz.opentree.n1$c */
    /* loaded from: classes.dex */
    public enum c {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    /* renamed from: a */
    public static a m6610a() {
        return new a();
    }

    /* renamed from: c */
    public static AbstractC1583n1 m6611c(Clock clock, Map<EnumC0854d, b> map) {
        return new C1192j1(clock, map);
    }

    /* renamed from: e */
    public static AbstractC1583n1 m6612e(Clock clock) {
        a m6610a = m6610a();
        EnumC0854d enumC0854d = EnumC0854d.DEFAULT;
        b.a m6620a = b.m6620a();
        m6620a.mo5776b(30000L);
        m6620a.mo5778d(86400000L);
        m6610a.m6617a(enumC0854d, m6620a.mo5775a());
        EnumC0854d enumC0854d2 = EnumC0854d.HIGHEST;
        b.a m6620a2 = b.m6620a();
        m6620a2.mo5776b(1000L);
        m6620a2.mo5778d(86400000L);
        m6610a.m6617a(enumC0854d2, m6620a2.mo5775a());
        EnumC0854d enumC0854d3 = EnumC0854d.VERY_LOW;
        b.a m6620a3 = b.m6620a();
        m6620a3.mo5776b(86400000L);
        m6620a3.mo5778d(86400000L);
        m6620a3.mo5777c(m6613h(c.NETWORK_UNMETERED, c.DEVICE_IDLE));
        m6610a.m6617a(enumC0854d3, m6620a3.mo5775a());
        m6610a.m6619c(clock);
        return m6610a.m6618b();
    }

    /* renamed from: h */
    public static <T> Set<T> m6613h(T... tArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(tArr)));
    }

    @RequiresApi(api = 21)
    /* renamed from: b */
    public JobInfo.Builder m6614b(JobInfo.Builder builder, EnumC0854d enumC0854d, long j, int i) {
        builder.setMinimumLatency(m6615f(enumC0854d, j, i));
        m6616i(builder, mo5034g().get(enumC0854d).mo5773c());
        return builder;
    }

    /* renamed from: d */
    public abstract Clock mo5033d();

    /* renamed from: f */
    public long m6615f(EnumC0854d enumC0854d, long j, int i) {
        long mo807a = j - mo5033d().mo807a();
        b bVar = mo5034g().get(enumC0854d);
        return Math.min(Math.max(((long) Math.pow(2.0d, i - 1)) * bVar.mo5772b(), mo807a), bVar.mo5774d());
    }

    /* renamed from: g */
    public abstract Map<EnumC0854d, b> mo5034g();

    @RequiresApi(api = 21)
    /* renamed from: i */
    public final void m6616i(JobInfo.Builder builder, Set<c> set) {
        if (set.contains(c.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(c.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(c.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }
}
