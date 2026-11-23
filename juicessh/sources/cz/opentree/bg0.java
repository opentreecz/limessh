package cz.opentree;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cz.opentree.ag0;
import cz.opentree.yf0;

/* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
/* loaded from: classes.dex */
public abstract class bg0 {

    /* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
    /* renamed from: cz.opentree.bg0$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0769a {
        @NonNull
        /* renamed from: a */
        public abstract bg0 mo2478a();

        @NonNull
        /* renamed from: b */
        public abstract AbstractC0769a mo2479b(@Nullable String str);

        @NonNull
        /* renamed from: c */
        public abstract AbstractC0769a mo2480c(long j);

        @NonNull
        /* renamed from: d */
        public abstract AbstractC0769a mo2481d(@NonNull String str);

        @NonNull
        /* renamed from: e */
        public abstract AbstractC0769a mo2482e(@Nullable String str);

        @NonNull
        /* renamed from: f */
        public abstract AbstractC0769a mo2483f(@Nullable String str);

        @NonNull
        /* renamed from: g */
        public abstract AbstractC0769a mo2484g(@NonNull ag0.EnumC0710a enumC0710a);

        @NonNull
        /* renamed from: h */
        public abstract AbstractC0769a mo2485h(long j);
    }

    static {
        m2458a().mo2478a();
    }

    @NonNull
    /* renamed from: a */
    public static AbstractC0769a m2458a() {
        yf0.C2344b c2344b = new yf0.C2344b();
        c2344b.mo2485h(0L);
        c2344b.mo2484g(ag0.EnumC0710a.ATTEMPT_MIGRATION);
        c2344b.mo2480c(0L);
        return c2344b;
    }

    @Nullable
    /* renamed from: b */
    public abstract String mo2459b();

    /* renamed from: c */
    public abstract long mo2460c();

    @Nullable
    /* renamed from: d */
    public abstract String mo2461d();

    @Nullable
    /* renamed from: e */
    public abstract String mo2462e();

    @Nullable
    /* renamed from: f */
    public abstract String mo2463f();

    @NonNull
    /* renamed from: g */
    public abstract ag0.EnumC0710a mo2464g();

    /* renamed from: h */
    public abstract long mo2465h();

    /* renamed from: i */
    public boolean m2466i() {
        return mo2464g() == ag0.EnumC0710a.REGISTER_ERROR;
    }

    /* renamed from: j */
    public boolean m2467j() {
        return mo2464g() == ag0.EnumC0710a.NOT_GENERATED || mo2464g() == ag0.EnumC0710a.ATTEMPT_MIGRATION;
    }

    /* renamed from: k */
    public boolean m2468k() {
        return mo2464g() == ag0.EnumC0710a.REGISTERED;
    }

    /* renamed from: l */
    public boolean m2469l() {
        return mo2464g() == ag0.EnumC0710a.UNREGISTERED;
    }

    /* renamed from: m */
    public boolean m2470m() {
        return mo2464g() == ag0.EnumC0710a.ATTEMPT_MIGRATION;
    }

    @NonNull
    /* renamed from: n */
    public abstract AbstractC0769a mo2471n();

    @NonNull
    /* renamed from: o */
    public bg0 m2472o(@NonNull String str, long j, long j2) {
        AbstractC0769a mo2471n = mo2471n();
        mo2471n.mo2479b(str);
        mo2471n.mo2480c(j);
        mo2471n.mo2485h(j2);
        return mo2471n.mo2478a();
    }

    @NonNull
    /* renamed from: p */
    public bg0 m2473p() {
        AbstractC0769a mo2471n = mo2471n();
        mo2471n.mo2479b(null);
        return mo2471n.mo2478a();
    }

    @NonNull
    /* renamed from: q */
    public bg0 m2474q(@NonNull String str) {
        AbstractC0769a mo2471n = mo2471n();
        mo2471n.mo2482e(str);
        mo2471n.mo2484g(ag0.EnumC0710a.REGISTER_ERROR);
        return mo2471n.mo2478a();
    }

    @NonNull
    /* renamed from: r */
    public bg0 m2475r() {
        AbstractC0769a mo2471n = mo2471n();
        mo2471n.mo2484g(ag0.EnumC0710a.NOT_GENERATED);
        return mo2471n.mo2478a();
    }

    @NonNull
    /* renamed from: s */
    public bg0 m2476s(@NonNull String str, @NonNull String str2, long j, @Nullable String str3, long j2) {
        AbstractC0769a mo2471n = mo2471n();
        mo2471n.mo2481d(str);
        mo2471n.mo2484g(ag0.EnumC0710a.REGISTERED);
        mo2471n.mo2479b(str3);
        mo2471n.mo2483f(str2);
        mo2471n.mo2480c(j2);
        mo2471n.mo2485h(j);
        return mo2471n.mo2478a();
    }

    @NonNull
    /* renamed from: t */
    public bg0 m2477t(@NonNull String str) {
        AbstractC0769a mo2471n = mo2471n();
        mo2471n.mo2481d(str);
        mo2471n.mo2484g(ag0.EnumC0710a.UNREGISTERED);
        return mo2471n.mo2478a();
    }
}
