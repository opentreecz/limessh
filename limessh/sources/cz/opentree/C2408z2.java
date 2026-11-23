package cz.opentree;

import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;
import com.google.android.datatransport.runtime.time.Clock;
import dagger.internal.Factory;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.z2 */
/* loaded from: classes.dex */
public final class C2408z2 implements Factory<SQLiteEventStore> {

    /* renamed from: a */
    public final Provider<Clock> f8408a;

    /* renamed from: b */
    public final Provider<Clock> f8409b;

    /* renamed from: c */
    public final Provider<AbstractC0749b2> f8410c;

    /* renamed from: d */
    public final Provider<SchemaManager> f8411d;

    public C2408z2(Provider<Clock> provider, Provider<Clock> provider2, Provider<AbstractC0749b2> provider3, Provider<SchemaManager> provider4) {
        this.f8408a = provider;
        this.f8409b = provider2;
        this.f8410c = provider3;
        this.f8411d = provider4;
    }

    /* renamed from: a */
    public static C2408z2 m10323a(Provider<Clock> provider, Provider<Clock> provider2, Provider<AbstractC0749b2> provider3, Provider<SchemaManager> provider4) {
        return new C2408z2(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SQLiteEventStore get() {
        return new SQLiteEventStore(this.f8408a.get(), this.f8409b.get(), this.f8410c.get(), this.f8411d.get());
    }
}
