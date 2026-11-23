package com.sonelli;

import com.google.android.gms.common.util.Clock;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* renamed from: com.sonelli.ih */
/* loaded from: classes.dex */
public final class C1160ih {

    /* renamed from: a */
    public final long f3314a;

    /* renamed from: b */
    public final int f3315b;

    /* renamed from: c */
    public double f3316c;

    /* renamed from: d */
    public long f3317d;

    /* renamed from: e */
    public final Object f3318e;

    /* renamed from: f */
    public final String f3319f;

    /* renamed from: g */
    public final Clock f3320g;

    public C1160ih(int i, long j, String str, Clock clock) {
        this.f3318e = new Object();
        this.f3315b = 60;
        this.f3316c = 60;
        this.f3314a = 2000L;
        this.f3319f = str;
        this.f3320g = clock;
    }

    public C1160ih(String str, Clock clock) {
        this(60, 2000L, str, clock);
    }

    /* renamed from: a */
    public final boolean m4778a() {
        synchronized (this.f3318e) {
            long mo1177a = this.f3320g.mo1177a();
            double d = this.f3316c;
            int i = this.f3315b;
            if (d < i) {
                double d2 = (mo1177a - this.f3317d) / this.f3314a;
                if (d2 > ShadowDrawableWrapper.COS_45) {
                    this.f3316c = Math.min(i, d + d2);
                }
            }
            this.f3317d = mo1177a;
            double d3 = this.f3316c;
            if (d3 >= 1.0d) {
                this.f3316c = d3 - 1.0d;
                return true;
            }
            String str = this.f3319f;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
            sb.append("Excessive ");
            sb.append(str);
            sb.append(" detected; call ignored.");
            C1212jh.m5112c(sb.toString());
            return false;
        }
    }
}
