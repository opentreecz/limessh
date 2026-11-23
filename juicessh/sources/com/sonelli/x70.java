package com.sonelli;

import com.google.firebase.inject.Provider;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class x70 implements Provider {

    /* renamed from: a */
    public final Set f7892a;

    public x70(Set set) {
        this.f7892a = set;
    }

    /* renamed from: a */
    public static Provider m9727a(Set set) {
        return new x70(set);
    }

    @Override // com.google.firebase.inject.Provider
    public Object get() {
        return z70.m10397g(this.f7892a);
    }
}
