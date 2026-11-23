package com.sonelli;

import com.google.android.gms.internal.measurement.zzde;
import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.cm */
/* loaded from: classes.dex */
public final class C0837cm<T> implements zzde<T>, Serializable {

    /* renamed from: O */
    @NullableDecl
    public final T f1990O;

    public C0837cm(@NullableDecl T t) {
        this.f1990O = t;
    }

    @Override // com.google.android.gms.internal.measurement.zzde
    /* renamed from: a */
    public final T mo1223a() {
        return this.f1990O;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof C0837cm)) {
            return false;
        }
        T t = this.f1990O;
        T t2 = ((C0837cm) obj).f1990O;
        if (t != t2) {
            return t != null && t.equals(t2);
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f1990O});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f1990O);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("Suppliers.ofInstance(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }
}
