package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.sonelli.C1099ha;
import com.sonelli.C1647ob;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new C1647ob();

    /* renamed from: O */
    public final int f905O;

    /* renamed from: P */
    public final String f906P;

    /* renamed from: Q */
    public final FastJsonResponse.Field<?, ?> f907Q;

    public zal(int i, String str, FastJsonResponse.Field<?, ?> field) {
        this.f905O = i;
        this.f906P = str;
        this.f907Q = field;
    }

    public zal(String str, FastJsonResponse.Field<?, ?> field) {
        this.f905O = 1;
        this.f906P = str;
        this.f907Q = field;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f905O);
        C1099ha.m4412q(parcel, 2, this.f906P, false);
        C1099ha.m4411p(parcel, 3, this.f907Q, i, false);
        C1099ha.m4397b(parcel, m4396a);
    }
}
