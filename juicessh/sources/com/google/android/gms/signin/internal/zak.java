package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sonelli.C1099ha;
import com.sonelli.e50;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new e50();

    /* renamed from: O */
    public final int f1036O;

    /* renamed from: P */
    public final ConnectionResult f1037P;

    /* renamed from: Q */
    @Nullable
    public final ResolveAccountResponse f1038Q;

    public zak(int i) {
        this(new ConnectionResult(8, null), null);
    }

    public zak(int i, ConnectionResult connectionResult, @Nullable ResolveAccountResponse resolveAccountResponse) {
        this.f1036O = i;
        this.f1037P = connectionResult;
        this.f1038Q = resolveAccountResponse;
    }

    public zak(ConnectionResult connectionResult, @Nullable ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, null);
    }

    @Nullable
    /* renamed from: K */
    public final ResolveAccountResponse m1508K() {
        return this.f1038Q;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f1036O);
        C1099ha.m4411p(parcel, 2, this.f1037P, i, false);
        C1099ha.m4411p(parcel, 3, this.f1038Q, i, false);
        C1099ha.m4397b(parcel, m4396a);
    }

    /* renamed from: x */
    public final ConnectionResult m1509x() {
        return this.f1037P;
    }
}
