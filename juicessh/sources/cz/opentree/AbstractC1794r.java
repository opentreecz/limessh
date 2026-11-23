package cz.opentree;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cz.opentree.C1482l;
import java.util.List;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* renamed from: cz.opentree.r */
/* loaded from: classes.dex */
public abstract class AbstractC1794r {

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* renamed from: cz.opentree.r$a */
    /* loaded from: classes.dex */
    public static abstract class a {
        @NonNull
        /* renamed from: a */
        public a m7834a(int i) {
            mo6027e(Integer.valueOf(i));
            return this;
        }

        @NonNull
        /* renamed from: b */
        public abstract a mo6024b(long j);

        @NonNull
        /* renamed from: c */
        public abstract a mo6025c(@Nullable AbstractC1684p abstractC1684p);

        @NonNull
        /* renamed from: d */
        public abstract a mo6026d(@Nullable EnumC1988u enumC1988u);

        @NonNull
        /* renamed from: e */
        public abstract a mo6027e(@Nullable Integer num);

        @NonNull
        /* renamed from: f */
        public abstract a mo6028f(@Nullable String str);

        @NonNull
        /* renamed from: g */
        public abstract a mo6029g(@Nullable List<AbstractC1742q> list);

        @NonNull
        /* renamed from: h */
        public abstract AbstractC1794r mo6030h();

        @NonNull
        /* renamed from: i */
        public abstract a mo6031i(long j);

        @NonNull
        /* renamed from: j */
        public a m7835j(@NonNull String str) {
            mo6028f(str);
            return this;
        }
    }

    @NonNull
    /* renamed from: a */
    public static a m7833a() {
        return new C1482l.b();
    }

    @Nullable
    /* renamed from: b */
    public abstract AbstractC1684p mo6017b();

    @Nullable
    /* renamed from: c */
    public abstract List<AbstractC1742q> mo6018c();

    @Nullable
    /* renamed from: d */
    public abstract Integer mo6019d();

    @Nullable
    /* renamed from: e */
    public abstract String mo6020e();

    @Nullable
    /* renamed from: f */
    public abstract EnumC1988u mo6021f();

    /* renamed from: g */
    public abstract long mo6022g();

    /* renamed from: h */
    public abstract long mo6023h();
}
