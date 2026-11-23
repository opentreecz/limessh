package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C1099ha;
import cz.opentree.C1143i5;

/* loaded from: classes.dex */
public class ProxyResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ProxyResponse> CREATOR = new C1143i5();

    /* renamed from: O */
    public final int f646O;

    /* renamed from: P */
    public final int f647P;

    /* renamed from: Q */
    public final PendingIntent f648Q;

    /* renamed from: R */
    public final int f649R;

    /* renamed from: S */
    public final Bundle f650S;

    /* renamed from: T */
    public final byte[] f651T;

    public ProxyResponse(int i, int i2, PendingIntent pendingIntent, int i3, Bundle bundle, byte[] bArr) {
        this.f646O = i;
        this.f647P = i2;
        this.f649R = i3;
        this.f650S = bundle;
        this.f651T = bArr;
        this.f648Q = pendingIntent;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f647P);
        C1099ha.m4411p(parcel, 2, this.f648Q, i, false);
        C1099ha.m4406k(parcel, 3, this.f649R);
        C1099ha.m4400e(parcel, 4, this.f650S, false);
        C1099ha.m4401f(parcel, 5, this.f651T, false);
        C1099ha.m4406k(parcel, 1000, this.f646O);
        C1099ha.m4397b(parcel, m4396a);
    }
}
