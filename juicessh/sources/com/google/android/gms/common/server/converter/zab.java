package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.sonelli.C1099ha;
import com.sonelli.C1443kb;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public final class zab extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zab> CREATOR = new C1443kb();

    /* renamed from: O */
    public final int f882O;

    /* renamed from: P */
    public final StringToIntConverter f883P;

    public zab(int i, StringToIntConverter stringToIntConverter) {
        this.f882O = i;
        this.f883P = stringToIntConverter;
    }

    public zab(StringToIntConverter stringToIntConverter) {
        this.f882O = 1;
        this.f883P = stringToIntConverter;
    }

    /* renamed from: x */
    public static zab m1146x(FastJsonResponse.FieldConverter<?, ?> fieldConverter) {
        if (fieldConverter instanceof StringToIntConverter) {
            return new zab((StringToIntConverter) fieldConverter);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    /* renamed from: K */
    public final FastJsonResponse.FieldConverter<?, ?> m1147K() {
        StringToIntConverter stringToIntConverter = this.f883P;
        if (stringToIntConverter != null) {
            return stringToIntConverter;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f882O);
        C1099ha.m4411p(parcel, 2, this.f883P, i, false);
        C1099ha.m4397b(parcel, m4396a);
    }
}
