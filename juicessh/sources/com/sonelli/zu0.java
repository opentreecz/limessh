package com.sonelli;

import java.util.HashMap;
import java.util.HashSet;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;

/* loaded from: classes.dex */
public class zu0 implements ProviderConfiguration {

    /* renamed from: a */
    public ThreadLocal f8595a = new ThreadLocal();

    /* renamed from: b */
    public volatile cv0 f8596b;

    static {
        new vu0("BC", "threadLocalEcImplicitlyCa");
        new vu0("BC", "ecImplicitlyCa");
        new vu0("BC", "threadLocalDhDefaultParams");
        new vu0("BC", "DhDefaultParams");
        new vu0("BC", "acceptableEcCurves");
        new vu0("BC", "additionalEcParameters");
    }

    public zu0() {
        new ThreadLocal();
        new HashSet();
        new HashMap();
    }

    @Override // org.bouncycastle.jcajce.provider.config.ProviderConfiguration
    /* renamed from: a */
    public cv0 mo10632a() {
        cv0 cv0Var = (cv0) this.f8595a.get();
        return cv0Var != null ? cv0Var : this.f8596b;
    }
}
