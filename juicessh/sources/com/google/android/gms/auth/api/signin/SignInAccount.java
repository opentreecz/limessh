package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.sonelli.C0813ca;
import com.sonelli.C1099ha;
import com.sonelli.C1589n6;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes.dex */
public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new C1589n6();

    /* renamed from: O */
    @Deprecated
    public String f693O;

    /* renamed from: P */
    public GoogleSignInAccount f694P;

    /* renamed from: Q */
    @Deprecated
    public String f695Q;

    public SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.f694P = googleSignInAccount;
        C0813ca.m2726h(str, "8.3 and 8.4 SDKs require non-null email");
        this.f693O = str;
        C0813ca.m2726h(str2, "8.3 and 8.4 SDKs require non-null userId");
        this.f695Q = str2;
    }

    @Nullable
    /* renamed from: h */
    public final GoogleSignInAccount m935h() {
        return this.f694P;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4412q(parcel, 4, this.f693O, false);
        C1099ha.m4411p(parcel, 7, this.f694P, i, false);
        C1099ha.m4412q(parcel, 8, this.f695Q, false);
        C1099ha.m4397b(parcel, m4396a);
    }
}
