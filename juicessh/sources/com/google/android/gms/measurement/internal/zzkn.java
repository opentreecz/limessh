package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sonelli.C0813ca;
import com.sonelli.C1099ha;
import com.sonelli.f40;
import com.sonelli.h40;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class zzkn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzkn> CREATOR = new f40();

    /* renamed from: O */
    public final int f990O;

    /* renamed from: P */
    public final String f991P;

    /* renamed from: Q */
    public final long f992Q;

    /* renamed from: R */
    public final Long f993R;

    /* renamed from: S */
    public final String f994S;

    /* renamed from: T */
    public final String f995T;

    /* renamed from: U */
    public final Double f996U;

    public zzkn(int i, String str, long j, Long l, Float f, String str2, String str3, Double d) {
        this.f990O = i;
        this.f991P = str;
        this.f992Q = j;
        this.f993R = l;
        if (i == 1) {
            this.f996U = f != null ? Double.valueOf(f.doubleValue()) : null;
        } else {
            this.f996U = d;
        }
        this.f994S = str2;
        this.f995T = str3;
    }

    public zzkn(h40 h40Var) {
        this(h40Var.f3102c, h40Var.f3103d, h40Var.f3104e, h40Var.f3101b);
    }

    public zzkn(String str, long j, Object obj, String str2) {
        C0813ca.m2725g(str);
        this.f990O = 2;
        this.f991P = str;
        this.f992Q = j;
        this.f995T = str2;
        if (obj == null) {
            this.f993R = null;
            this.f996U = null;
            this.f994S = null;
            return;
        }
        if (obj instanceof Long) {
            this.f993R = (Long) obj;
            this.f996U = null;
            this.f994S = null;
        } else if (obj instanceof String) {
            this.f993R = null;
            this.f996U = null;
            this.f994S = (String) obj;
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("User attribute given of un-supported type");
            }
            this.f993R = null;
            this.f996U = (Double) obj;
            this.f994S = null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f990O);
        C1099ha.m4412q(parcel, 2, this.f991P, false);
        C1099ha.m4408m(parcel, 3, this.f992Q);
        C1099ha.m4409n(parcel, 4, this.f993R, false);
        C1099ha.m4404i(parcel, 5, null, false);
        C1099ha.m4412q(parcel, 6, this.f994S, false);
        C1099ha.m4412q(parcel, 7, this.f995T, false);
        C1099ha.m4402g(parcel, 8, this.f996U, false);
        C1099ha.m4397b(parcel, m4396a);
    }

    /* renamed from: x */
    public final Object m1501x() {
        Long l = this.f993R;
        if (l != null) {
            return l;
        }
        Double d = this.f996U;
        if (d != null) {
            return d;
        }
        String str = this.f994S;
        if (str != null) {
            return str;
        }
        return null;
    }
}
