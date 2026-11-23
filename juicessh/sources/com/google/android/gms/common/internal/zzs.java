package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sonelli.C1099ha;
import com.sonelli.C1102hb;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
@Deprecated
/* loaded from: classes.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new C1102hb();

    /* renamed from: O */
    public final int f871O;

    public zzs(int i) {
        this.f871O = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f871O);
        C1099ha.m4397b(parcel, m4396a);
    }
}
