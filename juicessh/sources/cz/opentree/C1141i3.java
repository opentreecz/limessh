package cz.opentree;

import com.google.android.datatransport.runtime.time.Clock;
import dagger.internal.Factory;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.i3 */
/* loaded from: classes.dex */
public final class C1141i3 implements Factory<Clock> {

    /* renamed from: a */
    public static final C1141i3 f3260a = new C1141i3();

    /* renamed from: a */
    public static C1141i3 m4710a() {
        return f3260a;
    }

    /* renamed from: c */
    public static Clock m4711c() {
        Clock m3970b = AbstractC1023g3.m3970b();
        fm0.m3809c(m3970b, "Cannot return null from a non-@Nullable @Provides method");
        return m3970b;
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Clock get() {
        return m4711c();
    }
}
