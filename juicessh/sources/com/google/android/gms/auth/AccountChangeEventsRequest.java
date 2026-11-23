package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sonelli.C1099ha;
import com.sonelli.C1847s6;

/* loaded from: classes.dex */
public class AccountChangeEventsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new C1847s6();

    /* renamed from: O */
    public final int f545O;

    /* renamed from: P */
    public int f546P;

    /* renamed from: Q */
    @Deprecated
    public String f547Q;

    /* renamed from: R */
    public Account f548R;

    public AccountChangeEventsRequest() {
        this.f545O = 1;
    }

    public AccountChangeEventsRequest(int i, int i2, String str, Account account) {
        this.f545O = i;
        this.f546P = i2;
        this.f547Q = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.f548R = account;
        } else {
            this.f548R = new Account(str, "com.google");
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f545O);
        C1099ha.m4406k(parcel, 2, this.f546P);
        C1099ha.m4412q(parcel, 3, this.f547Q, false);
        C1099ha.m4411p(parcel, 4, this.f548R, i, false);
        C1099ha.m4397b(parcel, m4396a);
    }
}
