package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C0812c9;
import cz.opentree.C0813ca;
import cz.opentree.C1099ha;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes.dex */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new C0812c9();

    /* renamed from: O */
    public final int f725O;

    /* renamed from: P */
    public final String f726P;

    public Scope(int i, String str) {
        C0813ca.m2726h(str, "scopeUri must not be null or empty");
        this.f725O = i;
        this.f726P = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f726P.equals(((Scope) obj).f726P);
        }
        return false;
    }

    public final int hashCode() {
        return this.f726P.hashCode();
    }

    public final String toString() {
        return this.f726P;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f725O);
        C1099ha.m4412q(parcel, 2, m993x(), false);
        C1099ha.m4397b(parcel, m4396a);
    }

    /* renamed from: x */
    public final String m993x() {
        return this.f726P;
    }
}
