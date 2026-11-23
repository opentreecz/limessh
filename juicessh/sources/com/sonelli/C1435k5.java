package com.sonelli;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.dynamite.DynamiteModule;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: com.sonelli.k5 */
/* loaded from: classes.dex */
public class C1435k5 extends C1199j7<GoogleSignInOptions> {

    /* renamed from: j */
    public static final a f4481j = new a(null);

    /* renamed from: k */
    public static int f4482k = b.f4483a;

    /* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
    /* renamed from: com.sonelli.k5$a */
    /* loaded from: classes.dex */
    public static class a implements PendingResultUtil.ResultConverter<C1490l5, GoogleSignInAccount> {
        public a() {
        }

        public /* synthetic */ a(C1539m6 c1539m6) {
            this();
        }

        @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
        @Nullable
        /* renamed from: a */
        public final /* synthetic */ GoogleSignInAccount mo1125a(C1490l5 c1490l5) {
            return c1490l5.m6068a();
        }
    }

    /* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
    /* renamed from: com.sonelli.k5$b */
    /* loaded from: classes.dex */
    public enum b {

        /* renamed from: a */
        public static final int f4483a = 1;

        /* renamed from: b */
        public static final int f4484b = 2;

        /* renamed from: c */
        public static final int f4485c = 3;

        /* renamed from: d */
        public static final int f4486d = 4;

        /* renamed from: e */
        public static final /* synthetic */ int[] f4487e = {1, 2, 3, 4};

        /* renamed from: a */
        public static int[] m5840a() {
            return (int[]) f4487e.clone();
        }
    }

    public C1435k5(@NonNull Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, C1632o4.f5420e, googleSignInOptions, new C1692p7());
    }

    @NonNull
    /* renamed from: m */
    public Intent m5835m() {
        Context m5075g = m5075g();
        int i = C1539m6.f4991a[m5839q() - 1];
        return i != 1 ? i != 2 ? C1846s5.m8330h(m5075g, m5074f()) : C1846s5.m8324b(m5075g, m5074f()) : C1846s5.m8328f(m5075g, m5074f());
    }

    /* renamed from: n */
    public j60<Void> m5836n() {
        return PendingResultUtil.m1124b(C1846s5.m8329g(m5069a(), m5075g(), m5839q() == b.f4485c));
    }

    /* renamed from: o */
    public j60<Void> m5837o() {
        return PendingResultUtil.m1124b(C1846s5.m8326d(m5069a(), m5075g(), m5839q() == b.f4485c));
    }

    /* renamed from: p */
    public j60<GoogleSignInAccount> m5838p() {
        return PendingResultUtil.m1123a(C1846s5.m8325c(m5069a(), m5075g(), m5074f(), m5839q() == b.f4485c), f4481j);
    }

    /* renamed from: q */
    public final synchronized int m5839q() {
        if (f4482k == b.f4483a) {
            Context m5075g = m5075g();
            C2260x6 m9706m = C2260x6.m9706m();
            int mo9713h = m9706m.mo9713h(m5075g, C0810c7.f1875a);
            if (mo9713h == 0) {
                f4482k = b.f4486d;
            } else if (m9706m.mo9709b(m5075g, mo9713h, null) != null || DynamiteModule.m1182a(m5075g, "com.google.android.gms.auth.api.fallback") == 0) {
                f4482k = b.f4484b;
            } else {
                f4482k = b.f4485c;
            }
        }
        return f4482k;
    }
}
