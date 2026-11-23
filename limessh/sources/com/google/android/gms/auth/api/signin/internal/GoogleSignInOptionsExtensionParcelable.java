package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C1099ha;
import cz.opentree.C1633o5;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new C1633o5();

    /* renamed from: O */
    public final int f696O;

    /* renamed from: P */
    public int f697P;

    /* renamed from: Q */
    public Bundle f698Q;

    public GoogleSignInOptionsExtensionParcelable(int i, int i2, Bundle bundle) {
        this.f696O = i;
        this.f697P = i2;
        this.f698Q = bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f696O);
        C1099ha.m4406k(parcel, 2, m936x());
        C1099ha.m4400e(parcel, 3, this.f698Q, false);
        C1099ha.m4397b(parcel, m4396a);
    }

    /* renamed from: x */
    public int m936x() {
        return this.f697P;
    }
}
