package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C1099ha;
import cz.opentree.C2289xi;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* loaded from: classes.dex */
public final class zzaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaa> CREATOR = new C2289xi();

    /* renamed from: O */
    public final long f965O;

    /* renamed from: P */
    public final long f966P;

    /* renamed from: Q */
    public final boolean f967Q;

    /* renamed from: R */
    public final String f968R;

    /* renamed from: S */
    public final String f969S;

    /* renamed from: T */
    public final String f970T;

    /* renamed from: U */
    public final Bundle f971U;

    public zzaa(long j, long j2, boolean z, String str, String str2, String str3, Bundle bundle) {
        this.f965O = j;
        this.f966P = j2;
        this.f967Q = z;
        this.f968R = str;
        this.f969S = str2;
        this.f970T = str3;
        this.f971U = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4408m(parcel, 1, this.f965O);
        C1099ha.m4408m(parcel, 2, this.f966P);
        C1099ha.m4398c(parcel, 3, this.f967Q);
        C1099ha.m4412q(parcel, 4, this.f968R, false);
        C1099ha.m4412q(parcel, 5, this.f969S, false);
        C1099ha.m4412q(parcel, 6, this.f970T, false);
        C1099ha.m4400e(parcel, 7, this.f971U, false);
        C1099ha.m4397b(parcel, m4396a);
    }
}
