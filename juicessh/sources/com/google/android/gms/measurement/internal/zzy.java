package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sonelli.C0813ca;
import com.sonelli.C1099ha;
import com.sonelli.v40;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class zzy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzy> CREATOR = new v40();

    /* renamed from: O */
    public String f1019O;

    /* renamed from: P */
    public String f1020P;

    /* renamed from: Q */
    public zzkn f1021Q;

    /* renamed from: R */
    public long f1022R;

    /* renamed from: S */
    public boolean f1023S;

    /* renamed from: T */
    public String f1024T;

    /* renamed from: U */
    public zzaq f1025U;

    /* renamed from: V */
    public long f1026V;

    /* renamed from: W */
    public zzaq f1027W;

    /* renamed from: X */
    public long f1028X;

    /* renamed from: Y */
    public zzaq f1029Y;

    public zzy(zzy zzyVar) {
        C0813ca.m2729k(zzyVar);
        this.f1019O = zzyVar.f1019O;
        this.f1020P = zzyVar.f1020P;
        this.f1021Q = zzyVar.f1021Q;
        this.f1022R = zzyVar.f1022R;
        this.f1023S = zzyVar.f1023S;
        this.f1024T = zzyVar.f1024T;
        this.f1025U = zzyVar.f1025U;
        this.f1026V = zzyVar.f1026V;
        this.f1027W = zzyVar.f1027W;
        this.f1028X = zzyVar.f1028X;
        this.f1029Y = zzyVar.f1029Y;
    }

    public zzy(String str, String str2, zzkn zzknVar, long j, boolean z, String str3, zzaq zzaqVar, long j2, zzaq zzaqVar2, long j3, zzaq zzaqVar3) {
        this.f1019O = str;
        this.f1020P = str2;
        this.f1021Q = zzknVar;
        this.f1022R = j;
        this.f1023S = z;
        this.f1024T = str3;
        this.f1025U = zzaqVar;
        this.f1026V = j2;
        this.f1027W = zzaqVar2;
        this.f1028X = j3;
        this.f1029Y = zzaqVar3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4412q(parcel, 2, this.f1019O, false);
        C1099ha.m4412q(parcel, 3, this.f1020P, false);
        C1099ha.m4411p(parcel, 4, this.f1021Q, i, false);
        C1099ha.m4408m(parcel, 5, this.f1022R);
        C1099ha.m4398c(parcel, 6, this.f1023S);
        C1099ha.m4412q(parcel, 7, this.f1024T, false);
        C1099ha.m4411p(parcel, 8, this.f1025U, i, false);
        C1099ha.m4408m(parcel, 9, this.f1026V);
        C1099ha.m4411p(parcel, 10, this.f1027W, i, false);
        C1099ha.m4408m(parcel, 11, this.f1028X);
        C1099ha.m4411p(parcel, 12, this.f1029Y, i, false);
        C1099ha.m4397b(parcel, m4396a);
    }
}
