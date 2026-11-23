package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sonelli.C0813ca;
import com.sonelli.C1099ha;
import com.sonelli.C1901t6;
import java.util.List;

/* loaded from: classes.dex */
public class AccountChangeEventsResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsResponse> CREATOR = new C1901t6();

    /* renamed from: O */
    public final int f549O;

    /* renamed from: P */
    public final List<AccountChangeEvent> f550P;

    public AccountChangeEventsResponse(int i, List<AccountChangeEvent> list) {
        this.f549O = i;
        C0813ca.m2729k(list);
        this.f550P = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f549O);
        C1099ha.m4416u(parcel, 2, this.f550P, false);
        C1099ha.m4397b(parcel, m4396a);
    }
}
