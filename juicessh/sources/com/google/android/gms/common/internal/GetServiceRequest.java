package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sonelli.BinderC1694p9;
import com.sonelli.C1099ha;
import com.sonelli.C2210wa;
import com.sonelli.C2326y6;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes.dex */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new C2210wa();

    /* renamed from: O */
    public final int f842O;

    /* renamed from: P */
    public final int f843P;

    /* renamed from: Q */
    public int f844Q;

    /* renamed from: R */
    public String f845R;

    /* renamed from: S */
    public IBinder f846S;

    /* renamed from: T */
    public Scope[] f847T;

    /* renamed from: U */
    public Bundle f848U;

    /* renamed from: V */
    public Account f849V;

    /* renamed from: W */
    public Feature[] f850W;

    /* renamed from: X */
    public Feature[] f851X;

    /* renamed from: Y */
    public boolean f852Y;

    /* renamed from: Z */
    public int f853Z;

    public GetServiceRequest(int i) {
        this.f842O = 4;
        this.f844Q = C2326y6.f8141a;
        this.f843P = i;
        this.f852Y = true;
    }

    public GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z, int i4) {
        this.f842O = i;
        this.f843P = i2;
        this.f844Q = i3;
        if ("com.google.android.gms".equals(str)) {
            this.f845R = "com.google.android.gms";
        } else {
            this.f845R = str;
        }
        if (i < 2) {
            this.f849V = iBinder != null ? BinderC1694p9.m7254s(IAccountAccessor.AbstractBinderC0444a.m1119r(iBinder)) : null;
        } else {
            this.f846S = iBinder;
            this.f849V = account;
        }
        this.f847T = scopeArr;
        this.f848U = bundle;
        this.f850W = featureArr;
        this.f851X = featureArr2;
        this.f852Y = z;
        this.f853Z = i4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f842O);
        C1099ha.m4406k(parcel, 2, this.f843P);
        C1099ha.m4406k(parcel, 3, this.f844Q);
        C1099ha.m4412q(parcel, 4, this.f845R, false);
        C1099ha.m4405j(parcel, 5, this.f846S, false);
        C1099ha.m4415t(parcel, 6, this.f847T, i, false);
        C1099ha.m4400e(parcel, 7, this.f848U, false);
        C1099ha.m4411p(parcel, 8, this.f849V, i, false);
        C1099ha.m4415t(parcel, 10, this.f850W, i, false);
        C1099ha.m4415t(parcel, 11, this.f851X, i, false);
        C1099ha.m4398c(parcel, 12, this.f852Y);
        C1099ha.m4406k(parcel, 13, this.f853Z);
        C1099ha.m4397b(parcel, m4396a);
    }
}
