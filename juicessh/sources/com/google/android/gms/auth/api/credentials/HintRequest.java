package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C0695a5;
import cz.opentree.C0813ca;
import cz.opentree.C1099ha;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes.dex */
public final class HintRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<HintRequest> CREATOR = new C0695a5();

    /* renamed from: O */
    public final int f614O;

    /* renamed from: P */
    public final CredentialPickerConfig f615P;

    /* renamed from: Q */
    public final boolean f616Q;

    /* renamed from: R */
    public final boolean f617R;

    /* renamed from: S */
    public final String[] f618S;

    /* renamed from: T */
    public final boolean f619T;

    /* renamed from: U */
    @Nullable
    public final String f620U;

    /* renamed from: V */
    @Nullable
    public final String f621V;

    public HintRequest(int i, CredentialPickerConfig credentialPickerConfig, boolean z, boolean z2, String[] strArr, boolean z3, @Nullable String str, @Nullable String str2) {
        this.f614O = i;
        C0813ca.m2729k(credentialPickerConfig);
        this.f615P = credentialPickerConfig;
        this.f616Q = z;
        this.f617R = z2;
        C0813ca.m2729k(strArr);
        this.f618S = strArr;
        if (i < 2) {
            this.f619T = true;
            this.f620U = null;
            this.f621V = null;
        } else {
            this.f619T = z3;
            this.f620U = str;
            this.f621V = str2;
        }
    }

    @NonNull
    /* renamed from: K */
    public final CredentialPickerConfig m865K() {
        return this.f615P;
    }

    @Nullable
    /* renamed from: Y */
    public final String m866Y() {
        return this.f621V;
    }

    @Nullable
    /* renamed from: Z */
    public final String m867Z() {
        return this.f620U;
    }

    /* renamed from: a0 */
    public final boolean m868a0() {
        return this.f616Q;
    }

    /* renamed from: b0 */
    public final boolean m869b0() {
        return this.f619T;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4411p(parcel, 1, m865K(), i, false);
        C1099ha.m4398c(parcel, 2, m868a0());
        C1099ha.m4398c(parcel, 3, this.f617R);
        C1099ha.m4413r(parcel, 4, m870x(), false);
        C1099ha.m4398c(parcel, 5, m869b0());
        C1099ha.m4412q(parcel, 6, m867Z(), false);
        C1099ha.m4412q(parcel, 7, m866Y(), false);
        C1099ha.m4406k(parcel, 1000, this.f614O);
        C1099ha.m4397b(parcel, m4396a);
    }

    @NonNull
    /* renamed from: x */
    public final String[] m870x() {
        return this.f618S;
    }
}
