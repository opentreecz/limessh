package cz.opentree;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public enum d90 {
    NONE,
    JAVA_ONLY,
    ALL;

    @NonNull
    /* renamed from: f */
    public static d90 m3165f(@NonNull jc0 jc0Var) {
        return m3166h(jc0Var.f3541g == 2, jc0Var.f3542h == 2);
    }

    @NonNull
    /* renamed from: h */
    public static d90 m3166h(boolean z, boolean z2) {
        return !z ? NONE : !z2 ? JAVA_ONLY : ALL;
    }
}
