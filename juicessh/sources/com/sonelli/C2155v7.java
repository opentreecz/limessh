package com.sonelli;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: com.sonelli.v7 */
/* loaded from: classes.dex */
public final class C2155v7<L> {

    /* renamed from: a */
    public final L f7412a;

    /* renamed from: b */
    public final String f7413b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2155v7)) {
            return false;
        }
        C2155v7 c2155v7 = (C2155v7) obj;
        return this.f7412a == c2155v7.f7412a && this.f7413b.equals(c2155v7.f7413b);
    }

    public final int hashCode() {
        return (System.identityHashCode(this.f7412a) * 31) + this.f7413b.hashCode();
    }
}
