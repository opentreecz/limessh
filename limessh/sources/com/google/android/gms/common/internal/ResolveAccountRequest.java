package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C1099ha;
import cz.opentree.C1809ra;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public class ResolveAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountRequest> CREATOR = new C1809ra();

    /* renamed from: O */
    public final int f855O;

    /* renamed from: P */
    public final Account f856P;

    /* renamed from: Q */
    public final int f857Q;

    /* renamed from: R */
    public final GoogleSignInAccount f858R;

    public ResolveAccountRequest(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f855O = i;
        this.f856P = account;
        this.f857Q = i2;
        this.f858R = googleSignInAccount;
    }

    public ResolveAccountRequest(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    @Nullable
    /* renamed from: K */
    public GoogleSignInAccount m1127K() {
        return this.f858R;
    }

    /* renamed from: p */
    public Account m1128p() {
        return this.f856P;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f855O);
        C1099ha.m4411p(parcel, 2, m1128p(), i, false);
        C1099ha.m4406k(parcel, 3, m1129x());
        C1099ha.m4411p(parcel, 4, m1127K(), i, false);
        C1099ha.m4397b(parcel, m4396a);
    }

    /* renamed from: x */
    public int m1129x() {
        return this.f857Q;
    }
}
