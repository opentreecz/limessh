package com.sonelli;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.sonelli.C1190j;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* renamed from: com.sonelli.p */
/* loaded from: classes.dex */
public abstract class AbstractC1684p {

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* renamed from: com.sonelli.p$a */
    /* loaded from: classes.dex */
    public static abstract class a {
        @NonNull
        /* renamed from: a */
        public abstract a mo4992a(@Nullable AbstractC0962f abstractC0962f);

        @NonNull
        /* renamed from: b */
        public abstract a mo4993b(@Nullable b bVar);

        @NonNull
        /* renamed from: c */
        public abstract AbstractC1684p mo4994c();
    }

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* renamed from: com.sonelli.p$b */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: O */
        public static final b f5583O = new b("UNKNOWN", 0, 0);

        /* renamed from: P */
        public static final b f5584P = new b("ANDROID_FIREBASE", 1, 23);

        public b(String str, int i, int i2) {
        }
    }

    @NonNull
    /* renamed from: a */
    public static a m7161a() {
        return new C1190j.b();
    }

    @Nullable
    /* renamed from: b */
    public abstract AbstractC0962f mo4990b();

    @Nullable
    /* renamed from: c */
    public abstract b mo4991c();
}
