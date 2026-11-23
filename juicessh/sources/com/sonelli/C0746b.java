package com.sonelli;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;

/* compiled from: com.google.android.datatransport:transport-api@@2.2.0 */
/* renamed from: com.sonelli.b */
/* loaded from: classes.dex */
public final class C0746b {

    /* renamed from: a */
    public final String f1551a;

    public C0746b(@NonNull String str) {
        Objects.requireNonNull(str, "name is null");
        this.f1551a = str;
    }

    /* renamed from: b */
    public static C0746b m2321b(@NonNull String str) {
        return new C0746b(str);
    }

    /* renamed from: a */
    public String m2322a() {
        return this.f1551a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0746b) {
            return this.f1551a.equals(((C0746b) obj).f1551a);
        }
        return false;
    }

    public int hashCode() {
        return this.f1551a.hashCode() ^ 1000003;
    }

    @NonNull
    public String toString() {
        return "Encoding{name=\"" + this.f1551a + "\"}";
    }
}
