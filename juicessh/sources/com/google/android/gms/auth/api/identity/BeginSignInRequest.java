package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sonelli.C0758ba;
import com.sonelli.C0808c5;
import com.sonelli.C0813ca;
import com.sonelli.C0860d5;
import com.sonelli.C0970f5;
import com.sonelli.C1099ha;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes.dex */
public final class BeginSignInRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<BeginSignInRequest> CREATOR = new C0808c5();

    /* renamed from: O */
    public final PasswordRequestOptions f624O;

    /* renamed from: P */
    public final GoogleIdTokenRequestOptions f625P;

    /* renamed from: Q */
    @Nullable
    public final String f626Q;

    /* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
    /* loaded from: classes.dex */
    public static final class GoogleIdTokenRequestOptions extends AbstractSafeParcelable {
        public static final Parcelable.Creator<GoogleIdTokenRequestOptions> CREATOR = new C0860d5();

        /* renamed from: O */
        public final boolean f627O;

        /* renamed from: P */
        @Nullable
        public final String f628P;

        /* renamed from: Q */
        @Nullable
        public final String f629Q;

        /* renamed from: R */
        public final boolean f630R;

        public GoogleIdTokenRequestOptions(boolean z, @Nullable String str, @Nullable String str2, boolean z2) {
            this.f627O = z;
            if (z) {
                C0813ca.m2730l(str, "serverClientId must be provided if Google ID tokens are requested");
            }
            this.f628P = str;
            this.f629Q = str2;
            this.f630R = z2;
        }

        @Nullable
        /* renamed from: K */
        public final String m875K() {
            return this.f629Q;
        }

        @Nullable
        /* renamed from: Y */
        public final String m876Y() {
            return this.f628P;
        }

        /* renamed from: Z */
        public final boolean m877Z() {
            return this.f627O;
        }

        public final boolean equals(@Nullable Object obj) {
            if (!(obj instanceof GoogleIdTokenRequestOptions)) {
                return false;
            }
            GoogleIdTokenRequestOptions googleIdTokenRequestOptions = (GoogleIdTokenRequestOptions) obj;
            return this.f627O == googleIdTokenRequestOptions.f627O && C0758ba.m2404a(this.f628P, googleIdTokenRequestOptions.f628P) && C0758ba.m2404a(this.f629Q, googleIdTokenRequestOptions.f629Q) && this.f630R == googleIdTokenRequestOptions.f630R;
        }

        public final int hashCode() {
            return C0758ba.m2405b(Boolean.valueOf(this.f627O), this.f628P, this.f629Q, Boolean.valueOf(this.f630R));
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int m4396a = C1099ha.m4396a(parcel);
            C1099ha.m4398c(parcel, 1, m877Z());
            C1099ha.m4412q(parcel, 2, m876Y(), false);
            C1099ha.m4412q(parcel, 3, m875K(), false);
            C1099ha.m4398c(parcel, 4, m878x());
            C1099ha.m4397b(parcel, m4396a);
        }

        /* renamed from: x */
        public final boolean m878x() {
            return this.f630R;
        }
    }

    /* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
    /* loaded from: classes.dex */
    public static final class PasswordRequestOptions extends AbstractSafeParcelable {
        public static final Parcelable.Creator<PasswordRequestOptions> CREATOR = new C0970f5();

        /* renamed from: O */
        public final boolean f631O;

        public PasswordRequestOptions(boolean z) {
            this.f631O = z;
        }

        public final boolean equals(@Nullable Object obj) {
            return (obj instanceof PasswordRequestOptions) && this.f631O == ((PasswordRequestOptions) obj).f631O;
        }

        public final int hashCode() {
            return C0758ba.m2405b(Boolean.valueOf(this.f631O));
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int m4396a = C1099ha.m4396a(parcel);
            C1099ha.m4398c(parcel, 1, m879x());
            C1099ha.m4397b(parcel, m4396a);
        }

        /* renamed from: x */
        public final boolean m879x() {
            return this.f631O;
        }
    }

    public BeginSignInRequest(PasswordRequestOptions passwordRequestOptions, GoogleIdTokenRequestOptions googleIdTokenRequestOptions, @Nullable String str) {
        C0813ca.m2729k(passwordRequestOptions);
        this.f624O = passwordRequestOptions;
        C0813ca.m2729k(googleIdTokenRequestOptions);
        this.f625P = googleIdTokenRequestOptions;
        this.f626Q = str;
    }

    /* renamed from: K */
    public final PasswordRequestOptions m873K() {
        return this.f624O;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof BeginSignInRequest)) {
            return false;
        }
        BeginSignInRequest beginSignInRequest = (BeginSignInRequest) obj;
        return C0758ba.m2404a(this.f624O, beginSignInRequest.f624O) && C0758ba.m2404a(this.f625P, beginSignInRequest.f625P) && C0758ba.m2404a(this.f626Q, beginSignInRequest.f626Q);
    }

    public final int hashCode() {
        return C0758ba.m2405b(this.f624O, this.f625P, this.f626Q);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4411p(parcel, 1, m873K(), i, false);
        C1099ha.m4411p(parcel, 2, m874x(), i, false);
        C1099ha.m4412q(parcel, 3, this.f626Q, false);
        C1099ha.m4397b(parcel, m4396a);
    }

    /* renamed from: x */
    public final GoogleIdTokenRequestOptions m874x() {
        return this.f625P;
    }
}
