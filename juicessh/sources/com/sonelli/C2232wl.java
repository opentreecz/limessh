package com.sonelli;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.wl */
/* loaded from: classes.dex */
public final class C2232wl<T> extends AbstractC2358yl<T> {

    /* renamed from: O */
    public static final C2232wl<Object> f7763O = new C2232wl<>();

    @Override // com.sonelli.AbstractC2358yl
    /* renamed from: b */
    public final boolean mo9580b() {
        return false;
    }

    @Override // com.sonelli.AbstractC2358yl
    /* renamed from: c */
    public final T mo9581c() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public final boolean equals(@NullableDecl Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }
}
