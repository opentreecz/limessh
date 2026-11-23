package com.amazonaws.util;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class TimingInfo {

    /* renamed from: a */
    public final long f490a;

    /* renamed from: b */
    public Long f491b;

    public TimingInfo(Long l, long j, Long l2) {
        this.f490a = j;
        this.f491b = l2;
    }

    /* renamed from: b */
    public static double m681b(long j, long j2) {
        return TimeUnit.NANOSECONDS.toMicros(j2 - j) / 1000.0d;
    }

    /* renamed from: m */
    public static TimingInfo m682m() {
        return new TimingInfo(Long.valueOf(System.currentTimeMillis()), System.nanoTime(), null);
    }

    /* renamed from: n */
    public static TimingInfo m683n() {
        return new TimingInfoFullSupport(Long.valueOf(System.currentTimeMillis()), System.nanoTime(), null);
    }

    /* renamed from: o */
    public static TimingInfo m684o(long j) {
        return new TimingInfoFullSupport(null, j, null);
    }

    /* renamed from: p */
    public static TimingInfo m685p(long j, Long l) {
        return new TimingInfoUnmodifiable(null, j, l);
    }

    /* renamed from: a */
    public void mo686a(String str, TimingInfo timingInfo) {
    }

    /* renamed from: c */
    public TimingInfo mo687c() {
        this.f491b = Long.valueOf(System.nanoTime());
        return this;
    }

    /* renamed from: d */
    public Map<String, Number> mo688d() {
        return Collections.emptyMap();
    }

    /* renamed from: e */
    public final long m689e() {
        Long l = this.f491b;
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    /* renamed from: f */
    public final long m690f() {
        return this.f490a;
    }

    /* renamed from: g */
    public Map<String, List<TimingInfo>> mo691g() {
        return Collections.emptyMap();
    }

    @Deprecated
    /* renamed from: h */
    public final double m692h() {
        Double m693i = m693i();
        if (m693i == null) {
            return -1.0d;
        }
        return m693i.doubleValue();
    }

    /* renamed from: i */
    public final Double m693i() {
        if (m695k()) {
            return Double.valueOf(m681b(this.f490a, this.f491b.longValue()));
        }
        return null;
    }

    /* renamed from: j */
    public void mo694j(String str) {
    }

    /* renamed from: k */
    public final boolean m695k() {
        return this.f491b != null;
    }

    /* renamed from: l */
    public void mo696l(String str, long j) {
    }

    public final String toString() {
        return String.valueOf(m692h());
    }
}
