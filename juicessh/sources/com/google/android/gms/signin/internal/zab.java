package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sonelli.C1099ha;
import com.sonelli.z40;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public final class zab extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zab> CREATOR = new z40();

    /* renamed from: O */
    public final int f1031O;

    /* renamed from: P */
    public int f1032P;

    /* renamed from: Q */
    @Nullable
    public Intent f1033Q;

    public zab() {
        this(0, null);
    }

    public zab(int i, int i2, @Nullable Intent intent) {
        this.f1031O = i;
        this.f1032P = i2;
        this.f1033Q = intent;
    }

    public zab(int i, @Nullable Intent intent) {
        this(2, 0, null);
    }

    @Override // com.google.android.gms.common.api.Result
    /* renamed from: n */
    public final Status mo991n() {
        return this.f1032P == 0 ? Status.f727S : Status.f731W;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f1031O);
        C1099ha.m4406k(parcel, 2, this.f1032P);
        C1099ha.m4411p(parcel, 3, this.f1033Q, i, false);
        C1099ha.m4397b(parcel, m4396a);
    }
}
