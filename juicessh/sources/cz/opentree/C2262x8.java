package cz.opentree;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.x8 */
/* loaded from: classes.dex */
public final class C2262x8 {

    /* renamed from: a */
    public final ArrayMap<C1750q7<?>, ConnectionResult> f7893a;

    /* renamed from: b */
    public final ArrayMap<C1750q7<?>, String> f7894b;

    /* renamed from: c */
    public final k60<Map<C1750q7<?>, String>> f7895c;

    /* renamed from: d */
    public int f7896d;

    /* renamed from: e */
    public boolean f7897e;

    /* renamed from: a */
    public final void m9728a(C1750q7<?> c1750q7, ConnectionResult connectionResult, @Nullable String str) {
        this.f7893a.put(c1750q7, connectionResult);
        this.f7894b.put(c1750q7, str);
        this.f7896d--;
        if (!connectionResult.m954a0()) {
            this.f7897e = true;
        }
        if (this.f7896d == 0) {
            if (!this.f7897e) {
                this.f7895c.m5844c(this.f7894b);
            } else {
                this.f7895c.m5843b(new C1096h7(this.f7893a));
            }
        }
    }

    /* renamed from: b */
    public final Set<C1750q7<?>> m9729b() {
        return this.f7893a.keySet();
    }
}
