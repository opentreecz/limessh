package cz.opentree;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class r30 {

    /* renamed from: a */
    public final Clock f6168a;

    /* renamed from: b */
    public long f6169b;

    public r30(Clock clock) {
        C0813ca.m2729k(clock);
        this.f6168a = clock;
    }

    /* renamed from: a */
    public final void m7856a() {
        this.f6169b = this.f6168a.mo1178b();
    }

    /* renamed from: b */
    public final boolean m7857b(long j) {
        return this.f6169b == 0 || this.f6168a.mo1178b() - this.f6169b >= 3600000;
    }

    /* renamed from: c */
    public final void m7858c() {
        this.f6169b = 0L;
    }
}
