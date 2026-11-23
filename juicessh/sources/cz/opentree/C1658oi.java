package cz.opentree;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: cz.opentree.oi */
/* loaded from: classes.dex */
public final class C1658oi extends AbstractC1142i4<C1658oi> {

    /* renamed from: a */
    public final Map<String, Object> f5499a = new HashMap();

    @Override // cz.opentree.AbstractC1142i4
    /* renamed from: d */
    public final /* synthetic */ void mo4718d(C1658oi c1658oi) {
        C1658oi c1658oi2 = c1658oi;
        C0813ca.m2729k(c1658oi2);
        c1658oi2.f5499a.putAll(this.f5499a);
    }

    /* renamed from: e */
    public final void m7042e(String str, String str2) {
        C0813ca.m2725g(str);
        if (str != null && str.startsWith("&")) {
            str = str.substring(1);
        }
        C0813ca.m2726h(str, "Name can not be empty or \"&\"");
        this.f5499a.put(str, str2);
    }

    /* renamed from: f */
    public final Map<String, Object> m7043f() {
        return Collections.unmodifiableMap(this.f5499a);
    }

    public final String toString() {
        return AbstractC1142i4.m4715a(this.f5499a);
    }
}
