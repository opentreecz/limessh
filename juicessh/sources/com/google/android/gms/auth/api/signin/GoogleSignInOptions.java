package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import cz.opentree.C0813ca;
import cz.opentree.C1099ha;
import cz.opentree.C1436k6;
import cz.opentree.C1491l6;
import cz.opentree.C1538m5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions.Optional, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;

    /* renamed from: Z */
    public static final Scope f666Z = new Scope("profile");

    /* renamed from: a0 */
    public static final Scope f667a0 = new Scope(NotificationCompat.CATEGORY_EMAIL);

    /* renamed from: b0 */
    public static final Scope f668b0 = new Scope("openid");

    /* renamed from: c0 */
    public static final Scope f669c0;

    /* renamed from: d0 */
    public static final Scope f670d0;

    /* renamed from: e0 */
    public static final GoogleSignInOptions f671e0;

    /* renamed from: f0 */
    public static Comparator<Scope> f672f0;

    /* renamed from: O */
    public final int f673O;

    /* renamed from: P */
    public final ArrayList<Scope> f674P;

    /* renamed from: Q */
    public Account f675Q;

    /* renamed from: R */
    public boolean f676R;

    /* renamed from: S */
    public final boolean f677S;

    /* renamed from: T */
    public final boolean f678T;

    /* renamed from: U */
    public String f679U;

    /* renamed from: V */
    public String f680V;

    /* renamed from: W */
    public ArrayList<GoogleSignInOptionsExtensionParcelable> f681W;

    /* renamed from: X */
    public String f682X;

    /* renamed from: Y */
    public Map<Integer, GoogleSignInOptionsExtensionParcelable> f683Y;

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* renamed from: com.google.android.gms.auth.api.signin.GoogleSignInOptions$a */
    /* loaded from: classes.dex */
    public static final class C0424a {

        /* renamed from: a */
        public Set<Scope> f684a;

        /* renamed from: b */
        public boolean f685b;

        /* renamed from: c */
        public boolean f686c;

        /* renamed from: d */
        public boolean f687d;

        /* renamed from: e */
        public String f688e;

        /* renamed from: f */
        public Account f689f;

        /* renamed from: g */
        public String f690g;

        /* renamed from: h */
        public Map<Integer, GoogleSignInOptionsExtensionParcelable> f691h;

        /* renamed from: i */
        public String f692i;

        public C0424a() {
            this.f684a = new HashSet();
            this.f691h = new HashMap();
        }

        public C0424a(@NonNull GoogleSignInOptions googleSignInOptions) {
            this.f684a = new HashSet();
            this.f691h = new HashMap();
            C0813ca.m2729k(googleSignInOptions);
            this.f684a = new HashSet(googleSignInOptions.f674P);
            this.f685b = googleSignInOptions.f677S;
            this.f686c = googleSignInOptions.f678T;
            this.f687d = googleSignInOptions.f676R;
            this.f688e = googleSignInOptions.f679U;
            this.f689f = googleSignInOptions.f675Q;
            this.f690g = googleSignInOptions.f680V;
            this.f691h = GoogleSignInOptions.m906e0(googleSignInOptions.f681W);
            this.f692i = googleSignInOptions.f682X;
        }

        /* renamed from: a */
        public final GoogleSignInOptions m927a() {
            if (this.f684a.contains(GoogleSignInOptions.f670d0)) {
                Set<Scope> set = this.f684a;
                Scope scope = GoogleSignInOptions.f669c0;
                if (set.contains(scope)) {
                    this.f684a.remove(scope);
                }
            }
            if (this.f687d && (this.f689f == null || !this.f684a.isEmpty())) {
                m929c();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.f684a), this.f689f, this.f687d, this.f685b, this.f686c, this.f688e, this.f690g, this.f691h, this.f692i, null);
        }

        /* renamed from: b */
        public final C0424a m928b() {
            this.f684a.add(GoogleSignInOptions.f667a0);
            return this;
        }

        /* renamed from: c */
        public final C0424a m929c() {
            this.f684a.add(GoogleSignInOptions.f668b0);
            return this;
        }

        /* renamed from: d */
        public final C0424a m930d(String str) {
            this.f687d = true;
            m934h(str);
            this.f688e = str;
            return this;
        }

        /* renamed from: e */
        public final C0424a m931e() {
            this.f684a.add(GoogleSignInOptions.f666Z);
            return this;
        }

        /* renamed from: f */
        public final C0424a m932f(Scope scope, Scope... scopeArr) {
            this.f684a.add(scope);
            this.f684a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        /* renamed from: g */
        public final C0424a m933g(String str) {
            this.f692i = str;
            return this;
        }

        /* renamed from: h */
        public final String m934h(String str) {
            C0813ca.m2725g(str);
            String str2 = this.f688e;
            C0813ca.m2720b(str2 == null || str2.equals(str), "two different server client ids provided");
            return str;
        }
    }

    static {
        Scope scope = new Scope("https://www.googleapis.com/auth/games_lite");
        f669c0 = scope;
        f670d0 = new Scope("https://www.googleapis.com/auth/games");
        C0424a c0424a = new C0424a();
        c0424a.m929c();
        c0424a.m931e();
        f671e0 = c0424a.m927a();
        C0424a c0424a2 = new C0424a();
        c0424a2.m932f(scope, new Scope[0]);
        c0424a2.m927a();
        CREATOR = new C1491l6();
        f672f0 = new C1436k6();
    }

    public GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2, String str3) {
        this(i, arrayList, account, z, z2, z3, str, str2, m906e0(arrayList2), str3);
    }

    public GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map, String str3) {
        this.f673O = i;
        this.f674P = arrayList;
        this.f675Q = account;
        this.f676R = z;
        this.f677S = z2;
        this.f678T = z3;
        this.f679U = str;
        this.f680V = str2;
        this.f681W = new ArrayList<>(map.values());
        this.f683Y = map;
        this.f682X = str3;
    }

    public /* synthetic */ GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, String str3, C1436k6 c1436k6) {
        this(3, (ArrayList<Scope>) arrayList, account, z, z2, z3, str, str2, (Map<Integer, GoogleSignInOptionsExtensionParcelable>) map, str3);
    }

    /* renamed from: e0 */
    public static Map<Integer, GoogleSignInOptionsExtensionParcelable> m906e0(@Nullable List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : list) {
            hashMap.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.m936x()), googleSignInOptionsExtensionParcelable);
        }
        return hashMap;
    }

    @Nullable
    /* renamed from: f0 */
    public static GoogleSignInOptions m907f0(@Nullable String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String optString = jSONObject.optString("accountName", null);
        return new GoogleSignInOptions(3, (ArrayList<Scope>) new ArrayList(hashSet), !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null), new HashMap(), (String) null);
    }

    @Nullable
    /* renamed from: K */
    public String m917K() {
        return this.f682X;
    }

    /* renamed from: Y */
    public ArrayList<Scope> m918Y() {
        return new ArrayList<>(this.f674P);
    }

    /* renamed from: Z */
    public String m919Z() {
        return this.f679U;
    }

    /* renamed from: a0 */
    public boolean m920a0() {
        return this.f678T;
    }

    /* renamed from: b0 */
    public boolean m921b0() {
        return this.f676R;
    }

    /* renamed from: c0 */
    public boolean m922c0() {
        return this.f677S;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0067, code lost:
    
        if (r3.f679U.equals(r4.m919Z()) != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0048, code lost:
    
        if (r1.equals(r4.m925p()) != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch: java.lang.ClassCastException -> L8f
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r3.f681W     // Catch: java.lang.ClassCastException -> L8f
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 > 0) goto L8f
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r4.f681W     // Catch: java.lang.ClassCastException -> L8f
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 <= 0) goto L18
            goto L8f
        L18:
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.f674P     // Catch: java.lang.ClassCastException -> L8f
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L8f
            java.util.ArrayList r2 = r4.m918Y()     // Catch: java.lang.ClassCastException -> L8f
            int r2 = r2.size()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != r2) goto L8f
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.f674P     // Catch: java.lang.ClassCastException -> L8f
            java.util.ArrayList r2 = r4.m918Y()     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = r1.containsAll(r2)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != 0) goto L35
            goto L8f
        L35:
            android.accounts.Account r1 = r3.f675Q     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != 0) goto L40
            android.accounts.Account r1 = r4.m925p()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != 0) goto L8f
            goto L4a
        L40:
            android.accounts.Account r2 = r4.m925p()     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 == 0) goto L8f
        L4a:
            java.lang.String r1 = r3.f679U     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 == 0) goto L5d
            java.lang.String r1 = r4.m919Z()     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 == 0) goto L8f
            goto L69
        L5d:
            java.lang.String r1 = r3.f679U     // Catch: java.lang.ClassCastException -> L8f
            java.lang.String r2 = r4.m919Z()     // Catch: java.lang.ClassCastException -> L8f
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L8f
            if (r1 == 0) goto L8f
        L69:
            boolean r1 = r3.f678T     // Catch: java.lang.ClassCastException -> L8f
            boolean r2 = r4.m920a0()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != r2) goto L8f
            boolean r1 = r3.f676R     // Catch: java.lang.ClassCastException -> L8f
            boolean r2 = r4.m921b0()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != r2) goto L8f
            boolean r1 = r3.f677S     // Catch: java.lang.ClassCastException -> L8f
            boolean r2 = r4.m922c0()     // Catch: java.lang.ClassCastException -> L8f
            if (r1 != r2) goto L8f
            java.lang.String r1 = r3.f682X     // Catch: java.lang.ClassCastException -> L8f
            java.lang.String r4 = r4.m917K()     // Catch: java.lang.ClassCastException -> L8f
            boolean r4 = android.text.TextUtils.equals(r1, r4)     // Catch: java.lang.ClassCastException -> L8f
            if (r4 == 0) goto L8f
            r4 = 1
            return r4
        L8f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.f674P;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Scope scope = arrayList2.get(i);
            i++;
            arrayList.add(scope.m993x());
        }
        Collections.sort(arrayList);
        C1538m5 c1538m5 = new C1538m5();
        c1538m5.m6369a(arrayList);
        c1538m5.m6369a(this.f675Q);
        c1538m5.m6369a(this.f679U);
        c1538m5.m6371c(this.f678T);
        c1538m5.m6371c(this.f676R);
        c1538m5.m6371c(this.f677S);
        c1538m5.m6369a(this.f682X);
        return c1538m5.m6370b();
    }

    /* renamed from: j0 */
    public final JSONObject m923j0() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f674P, f672f0);
            ArrayList<Scope> arrayList = this.f674P;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Scope scope = arrayList.get(i);
                i++;
                jSONArray.put(scope.m993x());
            }
            jSONObject.put("scopes", jSONArray);
            Account account = this.f675Q;
            if (account != null) {
                jSONObject.put("accountName", account.name);
            }
            jSONObject.put("idTokenRequested", this.f676R);
            jSONObject.put("forceCodeForRefreshToken", this.f678T);
            jSONObject.put("serverAuthRequested", this.f677S);
            if (!TextUtils.isEmpty(this.f679U)) {
                jSONObject.put("serverClientId", this.f679U);
            }
            if (!TextUtils.isEmpty(this.f680V)) {
                jSONObject.put("hostedDomain", this.f680V);
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: l0 */
    public final String m924l0() {
        return m923j0().toString();
    }

    /* renamed from: p */
    public Account m925p() {
        return this.f675Q;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m4396a = C1099ha.m4396a(parcel);
        C1099ha.m4406k(parcel, 1, this.f673O);
        C1099ha.m4416u(parcel, 2, m918Y(), false);
        C1099ha.m4411p(parcel, 3, m925p(), i, false);
        C1099ha.m4398c(parcel, 4, m921b0());
        C1099ha.m4398c(parcel, 5, m922c0());
        C1099ha.m4398c(parcel, 6, m920a0());
        C1099ha.m4412q(parcel, 7, m919Z(), false);
        C1099ha.m4412q(parcel, 8, this.f680V, false);
        C1099ha.m4416u(parcel, 9, m926x(), false);
        C1099ha.m4412q(parcel, 10, m917K(), false);
        C1099ha.m4397b(parcel, m4396a);
    }

    /* renamed from: x */
    public ArrayList<GoogleSignInOptionsExtensionParcelable> m926x() {
        return this.f681W;
    }
}
