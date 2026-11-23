package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.util.Clock;
import cz.opentree.C0813ca;
import cz.opentree.C0921ec;
import cz.opentree.C1099ha;
import cz.opentree.C1146i6;
import cz.opentree.C1198j6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new C1198j6();

    /* renamed from: b0 */
    public static Clock f652b0 = C0921ec.m3474d();

    /* renamed from: O */
    public final int f653O;

    /* renamed from: P */
    public String f654P;

    /* renamed from: Q */
    public String f655Q;

    /* renamed from: R */
    public String f656R;

    /* renamed from: S */
    public String f657S;

    /* renamed from: T */
    public Uri f658T;

    /* renamed from: U */
    public String f659U;

    /* renamed from: V */
    public long f660V;

    /* renamed from: W */
    public String f661W;

    /* renamed from: X */
    public List<Scope> f662X;

    /* renamed from: Y */
    public String f663Y;

    /* renamed from: Z */
    public String f664Z;

    /* renamed from: a0 */
    public Set<Scope> f665a0 = new HashSet();

    public GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.f653O = i;
        this.f654P = str;
        this.f655Q = str2;
        this.f656R = str3;
        this.f657S = str4;
        this.f658T = uri;
        this.f659U = str5;
        this.f660V = j;
        this.f661W = str6;
        this.f662X = list;
        this.f663Y = str7;
        this.f664Z = str8;
    }

    @Nullable
    /* renamed from: h0 */
    public static GoogleSignInAccount m889h0(@Nullable String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        GoogleSignInAccount m890i0 = m890i0(jSONObject.optString("id"), jSONObject.optString("tokenId", null), jSONObject.optString(NotificationCompat.CATEGORY_EMAIL, null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        m890i0.f659U = jSONObject.optString("serverAuthCode", null);
        return m890i0;
    }

    /* renamed from: i0 */
    public static GoogleSignInAccount m890i0(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Uri uri, @Nullable Long l, @NonNull String str7, @NonNull Set<Scope> set) {
        long longValue = (l == null ? Long.valueOf(f652b0.mo1177a() / 1000) : l).longValue();
        C0813ca.m2725g(str7);
        C0813ca.m2729k(set);
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, longValue, str7, new ArrayList(set), str5, str6);
    }

    @Nullable
    /* renamed from: K */
    public String m891K() {
        return this.f656R;
    }

    @Nullable
    /* renamed from: Y */
    public String m892Y() {
        return this.f664Z;
    }

    @Nullable
    /* renamed from: Z */
    public String m893Z() {
        return this.f663Y;
    }

    @Nullable
    /* renamed from: a0 */
    public String m894a0() {
        return this.f654P;
    }

    @Nullable
    /* renamed from: b0 */
    public String m895b0() {
        return this.f655Q;
    }

    @Nullable
    /* renamed from: c0 */
    public Uri m896c0() {
        return this.f658T;
    }

    @NonNull
    /* renamed from: d0 */
    public Set<Scope> m897d0() {
        HashSet hashSet = new HashSet(this.f662X);
        hashSet.addAll(this.f665a0);
        return hashSet;
    }

    @Nullable
    /* renamed from: e0 */
    public String m898e0() {
        return this.f659U;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.f661W.equals(this.f661W) && googleSignInAccount.m897d0().equals(m897d0());
    }

    /* renamed from: f0 */
    public boolean m899f0() {
        return f652b0.mo1177a() / 1000 >= this.f660V - 300;
    }

    public int hashCode() {
        return ((this.f661W.hashCode() + 527) * 31) + m897d0().hashCode();
    }

    @NonNull
    /* renamed from: j0 */
    public final String m900j0() {
        return this.f661W;
    }

    /* renamed from: k0 */
    public final String m901k0() {
        JSONObject m902l0 = m902l0();
        m902l0.remove("serverAuthCode");
        return m902l0.toString();
    }

    /* renamed from: l0 */
    public final JSONObject m902l0() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (m894a0() != null) {
                jSONObject.put("id", m894a0());
            }
            if (m895b0() != null) {
                jSONObject.put("tokenId", m895b0());
            }
            if (m891K() != null) {
                jSONObject.put(NotificationCompat.CATEGORY_EMAIL, m891K());
            }
            if (m904x() != null) {
                jSONObject.put("displayName", m904x());
            }
            if (m893Z() != null) {
                jSONObject.put("givenName", m893Z());
            }
            if (m892Y() != null) {
                jSONObject.put("familyName", m892Y());
            }
            if (m896c0() != null) {
                jSONObject.put("photoUrl", m896c0().toString());
            }
            if (m898e0() != null) {
                jSONObject.put("serverAuthCode", m898e0());
            }
            jSONObject.put("expirationTime", this.f660V);
            jSONObject.put("obfuscatedIdentifier", this.f661W);
            JSONArray jSONArray = new JSONArray();
            List<Scope> list = this.f662X;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, C1146i6.f3268a);
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.m993x());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    /* renamed from: p */
    public Account m903p() {
        if (this.f656R == null) {
            return null;
        }
        return new Account(this.f656R, "com.google");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f653O);
        C1099ha.m4412q(parcel, 2, m894a0(), false);
        C1099ha.m4412q(parcel, 3, m895b0(), false);
        C1099ha.m4412q(parcel, 4, m891K(), false);
        C1099ha.m4412q(parcel, 5, m904x(), false);
        C1099ha.m4411p(parcel, 6, m896c0(), i, false);
        C1099ha.m4412q(parcel, 7, m898e0(), false);
        C1099ha.m4408m(parcel, 8, this.f660V);
        C1099ha.m4412q(parcel, 9, this.f661W, false);
        C1099ha.m4416u(parcel, 10, this.f662X, false);
        C1099ha.m4412q(parcel, 11, m893Z(), false);
        C1099ha.m4412q(parcel, 12, m892Y(), false);
        C1099ha.m4397b(parcel, m4396a);
    }

    @Nullable
    /* renamed from: x */
    public String m904x() {
        return this.f657S;
    }
}
