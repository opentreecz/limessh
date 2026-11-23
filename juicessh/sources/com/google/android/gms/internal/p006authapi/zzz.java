package com.google.android.gms.internal.p006authapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sonelli.C1099ha;
import com.sonelli.C1157ie;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes.dex */
public final class zzz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzz> CREATOR = new C1157ie();

    /* renamed from: O */
    public final Credential f948O;

    public zzz(Credential credential) {
        this.f948O = credential;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4411p(parcel, 1, this.f948O, i, false);
        C1099ha.m4397b(parcel, m4396a);
    }
}
