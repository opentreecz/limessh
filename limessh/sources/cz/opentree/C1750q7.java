package cz.opentree;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.q7 */
/* loaded from: classes.dex */
public final class C1750q7<O extends Api.ApiOptions> {

    /* renamed from: a */
    public final boolean f5946a = false;

    /* renamed from: b */
    public final int f5947b;

    /* renamed from: c */
    public final Api<O> f5948c;

    /* renamed from: d */
    public final O f5949d;

    public C1750q7(Api<O> api, O o) {
        this.f5948c = api;
        this.f5949d = o;
        this.f5947b = C0758ba.m2405b(api, o);
    }

    /* renamed from: b */
    public static <O extends Api.ApiOptions> C1750q7<O> m7629b(Api<O> api, O o) {
        return new C1750q7<>(api, o);
    }

    /* renamed from: a */
    public final String m7630a() {
        return this.f5948c.m961b();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1750q7)) {
            return false;
        }
        C1750q7 c1750q7 = (C1750q7) obj;
        return !this.f5946a && !c1750q7.f5946a && C0758ba.m2404a(this.f5948c, c1750q7.f5948c) && C0758ba.m2404a(this.f5949d, c1750q7.f5949d);
    }

    public final int hashCode() {
        return this.f5947b;
    }
}
