package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C1099ha;
import cz.opentree.d50;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public final class zai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zai> CREATOR = new d50();

    /* renamed from: O */
    public final int f1034O;

    /* renamed from: P */
    public final ResolveAccountRequest f1035P;

    public zai(int i, ResolveAccountRequest resolveAccountRequest) {
        this.f1034O = i;
        this.f1035P = resolveAccountRequest;
    }

    public zai(ResolveAccountRequest resolveAccountRequest) {
        this(1, resolveAccountRequest);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f1034O);
        C1099ha.m4411p(parcel, 2, this.f1035P, i, false);
        C1099ha.m4397b(parcel, m4396a);
    }
}
