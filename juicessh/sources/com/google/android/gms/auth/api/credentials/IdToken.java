package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C0753b5;
import cz.opentree.C0758ba;
import cz.opentree.C0813ca;
import cz.opentree.C1099ha;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes.dex */
public final class IdToken extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<IdToken> CREATOR = new C0753b5();

    /* renamed from: O */
    @NonNull
    public final String f622O;

    /* renamed from: P */
    @NonNull
    public final String f623P;

    public IdToken(@NonNull String str, @NonNull String str2) {
        C0813ca.m2720b(!TextUtils.isEmpty(str), "account type string cannot be null or empty");
        C0813ca.m2720b(!TextUtils.isEmpty(str2), "id token string cannot be null or empty");
        this.f622O = str;
        this.f623P = str2;
    }

    @NonNull
    /* renamed from: K */
    public final String m871K() {
        return this.f623P;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IdToken)) {
            return false;
        }
        IdToken idToken = (IdToken) obj;
        return C0758ba.m2404a(this.f622O, idToken.f622O) && C0758ba.m2404a(this.f623P, idToken.f623P);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4412q(parcel, 1, m872x(), false);
        C1099ha.m4412q(parcel, 2, m871K(), false);
        C1099ha.m4397b(parcel, m4396a);
    }

    @NonNull
    /* renamed from: x */
    public final String m872x() {
        return this.f622O;
    }
}
