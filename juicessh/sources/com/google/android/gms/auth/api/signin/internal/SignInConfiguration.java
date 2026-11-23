package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C0813ca;
import cz.opentree.C1028g6;
import cz.opentree.C1099ha;
import cz.opentree.C1538m5;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes.dex */
public final class SignInConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new C1028g6();

    /* renamed from: O */
    public final String f699O;

    /* renamed from: P */
    public GoogleSignInOptions f700P;

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        C0813ca.m2725g(str);
        this.f699O = str;
        this.f700P = googleSignInOptions;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.f699O.equals(signInConfiguration.f699O)) {
            GoogleSignInOptions googleSignInOptions = this.f700P;
            if (googleSignInOptions == null) {
                if (signInConfiguration.f700P == null) {
                    return true;
                }
            } else if (googleSignInOptions.equals(signInConfiguration.f700P)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        C1538m5 c1538m5 = new C1538m5();
        c1538m5.m6369a(this.f699O);
        c1538m5.m6369a(this.f700P);
        return c1538m5.m6370b();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4412q(parcel, 2, this.f699O, false);
        C1099ha.m4411p(parcel, 5, this.f700P, i, false);
        C1099ha.m4397b(parcel, m4396a);
    }

    /* renamed from: x */
    public final GoogleSignInOptions m937x() {
        return this.f700P;
    }
}
