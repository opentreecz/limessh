package com.sonelli;

import androidx.core.internal.view.SupportMenu;
import com.google.android.gms.internal.measurement.zzgt;
import com.sonelli.AbstractC2303xn;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.kn */
/* loaded from: classes.dex */
public class C1466kn {

    /* renamed from: b */
    public static volatile C1466kn f4618b;

    /* renamed from: c */
    public static volatile C1466kn f4619c;

    /* renamed from: d */
    public static final C1466kn f4620d = new C1466kn(true);

    /* renamed from: a */
    public final Map<a, AbstractC2303xn.f<?, ?>> f4621a;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
    /* renamed from: com.sonelli.kn$a */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        public final Object f4622a;

        /* renamed from: b */
        public final int f4623b;

        public a(Object obj, int i) {
            this.f4622a = obj;
            this.f4623b = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f4622a == aVar.f4622a && this.f4623b == aVar.f4623b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f4622a) * SupportMenu.USER_MASK) + this.f4623b;
        }
    }

    public C1466kn() {
        this.f4621a = new HashMap();
    }

    public C1466kn(boolean z) {
        this.f4621a = Collections.emptyMap();
    }

    /* renamed from: a */
    public static C1466kn m5954a() {
        C1466kn c1466kn = f4618b;
        if (c1466kn == null) {
            synchronized (C1466kn.class) {
                c1466kn = f4618b;
                if (c1466kn == null) {
                    c1466kn = f4620d;
                    f4618b = c1466kn;
                }
            }
        }
        return c1466kn;
    }

    /* renamed from: c */
    public static C1466kn m5955c() {
        C1466kn c1466kn = f4619c;
        if (c1466kn != null) {
            return c1466kn;
        }
        synchronized (C1466kn.class) {
            C1466kn c1466kn2 = f4619c;
            if (c1466kn2 != null) {
                return c1466kn2;
            }
            C1466kn m9314b = AbstractC2180vn.m9314b(C1466kn.class);
            f4619c = m9314b;
            return m9314b;
        }
    }

    /* renamed from: b */
    public final <ContainingType extends zzgt> AbstractC2303xn.f<ContainingType, ?> m5956b(ContainingType containingtype, int i) {
        return (AbstractC2303xn.f) this.f4621a.get(new a(containingtype, i));
    }
}
