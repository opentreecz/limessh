package cz.opentree;

import com.google.android.gms.measurement.internal.zzm;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class c40 implements Callable<String> {

    /* renamed from: a */
    public final /* synthetic */ zzm f1872a;

    /* renamed from: b */
    public final /* synthetic */ z30 f1873b;

    public c40(z30 z30Var, zzm zzmVar) {
        this.f1873b = z30Var;
        this.f1872a = zzmVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        C2318xz m10352R = this.f1873b.m10352R(this.f1872a);
        if (m10352R != null) {
            return m10352R.m9961x();
        }
        this.f1873b.mo1484j().m8525K().m9083a("App info was null when attempting to get app instance id");
        return null;
    }
}
