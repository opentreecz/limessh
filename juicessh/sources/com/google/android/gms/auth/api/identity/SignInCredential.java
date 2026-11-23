package com.google.android.gms.auth.api.identity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C0758ba;
import cz.opentree.C0813ca;
import cz.opentree.C1027g5;
import cz.opentree.C1099ha;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes.dex */
public final class SignInCredential extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInCredential> CREATOR = new C1027g5();

    /* renamed from: O */
    public final String f633O;

    /* renamed from: P */
    @Nullable
    public final String f634P;

    /* renamed from: Q */
    @Nullable
    public final String f635Q;

    /* renamed from: R */
    @Nullable
    public final String f636R;

    /* renamed from: S */
    @Nullable
    public final Uri f637S;

    /* renamed from: T */
    @Nullable
    public final String f638T;

    /* renamed from: U */
    @Nullable
    public final String f639U;

    public SignInCredential(String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Uri uri, @Nullable String str5, @Nullable String str6) {
        C0813ca.m2725g(str);
        this.f633O = str;
        this.f634P = str2;
        this.f635Q = str3;
        this.f636R = str4;
        this.f637S = uri;
        this.f638T = str5;
        this.f639U = str6;
    }

    @Nullable
    /* renamed from: K */
    public final String m881K() {
        return this.f636R;
    }

    @Nullable
    /* renamed from: Y */
    public final String m882Y() {
        return this.f635Q;
    }

    @Nullable
    /* renamed from: Z */
    public final String m883Z() {
        return this.f639U;
    }

    /* renamed from: a0 */
    public final String m884a0() {
        return this.f633O;
    }

    @Nullable
    /* renamed from: b0 */
    public final String m885b0() {
        return this.f638T;
    }

    @Nullable
    /* renamed from: c0 */
    public final Uri m886c0() {
        return this.f637S;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SignInCredential)) {
            return false;
        }
        SignInCredential signInCredential = (SignInCredential) obj;
        return C0758ba.m2404a(this.f633O, signInCredential.f633O) && C0758ba.m2404a(this.f634P, signInCredential.f634P) && C0758ba.m2404a(this.f635Q, signInCredential.f635Q) && C0758ba.m2404a(this.f636R, signInCredential.f636R) && C0758ba.m2404a(this.f637S, signInCredential.f637S) && C0758ba.m2404a(this.f638T, signInCredential.f638T) && C0758ba.m2404a(this.f639U, signInCredential.f639U);
    }

    public final int hashCode() {
        return C0758ba.m2405b(this.f633O, this.f634P, this.f635Q, this.f636R, this.f637S, this.f638T, this.f639U);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4412q(parcel, 1, m884a0(), false);
        C1099ha.m4412q(parcel, 2, m887x(), false);
        C1099ha.m4412q(parcel, 3, m882Y(), false);
        C1099ha.m4412q(parcel, 4, m881K(), false);
        C1099ha.m4411p(parcel, 5, m886c0(), i, false);
        C1099ha.m4412q(parcel, 6, m885b0(), false);
        C1099ha.m4412q(parcel, 7, m883Z(), false);
        C1099ha.m4397b(parcel, m4396a);
    }

    @Nullable
    /* renamed from: x */
    public final String m887x() {
        return this.f634P;
    }
}
