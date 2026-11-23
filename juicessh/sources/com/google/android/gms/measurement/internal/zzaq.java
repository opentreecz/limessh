package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sonelli.C0813ca;
import com.sonelli.C1099ha;
import com.sonelli.C1621nu;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class zzaq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaq> CREATOR = new C1621nu();

    /* renamed from: O */
    public final String f986O;

    /* renamed from: P */
    public final zzal f987P;

    /* renamed from: Q */
    public final String f988Q;

    /* renamed from: R */
    public final long f989R;

    public zzaq(zzaq zzaqVar, long j) {
        C0813ca.m2729k(zzaqVar);
        this.f986O = zzaqVar.f986O;
        this.f987P = zzaqVar.f987P;
        this.f988Q = zzaqVar.f988Q;
        this.f989R = j;
    }

    public zzaq(String str, zzal zzalVar, String str2, long j) {
        this.f986O = str;
        this.f987P = zzalVar;
        this.f988Q = str2;
        this.f989R = j;
    }

    public final String toString() {
        String str = this.f988Q;
        String str2 = this.f986O;
        String valueOf = String.valueOf(this.f987P);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(valueOf);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4412q(parcel, 2, this.f986O, false);
        C1099ha.m4411p(parcel, 3, this.f987P, i, false);
        C1099ha.m4412q(parcel, 4, this.f988Q, false);
        C1099ha.m4408m(parcel, 5, this.f989R);
        C1099ha.m4397b(parcel, m4396a);
    }
}
