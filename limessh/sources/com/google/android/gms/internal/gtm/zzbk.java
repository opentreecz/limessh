package com.google.android.gms.internal.gtm;

import android.os.Parcel;
import android.os.Parcelable;
import cz.opentree.C1816rg;

/* loaded from: classes.dex */
public final class zzbk implements Parcelable {

    @Deprecated
    public static final Parcelable.Creator<zzbk> CREATOR = new C1816rg();

    /* renamed from: O */
    public String f962O;

    /* renamed from: P */
    public String f963P;

    /* renamed from: Q */
    public String f964Q;

    @Deprecated
    public zzbk() {
    }

    @Deprecated
    public zzbk(Parcel parcel) {
        this.f962O = parcel.readString();
        this.f963P = parcel.readString();
        this.f964Q = parcel.readString();
    }

    /* renamed from: a */
    public final String m1208a() {
        return this.f962O;
    }

    /* renamed from: b */
    public final String m1209b() {
        return this.f964Q;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    @Deprecated
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f962O);
        parcel.writeString(this.f963P);
        parcel.writeString(this.f964Q);
    }
}
