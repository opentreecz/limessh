package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C0758ba;
import cz.opentree.C0813ca;
import cz.opentree.C1099ha;
import cz.opentree.C1801r6;

/* loaded from: classes.dex */
public class AccountChangeEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new C1801r6();

    /* renamed from: O */
    public final int f539O;

    /* renamed from: P */
    public final long f540P;

    /* renamed from: Q */
    public final String f541Q;

    /* renamed from: R */
    public final int f542R;

    /* renamed from: S */
    public final int f543S;

    /* renamed from: T */
    public final String f544T;

    public AccountChangeEvent(int i, long j, String str, int i2, int i3, String str2) {
        this.f539O = i;
        this.f540P = j;
        C0813ca.m2729k(str);
        this.f541Q = str;
        this.f542R = i2;
        this.f543S = i3;
        this.f544T = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AccountChangeEvent) {
            AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
            if (this.f539O == accountChangeEvent.f539O && this.f540P == accountChangeEvent.f540P && C0758ba.m2404a(this.f541Q, accountChangeEvent.f541Q) && this.f542R == accountChangeEvent.f542R && this.f543S == accountChangeEvent.f543S && C0758ba.m2404a(this.f544T, accountChangeEvent.f544T)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return C0758ba.m2405b(Integer.valueOf(this.f539O), Long.valueOf(this.f540P), this.f541Q, Integer.valueOf(this.f542R), Integer.valueOf(this.f543S), this.f544T);
    }

    public String toString() {
        int i = this.f542R;
        String str = i != 1 ? i != 2 ? i != 3 ? i != 4 ? "UNKNOWN" : "RENAMED_TO" : "RENAMED_FROM" : "REMOVED" : "ADDED";
        String str2 = this.f541Q;
        String str3 = this.f544T;
        int i2 = this.f543S;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 91 + str.length() + String.valueOf(str3).length());
        sb.append("AccountChangeEvent {accountName = ");
        sb.append(str2);
        sb.append(", changeType = ");
        sb.append(str);
        sb.append(", changeData = ");
        sb.append(str3);
        sb.append(", eventIndex = ");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f539O);
        C1099ha.m4408m(parcel, 2, this.f540P);
        C1099ha.m4412q(parcel, 3, this.f541Q, false);
        C1099ha.m4406k(parcel, 4, this.f542R);
        C1099ha.m4406k(parcel, 5, this.f543S);
        C1099ha.m4412q(parcel, 6, this.f544T, false);
        C1099ha.m4397b(parcel, m4396a);
    }
}
