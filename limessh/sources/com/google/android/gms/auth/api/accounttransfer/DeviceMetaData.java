package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C1099ha;
import cz.opentree.C2152v4;

/* loaded from: classes.dex */
public class DeviceMetaData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DeviceMetaData> CREATOR = new C2152v4();

    /* renamed from: O */
    public final int f558O;

    /* renamed from: P */
    public boolean f559P;

    /* renamed from: Q */
    public long f560Q;

    /* renamed from: R */
    public final boolean f561R;

    public DeviceMetaData(int i, boolean z, long j, boolean z2) {
        this.f558O = i;
        this.f559P = z;
        this.f560Q = j;
        this.f561R = z2;
    }

    /* renamed from: K */
    public boolean m837K() {
        return this.f561R;
    }

    /* renamed from: Y */
    public boolean m838Y() {
        return this.f559P;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f558O);
        C1099ha.m4398c(parcel, 2, m838Y());
        C1099ha.m4408m(parcel, 3, m839x());
        C1099ha.m4398c(parcel, 4, m837K());
        C1099ha.m4397b(parcel, m4396a);
    }

    /* renamed from: x */
    public long m839x() {
        return this.f560Q;
    }
}
