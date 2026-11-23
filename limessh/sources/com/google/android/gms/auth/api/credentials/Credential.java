package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C0758ba;
import cz.opentree.C0813ca;
import cz.opentree.C1099ha;
import cz.opentree.C2200w4;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes.dex */
public class Credential extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Credential> CREATOR = new C2200w4();

    /* renamed from: O */
    @Nonnull
    public final String f590O;

    /* renamed from: P */
    @Nullable
    public final String f591P;

    /* renamed from: Q */
    @Nullable
    public final Uri f592Q;

    /* renamed from: R */
    @Nonnull
    public final List<IdToken> f593R;

    /* renamed from: S */
    @Nullable
    public final String f594S;

    /* renamed from: T */
    @Nullable
    public final String f595T;

    /* renamed from: U */
    @Nullable
    public final String f596U;

    /* renamed from: V */
    @Nullable
    public final String f597V;

    public Credential(String str, @Nullable String str2, @Nullable Uri uri, List<IdToken> list, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        C0813ca.m2730l(str, "credential identifier cannot be null");
        String trim = str.trim();
        C0813ca.m2726h(trim, "credential identifier cannot be empty");
        if (str3 != null && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Password must not be empty if set");
        }
        if (str4 != null) {
            boolean z = false;
            if (!TextUtils.isEmpty(str4)) {
                Uri parse = Uri.parse(str4);
                if (parse.isAbsolute() && parse.isHierarchical() && !TextUtils.isEmpty(parse.getScheme()) && !TextUtils.isEmpty(parse.getAuthority()) && ("http".equalsIgnoreCase(parse.getScheme()) || "https".equalsIgnoreCase(parse.getScheme()))) {
                    z = true;
                }
            }
            if (!Boolean.valueOf(z).booleanValue()) {
                throw new IllegalArgumentException("Account type must be a valid Http/Https URI");
            }
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Password and AccountType are mutually exclusive");
        }
        if (str2 != null && TextUtils.isEmpty(str2.trim())) {
            str2 = null;
        }
        this.f591P = str2;
        this.f592Q = uri;
        this.f593R = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.f590O = trim;
        this.f594S = str3;
        this.f595T = str4;
        this.f596U = str5;
        this.f597V = str6;
    }

    @Nullable
    /* renamed from: K */
    public String m843K() {
        return this.f597V;
    }

    @Nullable
    /* renamed from: Y */
    public String m844Y() {
        return this.f596U;
    }

    @Nonnull
    /* renamed from: Z */
    public String m845Z() {
        return this.f590O;
    }

    @Nonnull
    /* renamed from: a0 */
    public List<IdToken> m846a0() {
        return this.f593R;
    }

    @Nullable
    /* renamed from: b0 */
    public String m847b0() {
        return this.f591P;
    }

    @Nullable
    /* renamed from: c0 */
    public String m848c0() {
        return this.f594S;
    }

    @Nullable
    /* renamed from: d0 */
    public Uri m849d0() {
        return this.f592Q;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.f590O, credential.f590O) && TextUtils.equals(this.f591P, credential.f591P) && C0758ba.m2404a(this.f592Q, credential.f592Q) && TextUtils.equals(this.f594S, credential.f594S) && TextUtils.equals(this.f595T, credential.f595T);
    }

    public int hashCode() {
        return C0758ba.m2405b(this.f590O, this.f591P, this.f592Q, this.f594S, this.f595T);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4412q(parcel, 1, m845Z(), false);
        C1099ha.m4412q(parcel, 2, m847b0(), false);
        C1099ha.m4411p(parcel, 3, m849d0(), i, false);
        C1099ha.m4416u(parcel, 4, m846a0(), false);
        C1099ha.m4412q(parcel, 5, m848c0(), false);
        C1099ha.m4412q(parcel, 6, m850x(), false);
        C1099ha.m4412q(parcel, 9, m844Y(), false);
        C1099ha.m4412q(parcel, 10, m843K(), false);
        C1099ha.m4397b(parcel, m4396a);
    }

    @Nullable
    /* renamed from: x */
    public String m850x() {
        return this.f595T;
    }
}
