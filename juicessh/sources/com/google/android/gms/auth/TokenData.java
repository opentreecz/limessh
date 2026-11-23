package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sonelli.C0758ba;
import com.sonelli.C0813ca;
import com.sonelli.C1099ha;
import com.sonelli.C1995u6;
import java.util.List;

/* loaded from: classes.dex */
public class TokenData extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<TokenData> CREATOR = new C1995u6();

    /* renamed from: O */
    public final int f551O;

    /* renamed from: P */
    public final String f552P;

    /* renamed from: Q */
    public final Long f553Q;

    /* renamed from: R */
    public final boolean f554R;

    /* renamed from: S */
    public final boolean f555S;

    /* renamed from: T */
    public final List<String> f556T;

    /* renamed from: U */
    public final String f557U;

    public TokenData(int i, String str, Long l, boolean z, boolean z2, List<String> list, String str2) {
        this.f551O = i;
        C0813ca.m2725g(str);
        this.f552P = str;
        this.f553Q = l;
        this.f554R = z;
        this.f555S = z2;
        this.f556T = list;
        this.f557U = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        return TextUtils.equals(this.f552P, tokenData.f552P) && C0758ba.m2404a(this.f553Q, tokenData.f553Q) && this.f554R == tokenData.f554R && this.f555S == tokenData.f555S && C0758ba.m2404a(this.f556T, tokenData.f556T) && C0758ba.m2404a(this.f557U, tokenData.f557U);
    }

    public int hashCode() {
        return C0758ba.m2405b(this.f552P, this.f553Q, Boolean.valueOf(this.f554R), Boolean.valueOf(this.f555S), this.f556T, this.f557U);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f551O);
        C1099ha.m4412q(parcel, 2, this.f552P, false);
        C1099ha.m4409n(parcel, 3, this.f553Q, false);
        C1099ha.m4398c(parcel, 4, this.f554R);
        C1099ha.m4398c(parcel, 5, this.f555S);
        C1099ha.m4414s(parcel, 6, this.f556T, false);
        C1099ha.m4412q(parcel, 7, this.f557U, false);
        C1099ha.m4397b(parcel, m4396a);
    }
}
