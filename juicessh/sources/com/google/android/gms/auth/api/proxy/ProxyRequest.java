package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C1094h5;
import cz.opentree.C1099ha;

/* loaded from: classes.dex */
public class ProxyRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ProxyRequest> CREATOR = new C1094h5();

    /* renamed from: O */
    public final int f640O;

    /* renamed from: P */
    public final String f641P;

    /* renamed from: Q */
    public final int f642Q;

    /* renamed from: R */
    public final long f643R;

    /* renamed from: S */
    public final byte[] f644S;

    /* renamed from: T */
    public Bundle f645T;

    public ProxyRequest(int i, String str, int i2, long j, byte[] bArr, Bundle bundle) {
        this.f640O = i;
        this.f641P = str;
        this.f642Q = i2;
        this.f643R = j;
        this.f644S = bArr;
        this.f645T = bundle;
    }

    public String toString() {
        String str = this.f641P;
        int i = this.f642Q;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 42);
        sb.append("ProxyRequest[ url: ");
        sb.append(str);
        sb.append(", method: ");
        sb.append(i);
        sb.append(" ]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4412q(parcel, 1, this.f641P, false);
        C1099ha.m4406k(parcel, 2, this.f642Q);
        C1099ha.m4408m(parcel, 3, this.f643R);
        C1099ha.m4401f(parcel, 4, this.f644S, false);
        C1099ha.m4400e(parcel, 5, this.f645T, false);
        C1099ha.m4406k(parcel, 1000, this.f640O);
        C1099ha.m4397b(parcel, m4396a);
    }
}
