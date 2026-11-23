package com.sonelli;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.zl */
/* loaded from: classes.dex */
public final class C2432zl<T> extends AbstractC2358yl<T> {

    /* renamed from: O */
    public final T f8537O;

    public C2432zl(T t) {
        this.f8537O = t;
    }

    @Override // com.sonelli.AbstractC2358yl
    /* renamed from: b */
    public final boolean mo9580b() {
        return true;
    }

    @Override // com.sonelli.AbstractC2358yl
    /* renamed from: c */
    public final T mo9581c() {
        return this.f8537O;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof C2432zl) {
            return this.f8537O.equals(((C2432zl) obj).f8537O);
        }
        return false;
    }

    public final int hashCode() {
        return this.f8537O.hashCode() + 1502476572;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f8537O);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 13);
        sb.append("Optional.of(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }
}
