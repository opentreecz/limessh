package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C0813ca;
import cz.opentree.C1099ha;
import cz.opentree.C2411z4;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes.dex */
public final class CredentialRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CredentialRequest> CREATOR = new C2411z4();

    /* renamed from: O */
    public final int f605O;

    /* renamed from: P */
    public final boolean f606P;

    /* renamed from: Q */
    public final String[] f607Q;

    /* renamed from: R */
    public final CredentialPickerConfig f608R;

    /* renamed from: S */
    public final CredentialPickerConfig f609S;

    /* renamed from: T */
    public final boolean f610T;

    /* renamed from: U */
    @Nullable
    public final String f611U;

    /* renamed from: V */
    @Nullable
    public final String f612V;

    /* renamed from: W */
    public final boolean f613W;

    public CredentialRequest(int i, boolean z, String[] strArr, @Nullable CredentialPickerConfig credentialPickerConfig, @Nullable CredentialPickerConfig credentialPickerConfig2, boolean z2, @Nullable String str, @Nullable String str2, boolean z3) {
        this.f605O = i;
        this.f606P = z;
        C0813ca.m2729k(strArr);
        this.f607Q = strArr;
        this.f608R = credentialPickerConfig == null ? new CredentialPickerConfig.C0423a().m857a() : credentialPickerConfig;
        this.f609S = credentialPickerConfig2 == null ? new CredentialPickerConfig.C0423a().m857a() : credentialPickerConfig2;
        if (i < 3) {
            this.f610T = true;
            this.f611U = null;
            this.f612V = null;
        } else {
            this.f610T = z2;
            this.f611U = str;
            this.f612V = str2;
        }
        this.f613W = z3;
    }

    @NonNull
    /* renamed from: K */
    public final CredentialPickerConfig m858K() {
        return this.f609S;
    }

    @NonNull
    /* renamed from: Y */
    public final CredentialPickerConfig m859Y() {
        return this.f608R;
    }

    @Nullable
    /* renamed from: Z */
    public final String m860Z() {
        return this.f612V;
    }

    @Nullable
    /* renamed from: a0 */
    public final String m861a0() {
        return this.f611U;
    }

    /* renamed from: b0 */
    public final boolean m862b0() {
        return this.f610T;
    }

    /* renamed from: c0 */
    public final boolean m863c0() {
        return this.f606P;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4398c(parcel, 1, m863c0());
        C1099ha.m4413r(parcel, 2, m864x(), false);
        C1099ha.m4411p(parcel, 3, m859Y(), i, false);
        C1099ha.m4411p(parcel, 4, m858K(), i, false);
        C1099ha.m4398c(parcel, 5, m862b0());
        C1099ha.m4412q(parcel, 6, m861a0(), false);
        C1099ha.m4412q(parcel, 7, m860Z(), false);
        C1099ha.m4398c(parcel, 8, this.f613W);
        C1099ha.m4406k(parcel, 1000, this.f605O);
        C1099ha.m4397b(parcel, m4396a);
    }

    @NonNull
    /* renamed from: x */
    public final String[] m864x() {
        return this.f607Q;
    }
}
