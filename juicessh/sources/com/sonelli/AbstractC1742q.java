package com.sonelli;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.sonelli.C1418k;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* renamed from: com.sonelli.q */
/* loaded from: classes.dex */
public abstract class AbstractC1742q {

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* renamed from: com.sonelli.q$a */
    /* loaded from: classes.dex */
    public static abstract class a {
        @NonNull
        /* renamed from: a */
        public abstract a mo5756a(long j);

        @NonNull
        /* renamed from: b */
        public abstract a mo5757b(@Nullable AbstractC1892t abstractC1892t);

        @NonNull
        /* renamed from: c */
        public abstract a mo5758c(@Nullable Integer num);

        @NonNull
        /* renamed from: d */
        public abstract a mo5759d(@Nullable String str);

        @NonNull
        /* renamed from: e */
        public abstract a mo5760e(@Nullable byte[] bArr);

        @NonNull
        /* renamed from: f */
        public abstract AbstractC1742q mo5761f();

        @NonNull
        /* renamed from: g */
        public abstract a mo5762g(long j);

        @NonNull
        /* renamed from: h */
        public abstract a mo5763h(long j);
    }

    @NonNull
    /* renamed from: a */
    public static a m7579a(@NonNull String str) {
        C1418k.b bVar = new C1418k.b();
        bVar.mo5759d(str);
        return bVar;
    }

    @NonNull
    /* renamed from: b */
    public static a m7580b(@NonNull byte[] bArr) {
        C1418k.b bVar = new C1418k.b();
        bVar.mo5760e(bArr);
        return bVar;
    }

    @Nullable
    /* renamed from: c */
    public abstract Integer mo5749c();

    /* renamed from: d */
    public abstract long mo5750d();

    /* renamed from: e */
    public abstract long mo5751e();

    @Nullable
    /* renamed from: f */
    public abstract AbstractC1892t mo5752f();

    @Nullable
    /* renamed from: g */
    public abstract byte[] mo5753g();

    @Nullable
    /* renamed from: h */
    public abstract String mo5754h();

    /* renamed from: i */
    public abstract long mo5755i();
}
