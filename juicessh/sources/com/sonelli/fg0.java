package com.sonelli;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.sonelli.cg0;

/* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
/* loaded from: classes.dex */
public abstract class fg0 {

    /* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
    /* renamed from: com.sonelli.fg0$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0987a {
        @NonNull
        /* renamed from: a */
        public abstract fg0 mo2790a();

        @NonNull
        /* renamed from: b */
        public abstract AbstractC0987a mo2791b(@NonNull gg0 gg0Var);

        @NonNull
        /* renamed from: c */
        public abstract AbstractC0987a mo2792c(@NonNull String str);

        @NonNull
        /* renamed from: d */
        public abstract AbstractC0987a mo2793d(@NonNull String str);

        @NonNull
        /* renamed from: e */
        public abstract AbstractC0987a mo2794e(@NonNull EnumC0988b enumC0988b);

        @NonNull
        /* renamed from: f */
        public abstract AbstractC0987a mo2795f(@NonNull String str);
    }

    /* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
    /* renamed from: com.sonelli.fg0$b */
    /* loaded from: classes.dex */
    public enum EnumC0988b {
        OK,
        BAD_CONFIG
    }

    @NonNull
    /* renamed from: a */
    public static AbstractC0987a m3771a() {
        return new cg0.C0823b();
    }

    @Nullable
    /* renamed from: b */
    public abstract gg0 mo2785b();

    @Nullable
    /* renamed from: c */
    public abstract String mo2786c();

    @Nullable
    /* renamed from: d */
    public abstract String mo2787d();

    @Nullable
    /* renamed from: e */
    public abstract EnumC0988b mo2788e();

    @Nullable
    /* renamed from: f */
    public abstract String mo2789f();
}
