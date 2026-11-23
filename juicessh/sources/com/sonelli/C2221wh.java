package com.sonelli;

import com.google.android.gms.common.util.Clock;

/* renamed from: com.sonelli.wh */
/* loaded from: classes.dex */
public final class C2221wh {

    /* renamed from: a */
    public final Clock f7700a;

    /* renamed from: b */
    public long f7701b;

    public C2221wh(Clock clock) {
        C0813ca.m2729k(clock);
        this.f7700a = clock;
    }

    public C2221wh(Clock clock, long j) {
        C0813ca.m2729k(clock);
        this.f7700a = clock;
        this.f7701b = j;
    }

    /* renamed from: a */
    public final void m9519a() {
        this.f7701b = 0L;
    }

    /* renamed from: b */
    public final void m9520b() {
        this.f7701b = this.f7700a.mo1178b();
    }

    /* renamed from: c */
    public final boolean m9521c(long j) {
        return this.f7701b == 0 || this.f7700a.mo1178b() - this.f7701b > j;
    }
}
