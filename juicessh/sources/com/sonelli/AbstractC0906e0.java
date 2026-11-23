package com.sonelli;

import androidx.annotation.Nullable;
import com.sonelli.C2405z;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.e0 */
/* loaded from: classes.dex */
public abstract class AbstractC0906e0 {

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* renamed from: com.sonelli.e0$a */
    /* loaded from: classes.dex */
    public static abstract class a {
        /* renamed from: a */
        public final a m3361a(String str, int i) {
            mo3365e().put(str, String.valueOf(i));
            return this;
        }

        /* renamed from: b */
        public final a m3362b(String str, long j) {
            mo3365e().put(str, String.valueOf(j));
            return this;
        }

        /* renamed from: c */
        public final a m3363c(String str, String str2) {
            mo3365e().put(str, str2);
            return this;
        }

        /* renamed from: d */
        public abstract AbstractC0906e0 mo3364d();

        /* renamed from: e */
        public abstract Map<String, String> mo3365e();

        /* renamed from: f */
        public abstract a mo3366f(Map<String, String> map);

        /* renamed from: g */
        public abstract a mo3367g(Integer num);

        /* renamed from: h */
        public abstract a mo3368h(C0855d0 c0855d0);

        /* renamed from: i */
        public abstract a mo3369i(long j);

        /* renamed from: j */
        public abstract a mo3370j(String str);

        /* renamed from: k */
        public abstract a mo3371k(long j);
    }

    /* renamed from: a */
    public static a m3349a() {
        C2405z.b bVar = new C2405z.b();
        bVar.mo3366f(new HashMap());
        return bVar;
    }

    /* renamed from: b */
    public final String m3350b(String str) {
        String str2 = mo3351c().get(str);
        return str2 == null ? "" : str2;
    }

    /* renamed from: c */
    public abstract Map<String, String> mo3351c();

    @Nullable
    /* renamed from: d */
    public abstract Integer mo3352d();

    /* renamed from: e */
    public abstract C0855d0 mo3353e();

    /* renamed from: f */
    public abstract long mo3354f();

    /* renamed from: g */
    public final int m3355g(String str) {
        String str2 = mo3351c().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    /* renamed from: h */
    public final long m3356h(String str) {
        String str2 = mo3351c().get(str);
        if (str2 == null) {
            return 0L;
        }
        return Long.valueOf(str2).longValue();
    }

    /* renamed from: i */
    public final Map<String, String> m3357i() {
        return Collections.unmodifiableMap(mo3351c());
    }

    /* renamed from: j */
    public abstract String mo3358j();

    /* renamed from: k */
    public abstract long mo3359k();

    /* renamed from: l */
    public a m3360l() {
        C2405z.b bVar = new C2405z.b();
        bVar.mo3370j(mo3358j());
        bVar.mo3367g(mo3352d());
        bVar.mo3368h(mo3353e());
        bVar.mo3369i(mo3354f());
        bVar.mo3371k(mo3359k());
        bVar.mo3366f(new HashMap(mo3351c()));
        return bVar;
    }
}
