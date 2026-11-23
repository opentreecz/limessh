package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C1099ha;
import cz.opentree.C2162va;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes.dex */
public final class zza extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zza> CREATOR = new C2162va();

    /* renamed from: O */
    public Bundle f868O;

    /* renamed from: P */
    public Feature[] f869P;

    /* renamed from: Q */
    public int f870Q;

    public zza() {
    }

    public zza(Bundle bundle, Feature[] featureArr, int i) {
        this.f868O = bundle;
        this.f869P = featureArr;
        this.f870Q = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4400e(parcel, 1, this.f868O, false);
        C1099ha.m4415t(parcel, 2, this.f869P, i, false);
        C1099ha.m4406k(parcel, 3, this.f870Q);
        C1099ha.m4397b(parcel, m4396a);
    }
}
