package cz.opentree;

import android.annotation.TargetApi;
import android.os.Build;
import com.google.android.gms.analytics.zzo;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: cz.opentree.h4 */
/* loaded from: classes.dex */
public final class C1093h4 {

    /* renamed from: a */
    public final C1195j4 f3089a;

    /* renamed from: b */
    public final Clock f3090b;

    /* renamed from: c */
    public boolean f3091c;

    /* renamed from: d */
    public long f3092d;

    /* renamed from: e */
    public long f3093e;

    /* renamed from: f */
    public long f3094f;

    /* renamed from: g */
    public long f3095g;

    /* renamed from: h */
    public long f3096h;

    /* renamed from: i */
    public boolean f3097i;

    /* renamed from: j */
    public final Map<Class<? extends AbstractC1142i4>, AbstractC1142i4> f3098j;

    /* renamed from: k */
    public final List<zzo> f3099k;

    public C1093h4(C1093h4 c1093h4) {
        this.f3089a = c1093h4.f3089a;
        this.f3090b = c1093h4.f3090b;
        this.f3092d = c1093h4.f3092d;
        this.f3093e = c1093h4.f3093e;
        this.f3094f = c1093h4.f3094f;
        this.f3095g = c1093h4.f3095g;
        this.f3096h = c1093h4.f3096h;
        this.f3099k = new ArrayList(c1093h4.f3099k);
        this.f3098j = new HashMap(c1093h4.f3098j.size());
        for (Map.Entry<Class<? extends AbstractC1142i4>, AbstractC1142i4> entry : c1093h4.f3098j.entrySet()) {
            AbstractC1142i4 m4349o = m4349o(entry.getKey());
            entry.getValue().mo4718d(m4349o);
            this.f3098j.put(entry.getKey(), m4349o);
        }
    }

    public C1093h4(C1195j4 c1195j4, Clock clock) {
        C0813ca.m2729k(c1195j4);
        C0813ca.m2729k(clock);
        this.f3089a = c1195j4;
        this.f3090b = clock;
        this.f3095g = 1800000L;
        this.f3096h = 3024000000L;
        this.f3098j = new HashMap();
        this.f3099k = new ArrayList();
    }

    @TargetApi(19)
    /* renamed from: o */
    public static <T extends AbstractC1142i4> T m4349o(Class<T> cls) {
        try {
            return cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            if (e instanceof InstantiationException) {
                throw new IllegalArgumentException("dataType doesn't have default constructor", e);
            }
            if (e instanceof IllegalAccessException) {
                throw new IllegalArgumentException("dataType default constructor is not accessible", e);
            }
            if (Build.VERSION.SDK_INT < 19 || !(e instanceof ReflectiveOperationException)) {
                throw new RuntimeException(e);
            }
            throw new IllegalArgumentException("Linkage exception", e);
        }
    }

    /* renamed from: a */
    public final <T extends AbstractC1142i4> T m4350a(Class<T> cls) {
        return (T) this.f3098j.get(cls);
    }

    /* renamed from: b */
    public final void m4351b(long j) {
        this.f3093e = j;
    }

    /* renamed from: c */
    public final void m4352c(AbstractC1142i4 abstractC1142i4) {
        C0813ca.m2729k(abstractC1142i4);
        Class<?> cls = abstractC1142i4.getClass();
        if (cls.getSuperclass() != AbstractC1142i4.class) {
            throw new IllegalArgumentException();
        }
        abstractC1142i4.mo4718d(m4363n(cls));
    }

    /* renamed from: d */
    public final C1093h4 m4353d() {
        return new C1093h4(this);
    }

    /* renamed from: e */
    public final Collection<AbstractC1142i4> m4354e() {
        return this.f3098j.values();
    }

    /* renamed from: f */
    public final List<zzo> m4355f() {
        return this.f3099k;
    }

    /* renamed from: g */
    public final long m4356g() {
        return this.f3092d;
    }

    /* renamed from: h */
    public final void m4357h() {
        this.f3089a.m5050c().m5833m(this);
    }

    /* renamed from: i */
    public final boolean m4358i() {
        return this.f3091c;
    }

    /* renamed from: j */
    public final void m4359j() {
        this.f3094f = this.f3090b.mo1178b();
        long j = this.f3093e;
        if (j != 0) {
            this.f3092d = j;
        } else {
            this.f3092d = this.f3090b.mo1177a();
        }
        this.f3091c = true;
    }

    /* renamed from: k */
    public final C1195j4 m4360k() {
        return this.f3089a;
    }

    /* renamed from: l */
    public final boolean m4361l() {
        return this.f3097i;
    }

    /* renamed from: m */
    public final void m4362m() {
        this.f3097i = true;
    }

    /* renamed from: n */
    public final <T extends AbstractC1142i4> T m4363n(Class<T> cls) {
        T t = (T) this.f3098j.get(cls);
        if (t != null) {
            return t;
        }
        T t2 = (T) m4349o(cls);
        this.f3098j.put(cls, t2);
        return t2;
    }
}
