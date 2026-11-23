package com.sonelli;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.sonelli.dg0;

/* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
/* loaded from: classes.dex */
public abstract class gg0 {

    /* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
    /* renamed from: com.sonelli.gg0$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1041a {
        @NonNull
        /* renamed from: a */
        public abstract gg0 mo3198a();

        @NonNull
        /* renamed from: b */
        public abstract AbstractC1041a mo3199b(@NonNull EnumC1042b enumC1042b);

        @NonNull
        /* renamed from: c */
        public abstract AbstractC1041a mo3200c(@NonNull String str);

        @NonNull
        /* renamed from: d */
        public abstract AbstractC1041a mo3201d(long j);
    }

    /* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
    /* renamed from: com.sonelli.gg0$b */
    /* loaded from: classes.dex */
    public enum EnumC1042b {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    @NonNull
    /* renamed from: a */
    public static AbstractC1041a m4121a() {
        dg0.C0875b c0875b = new dg0.C0875b();
        c0875b.mo3201d(0L);
        return c0875b;
    }

    @Nullable
    /* renamed from: b */
    public abstract EnumC1042b mo3195b();

    @Nullable
    /* renamed from: c */
    public abstract String mo3196c();

    @NonNull
    /* renamed from: d */
    public abstract long mo3197d();
}
