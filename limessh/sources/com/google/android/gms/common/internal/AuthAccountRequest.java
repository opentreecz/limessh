package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C1099ha;
import cz.opentree.C1151ia;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public class AuthAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new C1151ia();

    /* renamed from: O */
    public final int f796O;

    /* renamed from: P */
    @Deprecated
    public final IBinder f797P;

    /* renamed from: Q */
    public final Scope[] f798Q;

    /* renamed from: R */
    public Integer f799R;

    /* renamed from: S */
    public Integer f800S;

    /* renamed from: T */
    public Account f801T;

    public AuthAccountRequest(int i, IBinder iBinder, Scope[] scopeArr, Integer num, Integer num2, Account account) {
        this.f796O = i;
        this.f797P = iBinder;
        this.f798Q = scopeArr;
        this.f799R = num;
        this.f800S = num2;
        this.f801T = account;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f796O);
        C1099ha.m4405j(parcel, 2, this.f797P, false);
        C1099ha.m4415t(parcel, 3, this.f798Q, i, false);
        C1099ha.m4407l(parcel, 4, this.f799R, false);
        C1099ha.m4407l(parcel, 5, this.f800S, false);
        C1099ha.m4411p(parcel, 6, this.f801T, i, false);
        C1099ha.m4397b(parcel, m4396a);
    }
}
