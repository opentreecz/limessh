package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sonelli.C1099ha;
import com.sonelli.C1853sa;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new C1853sa();

    /* renamed from: O */
    public final int f859O;

    /* renamed from: P */
    public IBinder f860P;

    /* renamed from: Q */
    public ConnectionResult f861Q;

    /* renamed from: R */
    public boolean f862R;

    /* renamed from: S */
    public boolean f863S;

    public ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.f859O = i;
        this.f860P = iBinder;
        this.f861Q = connectionResult;
        this.f862R = z;
        this.f863S = z2;
    }

    /* renamed from: K */
    public ConnectionResult m1130K() {
        return this.f861Q;
    }

    /* renamed from: Y */
    public boolean m1131Y() {
        return this.f862R;
    }

    /* renamed from: Z */
    public boolean m1132Z() {
        return this.f863S;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.f861Q.equals(resolveAccountResponse.f861Q) && m1133x().equals(resolveAccountResponse.m1133x());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f859O);
        C1099ha.m4405j(parcel, 2, this.f860P, false);
        C1099ha.m4411p(parcel, 3, m1130K(), i, false);
        C1099ha.m4398c(parcel, 4, m1131Y());
        C1099ha.m4398c(parcel, 5, m1132Z());
        C1099ha.m4397b(parcel, m4396a);
    }

    /* renamed from: x */
    public IAccountAccessor m1133x() {
        return IAccountAccessor.AbstractBinderC0444a.m1119r(this.f860P);
    }
}
