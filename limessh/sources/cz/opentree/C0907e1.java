package cz.opentree;

import com.google.android.datatransport.runtime.time.Clock;
import dagger.internal.Factory;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.e1 */
/* loaded from: classes.dex */
public final class C0907e1 implements Factory<AbstractC1583n1> {

    /* renamed from: a */
    public final Provider<Clock> f2316a;

    public C0907e1(Provider<Clock> provider) {
        this.f2316a = provider;
    }

    /* renamed from: a */
    public static AbstractC1583n1 m3377a(Clock clock) {
        AbstractC1583n1 m3090a = AbstractC0856d1.m3090a(clock);
        fm0.m3809c(m3090a, "Cannot return null from a non-@Nullable @Provides method");
        return m3090a;
    }

    /* renamed from: b */
    public static C0907e1 m3378b(Provider<Clock> provider) {
        return new C0907e1(provider);
    }

    @Override // javax.inject.Provider
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public AbstractC1583n1 get() {
        return m3377a(this.f2316a.get());
    }
}
