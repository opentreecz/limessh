package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C0758ba;
import cz.opentree.C1099ha;
import cz.opentree.C2421zc;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes.dex */
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new C2421zc();

    /* renamed from: O */
    public final String f713O;

    /* renamed from: P */
    @Deprecated
    public final int f714P;

    /* renamed from: Q */
    public final long f715Q;

    public Feature(String str, int i, long j) {
        this.f713O = str;
        this.f714P = i;
        this.f715Q = j;
    }

    /* renamed from: K */
    public long m956K() {
        long j = this.f715Q;
        return j == -1 ? this.f714P : j;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((m957x() != null && m957x().equals(feature.m957x())) || (m957x() == null && feature.m957x() == null)) && m956K() == feature.m956K()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return C0758ba.m2405b(m957x(), Long.valueOf(m956K()));
    }

    public String toString() {
        C0758ba.a m2406c = C0758ba.m2406c(this);
        m2406c.m2407a("name", m957x());
        m2406c.m2407a("version", Long.valueOf(m956K()));
        return m2406c.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4412q(parcel, 1, m957x(), false);
        C1099ha.m4406k(parcel, 2, this.f714P);
        C1099ha.m4408m(parcel, 3, m956K());
        C1099ha.m4397b(parcel, m4396a);
    }

    /* renamed from: x */
    public String m957x() {
        return this.f713O;
    }
}
