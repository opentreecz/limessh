package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C0813ca;
import cz.opentree.C1099ha;
import cz.opentree.C1549me;

/* loaded from: classes.dex */
public final class zzaf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaf> CREATOR = new C1549me();

    /* renamed from: O */
    public final int f954O = 1;

    /* renamed from: P */
    public final String f955P;

    /* renamed from: Q */
    public final byte[] f956Q;

    public zzaf(int i, String str, byte[] bArr) {
        C0813ca.m2729k(str);
        this.f955P = str;
        C0813ca.m2729k(bArr);
        this.f956Q = bArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f954O);
        C1099ha.m4412q(parcel, 2, this.f955P, false);
        C1099ha.m4401f(parcel, 3, this.f956Q, false);
        C1099ha.m4397b(parcel, m4396a);
    }
}
