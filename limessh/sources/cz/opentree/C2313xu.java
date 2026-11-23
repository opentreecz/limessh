package cz.opentree;

import android.os.Bundle;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.xu */
/* loaded from: classes.dex */
public final class C2313xu extends C2446zy {

    /* renamed from: b */
    public final Map<String, Long> f8056b;

    /* renamed from: c */
    public final Map<String, Integer> f8057c;

    /* renamed from: d */
    public long f8058d;

    public C2313xu(C2144uz c2144uz) {
        super(c2144uz);
        this.f8057c = new ArrayMap();
        this.f8056b = new ArrayMap();
    }

    /* renamed from: A */
    public final void m9887A(String str, long j) {
        if (str == null || str.length() == 0) {
            mo1484j().m8522H().m9083a("Ad unit id must be a non-empty string");
        } else {
            mo1481g().m8281A(new RunnableC0738au(this, str, j));
        }
    }

    @WorkerThread
    /* renamed from: B */
    public final void m9888B(String str, long j, b20 b20Var) {
        if (b20Var == null) {
            mo1484j().m8530P().m9083a("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j < 1000) {
            mo1484j().m8530P().m9084b("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j);
        a20.m1959M(b20Var, bundle, true);
        m10662q().m10009S("am", "_xu", bundle);
    }

    @WorkerThread
    /* renamed from: C */
    public final void m9889C(long j) {
        Iterator<String> it = this.f8056b.keySet().iterator();
        while (it.hasNext()) {
            this.f8056b.put(it.next(), Long.valueOf(j));
        }
        if (this.f8056b.isEmpty()) {
            return;
        }
        this.f8058d = j;
    }

    /* renamed from: E */
    public final void m9890E(String str, long j) {
        if (str == null || str.length() == 0) {
            mo1484j().m8522H().m9083a("Ad unit id must be a non-empty string");
        } else {
            mo1481g().m8281A(new RunnableC2444zw(this, str, j));
        }
    }

    @WorkerThread
    /* renamed from: F */
    public final void m9891F(String str, long j) {
        mo7583b();
        mo7585d();
        C0813ca.m2725g(str);
        if (this.f8057c.isEmpty()) {
            this.f8058d = j;
        }
        Integer num = this.f8057c.get(str);
        if (num != null) {
            this.f8057c.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (this.f8057c.size() >= 100) {
            mo1484j().m8525K().m9083a("Too many ads visible");
        } else {
            this.f8057c.put(str, 1);
            this.f8056b.put(str, Long.valueOf(j));
        }
    }

    @WorkerThread
    /* renamed from: G */
    public final void m9892G(String str, long j) {
        mo7583b();
        mo7585d();
        C0813ca.m2725g(str);
        Integer num = this.f8057c.get(str);
        if (num == null) {
            mo1484j().m8522H().m9084b("Call to endAdUnitExposure for unknown ad unit id", str);
            return;
        }
        b20 m1961E = m10665t().m1961E(false);
        int intValue = num.intValue() - 1;
        if (intValue != 0) {
            this.f8057c.put(str, Integer.valueOf(intValue));
            return;
        }
        this.f8057c.remove(str);
        Long l = this.f8056b.get(str);
        if (l == null) {
            mo1484j().m8522H().m9083a("First ad unit exposure time was never set");
        } else {
            long longValue = j - l.longValue();
            this.f8056b.remove(str);
            m9888B(str, longValue, m1961E);
        }
        if (this.f8057c.isEmpty()) {
            long j2 = this.f8058d;
            if (j2 == 0) {
                mo1484j().m8522H().m9083a("First ad exposure time was never set");
            } else {
                m9894x(j - j2, m1961E);
                this.f8058d = 0L;
            }
        }
    }

    @WorkerThread
    /* renamed from: w */
    public final void m9893w(long j) {
        b20 m1961E = m10665t().m1961E(false);
        for (String str : this.f8056b.keySet()) {
            m9888B(str, j - this.f8056b.get(str).longValue(), m1961E);
        }
        if (!this.f8056b.isEmpty()) {
            m9894x(j - this.f8058d, m1961E);
        }
        m9889C(j);
    }

    @WorkerThread
    /* renamed from: x */
    public final void m9894x(long j, b20 b20Var) {
        if (b20Var == null) {
            mo1484j().m8530P().m9083a("Not logging ad exposure. No active activity");
            return;
        }
        if (j < 1000) {
            mo1484j().m8530P().m9084b("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j);
        a20.m1959M(b20Var, bundle, true);
        m10662q().m10009S("am", "_xa", bundle);
    }
}
