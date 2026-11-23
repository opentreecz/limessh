package com.sonelli;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: com.sonelli.s5 */
/* loaded from: classes.dex */
public final class C1846s5 {

    /* renamed from: a */
    public static C1154ib f6353a = new C1154ib("GoogleSignInCommon", new String[0]);

    @Nullable
    /* renamed from: a */
    public static C1490l5 m8323a(@Nullable Intent intent) {
        if (intent == null) {
            return new C1490l5(null, Status.f729U);
        }
        Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
        if (googleSignInAccount != null) {
            return new C1490l5(googleSignInAccount, Status.f727S);
        }
        if (status == null) {
            status = Status.f729U;
        }
        return new C1490l5(null, status);
    }

    /* renamed from: b */
    public static Intent m8324b(Context context, GoogleSignInOptions googleSignInOptions) {
        f6353a.m4739a("getSignInIntent()", new Object[0]);
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("config", signInConfiguration);
        intent.putExtra("config", bundle);
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0098  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.sonelli.AbstractC1437k7<com.sonelli.C1490l5> m8325c(com.google.android.gms.common.api.GoogleApiClient r5, android.content.Context r6, com.google.android.gms.auth.api.signin.GoogleSignInOptions r7, boolean r8) {
        /*
            com.sonelli.ib r0 = com.sonelli.C1846s5.f6353a
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "silentSignIn()"
            r0.m4739a(r3, r2)
            com.sonelli.ib r0 = com.sonelli.C1846s5.f6353a
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "getEligibleSavedSignInResult()"
            r0.m4739a(r3, r2)
            com.sonelli.C0813ca.m2729k(r7)
            com.sonelli.a6 r0 = com.sonelli.C0696a6.m1982c(r6)
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r0 = r0.m1987f()
            r2 = 0
            if (r0 == 0) goto L87
            android.accounts.Account r3 = r0.m925p()
            android.accounts.Account r4 = r7.m925p()
            if (r3 != 0) goto L31
            if (r4 != 0) goto L2f
            r3 = 1
            goto L35
        L2f:
            r3 = r1
            goto L35
        L31:
            boolean r3 = r3.equals(r4)
        L35:
            if (r3 == 0) goto L87
            boolean r3 = r7.m922c0()
            if (r3 != 0) goto L87
            boolean r3 = r7.m921b0()
            if (r3 == 0) goto L57
            boolean r3 = r0.m921b0()
            if (r3 == 0) goto L87
            java.lang.String r3 = r7.m919Z()
            java.lang.String r4 = r0.m919Z()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L87
        L57:
            java.util.HashSet r3 = new java.util.HashSet
            java.util.ArrayList r0 = r0.m918Y()
            r3.<init>(r0)
            java.util.HashSet r0 = new java.util.HashSet
            java.util.ArrayList r4 = r7.m918Y()
            r0.<init>(r4)
            boolean r0 = r3.containsAll(r0)
            if (r0 == 0) goto L87
            com.sonelli.a6 r0 = com.sonelli.C0696a6.m1982c(r6)
            com.google.android.gms.auth.api.signin.GoogleSignInAccount r0 = r0.m1986e()
            if (r0 == 0) goto L87
            boolean r3 = r0.m899f0()
            if (r3 != 0) goto L87
            com.sonelli.l5 r3 = new com.sonelli.l5
            com.google.android.gms.common.api.Status r4 = com.google.android.gms.common.api.Status.f727S
            r3.<init>(r0, r4)
            goto L88
        L87:
            r3 = r2
        L88:
            if (r3 == 0) goto L98
            com.sonelli.ib r6 = com.sonelli.C1846s5.f6353a
            java.lang.Object[] r7 = new java.lang.Object[r1]
            java.lang.String r8 = "Eligible saved sign in result found"
            r6.m4739a(r8, r7)
            com.sonelli.k7 r5 = com.sonelli.C1493l7.m6089b(r3, r5)
            return r5
        L98:
            if (r8 == 0) goto Laa
            com.sonelli.l5 r6 = new com.sonelli.l5
            com.google.android.gms.common.api.Status r7 = new com.google.android.gms.common.api.Status
            r8 = 4
            r7.<init>(r8)
            r6.<init>(r2, r7)
            com.sonelli.k7 r5 = com.sonelli.C1493l7.m6089b(r6, r5)
            return r5
        Laa:
            com.sonelli.ib r8 = com.sonelli.C1846s5.f6353a
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.String r1 = "trySilentSignIn()"
            r8.m4739a(r1, r0)
            com.sonelli.v5 r8 = new com.sonelli.v5
            r8.<init>(r5, r6, r7)
            com.sonelli.r7 r5 = r5.mo983a(r8)
            com.sonelli.w7 r6 = new com.sonelli.w7
            r6.<init>(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.C1846s5.m8325c(com.google.android.gms.common.api.GoogleApiClient, android.content.Context, com.google.android.gms.auth.api.signin.GoogleSignInOptions, boolean):com.sonelli.k7");
    }

    /* renamed from: d */
    public static PendingResult<Status> m8326d(GoogleApiClient googleApiClient, Context context, boolean z) {
        f6353a.m4739a("Signing out", new Object[0]);
        m8327e(context);
        return z ? C1493l7.m6090c(Status.f727S, googleApiClient) : googleApiClient.mo984b(new C2258x5(googleApiClient));
    }

    /* renamed from: e */
    public static void m8327e(Context context) {
        C0696a6.m1982c(context).m1984a();
        Iterator<GoogleApiClient> it = GoogleApiClient.m982c().iterator();
        if (it.hasNext()) {
            it.next().m987f();
            throw null;
        }
        C1848s7.m8337a();
    }

    /* renamed from: f */
    public static Intent m8328f(Context context, GoogleSignInOptions googleSignInOptions) {
        f6353a.m4739a("getFallbackSignInIntent()", new Object[0]);
        Intent m8324b = m8324b(context, googleSignInOptions);
        m8324b.setAction("com.google.android.gms.auth.APPAUTH_SIGN_IN");
        return m8324b;
    }

    /* renamed from: g */
    public static PendingResult<Status> m8329g(GoogleApiClient googleApiClient, Context context, boolean z) {
        f6353a.m4739a("Revoking access", new Object[0]);
        String m6644e = C1588n5.m6639b(context).m6644e();
        m8327e(context);
        return z ? RunnableC1690p5.m7245a(m6644e) : googleApiClient.mo984b(new C2412z5(googleApiClient));
    }

    /* renamed from: h */
    public static Intent m8330h(Context context, GoogleSignInOptions googleSignInOptions) {
        f6353a.m4739a("getNoImplementationSignInIntent()", new Object[0]);
        Intent m8324b = m8324b(context, googleSignInOptions);
        m8324b.setAction("com.google.android.gms.auth.NO_IMPL");
        return m8324b;
    }
}
