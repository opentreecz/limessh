package cz.opentree;

import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: RouteDatabase.java */
/* loaded from: classes.dex */
public final class mn0 {

    /* renamed from: a */
    public final Set<bn0> f5107a = new LinkedHashSet();

    /* renamed from: a */
    public synchronized void m6483a(bn0 bn0Var) {
        this.f5107a.remove(bn0Var);
    }

    /* renamed from: b */
    public synchronized void m6484b(bn0 bn0Var) {
        this.f5107a.add(bn0Var);
    }

    /* renamed from: c */
    public synchronized boolean m6485c(bn0 bn0Var) {
        return this.f5107a.contains(bn0Var);
    }
}
