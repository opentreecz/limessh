package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C0813ca;
import cz.opentree.C0911e5;
import cz.opentree.C1099ha;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes.dex */
public final class BeginSignInResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<BeginSignInResult> CREATOR = new C0911e5();

    /* renamed from: O */
    public final PendingIntent f632O;

    public BeginSignInResult(PendingIntent pendingIntent) {
        C0813ca.m2729k(pendingIntent);
        this.f632O = pendingIntent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4411p(parcel, 1, m880x(), i, false);
        C1099ha.m4397b(parcel, m4396a);
    }

    /* renamed from: x */
    public final PendingIntent m880x() {
        return this.f632O;
    }
}
