package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sonelli.C1099ha;
import com.sonelli.C1925ta;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public class SignInButtonConfig extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInButtonConfig> CREATOR = new C1925ta();

    /* renamed from: O */
    public final int f864O;

    /* renamed from: P */
    public final int f865P;

    /* renamed from: Q */
    public final int f866Q;

    /* renamed from: R */
    @Deprecated
    public final Scope[] f867R;

    public SignInButtonConfig(int i, int i2, int i3, Scope[] scopeArr) {
        this.f864O = i;
        this.f865P = i2;
        this.f866Q = i3;
        this.f867R = scopeArr;
    }

    public SignInButtonConfig(int i, int i2, Scope[] scopeArr) {
        this(1, i, i2, null);
    }

    /* renamed from: K */
    public int m1134K() {
        return this.f866Q;
    }

    @Deprecated
    /* renamed from: Y */
    public Scope[] m1135Y() {
        return this.f867R;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f864O);
        C1099ha.m4406k(parcel, 2, m1136x());
        C1099ha.m4406k(parcel, 3, m1134K());
        C1099ha.m4415t(parcel, 4, m1135Y(), i, false);
        C1099ha.m4397b(parcel, m4396a);
    }

    /* renamed from: x */
    public int m1136x() {
        return this.f865P;
    }
}
